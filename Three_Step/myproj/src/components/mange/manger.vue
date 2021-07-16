<template>
	<div>
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>系统管理</el-breadcrumb-item>
				<el-breadcrumb-item>人员管理</el-breadcrumb-item>

			</el-breadcrumb>
		</div>
		<!-- 查询条件框 -->
		<el-form :inline="true" ref="queryFrom" :model="queryFrom" class="demo-form-inline">
			<el-form-item label="用户ID" prop="quid">
				<el-input v-model="queryFrom.quid" placeholder="用户ID"></el-input>
			</el-form-item>
			<el-form-item label="用户名称" prop="quname">
				<el-input v-model="queryFrom.quname" placeholder="用户名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="queryData()">查询</el-button>
				<el-button @click="myreset">重置</el-button>
			</el-form-item>
		</el-form>
		<div style="margin-left:-38%;">
			<el-button type="success" @click="addFormOpen">添加</el-button>
			
			<el-button type="success" :disabled="btnstatus1" @click="authFormOpen">授权</el-button>
			<el-button type="warning" :disabled="btnstatus" @click="editFormOpen">修改</el-button>
			<el-button type="danger"  :disabled="btnstatus" @click="delFormOpen">删除</el-button>
			
		</div>
		<!--表头 -->
		<el-table ref="singleTable" align="center" :data="tableData" highlight-current-row @current-change="handleRowChange"
		 style="width: 100%;left: -width/2;line-height: 30px;">
			<el-table-column property="uid" align="center" label="用户ID" width="200px">
			</el-table-column>
			<el-table-column property="uname" align="center" label="用户名称" width="200">
			</el-table-column>
			<el-table-column property="logintime" align="center" label="最后登录时间" width="200">
			</el-table-column>
			<el-table-column property="ustate" align="center" label="人员状态" width="200">
				<template slot-scope="scope">
				      <el-tag :type="scope.row.ustate=='可用'?'success':(scope.row.ustate=='调休'?'warning':'info')">{{scope.row.ustate}}</el-tag>
				    </template>
			</el-table-column>
			<el-table-column property="uimage" align="center" label="用户头像" width="200">

				<template slot-scope="scope">
					<img style="width:70px;" :src="'http://localhost:8080/'+scope.row.uimage" />
				</template>

			</el-table-column>

		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
		 :page-sizes="[5,10,15]" :page-size="3" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
		</el-pagination>
		<!-- 授权功能-->
		<el-dialog width="25%" title="授权" :visible.sync="authFormVisible">
			<el-form style="width: 350px;" :model="authForm" ref="authForm">
				<el-form-item label="授权ID" :label-width="formLabelWidth" prop="uid">
					<el-input v-model="authForm.uid" autocomplete="off" :disabled="true"></el-input>
				</el-form-item>

				<el-tree :data="authdata" show-checkbox node-key="mid" ref="authtree" default-expanded-all :default-checked-keys="currntAuth"
				 :props="defaultProps">
				</el-tree>


			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="authFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="authsubmit">确 定</el-button>
			</div>

		</el-dialog>

		<!-- 弹出添加菜单 -->
		<el-dialog width="28%" title="添加" :visible.sync="addFormVisible">
			<el-form :model="addForm" ref="addFrom" style="width: 400px;">
				<el-form-item label="用户ID" :label-width="formLabelWidth" prop="uid">
					<el-input v-model="addForm.uid" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="用户名" :label-width="formLabelWidth" prop="uname">
					<el-input v-model="addForm.uname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="人员状态" :label-width="formLabelWidth" prop="ustate">
					<el-select v-model="addForm.ustate" placeholder="人员状态">
						<el-option v-for="ms in mgusatate" :label="ms.name" :value="ms.name"></el-option>
					</el-select>
				</el-form-item>

				<el-form-item style="width: 245px;margin: 5px auto;" label="头像" prop="uimage">
					<el-upload class="avatar-uploader" action="" :http-request="myupload" :show-file-list="false" :before-upload="beforeAvatarUpload"
					 name="myfile">
						<img v-if="addForm.uimage" :src="'http://localhost:8080/'+addForm.uimage" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>

				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addSubmit">确 定</el-button>
			</div>
		</el-dialog>

		<!--弹出修改菜单  -->
		<el-dialog width="28%" title="修改" :visible.sync="editFormVisible">
			<el-form :model="editForm" ref="editFrom" style="width: 400px;">
				<el-form-item label="用户ID" :label-width="formLabelWidth" prop="uid">
					<el-input :disabled="true" v-model="editForm.uid" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="用户名" :label-width="formLabelWidth" prop="uname">
					<el-input v-model="editForm.uname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="人员状态" :label-width="formLabelWidth" prop="ustate">
					<el-select v-model="editForm.ustate" placeholder="人员状态">
						<el-option v-for="ms in mgusatate" :label="ms.name" :value="ms.name"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="头像" style="width: 245px;margin: 5px auto;" prop="uimage">
					<el-upload class="avatar-uploader" action="" :http-request="myupload2" :show-file-list="false" :before-upload="beforeAvatarUpload"
					 name="myfile">
						<img v-if="editForm.uimage" :src="'http://localhost:8080/'+editForm.uimage" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>

				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSubmit">确 定</el-button>
			</div>
		</el-dialog>
	</div>

</template>

<script>
	export default {
		data() {
			return {
				loginMan:{name:""},
				currntAuth: [],
				/* 默认选中的权限*/
				authdata: [],
				/* 授权的数据*/

				defaultProps: {
					children: 'submenu',
					label: 'mname',
				},
				authForm: { /* 授权的id*/
					uid: "",
				},

				queryFrom: { /* 查询的名称和id*/
					quname: '',
					quid: ''
				},
				mgusatate: [{
						name: "可用",
						id: 1
					},
					{
						name: "休假",
						id: 2
					},
					{
						name: "调休",
						id: 3
					},
				],
				menuOptions: [],
				/* 下拉菜单集合*/

				tableData: [],
				/* 查询的数据*/

				currentRow: null,
			

				pageinfo: {
					page: 0,
					pageSize: 0,
					total: 0,
				},

				addForm: {
					uid: '',
					uname: '',
					ustate: '',
					uimage: '',

				},
				editForm: {
					uid: '',
					uname: '',
					ustate: '',
					uimage: '',
				},
				formLabelWidth: '120px',
				btnstatus: true,
                btnstatus1: true,
				addFormVisible: false,
				editFormVisible: false,
				authFormVisible: false,

			}
		},

		methods: {
			/* 授权确定按钮 */
			authsubmit() {
				let menuid = this.$refs.authtree.getCheckedKeys().join(",");

				let param = "uid=" + this.currentRow.uid + "&menuid=" + menuid
				this.$axios.post("manger/editmgauth", param)
					.then(resp => {

						this.$message.success(resp.data.returnMsg);
						this.authFormVisible = false;
						this.myquery("");
					}).catch(err => {
						console.log(err);
					})
			},

			//授权
			authFormOpen() {
				this.authFormVisible = true;
				this.$axios.post("manger/auth", "uid=" + this.currentRow.uid)
					.then(returnVal => {
						console.log(returnVal)

						this.authdata = returnVal.data.returnData.menuslist

						this.authForm.uid = returnVal.data.returnData.uid; //用户id

						this.currntAuth = returnVal.data.returnData.idmenus.split(",") //用户本身拥有的权限


					})
					.catch(err => {
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
						this.addForm.uimage = resp.data.imgsrc;
						console.log(resp.data.imgsrc)
					})
			},
			myupload2(param) {
				let formData = new FormData();
				formData.append("myfile", param.file);
				this.$axios.post("upload", formData, {
						headers: {
							"Content-Type": "multipart/form-data"
						}
					})
					.then(resp => {
						console.log(resp);
						this.editForm.uimage = resp.data.imgsrc;
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

			/* 删除 */
			delFormOpen() {
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {

					this.$axios.post("manger/remove", "uid=" + this.currentRow.uid) /*  this.currentRow.menuid 获得点击时的 id*/
						.then(returnVal => {
							if (returnVal.data.returnCode == 3000) {
								this.$message({
									showClose: true,
									message: returnVal.data.returnMsg,
									type: 'success'
								});
							} else if (returnVal.data.returnCode == 4000) {
								this.$message({
									showClose: true,
									message: returnVal.data.returnMsg,
									type: 'error'
								});
							}
							let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
							this.myquery(param) /*刷新列表数据*/

						})
						.catch(err => {
							console.log(err)
						})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			},
			/* 点击一行*/
			handleRowChange(val) {
				this.currentRow = val;
				this.btnstatus = false;
				if (this.currentRow != null) {
					this.editForm = JSON.parse(JSON.stringify(this.currentRow)); /* 将此行数据 传入修改框*/
					if(this.loginMan.name=="测试1"){
						this.btnstatus1=false;
					}else{
						this.btnstatus1=true;
						}
             }
			},
			/* 点击修改按钮 弹出修改框 */
			editFormOpen() {
				this.editFormVisible = true;



			},


			editSubmit() { /*点击 修改 的确定按钮 发送请求*/
				this.editFormVisible = false;
				this.$axios.post("manger/edit", this.$qs.stringify(this.editForm))
					.then(returnVal => {
						if (returnVal.data.returnCode == 3000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'success'
							});
						} else if (returnVal.data.returnCode == 4000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'error'
							});
						}
						let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
						this.myquery(param) /*刷新列表数据*/

					})
					.catch(err => {
						console.log(err)
					})

			},
			/* 点击 添加按钮  */
			addFormOpen() {

				this.addFormVisible = true;
				this.$nextTick(function() { /*渲染后执行 代码*/
					this.$refs['addFrom'].resetFields(); /* 不重置  之前添加的数据还在输入框内*/
				})
			},
			/*点击添加的确定按钮*/
			addSubmit() {
				this.addFormVisible = false;

				this.$axios.post("manger/add", this.$qs.stringify(this.addForm))
					.then(returnVal => {
						if (returnVal.data.returnCode == 3000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'success'
							});
						} else if (returnVal.data.returnCode == 4000) {
							this.$message({
								showClose: true,
								message: returnVal.data.returnMsg,
								type: 'error'
							});
						}
						let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
						this.myquery(param) /*刷新列表数据*/

					})
					.catch(err => {
						console.log(err)
					})

			},
			/* ?? */

			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},



			/* 点击查询 按钮 */
			queryData() {
				this.pageinfo.page=1;
				
				let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
				

				this.myquery(param)
			},
			myreset() {
				this.$refs['queryFrom'].resetFields(); //重置
			},
			/*封装的  查询函数  */
			myquery(param) {

				this.$axios.get("manger/query?" + param)
					.then(returnVal => {
					    
						this.tableData = returnVal.data.returnData;
						
						this.pageinfo = returnVal.data.pageInfo;
						
					    this.loginMan.name = returnVal.data.reviewer;
					    
						// if(this.loginMan.name=="测试1"){
						// 	this.btnstatus1=false;
						// 	}

					})
					.catch(err => {
						console.log(err)
					})

			},
			/*pagesize发生改变 */
			handleSizeChange(val) {
				this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				var param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
				this.myquery(param)
			},
			/*当前页码发生改变  */
			handleCurrentChange(val) {
				this.$axios.get("manger/query?page=" + val + "&pageSize=" + this.pageinfo.pageSize + "&" + this.$qs.stringify(this.queryFrom))
					.then(returnVal => {
						
						this.tableData = returnVal.data.returnData;
						this.pageinfo = returnVal.data.pageInfo;


					})
					.catch(err => {
						console.log(err)
					})
			},
			/*获得二级菜单的下拉列表*/
			getMenuSelect() {
				this.$axios.get("mange/getmgustate")
					.then(returnVal => {
						this.menuOptions = returnVal.data.returnData;

					})
					.catch(err => {
						console.log(err)
					})

			}
		},

		mounted() {
			this.myquery("");
			// this.getMenuSelect();
		},
		watch: {
			tableData: function() {
				this.$nextTick(function() {
					this.btnstatus = true;
				})
			}

		}

	}
</script>

<style>
	.el-main {
		line-height: 40px;
	}

	.el-select {
		width: 100%;
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
	
    .el-form--inline .el-form-item {
       margin-bottom: 10px;
    }
	

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
