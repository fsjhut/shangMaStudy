import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import {getdicts,parseDicts} from '@/utils/dicts.js'

Vue.config.productionTip = false

Vue.prototype.getdicts=getdicts
Vue.prototype.parseDicts=parseDicts

Vue.prototype.suc=function(msg){
	this.$message({message: msg,type: 'success'});
}

Vue.prototype.error=function(msg){
	this.$message.error(msg);
}

Vue.prototype.resetForm=function(formName){
	this.$refs[formName].resetFields();
}

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')