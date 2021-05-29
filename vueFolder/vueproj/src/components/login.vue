<template>
	<el-card class="box-card loginPanel">
	  <div slot="header" class="clearfix">
	    <span>登录</span>
	  </div>
	  
	  <el-form :rules="rules" ref="loginform" :model="loginform" hide-required-asterisk label-width="80px">
	    <el-form-item label="用户名" prop="uname">
	      <el-input  v-model="loginform.uname"suffix-icon="el-icon-user-solid" ></el-input>
	    </el-form-item>
		<el-form-item label="密码" prop="upwd">
	      <el-input v-model="loginform.upwd" suffix-icon="el-icon-lock"  show-password></el-input>
	    </el-form-item>
		
	    <el-form-item>
	      <el-button type="primary" @click="onSubmit('loginform')">登录</el-button>
	      <el-button @click="myreset">重置</el-button>
	    </el-form-item>
	  </el-form>
	</el-card>
</template>

<script>
	/* 
		1.在vue脚手架中，单页面应用
		.vue  vue组件
		import 导入的组件
		export 导出的组件
		/项目/public/index.html 唯一的html文件
		main.js  核心配置文件(文件的入口)  创建一个 vue对象
		App.vue 根组件    创建好的vue对象，默认加载的app组件
		router 路由  替换所需要显示的组件  /请求地址  -- 组件
					 在根组件 App.vue 中   加入<router-view></router-view> 让显示的其他组件  也显示到app组件中
		/src/router/index.js 路由配置   配置请求地址 与组件的关联关系
	    2. vue + elementUI
		vue组建的格式 
		<template>
			html代码
		</template>
		
		<script>
			js代码
			export default{
				data(){
					return{
						
					}
				data:{} 全局使用
			}
		</s cript>
		
		<style>
			css代码
		</style>
		3. 页面跳转时，使用路由跳转  this.$router.push('/main')
		
	 */
	export default{
		
		data(){
			return{
				loginform: {
					  uname: '',
					  upwd: ''
				    },
				rules: {
					  uname: [
						{ required: true, message: '请输入用户名', trigger: 'blur' },
						{ min: 6, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
					  ]
				}
			}
		},
		methods:{
			onSubmit(formname) {
				console.log(this);
				console.log(formname);
			    
				this.$refs[formname].validate((valid) => {
					  if (valid) {
						console.log("发送ajax请求 去登录");
						console.log(this);
						this.$router.push('/main');
					  } else {
						console.log('参数有误');
						return false;
					  }
					});
				
					
			 },
			 myreset(){
				 this.$refs['loginform'].resetFields();
			 }
		}
	}
</script>

<style>
	.text {
	  font-size: 14px;
	}
			
	.item {
	  margin-bottom: 18px;
	}
			
	.clearfix:before,
	.clearfix:after {
	  display: table;
	  content: "";
	}
	.clearfix:after {
	  clear: both
	}
			
	.box-card {
	  width: 480px;
	}
	.loginPanel{
				  margin: 300px auto;
	}
	.el-input{
				  width: 90%;
	}
</style>
