<template>
	<el-container>
		<el-header style="height: 80px;">
			<div style="height: 80px;">
				<img style="height: 80px;width:120px;" src="../assets/微信图片_20210603142303.png" />
				<!-- <span style="font-weight:bolder;font-size:20px;font-family:'微软雅黑';color: aliceblue; ">尚马MIS金融系统</span> -->


				<el-dropdown style="cursor: pointer;  margin-left:85%; top: -33px;" split-button type="info" @click="handleClick">
					<span>{{mgname}}</span>
					<el-dropdown-menu slot="dropdown">
						<el-dropdown-item @click.native="edit">
							修改密码
						</el-dropdown-item>
						<el-dropdown-item @click.native="myquit">
							退出
						</el-dropdown-item>
					</el-dropdown-menu>
				</el-dropdown>

			</div>
		</el-header>
      
		<el-dialog width="25%" title="修改密码" :visible.sync="dialogFormVisible">
			<el-form :model="editpwd" ref="editFrom" style="width: 350px;">
				<el-form-item label="用户Id" :label-width="formLabelWidth" prop="uid">
					<el-input :disabled="true" v-model="editpwd.uid" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="输入旧密码" :label-width="formLabelWidth" prop="oldupwd">
					<el-input show-password v-model="editpwd.oldupwd" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="输入新密码" :label-width="formLabelWidth" prop="newupwd">
					<el-input show-password v-model="editpwd.newupwd" autocomplete="off"></el-input>
				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editsubmit">确 定</el-button>
			</div>
		</el-dialog>

		<el-container>
			<el-aside width="200px">
				</el-col>
				<el-col :span="24">
					<el-menu default-active="2" class="el-menu-vertical-demo" :router="true" @open="handleOpen" @close="handleClose"
					 background-color="white" text-color="#333333" active-text-color="black">
						<!-- 遍历列表集合-->
						<el-submenu v-for="menu in mymenu" :index="menu.mid.toString()" :keys="menu.mid">
							<template slot="title">
								<!-- 一级列表 -->
								<i :class="menu.glyphicon"></i>
								<span>{{menu.mname}}</span>
							</template>
							<!-- 二级列表 -->
							<el-menu-item v-for="submenus in menu.submenu" :index="submenus.url" :keys="submenus.uid"><i :class="submenus.glyphicon"></i>{{submenus.mname}}</el-menu-item>
						</el-submenu>

					</el-menu>
				</el-col>
				</el-row>

			</el-aside>
			<el-main>
				<!-- 子组件 -->
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
				dialogTableVisible: false,
				dialogFormVisible: false,
				editpwd: {
					uid: '',
					oldupwd: '',
					newupwd: '',
				},
				formLabelWidth: '120px',
				mgname: "",
				mymenu: []
			}
		},
		methods: {
			edit() {
				this.dialogFormVisible = true,
					this.$nextTick(function() { /*渲染后执行 代码*/
						this.$refs['editFrom'].resetFields(); /* 不重置  之前添加的数据还在输入框内*/
					})
			},
			
			myquit() {
				console.log("123456")
				this.$confirm('确认退出吗?', '提示', {
					confirmButtonText: '确实',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
                    this.$axios.get("loginOut")
					.then(returnVal=>{
						if(returnVal.data.returnCode==3000){
							this.$message({
						type: 'success',
						message: '退出成功'
					});
					this.$router.push('/login')
						}
					})
					
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消'
					});
				});
			},
			/* 修改密码提交确认 */
			editsubmit() {
				this.dialogFormVisible = false
				this.$axios.post("editupwd", this.$qs.stringify(this.editpwd))
					.then(returnVal => {

						if (returnVal.data.returnCode == 3000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'success'
							});

							this.$router.push('/login')
						} else if (returnVal.data.returnCode == 4000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'error'
							});
						}
					})
					.catch(err => {
						console.log(err)
					})

			},
			handleClick() {
				alert('别点啦！！');
			},
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			}
		},
		mounted() {
			this.$axios.get("getmenu")
				.then(returnVal => {
					if (returnVal.data.returnCode == 3000) {
						console.log(returnVal)
						this.mymenu = returnVal.data.returnData.mgmenu
						this.mgname = returnVal.data.returnData.uname
						this.editpwd.uid = returnVal.data.returnData.uid;

					}
				})
				.catch(err => {
					console.log(err)
				})
		
		}
	}
</script>

<style>
	html,
	body,
	#app {
		height: 100%;
		margin: 0px;
		padding: 0px;
	}

	.el-header {
		background-color: #333333;
		color: #333;
		text-align: center;
		height: 30%;
	}

	.el-footer {
		background-color: #333333;
		color: #333;
		text-align: center;
		line-height: 60px;
	}

	.el-aside {
		background-color: white;
		color: #333;
		text-align: center;
		line-height: 200px;
	}

	.el-main {
		background-color: gainsboro;
		color: #333;
		text-align: center;
		line-height: 160px;
	}

	body>.el-container {
		margin-bottom: 40px;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
		line-height: 320px;
	}

	body>.el-container {
		height: 100%;
	}
</style>
