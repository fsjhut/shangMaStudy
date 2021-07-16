<template>
	<div>
		<template>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{}">商品与赠品管理管理</el-breadcrumb-item>
				<el-breadcrumb-item>商品管理</el-breadcrumb-item>
				<el-breadcrumb-item>产品查询列表</el-breadcrumb-item>
			</el-breadcrumb>
			<br />
			<el-form ref="queryForm" :inline="true" :model="queryForm" class="demo-form-inline">
				<el-form-item label="存货档案编码：" prop="goodsCode">
					<el-input v-model="queryForm.goodsCode" placeholder="存货档案编码"></el-input>
				</el-form-item>
				<el-form-item label="产品型号：" prop="goodsType">
					<el-input v-model="queryForm.goodsType" placeholder="产品型号"></el-input>
				</el-form-item>

				<el-form-item label="基础库-颜色" prop="goodsColor">
					<el-select v-model="queryForm.goodsColor" placeholder="全部">
						<el-option label="全部" :value="0"></el-option>
						<el-option v-for="item in colors" :value="item.goodsColor" :label="item.goodsColor">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="商品品牌" prop="goodsBrand">

					<el-select v-model="queryForm.goodsBrand" placeholder="商品品牌">
						<el-option label="全部" :value="0"></el-option>
						<el-option v-for="item in brands" :value="item.goodsBrand" :label="item.goodsBrand">
						</el-option>
					</el-select>
				</el-form-item>
				</el-select>
				</el-form-item>
				<el-form-item label="产品分类" prop="goodsType">
					<el-select v-model="queryForm.goodsType" placeholder="产品分类">
						<el-option label="全部" :value="0"></el-option>
						<el-option v-for="item in goodsTypes" :value="item.goodsType" :label="item.goodsType">
						</el-option>
					</el-select>
				</el-form-item>

				<br />
				<el-form-item>
					<el-button type="primary" @click="myquery">查询</el-button>
					<el-button type="danger" @click="myreset">重置</el-button>
				</el-form-item>
				<br />
				<el-upload class="upload-demo" action="" :http-request="myupload" :on-preview="handlePreview" :on-remove="handleRemove"
				 :before-remove="beforeRemove" multiple :limit="3" :on-exceed="handleExceed" :file-list="fileList" name="myfile">
					<el-button size="big" type="success">导入</el-button>

					<div slot="tip" class="el-upload__tip">上传xlsx文件</div>

				</el-upload>
					<el-button type="danger"><a href="http://localhost:8080/goodsManager/down?path=/upload/模板.xlsx">模板下载</a></el-button>
					<el-button type="primary" @click="educe">导出</el-button>


			</el-form>


			<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
				<el-table-column property="" label="序号" width="60px " type="index">
				</el-table-column>
				<el-table-column type="selection" width="55"> </el-table-column>
				<el-table-column property="goodsCode" label="存货档案编码" width="200">
				</el-table-column>
				<el-table-column property="goodsType" label="基础库分类" width="250">
				</el-table-column>
				<el-table-column property="goodsBrand" label="基础库品牌" width="200">
				</el-table-column>
				<el-table-column property="goodsModel" label="基础库型号" width="200">
				</el-table-column>
				<el-table-column property="goodsColor" label="基础库颜色" width="280">
				</el-table-column>


			</el-table>
			<!--  要接受从后台返回的数据 页数 current-page="currentPage4" -->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[3, 6, 10]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>

		</template>
	</div>


</template>

<script>
	// import moment from 'moment'
	export default {
		data() {
			return {
				tableData: [],
				currentRow: null,
				pageinfo: {
					pageNum: 1,
					pageSize: 3,
					total: 10
				},
				// disBtn:true,
				queryForm: {
					goodsCode: '',
					goodsType: '',
					goodsColor: '',
					goodsBrand: '',
					goodsType: ''
				},
				fileList: [{
					name: '',
					url: ''
				}],
				brands: [],
				colors: [],
				goodsTypes: []
			}
		},
		methods: {
			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				// this.disBtn = false;
				console.log("当前对象" + this.currentRow.goodsName);
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

			myreset() {
				this.$refs['queryForm'].resetFields();
			},

			handleRemove(file, fileList) {
				console.log(file, fileList);
			},
			beforeRemove(file, fileList) {
				return this.$confirm(`确定移除 ${ file.name }？`);
			},
			handleExceed(files, fileList) {
				this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
			},
			handlePreview(file) {
				console.log(file);
			},
			/* 导入 */
			myupload(param) {
				let formData = new FormData();
				formData.append("myfile", param.file);
				this.$axios.post("goodsManager/upload", formData, {
						headers: {
							"Content-Type": "multipart/form-data"
						}
					})
					.then(resp => {
						if (resp.code == 50000) {
							this.$message({
								showClose: true,
								message: '上传成功',
								type: 'success'
							});
						} else if (resp.code == 201) {
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'error'
							});
						};
					}).catch(err => {
						console.log(err)
					})
			},
			/* 导出 */
			educe() {
				this.$axios.post("goodsManager/educe", {
					params: this.queryFrom
				}).then(returnval => {
					if (returnval.code == 20000) {
						this.$message({
							showClose: true,
							message: returnval.msg,
							type: 'success'
						});
					} else if (returnval.code == 201) {
						this.$message({
							showClose: true,
							message: returnval.msg,
							type: 'error'
						});
					}
					console.log(returnval)
				}).catch(err => {
					console.log(err)
				})
			},















			myquery() {
				this.$axios.get("goodsManager/list?" + this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo))
					.then(resp => {

						console.log("2222" + this.pageinfo)
						console.log(resp.data.list);
						this.tableData = resp.data.list;
						console.log("当前" + resp.data.pageNum)
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			},
			getbrand() { //刷新商品品牌的下拉框
				this.$axios.get("goodsManager/getType/goods_brand")
					.then(resp => {

						console.log(resp);
						this.brands = resp;
						console.log("数据：")
						console.log(this.brands);
					})
					.catch(err => {
						console.log(err);
					})
			},
			getcolor() { //刷新商品颜色的下拉框
				this.$axios.get("goodsManager/getType/goods_color")
					.then(resp => {

						console.log(resp);
						this.colors = resp;
						console.log("数据：")
						console.log(this.colors);
					})
					.catch(err => {
						console.log(err);
					})
			},
			getGoodsType() { ////刷新商品分类的下拉框
				this.$axios.get("goodsManager/getType/goods_type")
					.then(resp => {

						console.log(resp);
						this.goodsTypes = resp;
						console.log("数据：")
						console.log(this.goodsTypes);
					})
					.catch(err => {
						console.log(err);
					})
			}

		},

		//监听  操作完成  进行页面渲染
		mounted() {
			this.myquery();
			this.getbrand();
			this.getcolor();
			this.getGoodsType();
		},
		// watch: {
		// 	tableData: function() {
		// 		console.log("数据刷新了");
		// 		this.$nextTick(function() {
		// 			this.disBtn = true;
		// 		})

		// 	},

	}
</script>

<style>
</style>
