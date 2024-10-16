<template>
    <v-card outlined>
        <v-card-title>
            RegisterCodingGuide
        </v-card-title>

        <v-card-text>
            <String label="GuideId" v-model="value.guideId" :editMode="editMode"/>
            <String label="GuideName" v-model="value.guideName" :editMode="editMode"/>
            <String label="GuideContent" v-model="value.guideContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerCodingGuide"
            >
                RegisterCodingGuide
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
        name: 'RegisterCodingGuideCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.guideId = '';
            this.value.guideName = '';
            this.value.guideContent = '';
        },
        watch: {
        },
        methods: {
            registerCodingGuide() {
                this.$emit('registerCodingGuide', this.value);
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

