<template>
	<el-card class="box-card border">
	  <div slot="header" class="clearfix">
	    <span>登录</span>
	  </div>
	  <div>
		  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
		    <el-form-item label="用户名" prop="uname">
		  	<el-input v-model="ruleForm.uname" suffix-icon="el-icon-user-solid" ></el-input>
		    </el-form-item>
		    <el-form-item label="密码" prop="upassword">
		  	<el-input v-model="ruleForm.upassword" suffix-icon="el-icon-lock" type="password"></el-input>
		    </el-form-item>
			<el-form-item>
				<el-button @click="submitForm('ruleForm')" >登录</el-button>
				<el-button @click="resetForm('ruleForm')">重置</el-button>
			</el-form-item>
		  </el-form>	
	  </div>
	  <div>
		  
	  </div>
	</el-card>
	
</template>

<script>
	
	export default {
	    data() {
	          return {
	            ruleForm: {
	              uname: '',
	              upassword: ''
	            },
	            rules: {
	              uname: [
	                { required: true, message: '请输入用户名', trigger: 'blur' },
	                { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
	              ],
	              upassword:	[
					  { required: true, message: '请输入密码', trigger: 'blur' }
				  ]
	            }
	          };
	        },
	        methods: {
	          submitForm(formName) {
	            this.$refs[formName].validate((valid) => {
	              if (valid) {
					//验证后端跨域代码
					this.$axios.post("sysuser/login",this.ruleForm)
					.then(resp=>{
						console.log(resp);
						if(resp.code==10000){
							this.$router.push('/MyPage');
						}else if(resp.code==50002){
							this.$message.error('用户名或密码错误');
						}
					}).catch(error=>{
						console.log(error)
					})
	              } else {
	                console.log('error submit!!');
	                return false;
	              }
	            });
	          },
	          resetForm(formName) {
	            this.$refs[formName].resetFields();
	          }
	        }
	  }
	
</script>
	
<style>
	.el-input {
	    width: 90%;
	}
	.border {
	    margin-left: 36%;
	    position:relative;
	    top: 200px;
	    /* border: 1px solid black; */
	    /* margin: 200px auto; */
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
</style>
