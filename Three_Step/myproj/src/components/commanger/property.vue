<template>
	<div>
	
		<div>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>独角兽管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品系列管理</el-breadcrumb-item>
		
			</el-breadcrumb>
		</div>
		<div id="div1">
			<el-form ref="queryform"  :inline="true" :model="queryform" class="demo-form-inline " style="width: 100%">

				<el-form-item label="姓名" prop="uname">
					<el-input v-model="queryform.uname" placeholder="姓名"></el-input>
				</el-form-item>
				<el-form-item label="电话" prop="uphone">
					<el-input v-model="queryform.uphone" placeholder="电话"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="queryData">查询</el-button>
					<el-button @click="myReset">重置</el-button>
				</el-form-item>
			</el-form>
		</div>
        
		<el-table ref="singleTable" align="center" :data="tableData" highlight-current-row style="width: 100%">
			<el-table-column property="uid" align="center" label="客户编号" width="180">
			</el-table-column>
			<el-table-column property="uname" align="center" label="客户名称" width="180">
			</el-table-column>
			<el-table-column property="uphone" align="center" label="客户手机号" width="180">
			</el-table-column>
			<el-table-column property="companyName" align="center" label="企业名称" width="180">
			</el-table-column>
			<el-table-column property="number" align="center" label="数量" width="180">
			</el-table-column>
			<el-table-column property="price" align="center" label="成本价格" width="180">
			</el-table-column>
		</el-table>


		<el-pagination 
		@size-change="handleSizeChange" 
		@current-change="handleCurrentChange" 
		:current-page="pageInfo.page"
		 
		 :page-sizes="[5, 10,15, 20]" 
		 :page-size="pageInfo.pageSize" 
		 layout="total, sizes, prev, pager, next, jumper"
		 :total="pageInfo.total">
		</el-pagination>
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
					uname: '',
					uphone: '',
				},
			}
		},
		methods: {
	           myReset(){ //
				this.$refs['queryform'].resetFields();
			   },

			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);

				this.pageInfo.page = 1;
				this.pageInfo.pageSize = val;
			let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize + "&" +
				this.$qs.stringify(this.queryform);
			this.myquery(param);
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageInfo.page = val;
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize + "&" +
					this.$qs.stringify(this.queryform);
				this.myquery(param);
			},

			// 查询
			myquery(param) {
				this.$axios.get("property/query?" + param)
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
				let param = "page=" + this.pageInfo.page + "&pageSize=" + this.pageInfo.pageSize + "&" +
					this.$qs.stringify(this.queryform);
				this.myquery(param);
			},
		},
		mounted() {
			this.myquery("");
		}



	}
</script>

<style>
	#div1 .el-form--inline .el-form-item__label {
		float: left;
	}
	.el-main {
	
		line-height: 40px;
	}
</style>
