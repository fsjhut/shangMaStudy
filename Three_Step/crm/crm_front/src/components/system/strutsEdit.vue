<template>
	<div>

		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/MyPage' }">系统管理</el-breadcrumb-item>
				<el-breadcrumb-item>组织修改管理</el-breadcrumb-item>
			</el-breadcrumb>
			<br>

			<el-form-item>
				<el-button type="success" :disabled="btnStatus" @click="editFormOpen">组织结构修改</el-button>
				<el-button type="warning" :disabled="btnStatus" @click="deleteDeptById">组织结构删除</el-button>
			</el-form-item>
		</el-form>

		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
			<!-- handleRowChange -->
			<el-table-column property="id" label="部门ID">
			</el-table-column>
			<el-table-column property="dname" label="部门名称">
			</el-table-column>
			<el-table-column property="sname" label="上级部门名称">
			</el-table-column>
			<el-table-column property="deptno" label="部门编号">
			</el-table-column>
			<el-table-column property="isEnabled" label="是否启动">
				<template slot-scope="scope">
					<el-tag :type="scope.row.isEnabled == '1' ? 'primary' : 'danger'" disable-transitions>{{scope.row.isEnabled==1?'已启用':'未启用'}}</el-tag>
				</template>
			</el-table-column>

		</el-table>

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.pageNum"
		 :page-sizes="[3, 6, 9]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>


		<!-- 组织结构修改 -->
		<el-dialog title="组织结构修改" :visible.sync="editFormVisible">
			<el-form ref="editForm" :model="editForm">
				<el-form-item label="部门ID" :label-width="formLabelWidth" prop="id">
					<el-input v-model="editForm.id" :disabled="true" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="部门名称" :label-width="formLabelWidth" prop="dname">
					<el-input v-model="editForm.dname" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="部门编号" :label-width="formLabelWidth" prop="deptno">
					<el-input v-model="editForm.deptno" :disabled="true" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="上级部门" :label-width="formLabelWidth" prop="sname">
					<el-select v-model="editForm.sname" clearable placeholder="请选择">
						<el-option label="无" :value="-1">
						</el-option>
						<el-option v-for="item in totalDepts" :key="item.dname" :label="item.dname" :value="item.dname">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="是否启用" :label-width="formLabelWidth" prop="isEnabled">
					<el-select v-model="editForm.isEnabled" clearable placeholder="请选择">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSubmit()">确 定</el-button>
			</div>
		</el-dialog>
	</div>


</template>

<script>
	export default {
		data() {
			return {
				totalDepts: [],
				tableData: [],
				currentRow: null,
				value: '',
				pageInfo: {
					pageNum: 1,
					pageSize: 6,
					total: 10
				},
				options: [{
						value: '1',
						label: '是'
					},
					{
						value: '0',
						label: '否'
					}
				],
				value2: '',

				editForm: {
					id: '',
					dname: '',
					deptno: '',
					sname: '',
					isEnabled: '',
				},

				defaultProps: {
					children: 'deptList',
					label: 'dname'
				},
				selectform: {
					productName: ''
				},

				checked: true,
				editFormVisible: false,
				formLabelWidth: "100",
				btnStatus: true,
			}


		},

		//var deptId = "";
		methods: {

			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				if (this.currentRow != null) {
					this.editForm = JSON.parse(JSON.stringify(this.currentRow));
					this.btnStatus = false;
					console.log("当前对象==" + this.currentRow.dname);


				}
			},

			// page相关函数，size改变，查询按钮、重置按钮
			handleSizeChange(val) {
				this.btnStatus = true;
				console.log(`每页 ${val} 条`);
				this.pageInfo.pageNum = 1;
				this.pageInfo.pageSize = val;
				this.getDeptAll(this.$qs.stringify(this.pageInfo));
			},

			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},

			//page改变
			handleCurrentChange(val) {
				this.btnStatus = true;
				console.log(`当前页: ${val}`);
				this.pageInfo.pageNum = val;
				this.getDeptAll(this.$qs.stringify(this.pageInfo));

			},



			editFormOpen() {
				this.editFormVisible = true;
				// this.$nextTick(function() {
				// 	this.$refs['editForm'].resetFields();
				// })
			},

			editSubmit() {
				this.btnStatus = true;
				this.editFormVisible = false;
				this.$axios.post("dept/edit", this.editForm)
					.then(resp => {
						if (resp.code == 5009) {
							//成功时 切换视图
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'success'
							});
						
						} else if (resp.code == 5010) {
							//失败时 给用户提示错误信息
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'error'
							});

						}else if (resp.code == 50016) {
							//失败时 给用户提示错误信息
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'error'
							});

						}

						//修改成功刷新数据
						this.getDeptAll(this.$qs.stringify(this.pageInfo));
						this.getTotalDept();
						console.log("bxl==" + this.currentRow.id);



					}).catch(function(err) {
						console.log(err);
					})
			},



			//下拉框
			getTotalDept() {
				this.$axios.post("dept/totalDept")
					.then(resp => {
						let result = resp.data;
						this.totalDepts = resp.data;

					}).catch(function(err) {
						console.log(err)
					})
			},

			//获取表单信息
			getDeptAll(param) {
				this.$axios.get("dept/list/all?" + param)
					.then(resp => {
						this.tableData = resp.data.list;
						//"pageNum":1,"pageSize":200,"total":10
						this.pageInfo.pageNum = resp.data.pageNum;
						this.pageInfo.pageSize = resp.data.pageSize;
						this.pageInfo.total = resp.data.total;

						console.log("11111111====" + resp.code)
					}).catch(function(err) {
						console.log(err)
					})
			},

			//通过id删除部门
			deleteDeptById() {
				//跳出删除框
				this.$confirm('此操作将永久删除该数据，请问是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					//发删除请求
					this.$axios.get("dept/delete/" + this.currentRow.id)
						.then(resp => {
							console.log("id===>" + this.currentRow.id);
							//给用户提示
							if (resp.code == 20000) {
								this.$message({
									message: resp.msg,
									type: 'success'
								});
							} else if(resp.code == 50012){
								this.$message.error(resp.msg);
							}else if(resp.code == 50013){
								this.$message.error(resp.msg);
							}else if (resp.code == 50000) {
								this.$message.error(resp.msg);
							}
							 	//刷新 table数据
							    this.getDeptAll(this.$qs.stringify(this.pageInfo));
								
								//刷新下拉列表数据
								this.getTotalDept();

							
							
						}).catch(err => {})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});

				
			},




		},

		mounted() {
			this.getTotalDept();
			this.getDeptAll();
		},


	}
</script>





<style scoped="scoped">
	.el-button {
		padding: 8px 3px;
		font-size: 6px;
	}

	.el-input {
		width: 300px;
	}
</style>
