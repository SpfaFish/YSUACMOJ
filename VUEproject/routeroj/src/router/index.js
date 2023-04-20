import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component:()=>import('../views/login.vue'),
  },
  {
    path: '/signup',
    name: 'signup',
    component:()=>import('../views/Signup.vue'),
  },
  {
    path: '/mainuser',
    name: 'mainuser',
    component:()=>import('../views/MainUserPage.vue'),
  },
  {
    path: '/GYM',
    name: 'GYM',
    component:()=>import('../views/GYM.vue'),
  },
  {
    path: '/GYMrg',
    name: 'GYMrg',
    component:()=>import('../views/GYMregist.vue'),
  },
  {
    path: '/useriden',
    name: 'useriden',
    component:()=>import('../views/Useriden.vue'),
  },
  {
    path: '/problempage',
    name: 'problempage',
    component:()=>import('../views/ProblemPage.vue'),
  },
  {
    path: '/gamepage',
    name: 'gamepage',
    component:()=>import('../views/GamePage.vue'),
  },
  {
    path: '/file',
    name: 'file',
    component:()=>import('../views/FileUpload.vue'),
  }

]

const router = new VueRouter({
  routes
})

export default router
