
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import WindowWindowManager from "./components/listers/WindowWindowCards"
import WindowWindowDetail from "./components/listers/WindowWindowDetail"

import WorkWorkManager from "./components/listers/WorkWorkCards"
import WorkWorkDetail from "./components/listers/WorkWorkDetail"

import EmailEmailManager from "./components/listers/EmailEmailCards"
import EmailEmailDetail from "./components/listers/EmailEmailDetail"


import MyPageView from "./components/MyPageView"
import MyPageViewDetail from "./components/MyPageViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/windows/windows',
                name: 'WindowWindowManager',
                component: WindowWindowManager
            },
            {
                path: '/windows/windows/:id',
                name: 'WindowWindowDetail',
                component: WindowWindowDetail
            },

            {
                path: '/works/works',
                name: 'WorkWorkManager',
                component: WorkWorkManager
            },
            {
                path: '/works/works/:id',
                name: 'WorkWorkDetail',
                component: WorkWorkDetail
            },

            {
                path: '/emails/emails',
                name: 'EmailEmailManager',
                component: EmailEmailManager
            },
            {
                path: '/emails/emails/:id',
                name: 'EmailEmailDetail',
                component: EmailEmailDetail
            },


            {
                path: '/customers/myPages',
                name: 'MyPageView',
                component: MyPageView
            },
            {
                path: '/customers/myPages/:id',
                name: 'MyPageViewDetail',
                component: MyPageViewDetail
            },


    ]
})
