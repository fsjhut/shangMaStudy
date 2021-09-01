import Vue from 'vue'
import VueRouter from 'vue-router'
import NewPage from '../components/newpage.vue'
import TestPage from '../components/testpage.vue'
import LoginPage from '../components/login.vue'
import MainPage from '../components/main.vue'
import Menus from '../components/mangeCenter/menus.vue'
import Users from '../components/mangeCenter/users.vue'
Vue.use(VueRouter)
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

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
	component:MainPage,
	children:[
		{
			path: '/menus',
			component:Menus
		},
		{
			path: '/users',
			component:Users
		}
	]
  }
]
// const originalPush = Router.prototype.push
// Router.prototype.push = function push (location) {
//    return originalPush.call(this, location).catch(err => err)
// }
const router = new VueRouter({
  routes
})

export default router
