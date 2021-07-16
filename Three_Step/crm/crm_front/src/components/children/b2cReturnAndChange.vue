<template>
	<div>
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="订单编号">
				<el-input v-model="queryForm.orderNumber" placeholder="订单编号"></el-input>
			</el-form-item>
			<el-form-item label="记录人">
				<el-input v-model="queryForm.orderNumber" placeholder="记录人"></el-input>
			</el-form-item>
			<el-form-item label="审批人">
				<el-input v-model="queryForm.orderNumber" placeholder="审批人"></el-input>
			</el-form-item>
			<el-form-item label="单据状态">
				<el-select v-model="queryForm.orderType" placeholder="--------">
					<el-option label="全部"></el-option>
					<el-option label="未审核" value="商城订单"></el-option>
					<el-option label="已通过" value="网络订单"></el-option>
					<el-option label="未通过" value="电话订单"></el-option>
					<el-option label="未入库" value="秒杀订单"></el-option>
					<el-option label="已入库" value="1"></el-option>
				</el-select>
			</el-form-item>
			<el-row>
				<el-col :span="8">
					
					<div class="block">
					    <span class="demonstration">申诉时间</span>
					    <el-date-picker
					      v-model="value1"
					      type="datetimerange"
					      range-separator="至"
					      start-placeholder="开始日期"
					      end-placeholder="结束日期">
					    </el-date-picker>
					  </div>
			
			</el-col>
				
			<el-col :span="8">
				<div class="block">
				    <span class="demonstration">审批时间</span>
				    <el-date-picker
				      v-model="value2"
				      type="datetimerange"
				      range-separator="至"
				      start-placeholder="开始日期"
				      end-placeholder="结束日期">
				    </el-date-picker>
				  </div>
				
			
			</el-col>
			
			
			
			</el-row>
			
				<el-button type="primary" @click="onAdd">新增申诉记录</el-button>
			<el-button type="primary" @click="onQuery">搜索</el-button>
			<el-button type="primary" @click="onOut">导出</el-button>
			
		</el-form>
		<!-- 		<el-form-item>
			<el-button type="primary" @click="onAdd">生成销售单</el-button>
		</el-form-item> -->
		<!-- 表格数据 -->
		
		<el-table ref="selectTableDate" :data="tableData" style="width: 100%" stripe
		 >
			<el-table-column prop="index" label="序号" width="100">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column type="selection" width="55"> </el-table-column>
			<el-table-column prop="orderNumber" label="订单编号" width="180">
			</el-table-column>
			<el-table-column prop="statementRecordName" label="申诉记录名称" sortable width="150">
			</el-table-column>
			<el-table-column prop="noteTaker" label="记录人" width="140">
			</el-table-column>
			<el-table-column prop="approvalTime" label="记录时间" width="140" >
			</el-table-column>
			<el-table-column prop="approved" label="审批人" width="140" >
			</el-table-column>
			<el-table-column prop="approvalTime" label="审批时间" width="140" >
			</el-table-column>
			<el-table-column prop="returnType" label="单据状态" width="140" >
			</el-table-column>
			
			<el-table-column prop="operate" label="操作" width="250">
				
				<template slot-scope="scope">
					<el-button type="success" circle @click="onSelect(scope.row)">查看</el-button>
					
						<el-button type="primary" circle @click="onDelect">删除</el-button>
					<el-button type="primary" circle @click="onCheck(scope.row)">审核跟踪</el-button>
				</template>
				
				
					
				
			</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="queryForm.pageNum"
		 :page-sizes="[5, 10, 15, 20]" :page-size="queryForm.pageSize" layout="total, sizes, prev, pager, next, jumper"
		 :total="queryForm.total">
		</el-pagination>


		<!-- 退货申请单详细信息模态框*************************  -->
		
		<el-dialog title="退货申请单详细信息" :visible.sync="centerVisible" width="70%" center>
		<el-form ref="promoteSaleDate" :model="customerComplaintData" label-width="120px">
			<el-row>
				<el-form-item label="申诉基本信息:">
				</el-form-item>
			</el-row>
			<el-row>
				<el-col :span="5">
					<el-form-item label="单据编号">
						<el-input :readonly="true" v-model="customerComplaintData.cid"></el-input>
					</el-form-item>
					
				</el-col>
				<el-col :span="7">
					<el-form-item label="制单人">
						<el-input :readonly="true" v-model="customerComplaintData.makePeople"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="制单时间">
						<el-input :readonly="true" v-model="customerComplaintData.createTime"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				
				<el-col :span="10">
					<el-form-item label="申诉记录名称">
						<el-input :readonly="true" v-model="customerComplaintData.cname"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-form-item label="申诉来源">
						<el-input :readonly="true" v-model="customerComplaintData.sourceRepresentation"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				
				<el-col :span="20">
					<el-form-item label="申诉记录描述">
						<el-input :readonly="true" v-model="customerComplaintData.complaintDescription"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		
		<!-- 订单基本资料********** -->
			
				<el-form ref="orderDeatail" :model="orderDeatail" label-width="120px">
					<el-row>
						<el-form-item label="订单基本信息:">
						</el-form-item>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="订单编号">
								<el-input :readonly="true" v-model="orderDeatail.orderNumber"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="下单日期">
								<el-input :readonly="true" v-model="orderDeatail.creatTime"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="订单类型">
								<el-input :readonly="true" v-model="orderDeatail.orderType"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="订单动作">
								<el-input :readonly="true" v-model="orderDeatail.orderAction"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="业务类型">
								<el-input :readonly="true" v-model="orderDeatail.businessTypes"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<el-form-item label="订单状态">
								<el-input :readonly="true" v-model="orderDeatail.orderState"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
				</el-form>
			
				<!-- 收货人表格 -->
				<el-form ref="consigneeInfo" :model="consigneeInfo" label-width="120px">
					<el-row>
						<el-form-item label="收货人信息:">
						</el-form-item>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="收货人姓名:">
								<el-input :readonly="true" v-model="consigneeInfo.consigneeName"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="会员账号:">
								<el-input :readonly="true" v-model="consigneeInfo.consigneeAccount"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="联系电话:">
								<el-input :readonly="true" v-model="consigneeInfo.consigneeAccount"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="联系手机:">
								<el-input :readonly="true" v-model="consigneeInfo.consigneePhone"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="邮政编码:">
								<el-input :readonly="true" v-model="consigneeInfo.zipCode"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="收货地址:">
								<el-input :readonly="true" v-model="consigneeInfo.consigneeAddress"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="配送地区:">
								<el-input :readonly="true" v-model="consigneeInfo.distributionRegion"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="配送方式:">
								<el-input :readonly="true" v-model="consigneeInfo.distributionWay"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="配送费用:">
								<el-input :readonly="true" v-model="consigneeInfo.distributionMoney"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="支付方式:">
								<el-input :readonly="true" v-model="consigneeInfo.payMethod"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="自提时间:">
								<el-input :readonly="true" v-model="consigneeInfo.extractTime"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="电子邮箱:">
								<el-input :readonly="true" v-model="consigneeInfo.emil"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="汇款人:">
								<el-input :readonly="true" v-model="consigneeInfo.remitter"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
				</el-form>
				<!-- 商品信息 -->
				<el-row>
				<el-col :push="1">退还订单商品信息:
				</el-col>
			</el-row>
			<el-row :gutter="20">
				<el-col :span="18" :offset="3">
					<el-table ref="productDate" :data="productDate" stripe style="width: 100%">
						<el-table-column prop="goodsCode" label="商品编号" width="120">
						</el-table-column>
						<el-table-column prop="goodsIem" label="商品串码" width="150">
						</el-table-column>
						<el-table-column prop="goodsName" label="商品名称" width="150">
						</el-table-column>
						<el-table-column prop="goodsPrice" label="单价" width="100">
						</el-table-column>
						<el-table-column prop="goodsCount" label="数量" width="120">
						</el-table-column>
						<el-table-column prop="totalAmount" label="总金额" width="100">
						</el-table-column>
					</el-table>
				</el-col>
			</el-row>
				<!-- 销售出库单信息，可以隐藏 -->
				
				
		
		<!-- 订单退换商品信息******** -->
		<el-form ref="promoteSaleDate" :model="customerComplaintData" label-width="120px">
			<el-row>
				<el-col :push="1">退还订单商品信息:
				</el-col>
			</el-row>
			
			
			<el-row>
				<el-col :push="1">退还商品类型:
				</el-col>
				<el-form-item >
					<el-input :readonly="true" v-model="tuiDate"></el-input>
				</el-form-item>
			</el-row>
			
			
			<el-row>
					<el-form-item label="换货原因">
						<el-input :readonly="true" v-model="customerComplaintData.orderNumber"></el-input>
					</el-form-item>
				</el-row>
				
			<el-row>
				
				<el-col :span="10">
					<el-form-item label="检修单号">
						<el-input :readonly="true" v-model="customerComplaintData.cid"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-form-item label="客户申请时间">
						<el-input :readonly="true" v-model="customerComplaintData.createTime"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="10">
					<el-form-item label="检修点名称">
						<el-input :readonly="true" v-model="customerComplaintData.maintenancePoint"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="10">
					<el-form-item label="检修点电话">
						<el-input :readonly="true" v-model="customerComplaintData.maintenancePhone"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-form-item label="客户答复信息:">
				</el-form-item>
			</el-row>
			
			
			<el-row>
				<el-col :span="10">
					<el-form-item label="客服答复意见:">
						<el-input :readonly="true" v-model="customerComplaintData.replyComment"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-form-item label="客服答复日期:">
						<el-input :readonly="true" v-model="customerComplaintData.createTime"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-form-item label="备注:">
					<el-input :readonly="true" v-model="customerComplaintData.cdesc"></el-input>
				</el-form-item>
			</el-row>
			
		</el-form>
		
		<el-row>
			<el-col :offset="10">
				<el-button type="primary" icon="el-icon-refresh-left" @click="returnMenu" round>返回</el-button>
			</el-col>
		</el-row>
					
		</el-dialog>
		
		
		
		
		

		<!-- 订单详情界面的模态框 -->
		
	</div>
</template>

<script>
	export default {
		data() {
			return {
				// 退换货申请客服审核-------------------
				centerVisible:false,
				tuiDate:'',
				orderData:{},
				customerComplaintData:{},
				customerComplaintData:{},
				consigneeData:{},
				//--------------------------
				//时间框
				pickerOptions: {
					shortcuts: [{
						text: '今天',
						onClick(picker) {
							picker.$emit('pick', new Date());
						}
					}, {
						text: '昨天',
						onClick(picker) {
							const date = new Date();
							date.setTime(date.getTime() - 3600 * 1000 * 24);
							picker.$emit('pick', date);
						}
					}, {
						text: '一周前',
						onClick(picker) {
							const date = new Date();
							date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
							picker.$emit('pick', date);
						}
					}]
				},
				value1:'',
				value2: '',
				
				// 订单详情的模态框
				orderDeatail: {},
				consigneeInfo: {},
				goDownMsg: {},
				centerDialogVisible: false,
				currentPage: 1,
				tableData: [],
				inputStatus: true,
				showGodown: false,
				productDate: [],
				goDownDate: [],
				queryForm: {
					orderNumber: '',
					orderType: '',
					payMethod: '',
					businessTypes: '',
					orderAction: '',
					orderState: '',
					pageNum: 1,
					pageSize: 5,
					total: undefined
				},
				goDownDate: {
					applicant: '',
					verifyTable: '',
					verifyTableId: '',
					verifyPerson: '',
					verifyStatus: '',
					verifySuggestion: ''
				},
			}
		},
		methods: {

			returnMenu() {
				this.centerVisible = false;
			},
			onSelect(val) {
				this.centerVisible = true;
				console.log(this.tuiDate)
				
				
				this.$axios.get("/customerComplaintForm/1" )
				// this.$axios.get("/b2cOrder/" + orderId)
					.then(resp => {
						this.orderDeatail = resp.data.orderDeatail;
						this.consigneeInfo = resp.data.consigneeInfo;
						this.productDate = resp.data.productDate;
						this.customerComplaintData=resp.data.customerComplaintData;
						if(resp.data.goDownMsg==null || resp.data.goDownMsg==undefined){
						this.goDownMsg = {};
						}
						this.queryForm.pageNum = resp.data.pageNum;
						this.queryForm.pageSize = resp.data.pageSize;
						this.queryForm.total = resp.data.total;
						
							this.tuiDate=this.customerComplaintData.solutions
							
						
						
					}).catch(function(err) {
						console.log(err)
					})
				
				
				
				
			},
			onCheck(val) {
				this.centerDialogVisible = true;

			},
			updateVerify() {
				this.verifyRemark.applicant = this.promoteSaleDate.createBy;
				this.verifyRemark.verifyTableId = this.promoteSaleDate.promoteId;
				this.verifyRemark.verifyTable = "promote_sale";
				let jsonStr = {
					"Verify": this.verifyRemark
				};
				
			},
			returnPromote() {
				this.centerDialogVisible = false;
			},
			onQuery() {
				this.selectPromoteList();
			},
			onAdd() {
				
			
			},
			onOut() {
				
			
			},
			onDelect() {
				
			
			},
			selectPromoteList() {
				this.$axios.get("b2cReturnForm/list")
					.then(resp => {
						console.log(resp.data);
						//给用户提示
						if (resp.code == 20000) {
							this.tableData=resp.data.list;
							this.$message({
								message: resp.data.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.data.msg);
						}
						
					})
					.catch(err => {
				
					})
			},

			// 页面相关的函数
			handleSizeChange(pageSize) {
				this.queryForm.pageSize = pageSize;
				this.selectPromoteList();
				console.log(`每页 ${val} 条`);
			},
			handleCurrentChange(pageNum) {
				this.queryForm.pageNum = pageNum;
				this.selectPromoteList();
				console.log(`当前页: ${val}`);
			},
		},
		mounted() {
			this.selectPromoteList();
		}
	}
</script>

<style>
	.demo-table-expand {
		font-size: 0;
	}

	.demo-table-expand label {
		width: 90px;
		color: #99a9bf;
	}

	.demo-table-expand .el-form-item {
		margin-right: 0;
		margin-bottom: 0;
		width: 50%;
	}
</style>
