<template>
    <v-card outlined>
        <v-card-title>
            ProvideCodeExamples
        </v-card-title>

        <v-card-text>
            <String label="CourseId" v-model="value.courseId" :editMode="editMode"/>
            <String label="ExampleId" v-model="value.exampleId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideCodeExamples"
            >
                ProvideCodeExamples
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
        name: 'ProvideCodeExamplesCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.courseId = '';
            this.value.exampleId = '';
        },
        watch: {
        },
        methods: {
            provideCodeExamples() {
                this.$emit('provideCodeExamples', this.value);
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

