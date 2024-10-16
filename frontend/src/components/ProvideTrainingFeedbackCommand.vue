<template>
    <v-card outlined>
        <v-card-title>
            ProvideTrainingFeedback
        </v-card-title>

        <v-card-text>
            <String label="CourseId" v-model="value.courseId" :editMode="editMode"/>
            <String label="Feedback" v-model="value.feedback" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideTrainingFeedback"
            >
                ProvideTrainingFeedback
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
        name: 'ProvideTrainingFeedbackCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.courseId = '';
            this.value.feedback = '';
        },
        watch: {
        },
        methods: {
            provideTrainingFeedback() {
                this.$emit('provideTrainingFeedback', this.value);
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

