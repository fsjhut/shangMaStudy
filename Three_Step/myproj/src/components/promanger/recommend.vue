<template>
	<div>
		
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>产品管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品推荐管理</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<el-form ref="queryform" :inline="true" :model="queryform" class="demo-form-inline " style="width: 100%">
			<el-form-item label="系列名称" prop="productName">
				<el-input v-model="queryform.productName" placeholder="产品名称"></el-input>
			</el-form-item>

			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
				<el-button @click="myReset">重置</el-button>
				
				
			</el-form-item>
			
			<div style="margin-left:-35%;">
				<el-button type="success" @click="addFormOpen">添加</el-button>
				<el-button type="success" :disabled="btnstatus" @click="buyFormOpen">关联申购</el-button>
				<el-button type="warning" :disabled="btnstatus" @click="editFormOpen">修改</el-button>
				
			</div>
		</el-form>



		<el-table ref="singleTable" align="center":data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%">
			<el-table-column property="productName" align="center" label="产品名称" width="180">
			</el-table-column>
			<el-table-column property="recommendation" align="center" label="推荐度" width="180">
			</el-table-column>
			<el-table-column property="ifFirst" align="center" label="是否首发" width="180">
			</el-table-column>
			<el-table-column property="netBuy" align="center" label="线上申购" width="180">
			</el-table-column>
			<el-table-column property="orderId" align="center" label="排序" width="180">
			</el-table-column>
		</el-table>


		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.page"
		 :page-sizes="[5, 10,15, 20]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper"
		 :total="pageInfo.total">
		</el-pagination>


		<!-- form -->
		<el-dialog title="添加" :visible.sync="addFormVisible" width="30%">
			<el-form ref="addform" :model="addform"  >
				<el-form-item label="推荐产品"  >
					<el-select v-model="addform.productName" clearable placeholder="请选择">
						<el-option v-for="item in product" :key="item.productName" :label="item.label" :value="item.productName">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="推荐度">
					<el-select v-model="addform.recommendation" clearable placeholder="请选择">
						<el-option v-for="item in recommenda" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="是否投顾端可见" prop="ifView">
					<el-radio v-model="addform.ifView" label="是">是</el-radio>
					<el-radio v-model="addform.ifView" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="是否首发" prop="ifFirst">
					<el-radio v-model="addform.ifFirst" label="是">是</el-radio>
					<el-radio v-model="addform.ifFirst" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="线上申购开启" prop="netBuy">
					<el-radio v-model="addform.netBuy" label="是">是</el-radio>
					<el-radio v-model="addform.netBuy" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="推荐理由" prop="recommendMsg">
					<el-input v-model="addform.recommendMsg" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addSubmit()">确 定</el-button>
			</div>
		</el-dialog>

		<el-dialog title="修改" :visible.sync="editFormVisible">
			<el-form ref="editform" :model="editform">
				<el-form-item label="推荐产品" prop="productName">
					<el-input v-model="editform.productName" autocomplete="off" :disabled="true"></el-input>
				</el-form-item>
				<el-form-item label="推荐度">
					<el-select v-model="editform.recommendation" clearable placeholder="请选择">
						<el-option v-for="item in recommenda" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="是否投顾端可见" prop="ifView">
					<el-radio v-model="editform.ifView" label="是">是</el-radio>
					<el-radio v-model="editform.ifView" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="是否首发" prop="ifFirst">
					<el-radio v-model="editform.ifFirst" label="是">是</el-radio>
					<el-radio v-model="editform.ifFirst" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="线上申购开启" prop="netBuy">
					<el-radio v-model="editform.netBuy" label="是">是</el-radio>
					<el-radio v-model="editform.netBuy" label="否">否</el-radio>
				</el-form-item>
				<el-form-item label="推荐理由" prop="recommendMsg">
					<el-input v-model="editform.recommendMsg" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSubmit()">确 定</el-button>
			</div>
		</el-dialog>


		<el-dialog title="关联申购" :visible.sync="buyFormVisible">
			<el-form ref="buyform" :model="editform">
				<el-transfer v-model="relationBuy" :data="data" :button-texts="['取消关联', '关联']">
				</el-transfer>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="buyFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="buySubmit()">确 定</el-button>
			</div>
		</el-dialog>



	</div>
</template>

<script>
	export default {
		data() {
			const generateData = _ => {
				const data = [];
				const recomends = ['PE香港平衡基金', '测试量化明星A', '全球量化私募对冲', '专项股权基金(ML)', '测试基金A', '测试基金B', '测试基金C'];
				recomends.forEach((recomend, index) => {
					data.push({
						label: recomend,
						key: index,
					});
				});
				return data;
			};

			return {
				// 关联申购
				buyFormVisible: false,
				data: generateData(),
				relationBuy: [],



				tableData: [],
				currentRow: null,

				pageInfo: {
					page: 3,
					pageSize: 30,
					total: 99
				},


				queryform: {
					productName: '',
				},

				addFormVisible: false,
				addform: {
					productName: '',
					recommendation: '',
					ifView: '',
					ifFirst: '',
					netBuy: '',
					recommendMsg: '',
				},

				product: [],

				recommenda: [{
					value: '热门推荐',
					label: '热门推荐'
				}, {
					value: '一般推荐',
					label: '一般推荐'
				}, {
					value: '不太推荐',
					label: '不太推荐'
				}],

				editFormVisible: false,
				editform: {
					orderId: '',
					productName: '',
					recommendation: '',
					ifView: '',
					ifFirst: '',
					netBuy: '',
					recommendMsg: '',
					relatioBuy: '',
				},

				// 按钮状态
				btnstatus: true,
			}
		},
		methods: {
			
			myReset(){ //
				this.$refs['queryform'].resetFields();
			},
			
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			// 点击行事件
			handleRowChange(val) {
				this.currentRow = val;
				// console.log(this.currentRow);
				this.btnstatus = false;
				//深克隆json对象 JSON.parse(JSON.stringify(this.currentRow)
				if (this.currentRow != null) {
					this.editform = JSON.parse(JSON.stringify(this.currentRow));
					// this.moneyreq.moneyName = this.currentRow.companyName;
					// this.moneyreq.sid = this.currentRow.sid;
				}
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);

				this.pageInfo.page = 1;
				this.pageInfo.pageSize = val;
				// 刷新table数据
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
					"&productName=" + this.queryform.productName;
				this.myquery(param);
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageInfo.page = val;
				// 刷新table数据
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
					"&productName=" + this.queryform.productName;
				this.myquery(param);
			},

			// 查询
			myquery(param) {
				this.$axios.get("recommend/query?" + param)
					.then(returnval => {
						// console.log(returnval.data)
						this.tableData = returnval.data.returnData
						this.pageInfo = returnval.data.pageInfo
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 条件查询
			queryData() {
				this.pageInfo.page = 1;
				// let param1=this.$qs.stringify(this.pageInfo)
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
					"&productName=" + this.queryform.productName;
				this.myquery(param);
			},
			// 添加前重置，清空内容
			addFormOpen() {
				this.addFormVisible = true;
				// this.$nextTick渲染后执行nextTick中的代码
				this.$nextTick(function() {
					this.$refs['addform'].resetFields();
				});
				// 发请求查询审核过的产品
				this.$axios.get("/review/queryState")
					.then(returnval => {
						// console.log(returnval)
						this.product = returnval.data.returnData
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 添加
			addSubmit() {
				this.addFormVisible = false;
				this.$axios.post("recommend/add", this.$qs.stringify(this.addform))
					.then(returnval => {
						console.log(returnval.data)
						// 提示
						if (returnval.data.returnCode == 3000) {
							this.$message({
								message: returnval.data.returnMsg,
								type: 'success'
							});
						} else if (returnval.data.returnCode == 4000) {
							// 失败提示信息
							this.$message.error(returnval.data.returnMsg);
						}
						// 刷新table数据
						let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
							"&productName=" + this.queryform.productName;
						this.myquery(param);
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 修改前重置
			editFormOpen() {
				this.editFormVisible = true;
			},
			// 修改
			editSubmit() {
				this.editFormVisible = false;
				// console.log(this.$qs.stringify(this.editform));
				this.$axios.post("recommend/edit", this.$qs.stringify(this.editform))
					.then(returnval => {
						console.log(returnval.data)
						// 提示
						if (returnval.data.returnCode == 3000) {
							this.editform =
								this.$message({
									message: returnval.data.returnMsg,
									type: 'success'
								});
						} else if (returnval.data.returnCode == 4000) {
							// 失败提示信息
							this.$message.error(returnval.data.returnMsg);
						}
						// 刷新table数据
						let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
							"&productName=" + this.queryform.productName;
						this.myquery(param);
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 关联申购前重置
			buyFormOpen() {
				this.buyFormVisible = true;
				this.$nextTick(function() {
					this.$refs['buyform'].resetFields();
				});
				this.$axios.get("recommend/queryrelationBuy?orderId=" + this.editform.orderId)
					.then(returnval => {
						this.relationBuy = returnval.data.returnData
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 关联申购
			buySubmit() {
				// console.log(this.relationBuy.toString())
				this.buyFormVisible = false
				this.$axios.get("recommend/editrelationBuy?relationBuy=" + this.relationBuy.toString() +
						"&orderId=" + this.editform.orderId)
					.then(returnval => {
						console.log(returnval.data)
						// 提示
						if (returnval.data.returnCode == 3000) {
							this.editform =
								this.$message({
									message: returnval.data.returnMsg,
									type: 'success'
								});
						} else if (returnval.data.returnCode == 4000) {
							// 失败提示信息
							this.$message.error(returnval.data.returnMsg);
						}
						// 刷新table数据
						let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
							"&productName=" + this.queryform.productName;
						this.myquery(param);
					})
					.catch(err => {
						console.log(err)
					})
			},




		},
		mounted() {
			this.myquery("");
		},
		watch: {
			//监控数据 列表更新，按钮状态禁用
			tableData: function() {
				this.$nextTick(function() {
					// 数据更新后 更改按钮状态
					this.btnstatus = true
				})
			}
		},
		
		



	}
</script>

<style>
	.el-transfer {
		text-align: left;
	}
	.el-main {
	
		line-height: 40px;
	}
</style>
