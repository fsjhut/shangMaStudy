<template>
	<div>
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/mypage' }">商品与赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item>赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item>商品转赠品审核列表</el-breadcrumb-item>

		</el-breadcrumb>
		<hr />
		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-form-item prop="goodsName" label="商品名称:">
				<el-input v-model="selectform.goodsName" placeholder="商品名称" style="width: 150px;"></el-input>
			</el-form-item>

			<el-form-item prop="goodsType" label="商品类型:">
				<el-select v-model="selectform.goodsType" placeholder="商品类型" style="width: 150px;">
					<el-option label="全部" value=""></el-option>
					<el-option v-for="item in types" :label="item.goodsType" :value="item.goodsType"></el-option>
				</el-select>
			</el-form-item>



		</el-form>
		<div>
			<el-button type="primary" @click="querydata()">查询</el-button>

			<el-button @click="myreset()">重置</el-button>
			<hr />
		</div>
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleCurrentChange" style="width: 78.5%;height: 20%;"
		 border>
			</el-table-column>
			<el-table-column label="序号" width="50" type="index">
			</el-table-column>
			<el-table-column type="selection" width="55">
			</el-table-column>
			<el-table-column prop="goodsName" label="赠品名称" width="100">
			</el-table-column>
			<el-table-column prop="goodsType" label="赠品类型" width="100">
			</el-table-column>
			<el-table-column prop="goodsBrand" label="赠品品牌" width="100">
			</el-table-column>
			<!-- <el-table-column prop="procurementRmb" label="赠品成本" width="100">
			</el-table-column> -->
			<el-table-column prop="marketRmb" label="赠品单价" width="100">
			</el-table-column>
			<el-table-column prop="giftNumber" label="赠品数量" width="100">
			</el-table-column>
			<el-table-column prop="giftReviewstatus" label="审核状态" width="100">
				<template slot-scope="scope">
					<!-- 0：未审核，1：通过，2：未通过 -->
					<el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'"
					 disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?'已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'无效'}}</el-tag>
				</template>
			</el-table-column>
			</el-table-column>
			<el-table-column label="操作" width="300">
				<template slot-scope="scope">
					<el-button size="mini" type="success" @click="handleSelect(scope.$index, scope.row)">审核</el-button>
					<el-button size="mini" type="danger" @click="audit(scope.$index, scope.row)">审核跟踪</el-button>
				</template>
			</el-table-column>
		</el-table>


		<el-dialog title="审核" :visible.sync="trackingFormCheckVisible">
			<el-form ref="trackingForm2" :model="trackingForm2">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="goodsName">
					<el-input v-model="trackingForm2.goodsName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="goodsType">
					<el-input v-model="trackingForm2.goodsType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="goodsModel">
					<el-input v-model="trackingForm2.goodsModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="trackingForm2.marketRmb" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="purchasingPrice">
					<el-input v-model="trackingForm2.purchasingPrice" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="purchasingDepartment">
					<el-input v-model="trackingForm2.purchasingDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftNumber">
					<el-input v-model="trackingForm2.giftNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="goodsColor">
					<el-input v-model="trackingForm2.goodsColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<span>
					<h3>审核记录</h3>
				</span>
				<el-table ref="singleTable" :data="trackingForeData" highlight-current-row style="width: 100% " border>
					<el-table-column property="updateBy" label="审核人" width="100px">
					</el-table-column>
					<el-table-column property="updateTime" label="审核时间" width="150px">
					</el-table-column>
					<el-table-column property="giftReviewstatus" label="审核状态" width="100px">
						<template slot-scope="scope">
							<el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'"
							 disable-transitions>{{scope.row.giftReviewstatus==0?'已审核': scope.row.giftReviewstatus==1?'未审核' :scope.row.giftReviewstatus==2?'审核未通过' :'无效'}}
							</el-tag>
						</template>
					</el-table-column>
					<el-table-column property="auditOpinion" label="审核意见">
					</el-table-column>
				</el-table>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<!-- <el-button @click="trackingFormCheckVisible = false ">返回</el-button> -->
				<el-button type="primary" @click="examinationPassed">审核通过</el-button>
				<el-button type="primary" @click="auditNotPassed">审核驳回</el-button>
			</div>
		</el-dialog>

		<el-dialog title="审核跟踪详情" :visible.sync="trackingFormVisible">
			<el-form ref="trackingForm" :model="trackingForm">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="goodsName">
					<el-input v-model="trackingForm.goodsName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="goodsType">
					<el-input v-model="trackingForm.goodsType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="goodsModel">
					<el-input v-model="trackingForm.goodsModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="trackingForm.marketRmb" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="purchasingPrice">
					<el-input v-model="trackingForm.purchasingPrice" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="purchasingDepartment">
					<el-input v-model="trackingForm.purchasingDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftNumber">
					<el-input v-model="trackingForm.giftNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="goodsColor">
					<el-input v-model="trackingForm.goodsColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<span>
					<h3>审核记录</h3>
				</span>
				<el-table ref="singleTable" :data="trackingForeData" highlight-current-row style="width: 100% " border>
					<el-table-column property="updateBy" label="审核人" width="100px">
					</el-table-column>
					<el-table-column property="updateTime" label="审核时间" width="150px">
					</el-table-column>
					<el-table-column property="giftReviewstatus" label="审核状态" width="100px">
						<template slot-scope="scope">
							<el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'"
							 disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?'已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'无效'}}
							</el-tag>
						</template>
					</el-table-column>
					<el-table-column property="auditOpinion" label="审核意见">
					</el-table-column>
				</el-table>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="trackingFormVisible = false ">返回</el-button>
			</div>
		</el-dialog>



		<el-pagination @size-change="handleSizeChange" @current-change="handlePageChange" :current-page="PageInfo.pageNum"
		 :page-sizes="[3, 6, 9, 12]" :page-size="PageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="PageInfo.total">
		</el-pagination>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				testData: undefined,
				testData1: undefined,
				formLabelWidth: "180px",
				selectFormVisible: false,
				updateFormVisible: false,
				trackingFormVisible: false,
				giftFormVisible: false,
				trackingFormCheckVisible: false,
				giftForm: [],
				trackingForm: [],
				trackingForm2: [],
				trackingForeData: [],
				trackingForeData2: [],
				selectform: {},
				selectForm: {},
				brands: [],
				clors: [],
				types: [],
				tableData: [],
				reviewstatus: [],
				auditData:{},
				PageInfo: {
					pageNum: 1,
					pageSize: 3,
					total: 100
				},
				PageInfo2: {
					pageNum: 1,
					pageSize: 6,
					total: 10
				},
			}
		},
		methods: {
			//审核不通过
			auditNotPassed(){
				this.trackingFormCheckVisible = false;
				this.auditData.verifyTable = "goods_gift";
				this.auditData.verifyTableId = this.currentRow.goodsId+"";
				this.auditData.verifyId = 2000;
				this.auditData.verifyStatus = 2;
				//debugger
				this.currentRow.giftReviewstatus = 2;
				let data = Object.assign(this.auditData, this.currentRow);
				
				// let data = this.trackingForm2;
				
				this.$axios.post("ver/adds",data)
				.then(resp=>{
					
					//刷新页面
					let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
					this.myquer(myparam);
					
				})
				
			},
			// 0：未审核，1：通过，2：未通过
			//审核通过
			examinationPassed(){
				this.trackingFormCheckVisible = false;
				this.auditData.verifyTable = "goods_gift";
				this.auditData.verifyTableId = this.currentRow.goodsId+"";
				this.auditData.verifyId = 2000;
				this.auditData.verifyStatus = 1;
				//debugger
				this.currentRow.giftReviewstatus = 1;
				let data = Object.assign(this.auditData, this.currentRow);
								
				this.$axios.put("goodsGift/update",data)
				.then(resp=>{
					if (resp.code == 20000) {
						this.$message({
							showClose: true,
							message: "审核通过",
							type: 'success'
						});
					} 
					//刷新页面
					let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
					this.myquer(myparam);
					
				})
			},
			
			handleCurrentChange(val) {
				this.currentRow = val;
			},

			handleSizeChange(val) { //pageSzie发生变化
				this.PageInfo.pageNum = 1;
				this.PageInfo.pageSize = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},

			handlePageChange(val) { //翻页
				this.PageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},

			querydata() {
				let a = { ...this.PageInfo,
					...this.selectform
				};
				//let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				this.myquer(this.$qs.stringify(a));
			},

			sureSubmit() {},

			addQuery() {
				this.giftFormVisible = true;
				let params = { ...this.PageInfo2
				}
				this.adddata("");
			},
			adddata(param) {},


			//添加商品转赠品
			addGoodsSubmit() {},
			handleSelect(index, row) {
				this.trackingFormCheckVisible = true;
				this.selectFormVisible = true;
				this.selectForm = row;
				this.trackingForm2 = row;
				
				this.$axios.get("goodsGift/list?goodsId=" + row.goodsId)
					.then(resp => {
						console.log(resp);
						this.trackingForeData = resp.data.list;
						// debugger;
					})
					.catch(err => {
						console.log(err);
					})
				

			},

			//审核跟踪
			audit(index, row) {
				this.trackingFormVisible = true;
				this.trackingForm = row;
				//this.trackingForeData = row;
				this.$axios.get("goodsGift/list?goodsId=" + row.goodsId)
					.then(resp => {
						console.log(resp);
						this.trackingForeData = resp.data.list;
						// debugger;
					})
					.catch(err => {
						console.log(err);
					})
			},
			
		
			
			
			updateSubmit() {},
			
			

			handleUpdate(index, row) {
				this.updateFormVisible = true;
				this.updateForm = row;

			},


			handleDelete(index, row) {},
			
		

			//audit(index, row) {},

			//查询所有或条件查询
			myquer(param) { //初始化页面
				this.$axios.get("goodsGift/list/invalid?" + param)
					.then(resp => {

						this.tableData = resp.data.list;
						this.PageInfo.pageNum = resp.data.pageNum;
						this.PageInfo.pageSize = resp.data.pageSize;
						this.PageInfo.total = resp.data.total;

					}).catch(err => {
						console.log(err);
					})
			},


			myreset(fromname) { //重置按钮
				this.$refs['selectform'].resetFields(); //model需要有ref，和对应的prop属性
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam); //重置输入框内容后进行页面刷新
			},






			gettype() { //赠品类型下拉框
				this.$axios.get("goodsGift/selectType/goods_type")
					.then(resp => {


						this.types = resp.data;

					})
					.catch(err => {
						console.log(err);
					})
			},
			getreviewstatus(param) { //审核状态
				this.$axios.get("goodsGift/reviewstatus?" + param)
					.then(resp => {
						console.log("reviewstatus" + resp);
						this.reviewstatus = resp.data.list;
						console.log("this.reviewstatus----" + this.reviewstatus)
					})
					.catch(err => {
						console.log(err);
					})
			},


		},
		mounted() { //钩子函数，进行页面初始化
			this.myquer();
			// this.getbrand("");
			// this.getclor("");
			this.gettype();
			this.getreviewstatus("");
		},

	}
</script>

<style>
</style>
