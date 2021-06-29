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
	
	export default {
	
		data(){
			return{
				loginform: {
					  uname: '',
					  upwd: ''
				    },
				rules: {
					  uname: [
						{ required: true, message: '请输入用户名', trigger: 'blur' },
						{ min: 2, max: 8, message: '长度在 6 到 8 个字符', trigger: 'blur' }
					  ]
				}
			}
		},
		methods:{
			onSubmit(formname) {
				this.$refs[formname].validate((valid) => {
					  if (valid) {
						axios.post("/sysuser/loginByPwd",this.loginform)
						.then(resp=>{
							let code = resp.code;
							if(code==50001){
								this.error("密码错误!");
							}else if(code==50004){
								this.error("用户名不存在!")
							}else{
								let loginuser = resp.data;
								localStorage.setItem("loginuser",JSON.stringify(loginuser));
								this.$router.push('/main');
							}
						}).catch(err=>{
							console.log(err);
					   })
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
