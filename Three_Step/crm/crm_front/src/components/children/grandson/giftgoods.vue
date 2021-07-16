<template>
	<div>
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: 'mypage' }">商品与赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item >赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item >赠品转商品管理</el-breadcrumb-item>
			
		</el-breadcrumb>
		<hr />
		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-form-item prop="giftName" label="商品名称:">
				<el-input v-model="selectform.giftName"  placeholder="商品名称" style="width: 110px;"></el-input>
			</el-form-item>
			<el-form-item prop="giftBrand" label="商品品牌:">
				<el-select v-model="selectform.giftBrand"  placeholder="赠品品牌" style="width: 110px;">
					<el-option label="全部" value=""></el-option>
					<el-option
					      v-for="item in brands"
					      :value="item.giftBrand"
					      :label="item.giftBrand">
					    </el-option>
				</el-select>
			</el-form-item>
			<el-form-item prop="giftColor" label="商品颜色:">
				<el-select v-model="selectform.giftColor"  placeholder="赠品颜色" style="width: 110px;">
					<el-option label="全部" value="" ></el-option>
					<el-option v-for="item in clors" :label="item.giftColor" :value="item.giftColor"></el-option>
				</el-select>
			</el-form-item>
			
			<el-form-item prop="giftType" label="商品类型:">
				<el-select v-model="selectform.giftType"  placeholder="商品类型" style="width: 110px;">
					<el-option label="全部" value="" ></el-option>
					<el-option v-for="item in types" :label="item.giftType" :value="item.giftType" ></el-option>
					<!-- <template slot-scope="scope">
					      <el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' : 'danger'" disable-transitions>{{scope.row.giftReviewstatus==0?'有效':'草稿'}}</el-tag>
					     </template> -->
				</el-select>
			</el-form-item>
			<el-form-item prop="giftReviewstatus" label="审核状态:">
				<el-select v-model="selectform.giftReviewstatus"  placeholder="审核状态" style="width: 110px;">
				
					<el-option label="全部" value="" ></el-option>
					<el-option v-for="item in reviewstatus" :label="item.desc" :value="item.giftReviewstatus" ></el-option>
				</el-select>
			</el-form-item>
			
		   
		</el-form>
		<div>
		<el-button type="primary" @click="querydata()">查询</el-button>
		 <el-button type="success" @click="adddata()">新增赠品转商品</el-button>
		<el-button @click="myreset()">重置</el-button>
		<hr />
		</div>
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleCurrentChange" 
		style="width: 70%;height: 20%;" border>
			</el-table-column>
			<el-table-column prop="index" label="序号" width="50px">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column type="selection" width="55">
				
			</el-table-column>
			<el-table-column prop="giftName" label="商品名称" width="100">
			</el-table-column>
			<el-table-column prop="giftType" label="商品类型" width="100">
			</el-table-column>
			<el-table-column prop="giftBrand" label="商品品牌" width="100">
			</el-table-column>
			<el-table-column prop="giftPrice" label="商品单价" width="100">
			</el-table-column>
			<el-table-column prop="giftInventory" label="商品库存量" width="100">
			</el-table-column>
			<el-table-column prop="giftReviewstatus"  label="审核状态"  width="100" :formatter="giftReviews">
		<!-- 		<template slot-scope="scope">
				      <el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'" disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?' 已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'草稿'}}</el-tag>
				     </template> -->
			</el-table-column>
			</el-table-column>
			<el-table-column prop="operate" label="操作"   width="300">
				<template slot-scope="scope" >
					<el-button size="mini" type="success" @click="handleSelect(scope.$index, scope.row)"
					>查看</el-button>
					<el-button size="mini" type="warning" @click="handleUpdate(scope.$index, scope.row)"
					:disabled="scope.row.operate">修改</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)"
					:disabled="scope.row.operate">删除</el-button>
					<el-button size="mini" type="danger" @click="audit(scope.$index, scope.row)">审核跟踪</el-button>
				</template>
			</el-table-column>
		</el-table>
		<el-dialog title="赠品详细信息" :visible.sync="selectFormVisible" >
			<el-form ref="selectForm" :model="selectForm" >
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="selectForm.giftName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="giftType" >
					<el-input v-model="selectForm.giftType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="selectForm.giftModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="selectForm.giftPrice" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="selectForm.giftCost" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="selectForm.giftDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="selectForm.giftNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="selectForm.giftColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				
				<el-button type="primary" @click="sureSubmit() " >确 定</el-button>
			</div>
			
		</el-dialog>
		<el-dialog title="修改" :visible.sync="updateFormVisible" >
			
			<el-form ref="updateForm" :model="updateForm" >
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="updateForm.giftName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="giftType" >
					<el-input v-model="updateForm.giftType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="updateForm.giftModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="updateForm.giftPrice" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="updateForm.giftCost" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="updateForm.giftDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="updateForm.giftInventory" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="updateForm.giftColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item prop="giftNumber" label="入库数量" :label-width="formLabelWidth"  >
					<el-input v-model="updateForm.giftNumber" autocomplete="off" />	
				</el-form-item>
				<el-form-item prop="giftTyprice" label="天翼价" :label-width="formLabelWidth"  >
					<el-input v-model="updateForm.giftTyprice" autocomplete="off" />	
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="updateFormVisible = false ">取 消</el-button>
				<el-button type="primary" @click="notsureSubmit()" >保存草稿</el-button>
				<el-button type="primary" @click="updateSubmit() " >提交审核</el-button>	
			</div>
		</el-dialog>
		<el-dialog title="审核跟踪详情" :visible.sync="trackingFormVisible" >
			<el-form ref="trackingForm" :model="trackingForm" >
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="trackingForm.giftName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="giftType" >
					<el-input v-model="trackingForm.giftType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="trackingForm.giftModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="trackingForm.giftPrice" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="trackingForm.giftCost" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="trackingForm.giftDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="trackingForm.giftInventory" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="trackingForm.giftColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<span><h3>审核记录</h3></span>
				<el-table  ref="singleTable" :data="trackingForeData" highlight-current-row  style="width: 100% " border >
						<el-table-column property="updateBy" label="审核人" width="100px">
						</el-table-column>
						<el-table-column property="updateTime" label="审核时间" width="150px">
						</el-table-column>
						<el-table-column property="giftReviewstatus" label="审核状态" width="100px">
							<template slot-scope="scope">
							      <el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'" disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?'已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'草稿'}}</el-tag>
							     </template>
						</el-table-column>
						<el-table-column property="auditOpinion" label="审核意见" >
						</el-table-column>
					</el-table>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="trackingFormVisible = false " >返回</el-button>
			</div>
		</el-dialog>
		<el-dialog title="新增赠品转商品" :visible.sync="giftFormVisible" style="width: 100%;">
		    <el-table  ref="singleTable" :data="giftForm" highlight-current-row @current-change="handleCurrentChange" style="width: 100%" borde>
					<el-table-column property="" label="序号" width="50px " type="index">
					</el-table-column>
					<el-table-column type="selection" width="45"> </el-table-column>
					<el-table-column property="giftName" label="商品名称" width="78">
					</el-table-column>
					<el-table-column property="giftType" label="商品类型" width="78">
					</el-table-column>
					<el-table-column property="giftModel" label="商品型号" width="78">
					</el-table-column>
					<el-table-column property="giftPrice" label="商品单价" width="78">
					</el-table-column>
					<el-table-column property="giftCost" label="成本价格" width="78">
					</el-table-column>
					</el-table-column>
					<el-table-column property="giftDepartment" label="采购部门" width="78">
					</el-table-column>
					<el-table-column property="giftInventory" label="商品库存" width="78">
					</el-table-column>
					<el-table-column property="giftColor" label="商品颜色" width="78">
					</el-table-column>
					<el-table-column property="giftNumber" label="入库数量" width="78"   >	
						<input v-model="testData" style="width: 55px;"  placeholder="入库数量"/>	
					</el-table-column>
					<el-table-column property="giftTyprice" label="天翼价" width="78"  >
						<input v-model="testData1" style="width: 50px;" placeholder="天翼价"/>	
					</el-table-column>
			        <el-table-column  label="操作"   width="300">
				        <template slot-scope="scope" >
					    <el-button type="primary" @click="notgiftsureSubmit()" >保存草稿</el-button>
					    <el-button type="danger" @click="addgiftSubmit() "  >确 定</el-button>
				        </template>
			        </el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange1" @current-change="handlePageChange1" :current-page="pageInfo.pageNum"
			 :page-sizes="[5, 10, 15]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
			</el-pagination>
			<div slot="footer" class="dialog-footer">
				<el-button @click="giftFormVisible = false ">返回</el-button>
				
				
			</div>
			</el-dialog>
		
		<el-pagination @size-change="handleSizeChange" @current-change="handlePageChange" :current-page="PageInfo.pageNum"
		 :page-sizes="[5, 10, 15]" :page-size="PageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="PageInfo.total">
		</el-pagination>
	</div>
</template>

<script>
	export default{
		data() {
			return{
				testData:undefined,
				testData1:undefined,
				formLabelWidth:"180px",
				selectFormVisible:false,
				updateFormVisible:false,
				trackingFormVisible:false,
				giftFormVisible:false,
				giftForm:[],
				selectform:{},
				selectForm:{},
				updateForm:{},
				trackingForm:[],
				// giftFrom:{},
				brands:[],
				clors:[],
				types:[],
				tableData:[],
				reviewstatus:[],
				trackingForeData:[],
				
				PageInfo:{
					pageNum:1,
					pageSize:3,
					total:100
					},
                pageInfo:{
					pageNum:1,
					pageSize:3,
					total:100
				}	,
				auditData:{
					"verifyId": 1000,
					"applicant": "lisi",
					"verifyTable": "gift_goods",
					"verifyTableId": 1625241212429,
					"verifyPerson": "",
					"verifyStatus": 0,
					"verifySuggestion": "",
					"verifyTime": "2021-07-02 23:53:32.0"}
			}
		},
		methods:{
			giftReviews(cellValue) {
				console.log(11111111111111);
				debugger
				if (cellValue.giftReviewstatus == 1) {
					cellValue.operate = true;
					return "已审核";
				} else if (cellValue.giftReviewstatus == 0) {
					cellValue.operate=false;
					return "未审核";
				} else if (cellValue.giftReviewstatus == 2) {
					cellValue.operate=false;
					return "审核未通过";
				} else if (cellValue.giftReviewstatus == 3) {
					cellValue.operate=false;
					return "草稿";
				}
			},
			handleCurrentChange(val) {
				console.log(val);
				this.currentRow = val;
			},
			handleCurrentChange1(val){
				this.currentRow = val;
				this.TwoaddSubmit().disabled=false;
				this.notsureSubmit().disabled=false;
			},
			handleSizeChange(val) { //pageSzie发生变化
				this.PageInfo.pageNum = 1;
				
				this.PageInfo.pageSize = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},
			handleSizeChange1(val) { //pageSzie发生变化
				this.pageInfo.pageNum = 1;
				
				this.pageInfo.pageSize = val;
				console.log(this.pageInfo.pageSize);
				console.log(`当前页: ${val}`);
				let myparam = this.$qs.stringify(this.pageInfo) ;
			     this.adddata(myparam);
			},
			handlePageChange(val) { //翻页
				
				this.PageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
				
			
			},
			handlePageChange1(val) { //翻页
				
				this.pageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.pageInfo) ;
				this.adddata(myparam);
				
			
			},
			querydata(){
				let a = {...this.PageInfo,...this.selectform};
				 // let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				 this.myquer(this.$qs.stringify(a));
			},
			sureSubmit(){
				this.selectFormVisible = false;
				
			},
			notsureSubmit(index,row){
					this.updateFormVisible = false;
					console.log("ww"+this.testData);
					// debugger;
					// this.TwotableData.giftNumber = this.testData;
					// console.log("获取到数据："+this.TwotableData.giftNumber);
					this.TowaddFormVisible=false;
					this.$axios.post("giftGoods/giftReviewstatus",this.currentRow)
					.then(resp=>{
						if(resp.code==20000){
							this.$message({
								  message: resp.msg,
								  type: 'success'
							});	
							// //刷新 table数据
							let myparam = {...this.PageInfo,...this.selectform};
							this.myquer(this.$qs.stringify(myparam));
							//刷新下拉列表数据
							this.getbrand("");
							this.getclor("");
							this.gettype("");
									   
						}else if(resp.code==50000){
							this.$message.error(resp.msg);
						}
						this.testData=undefined;
					})
					
				},
			
			adddata(param){
				// this.updateFormVisible=false;
				// this.updateFormVisible = false;
				// console.log("ww"+this.testData);
				//  1000 只对申请表做操作，2000 两张表操作
				// this.auditData.verifyId=1000;
				// this.auditData.verifyTableId=this.currentRow.giftId+'';
				// this.auditData.applicant=this.currentRow.updateBy;
				// this.auditData.verifyStatus=0;
				// this.currentRow.giftReviewstatus=0;
				// let data = Object.assign(this.auditData,this.currentRow);
				
				this.giftFormVisible=true;
				this.$axios.get("gift/list?"+param)
				// this.$axios.get("ver/adds",data)
				// "ver/adds",data
				.then(resp=>{
					console.log(resp);
					this.giftForm=resp.data.list;
					this.pageInfo.pageNum=resp.data.pageNum;
					this.pageInfo.pageSize=resp.data.pageSize;
					this.pageInfo.total=resp.data.total;
					debugger;
				})
				.catch(err=>{
					console.log(err);
				})
			},
			notgiftsureSubmit(){
				
			},
			addgiftSubmit(){
				this.giftFormVisible=false;
				this.currentRow.giftNumber=this.testData;
				this.currentRow.giftTyprice=this.testData1;
				//  1000 只对申请表做操作，2000 两张表操作
				this.auditData.verifyId=1000;
				this.auditData.verifyTableId=this.currentRow.giftId+'';
				console.log(this.currentRow.updateBy);
				debugger;
				this.auditData.applicant=this.currentRow.updateBy;
				this.auditData.verifyStatus=0;
				this.currentRow.giftReviewstatus=0;
				
		
				let data = Object.assign(this.auditData,this.currentRow);
				this.$axios.post("ver/adds",data)
				// this.$axios.get("ver/adds",data)
				// "ver/adds",data
				.then(resp=>{
					if(resp.code==20000){
						this.$message({
							  message: resp.msg,
							  type: 'success'
						});	
						// //刷新 table数据
						let myparam = {...this.pageInfo,...this.selectform};
						this.myquer(this.$qs.stringify(myparam));
						//刷新下拉列表数据
						this.getbrand("");
						this.getclor("");
						this.gettype("");
								   
					}else if(resp.code==50000){
						this.$message.error(resp.msg);
					}
					this.testData=undefined;
				})
			},
			handleSelect(index,row){
				this.selectFormVisible=true;
				this.selectForm = row;
			},
			handleUpdate(index, row) {
				
				this.updateFormVisible=true;
				this.updateForm=row;
				
			},
			updateSubmit() {
				this.updateFormVisible=false;
				this.updateFormVisible = false;
				console.log("ww"+this.testData);
				//  1000 只对申请表做操作，2000 两张表操作
				this.currentRow.giftNumber=this.testData;
				this.auditData.verifyId=2000;
				this.auditData.verifyTableId=this.currentRow.giftId+'';
				this.auditData.applicant=this.currentRow.updateBy;
				this.auditData.verifyStatus=0;
				this.currentRow.giftReviewstatus=0;
				let data = Object.assign(this.auditData,this.currentRow);
					// "verifyId": 1000,
					// "applicant": "lisi",
					// "verifyTable": "gift_goods",
					// "verifyTableId": 1625241212429,
					// "verifyPerson": "",
					// "verifyStatus": 0,
					// "verifySuggestion": "",
					// "verifyTime": "2021-07-02 23:53:32.0"}
				// debugger;
				// this.TwotableData.giftNumber = this.testData;
				// console.log("获取到数据："+this.TwotableData.giftNumber);
				this.TowaddFormVisible=false;
				this.$axios.post("ver/adds",data)
				.then(resp=>{
					if(resp.code==20000){
						this.$message({
							  message: resp.msg,
							  type: 'success'
						});	
						// //刷新 table数据
						let myparam = {...this.PageInfo,...this.selectform};
						this.myquer(this.$qs.stringify(myparam));
						//刷新下拉列表数据
						this.getbrand("");
						this.getclor("");
						this.gettype("");
								   
					}else if(resp.code==50000){
						this.$message.error(resp.msg);
					}
					this.testData=undefined;
				})
				},
			handleDelete(index, row) {;
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
								 			            confirmButtonText: '确定',
								 			            cancelButtonText: '取消',
								 			            type: 'warning'
								 			  }).then(() => {
								 				//发请求
								 				this.$axios.delete("giftGoods/delete/"+row.giftId)
								 				.then(resp=>{
								 					console.log(resp);
								 								//给用户提示
								 								if(resp.code==20000){
																	this.$message({
																		  message: resp.msg,
																		  type: 'success'
																	});	
																	// //刷新 table数据
																	let myparam = this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
																	this.myquer(myparam);
																	//刷新下拉列表数据
																	this.getbrand("");
																	this.getclor("");
																	this.gettype("");		   
								 								}else if(resp.code==50000){
								 									this.$message.error(resp.msg);
								 								}
								 								
								 				})
								 				.catch(err=>{
								 					
								 				})
								 			  }).catch(() => {
								 				this.$message({
								 				  type: 'info',
								 				  message: '已取消删除'
								 				});          
								 			  });
			},
			
			audit(index,row){
				this.trackingFormVisible=true;
				this.trackingForm=row
				console.log("******"+row.giftId);
				this.$axios.get("giftGoods/list?giftId="+row.giftId)
				.then(resp=>{
					console.log(resp);
					this.trackingForeData=resp.data.list;
					console.log("----1"+resp.list);
					// debugger;
				})
				.catch(err=>{
					console.log(err);
				})
				
			},
			myquer(param) { //初始化页面
				this.$axios.get("giftGoods/list?" + param)
					.then(resp => {
						
						this.tableData = resp.data.list;
						
						this.PageInfo.pageNum=resp.data.pageNum;
						this.PageInfo.pageSize=resp.data.pageSize;
						this.PageInfo.total=resp.data.total;
						
					}).catch(err => {
						console.log(err);
					})
			},
			myreset(fromname) {//重置按钮
				this.$refs['selectform'].resetFields(); //model需要有ref，和对应的prop属性
				
				let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				this.myquer(myparam);//重置输入框内容后进行页面刷新
				// this.querydata();
				
				
				
			},
			getbrand(param) { //刷新赠品品牌的下拉框
				this.$axios.get("giftGoods/giftBrand?" + param)
					.then(resp => {
						console.log("brands"+resp);
						this.brands = resp;
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			getclor(param) { //刷新赠品颜色的下拉框
				this.$axios.get("giftGoods/giftColor?" + param)
					.then(resp => {
						
						this.clors = resp;
						
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			gettype(param){//赠品类型下拉框
				this.$axios.get("giftGoods/giftType?" + param)
					.then(resp => {
						
						
						this.types = resp;
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			getreviewstatus(param){//审核状态
				this.$axios.get("giftGoods/giftReviewstatus?" + param)
					.then(resp => {
						console.log("reviewstatus"+resp);
						this.reviewstatus=resp;
						console.log("this.reviewstatus----"+this.reviewstatus)
					})
					.catch(err => {
						console.log(err);
					})
			},
			myreset(fromname) {//重置按钮
				this.$refs['selectform'].resetFields(); //model需要有ref，和对应的prop属性
				
				let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				this.myquer(myparam);//重置输入框内容后进行页面刷新
				// this.querydata();
				
				
				
			},
			
		},
		mounted() { //钩子函数，进行页面初始化
			this.myquer();
			this.getbrand("");
			this.getclor("");
			this.gettype("");
			this.getreviewstatus("");
		},
		
	}
</script>

<style>
</style>
