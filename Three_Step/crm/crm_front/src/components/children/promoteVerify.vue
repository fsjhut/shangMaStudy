<template>
	<div>
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="活动名称">
				<el-input v-model="queryForm.promoteName" placeholder="活动名称"></el-input>
			</el-form-item>
			<el-form-item label="活动类型">
				<el-select v-model="queryForm.promoteType" clearable placeholder="活动类型">
					<!-- <el-option label="全部"></el-option> -->
					<el-option label="每日限量" value="1"></el-option>
					<el-option label="连续促销" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="审核状态">
				<el-select v-model="queryForm.promoteStatus" clearable placeholder="审核状态">
					<!-- <el-option label="全部" value=""></el-option> -->
					<el-option label="未审核" value="1"></el-option>
					<el-option label="已审核" value="3"></el-option>
					<el-option label="审核未通过" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onQuery">查询</el-button>
			</el-form-item>
		</el-form>
		<!-- 表格数据 -->
		<el-table ref="selectTableDate" :data="tableData" style="width: 100%" stripe
			:default-sort="{prop: 'startTime', order: 'descending'}" :cell-style="rowStyle"
			:header-cell-style="headStyle">
			<el-table-column prop="index" label="序号" width="100">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column prop="promoteName" label="活动名称" width="180">
			</el-table-column>
			<el-table-column prop="startTime" label="活动开始时间" sortable width="180">
			</el-table-column>
			<el-table-column prop="priceStartTime" label="价格生效时间" width="180">
			</el-table-column>
			<el-table-column prop="promoteStatus" label="审核状态" width="180" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="operate" label="操作" width="300">
				<template slot-scope="scope">
					<el-button type="primary" circle @click="onVerify(scope.$index,scope.row)" :disabled="scope.row.operate">审核
					</el-button>
					<el-button type="success" @click="onTrack(scope.row)" circle>跟踪</el-button>
				</template>
			</el-table-column>
		</el-table>

		<!-- 分页插件 -->
<!-- 		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
			:current-page="queryForm.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="queryForm.pageSize"
			layout="total, sizes, prev, pager, next, jumper" :total="queryForm.total">
		</el-pagination> -->


		<!-- 模态框 -->
		<el-dialog title="促销活动" :visible.sync="centerDialogVisible" width="48%" center>
			<el-form ref="promoteSaleDate" :model="promoteSaleDate" label-width="120px">
				<el-form-item label="活动名称">
					<el-input v-model="promoteSaleDate.promoteName" :disabled="inputStatus"></el-input>
				</el-form-item>
				<el-form-item label="活动开始时间">
					<el-date-picker v-model="promoteSaleDate.startTime" :readonly="inputStatus" type="datetime"
						placeholder="开始时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="活动结束时间">
					<el-date-picker v-model="promoteSaleDate.endTime" :readonly="inputStatus" type="datetime"
						placeholder="结束时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="活动类型">
					<el-select v-model="promoteSaleDate.promoteType" :disabled="inputStatus">
						<el-option v-for="item in activeOption" :key="item.value" :value="item.value"
							:label="item.label"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="活动商品">
					<el-table :data="productDate" stripe style="width: 100%" slot-scope="scope">
						<el-table-column prop="productId" label="id" width="50">
						</el-table-column>
						<el-table-column prop="productName" label="商品名字" width="80">
						</el-table-column>
						<el-table-column prop="productStock" label="库存数量" width="100">
						</el-table-column>
						<el-table-column prop="promoteNum" label="促销数量" width="100">
						</el-table-column>
						<el-table-column prop="marketPrice" label="市场价格" width="100">
						</el-table-column>
						<el-table-column prop="shoppingPrice" label="商场价格" width="100">
						</el-table-column>
						<el-table-column prop="promotePrice" label="促销价格" width="100">
						</el-table-column>
					</el-table>
				</el-form-item>
				<el-form-item label="活动情况或原因">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :disabled="inputStatus"
						v-model="promoteSaleDate.promoteDetail">
					</el-input>
				</el-form-item>
				<el-form-item label="活动策划文件">
					<a v-bind:href="promoteSaleDate.promoteFile">活动文件下载</a>
				</el-form-item>
				<el-form-item label="备注">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :disabled="inputStatus"
						v-model="promoteSaleDate.remark">
					</el-input>
				</el-form-item>
				<!-- 审核记录 -->
				<el-form-item label="">
					<el-table :data="verifyDate" stripe style="width: 100%" slot-scope="scope" v-show="showVerfiy">
						<el-table-column prop="applicant" label="申请人" width="140">
						</el-table-column>
						<el-table-column prop="verifyPerson" label="审批人" width="140">
						</el-table-column>
						<el-table-column prop="verifyTime" label="审批时间" width="150">
						</el-table-column>
						<el-table-column prop="verifyStatus" label="审批状态" width="150" :formatter="verifyStatus">
						</el-table-column>
						<el-table-column prop="verifySuggestion" label="审批意见" width="150">
						</el-table-column>
					</el-table>
				</el-form-item>
				<!-- 审核意见 -->
				<el-form-item label="审核意见">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-show="!showVerfiy"
						v-model=" verifyRemark.verifySuggestion">
					</el-input>
				</el-form-item> 
				<el-form-item prop="operate2" label="">
					<template slot-scope="scope">
						<el-button type="warning" @click="accept(scope.row)" v-show="!showVerfiy">通过</el-button>
						<el-button type="primary" @click="refuse(scope.row)" v-show="!showVerfiy">不通过</el-button>
						<el-button type="primary" @click="returnPromote" v-show="!showVerfiy">返回</el-button>
					</template>
				</el-form-item>
			</el-form>
	<!-- 		<el-form label-position="right" label-width="120px">
				
			</el-form> -->
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				test:true,
				textarea1: '',
				textarea2: '',
				promoteId: '',
				PromoteIndex:0,
				centerDialogVisible: false,
				currentPage: 1,
				tableData: [],
				activeOption: [{
					value: 1,
					label: '每日限量'
				}, {
					value: 2,
					label: '连续促销'
				}],
				inputStatus: true,
				showVerfiy: true,
				promoteSaleDate: {
					createBy: '',
					promoteId: '',
					promoteName: '',
					startTime: '',
					endTime: '',
					promoteType: '',
					priceStartTime: '',
					priceEndTime: '',
					promoteFile: '',
					promoteDetail: '',
					remark: '',
					promoteStatus: ''
				},
				productDate: [],
				verifyDate: [],
				percentAdjust: 100,
				queryForm: {
					promoteName: '',
					promoteType: '',
					promoteStatus: '',
					pageNum: 1,
					pageSize: 5,
					total: undefined
				},
				verifyRemark: {
					applicant:'',
					verifyTable:'',
					verifyTableId:'',
					verifyPerson:'',
					verifyStatus:'',
					verifySuggestion:''
				},
			}
		},
		methods: {
			accept(){
				// debugger
				this.verifyRemark.verifyStatus = 1;
				this.updateVerify();
				this.centerDialogVisible = false;
				this.selectPromoteList();
			},
			refuse(){
				this.verifyRemark.verifyStatus = 2;
				this.updateVerify();
				this.centerDialogVisible = false;
				this.selectPromoteList();
			},
			updateVerify(){
				this.verifyRemark.applicant = this.promoteSaleDate.createBy;
				this.verifyRemark.verifyTableId = this.promoteSaleDate.promoteId;
				this.verifyRemark.verifyTable = "promote_sale";
				let jsonStr = {
					"Verify": this.verifyRemark
				};
				this.$axios.post("/verify/add",jsonStr).then(resp => {
					if (resp.code == 20000) { 
						// this.tableData[PromoteIndex].operate = true;
						// debugger;
						this.$message({
							message: resp.msg,
							type: 'success'
						});
					} else if (resp.code == 50000) {
						this.$message.error(resp.msg);
					}
				})
				
			},
			returnPromote(){
				this.centerDialogVisible = false;
			},
			onVerify(index,val) {
				this.PromoteIndex = index;
				// debugger
				this.promoteId = val.promoteId;
				this.showVerfiy = false;
				this.inputStatus = true;
				this.centerDialogVisible = true;
				this.$axios.get("/promoteSale/" + val.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						console.log(this.productDate);
					});
				
			},
			onTrack(val) {
				this.promoteId = val.promoteId;
				this.inputStatus = true;
				this.centerDialogVisible = true;
				this.showVerfiy = true;
				this.$axios.get("/verify/" + this.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						this.verifyDate = resp.data.Verify;
						console.log(this.verifyDate);
						// debugger;
						
					});
			},
			rowStyle() {
				return "text-align:center"
			},
			headStyle() {
				return "text-align:center"
			},
			onQuery() {
				this.selectPromoteList();
			},
			promoteStatus(cellValue) {
				if (cellValue.promoteStatus == 1) {
					cellValue.operate = false;
					return "待审核";
				} else if (cellValue.promoteStatus == 2) {
					cellValue.operate = true;
					return "已驳回";
				} else if (cellValue.promoteStatus == 3) {
					cellValue.operate = true;
					return "已审核";
				} else {
					cellValue.operate = false;
					return "其他";
				}
			},
			verifyStatus(cellValue) {
				if (cellValue.verifyStatus == 1) {
					return "通过";
				} else if (cellValue.verifyStatus == 2) {
					return "驳回";
				}
			},
			selectPromoteList() {
				this.$axios.get("/verify/list", {
					params: this.queryForm
				}).then(resp => {
					this.tableData = resp.data;
					// this.tableData = resp.data.list;
					// // debugger
					// this.queryForm.pageNum = resp.data.pageNum;
					// this.queryForm.pageSize = resp.data.pageSize;
					// this.queryForm.total = resp.data.total;
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
</style>
