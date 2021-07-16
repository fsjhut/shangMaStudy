<template>
	<div>
		<el-form :inline="true" :model="formInline" ref="formInline" class="demo-form-inline">
		  <el-form-item label="部门" prop="deptno">
		    <el-cascader
		        v-model="formInline.deptno"
		        :options="depts"
				:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
				:show-all-levels="false"
		        @change="handleChange"></el-cascader>
		  </el-form-item>
		  <el-form-item prop="ustate">
				<el-select v-model="formInline.ustate" placeholder="请选择用户状态">
			      <el-option
			        v-for="item in states"
			        :key="item.value"
			        :label="item.label"
			        :value="item.value">
			      </el-option>
				</el-select>
		  </el-form-item>
		  <el-form-item prop="ujob">
				<el-select v-model="formInline.ujob" placeholder="请选择职务">
				  <el-option
					v-for="item in jobs"
					:key="item.value"
					:label="item.label"
					:value="item.value">
				  </el-option>
				</el-select>
		  </el-form-item>
		  <el-form-item prop="rid">
				<el-select v-model="formInline.rid" placeholder="请选择角色">
				  <el-option
					v-for="item in roles"
					:key="item.rid"
					:label="item.rname"
					:value="item.rid">
				  </el-option>
				</el-select>
		  </el-form-item>
		  <el-form-item prop="uname">
				<el-select v-model="formInline.uname" placeholder="请选择登录名">
				  <el-option
					v-for="item in unames"
					:label="item"
					:value="item">
				  </el-option>
				</el-select>
		  </el-form-item>
		  <el-form-item prop="usex">
				<el-select v-model="formInline.usex" placeholder="请选择性别">
				  <el-option
					v-for="item in usexs"
					:key="item.value"
					:label="item.label"
					:value="item.value">
				  </el-option>
				</el-select>
		  </el-form-item>
		  <el-form-item>
		    <el-button type="primary" @click="onSubmit">查询</el-button>
		    <el-button @click="resetForm('formInline')">重置</el-button>
			<el-button type="success" @click="adduser">添加</el-button>
		  </el-form-item>
		</el-form>
		
		<el-table :data="tableData" border style="width: 100%">
			<el-table-column fixed type="index" label="序号" width="150">
			</el-table-column>
			<el-table-column prop="uname" label="用户登录名" width="120">
			</el-table-column>
			<el-table-column prop="realname" label="用户姓名" width="120">
			</el-table-column>
			<el-table-column prop="dname" label="归属部门" width="300">
			</el-table-column>
			<el-table-column prop="sexvalue" label="用户性别" width="120">
				<template slot-scope="scope">
				   <el-tag type="success" effect="dark" v-if="scope.row.sexvalue==0">男</el-tag>
				   <el-tag type="primary" effect="dark" v-if="scope.row.sexvalue==1">女</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="ustate" label="用户状态" width="200">
				<template slot-scope="scope">
				   <el-tag type="warning" effect="dark" v-if="scope.row.ustate==-1">无效</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.ustate==0">有效</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="ujob" label="用户职务" width="160">
				<template slot-scope="scope">
				   <el-tag type="info" effect="dark" v-if="scope.row.ujob==0">员工</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.ujob==1">经理</el-tag>
				   <el-tag type="error" effect="dark" v-if="scope.row.ujob==2">处长</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="uphone" label="手机号码" width="120">
			</el-table-column>
			<el-table-column prop="uemail" label="用户邮箱" width="120">
			</el-table-column>
			<el-table-column prop="rname" label="所属角色" width="120">
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="180">
				<template slot-scope="scope">
					<el-button @click="handlecancle(scope.row)" type="text" size="small">禁用</el-button>
					<el-button @click="handleopen(scope.row)" type="text" size="small">启用</el-button>
					<el-button @click="handledit(scope.row)" type="text" size="small">编辑</el-button>
					<el-button @click="handldelete(scope.row)" type="text" size="small">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<!-- 分页 -->
		<el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :current-page="pageinfo.pageNum"
		      :page-sizes="[5, 10, 20, 100]"
		      :page-size="pageinfo.pageSize"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="pageinfo.total">
		</el-pagination>
		<!-- 增加用户模态框 -->
		<el-dialog title="新增用户" :visible.sync="adddiolog">
		  <el-form ref="addform" :model="addform" class="addsync">
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户登录名" :label-width="formLabelWidth" prop="uname">
			  	    <el-input v-model="addform.uname" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户姓名" :label-width="formLabelWidth" prop="realname">
			  	    <el-input v-model="addform.realname" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="归属部门" :label-width="formLabelWidth" prop="deptno">
			  	    <el-cascader
			  	        v-model="addform.deptno"
			  	        :options="depts"
			  	    	:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
			  	    	:show-all-levels="false"
			  	        @change="handleChange"></el-cascader>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户密码" :label-width="formLabelWidth" prop="upassword">
			  	    <el-input v-model="addform.upassword" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户性别" :label-width="formLabelWidth" prop="usex">
			  	    <el-select v-model="addform.usex" placeholder="请选择性别">
			  	      <el-option
						v-for="item in usexs"
						:key="item.value"
						:label="item.label"
						:value="item.value">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户状态" :label-width="formLabelWidth" prop="ustate">
			  	    <el-select v-model="addform.ustate" placeholder="请选择用户状态">
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
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户职务" :label-width="formLabelWidth" prop="ujob">
			  	    <el-select v-model="addform.ujob" placeholder="请选择职务">
			  	      <el-option
						v-for="item in jobs"
						:key="item.value"
						:label="item.label"
						:value="item.value">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="手机号" :label-width="formLabelWidth" prop="uphone">
			  	    <el-input v-model="addform.uphone" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="所属角色" :label-width="formLabelWidth" prop="rid">
			  	    <el-select v-model="addform.rid" placeholder="请选择角色">
			  	      <el-option
						v-for="item in roles"
						:key="item.rid"
						:label="item.rname"
						:value="item.rid">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户邮箱" :label-width="formLabelWidth" prop="uemail">
			  	    <el-input v-model="addform.uemail" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="用户备注" :label-width="formLabelWidth">
			    <el-input v-model="addform.udesc" autocomplete="off"></el-input>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="addcancle">取 消</el-button>
			<el-button @click="resetForm('addform')">重置</el-button>
		    <el-button type="primary" @click="addconfirm">确 定</el-button>
		  </div>
		</el-dialog>
		<!-- 修改用户模态框 -->
		<el-dialog title="修改用户" :visible.sync="editdiolog">
		  <el-form ref="editform" :model="editform" class="addsync">
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户登录名" :label-width="formLabelWidth" prop="uname">
			  	    <el-input v-model="editform.uname" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户姓名" :label-width="formLabelWidth" prop="realname">
			  	    <el-input v-model="editform.realname" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="归属部门" :label-width="formLabelWidth" prop="deptno">
			  	    <el-cascader
			  	        v-model="editform.deptno"
			  	        :options="depts"
			  	    	:props="{ label: 'dname', value: 'deptno',children:'deptList', checkStrictly: true}"
			  	    	:show-all-levels="false"
			  	        @change="handleChange"></el-cascader>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户密码" :label-width="formLabelWidth" prop="upassword">
			  	    <el-input v-model="editform.upassword" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户性别" :label-width="formLabelWidth" prop="usex">
			  	    <el-select v-model="editform.usex" placeholder="请选择性别">
			  	      <el-option
						v-for="item in usexs"
						:key="item.value"
						:label="item.label"
						:value="item.value">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户状态" :label-width="formLabelWidth" prop="ustate">
			  	    <el-select v-model="editform.ustate" placeholder="请选择用户状态">
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
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="用户职务" :label-width="formLabelWidth" prop="ujob">
			  	    <el-select v-model="editform.ujob" placeholder="请选择职务">
			  	      <el-option
						v-for="item in jobs"
						:key="item.value"
						:label="item.label"
						:value="item.value">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="手机号" :label-width="formLabelWidth" prop="uphone">
			  	    <el-input v-model="editform.uphone" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-row>
			    <el-col :span="12">
			  	  <el-form-item label="所属角色" :label-width="formLabelWidth" prop="rid">
			  	    <el-select v-model="editform.rid" placeholder="请选择角色">
			  	      <el-option
						v-for="item in roles"
						:key="item.rid"
						:label="item.rname"
						:value="item.rid">
			  	      </el-option>
			  	    </el-select>
			  	  </el-form-item>
			    </el-col>
			    <el-col :span="12">
			  	  <el-form-item label="用户邮箱" :label-width="formLabelWidth" prop="uemail">
			  	    <el-input v-model="editform.uemail" autocomplete="off"></el-input>
			  	  </el-form-item>
			    </el-col>
			  </el-row>
			  <el-form-item label="用户备注" :label-width="formLabelWidth">
			    <el-input v-model="editform.udesc" autocomplete="off"></el-input>
			  </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="editcancle">取 消</el-button>
			<el-button @click="resetForm('editform')">重置</el-button>
		    <el-button type="primary" @click="editconfirm">确 定</el-button>
		  </div>
		</el-dialog>
	</div>
</template>

<script>
	export default {
	    methods: {
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
			  this.$axios.put("sysuser",this.editform)
			  .then(resp=>{
				  console.log(resp);
				  if(resp.code==20000){
					  this.$message.success('修改用户成功');
					  this.editparam();
				  }
			  }).catch(error=>{
				  console.log(error);
			  })
		  },
		  addcancle(){
			  this.adddiolog=false;
			  this.$refs['addform'].resetFields();
		  },
		  addconfirm(){
			  this.adddiolog=false;
			  var deptArray = this.addform.deptno;
			  var newdeptno;
			  for(var i=0;i<deptArray.length;i++){
				  newdeptno = deptArray[i];
			  }
			  this.addform.deptno = newdeptno;
			  this.$axios.post("sysuser",this.addform)
			  .then(resp=>{
				  if(resp.code==20000){
					  this.$message.success('添加用户成功');
					  this.editparam();
				  }
			  }).catch(error=>{
				  console.log(error);
			  })
		  },
		  resetForm(formName) {
			this.$refs[formName].resetFields();
		  },
		  handleSizeChange(val) {
			  this.pageinfo.pageSize = val;
			  let param = this.$qs.stringify(this.formInline)+"&"+this.$qs.stringify(this.pageinfo);
			  this.getdata(param);
		  },
		  handleCurrentChange(val) {
			  this.pageinfo.pageNum = val;
			  let param = this.$qs.stringify(this.formInline)+"&"+this.$qs.stringify(this.pageinfo);
			  this.getdata(param);
		  },
		  handldelete(row){
			  console.log(row.uid);
			  let uid = row.uid;
			  this.$axios.delete("sysuser/del/"+uid)
			  .then(resp=>{
				  console.log(resp);
				  if(resp.code==20000){
					this.$message.success('删除用户成功');  
				  }
				  this.editparam();
			  }).catch(error=>{console.log(error)})
		  },
		  //编辑用户信息
		  handledit(row){
			this.editdiolog=true;
			this.editform = row;
			console.log(row);
		  },
		  handleopen(row){
			let uid = row.uid;
			this.$axios.get("sysuser/open/"+uid)
			.then(resp=>{
				this.editparam();
			}).catch(error=>{
				console.log(error);
			})  
		  },
	      handlecancle(row) {
			let uid = row.uid;
			this.$axios.get("sysuser/forbidden/"+uid)
			.then(resp=>{
				this.editparam();
			}).catch(error=>{
				console.log(error);
			})
	      },
		  handleChange(value) {
			console.log(value);
		  },
		  adduser(){
			  this.adddiolog=true;
		  },
		  getdata(param){
			  this.$axios.get("sysuser/all?"+param)
			  .then(resp=>{
				  this.tableData = resp.data.list;
				  this.pageinfo.pageNum = resp.data.pageNum;
				  this.pageinfo.pageSize = resp.data.pageSize;
				  this.pageinfo.total = resp.data.total;
			  }).catch(error=>{
				  console.log(error);
			  })
		  },
		  onSubmit() {
			  let deptArray = this.formInline.deptno;
			  let newdeptno;
			  if(deptArray instanceof Array){
				for(var i=0;i<deptArray.length;i++){
				  newdeptno = deptArray[i];
				}  
			  }
			  this.formInline.deptno = newdeptno;
			  let param = this.$qs.stringify(this.formInline)+"&"+this.$qs.stringify(this.pageinfo);
			  this.getdata(param);
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
		  editparam(){
			let param = this.$qs.stringify(this.formInline)+"&"+this.$qs.stringify(this.pageinfo);
			this.getdata(param);
		  },
		  getroles(){
			  this.$axios.get("crmSysrole/list")
			  .then(resp=>{
				  this.roles = resp.data.list;
				  console.log(this.roles);
			  }).catch(error=>{console.log(error)})
		  },
		  getusers(){
			  this.$axios.get("sysuser/list")
			  .then(resp=>{
				  let users = resp.data;
				  for(var i=0;i<users.length;i++){
					  this.unames[i] = users[i].uname;
				  }
			  }).catch(error=>{console.log(error)})
		  }
	    },
		mounted() {
			this.getdata("");
			this.getdepts();
			this.getroles();
			this.getusers();
		},
	
	    data() {
	      return {
			adddiolog:false,
			editdiolog:false,
			formLabelWidth: '120px',
		    addform:{
				uname:'',
				realname:'',
				deptno:'',
				upassword:'',
				usex:'',
				ustate:'',
				ujob:'',
				uphone:'',
				uemail:'',
				udesc:'',
				rid:''
		    },
			editform:{
				uname:'',
				realname:'',
				deptno:'',
				upassword:'',
				usex:'',
				ustate:'',
				ujob:'',
				uphone:'',
				uemail:'',
				udesc:'',
				rid:''
			},
	        tableData: [],
			pageinfo:{
				pageNum:1,
				pageSize:5,
				total:0
			},
			formInline: {
			  deptno:'',
			  ustate:'',
			  ujob:'',
			  rid:'',
			  uname:'',
			  usex:''
			},
			depts: [],
			value: [],
			states:[
				{value:-1,label:"无效"},
				{value:0,label:"有效"}
			],
			jobs:[
				{value:0,label:"员工"},
				{value:1,label:"经理"},
				{value:2,label:"处长"}
			],
			roles:[],
			unames:[],
			usexs:[
				{value:0,label:'男'},
				{value:1,label:'女'}
			]
	      }
	    }
	  }
</script>

<style>
	.addsync{
		width: 88%;
	}
	.el-select {
	    width: 100%;
	}
	.el-cascader{
		width: 100%;
	}
</style>
