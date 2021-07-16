<template>
	<div>
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>产品管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品系列管理</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		
		<el-form ref="queryform" :inline="true" :model="queryform" class="demo-form-inline " >
			<el-form-item label="系列名称" prop="sname">
				<el-input v-model="queryform.sname" placeholder="系列名称"></el-input>
			</el-form-item>

			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
				
				<el-button @click="myreset">重置</el-button>
				<!-- form -->
		
			</el-form-item>
			<div style="margin-left:-38%;">
			<el-button type="success" @click="addFormOpen">添加</el-button>
			<el-button type="success" :disabled="btnstatus" @click="moneyFormOpen">汇款信息</el-button>
			<el-button type="warning" :disabled="btnstatus" @click="editFormOpen">修改</el-button>
			
			</div>
		</el-form>


		<el-table ref="singleTable" align="center"  :data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%">
			<el-table-column property="sid" label="产品系列ID" align="center" width="100">
			</el-table-column>
			<el-table-column property="sname" label="产品系列中文名" align="center" width="250">
			</el-table-column>
			<el-table-column property="ename" label="产品系列英文名" align="center" width="300">
			</el-table-column>
			<el-table-column property="companyName" label="汇款信息概略" align="center" width="250">
			</el-table-column>
		</el-table>


		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.page" 
		 :page-sizes="[5, 10,15, 20]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>

		<!-- form -->
		<el-dialog title="添加" :visible.sync="addFormVisible" width="30%">
			<el-form ref="addform" :model="addform">
				<el-form-item label="产品渠道">
					<el-select v-model="addform.channel" clearable placeholder="请选择">
						<el-option v-for="item in channel" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="产品分类">
					<el-select v-model="addform.sort" clearable placeholder="请选择">
						<el-option v-for="item in sort" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="产品中文名" prop="sname">
					<el-input v-model="addform.sname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="产品英文名" prop="ename">
					<el-input v-model="addform.ename" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="汇款信息概略" prop="companyName">
					<el-input v-model="addform.companyName" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="addSubmit()">确 定</el-button>
			</div>
		</el-dialog>


		<el-dialog title="修改" :visible.sync="editFormVisible" width="30%">
			<el-form ref="editform" :model="editform">
				<el-form-item label="产品渠道">
					<el-select v-model="editform.channel" clearable placeholder="请选择">
						<el-option v-for="item in channel" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="产品分类">
					<el-select v-model="editform.sort" clearable placeholder="请选择">
						<el-option v-for="item in sort" :key="item.value" :label="item.label" :value="item.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="产品中文名" prop="sname" >
					<el-input v-model="editform.sname" autocomplete="off" :disabled="true"></el-input>
				</el-form-item>
				<el-form-item label="产品英文名" prop="ename" >
					<el-input v-model="editform.ename" autocomplete="off" :disabled="true"></el-input>
				</el-form-item>
				<el-form-item label="汇款信息概略" prop="companyName">
					<el-input v-model="editform.companyName" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSubmit()">确 定</el-button>
			</div>
		</el-dialog>


		<el-dialog title="汇款信息" :visible.sync="moneyFormVisible">
			<el-form ref="moneyform" :model="moneyform">
				<el-row :gutter="80">
					<el-col :span="10">
						<el-form-item label="收款银行名称" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyform.bname" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="银行SWIFT码" prop="ename" class="demo-form-inline">
							<el-input v-model="moneyform.bswift" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row :gutter="80">
					<el-col :span="10">
						<el-form-item label="收款银行地区" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyform.barea" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="收款银行城市" prop="ename" class="demo-form-inline">
							<el-input v-model="moneyform.bcity" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row :gutter="80">
					<el-col :span="10">
						<el-form-item label="收款人户名" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyreq.moneyName" autocomplete="off" :disabled="true"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="收款人账号" prop="ename" class="demo-form-inline">
							<el-input v-model="moneyform.account" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row :gutter="80">
					<el-col :span="20">
						<el-form-item label="收款人地址" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyform.baddress" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row :gutter="80">
					<el-col :span="10">
						<el-form-item label="汇款用户" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyform.uname" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="汇款附言" prop="ename" class="demo-form-inline">
							<el-input v-model="moneyform.umsg" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row :gutter="80">
					<el-col :span="10">
						<el-form-item label="BANK CODE" prop="sname" class="demo-form-inline">
							<el-input v-model="moneyform.bcode" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="10">
						<el-form-item label="CNAPS编号" prop="ename" class="demo-form-inline">
							<el-input v-model="moneyform.bcanps" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="moneyFormVisible = false">取 消</el-button>
				<el-button type="success" :disabled="moneyformAddbtn" @click="moneyAddSubmit()">确定添加</el-button>
				<el-button type="warning" :disabled="moneyformEditbtn" @click="moneyEditSubmit()">确定修改</el-button>
			</div>
		</el-dialog>


	</div>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				currentRow: null,

				pageInfo: {
					page: 3,
					pageSize: 30,
					total: 99
				},


				queryform: {
					sname: '',
				},

				addFormVisible: false,
				addform: {
					channel:'',
					sort:'',
					sname: '',
					ename: '',
					companyName: '',
				},

				channel: [{
					value: '香港资管',
					label: '香港资管'
				}, {
					value: '内地资管',
					label: '内地资管'
				}],
				

				sort: [{
					value: '基金',
					label: '基金'
				}, {
					value: '保险',
					label: '保险'
				}, {
					value: '证券',
					label: '证券'
				}],


				editFormVisible: false,
				editform: {
					sid: '',
					sname: '',
					ename: '',
					companyName: '',
					channel:'',
					sort:'',
				},


				moneyFormVisible: false,

				moneyreq: {
					moneyName: '',
					sid: '',
				},

				moneyform: {
					bid: '',
					bname: '',
					bswift: '',
					barea: '',
					bcity: '',
					account: '',
					baddress: '',
					uname: '',
					umsg: '',
					bcode: '',
					bcanps: '',
					sid: '',
				},



				// 按钮状态
				btnstatus: true,
				moneyformAddbtn:true,
				moneyformEditbtn:true,
				
			}
		},
		methods: {
			
			myreset() {
				this.$refs['queryform'].resetFields(); //重置
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
					// console.log(JSON.stringify(this.currentRow))标准json格式
					// {"channel":"内地资管","companyName":"尚马资管","ename":"China Gold portfolio","sid":2,"sname":"中金收益宝","sort":"证券"}
					this.editform = JSON.parse(JSON.stringify(this.currentRow));
					this.moneyreq.moneyName = this.currentRow.companyName;
					this.moneyreq.sid = this.currentRow.sid;
				}
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);

				this.pageInfo.page = 1;
				this.pageInfo.pageSize = val;
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
					"&sname=" + this.queryform.sname;
				this.myquery(param);
				
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageInfo.page = val;
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize +
					"&sname=" + this.queryform.sname;
				this.myquery(param);
				
			},

			// 查询
			myquery(param) {
				this.$axios.get("series/query?" + param)
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
					"&sname=" + this.queryform.sname;
				this.myquery(param);

			},

			// 添加前重置，清空内容
			addFormOpen() {
				this.addFormVisible = true;
				// this.$nextTick渲染后执行nextTick中的代码
				this.$nextTick(function() {
					this.$refs['addform'].resetFields();
				})

			},
			// 添加
			addSubmit() {
				this.addFormVisible = false;
				this.$axios.post("series/add", this.$qs.stringify(this.addform))
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
							"&sname=" + this.queryform.sname;
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
				console.log(this.$qs.stringify(this.editform));
				this.$axios.post("series/edit", this.$qs.stringify(this.editform))
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
							"&sname=" + this.queryform.sname;
						this.myquery(param);
					})
					.catch(err => {
						console.log(err)
					})
			},

			// 点击汇款信息前查询是否当前产品系列是否具有汇款信息，有修改，无增加
			moneyFormOpen() {
				this.moneyFormVisible = true;
				this.$axios.get("bankInfo/query?sid=" + this.moneyreq.sid)
					.then(returnval => {
						if (returnval.data.returnCode == 3000) {
							this.moneyformAddbtn=true;
							this.moneyformEditbtn=false;
							this.moneyform = returnval.data.returnData
							// console.log(returnval.data.returnData)
						} else if (returnval.data.returnCode == 4000) {
							this.moneyformAddbtn=false;
							this.moneyformEditbtn=true;
							this.moneyform = {
								bid: '',
								bname: '',
								bswift: '',
								barea: '',
								bcity: '',
								account: '',
								baddress: '',
								uname: '',
								umsg: '',
								bcode: '',
								bcanps: '',
								sid: ''
							};
						}
					})
					.catch(err => {
						console.log(err)
					})
			},
			// 增加汇款信息
			moneyAddSubmit() {
				this.moneyFormVisible = false;
				this.moneyform.sid=this.moneyreq.sid;
				this.$axios.post("bankInfo/add", this.$qs.stringify(this.moneyform))
					.then(returnval => {
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
							"&sname=" + this.queryform.sname;
						this.myquery(param);
					})
					.catch(err => {
						console.log(err)
					})
			},
			
			// 修改汇款信息
			moneyEditSubmit() {
				this.moneyFormVisible = false;
				this.$axios.post("bankInfo/edit", this.$qs.stringify(this.moneyform))
					.then(returnval => {
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
							"&sname=" + this.queryform.sname;
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
	.el-main {
		line-height: 40px;
	}

	.el-select {
		width: 100%;
	}

	.el-form--inline .el-form-item {
		display: inline-block;
		margin-right: 100px;
		vertical-align: top;
	}

	.el-pagination {
		white-space: nowrap;
		padding: 25px 5px;
		color: #303133;
		font-weight: 700;
	}
</style>
