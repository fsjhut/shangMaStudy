<template>
	<div>
		<!-- 查询表单 -->
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="部门名称">
				<el-input v-model="queryForm.dname" placeholder="审批人"></el-input>
			</el-form-item>
			<el-form-item label="联系人">
				<el-input v-model="queryForm.duser" placeholder="审批人"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="doQuery">查询</el-button>
			</el-form-item>
		</el-form>
		
		<el-row>
			<el-col :span="24">
				<el-button type="primary" @click="handleAdd">添加</el-button>
			</el-col>
		</el-row>
		
		<!-- 部门列表,树形表格 -->
		<el-table :data="tableData" style="width: 100%;margin-bottom: 20px;" row-key="did" border default-expand-all
		 :tree-props="{children: 'children'}">
			<el-table-column prop="dname" label="部门名称" width="180">
			</el-table-column>
			<el-table-column prop="duser" label="部门联系人" width="180">
			</el-table-column>
			<el-table-column prop="duphone" label="联系电话">
			</el-table-column>
			<el-table-column prop="createTime" label="更新时间">
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<!-- 添加或修改部门 -->
		<el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
			<el-form ref="dataForm"  :model="dataForm">
				<el-form-item label="父部门" :label-width="formLabelWidth">
					<treeselect :options="alldepts" v-model="dataForm.deptParentId" :value="dataForm.deptParentId" :normalizer="normalizer" />
				</el-form-item>
				<el-form-item label="部门名称" :label-width="formLabelWidth">
					<el-input v-model="dataForm.dname"></el-input>
				</el-form-item>
				<el-form-item label="联系人" :label-width="formLabelWidth">
					<el-input v-model="dataForm.duser"></el-input>
				</el-form-item>
				<el-form-item label="联系方式" :label-width="formLabelWidth">
					<el-input v-model="dataForm.duphone"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="closeDialog">取 消</el-button>
				<el-button type="primary" @click="doAdd">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>
<script>
	import Treeselect from '@riophae/vue-treeselect'
	import '@riophae/vue-treeselect/dist/vue-treeselect.css'

	export default {
		components: {
			Treeselect
		},
		data() {
			return {
				formLabelWidth: '120px',
				dialogTitle: '',
				dialogFormVisible: false,
				dataForm: {},
				queryForm: {},
				tableData: [],
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
			this.doQuery();
		},
		methods: {
			handleEdit(index,row){
				if(this.alldepts.length==0){
					axios.get("/sysdept/list").then(resp=>{
						this.alldepts=resp.data;
					})
				}
				// 先按照id取服务端获取完整数据.
				axios.get(`/sysdept/${row.did}`).then(resp=>{
					this.dataForm=resp.data;
					console.log(this.dataForm);
					this.dialogTitle="编辑部门信息";
					this.dialogFormVisible=true;
				});
			},
			closeDialog(){
				this.resetForm('dataForm')
				this.dataForm={};
				this.dialogTitle="";
				this.dialogFormVisible=false;
			},
			doAdd(){
				let did = this.dataForm.did;
				if(did==null || did==undefined){
					axios.post("/sysdept",this.dataForm).then(resp=>{
						if(resp.code==50000){
							this.error("添加失败");
						}
						this.doQuery();
					})
				}else{
					axios.put("/sysdept",this.dataForm).then(resp=>{
						if(resp.code==50000){
							this.error("编辑失败");
						}
							this.doQuery();
					})
				}
			
				this.resetForm('dataForm')
				this.dataForm={};
				this.dialogFormVisible=false;
			},
			handleAdd() {
				axios.get("/sysdept/list").then(resp => {
					this.alldepts=resp.data;
					this.dataForm={};
					this.dialogTitle="添加部门";
					this.dialogFormVisible=true;
				})
			},
			handleDelete(index, row) {
				axios.delete("/sysdept/id/" + row.did).then(resp => {
					let code = resp.code;
					if (code == 50005) {
						this.error(row.dname + "部门下有子部门,不允许删除!");
					}
					this.doQuery();
				});
			},
			doQuery() {
				axios.get("/sysdept/list", {
					params: this.queryForm
				}).then(resp => {
					this.tableData = resp.data;
				})
			}
		}
	}
</script>

<style>
</style>
