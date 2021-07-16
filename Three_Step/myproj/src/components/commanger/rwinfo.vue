<template>
	<div>
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>独角兽管理</el-breadcrumb-item>
				<el-breadcrumb-item>充值提现信息</el-breadcrumb-item>

			</el-breadcrumb>

			<!-- 查询条件框 -->

			<el-form :inline="true" ref="queryFrom" :model="queryFrom" class="demo-form-inline">
				<el-form-item label="姓名" prop="uname">
					<el-input v-model="queryFrom.uname" placeholder="姓名"></el-input>
				</el-form-item>
				<el-form-item label="电话 " prop="uphone">
					<el-input v-model="queryFrom.uphone" placeholder="电话"></el-input>
				</el-form-item>
				<el-form-item label="交易类型 " prop="transactiontype">
					<el-select v-model="queryFrom.transactiontype" placeholder="交易类型" style="width: 150px;">
						<el-option label="提现" value="提现"></el-option>
						<el-option label="充值" value="充值"></el-option>

					</el-select>
				</el-form-item>
				<el-form-item label="交易状态 " prop="status">
					<el-select v-model="queryFrom.status" placeholder="交易状态">
						<el-option label="已汇款给用户" value="已汇款给用户"></el-option>
						<el-option label="已到PTN账户" value="已到PTN账户"></el-option>

					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="queryData()">查询</el-button>
					<el-button @click="myreset">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div>
			<!--表头 -->
			<el-table ref="singleTable" align="center" :data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%; ">

				　　
				<el-table-column property="uid" align="center" label="客户编号" width="150">
				</el-table-column>
				<el-table-column property="uname" align="center" label="客户名称" width="150">
				</el-table-column>
				<el-table-column property="uphone" align="center" label="客户手机号" width="150">
				</el-table-column>
				<el-table-column property="transactiontype" align="center" label="交易类型" width="150">
				</el-table-column>
				<el-table-column property="amount" align="center" label="金额(千)" width="150">
				</el-table-column>
				<el-table-column property="requesttime" align="center" label="请求时间" width="170">
				</el-table-column>
				<el-table-column property="completetime" align="center" label="处理完成时间" width="170">
				</el-table-column>
				<el-table-column property="bankid" align="center" label="银行交易编号" width="150">
				</el-table-column>
				<el-table-column property="status" align="center" label="状态" width="150">
					<template slot-scope="scope">
					      <el-tag :type="scope.row.status=='已汇款给用户'?'success':(scope.row.status=='已到PTN账户'?'warning':'info')">{{scope.row.status}}</el-tag>
					    </template>
				</el-table-column>

			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[5,10,15]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				queryFrom: { /* 查询的名称和id*/
					uname: '',
					uphone: '',
					transactiontype: '',
					status: '',

				},
				tableData: [],
				pageinfo: {
					page: 1,
					pageSize: 3,
					total: 5,
				},
			}
		},
		methods: {
			/* 点击查询 按钮 */
			queryData() {
				this.pageinfo.page = 1;
				let param = this.$qs.stringify(this.pageinfo) + "&" + this.$qs.stringify(this.queryFrom)
				this.myquery(param)
			},
			myquery(param) {
			
				this.$axios.get("rwinfo/query?" + param)
					.then(returnVal => {
						console.log(returnVal)
						this.tableData = returnVal.data.returnData;
						console.log(returnVal.data.pageInfo)
						this.pageinfo = returnVal.data.pageInfo;
			
					})
					.catch(err => {
						console.log(err)
					})
			
			},
			myreset() {
				this.$refs['queryFrom'].resetFields(); //重置
			},
			handleRowChange(val) {
				this.currentRow = val;
				this.btnstatus = false;
				if (this.currentRow != null) {
					this.editForm = JSON.parse(JSON.stringify(this.currentRow)); /* 将此行数据 传入修改框*/
					console.log(this.currentRow)

				}

			},
			/*pagesize发生改变 */
			handleSizeChange(val) {
				this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				var param = this.$qs.stringify(this.pageinfo)
				this.myquery(param)
			},
			/*当前页码发生改变  */
			handleCurrentChange(val) {
				this.$axios.get("rwinfo/query?page=" + val + "&pageSize=" + this.pageinfo.pageSize)
					.then(returnVal => {
						console.log(returnVal)
						this.tableData = returnVal.data.returnData;
						this.pageinfo = returnVal.data.pageInfo;


					})
					.catch(err => {
						console.log(err)
					})
			},
		},
		mounted() {
			this.myquery("");

		},
	}
</script>

<style>
	.el-main {
	
		line-height: 40px;
	}
</style>
