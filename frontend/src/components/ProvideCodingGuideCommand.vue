<template>
    <v-card outlined>
        <v-card-title>
            ProvideCodingGuide
        </v-card-title>

        <v-card-text>
            <String label="GuideId" v-model="value.guideId" :editMode="editMode"/>
            <String label="GuideContent" v-model="value.guideContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideCodingGuide"
            >
                ProvideCodingGuide
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
        name: 'ProvideCodingGuideCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.guideId = '';
            this.value.guideContent = '';
        },
        watch: {
        },
        methods: {
            provideCodingGuide() {
                this.$emit('provideCodingGuide', this.value);
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

