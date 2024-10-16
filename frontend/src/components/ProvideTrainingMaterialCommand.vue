<template>
    <v-card outlined>
        <v-card-title>
            ProvideTrainingMaterial
        </v-card-title>

        <v-card-text>
            <String label="CourseId" v-model="value.courseId" :editMode="editMode"/>
            <String label="MaterialId" v-model="value.materialId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideTrainingMaterial"
            >
                ProvideTrainingMaterial
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
        name: 'ProvideTrainingMaterialCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.courseId = '';
            this.value.materialId = '';
        },
        watch: {
        },
        methods: {
            provideTrainingMaterial() {
                this.$emit('provideTrainingMaterial', this.value);
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

