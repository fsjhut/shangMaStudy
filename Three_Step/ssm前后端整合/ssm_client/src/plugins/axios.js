"use strict";

import Vue from 'vue';
import axios from "axios";
import router from '@/router'

let config = {
  baseURL: "http://localhost:8080",
  withCredentials: true
};

//创建axios实例对象
const _axios = axios.create(config);

//axios请求前拦截
_axios.interceptors.request.use(
  function(config) {
    return config;
  },
  function(error) {
    return Promise.reject(error);
  }
);

//axios请求后拦截
_axios.interceptors.response.use(
  function(response) {
	  // debugger;
	  let data = response.data;
	  let code=data.code;
	  if(code==50002){
		  router.push("/login")
	  }
    return data;
  },
  function(error) {
    return Promise.reject(error);
  }
);

//把创建的axios实例作为插件挂载到vue实例
Plugin.install = function(Vue, options) {
  Vue.axios = _axios;
  window.axios = _axios;
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios;
      }
    },
    $axios: {
      get() {
        return _axios;
      }
    },
  });
};

//安装插件
Vue.use(Plugin)

export default Plugin;
