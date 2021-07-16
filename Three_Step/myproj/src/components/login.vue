<template>

<div>
	<el-card class="box-card">
		<div slot="header" class="clearfix">
			<div style="height: 130px;"><img style="width: 100px;" src="../assets/u4.jpg" />
				<span style="font-weight:bolder;font-size:25px;font-family:'微软雅黑';color: black;margin-left: 30px;">尚马MIS金融系统</span>
			</div>
			<el-form :rules="rules" ref="loginform" :model="loginform" label-width="80px" style="width: 400px;">
				<el-form-item label="用户名" prop="uname">
					<el-input v-model="loginform.uname" suffix-icon="el-icon-s-custom"></el-input>
				</el-form-item>
				<el-form-item label="密码" prop="upwd">
					<el-input v-model="loginform.upwd" show-password ></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="onSubmit('loginform')">登录</el-button>
					<el-button @click="myreset">重置</el-button>
					<el-button @click="register" style="margin-left:30% ;">注册</el-button>
				</el-form-item>
			</el-form>
		</div>
	</el-card>
	
	<el-dialog width="28%" title="注册" :visible.sync="dialogFormVisible">
		<el-form  :model="form"  ref="from" style="width: 400px;">
			<el-form-item label="用户名" :label-width="formLabelWidth" prop="uname" >
				<el-input v-model="form.uname" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="密码" :label-width="formLabelWidth" prop="upwd1">
				<el-input show-password v-model="form.upwd1" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="再次输入密码" :label-width="formLabelWidth" prop="upwd2">
				<el-input show-password v-model="form.upwd2" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="头像" style="width: 245px;margin: 5px auto;" prop="uimage">
				<el-upload class="avatar-uploader" action="" :http-request="myupload" :show-file-list="false" :before-upload="beforeAvatarUpload"
				 name="myfile">
					<img v-if="form.uimage" :src="'http://localhost:8080/'+form.uimage" class="avatar">
					<i v-else class="el-icon-plus avatar-uploader-icon"></i>
				</el-upload>
			
			</el-form-item>
			

		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button @click="dialogFormVisible = false">取 消</el-button>
			<el-button type="primary" @click="registerSubmit">确 定</el-button>
		</div>
	</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					uname: '',
					upwd1: '',
					upwd2: '',
					uimage:'',

				},
				
				dialogFormVisible: false,
				 formLabelWidth: '120px',
				loginform: {
					uname: '',
					upwd: '',

				},

				rules: {
					username: [{
							required: true,
							message: '请输入用户名称',
							trigger: 'blur'
						},
						{
							min: 2,
							max: 8,
							message: '长度在 6 到 8 个字符',
							trigger: 'blur'
						}
					]
				}
			}
		},
		methods: {
			/* 注册提交按钮 */
			registerSubmit(){
				this.$axios.post("register",this.$qs.stringify(this.form))
				
				.then(returnVal=>{
					
					if (returnVal.data.returnCode == 3000) {
						this.$message({
							showClose: true,
							message: '注册成功',
							type: 'success'
						});
						this.dialogFormVisible=false;
					} else if (returnVal.data.returnCode == 4000) {
						this.$message({
							showClose: true,
							message: '两次密码不一致，请重新输入',
							type: 'error'
						});
					}
					
					
				})
				.catch(err=>{
					console.log(err)
				})
			},
			myupload(param) {
				let formData = new FormData();
				formData.append("myfile", param.file);
				this.$axios.post("upload", formData, {
						headers: {
							"Content-Type": "multipart/form-data"
						}
					})
					.then(resp => {
						console.log(resp);
						this.form.uimage = resp.data.imgsrc;
						console.log(resp.data.imgsrc)
					})
			},
			beforeAvatarUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isLt2M = file.size / 1024 / 1024 < 2;
			
				if (!isJPG) {
					this.$message.error('上传头像图片只能是 JPG 格式!');
				}
				if (!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return isJPG && isLt2M;
			},
			
			/* 点击注册按钮 */
			register() {
				this.dialogFormVisible=true;
				this.$nextTick(function() { /*渲染后执行 代码*/
					this.$refs['from'].resetFields(); /* 不重置  之前添加的数据还在输入框内*/
				})

			},
			onSubmit(loginform) {
				this.$refs[loginform].validate((valid) => { //验证账号密码  如果符合格式 则发请求
					if (valid) {
						console.log('请登录');
						this.$axios.post("login", this.$qs.stringify(this.loginform))
							.then(returnData => {
								console.log(returnData)
								if (returnData.data.returnCode == 4000) {
									this.$message.error('账号或密码输入错误');
								} else if (returnData.data.returnCode == 3000) {
									this.$router.push('/main') //跳转
								}
							})
							.catch(err => {
								console.log(err);
							})
					} else {
						console.log('输入有误');
						return false;
					}

				});
			},
			myreset() {
				this.$refs['loginform'].resetFields(); //重置
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
		margin: 300px auto;
	}

	.el-input {
		width: 90%;
	}
	
	.avatar-uploader .el-upload {
	    border: 1px dashed #d9d9d9;
	    border-radius: 6px;
	    cursor: pointer;
	    position: relative;
	    overflow: hidden;
	  }
	  .avatar-uploader .el-upload:hover {
	    border-color: #409EFF;
	  }
	  .avatar-uploader-icon {
	    font-size: 28px;
	    color: #8c939d;
	    width: 178px;
	    height: 178px;
	    line-height: 178px;
	    text-align: center;
	  }
	  .avatar {
	    width: 178px;
	    height: 178px;
	    display: block;
	  }
</style>
