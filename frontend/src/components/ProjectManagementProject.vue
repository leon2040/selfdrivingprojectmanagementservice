<template>
    <v-card style="width:450px; height:100%;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            프로젝트 # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            프로젝트
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <String v-if="editMode" label="프로젝트 ID" v-model="value.projectId" :editMode="editMode" :inputUI="''"/>
            <String label="프로젝트 이름" v-model="value.projectName" :editMode="editMode" :inputUI="''"/>
            <String label="프로젝트 설명" v-model="value.projectDescription" :editMode="editMode" :inputUI="''"/>
            <String label="프로젝트 상태" v-model="value.projectStatus" :editMode="editMode" :inputUI="''"/>
            <projectStatusType offline label="프로젝트 상태 유형" v-model="value.projectStatusType" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions style="background-color: white;">
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="edit"
                v-if="!editMode"
            >
                수정
            </v-btn>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 등록
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 진행 모니터링
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    시스템 성능 점검
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    피드백 제공
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
                >
                    삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn  
                :disabled="!userRoles.includes('Admin')"
                v-if="!editMode"
                color="primary"
                text
                @click="openUpdateProject"
            >
                UpdateProject
            </v-btn>
            <v-dialog v-model="updateProjectDiagram" width="500">
                <UpdateProjectCommand
                    @closeDialog="closeUpdateProject"
                    @updateProject="updateProject"
                ></UpdateProjectCommand>
            </v-dialog>
            <v-btn  
                :disabled="!userRoles.includes('Admin')"
                v-if="!editMode"
                color="primary"
                text
                @click="openAssignTeamMember"
            >
                AssignTeamMember
            </v-btn>
            <v-dialog v-model="assignTeamMemberDiagram" width="500">
                <AssignTeamMemberCommand
                    @closeDialog="closeAssignTeamMember"
                    @assignTeamMember="assignTeamMember"
                ></AssignTeamMemberCommand>
            </v-dialog>
            <v-btn  
                :disabled="!userRoles.includes('Admin')"
                v-if="!editMode"
                color="primary"
                text
                @click="openAssignTask"
            >
                AssignTask
            </v-btn>
            <v-dialog v-model="assignTaskDiagram" width="500">
                <AssignTaskCommand
                    @closeDialog="closeAssignTask"
                    @assignTask="assignTask"
                ></AssignTaskCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'ProjectManagementProject',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
                userRole: ''
            },
            updateProjectDiagram: false,
            assignTeamMemberDiagram: false,
            assignTaskDiagram: false,
        }),
	async created() {
            var me = this

            me.userRole = me.$OAuth.tokenParsed.realm_access.roles;
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/projects'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async updateProject(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links[''].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateProject();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateProject() {
                this.updateProjectDiagram = true;
            },
            closeUpdateProject() {
                this.updateProjectDiagram = false;
            },
            async assignTeamMember(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links[''].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeAssignTeamMember();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openAssignTeamMember() {
                this.assignTeamMemberDiagram = true;
            },
            closeAssignTeamMember() {
                this.assignTeamMemberDiagram = false;
            },
            async assignTask(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links[''].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeAssignTask();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openAssignTask() {
                this.assignTaskDiagram = true;
            },
            closeAssignTask() {
                this.assignTaskDiagram = false;
            },
        },
    }
</script>

