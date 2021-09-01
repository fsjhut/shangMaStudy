import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import store from './store'
import qs from 'qs';
import axios from 'axios';


Vue.config.productionTip = false

// 配置一个默认的baseurl localhost和127.0.0.1是不一样的，一个过路由，一个不过路由
axios.defaults.baseURL="http://localhost:8080/"
// 跨域请求需要携带cookie
axios.defaults.withCredentials = true;
//响应拦截器 统一处理响应数据(公共的代码)
axios.interceptors.response.use(function (resp) {
	if(resp.data.returnCode==20000){
         //如果服务器响应码是20000的话 通过路由跳转到登录组件
		console.log("拦截器输出： 没有登录")
		router.push("/login");
	}
    return resp;
}, function (error) {
    return Promise.reject(error);
});

// 将qs和axios扩展到vue对象中，每次使用不用再导入
Vue.prototype.$axios = axios
Vue.prototype.$qs = qs

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
