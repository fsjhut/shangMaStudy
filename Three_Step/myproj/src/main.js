import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'







import moment from 'moment';
import axios from 'axios'
import qs from 'qs'
import * as echarts from 'echarts'

  Vue.config.productionTip = false
 
Vue.prototype.$axios = axios
Vue.prototype.$qs = qs
Vue.prototype.$moment = moment
Vue.prototype.$echarts = echarts

// // 定义全局时间戳过滤器
// Vue.filter('formatDate', function(value) {
//   return Moment(value).format('YYYY-MM-DD')
// })
//服务器路径
  axios.defaults.baseURL="http://localhost:8080/"
//跨域带cookie
axios.defaults.withCredentials = true
//响应拦截器 统一处理响应数据 
  axios.interceptors.response.use(function (resp) {
	if(resp.data.returnCode==50000){
         //如果服务器响应码是50000的话 通过路由跳转到登录组件
		console.log("拦截器输出： 没有登录")
		router.push("/login");
	}
    return resp;
}, function (error) {
    return Promise.reject(error);
});


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
