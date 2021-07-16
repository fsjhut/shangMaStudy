import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import  qs from 'qs'
import  axios from 'axios'


axios.defaults.baseURL = "http://127.0.0.1:8080/"
axios.defaults.withCredentials = true

Vue.config.productionTip = false
Vue.prototype.$qs = qs
Vue.prototype.$axios = axios

//服务器路径
// axios.defaults.baseURL="http://localhost:8080/"
//跨域带cookie
// axios.defaults.withCredentials = true
//设置请求拦截
axios.interceptors.request.use(
	function(config){
		let headers = config.headers;
		let token = localStorage.getItem("token");
		if(token!=null&&token!=undefined){
			headers['token'] = token;
		}
		return config;
	},
	function(error){
		return  Promise.reject(error);
	}
);

//响应拦截器 统一处理响应数据
axios.interceptors.response.use(function (resp) {
	let returnCode = resp.data.code;
	console.log(resp)
	if(returnCode==50002){
		router.push("/login");
	}
	if(returnCode==10000){
		let head = resp.headers;
		console.log(head['token']);
		localStorage.setItem("token",head['token']);
	}	
	return resp.data;
}, function (error) {
    return Promise.reject(error);
});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
