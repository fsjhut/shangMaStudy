import Vue from 'vue'
import VueRouter from 'vue-router' 
import Home from '../views/Home.vue'
import GoodPriceAdjust from '../components/GoodPriceAdjust.vue' 
import Login from '../components/login.vue'
import MyPafe from '../components/mypage.vue'
import sysuser from '../components/children/Sysuser.vue' 
import MaintainManager from '../components/children/maintainManager.vue' 
import sysrole from '../components/children/SysuserRole.vue'
import syspermission from '../components/children/SysPermission.vue'
import Gift from '../components/children/gift.vue'
import Goods from '../components/children/goodsManager.vue' 
import GiftGoods from '../components/children/grandson/giftgoods.vue'
import Goods2 from '../components/children/grandson/goodsMang2.vue'
import BrandsManager from '../components/children/grandson/brandsManager.vue'
import returnFactory from '../components/children/service/returnFactory.vue'
import promoteSale from '../components/children/promoteSale.vue'
import promoteVerify from '../components/children/promoteVerify.vue'
import B2Corder from '../components/children/B2Corder.vue'
import godown from '../components/children/goDownMgr.vue'
import goodType from '../components/children/goodType.vue'
import supplerManager from '../components/children/supplerManager.vue'
import b2cReturnAndChange from '../components/children/b2cReturnAndChange.vue'
import giftAduit from '../components/children/giftManagement/commodityTransferGift.vue'
import strutsAdd from '../components/system/strutsAdd.vue'
import strutsEdit from '../components/system/strutsEdit.vue'
import logForJ from '../components/system/logForJ.vue'
import commodityTransferManagerment from '../components/children/giftManagement/commodityTransferManagerment.vue'
import commodityTransferReview from '../components/children/giftManagement/commodityTransferReview.vue'
import Out from '../components/inoutmanager/outmanager.vue'
import Audit from '../components/inoutmanager/outaudit.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/login',
		component: Login
	},
	{
		path: '/mypage',
		component: MyPafe,
		children: [{
				path: '/goodPriceAdjust',
				component: GoodPriceAdjust
			},
			{
				path: '/maintainManager',
				component: MaintainManager
			},


			{
				path: '/sysuser',
				component: sysuser
			}
		]
	},
	{
		path: '/login',
		component: Login
	},
	{
		path: '/mypage',
		component: MyPafe,
		children: [{
			path: '/sysuser',
			component: sysuser
		}]
	},

	{
		path: '/login',
		component: Login
	},
	{
		path: '/mypage',
		component: MyPafe,
		children: [{
				path: '/sysuser',
				component: sysuser
			},
			{
				path: '/sysrole',
				component: sysrole
			},
			{
				path: '/syspermission',
				component: syspermission
			},
			{
				path: '/returnFactory',
				component: returnFactory
			},
			{
				path: '/gift',
				component: Gift
			},
			{
				path: '/gift/giftgoods',
				component: GiftGoods
			},
			{
				path: '/gift/audit',
				component: giftAduit
			},
			{
				path: '/goodsManager',
				component: Goods
			},
			{
				path: '/goodsManager/goodsMang2',
				component: Goods2
			},


			{
				path: '/goodsManager/brandsManager',
				component: BrandsManager
			},

			{
				path: '/outmanager',
				component: Out
			},
			{
				path: '/outaudit',
				component: Audit
			},


			{
				path: '/promotesale',
				component: promoteSale
			},
			{
				path: '/promoteverfiy',
				component: promoteVerify
			},

			{
				path: '/promotesale',
				component: promoteSale
			},
			{
				path: '/promoteverfiy',
				component: promoteVerify
			},
			{
				path: '/godown',
				component: godown
			},
			{
				path: '/goodType',
				component: goodType
			},
			{
				path: '/supplerManager',
				component: supplerManager
			},
			{
				path: '/b2cReturnAndChange',
				component: b2cReturnAndChange
			},
			// {path:'/promotesale',component:promoteSale},
			// {path:'/promoteverfiy',component:promoteVerify}
			{
				path: '/B2Corder',
				component: B2Corder
			},
			{
				path: '/systemManager/strutsManager/strutsAdd',
				component: strutsAdd
			},
			{
				path: '/systemManager/strutsManager/strutsEdit',
				component: strutsEdit
			},
			{
				path: '/systemManager/logForJ',
				component: logForJ
			},
			//商品转赠品
			{
				path: '/gift/commodityTransferManagerment',
				component: commodityTransferManagerment
			},
			{
				path: '/gift/commodityTransferReview',
				component: commodityTransferReview
			},

		]
	},
]

const router = new VueRouter({
	routes
})

export default router
