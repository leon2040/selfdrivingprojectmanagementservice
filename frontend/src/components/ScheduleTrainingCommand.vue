<template>
    <v-card outlined>
        <v-card-title>
            ScheduleTraining
        </v-card-title>

        <v-card-text>
            <String label="CourseId" v-model="value.courseId" :editMode="editMode"/>
            <Date label="TrainingDate" v-model="value.trainingDate" :editMode="editMode"/>
            <String label="TrainingLocation" v-model="value.trainingLocation" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="scheduleTraining"
            >
                ScheduleTraining
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
        name: 'ScheduleTrainingCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.courseId = '';
            this.value.trainingDate = '2024-10-16';
            this.value.trainingLocation = '';
        },
        watch: {
        },
        methods: {
            scheduleTraining() {
                this.$emit('scheduleTraining', this.value);
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

