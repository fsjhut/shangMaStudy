<template>
	<div>
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="活动名称">
				<el-input v-model="queryForm.orderNumber" placeholder="订单编号"></el-input>
			</el-form-item>
			<el-form-item label="订单类型">
				<el-select v-model="queryForm.orderType" placeholder="订单类型">
					<el-option label="全部"></el-option>
					<el-option label="商城订单" value="商城订单"></el-option>
					<el-option label="网络订单" value="网络订单"></el-option>
					<el-option label="电话订单" value="电话订单"></el-option>
					<el-option label="秒杀订单" value="秒杀订单"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="支付方式">
				<el-select v-model="queryForm.payMethod" placeholder="支付方式">
					<el-option label="全部" value=""></el-option>
					<el-option label="货到付款" value="货到付款"></el-option>
					<el-option label="网上支付" value="网上支付"></el-option>
					<el-option label="支付宝" value="支付宝"></el-option>
					<el-option label="微信" value="微信"></el-option>
					<el-option label="上门自提" value="上门自提"></el-option>
					<el-option label="银行汇款" value="银行汇款"></el-option>
				</el-select>
			</el-form-item>
			<br>
			<el-form-item label="业务类型">
				<el-select v-model="queryForm.businessTypes" placeholder="业务类型">
					<el-option label="全部" value=""></el-option>
					<el-option label="普通业务" value="普通业务"></el-option>
					<el-option label="号卡套餐" value="号卡套餐"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="订单动作">
				<el-select v-model="queryForm.orderAction" placeholder="订单动作">
					<el-option label="全部" value=""></el-option>
					<el-option label="订购" value="订购"></el-option>
					<el-option label="换购" value="换购"></el-option>
					<el-option label="支付" value="支付"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="订单状态">
				<el-select v-model="queryForm.orderState" placeholder="订单状态">
					<el-option label="全部" value=""></el-option>
					<el-option label="审核通过" value="审核通过"></el-option>
					<el-option label="已出库" value="已出库"></el-option>
					<el-option label="已发货" value="已发货"></el-option>
					<el-option label="已到货" value="已到货"></el-option>
					<el-option label="已归档" value="已归档"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onQuery">查询</el-button>
				<el-upload class="upload-demo" action="" :http-request="inputExcel" 
				
				 
				
				 :file-list="fileList" name="myfile">
				<!-- :on-preview="handlePreview" :on-remove="handleRemove"
				  :before-remove="beforeRemove" 
				  multiple 
				  :limit="3"
				  :on-exceed="handleExceed" -->
					<el-button size="big" type="success">导入</el-button>
				</el-upload>
			<el-button type="primary" @click="outExcel">导出</el-button>
				<!-- <el-button type="primary" @click="outWord()" v-show="!showGodown">生成出库单</el-button> -->
			</el-form-item>
		</el-form>

		<!-- 表格数据 -->
		<el-table ref="selectTableDate" :data="tableData" style="width: 100%" stripe :cell-style="rowStyle">
			<el-table-column prop="index" label="序号" width="100">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column type="selection" width="55"> </el-table-column>
			<el-table-column prop="orderNumber" label="订单编号" width="180">
			</el-table-column>
			<el-table-column prop="orderType" label="订单类型" sortable width="150">
			</el-table-column>
			<el-table-column prop="orderAction" label="订单动作" width="150">
			</el-table-column>
			<el-table-column prop="businessTypes" label="业务类型" width="150" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="payMethod" label="支付方式" width="150" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="distribution" label="配送方式" width="150" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="orderState" label="订单状态" width="150" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="operate" label="操作" width="200">
				<template slot-scope="scope">
					<el-button type="primary" circle @click="selectOrderDetail(scope.row)">查看</el-button>

				</template>
			</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
			:current-page="queryForm.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="queryForm.pageSize"
			layout="total, sizes, prev, pager, next, jumper" :total="queryForm.total">
		</el-pagination>

		<!-- 订单详情界面的模态框 -->
		<el-dialog title="订单详情" :visible.sync="centerDialogVisible" width="55%" center>
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
				<el-col :push="1">订单商品信息:
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
			<el-row>
				<el-col :push="1"><span :hidden="showGodown">销售出库单记录信息:</span>
				</el-col>
			</el-row>
			<el-form ref="goDownMsg" :model="goDownMsg" label-width="120px" v-show="!showGodown">
				<el-row>
					<el-col :span="10">
						<el-form-item label="创建人:">
							<el-input :readonly="true" v-model="goDownMsg.operatePerson"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="创建时间:">
							<el-input :readonly="true" v-model="goDownMsg.createTime"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
			<el-row>
				<el-col :offset="10">
					<el-button type="primary" icon="el-icon-refresh-left" @click="returnMenu" round>返回</el-button>
				</el-col>
			</el-row>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				// 订单详情的模态框
				orderDeatail: {},
				consigneeInfo: {},
				goDownMsg: {
					operatePerson: '',
					createTime: '',
				},
				centerDialogVisible: false,
				currentPage: 1,
				tableData: [],
				inputStatus: true,
				showGodown: true,
				productDate: [],
				fileList: [{
					name: '',
					url: ''
				}],
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
			}
		},
		methods: {
			
			// handleRemove(file, fileList) {
			// 	console.log(file, fileList);
			// },
			// beforeRemove(file, fileList) {
			// 	return this.$confirm(`确定移除 ${ file.name }？`);
			// },
			// handleExceed(files, fileList) {
			// 	this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
			// },
			// handlePreview(file) {
			// 	console.log(file);
			// },
			
			inputExcel(param){
				let formData = new FormData();
				formData.append("myfile", param.file);
				//导入
				
				this.$axios.post("b2cOrder/insertB2C",formData, {
						headers: {
							"Content-Type": "multipart/form-data"
						}
					})
				.then(resp=>{
					if(resp.code==20000){
												
								let myparam=this.$qs.stringify(this.Pageinfo)+"&"+this.$qs.stringify(this.selectform);
								this.selectOrderList(myparam);
								
												 // this.btnStatus = true;//将按钮状态改为禁用,没有起作用？
								
								this.$message({
											 showClose: true,
											 message: resp.msg,
											type: 'success'
											 });
													 
								}else if(resp.code==50000){
												 // this.$message.error(returnVal.data.returnMsg)
										 this.$message({
										 showClose: true,
										 message: "失败，数据为以重复数据",
										 type: 'warning'
											 });
									 }  
					})
			},
			/* 导出 */
			outExcel() {
				console.log(this.queryForm)
				// insertB2C2
				this.$axios.post("b2cOrder/educe",
				
					this.queryForm
				).then(resp => {
					if (resp.code == 20000) {
						this.$message({
							showClose: true,
							message: resp.msg,
							type: 'success'
						});
					} else if (resp.code == 50000) {
						this.$message({
							showClose: true,
							message: resp.msg,
							type: 'error'
						});
					}
					console.log(resp)
				}).catch(err => {
					console.log(err)
				})
			},		
			returnMenu() {
				this.centerDialogVisible = false;
				this.orderDeatail = {};
				this.consigneeInfo = {};
				this.goDownMsg = {};
				this.productDate = [];
			},
			selectOrderDetail(val) {
				let orderId = val.id;
				this.centerDialogVisible = true;
				debugger;
				this.$axios.get("/b2cOrder/" + orderId)
				// this.$axios.get("/b2cOrder/" + orderId)
					.then(resp => {
						this.orderDeatail = resp.data.orderDeatail;
						this.consigneeInfo = resp.data.consigneeInfo;
						this.productDate = resp.data.productDate;
						
						this.queryForm.pageNum = resp.data.pageNum;
						this.queryForm.pageSize = resp.data.pageSize;
						this.queryForm.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			},
			onQuery() {
				this.selectOrderList();
			},
			selectOrderList() {
				this.$axios.get("/b2cOrder/list", {
					params: this.queryForm
				}).then(resp => {
					this.tableData = resp.data.list;
					this.queryForm.pageNum = resp.data.pageNum;
					this.queryForm.pageSize = resp.data.pageSize;
					this.queryForm.total = resp.data.total;
				})
			},

			// 页面相关的函数
			handleSizeChange(pageSize) {
				this.queryForm.pageSize = pageSize;
				this.selectOrderList();
				console.log(`每页 ${val} 条`);
			},
			handleCurrentChange(pageNum) {
				this.queryForm.pageNum = pageNum;
				this.selectOrderList();
				console.log(`当前页: ${val}`);
			},
		},
		mounted() {
			this.selectOrderList();
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

