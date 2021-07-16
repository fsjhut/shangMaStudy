<template>
<div>
	<div>
	<el-breadcrumb separator-class="el-icon-arrow-right">
		<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
		<el-breadcrumb-item>系统管理</el-breadcrumb-item>
		<el-breadcrumb-item>菜单管理</el-breadcrumb-item>
		
	</el-breadcrumb>
	</div>
	<!-- 查询条件框 -->
	<el-form :inline="true" ref="queryFrom" :model="queryFrom" class="demo-form-inline">
		<el-form-item label="菜单名称" prop="qmname">
			<el-input v-model="queryFrom.qmname" placeholder="菜单名称"></el-input>
		</el-form-item>
		<el-form-item label="上级菜单 " prop="qpid">
			<el-select v-model="queryFrom.qpid" placeholder="上级菜单">
				<el-option label="无" value="0"></el-option>
				<el-option v-for="menuOp in menuOptions" :label="menuOp.mname" :value="menuOp.mid"></el-option>
			</el-select>
		</el-form-item>
		<el-form-item>
			<el-button type="primary" @click="queryData()">查询</el-button>
			<el-button @click="myreset">重置</el-button>
		</el-form-item>
	</el-form>
      <div style="margin-left:-46%;">
	<el-button type="success" @click="addFormOpen">添加</el-button>
	<el-button type="warning"  :disabled="btnstatus" @click="editFormOpen">修改</el-button>
	<el-button type="danger" :disabled="btnstatus" @click="delFormOpen">删除</el-button>
</div>
	<!--表头 -->
	<el-table ref="singleTable" align="center" :data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%">
		<el-table-column property="mid" align="center" label="菜单编号" width="180">
		</el-table-column>
		<el-table-column property="mname"  align="center" label="菜单名称" width="180">
		</el-table-column>
		<el-table-column property="pid" align="center" label="上级id" width="180">
		</el-table-column>
		<el-table-column property="pname" align="center" label="上级名称" width="180">
		</el-table-column>
		<el-table-column property="url" align="center" label="访问地址" width="180">
		</el-table-column>
		<el-table-column property="glyphicon" align="center" label="图标" width="180">
			<template slot-scope="haha">
				<i :class="haha.row.glyphicon"></i>{{haha.row.glyphicon}}
			</template>
		</el-table-column>
	</el-table>
	<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
	 :page-sizes="[5, 10, 15]" :page-size="3" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
	</el-pagination>

	<!-- 弹出添加菜单 -->
	<el-dialog width="30%" title="添加菜单" :visible.sync="addFormVisible">
		<el-form :model="addForm" ref="addFrom" style="width: 400px;">
			<el-form-item label="菜单编号" :label-width="formLabelWidth" prop="mid" >
				<el-input v-model="addForm.mid" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="菜单名称" :label-width="formLabelWidth" prop="mname">
				<el-input v-model="addForm.mname" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="访问地址" :label-width="formLabelWidth" prop="url">
				<el-input v-model="addForm.url" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="上级菜单" :label-width="formLabelWidth" prop="pid">
				<el-select v-model="addForm.pid" placeholder="上级菜单">
					<el-option label="无" value="0"></el-option>
					<el-option v-for="menuOp in menuOptions" :label="menuOp.mname" :value="menuOp.mid"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="菜单图标" :label-width="formLabelWidth" prop="glyphicon">
				<el-input v-model="addForm.glyphicon" autocomplete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button @click="addFormVisible = false">取 消</el-button>
			<el-button type="primary" @click="addSubmit">确 定</el-button>
		</div>
	</el-dialog>

	<!--弹出修改菜单  -->
	<el-dialog width="30%" title="修改菜单" :visible.sync="editFormVisible">
		<el-form :model="editForm" ref="editFrom" style="width: 400px;">
			<el-form-item label="菜单编号" :label-width="formLabelWidth" prop="mid">
				<el-input v-model="editForm.mid" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="菜单名称" :label-width="formLabelWidth" prop="mname">
				<el-input v-model="editForm.mname" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="访问地址" :label-width="formLabelWidth" prop="url">
				<el-input v-model="editForm.url" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item label="上级菜单" :label-width="formLabelWidth" prop="pid">
				<el-select v-model="editForm.pid" placeholder="上级菜单">
					<el-option label="无" :value="0"></el-option>
					<el-option v-for="menuOp in menuOptions" :label="menuOp.mname" :value="menuOp.mid"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="菜单图标" :label-width="formLabelWidth" prop="glyphicon">
				<el-input v-model="editForm.glyphicon" autocomplete="off"></el-input>
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
				queryFrom: { /* 查询的名称和id*/
					qmname: '',
					qpid: ''
				},
				menuOptions: [],
				/* 下拉菜单集合*/

				tableData: [],
				/* 查询的数据*/

				currentRow: null,
				currentPage4: 2,

				pageinfo: {
					page: 1,
					pageSize: 5,
					total: 20
				},

				addForm: {
					mid: '',
					mname: '',
					url: '',
					pid: '',
					glyphicon: '',
				},
				editForm: {
					mid: '',
					mname: '',
					url: '',
					pid: '',
					glyphicon: '',
				},
				formLabelWidth: '120px',
				btnstatus: true,

				addFormVisible: false,
				editFormVisible: false,
			}
		},

		methods: {
			/* 删除 */
			delFormOpen() {
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {

					this.$axios.post("menu/remove", "mid=" + this.currentRow.mid) /*  this.currentRow.menuid 获得点击时的 id*/
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
							this.getMenuSelect(); /*刷新下拉列表*/
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
				}

			},
			/* 点击修改按钮 弹出修改框 */
			editFormOpen() {
				this.editFormVisible = true;
				

			},
			editSubmit() { /*点击 修改 的确定按钮 发送请求*/
				this.editFormVisible = false;
				this.$axios.post("menu/edit", this.$qs.stringify(this.editForm))
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
						this.getMenuSelect(); /*刷新下拉列表*/
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
				this.$axios.post("menu/add", this.$qs.stringify(this.addForm))
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
						this.getMenuSelect(); /*刷新下拉列表*/
					})
					.catch(err => {
						console.log(err)
					})

			},

			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},


			/*pagesize发生改变 */
			handleSizeChange(val) {
				this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				var param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
				console.log(param);
				this.myquery(param)
			},
			/* 点击查询 按钮 */
			queryData() {
				this.pageinfo.page = 1;
				let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
				this.myquery(param)
			},
			myreset() {
				this.$refs['queryFrom'].resetFields(); //重置
			},
			/*封装的  查询函数  */
			myquery(param) {

				this.$axios.get("menu/query?" + param)
					.then(returnVal => {

						this.tableData = returnVal.data.returnData;
						this.pageinfo = returnVal.data.pageInfo;


					})
					.catch(err => {
						console.log(err)
					})

			},
			/*当前页码发生改变  */
			handleCurrentChange(val) {
				this.$axios.get("menu/query?page=" + val + "&pageSize=" + this.pageinfo.pageSize + "&" + this.$qs.stringify(this.queryFrom) )
					.then(returnVal => {
						console.log(returnVal)
						this.tableData = returnVal.data.returnData;
						this.pageinfo = returnVal.data.pageInfo;
					})
					.catch(err => {
						console.log(err)
					})
			},
			/*获得二级菜单的下拉列表*/
			getMenuSelect() {
				this.$axios.get("menu/getmenuselect")
					.then(returnVal => {
						console.log(returnVal)
						this.menuOptions = returnVal.data.returnData;
						console.log(this.menuOptions)
						

					})
					.catch(err => {
						console.log(err)
					})

			}
		},
		mounted() {
			this.myquery("");
			this.getMenuSelect();
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
	el-table-column{
		align:"center"
		
		}
</style>
