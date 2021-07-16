<template>
	<div>
		
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>产品管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品审核</el-breadcrumb-item>
		
			</el-breadcrumb>
		</div>
		<!-- 条件查询-->
		<el-form :inline="true" ref="queryfrom" :model="queryfrom" class="demo-form-inline">
			<el-form-item label="产品名称" prop="productName">
				<el-input v-model="queryfrom.productName" placeholder="产品名称"></el-input>
			</el-form-item>
			<el-form-item label="审核状态" prop="reviewState">
				<el-select v-model="queryfrom.reviewState" placeholder="审核状态">
					<el-option v-for="query in stateQuery" :label="query.name" :value="query.name"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
				<el-button @click="myReset">重置</el-button>
				<el-button type="warning" :disabled="buttonstate" @click="myEdit">操作</el-button>
			</el-form-item>
		</el-form>

		<!-- 展示页面-->
		<el-table ref="singleTable" align="center":data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%">

			<el-table-column property="productName" align="center" label="产品名称" width="200">
			</el-table-column>

			<el-table-column property="productSecCategory" align="center" label="二级分类" width="180">
			</el-table-column>
			</el-table-column>
			<el-table-column property="createPeople" align="center" label="创建人" width="150">
			</el-table-column>
			<el-table-column property="createTime" align="center" label="首次创建时间" :formatter="dateFormat" width="200">
			</el-table-column>
			<el-table-column property="updateTime" align="center" label="最新修改时间" :formatter="dateFormat" width="200">
			</el-table-column>
		</el-table>

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.page"
		 :page-sizes="[5, 10, 15, 20]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>


		<!-- 修改表单-->
		<el-dialog title="产品详情" :visible.sync="editFormVisible" >
			<el-form ref="myeditform" :model="editform">
				<span>基本信息</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品系列" :label-width="formLabelWidth" prop="productCategoryName">
							<el-input v-model="editform.productCategoryName" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="二级分类" :label-width="formLabelWidth" prop="productSecCategory">
							<el-input v-model="editform.productSecCategory" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="产品名称" :label-width="formLabelWidth" prop="productName">
							<el-input v-model="editform.productName" :disabled="true" autocomplete="off"></el-input>
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
							<el-input v-model="editform.annualized" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="货币类型" :label-width="formLabelWidth" prop="fundCurrency">
							<el-input v-model="editform.fundCurrency" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<span>认购属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="开放日期"  :label-width="formLabelWidth" prop="opDate">
							<el-date-picker
							 v-model="editform.opDate" 
							 type="date" 
							 placeholder="选择日期" 
							 :disabled='true'
							 >
							</el-date-picker> 
							
							
							
							<!-- <el-input v-model="editform.opDate" :disabled="true" autocomplete="off"></el-input> -->
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购周期" :label-width="formLabelWidth" prop="subscriptionDate">
							<el-input v-model="editform.subscriptionDate" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="基金管理费率" :label-width="formLabelWidth" prop="relativeManageCost">
							<el-input v-model="editform.relativeManageCost" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费率" :label-width="formLabelWidth" prop="subscriptionRate">
							<el-input v-model="editform.subscriptionRate" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="起投金额" :label-width="formLabelWidth" prop="startAmount">
							<el-input v-model="editform.startAmount" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="认购费收取方式" :label-width="formLabelWidth" prop="chargeMode">
							<el-input v-model="editform.chargeMode" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<span>赎回属性</span>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回周期" :label-width="formLabelWidth" prop="redemingCycle">
							<el-input v-model="editform.redemingCycle" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="赎回起始金额" :label-width="formLabelWidth" prop="redemingMoney">
							<el-input v-model="editform.redemingMoney" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="10">
						<el-form-item label="赎回费" :label-width="formLabelWidth" prop="redemingRate">
							<el-input v-model="editform.redemingRate" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="锁定期" :label-width="formLabelWidth" prop="redemingLockUp">
							<el-input v-model="editform.redemingLockUp" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<hr />
				<el-row>
					<el-col :span="10">
						<el-form-item label="审核人" :label-width="formLabelWidth" prop="reviewer">
							<el-input v-model="editform.reviewer" :disabled="true" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>


			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="warning" @click="refuseSumit">驳回</el-button>
				<el-button type="primary" @click="agreeSumit">审核通过</el-button>

			</div>
		</el-dialog>

	</div>
</template>

<script>
	export default {
		data() {
			return {
				buttonstate: true,
				currentRow: null,
				editFormVisible: false,
				reviewer: { //审核人
					name: '测试1'
				},
				tableData: [],
				formLabelWidth: '150px',
				editform: {
					/* productCategoryName: '',
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
					productId: '',
					createTime: '',
					updateTime: '',
					reviewState: '',
					createPeople: '', */
				},
				queryfrom: {
					productName: '',
					reviewState: ''
				},
				pageInfo: {
					page: 0,
					pageSize: 0,
					total: 0
				},
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

			}
		},
		methods: {
			
			dateFormat(row, column) {
							var date = row[column.property];
							if (date === undefined) {
								return ''
							};
							return this.$moment(date).format("YYYY-MM-DD HH:mm:ss")
			},
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			handleRowChange(val) { //点击行得出次行数据
				this.currentRow = val;
				// console.log(val)
				this.buttonstate = false;
					if (this.currentRow != null) {
				this.editform = this.currentRow
                 }

			},

			queryData() { //条件查询
				this.pageInfo.page = 1;
				let myprarm = this.$qs.stringify(this.pageInfo) + "&" + this.$qs.stringify(this.queryfrom);
				console.log("saaaa")
				console.log(this.editform)
				this.query(myprarm);

			},
			myReset() { //重置按钮
				this.$refs['queryfrom'].resetFields();
			},

			myEdit() { //操作按钮
				this.editFormVisible = true;

			},
			agreeSumit() {
				this.editFormVisible = false
				this.$axios.get("review/updateState?reviewState=已通过&productId=" + this.editform.productId)
					.then(returnVal => {
						// console.log(returnVal)
						if (returnVal.data.returnCode == 3000) {
							this.$message({
								message: returnVal.data.returnMsg,
								type: 'success'
							});
							this.query("");
						} else if (returnVal.data.returnCode == 4000) {
							this.$message.error(returnVal.data.returnMsg);
						}
					}).catch(err => {
						console.log(err);
					})
			},
			refuseSumit() {
				this.editFormVisible = false
				this.$axios.get("review/updateState?reviewState=驳回&productId=" + this.editform.productId)
					.then(returnVal => {
						if (returnVal.data.returnCode == 3000) {
							this.$message({
								message: returnVal.data.returnMsg,
								type: 'success'
							});
							this.query("");
						} else if (returnVal.data.returnCode == 4000) {
							this.$message.error(returnVal.data.returnMsg);
						}
					}).catch(err => {
						console.log(err);
					})
			},



			handleSizeChange(val) { //改变每页展示的数据
				this.buttonstate = true;
				console.log(`每页 ${val} 条`);
				this.pageInfo.pageSize = val;
				this.pageInfo.page = 1;
				/* console.log(this.$qs.stringify(this.pageInfo)); */
			    let param =	this.$qs.stringify(this.queryfrom)+"&"+this.$qs.stringify(this.pageInfo)

				this.query(param)
			},
			handleCurrentChange(val) { //改变页数
				this.buttonstate = true;
				console.log(`当前页: ${val}`);
				// console.log(this.editform)
				this.pageInfo.page = val;
				
				
				 let param1 =	this.$qs.stringify(this.queryfrom)+"&"+this.$qs.stringify(this.pageInfo)
				this.query(param1);
			},

			query(param) { /* 分页*/
				this.$axios.get("review/queryNeedReview?" + param)
					.then(returnVal => {
						// console.log(returnVal)
						this.tableData = returnVal.data.returnData
						this.pageInfo = returnVal.data.pageInfo;
						
					}).catch(err => {
						console.log(err);
					})
			}

		},
		mounted() {
			this.query("")
		},
		watch: {
			/* 监控tableData的数据的改变 ，改变后执行自己需要的代码 */
			tableData: function() {
				this.$nextTick(function() { /* 可能出现渲染不及时，所有用nextTick方法来推迟运行。  也可以用watch监控数据更新，然后进行自己的操作（watch 与method，data同级）*/
					this.buttonstate = true;
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
