<template>
    <v-card outlined>
        <v-card-title>
            RegisterProject
        </v-card-title>

        <v-card-text>
            <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
            <String label="ProjectName" v-model="value.projectName" :editMode="editMode"/>
            <String label="ProjectDescription" v-model="value.projectDescription" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerProject"
            >
                RegisterProject
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RegisterProjectCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.projectId = '';
            this.value.projectName = '';
            this.value.projectDescription = '';
        },
        watch: {
        },
        methods: {
            registerProject() {
                this.$emit('registerProject', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

