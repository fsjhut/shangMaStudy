<template>
	<div>
		<el-form :inline="true" ref="deptform" :model="deptform" class="demo-form-inline">
		  <el-form-item label="部门" prop="deptno">
		    <el-cascader
		        v-model="deptform.deptno"
		        :options="depts"
		    	:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
		    	:show-all-levels="false"></el-cascader>
		  </el-form-item>
		  
		  <el-form-item label="角色状态" prop="rstate">
		    <el-select v-model="deptform.rstate" placeholder="请选择角色状态">
		      <el-option
		        v-for="item in states"
		        :key="item.value"
		        :label="item.label"
		        :value="item.value">
		      </el-option>
		    </el-select>
		  </el-form-item>
		  <el-form-item label="角色名" prop="rname">
		    <el-input v-model="deptform.rname" placeholder="请输入角色名"></el-input>
		  </el-form-item>
		  <el-form-item label="角色描述" prop="rdesc">
		    <el-input v-model="deptform.rdesc" placeholder="请输入角色描述"></el-input>
		  </el-form-item>
		  <el-form-item>
		    <el-button type="primary" @click="deptquery">查询</el-button>
		    <el-button type="success" @click="addrole">新增</el-button>
			<el-button @click="resetForm('deptform')">重置</el-button>
		  </el-form-item>
		</el-form>
		
		<el-table :data="tableData" border style="width: 100%">
			<el-table-column fixed type="index" label="序号" width="150">
			</el-table-column>
			<el-table-column prop="rcode" label="角色编码" width="120">
			</el-table-column>
			<el-table-column prop="rname" label="角色名称" width="120">
			</el-table-column>
			<el-table-column prop="rdesc" label="角色描述" width="120">
			</el-table-column>
			<el-table-column prop="rstate" label="角色状态" width="300">
				<template slot-scope="scope">
				   <el-tag type="warning" effect="dark" v-if="scope.row.rstate==-1">无效</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.rstate==0">有效</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="dname" label="角色部门" width="120">
			</el-table-column>
			<!-- <el-table-column prop="qname" label="权限设定" width="120">
			</el-table-column> -->
			<el-table-column fixed="right" label="操作" width="300">
				<template slot-scope="scope">
					<el-button @click="handleCancle(scope.row)" type="text" size="small">禁用</el-button>
					<el-button @click="handleOpen(scope.row)" type="text" size="small">启用</el-button>
					<el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
					<el-button @click="handleUpdate(scope.row)" type="text" size="small">编辑</el-button>
					<el-button @click="handlepermission(scope.row)" type="text" size="small">分配权限</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<!-- 分页 -->
		<el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :current-page="pageinfo.pageNum"
		      :page-sizes="[3, 10, 20, 100]"
		      :page-size="pageinfo.pageSize"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="pageinfo.total">
		</el-pagination>
		<!-- 新增角色 -->
		<el-dialog title="新增角色" :visible.sync="addiolog">
		  <el-form ref="addform" :model="addform" class="addsync">
			  <el-form-item label="角色名称" :label-width="formLabelWidth" prop="rname">
			    <el-input v-model="addform.rname" autocomplete="off"></el-input>
			  </el-form-item>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="角色描述" :label-width="formLabelWidth" prop="rdesc">
			  	    <el-input v-model="addform.rdesc" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="角色状态" :label-width="formLabelWidth" prop="rstate">
						<el-select v-model="addform.rstate" placeholder="请选择角色状态">
						  <el-option
						    v-for="item in states"
						    :key="item.value"
						    :label="item.label"
						    :value="item.value">
						  </el-option>
						</el-select>  
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="角色部门" :label-width="formLabelWidth" prop="deptno">
				<el-cascader
					v-model="addform.deptno"
					:options="depts"
					:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
					:show-all-levels="false"></el-cascader>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="addcancle">取 消</el-button>
		    <el-button type="primary" @click="addconfirm">确 定</el-button>
		  </div>
		</el-dialog>
		
		<el-dialog title="修改角色" :visible.sync="editdiolog">
		  <el-form ref="editform" :model="editform" class="addsync">
			  <el-form-item label="角色名称" :label-width="formLabelWidth" prop="rname">
			    <el-input v-model="editform.rname" autocomplete="off"></el-input>
			  </el-form-item>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="角色描述" :label-width="formLabelWidth" prop="rdesc">
			  	    <el-input v-model="editform.rdesc" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="角色状态" :label-width="formLabelWidth" prop="rstate">
						<el-select v-model="editform.rstate" placeholder="请选择角色状态">
						  <el-option
						    v-for="item in states"
						    :key="item.value"
						    :label="item.label"
						    :value="item.value">
						  </el-option>
						</el-select>  
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="角色部门" :label-width="formLabelWidth" prop="deptno">
				<el-cascader
					v-model="editform.deptno"
					:options="depts"
					:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
					:show-all-levels="false"></el-cascader>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="editcancle">取 消</el-button>
		    <el-button type="primary" @click="editconfirm">确 定</el-button>
		  </div>
		</el-dialog>
		<!-- 分配权限 -->
		<el-dialog
		  title="分配权限"
		  :visible.sync="dialogPermission"
		  width="30%">
		  
		  <el-tree
		    :data="treeData"
		    show-checkbox
		    node-key="menuId"
			ref="tree"
		    :default-expanded-keys="[2, 3]"
		    :default-checked-keys="[5]"
		    :props="defaultProps">
		  </el-tree>
		  
		  <span slot="footer" class="dialog-footer">
		    <el-button @click="dialogPermission = false">取 消</el-button>
		    <el-button type="primary" @click="PermissionConfirm">确 定</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				addiolog:false,
				dialogPermission:false,
				editdiolog:false,
				formLabelWidth: '120px',
				treeData:[],
				tableData: [],
				defaultProps: {
					children: 'children',
					label: 'menuName',
					children:'submenu'
				},
				deptform: {
				  deptno: '',
				  rstate: '',
				  rname:'',
				  rdesc:''
				},
				addform:{
					rname:'',
					rdesc:'',
					rstate:'',
					deptno:''
				},
				editform:{
					rname:'',
					rdesc:'',
					rstate:'',
					deptno:''
				},
				newrow:{},
				depts: [],
				states:[
					{value:-1,label:"无效"},
					{value:0,label:"有效"}
				],
				pageinfo:{
					pageNum:1,
					pageSize:10,
					total:0
				}
			}
		},

		methods: {
			deptquery() {
				var deptArray = this.deptform.deptno;
				var newdeptno;
				if(deptArray instanceof Array){
					for(var i=0;i<deptArray.length;i++){
					  newdeptno = deptArray[i];
					}  
					this.deptform.deptno = newdeptno;
				}
				console.log(this.deptform);
				this.editparam();
			},
			PermissionConfirm(){
				// let selectTree = this.$refs.tree.getCheckedNodes();
				let selectTree = this.$refs.tree.getCheckedKeys();
				let rid = this.newrow.rid;
				console.log(selectTree);
				this.$axios.put("crmSysrole/insertpers?rid="+rid,selectTree)
				.then(resp=>{
					console.log(resp);
				}).catch(error=>{console.log(error)})
				this.dialogPermission=false;
			},
			addrole(){
				this.addiolog=true;
			},
			addcancle(){
				this.addiolog=false;
				this.$refs['addform'].resetFields();
			},
			addconfirm(){
				this.addiolog=false;
				var deptArray = this.addform.deptno;
				var newdeptno;
				if(deptArray instanceof Array){
					for(var i=0;i<deptArray.length;i++){
					  newdeptno = deptArray[i];
					}  
					this.addform.deptno = newdeptno;
				}
				this.$axios.post("crmSysrole",this.addform)
				.then(resp=>{})
				.catch(error=>{console.log(error)})
			},
			editcancle(){
				this.editdiolog=false;
				this.$refs['editform'].resetFields();
			},
			editconfirm(){
				this.editdiolog=false;
				var deptArray = this.editform.deptno;
				var newdeptno;
				if(deptArray instanceof Array){
					for(var i=0;i<deptArray.length;i++){
					  newdeptno = deptArray[i];
					}  
					this.editform.deptno = newdeptno;
				}
				this.$axios.put("crmSysrole",this.editform)
				.then(resp=>{
					if(resp.code==20000){
						this.$message.success('修改角色信息成功'); 
					}
					this.editparam();
				})
				.catch(error=>{console.log(error)})
			},
			handlepermission(row){
				
				this.newrow = row;
				this.dialogPermission=true;
				this.getIds(row);
			},
			gettree(){
				this.$axios.get("menu/tree")
				.then(resp=>{
					if(resp.code==20000){
						this.treeData=resp.data.list;
					}
				}).catch(error=>{console.log(error)});
			},
			getIds(row){
				this.$axios.get("crmSysrole/selectIds?rid="+row.rid)
				.then(resp=>{
					console.log(resp);
					this.$refs.tree.setCheckedKeys(resp.data);
				})
				.catch(error=>{console.log(error)})
			},
			handleCancle(row) {
				row.rstate = -1;
				this.$axios.put("crmSysrole",row)
				.then(resp=>{
					if(resp.code==20000){
						this.$message.success('禁用成功'); 
					}
					this.editparam();
				}).catch(error=>{console.log(error)})
			},
			handleOpen(row) {
				row.rstate = 0;
				this.$axios.put("crmSysrole",row)
				.then(resp=>{
					if(resp.code==20000){
						this.$message.success('启用成功'); 
					}
					this.editparam();
				}).catch(error=>{console.log(error)})
			},
			handleDelete(row) {
				console.log(row);
				this.$axios.delete("crmSysrole/"+row.rid)
				.then(resp=>{
					if(resp.code==20000){
						this.$message.success('删除角色成功'); 
					}
					this.editparam();
				})
				.catch(error=>{console.log(error)})
			},
			handleUpdate(row) {
				this.editdiolog=true;
				this.editform = row;
				console.log(row);
			},
			handleSizeChange(val) {
				this.pageinfo.pageSize = val;
				this.editparam();
			},
			handleCurrentChange(val) {
				this.pageinfo.pageNum = val;
				this.editparam();
			},
			getdepts(){
				this.$axios.post("dept/userDeptno")
				.then(resp=>{
				  if(resp.code==20000){
					  this.depts = resp.data;
					  console.log(this.depts);
				  }
				}).catch(error=>{
				  console.log(error);
				})
			},
			getdata(param){
				this.$axios.get("crmSysrole/all?"+param)
				.then(resp=>{
					if(resp.code==20000){
						// for(var i=0;i<resp.data.list.length;i++){
						// 	let qid = "";
						// 	let qname = "";
						// 	let permissions = resp.data.list[i].crmSyspermissions;
						// 	for(var j=0;j<permissions.length;j++){
						// 		qid += permissions[j].qid+","
						// 		qname += permissions[j].qname+",";
						// 	}
						// 	resp.data.list[i].qid = qid;
						// 	resp.data.list[i].qname = qname;
						// }
						this.tableData = resp.data.list;
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}
				}).catch(error=>{console.log(error)})
			},
			editparam(){
				let param = this.$qs.stringify(this.deptform)+"&"+this.$qs.stringify(this.pageinfo);
				this.getdata(param);
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
		},
		mounted() {
			this.gettree();
			this.getdata("");
			this.getdepts();
		}
	}
</script>

<style>
</style>
