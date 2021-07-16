<template>
	<div>

		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/MyPage' }">系统管理</el-breadcrumb-item>
				<el-breadcrumb-item>组织结构管理</el-breadcrumb-item>
			</el-breadcrumb>
			<br>


			<el-form-item>
				<el-button type="primary" @click="addFormOpen2">组织结构添加顶级节点</el-button>
				<el-button type="primary" @click="addFormOpen">组织结构添加子级节点</el-button>
			</el-form-item>
		</el-form>


		<!-- 组织结构添加 -->
		<el-dialog title="组织结构添加" :visible.sync="addFormVisible">
			<el-form ref="addForm" :model="addForm">
				<el-form-item label="部门名称" :label-width="formLabelWidth" prop="dname">
					<el-input v-model="addForm.dname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="部门编号" :label-width="formLabelWidth" prop="deptno">
					<el-input v-model="addForm.deptno" autocomplete="off"></el-input>
				</el-form-item>

				<!-- 		<el-form-item label="上级部门" :label-width="formLabelWidth" prop="sname">
					<el-select v-model="addForm.sname" clearable placeholder="请选择">
						<el-option label="无" :value="-1">
						</el-option>
						<el-option v-for="item in totalDepts" :key="item.dname" :label="item.dname" :value="item.dname">
						</el-option>
					</el-select>
				</el-form-item> -->

				<el-form-item label="上级部门" :label-width="formLabelWidth" prop="sname">
					<!-- emitPath: false只选择当前节点 -->
					<el-cascader v-model="addForm.sname" :options="depts" :clearable=true :props="{ label: 'dname', value: 'dname',children:'deptList', checkStrictly: true,emitPath: false}"
					 :show-all-levels="false" @change="handleChange"></el-cascader>
				</el-form-item>

				<el-form-item label="是否启用" :label-width="formLabelWidth" prop="isEnabled">
					<el-select v-model="addForm.isEnabled" clearable placeholder="请选择">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>

				<!-- 		<el-col :span="12">
					<el-checkbox v-model="checked">设为顶级部门</el-checkbox>
				</el-col>	 -->
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addSubmit()">确 定</el-button>
			</div>
		</el-dialog>
		
		<!-- 组织结构添加顶级节点 -->
		<el-dialog title="组织结构添加顶级节点" :visible.sync="addFormVisible2">
			<el-form ref="addForm2" :model="addForm2">
				<el-form-item label="部门名称" :label-width="formLabelWidth" prop="dname">
					<el-input v-model="addForm2.dname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="部门编号" :label-width="formLabelWidth" prop="deptno">
					<el-input v-model="addForm2.deptno" autocomplete="off"></el-input>
				</el-form-item>
		
				<el-form-item label="上级部门" :label-width="formLabelWidth" prop="sname">
					<el-select v-model="addForm2.sname" clearable placeholder="请选择">
						<el-option label="无" :value="-1"></el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="是否启用" :label-width="formLabelWidth" prop="isEnabled">
					<el-select v-model="addForm2.isEnabled" clearable placeholder="请选择">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
		
				<!-- 		<el-col :span="12">
					<el-checkbox v-model="checked">设为顶级部门</el-checkbox>
				</el-col>	 -->
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible2 = false">取 消</el-button>
				<el-button type="primary" @click="addSubmit2()">确 定</el-button>
			</div>
		</el-dialog>


		


		<!-- <el-tree :data="authdata" show-checkbox node-key="id" default-expand-all :default-checked-keys="currntAuth" :props="defaultProps">
		</el-tree> -->
		
		<el-tree :data="authdata" :props="defaultProps" @node-click="currntAuth"></el-tree>


	</div>







</template>

<script>
	export default {
		data() {
			return {
				totalDepts: [],
				value: '',
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
				addForm: {
					id: '',
					dname: '',
					deptno: '',
					sname: '',
					isEnabled: '',
				},
				addForm2: {//顶级节点
					id: '',
					dname: '',
					deptno: '',
					sname: '',
					isEnabled: '',
				},
			
				currntAuth: [],
				authdata: [],
				depts: [],
				defaultProps: {
					children: 'deptList',
					label: 'dname'
				},
				selectform: {
					productName: ''
				},

				checked: true,
				addFormVisible: false,
				addFormVisible2:false,
				editFormVisible: false,
				formLabelWidth: "100",
			}


		},


		methods: {
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;

				console.log(123456789);
				console.log("当前对象" + this.currentRow);
			},
			handleChange(value) {
				console.log(value);
			},


			addFormOpen() {
				//this.getTotalDept();
				//myreset();
				this.addFormVisible = true;
				this.$nextTick(function() {
					this.$refs['addForm'].resetFields();
				})

			},
			
			addFormOpen2() {
				//this.getTotalDept();
				//myreset();
				this.addFormVisible2 = true;
				this.$nextTick(function() {
					this.$refs['addForm2'].resetFields();
				})
			
			},

			//添加
			addSubmit() {
				this.addFormVisible = false;
				console.log("1231231" + this.addForm)
				this.$axios.post("dept", this.addForm)
					.then(resp => {
						if (resp.code == 50015) {
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50014) {
							this.$message.error(resp.msg)
						}
						//刷新数据
						this.deptTree();
					})

			},
			
			//顶级
			addSubmit2() {
				this.addFormVisible2 = false;
				// let deptArray = this.addForm.sname;
				// console.log("dept=="+deptArray)
				// let newsname;
				// for (var i = 0; i < deptArray.length; i++) {
				// 	newsname = deptArray[i];
				// }
			
				// this.addForm.sname = newsname;
				// console.log(this.addForm)
				//let param = this.$qs.stringify(this.addForm);
				console.log("1231231" + this.addForm2)
				this.$axios.post("dept", this.addForm2)
					.then(resp => {
						if (resp.code == 50015) {
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50014) {
							this.$message.error(resp.msg)
						}
			
						//刷新数据
						this.deptTree();
					})

			},

		

			




			deptTree() {
				this.$axios.post("dept/userDeptno")
					.then(resp => {
						let result = resp.data;
						this.authdata = resp.data;
						this.depts = resp.data;
						// this.totalDepts = resp.data;
						//console.log("123==" + resp.msg)
					}).catch(function(err) {
						console.log(err)
					})
			},

			getTotalDept() {
				this.$axios.post("dept/totalDept")
					.then(resp => {
						let result = resp.data;
						this.totalDepts = resp.data;
						//console.log("bxl==" + result)
					}).catch(function(err) {
						console.log(err)
					})
			},




		},

		mounted() {
			//this.onSubmit();
			this.deptTree();
			this.getTotalDept();
		},


	};
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
