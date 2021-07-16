<template>
	<div>
		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/MyPage' }">系统管理</el-breadcrumb-item>
				<el-breadcrumb-item>日志管理</el-breadcrumb-item>
			</el-breadcrumb><br>

			<el-form-item label="部门的名称" prop="dname">
				<el-select v-model="selectform.dname" clearable placeholder="请选择">
					<el-option v-for="item in depts" :key="item.deptName" :label="item.label" :value="item.deptName">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="访问模块" prop="accessmodule">
				<el-select v-model="selectform.accessmodule" clearable placeholder="请选择">
					<el-option v-for="item in options" :key="item.accessmodule" :label="item.label" :value="item.accessmodule">
					</el-option>
				</el-select>
			</el-form-item>

			<el-form-item label="操作内容" prop="operatingcontents">
				<el-select v-model="selectform.operatingcontents" clearable placeholder="请选择">
					<el-option v-for="item in operator" :key="item.operatingcontents" :label="item.label" :value="item.operatingcontents">
					</el-option>
				</el-select>
			</el-form-item>

			<el-form-item label="登录用户名" prop="accessuser">
				<el-input placeholder="请输入内容" v-model="selectform.accessuser" clearable>
				</el-input>
			</el-form-item>
			<el-form-item label="真实用户名" prop="realUserName">
				<el-input placeholder="请输入内容" v-model="selectform.realUserName" clearable>
				</el-input>
			</el-form-item>
			<el-form-item>
				<el-date-picker v-model="selectform.operatingTime" type="datetime" placeholder="起始时间" value-format="yyyy-MM-dd HH:mm:ss"
				 format="yyyy-MM-dd HH:mm:ss">
				</el-date-picker>
			</el-form-item>

			<el-form-item>
				<el-date-picker v-model="selectform.operatingEndTime" type="datetime" placeholder="结束时间" value-format="yyyy-MM-dd HH:mm:ss"
				 format="yyyy-MM-dd HH:mm:ss">
				</el-date-picker>
			</el-form-item>

			<el-form-item>
				<el-button type="primary" @click="queryData">查询</el-button>
			</el-form-item>

			<!-- <el-form-item label="操作关键字" prop="keyWord">
				<el-input placeholder="请输入内容" v-model="selectform.keyWord" clearable>
				</el-input>
			</el-form-item>

			<el-form-item>
				<el-button type="primary" @click="">搜索</el-button>
			</el-form-item> -->

		</el-form>
		<el-form :inline="true" :model="selectKeyform" class="demo-form-inline" ref="selectKeyform">
			<el-form-item label="操作关键字" prop="keyWord">
				<el-input placeholder="请输入内容" v-model="selectKeyform.keyWord" clearable>
				</el-input>
			</el-form-item>
			
			<el-form-item>
				<el-button type="primary" @click="keyWordSerach">搜索</el-button>
			</el-form-item>
		</el-form>	

		<!-- <el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowChange" style="width: 100%"> -->
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">

			<el-table-column property="id" label="序号">
			</el-table-column>

			<el-table-column property="accessuser" label="访问用户名">
			</el-table-column>

			<el-table-column property="accessmodule" label="访问模块">
			</el-table-column>

			<el-table-column property="accesstype" label="访问类型">
			</el-table-column>

			<el-table-column property="operatingTime" label="操作时间">
			</el-table-column>

			<el-table-column property="operatingcontents" label="操作内容">
			</el-table-column>

			<el-table-column property="operatingresult" label="操作结果">
			</el-table-column>
		</el-table>

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.pageNum"
		 :page-sizes="[3, 6, 9]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>
		
		



	</div>
</template>

<script>
	export default {
		data() {
			return {
				totalDepts: [],
				tableData: [],
				currentRow: null,
				value: '',
				pageInfo: {
					pageNum: 1,
					pageSize: 6,
					total: 10
				},
				
				pageInfo2: {
					pageNum: 1,
					pageSize: 6,
					total: 10
				},
				priceAdjustData: {
					operatingTime: ''
				},
				priceAdjustData2: {
					operatingEndTime: ''
				},
				options: [],
				operator: [],
				depts: [],

				selectform: {
					productName: '',
					accessmodule: '',
					operatingcontents: '',
					dname: '',
					accessuser: '',
					realUserName: '',
					operatingTime: '',
					operatingEndTime: '',


				},
				selectKeyform:{
					keyWord:'',
				},


				formLabelWidth: "100",
				input: '',
				pickerOptions: {
					shortcuts: [{
						text: '最近一周',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
							picker.$emit('pick', [start, end]);
						}
					}, {
						text: '最近一个月',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
							picker.$emit('pick', [start, end]);
						}
					}, {
						text: '最近三个月',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
							picker.$emit('pick', [start, end]);
						}
					}]
				},
				value1: '',
				value2: ''

			};




		},


		methods: {
			setCurrent(row) {
				this.$refs.singleTable.setCurrentRow(row);
			},
			
			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				if (this.currentRow != null) {
					console.log("当前对象==" + this.currentRow.accessuser);
				}
			},



			// page相关函数，size改变，查询按钮、重置按钮
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				this.pageInfo.pageNum = 1;
				this.pageInfo.pageSize = val;
			let myparam = {...this.pageInfo ,...this.selectform};
			this.myquery(this.$qs.stringify(myparam));
			
			//关键字
			let myparams = {...this.pageInfo2 ,...this.selectKeyform};
			this.keyWordSearchData(this.$qs.stringify(myparams));
			
			},
			
			

		
			//page改变
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageInfo.pageNum = val;
				//console.log(this.pageInfo);
				//this.getAllLogInfo(this.$qs.stringify(this.pageInfo));
				
				//多参数查询
				let myparam = {...this.pageInfo ,...this.selectform};
				this.myquery(this.$qs.stringify(myparam));
				
				// //关键字
				let myparams = {...this.pageInfo2 ,...this.selectKeyform};
				this.keyWordSearchData(this.$qs.stringify(myparams));
			},
			
			// //模糊查询分页
			// handleCurrentChange2(val) {
			// 	console.log(`当前页: ${val}`);
			// 	this.pageInfo2.pageNum = val;
			// 	//console.log(this.pageInfo);
			// 	//this.getAllLogInfo(this.$qs.stringify(this.pageInfo));
			// 	//关键字
			// 	let myparams = {...this.pageInfo2 ,...this.selectKeyform};
			// 	this.keyWordSearchData(this.$qs.stringify(myparams));
			// },

		
			getModule() {
				this.$axios.post("log/modules")
					.then(resp => {
						this.options = resp.data.list;
						// this.operator = resp.data.list;
					})

			},

			getOperatorContents() {
				this.$axios.post("log/OperatorContent")
					.then(resp => {
						// this.options = resp.data.list;
						this.operator = resp.data.list;
					})

			},

			getDeptName() {
				this.$axios.post("log/deptNames")
					.then(resp => {
						// this.options = resp.data.list;
						//this.depts = resp.data.list;
					})

			},

			//查询功能
			queryData() {
				//条件查询
				this.pageInfo.pageNum = 1;
				let myparams = {...this.pageInfo ,...this.selectform};
				this.myquery(this.$qs.stringify(myparams));
			
			},

			myquery(param) {
				this.$axios.get("log/ManyParam?" + param)
					.then(resp => {
						// this.options = resp.data.list;
						this.tableData = resp.data.list;
						this.pageInfo.pageNum = resp.data.pageNum;
						this.pageInfo.pageSize = resp.data.pageSize;
						this.pageInfo.total = resp.data.total;

					})
			},
			
			//关键字搜索
			keyWordSerach(){
				let myparam = {...this.pageInfo ,...this.selectKeyform};
				this.keyWordSearchData(this.$qs.stringify(myparam))
			},
			
			keyWordSearchData(params){
				
				this.$axios.get("log/keyWords?" + params)
					.then(resp => {
						// this.options = resp.data.list;
						this.tableData = resp.data.list;
						this.pageInfo.pageNum = resp.data.pageNum;
						this.pageInfo.pageSize = resp.data.pageSize;
						this.pageInfo.total = resp.data.total;
				
					})
			},
			
			
		

		},



		mounted() {
			//this.getAllLogInfo();
			this.queryData();
			this.getModule();
			this.getOperatorContents();
			this.getDeptName();
		},

	}
</script>

<style>
</style>
