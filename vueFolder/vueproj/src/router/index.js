import Vue from 'vue'
import VueRouter from 'vue-router'
import NewPage from '../components/newpage.vue'
import TestPage from '../components/testpage.vue'
import LoginPage from '../components/login.vue'
import MainPage from '../components/main.vue'
Vue.use(VueRouter)

const routes = [
  {
	path: '/newpage',
	component: NewPage
  },
  {
  	path: '/testpage',
  	component: TestPage
  },
  {
  	path: '/login',
  	component: LoginPage
  },
  {
	path: '/main',
	component:MainPage
  }
]

const router = new VueRouter({
  routes
})

export default router
