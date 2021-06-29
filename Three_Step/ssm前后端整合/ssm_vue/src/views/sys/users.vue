<template>
	<div>
		<!-- 查询表单 -->
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="用户名">
				<el-input v-model="queryForm.uname" placeholder="用户名"></el-input>
			</el-form-item>
			<el-form-item label="手机号">
				<el-input v-model="queryForm.uphone" placeholder="手机号"></el-input>
			</el-form-item>
			<el-form-item label="部门">
				<treeselect placeholder="选择部门" :options="alldepts" v-model="queryForm.did" :normalizer="normalizer" style="width: 260px;" />
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="doQuery">查询</el-button>
			</el-form-item>
		</el-form>

		<el-row>
			<el-col :span="24">
				<el-button type="primary" @click="handleAdd">添加</el-button>
				<el-button type="primary" @click="handleAdd">批量删除</el-button>
			</el-col>
		</el-row>

		<!-- 列表数据 -->
		<el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
			<el-table-column type="selection" width="55">
			</el-table-column>
			<el-table-column label="用户名" prop="uname" width="120">
			</el-table-column>
			<el-table-column prop="uphone" label="手机号" width="120">
			</el-table-column>
			<el-table-column prop="uwechat" label="微信" show-overflow-tooltip>
			</el-table-column>
			<el-table-column prop="sdept.dname" label="部门" show-overflow-tooltip>
			</el-table-column>
			<el-table-column prop="usex" label="性别" :formatter="formatUsex">
			</el-table-column>
			<el-table-column prop="createTime" label="创建时间" show-overflow-tooltip>
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<el-pagination 
		@size-change="handleSizeChange" 
		@current-change="handleCurrentChange" 
		:current-page="queryForm.pageNum"
		:page-size="queryForm.pageSize"
		 :page-sizes="[2, 5, 10, 20]"  
		 :total="queryForm.total"
		 layout="total, sizes, prev, pager, next, jumper">
		</el-pagination>
	</div>
</template>

<script>
	import Treeselect from '@riophae/vue-treeselect'
	import '@riophae/vue-treeselect/dist/vue-treeselect.css'
	import {
		getDeptsTree
	} from '@/utils/depts.js'
	
	export default {
		components: {
			Treeselect
		},
		data() {
			return {
				usersex:[],
				formLabelWidth: '120px',
				dialogTitle: '',
				dialogFormVisible: false,
				dataForm: {},
				queryForm: {
					pageNum:1,
					pageSize:2,
					total:undefined
				},
				tableData: [],
				multipleSelection: [],
				value: null,
				alldepts: [],
				normalizer(node) {
					return {
						id: node.did,
						label: node.dname,
						children: node.children,
					}
				}
			}
		},
		created() {
			this.getdicts("user_sex").then(resp=>{
				this.usersex=resp.data;
			});
			//查询用户列表
			this.doQuery();
			//查询部门树形数据
			getDeptsTree().then(resp => {
				this.alldepts = resp.data;
			});
		},
		methods: {
			formatUsex(row, column, cellValue, index){
				return this.parseDicts(this.usersex,cellValue);
			},
			handleSizeChange(pageSize) {
				this.queryForm.pageSize=pageSize;
				this.doQuery();
			},
			handleCurrentChange(pageNum) {
				this.queryForm.pageNum=pageNum;
				this.doQuery();
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},
			handleEdit(index, row) {
				if (this.alldepts.length == 0) {
					axios.get("/sysuser/list").then(resp => {
						this.alldepts = resp.data;
					})
				}
				// 先按照id取服务端获取完整数据.
				axios.get(`/sysuser/${row.did}`).then(resp => {
					this.dataForm = resp.data;
					this.dialogTitle = "编辑部门信息";
					this.dialogFormVisible = true;
				});
			},
			closeDialog() {
				this.resetForm('dataForm')
				this.dataForm = {};
				this.dialogTitle = "";
				this.dialogFormVisible = false;
			},
			doAdd() {
				let did = this.dataForm.did;
				if (did == null || did == undefined) {
					axios.post("/sysuser", this.dataForm).then(resp => {
						if (resp.code == 50000) {
							this.error("添加失败");
						}
						this.doQuery();
					})
				} else {
					axios.put("/sysuser", this.dataForm).then(resp => {
						if (resp.code == 50000) {
							this.error("编辑失败");
						}
						this.doQuery();
					})
				}

				this.resetForm('dataForm')
				this.dataForm = {};
				this.dialogFormVisible = false;
			},
			handleAdd() {
				axios.get("/sysuser/list").then(resp => {
					this.alldepts = resp.data;
					this.dataForm = {};
					this.dialogTitle = "添加";
					this.dialogFormVisible = true;
				})
			},
			handleDelete(index, row) {
				axios.delete("/sysuser/id/" + row.did).then(resp => {
					
				});
			},
			doQuery() {
				axios.get("/sysuser/udlist", {
					params: this.queryForm
				}).then(resp => {
					this.tableData = resp.data.list;
					this.queryForm.pageNum=resp.data.pageNum;
					this.queryForm.pageSize=resp.data.pageSize;
					this.queryForm.total=resp.data.total;
					console.log(this.queryForm);
				})
			}
		}
	}
</script>
<style>
</style>
