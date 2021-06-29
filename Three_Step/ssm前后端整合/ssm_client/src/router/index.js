import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Main from '../views/main.vue'
import Depts from '../views/sys/depts.vue'
import Users from '../views/sys/users.vue'

Vue.use(VueRouter)

const routes = [
  {path: '/',redirect:'/login'},
  {path: '/login',component: Login},
  {path: '/main',component: Main,children:[
		{path: '/depts',component: Depts},
		{path: '/users',component: Users}
	]},
]

const router = new VueRouter({
  routes
})

export default router
