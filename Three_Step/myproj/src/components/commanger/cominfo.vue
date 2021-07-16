<template>
	<div>
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>独角兽管理</el-breadcrumb-item>
				<el-breadcrumb-item>企业信息管理</el-breadcrumb-item>
		
			</el-breadcrumb>
		</div>
		<!-- 条件查询-->
		<el-form :inline="true" ref="queryform" :model="queryform" class="demo-form-inline" >
			
			<el-form-item label="企业名称" prop="companyName">
				<el-input v-model="queryform.companyName" placeholder="企业名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
				<el-button @click="myReset">重置</el-button>
				
				
			</el-form-item>
			<div style="margin-left:-35%;">
				<el-button type="success"  @click="myinsert">新增</el-button>
				
				<el-button type="success" :disabled="buttonstate" @click="mydeal">编辑挂单</el-button>
				<el-button type="success" :disabled="buttonstate" @click="myhistiry">历史融资</el-button>
				<el-button type="warning" :disabled="buttonstate" @click="myedit">修改</el-button>
			</div>
			
		</el-form>
		
		
		
		<!-- 展示页面-->
		
		
		<el-table  ref="singleTable" align="center"  :data="tableData" highlight-current-row   @current-change="handleRowChange"  style="width: 100%">
		
			<el-table-column property="companyName"  label="企业名称" width="200">
			</el-table-column>
		
			<el-table-column property="dealCode" align="center" label="交易代码" width="180">
			</el-table-column>
			</el-table-column>
			<el-table-column property="lastDeal" align="center" label="最近成交价格(每股)" width="200">
			</el-table-column>
			<el-table-column property="rate" align="center" label="费率"  width="180">
			</el-table-column>
			<el-table-column property="comOrder" align="center" label="顺序" width="150">
			</el-table-column>
		</el-table>
		
		<el-pagination @size-change="handleSizeChange" 
		@current-change="handleCurrentChange" 
		:current-page="pageInfo.page"
		 :page-sizes="[5, 10, 15, 20]" 
		 :page-size="pageInfo.pageSize" 
		 layout="total, sizes, prev, pager, next, jumper" 
		 :total="pageInfo.total">
		</el-pagination>
		
		<!-- 增加表单-->
		<el-dialog title="添加"  :visible.sync="addFormVisible">
			<el-form ref="addform" :model="cominfoform">
				<el-row>
					<el-col :span="10">
						<el-form-item label="企业名称" :label-width="formLabelWidth" prop="companyName">
							<el-input v-model="cominfoform.companyName" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="交易代码" :label-width="formLabelWidth" prop="dealCode">
							<el-input v-model="cominfoform.dealCode" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="企业logo" :label-width="formLabelWidth" prop="companyLogo">
							<el-upload
							  class="upload-demo"
							  action=""
							  :http-request="myupload"
							  :on-preview="handlePreview"
							  :on-remove="handleRemove"
							  :before-remove="beforeRemove"
							  multiple
							  :limit="1"
							  ref="upload"
							  :on-exceed="handleExceed"
							  :file-list="fileList">
							  <el-button  size="small" type="primary">点击上传</el-button>
							  <img v-if="cominfoform.companyLogo" :src="'http://localhost:8080/'+cominfoform.companyLogo" class="avatar">
							</el-upload>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="app端logo" :label-width="formLabelWidth" prop="appLogo">
							<el-upload
							  class="upload-demo"
							  action=""
							  :http-request="myuploadapp"
							  :on-preview="handlePreview"
							  :on-remove="handleRemove"
							  :before-remove="beforeRemove"
							  multiple
							  :limit="1"
							  ref="upload1"
							  :on-exceed="handleExceed"
							  :file-list="fileList">
							  <el-button  size="small" type="primary">点击上传</el-button>
							  <img v-if="cominfoform.appLogo" :src="'http://localhost:8080/'+cominfoform.appLogo" class="avatar">
							</el-upload>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="所属行业" :label-width="formLabelWidth" prop="industry">
							<el-input v-model="cominfoform.industry" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="成立年份" :label-width="formLabelWidth" prop="createYear">
							<el-input v-model="cominfoform.createYear" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="ceo" :label-width="formLabelWidth" prop="ceo">
							<el-input v-model="cominfoform.ceo" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="企业所在地" :label-width="formLabelWidth" prop="companyArea">
							<el-input v-model="cominfoform.companyArea" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="费率" :label-width="formLabelWidth" prop="rate">
							<el-input v-model="cominfoform.rate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="企业顺序" :label-width="formLabelWidth" prop="comOrder">
							<el-input v-model="cominfoform.comOrder" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="20">
						<el-form-item label="企业介绍" :label-width="formLabelWidth" prop="introduce">
							<el-input v-model="cominfoform.introduce" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>		
				</el-row>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addSumit">确 定</el-button>
			</div>
		</el-dialog>
		
		
		<!-- 修改表单-->
		<el-dialog title="修改"  :visible.sync="editFormVisible">
			<el-form ref="editform" :model="editinfoform">
				<el-row>
					<el-col :span="10">
						<el-form-item label="企业名称" :label-width="formLabelWidth" prop="companyName">
							<el-input v-model="editinfoform.companyName" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="交易代码" :label-width="formLabelWidth" prop="dealCode">
							<el-input v-model="editinfoform.dealCode" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="企业logo" :label-width="formLabelWidth" prop="companyLogo">
							<el-upload
							  class="upload-demo"
							  action=""
							  :http-request="myupload"
							  :on-preview="handlePreview"
							  :on-remove="handleRemove"
							  :before-remove="beforeRemove"
							  multiple
							  :limit="1"
							  :on-exceed="handleExceed"
							  :file-list="fileList">
							  <el-button  size="small" type="primary">点击上传</el-button>
							  <img v-if="editinfoform.companyLogo" :src="'http://localhost:8080/'+editinfoform.companyLogo" class="avatar">
							</el-upload>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="app端logo" :label-width="formLabelWidth" prop="appLogo">
							<el-upload
							  class="upload-demo"
							  action=""
							  :http-request="myuploadapp"
							  :on-remove="handleRemove"
							  :before-remove="beforeRemove"
							  multiple
							  :limit="1"
							  :on-exceed="handleExceed"
							  :file-list="fileList">
							  <el-button  size="small" type="primary">点击上传</el-button>
							  <img v-if="editinfoform.appLogo" :src="'http://localhost:8080/'+editinfoform.appLogo" class="avatar">
							</el-upload>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="所属行业" :label-width="formLabelWidth" prop="industry">
							<el-input v-model="editinfoform.industry" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="成立年份" :label-width="formLabelWidth" prop="createYear">
							<el-input v-model="editinfoform.createYear" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="ceo" :label-width="formLabelWidth" prop="ceo">
							<el-input v-model="editinfoform.ceo" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="企业所在地" :label-width="formLabelWidth" prop="companyArea">
							<el-input v-model="editinfoform.companyArea" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="费率" :label-width="formLabelWidth" prop="rate">
							<el-input v-model="editinfoform.rate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="企业顺序" :label-width="formLabelWidth" prop="comOrder">
							<el-input v-model="editinfoform.comOrder" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="20">
						<el-form-item label="企业介绍" :label-width="formLabelWidth" prop="introduce">
							<el-input v-model="editinfoform.introduce" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>		
				</el-row>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSumit">确 定</el-button>
			</div>
		</el-dialog>
		
		
		<!-- 挂单-->
		<el-dialog title="挂单" width="30%" :visible.sync="dealFormVisible">
			<el-form ref="dealform" :model="dealinfoform">
				<el-row>
					<el-col :span="20">
						<el-form-item label="买一价格" :label-width="formLabelWidth" prop="buyOne">
							<el-input v-model="dealinfoform.buyOne" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					</el-row>
				<el-row>
					<el-col :span="20">
						<el-form-item label="买二价格" :label-width="formLabelWidth" prop="buyTwo">
							<el-input v-model="dealinfoform.buyTwo" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="20">
						<el-form-item label="买三价格" :label-width="formLabelWidth" prop="buyThree">
							<el-input v-model="dealinfoform.buyThree" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>	
					<el-col :span="20">
						<el-form-item label="卖一价格" :label-width="formLabelWidth" prop="sellOne">
							<el-input v-model="dealinfoform.sellOne" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="20">
						<el-form-item label="卖二价格" :label-width="formLabelWidth" prop="sellTwo">
							<el-input v-model="dealinfoform.sellTwo" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>	
				<el-row>	
					<el-col :span="20">
						<el-form-item label="卖三价格" :label-width="formLabelWidth" prop="sellThree">
							<el-input v-model="dealinfoform.sellThree" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dealFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="dealSumit" v-show="isshow">添加</el-button>
				<el-button type="primary" @click="editDealSumit" v-show="isshow1">修改</el-button>
			</div>
		</el-dialog>
		
		<!-- //历史融资 -->
		<el-dialog title="历史融资" :visible.sync="historyTableVisible">
		  <el-table :data="historyData">
		    <el-table-column property="companyName" label="企业名称" width="150"></el-table-column>
		    <el-table-column property="investData" label="投资日期"  :formatter="dateFormat" width="200"></el-table-column>
		    <el-table-column property="investRound" label="投资轮"></el-table-column>
			<el-table-column property="investMoney" label="投资金额(百万)"></el-table-column>
			<el-table-column property="insertValuation" label="投资轮"></el-table-column>
			<el-table-column property="investRound" label="投后估值(百万)"></el-table-column>
			<el-table-column property="allShares" label="总发行股数(百万)"></el-table-column>
			<el-table-column property="sharesMoney" label="每股价格"></el-table-column>
			
		  </el-table>
		</el-dialog>
		
	</div>
</template>

<script>
	export default{
		data(){
			return{
				tableData:[],
				 fileList:[{
					 name:'',
					 url:'',
					 }],
				dealFormVisible:false,	 
				editFormVisible:false,
				addFormVisible:false,
				historyTableVisible:false,
				isshow:true,
				isshow1:true,
			    buttonstate:true,
				buttonstate1:true,
				historyData: [],
				queryform:{
					companyName:'',
				},
				currentRow: null,
				pageInfo: {
					page: 0,
					pageSize: 0,
					total: 0
				},
				cominfoform:{
					companyId:'',
					companyName:'',
					dealCode:'',
					lastDeal:'',
					rate:'',
					comOrder:'',
					companyLogo:'',
					appLogo:'',
					industry:'',
					createYear:'',
					ceo:'',
					companyArea:'',
					introduce:'',
				},
				editinfoform:{
					companyId:'',
					companyName:'',
					dealCode:'',
					lastDeal:'',
					rate:'',
					comOrder:'',
					companyLogo:'',
					appLogo:'',
					industry:'',
					createYear:'',
					ceo:'',
					companyArea:'',
					introduce:'',
				},
				dealinfoform:{
					buyOne:'',
					buyTwo:'',
					buyThree:'',
					sellOne:'',
					sellTwo:'',
					sellThree:'',
					companyId:'',
				},
				
				formLabelWidth: '150px',
				
			}
			
		},
		methods:{
			dateFormat(row, column) { //格式化时间
							var date = row[column.property];
							if (date === undefined) {
								return ''
							};
							return this.$moment(date).format("YYYY-MM-DD")
			},
			queryData(){//条件查询
				this.pageInfo.page = 1;
				let myprarm = this.$qs.stringify(this.pageInfo) + "&" + this.$qs.stringify(this.queryform);
				
				this.querycominfo(myprarm);
			},
			myReset(){ //
				this.$refs['queryform'].resetFields();
			},
			
			
			myinsert(){ //添加按钮
				this.addFormVisible=true;
				this.$nextTick(function() { /*渲染后执行 代码*/
					this.$refs['addform'].resetFields(); /* 不重置  之前添加的数据还在输入框内*/
					this.$refs.upload.clearFiles();
				    this.$refs.upload1.clearFiles();
				})
				
				
				
				
			},
			addSumit(){ //提交添加
			   this.addFormVisible = false;
			   console.log( this.$qs.stringify(this.cominfoform) )
			   
			   this.$axios.get("comInfo/insertInfo?"+ this.$qs.stringify(this.cominfoform))
			   .then(returnVal=>{
				   // console.log(returnVal)
				  if (returnVal.data.returnCode == 3000) {
				  	this.$message({
				  		message: returnVal.data.returnMsg,
				  		type: 'success'
				  	});
				  	this.querycominfo("");
				  } else if (returnVal.data.returnCode == 4000) {
				  	this.$message.error(returnVal.data.returnMsg);
				  }
			   }).catch(err => {
						console.log(err);
					})
			  
			},
			
			
			myedit(){
				this.editFormVisible=true;
				
				
			},
			editSumit(){ //修改
				this.editFormVisible = false;
				this.$axios.get("comInfo/updataCom?"+this.$qs.stringify(this.editinfoform))
				.then(returnVal=>{
					// console.log(returnVal)
					if (returnVal.data.returnCode == 3000) {
						this.$message({
							message: returnVal.data.returnMsg,
							type: 'success'
						});
						this.querycominfo("");
					} else if (returnVal.data.returnCode == 4000) {
					this.$message.error(returnVal.data.returnMsg);
					}
					
				}).catch(err => {
						console.log(err);
					})
			},
			
			mydeal(){
				this.dealFormVisible=true;
			},
			dealSumit(){
				this.dealFormVisible=false;
				 this.dealinfoform.companyId=this.currentRow.companyId
				console.log(this.$qs.stringify(this.dealinfoform))
				this.$axios.get("comInfo/insertDealInfo?"+this.$qs.stringify(this.dealinfoform))
				.then(returnVal=>{
					if (returnVal.data.returnCode == 3000) {
						this.$message({
						         message: returnVal.data.returnMsg,
						         type: 'success'
						       });
						this.querycominfo("");	   
					}else if(returnVal.data.returnCode == 4000){
							 this.$message.error(returnVal.data.returnMsg);
						}
				}).catch(err => {
						console.log(err);
					})
			},
			editDealSumit(){
				this.dealFormVisible=false;
				this.dealinfoform.companyId=this.currentRow.companyId
				this.$axios.get("comInfo/editDeal?"+this.$qs.stringify(this.dealinfoform))
				.then(returnVal=>{
					if (returnVal.data.returnCode == 3000) {
						this.$message({
						         message: returnVal.data.returnMsg,
						         type: 'success'
						       });
						this.querycominfo("");	   
					}else if(returnVal.data.returnCode == 4000){
							 this.$message.error(returnVal.data.returnMsg);
						}
				}).catch(err => {
						console.log(err);
					})
			},
			
			
			myhistiry(){
				this.historyTableVisible=true;
				
			},
			
			
			
			
			
			myupload(param){
				let formData = new FormData();
					formData.append("myfile",param.file);
					this.$axios.post("upload",formData,{headers:{"Content-Type":"multipart/form-data"}})
					.then(resp=>{
					console.log(resp);
					this.cominfoform.companyLogo = resp.data.imgsrc;
					this.editinfoform.companyLogo=resp.data.imgsrc;
								}).catch(err => {
						console.log(err);
					})
			},
			
			myuploadapp(param){
				let formData = new FormData();
					formData.append("myfile",param.file);
					this.$axios.post("upload",formData,{headers:{"Content-Type":"multipart/form-data"}})
					.then(resp=>{
					console.log(resp);
					this.cominfoform.appLogo = resp.data.imgsrc;
					this.editinfoform.appLogo = resp.data.imgsrc;
					}).catch(err => {
						console.log(err);
					})
			},
			
			
			
			
			handleRemove(file, fileList) {
			        console.log(file, fileList);
			      },
			handlePreview(file) {
			        console.log(file);
			      },
			handleExceed(files, fileList) {
			        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
			      },
			beforeRemove(file, fileList) {
			        // return this.$confirm(`确定移除 ${ file.name }？`);
			      },
			
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			
			handleSizeChange(val) { //改变每页展示的数据
			
				this.buttonstate = true;
				this.buttonstate1=true;
				console.log(`每页 ${val} 条`);
				this.pageInfo.pageSize = val;
				this.pageInfo.page = 1;
				/* console.log(this.$qs.stringify(this.pageInfo)); */
			
				this.querycominfo(this.$qs.stringify(this.pageInfo))
			},
			handleCurrentChange(val) { //改变页数
				this.buttonstate=true;
				this.buttonstate1=true;
				console.log(`当前页: ${val}`);
				// console.log(this.editform)
				this.pageInfo.page = val;
				console.log(this.$qs.stringify(this.pageInfo))
				this.querycominfo(this.$qs.stringify(this.pageInfo));
			},
			
			
			
			handleRowChange(val){ //点击行数显示此行信息
				this.currentRow=val;
				console.log(val)
				if(this.currentRow!=null){
					 this.editinfoform=JSON.parse(JSON.stringify(this.currentRow))
					this.buttonstate=false;
					 
				}
				this.$axios.get("comInfo/queryDealInfo?companyId="+this.editinfoform.companyId)
				.then(returnVal=>{
					// console.log(returnVal)
					if(returnVal.data.returnCode==4000){
						this.isshow=true;
						this.isshow1=false;
						// this.buttonstate=false;
						Object.keys(this.dealinfoform).forEach(key => (this.dealinfoform[key] = ''));
					}else if(returnVal.data.returnCode==3000){
						 this.isshow=false;
						 this.isshow1=true;
						 // this.buttonstate=false;
						 this.dealinfoform=returnVal.data.returnData
						 
					}
				}).catch(err => {
						console.log(err);
					});
				
				this.$axios.get("comInfo/queryHis?companyId="+this.editinfoform.companyId)
				.then(returnVal=>{
					if(returnVal.data.returnCode==4000){
						
						// Object.keys(this.netform).forEach(key => (this.netform[key] = ''));
						this.historyData=[];
					}else if(returnVal.data.returnCode==3000){
						
						this.historyData=returnVal.data.returnData
					}
					
				}).catch(err => {
						console.log(err);
					})
			   
				
			},
			querycominfo(param){
				
				this.$axios.get("comInfo/queryCom?"+param)
				.then(returnVal=>{
					
					this.tableData=returnVal.data.returnData;
					this.pageInfo=returnVal.data.pageInfo;
				}).catch(err => {
						console.log(err);
					})
			},
		},
		mounted() {
			this.querycominfo("");
			
		},
		watch: {
			/* 监控tableData的数据的改变 ，改变后执行自己需要的代码 */
			tableData: function() {
				this.$nextTick(function() { /* 可能出现渲染不及时，所有用nextTick方法来推迟运行。  也可以用watch监控数据更新，然后进行自己的操作（watch 与method，data同级）*/
					this.buttonstate = true;
					this.buttonstate1 = true;
				})
			}
		}
	}
</script>
      

<style>
	hr {
		margin-bottom: 15px;
	}
	
	element.style {
		padding-top: 5px;
		padding-left: 5px;
		padding-right: 5px;
		padding-bottom: 5px;
	}
	
	.el-dialog__header {
		text-align: left;
	}
	
	.el-main {
	
		line-height: 40px;
	}
	
	.el-select {
	
		width: 100%;
	}
	
	.el-date-editor.el-input,
	.el-date-editor.el-input__inner {
		width: 100%;
	}
	
	.el-dialog {
	
		width: 80%;
	}
	.avatar {
		width: 80px;
		height: 80px;
		display: block;
	}
</style>
