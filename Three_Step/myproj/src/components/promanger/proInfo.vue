<template>
	
	<div >
		
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>产品管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品基础信息管理</el-breadcrumb-item>
		
			</el-breadcrumb>
		</div>
		<!-- 条件查询-->
		<el-form :inline="true" ref="queryfrom" :model="queryfrom" class="demo-form-inline">
			<el-form-item label="产品名称" prop="productName">
				<el-input v-model="queryfrom.productName" placeholder="产品名称"></el-input>
			</el-form-item>
			<el-form-item label="产品类别" prop="productSecCategory">
				<el-select v-model="queryfrom.productSecCategory" placeholder="产品类别">
					<el-option v-for="query in categoryQuery" :label="query.name" :value="query.name"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="审核状态" prop="reviewState">
				<el-select v-model="queryfrom.reviewState" placeholder="审核状态">
					<el-option v-for="query in stateQuery" :label="query.name" :value="query.name"></el-option>
				</el-select>
			</el-form-item>

			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
				<el-button @click="myReset">重置</el-button>
				
			</el-form-item>
			<div style="margin-left:-47%;">
				<el-button type="success"  @click="myAdd">新增</el-button>
				<el-button type="success" :disabled="buttonstate" @click="myNetValue">净值管理</el-button>
				<el-button type="warning" :disabled="buttonstate" @click="myEdit">修改</el-button>
				
			</div>
		</el-form>

		<!-- 展示页面-->
		<el-table ref="singleTable" 
		:data="tableData" 
		highlight-current-row 
		@current-change="handleRowChange" 
		style="width: 100%"
		align="center">

			<el-table-column property="productName" align="center" label="产品名称" width="200">
			</el-table-column>
			<el-table-column property="productCategoryName" align="center" label="产品系列" width="200">
			</el-table-column>
			<el-table-column property="productSecCategory" align="center" label="二级分类" width="180">
			</el-table-column>
			</el-table-column>
			<el-table-column property="opDate" label="开放时间" align="center" :formatter="dateFormat" width="200" >
			</el-table-column>
			<el-table-column property="fundCurrency" align="center" label="币种" width="180">
			</el-table-column>
			<el-table-column property="reviewState" align="center" label="审核状态" width="180">
				<template slot-scope="scope">
				      <el-tag :type="scope.row.reviewState=='已通过'?'success':(scope.row.reviewState=='审核中'?'warning':'danger')">{{scope.row.reviewState}}</el-tag>
				    </template>
			</el-table-column>
		</el-table>

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.page"
		 :page-sizes="[5, 10, 15, 20]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>

		<!-- 增加表单-->
		<el-dialog title="产品详情"  :visible.sync="addFormVisible">
			<el-form ref="addform" :model="proform">
				<span>基本信息</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品系列" :label-width="formLabelWidth" prop="productCategoryName">
							<el-select v-model="proform.productCategoryName" placeholder="产品系列" @change="getSeriesName()">
								<el-option v-for="query in series" :label="query.sname" :value="query.sname"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="二级分类" :label-width="formLabelWidth" prop="productSecCategory">
							<el-select v-model="proform.productSecCategory" placeholder="产品类别" >
								<el-option v-for="query in categoryQuery" :label="query.name" :value="query.name"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品名称" :label-width="formLabelWidth" prop="productName">
							<el-input v-model="proform.productName" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="管理机构" :label-width="formLabelWidth" prop="companyName">
							<el-input v-model="proform.companyName" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="年化收益率" :label-width="formLabelWidth" prop="annualized">
							<el-input v-model="proform.annualized" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="货币类型" :label-width="formLabelWidth" prop="fundCurrency">
							<el-select v-model="proform.fundCurrency" placeholder="货币类型" >
								<el-option v-for="query in myFundCurrency" :label="query.name" :value="query.name"></el-option>
							</el-select>
							
							<!-- <el-input v-model="proform.fundCurrency" autocomplete="off"></el-input> -->
						</el-form-item>
					</el-col>
				</el-row>
				<span>认购属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="开放日期" :label-width="formLabelWidth" prop="opDate">
							<el-date-picker 
							v-model="proform.opDate" 
							type="date" 
							placeholder="选择日期"
							format="yyyy 年 MM 月 dd 日"
							value-format="yyyy-MM-dd">
							 
							</el-date-picker>
							<!-- <el-input v-model="proform.opDate" autocomplete="off"></el-input> -->
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购周期" :label-width="formLabelWidth" prop="subscriptionDate">
							<el-input v-model="proform.subscriptionDate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="基金管理费率" :label-width="formLabelWidth" prop="relativeManageCost">
							<el-input v-model="proform.relativeManageCost" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费率" :label-width="formLabelWidth" prop="subscriptionRate">
							<el-input v-model="proform.subscriptionRate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="起投金额" :label-width="formLabelWidth" prop="startAmount">
							<el-input v-model="proform.startAmount" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费收取方式" :label-width="formLabelWidth" prop="chargeMode">
							<el-input v-model="proform.chargeMode" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<span>赎回属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回周期" :label-width="formLabelWidth" prop="redemingCycle">
							<el-input v-model="proform.redemingCycle" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="赎回起始金额" :label-width="formLabelWidth" prop="redemingMoney">
							<el-input v-model="proform.redemingMoney" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回费" :label-width="formLabelWidth" prop="redemingRate">
							<el-input v-model="proform.redemingRate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="锁定期" :label-width="formLabelWidth" prop="redemingLockUp">
							<el-input v-model="proform.redemingLockUp" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="审核人" :label-width="formLabelWidth" prop="reviewer">
							<el-select v-model="proform.reviewer" placeholder="审核人">
								<el-option v-for="query in allmanger" :label="query.uname" :value="query.uname"></el-option>
							</el-select>
							
							<!-- <el-input v-model="proform.reviewer" autocomplete="off"></el-input> -->
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
		<el-dialog title="产品详情"  :visible.sync="editFormVisible">
			<el-form ref="myeditform" :model="editform">
				<span>基本信息</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品系列" :label-width="formLabelWidth" prop="productCategoryName">
							<el-select v-model="editform.productCategoryName" placeholder="产品系列" @change="getComName()">
								<el-option v-for="query in series" :label="query.sname" :value="query.sname"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="二级分类" :label-width="formLabelWidth" prop="productSecCategory">
							<el-select v-model="editform.productSecCategory" placeholder="产品类别" >
								<el-option v-for="query in categoryQuery" :label="query.name" :value="query.name"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品名称" :label-width="formLabelWidth" prop="productName">
							<el-input v-model="editform.productName" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="管理机构" :label-width="formLabelWidth" prop="companyName">
							<el-input v-model="editform.companyName" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="年化收益率" :label-width="formLabelWidth" prop="annualized">
							<el-input v-model="editform.annualized" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="货币类型" :label-width="formLabelWidth" prop="fundCurrency">
							<el-select v-model="editform.fundCurrency" placeholder="货币类型" >
								<el-option v-for="query in myFundCurrency" :label="query.name" :value="query.name"></el-option>
							</el-select>
							
							<!-- <el-input v-model="proform.fundCurrency" autocomplete="off"></el-input> -->
						</el-form-item>
					</el-col>
				</el-row>
				<span>认购属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="开放日期" :label-width="formLabelWidth" prop="opDate">
							  <el-date-picker
							      v-model="editform.opDate"
							      type="date"
							      placeholder="选择日期"
								  value-format="yyyy-MM-dd">
							    </el-date-picker>
							<!-- <el-input v-model="proform.opDate" autocomplete="off"></el-input> -->
						</el-form-item>
						
						<!-- <el-form-item label="开放日期" :label-width="formLabelWidth" prop="opDate">
							<el-date-picker
							 v-model="editform.opDate" 
							 type="date" 
							 placeholder="选择日期" 
							 format="yyyy 年 MM 月 dd 日"
							 value-format="yyyy-MM-dd">
							 
							</el-date-picker> 
							
						</el-form-item> -->
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购周期" :label-width="formLabelWidth" prop="subscriptionDate">
							<el-input v-model="editform.subscriptionDate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="基金管理费率" :label-width="formLabelWidth" prop="relativeManageCost">
							<el-input v-model="editform.relativeManageCost" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费率" :label-width="formLabelWidth" prop="subscriptionRate">
							<el-input v-model="editform.subscriptionRate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="起投金额" :label-width="formLabelWidth" prop="startAmount">
							<el-input v-model="editform.startAmount" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费收取方式" :label-width="formLabelWidth" prop="chargeMode">
							<el-input v-model="editform.chargeMode" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<span>赎回属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回周期" :label-width="formLabelWidth" prop="redemingCycle">
							<el-input v-model="editform.redemingCycle" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="赎回起始金额" :label-width="formLabelWidth" prop="redemingMoney">
							<el-input v-model="editform.redemingMoney" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回费" :label-width="formLabelWidth" prop="redemingRate">
							<el-input v-model="editform.redemingRate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="锁定期" :label-width="formLabelWidth" prop="redemingLockUp">
							<el-input v-model="editform.redemingLockUp" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="审核人" :label-width="formLabelWidth" prop="reviewer">
						<el-select v-model="editform.reviewer" placeholder="审核人">
							<el-option v-for="query in allmanger" :label="query.uname" :value="query.uname"></el-option>
						</el-select>
						</el-form-item>
					</el-col>
				</el-row>
		
		
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSumit">确 定</el-button>
			</div>
		</el-dialog>
		
		
		<!-- 净值管理-->
		<el-dialog title="净值管理"  :visible.sync="netFormVisible">
			<el-form ref="mynetform" :model="netform">
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品名称" :label-width="formLabelWidth" prop="productCategoryName">
						<el-input v-model="netform.productName" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="单位净值" :label-width="formLabelWidth" prop="productSecCategory">
						<el-input v-model="netform.unitNet" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="基准净值日" :label-width="formLabelWidth" prop="productName">
							
							
							<el-date-picker
							 v-model="netform.baseDate" 
							 type="date" 
							 
							 placeholder="选择日期"
							 value-format="yyyy-MM-dd">
							 
							</el-date-picker> 
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="累计增长率" :label-width="formLabelWidth" prop="companyName">
							<el-input v-model="netform.increaseRate" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="netFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="netSumit" v-show="isshow">添加</el-button>
				<el-button type="primary" @click="editNetSumit" v-show="isshow1">修改</el-button>
			</div>
		</el-dialog>

	</div>

</template>

<script>
	export default {
		data() {
			return {
				isshow:true,
				isshow1:true,
				dialogTableVisible: false,
				addFormVisible: false,
				editFormVisible:false,
				netFormVisible:false,
				buttonstate:true,
				
				proform: {
					productCategoryName: '',
					productSecCategory: '',
					productName: '',
					companyName: '',
					annualized: '',
					fundCurrency: '',
					opDate: '',
					subscriptionDate: '',
					relativeManageCost: '',
					subscriptionRate: '',
					startAmount: '',
					chargeMode: '',
					redemingCycle: '',
					redemingMoney: '',
					redemingRate: '',
					redemingLockUp: '',
					reviewer: ''
				},
				editform:{
					productCategoryName: '',
					productSecCategory: '',
					productName: '',
					companyName: '',
					annualized: '',
					fundCurrency: '',
					opDate: '',
					subscriptionDate: '',
					relativeManageCost: '',
					subscriptionRate: '',
					startAmount: '',
					chargeMode: '',
					redemingCycle: '',
					redemingMoney: '',
					redemingRate: '',
					redemingLockUp: '',
					reviewer: '',
					productId:'',
					createTime:'',
					updateTime:'',
					reviewState:'',
					createPeople:'',
				},
				netform:{
					netWorthId:'',
					productName:'',
					unitNet:'',
					baseDate:'',
					increaseRate:'',
				},
			
				
				
				formLabelWidth: '150px',
				tableData: [],



				currentRow: null,
				pageInfo: { //{} 表示对象  [] 表示集合
					page: 1,
					pageSize: 5,
					total: 10
				},
				queryfrom: { //查询表单
					productName: '',
					productSecCategory: '',
					reviewState: ""
				},
				categoryQuery: [{
						name: "阳光私募",
						id: "1"
					},
					{
						name: "对冲基金",
						id: "2"
					},
					{
						name: "香港私募股权",
						id: "3"
					},
					{
						name: "其他基金",
						id: "4"
					},
					{
						name: "共同基金",
						id: "5"
					}
				],

				stateQuery: [{
						name: "审核中",
						id: "1"
					},
					{
						name: "已通过",
						id: "2"
					},
					{
						name: "驳回",
						id: "3"
					},
				],
				
                myFundCurrency:[ /* 货币类型 */
					{name:"CNY"},
				    {name:"USD"},
				],

				series: [],/* 所有系列名称 */
				
				myparam:{
					companyName:'',
					fundCurrency:'',
					opDate:'',
					productCategoryName:'',
					productId:'',
					productName:'',
					productSecCategory:'',
					reviewState:''
				},
				
				allmanger:[],
				nowmanger:{
					uname:''
				}
				


			}
		},

		methods: {
			
			
			
			dateFormat(row, column) {  //格式化时间
							var date = row[column.property];
							if (date === undefined) {
								return ''
							};
							return this.$moment(date).format("YYYY-MM-DD")
			},
			
			myNetValue() { 
                this.netFormVisible=true
			},
			myAdd() {
				this.addFormVisible = true
				if (this.$refs['addform']!==undefined) {
				     this.$refs['addform'].resetFields();
				 }
				
			},
			myEdit(){
				this.editFormVisible = true;	
				
			},
			
			addSumit(){  //增加提交
			this.addFormVisible = false;
			    console.log(this.$qs.stringify(this.proform))
				this.$axios.get("proInfo/insertPro?"+this.$qs.stringify(this.proform))
				.then(returnVal=>{
					
					if (returnVal.data.returnCode == 3000) {
						this.$message({
						         message: returnVal.data.returnMsg,
						         type: 'success'
						       });
						this.query("");	   
					}else if(returnVal.data.returnCode == 4000){
							 this.$message.error(returnVal.data.returnMsg);
						}
				})
			},
			
			editSumit(){   //修改提交
		     this.editFormVisible = false
			 
			 console.log(this.$qs.stringify(this.editform))
			 
			 this.$axios.get("proInfo/updataPro?"+this.$qs.stringify(this.editform))
			 .then(returnVal=>{
				 console.log(returnVal)
				 if (returnVal.data.returnCode == 3000) {
				 	this.$message({
				 	         message: returnVal.data.returnMsg,
				 	         type: 'success'
				 	       });
				 	this.query("");	   
				 }else if(returnVal.data.returnCode == 4000){
				 		 this.$message.error(returnVal.data.returnMsg);
						 
				 	}
			 })
			},
			netSumit(){  //净值管理提交
				this.netFormVisible = false
				
				this.$axios.get("proInfo/insertNetWorth?"+this.$qs.stringify(this.netform))
				.then(returnVal=>{
					console.log(returnVal)
					if (returnVal.data.returnCode == 3000) {
						this.$message({
						         message: returnVal.data.returnMsg,
						         type: 'success'
						       });
						this.query("");	   
					}else if(returnVal.data.returnCode == 4000){
							 this.$message.error(returnVal.data.returnMsg);
						}
				})
				
			},
			editNetSumit(){
				this.netFormVisible = false
				
				this.$axios.get("proInfo/editValue?"+this.$qs.stringify(this.netform))
				.then(returnVal=>{
					if (returnVal.data.returnCode == 3000) {
						this.$message({
						         message: returnVal.data.returnMsg,
						         type: 'success'
						       });
						this.query("");	   
					}else if(returnVal.data.returnCode == 4000){
							 this.$message.error(returnVal.data.returnMsg);
						}
				}).catch(err => {
						console.log(err);
					});
			},
			
			myReset() {
				this.$refs['queryfrom'].resetFields();
			},
			queryData() {
				//条件查询
				this.pageInfo.page = 1;
				let myprarm = this.$qs.stringify(this.pageInfo) + "&" + this.$qs.stringify(this.queryfrom);
				console.log(myprarm)
				this.query(myprarm);

			},


			handleSizeChange(val) {
				this.buttonstate=true;
				console.log(`每页 ${val} 条`);
				this.pageInfo.pageSize = val;
				this.pageInfo.page = 1;
					let myprarm2 = this.$qs.stringify(this.pageInfo) + "&" + this.$qs.stringify(this.queryfrom);
				/* console.log(this.$qs.stringify(this.pageInfo)); */
				this.query(myprarm2)
			},
			handleCurrentChange(val) {
				this.buttonstate=true;
				console.log(`当前页: ${val}`);
				// console.log(this.editform)
				this.pageInfo.page = val;
				let myprarm1 = this.$qs.stringify(this.pageInfo) + "&" + this.$qs.stringify(this.queryfrom);
				
				this.query(myprarm1);
			},
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			
			
			/* ---------------------------------------------------------- */
			handleRowChange(val) {  //点击行
				this.myparam = val;
				// console.log(this.myparam)
			    this.buttonstate=false;		
					if (this.myparam != null) {
				this.$axios.get("proInfo/readyUpdataPro?productId="+this.myparam.productId)  //修改信息
				.then(returnVal=>{
					   console.log(returnVal.data)
						this.editform=returnVal.data.returnData;
					    this.editform.opDate=this.$moment(this.editform.opDate).format("YYYY-MM-DD")
						
						
				}).catch(err => {
						console.log(err);
					});
				
				this.$axios.get("proInfo/getNetValue?productName="+this.myparam.productName)   //净值信息
				.then(returnVal=>{
					console.log(returnVal)
					if(returnVal.data.returnCode==4000){
						if(this.myparam.reviewState=='已通过'){
							this.isshow=true;
							this.isshow1=false;
							}else{
								this.isshow=false;
								this.isshow1=true;
							}
						Object.keys(this.netform).forEach(key => (this.netform[key] = ''));
						this.netform.productName=this.myparam.productName
					}else if(returnVal.data.returnCode==3000){
								this.isshow=false;
								this.isshow1=true;
						 this.netform=returnVal.data.returnData
						 this.netform.baseDate=this.$moment(this.netform.baseDate).format("YYYY-MM-DD")
					}
				
				}).catch(err => {
						console.log(err);
					})
				}
			},
			
			
			query(param) { /* 分页查询 */
				this.$axios.get("proInfo/queryPro?" + param)
					.then(returnVal => {

						if (returnVal.data.returnCode == 3000) {
							console.log(returnVal)
							this.tableData = returnVal.data.returnData;
							this.pageInfo = returnVal.data.pageInfo;
							this.nowmanger.uname =returnVal.data.reviewer;
							
							
							
							// this.$nextTick(function(){   /* 可能出现渲染不及时，所有用nextTick方法来推迟运行。  也可以用watch监控数据更新，然后进行自己的操作（watch 与method，data同级）*/
							// 	this.buttonstate=true;   
							// }),

						}
					}).catch(err => {
						console.log(err);
					})
			},
			getSeriesName() {
				this.$axios.get("series/query?sname=" + this.proform.productCategoryName)
					.then(returnVal => {
						/* console.log(returnVal) */
						if (returnVal.data.returnCode == 3000) {
							this.proform.companyName = returnVal.data.returnData[0].companyName;
							// this.editform.companyName=returnVal.data.returnData[0].companyName;
						}

					}).catch(err => {
						console.log(err);
					})
			},
			getComName(){
			
				this.$axios.get("series/query?sname=" + this.editform.productCategoryName)
					.then(returnVal => {
						/* console.log(returnVal) */
						if (returnVal.data.returnCode == 3000) {
							// console.log(returnVal)
							// this.proform.companyName = returnVal.data.returnData[0].companyName;
							this.editform.companyName=returnVal.data.returnData[0].companyName;
						}
				
					}).catch(err => {
						console.log(err);
					})
			},
			
			getSeries() {
				this.$axios.get("series/queryAll")
					.then(returnVal => {
						if (returnVal.data.returnCode == 3000) {
							this.series = returnVal.data.returnData
						}
					}).catch(err => {
						console.log(err);
					})
			},
			getManger(){
				this.$axios.get("manger/queryallmg?uname="+this.nowmanger.uname)
				.then(returnVal=>{
					console.log(returnVal)
					this.allmanger=returnVal.data.returnData;
				}).catch(err => {
						console.log(err);
					})
			}

		},
		mounted() {
			this.query("");
			this.getSeries();
			
			
		},
		watch:{
			/* 监控tableData的数据的改变 ，改变后执行自己需要的代码 */
			tableData:function(){
				this.$nextTick(function(){   /* 可能出现渲染不及时，所有用nextTick方法来推迟运行。  也可以用watch监控数据更新，然后进行自己的操作（watch 与method，data同级）*/
					this.buttonstate=true;   
					this.getManger();
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
</style>
