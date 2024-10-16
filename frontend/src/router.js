
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProjectManagementProjectManager from "./components/listers/ProjectManagementProjectCards"
import ProjectManagementProjectDetail from "./components/listers/ProjectManagementProjectDetail"

import CodingGuideCodingGuideManager from "./components/listers/CodingGuideCodingGuideCards"
import CodingGuideCodingGuideDetail from "./components/listers/CodingGuideCodingGuideDetail"

import EducationSupportEducationCourseManager from "./components/listers/EducationSupportEducationCourseCards"
import EducationSupportEducationCourseDetail from "./components/listers/EducationSupportEducationCourseDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/projectManagements/projects',
                name: 'ProjectManagementProjectManager',
                component: ProjectManagementProjectManager
            },
            {
                path: '/projectManagements/projects/:id',
                name: 'ProjectManagementProjectDetail',
                component: ProjectManagementProjectDetail
            },

            {
                path: '/codingGuides/codingGuides',
                name: 'CodingGuideCodingGuideManager',
                component: CodingGuideCodingGuideManager
            },
            {
                path: '/codingGuides/codingGuides/:id',
                name: 'CodingGuideCodingGuideDetail',
                component: CodingGuideCodingGuideDetail
            },

            {
                path: '/educationSupports/educationCourses',
                name: 'EducationSupportEducationCourseManager',
                component: EducationSupportEducationCourseManager
            },
            {
                path: '/educationSupports/educationCourses/:id',
                name: 'EducationSupportEducationCourseDetail',
                component: EducationSupportEducationCourseDetail
            },



    ]
})
