<template>
	<div>
		<el-form :inline="true" ref="permissionform" :model="permissionform" class="demo-form-inline">
			<el-form-item label="所有权限" prop="menuId">
			  <el-cascader
				v-model="permissionform.menuId"
				:options="permissions"
			  	:props="{ label: 'menuName', value: 'menuId',children:'submenu', checkStrictly: true}"
			  	:show-all-levels="false"></el-cascader>
			</el-form-item>
			
			<el-form-item label="权限状态" prop="menuState">
				<el-select v-model="permissionform.menuState" placeholder="请选择权限状态">
				  <el-option
					v-for="item in states"
					:key="item.value"
					:label="item.label"
					:value="item.value">
				  </el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="permissionquery">查询</el-button>
				<el-button type="success" @click="addpermission">新增</el-button>
				<el-button type="error" @click="outpermission">权限导出</el-button>
			</el-form-item>
		</el-form>
		
		<el-table :data="tableData" border style="width: 100%">
			<el-table-column fixed type="index" label="序号" width="150">
			</el-table-column>
			<el-table-column prop="menuName" label="权限名称" width="120">
			</el-table-column>
			<el-table-column prop="rname" label="角色名称" width="120">
			</el-table-column>
			<el-table-column prop="menuDesc" label="权限描述" width="120">
			</el-table-column>
			<el-table-column prop="menuState" label="权限状态" width="300">
				<template slot-scope="scope">
				   <el-tag type="warning" effect="dark" v-if="scope.row.menuState==-1">无效</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.menuState==0">有效</el-tag>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="300">
				<template slot-scope="scope">
					<el-button @click="handleCancle(scope.row)" type="text" size="small">禁用</el-button>
					<el-button @click="handleOpen(scope.row)" type="text" size="small">启用</el-button>
					<!-- <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button> -->
					<el-button @click="handleUpdate(scope.row)" type="text" size="small">编辑</el-button>
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
		
		<!-- 新增 -->
		<el-dialog title="新增权限" :visible.sync="addiolog">
		  <el-form ref="addform" :model="addform" class="addsync">
			  <el-form-item label="权限名称" :label-width="formLabelWidth" prop="menuName">
			    <el-input v-model="addform.menuName" autocomplete="off"></el-input>
			  </el-form-item>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="权限描述" :label-width="formLabelWidth" prop="menuDesc">
			  	    <el-input v-model="addform.menuDesc" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="上级权限" :label-width="formLabelWidth" prop="parentId">
						<el-cascader
							v-model="addform.parentId"
							:options="permissions"
							:props="{ label: 'menuName', value: 'menuId',children:'submenu', checkStrictly: true}"
							:show-all-levels="false"></el-cascader>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="可执行操作" :label-width="formLabelWidth" prop="menuHandle">
				<template>
				  <el-checkbox-group 
				    v-model="addform.menuHandle">
				    <el-checkbox v-for="h in handles" :key="h.hkey" :label="h.hkey">{{h.hvalue}}</el-checkbox>
				  </el-checkbox-group>
				</template>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="addcancle">取 消</el-button>
		    <el-button type="primary" @click="addconfirm">确 定</el-button>
		  </div>
		</el-dialog>
		
		<!-- 修改权限 -->
		<el-dialog title="修改权限" :visible.sync="editiolog">
		  <el-form ref="editform" :model="editform" class="addsync">
			  <el-form-item label="权限名称" :label-width="formLabelWidth" prop="menuName">
			    <el-input v-model="editform.menuName" autocomplete="off"></el-input>
			  </el-form-item>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="权限描述" :label-width="formLabelWidth" prop="menuDesc">
			  	    <el-input v-model="editform.menuDesc" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="上级权限" :label-width="formLabelWidth" prop="parentId">
						<el-cascader
							v-model="editform.parentId"
							:options="permissions"
							:props="{ label: 'menuName', value: 'menuId',children:'submenu', checkStrictly: true}"
							:show-all-levels="false"></el-cascader>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="可执行操作" :label-width="formLabelWidth" prop="menuHandle">
				<template>
				  <el-checkbox-group 
				    v-model="editform.menuHandle">
				    <el-checkbox v-for="h in handles" :key="h.hkey" :label="h.hkey">{{h.hvalue}}</el-checkbox>
				  </el-checkbox-group>
				</template>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="editcancle">取 消</el-button>
		    <el-button type="primary" @click="editconfirm">确 定</el-button>
		  </div>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
		  return {
			addiolog:false,
			editiolog:false,
			formLabelWidth: '120px',
			editform:{
				menuId:'',
				menuName:'',
				menuDesc:'',
				parentId:10,
				menuHandle:[]
			},
			addform:{
				menuName:'',
				menuDesc:'',
				parentId:10,
				menuHandle:[]
			},
			checkedHandles:[],
			handles:[
				{hkey:-1,hvalue:'凭证录入'},
				{hkey:0,hvalue:'凭证提交'},
				{hkey:1,hvalue:'凭证审核'}
			],
		    tableData: [],
			permissions:[],
			pageinfo:{
				pageNum:1,
				pageSize:10,
				total:0
			},
			permissionform:{
				menuId:'',
				menuState:''
			},
			states:[
				{value:-1,label:"无效"},
				{value:0,label:"有效"}
			],
		  }
		},
	    methods: {
			outpermission(){
				this.$axios.post("menu/out")
				.then(resp=>{
					if(resp.code==20000){
						this.$message.success("文件导出至:"+resp.data);
					}else{
						this.$message.error("操作失败");
					}
				}).catch(error=>{console.log(error)})
			},
			addpermission(){
				this.addiolog=true;
			},
			editcancle(){
				this.editiolog=false;
				this.$refs['editform'].resetFields();
			},
			editconfirm(){
				let handles = this.editform.menuHandle;
				let parentids = this.editform.parentId;
				let newhandle="";
				let newparentid=10;
				if(handles instanceof Array){
					for(var i=0;i<handles.length;i++){
						newhandle += handles[i]+",";
					}
				}
				if(parentids instanceof Array){
					for(var j=0;j<parentids.length;j++){
						newparentid = parentids[j];
					}
				}
				this.editform.menuHandle = newhandle;
				this.editform.parentId = newparentid;
				this.$axios.put("menu",this.editform)
				.then(resp=>{
					console.log(resp);
					if(resp.code==20000){
						this.$message.success('修改成功');
					}
				}).catch(error=>{console.log(error)})
				
				this.$nextTick(function(){
					this.$refs['editform'].resetFields();
				})
				this.editiolog=false;
			},
			addcancle(){
				this.addiolog=false;
				this.$refs['addform'].resetFields();
			},
			addconfirm(){
				console.log(this.addform);
				let handles = this.addform.menuHandle;
				let parentids = this.addform.parentId;
				let newhandle="";
				let newparentid;
				if(handles instanceof Array){
					for(var i=0;i<handles.length;i++){
						newhandle += handles[i]+",";
					}
				}
				if(parentids instanceof Array){
					for(var j=0;j<parentids.length;j++){
						newparentid = parentids[j];
					}
				}
				this.addform.menuHandle = newhandle;
				this.addform.parentId = newparentid;
				this.$axios.post("menu",this.addform)
				.then(resp=>{
					console.log(resp);
				}).catch(error=>{console.log(error)})
				this.getallpermissions();
				this.addiolog=false;
				this.$nextTick(function(){
					this.$refs['addform'].resetFields();
				})
			},
			permissionquery(){
				var idArray = this.permissionform.menuId;
				var newId;
				if(idArray instanceof Array){
					for(var i=0;i<idArray.length;i++){
					  newId = idArray[i];
					}  
					this.permissionform.menuId = newId;
				}
				this.editparam();
			},
			handleSizeChange(val) {
				this.pageinfo.pageSize = val;
				this.editparam();
			},
			handleCurrentChange(val) {
				this.pageinfo.pageNum = val;
				this.editparam();
			},	
	      handleClick(row) {
	        console.log(row);
	      },
		  handleCancle(row){
			  this.$axios.put("menu/changeState?menuState=-1&rid="+row.rid+"&"+"qid="+row.menuId)
			  .then(resp=>{
				  if(resp.code==20000){
					  this.$message.error('禁用成功');
					  this.editparam();
				  }
			  }).catch(error=>{console.log(error)})
		  },
		  handleOpen(row){
			  this.$axios.put("menu/changeState?menuState=0&rid="+row.rid+"&"+"qid="+row.menuId)
			  .then(resp=>{
				  if(resp.code==20000){
					  this.$message.success('启用成功');
					  this.editparam();
				  }
			  }).catch(error=>{console.log(error)})
		  },
		  handleDelete(row){},
		  handleUpdate(row){
			  let handles = row.menuHandle;
			  let handleArray;
			  if(handles!=null){
				  handleArray = handles.split(",");
			  }
			  for(var i=0;i<handleArray.length;i++){
				  this.editform.menuHandle[i] = parseInt(handleArray[i]);
			  }
			  this.editform.menuName = row.menuName;
			  this.editform.menuId = row.menuId;
			  this.editform.menuDesc = row.menuDesc;
			  this.editform.parentId = row.parentId;
			  this.editiolog=true;
			  
		  },
		  editparam(){
		  	let param = this.$qs.stringify(this.permissionform)+"&"+this.$qs.stringify(this.pageinfo);
		  	this.getparam(param);
		  },
		  getparam(param){
			  this.$axios.get("menu/permission?"+param)
			  .then(resp=>{
				  console.log(resp);
					this.tableData = resp.data.list;
					this.pageinfo.pageNum = resp.data.pageNum;
					this.pageinfo.pageSize = resp.data.pageSize;
					this.pageinfo.total = resp.data.total;
			  }).catch(error=>{console.log(error)})
		  },
		  getallpermissions(){
			  this.$axios.get("menu/tree")
			  .then(resp=>{
				  this.permissions = resp.data.list;
			  })
			  .catch(error=>{console.log(error)})
		  }
	    },
		mounted() {
			this.getparam("");
			this.getallpermissions();
		},
	  }
</script>

<style>
</style>
