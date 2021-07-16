import Vue from 'vue'
import VueRouter from 'vue-router'


import Login from '../components/login.vue'
import Main from '../components/main.vue'
import Manager from '../components/mange/manger.vue'
import Review from '../components/promanger/review.vue'
import ProInfo from '../components/promanger/proInfo.vue'
import ComInfo from '../components/commanger/cominfo.vue'

import Rwinfo from '../components/commanger/rwinfo.vue'
import Menus from '../components/mange/menus.vue'
import Property from '../components/commanger/property.vue'
import Recimmend from '../components/promanger/recommend.vue'
import Series from '../components/promanger/series.vue'
import First from '../components/first.vue'


Vue.use(VueRouter)

const routes = [

	  {path: '/',redirect: '/main'},
	  {path: '/login',component: Login},
	 
	 
	   //子路由
	  {path: '/main',component: Main,
	  redirect:'/first',
	  children:[
		 {path: '/first',component: First},
		{path: '/manager',component: Manager},
	    {path: '/proInfo',component: ProInfo},
		{path: '/review',component: Review},
		{path: '/cominfo',component: ComInfo},
		{path: '/menus',component: Menus},
		
		{path: '/rwinfo',component: Rwinfo},
		
		{path: '/property',component: Property},
		{path: '/recommend',component: Recimmend},
		{path: '/series',component: Series}
		
		]},
			
	
		
]

const router = new VueRouter({
  routes
})

export default router
