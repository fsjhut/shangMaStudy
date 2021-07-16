<template>
	<div>
		<template>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{}">返厂出入库管理</el-breadcrumb-item>
				<el-breadcrumb-item>返厂出库管理</el-breadcrumb-item>
				<el-breadcrumb-item>返厂出库单列表</el-breadcrumb-item>
			</el-breadcrumb>
			<br />
			<el-form ref="queryForm" :inline="true" :model="queryForm" class="demo-form-inline">
				<el-form-item label="返厂出库单号：" prop="outOrderNum">
					<el-input v-model="queryForm.outOrderNum" placeholder="返厂出库单号"></el-input>
				</el-form-item>
				<el-form-item label="返厂出库标志：" prop="outMark">
					<el-select v-model="queryForm.outMark" placeholder="返厂出库标志">
						<el-option label="全部" :value="0"></el-option>
						<el-option v-for="item in mark" :value="item.outMark" :label="item.outMark">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="审核状态" prop="auditStatus">
					<el-select v-model="queryForm.auditStatus" placeholder="审核状态">
						<el-option label="全部" :value="0"></el-option>
						<el-option v-for="item in status" :value="item.auditStatus" :label="item.auditStatus">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="制单人" prop="orderPerson">
					<el-input v-model="queryForm.orderPerson" placeholder="制单人"></el-input>

					</el-select>
				</el-form-item>

				<el-form-item>



					<!-- 	<el-button type="success" @click="openAddForm">创建一级商品</el-button>
						<el-button type="success" @click="openAddForm">创建二级商品</el-button> -->
				</el-form-item>



				<el-form-item label="制单时间" prop="createTime">
					<el-date-picker v-model="value1" type="datetimerange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期">
					</el-date-picker>
					</el-select>
				</el-form-item>
				<el-form-item label="审核时间" prop="auditTime">
					<el-date-picker v-model="value2" type="datetimerange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期">
					</el-date-picker>
					</el-select>
				</el-form-item>
				<el-form-item>
					<!-- <el-button type="warning" @click="myadd()">新增出库单</el-button> -->
					<!-- <el-button type="primary" @click="myoutexcel()">导出</el-button> -->
					<el-button type="success" @click="myquery()">搜索</el-button>
					<!-- <el-button type="danger" @click="mydelete()">删除</el-button> -->
				</el-form-item>
			</el-form>

			<br />
			<!-- <el-form-item>
					<el-button type="primary" @click="myquery">查询</el-button>
					<el-button type="danger" @click="myreset">重置</el-button>
				</el-form-item> -->

			</el-form>

			<el-table   :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
				<el-table-column  label="序号" width="60px " type="index">
				</el-table-column>
				<el-table-column type="selection" width="55"> </el-table-column>
				<el-table-column property="outOrderNum" label="返厂出库单号" width="160">
				</el-table-column>
				<el-table-column property="outMark" label="返厂出库标志" width="160">
				</el-table-column>
				<el-table-column property="orderPerson" label="制单人" width="100">
				</el-table-column>
				<el-table-column property="makeTime" label="制单时间" width="200">
				</el-table-column>
				<el-table-column property="auditPerson" label="审批人" width="100">
				</el-table-column>
				<el-table-column property="auditTime" label="审批时间" width="200">
				</el-table-column>
				<el-table-column property="auditStatus" label="审批状态" width="160">
				</el-table-column>

				<el-table-column label="操作" width="300">
					<template slot-scope="scope">
						<el-button type="primary" :disabled="disBtn" @click="openaudit()">审核</el-button>
						<el-button type="danger" :disabled="disBtn" @click="openauditForm">审核追踪</el-button>
					</template>
				</el-table-column>
			</el-table>


			<!--  要接受从后台返回的数据 页数 current-page="currentPage4" -->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[3, 6, 10]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>


			<el-dialog title="新增出库单" :visible.sync="addFormVisable" width="60%">

				<el-button @click="selexGoods()" type="warning">选择商品</el-button>
				<el-dialog title="选择商品" :visible.sync="selFormVisable" width="80%">
					<el-table :data="tableData3" stripe style="width: 100%">
						<el-table-column prop="goodsIem" label="商品串码">
						</el-table-column>
						<el-table-column prop="goodsName" label="商品名称">
						</el-table-column>
						<el-table-column prop="goodsColor" label="商品颜色">
						</el-table-column>
						<el-table-column prop="goodsBrand" label="商品品牌">
						</el-table-column>
						<el-table-column prop="goodsModel" label="商品型号">
						</el-table-column>
						<el-table-column prop="goodsSupply" label="商品供应商">
						</el-table-column>
						<el-table-column prop="complaintForm.cname" label="申述名称">
						</el-table-column>
						<el-table-column prop="goodsColor" label="商品跟踪信息">
						</el-table-column>
						<el-table-column prop="goodsColor" label="返厂配置">
						</el-table-column>
						<el-table-column prop="complaintForm.solutions" label="退换货类型 退货0  换货1">
						</el-table-column>
						<el-table-column prop="complaintForm.detailedInformation" label="问题详细信息">
						</el-table-column>
						<el-table-column prop="complaintForm.maintenancePoint" label="检修点">
						</el-table-column>
						<el-table-column label="操作" width="">
							<template slot-scope="scope">
								<el-button type="success" @click="myaddto()">确定添加</el-button>
							</template>
						</el-table-column>
					</el-table>
				</el-dialog>
				<el-table :data="tableData4" stripe style="width: 100%">
					<el-table-column prop="goodsIem" label="商品串码">
					</el-table-column>
					<el-table-column prop="goodsName" label="商品名称">
					</el-table-column>
					<el-table-column prop="goodsBrand" label="商品品牌">
					</el-table-column>
					<el-table-column prop="goodsColor" label="商品颜色">
					</el-table-column>
					<el-table-column prop="goodsModel" label="商品型号">
					</el-table-column>
					<el-table-column prop="goodsSupply" label="商品供应商">
					</el-table-column>
					<el-table-column prop="goodsFollowing" label="商品跟踪信息">
					</el-table-column>
					<el-table-column prop="returnSet" label="返厂配置">
					</el-table-column>
					<el-table-column label="操作" width="">
						<template slot-scope="scope">
							<el-button type="danger">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-form ref="addform" :model="addform" label-width="150px">
					<el-form-item label="返厂地点" prop="outArea">
						<el-input v-model="addform.outArea"></el-input>
					</el-form-item>

					<el-form-item label="返厂原因" prop="outReason">
						<el-input v-model="addform.outReason"></el-input>
					</el-form-item>
					<el-form-item label="备注" prop="outNote">
						<el-input v-model="addform.outNote"></el-input>
					</el-form-item>

					<el-button type="primary" @click="addFromSubmit">保存</el-button>
					<el-button @click="addFormVisable = false">取 消</el-button>
					</el-form-item>
					</el-form-item>
				</el-form>
			</el-dialog>



			<el-dialog title="查看出库单" :visible.sync="queryFormVisable" width="60%">
				<el-table :data="tableData2" stripe style="width: 100%">
					<el-table-column prop="goodsInfo.goodsIem" label="商品串码">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsBrand" label="商品品牌">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsName" label="商品名称">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsModel" label="商品型号">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsColor" label="商品颜色">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsSupply" label="商品供应商">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsFollowing" label="商品跟踪信息">
					</el-table-column>
					<el-table-column prop="goodsInfo.returnSet" label="返厂配置">
					</el-table-column>

				</el-table>
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>
					<el-form-item label="返厂地点" prop="outArea">
						<el-input v-model="query.outArea" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="返厂原因" prop="outReason">
						<el-input v-model="query.outReason" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="备注" prop="outNote">
						<el-input v-model="query.outNote" :readonly="true"></el-input>
					</el-form-item>


					<el-form-item>
						<el-button type="primary" @click="queryFromSubmit">返回</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>


			<el-dialog title="编辑出库单" :visible.sync="editFormVisable" width="60%">
				<el-table :data="tableData2" stripe style="width: 100%">
					<el-table-column prop="goodsInfo.goodsIem" label="商品串码">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsBrand" label="商品品牌">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsName" label="商品名称">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsModel" label="商品型号">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsColor" label="商品颜色">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsSupply" label="商品供应商">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsFollowing" label="商品跟踪信息">
					</el-table-column>
					<el-table-column prop="goodsInfo.returnSet" label="返厂配置">
					</el-table-column>

				</el-table>
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>
					<el-form-item label="返厂地点" prop="outArea">
						<el-input v-model="query.outArea"></el-input>
					</el-form-item>
					<el-form-item label="返厂原因" prop="outReason">
						<el-input v-model="query.outReason"></el-input>
					</el-form-item>
					<el-form-item label="备注" prop="outNote">
						<el-input v-model="query.outNote"></el-input>
					</el-form-item>


					<el-form-item>
						<el-button type="success" @click="editFromSubmit">保存编辑</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>


			<el-dialog title="审核追踪" :visible.sync="queryFormVisable2" width="60%">
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>
				<el-row>
					<el-col :span="7">
						<el-form-item label="出库单号">
							<el-input :readonly="true" v-model="query.outOrderNum"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="制单日期">
							<el-input :readonly="true" v-model="query.makeTime"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item label="制单人">
							<el-input :readonly="true" v-model="query.orderPerson"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				</el-form>


				<el-table :data="tableData2" stripe style="width: 100%">
					<el-table-column prop="goodsInfo.goodsIem" label="商品串码">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsBrand" label="商品品牌">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsName" label="商品名称">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsModel" label="商品型号">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsColor" label="商品颜色">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsSupply" label="商品供应商">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsFollowing" label="商品跟踪信息">
					</el-table-column>
					<el-table-column prop="goodsInfo.returnSet" label="返厂配置">
					</el-table-column>
				</el-table>
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>


					<el-form-item label="返厂地点" prop="outArea">
						<el-input v-model="query.outArea" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="返厂原因" prop="outReason">
						<el-input v-model="query.outReason" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="备注" prop="outNote">
						<el-input v-model="query.outNote" :readonly="true"></el-input>
					</el-form-item>
					<span>审核记录:</span>
					<!-- <el-form-item label="审批人" prop="auditPerson">
							<el-input v-model="query.auditPerson" :readonly="true"></el-input>
						</el-form-item></span>
					<el-form-item label="审批时间" prop="auditTime">
						<el-input v-model="query.auditTime" :readonly="true"></el-input>
					</el-form-item></span> -->
					<el-row>
						<el-col :span="6">
							<el-form-item label="审批人">
								<el-input :readonly="true" v-model="query.auditPerson"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="审批时间">
								<el-input :readonly="true" v-model="query.auditTime"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="6">
							<el-form-item label="审批状态">
								<el-input :readonly="true" v-model="query.auditStatus"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="审批意见">
								<el-input :readonly="true" v-model="query.advice"></el-input>
							</el-form-item>
						</el-col>
					</el-row>

					<el-form-item>
						<el-button type="primary" @click="queryFromSubmit1">返回</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>
			
			
			
			<el-dialog title="审核" :visible.sync="queryFormVisable3" width="60%">
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>
				<el-row>
					<el-col :span="7">
						<el-form-item label="出库单号">
							<el-input :readonly="true" v-model="query.outOrderNum"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="制单日期">
							<el-input :readonly="true" v-model="query.auditTime"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="制单人">
							<el-input :readonly="true" v-model="query.orderPerson"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				</el-form>
			
			
				<el-table :data="tableData2" stripe style="width: 100%">
					<el-table-column prop="goodsInfo.goodsIem" label="商品串码">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsBrand" label="商品品牌">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsName" label="商品名称">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsModel" label="商品型号">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsColor" label="商品颜色">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsSupply" label="商品供应商">
					</el-table-column>
					<el-table-column prop="goodsInfo.goodsFollowing" label="商品跟踪信息">
					</el-table-column>
					<el-table-column prop="goodsInfo.returnSet" label="返厂配置">
					</el-table-column>
				</el-table>
				<el-form ref="query" :model="query" label-width="130px" hide-required-asterisk>
					<el-form-item label="返厂地点" prop="outArea">
						<el-input v-model="query.outArea" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="返厂原因" prop="outReason">
						<el-input v-model="query.outReason" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="备注" prop="outNote">
						<el-input v-model="query.outNote" :readonly="true"></el-input>
					</el-form-item>
					<span>审核记录:</span>
					<el-row>
						<el-col :span="10">
						<!-- 	<el-form-item label="审批人">
								<el-input :readonly="true" v-model="query.auditPerson"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="审批时间">
								<el-input :readonly="true" v-model="query.auditTime"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="6">
							<el-form-item label="审批状态">
								<el-input  v-model="query.auditStatus"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10"> -->
							<el-form-item label="审批意见">
								<el-input  v-model="query.advice"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
			
					<el-form-item>
						<el-button type="success" @click="queryFromSubmit3()">审核通过</el-button>
						<el-button type="primary" @click="queryFromSubmit2">返回</el-button>
						<el-button type="danger" @click="queryFromSubmit4">审核不通过</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>
			

		



		</template>

	</div>
</template>

<script>
	export default {


		data() {
			return {

				tableData: [],
				tableData1: [],
				tableData2: [],


				tableData3: [], //	弹出的查询到的商品
				tableData4: [],
				currentRow: null,
				pageinfo: {
					pageNum: 1,
					pageSize: 3,
					total: 10
				},
				// loading: true,
				queryForm: {
					outOrderNum: '',
					outMark: '',
					auditStatus: '',
					orderPerson: '',
					createTime: '',
					auditTime: ''
				},
				disBtn: true,
				selFormVisable: false,
				addFormVisable: false,
				queryFormVisable: false,
				queryFormVisable2: false,
				queryFormVisable3:false,
				// queryFormVisable4:false,
				
				editFormVisable: false,
				query: {
					// tableData2: [],

					outArea: '',
					outReason: '',
					outNote: '',
					advice:''
				},
				addform: {
					// tableData1: [],
					outArea: '',
					outReason: '',
					outNote: ''
				},

				mark: [],
				status: [],
				value1: '',
				value2: '',
				AuditData:{},
				myDatas:{},
			}
		},
		methods: {

			// 变更当前行
			handleRowchange(val) {

				this.currentRow = val;
				this.myDatas=val;
				this.disBtn = false;
				// this.AuditData.applicant=val.orderPerson;
				console.log("当前行数据")
				// console.log(this.currentRow);
			},
			// page相关函数，size改变，查询按钮、重置按钮
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				// this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				let param = this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo);
				this.myquery(param); //刷新页数
			},
			//page改变
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageinfo.pageNum = val;
				let param = this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo);
				console.log("111" + param)
				this.myquery(param); //刷新页数
			},
			getmark() { //刷新商品审核标记的下拉框
				this.$axios.get("outManager/getType/out_mark")
					.then(resp => {

						console.log(resp);
						this.mark = resp;
						console.log("数据：")
						console.log(this.mark);
					})
					.catch(err => {
						console.log(err);
					})
			},

			getstatus() { //刷新审核状态的下拉框
				this.$axios.get("outManager/getType/audit_status")
					.then(resp => {

						console.log(resp);
						this.status = resp;
						console.log("数据：")
						console.log(this.status);
					})
					.catch(err => {
						console.log(err);
					})
			},

			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			// 查询重置
			myreset() {
				this.$refs['queryForm'].resetFields();
			},
			
			
			
			//点击打开查看框
			openQueryForm() {
				this.queryFormVisable = true;
				this.query = JSON.parse(JSON.stringify(this.currentRow));
				this.myquery();
				this.myquery2();
			},
			//提交修改保存
			queryFromSubmit() {
				this.queryFormVisable = false;

			},

			queryFromSubmit1() {
				this.queryFormVisable2 = false;

			},
			queryFromSubmit2(){
				console.log("打开模态框!")
				this.queryFormVisable3 = false;
			},
			//审核通过
			queryFromSubmit3(){
				console.log("---------------------------------'")
				console.log(this.query);
				
				this.AuditData.verifyId = 2000;
				this.AuditData.verifyStatus =1;
				this.AuditData.verifyTable = "out_manager";
				this.AuditData.applicant = this.query.orderPerson;
				this.AuditData.verifyTableId =this.query.outOrderNum+'';
				this.AuditData.verifySuggestion = this.query.advice; 
				 this.query.auditStatus='已审核';
				let data = Object.assign( this.AuditData, this.query);
				 // 1. 只要需要添加审核记录，就调用接口：post("ver/adds",data)                  // 2. 新增申请：                 //  this.AuditData.verifyId = 1000;                 //  this.AuditData.verifyStatus =0;                 //  this.AuditData.verifyTable = "你的申请表数据库表名";                   // 3. 审核通过：                 //  this.AuditData.verifyId = 2000;                 //  this.AuditData.verifyStatus =1;                 //  this.AuditData.verifyTable = "你的申请表数据库表名";                 //  this.AuditLogging.applicant = "你选中要修改的申请记录的创建人给这个赋值";                 //  this.AuditLogging.verifyTableId = "你选中要修改的申请记录的ID给这个赋值";                 //  this.AuditLogging.verifySuggestion = "你的审核意见";   // 3. 审核驳回： //  this.AuditData.verifyId = 2000; //  this.AuditData.verifyStatus =2; //  this.AuditData.verifyTable = "你的申请表数据库表名"; //  this.AuditLogging.applicant = "你选中要修改的申请记录的创建人给这个赋值"; //  this.AuditLogging.verifyTableId = "你选中要修改的申请记录的ID给这个赋值"; //  this.AuditLogging.verifySuggestion = "你的审核意见";

				this.queryFormVisable3 = false;
				console.log("进入————————————————————————————————————")
		        this.$axios.post("ver/adds",data)
				.then(resp=>{
					if(resp.code==20000){
						console.log(resp);
						console.log("执行成功审核！")
						this.myquery();
						this.$message.success("添加审核成功")
					}else{
						this.$message.error("添加审核记录失败")
										
						}
					
				}).catch(err=>{
					console.log("这是失败的添加记录")
				})
			},
			////审核不通过
			queryFromSubmit4(){
				this.queryFormVisable3 = false;
				
				this.AuditData.verifyId = 2000;
				this.AuditData.verifyStatus =1;
				this.AuditData.verifyTable = "out_manager";
				this.AuditData.applicant = this.query.orderPerson;
				this.AuditData.verifyTableId =this.query.outOrderNum+'';
				this.AuditData.verifySuggestion = this.query.advice; 
				 this.query.auditStatus='未审核';
				let data = Object.assign( this.AuditData, this.query);
				
				this.queryFormVisable3 = false;
				console.log("进入————————————————————————————————————")
				this.$axios.post("ver/adds",data)
				.then(resp=>{
					if(resp.code==20000){
						console.log(resp);
						console.log("审核不通过！")
						this.myquery();
						this.$message.success("审核不通过")
					}else{
						this.$message.error("添加审核记录失败")
										
						}
					
				}).catch(err=>{
					console.log("这是失败的添加记录")
				})
			},
			
			editFromSubmit() {
				this.editFormVisable = false;


			},
			//点击打开编辑框
			openEditForm() {
				this.editFormVisable = true;
				this.query = JSON.parse(JSON.stringify(this.currentRow));
				this.myquery();
				this.myquery2();
			},
			
			//审核框 
			openaudit(){
				console.log("打开审核框：")
				this.queryFormVisable3 = true;
				this.query = JSON.parse(JSON.stringify(this.currentRow));
				this.myquery();
				this.myquery2();
				console.log(this.currentRow);
				console.log(this.query);
			},
			

            //审核追踪框
			openauditForm() {

				this.queryFormVisable2 = true;
				this.query = JSON.parse(JSON.stringify(this.currentRow));
				this.myquery();
				this.myquery2();
			},
			myaddto() {
				this.selFormVisable = false;
				console.log("11111111111111111111111" + this.tableData3[0].goodsBrand)
				this.tableData4 = this.tableData3;
				// this.tableData4.goodsBrand = this.tableData3[0].goodsBrand;
				console.log(this.tableData4)
				// console.log(this.tableData3[0]);
			},


			//新增出库单
			myadd() {
				this.addFormVisable = true;
				this.$nextTick(function() {
					this.resetForm('addform');
				})
			},
			//添加是提交保存按钮
			addFromSubmit() {
				// this.addform=1;
				this.addFormVisable = false;
				this.$axios.post("outManager/add/", this.addform)
					.then(resp => {
						console.log(resp.code);
						if (resp.code == 20000) {

							this.$message({
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg);
						}
						this.addFormVisable = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
					})
			},


			selexGoods() {
				// let a = { ...this.pageinfo,
				// 	...this.queryForm
				// }
				// let a = Object.assign(this.pageinfo,this.queryForm);
				this.selFormVisable = true;
				this.$axios.get("goodsInfo/selectExchangeGoods")
					.then(resp => {
						// console.log(resp.data.list)
						console.log("标记3");
						this.tableData3 = resp.data.list;
						console.log(this.tableData3)
						// this.tableData4=this.tableData3;

						// console.log(resp.data)
						// this.pageinfo.pageNum = resp.data.pageNum;
						// this.pageinfo.pageSize = resp.data.pageSize;
						// this.pageinfo.total = resp.data.total;

					}).catch(err => {
						console.log(err);
					});
				console.log("标记1");

			},
			myquery() {
				// this.queryFormVisable=true;
				this.query.auditStatus="未审核"
				let a = { ...this.pageinfo,
					...this.queryForm,
				}
				
				console.log(this.$qs.stringify(a))
				// debugger
				// let a = Object.assign(this.pageinfo,this.queryForm);
				this.$axios.get("outManager/list?" + this.$qs.stringify(a))
					.then(resp => {
						// console.log(resp.data.list)
						// console.log("标记3");
						this.tableData = resp.data.list;
						// debugger;
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}).catch(err => {
						console.log(err);
					});
				// console.log("标记1");
			},
			myquery2() {
				let b = this.currentRow.outOrderNum;
				this.$axios.get("outManager/selectGoods/" + b)
					.then(resp => {
						console.log("11111111111");
						console.log(resp);
						this.tableData2 = resp;
						// console.log(this.tableData2)
						// let a  = resp[0].goodsInfo;
						// resp[0].goodsInfo.
						// console.log(a);
						// this.tableData2 = a;
					}).catch(function(err) {
						console.log(err)
					})
			},



		},

		//监听  操作完成  进行页面渲染
		mounted() {
			this.myquery();
			this.getmark();
			this.getstatus();

		},
	}
</script>

<style>
	 body {
	    margin: 0;
	  }

</style>
