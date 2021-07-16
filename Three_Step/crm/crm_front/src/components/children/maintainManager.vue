<template>

	<el-container>

		<el-dialog :title="digName" width="50%" :visible.sync="openAdd" center>

			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">公司名称</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="公司名称" v-model="addParams.maintainName" :readonly="addDig"></el-input>
					</div>
				</el-col>
			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">详细地址</div>
				</el-col>
				<el-col :span="12">
					<div class="grid-content bg-purple">
						<el-input placeholder="详细地址" :readonly="addDig" v-model="addParams.maintainAddress"></el-input>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">省市县</div>
				</el-col>
				<el-col :span="12">
					<div class="grid-content bg-purple">
						<el-cascader :change-on-select="true" :props="defaultParams" @change="selectChange"
							:options="allAreaDatas" v-model="selectedOptions" :clearable="true"></el-cascader>
					</div>
				</el-col>

			</el-row>
			<br />



			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">热线电话</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="热线电话" :readonly="addDig" v-model="addParams.maintainPhone">
						</el-input>
					</div>
				</el-col>

			</el-row>



			<span slot="footer" class="dialog-footer">

				<el-button type="primary" @click="openAdd = false,save()">保 存
				</el-button>
				<el-button type="primary" @click="openAdd = false">返 回
				</el-button>

			</span>
		</el-dialog>




		<el-header height="150px">

			<!-- 搜索块 -->
			<el-form :inline="true" :model="queryParams" class="demo-form-inline">

				<el-form-item label="公司名称">
					<el-input v-model="queryParams.maintainName" placeholder="公司名称"></el-input>
				</el-form-item>
				<el-form-item label="详细地址">
					<el-input v-model="queryParams.maintainAddress" placeholder="详细地址"></el-input>
				</el-form-item>
				<el-form-item label="热线电话">
					<el-input v-model="queryParams.maintainPhone" placeholder="热线电话"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="flushPage">查询</el-button>
					<el-button @click="resetQuery">重置</el-button>
					<el-button type="button" @click="openAdd = true,addMainTain()">新增维修点</el-button>
				</el-form-item>
				<el-form-item>
					<el-upload class="upload-demo" action="" :http-request="myupload" multiple name="myfile">
						<el-button size="big" type="success">导入</el-button>
					</el-upload>
				</el-form-item>
				<el-form-item>
					<el-button @click="educe">导出</el-button>
				</el-form-item>
			</el-form>
		</el-header>
		<el-container>
			<el-aside width="250px">
				<el-tree :data="haveCity" :props="defaultProps" accordion @node-click="handleNodeClick">
				</el-tree>
			</el-aside>

			<el-main>

				<el-table :data="maintainDatas"  border style="width: 100%" @current-change="choiseGood"
					@selection-change="handleSelectionChange">
					<el-table-column label="序号" type="index" align="center" show-overflow-tooltip width="50px">
					</el-table-column>
					<el-table-column type="selection" width="55">
					</el-table-column>
					<el-table-column prop="maintainName" width="150px" label="名称">
					</el-table-column>
					<el-table-column prop="maintainAddress" label="地址">
					</el-table-column>
					<el-table-column prop="maintainPhone" label="电话">
					</el-table-column>
					</el-table-column>
					<el-table-column label="操作">
						<template slot-scope="scope">
							<el-button size="mini" @click="openAdd = true,handleEdit(scope.$index, scope.row)">编辑
							</el-button>
							<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除
							</el-button>
						</template>
					</el-table-column>


				</el-table>
				<!-- 页码块 -->
				<el-pagination @size-change="SizeChange" @current-change="PageChange" :current-page="DefaultPage"
					:page-sizes="[5, 10, 20]" :page-size="5" layout="total, sizes, prev, pager, next, jumper"
					:total="params.total">
				</el-pagination>

			</el-main>

		</el-container>
	</el-container>
</template>

<script>
	var token = localStorage.getItem('token')
	export default {
		data() {
			return {

				addDig: false,
				headers: {
					Authorization: token
				},
				haveCity: [],
				openAdd: false,
				digName: "",
				allAreaDatas: [],
				defaultProps: {
					children: 'list',
					label: 'name'
				},
				maintainDatas: [],
				DefaultPage: 1,
				params: {
					total: 0,
					pageSize: 5,
				},
				choiseData: {},
				queryParams: {
					pageSize: 5,
					pageNum: 1,
					maintainName: undefined,
					maintainAddress: undefined,
					maintainPhone: undefined,
				},
				multipleSelection: [],


				options: [],
				selectedOptions: [],
				defaultParams: {
					label: 'name',
					value: 'id',
					children: 'list'
				},
				addParams: {},
				status: 1,
			}
		},
		methods: {

			fileChange(e) {
				try {
					const fu = document.getElementById('file')
					if (fu == null) return
					this.form.imgSavePath = fu.files[0].path
					console.log(fu.files[0].path)
				} catch (error) {
					console.debug('choice file err:', error)
				}
			},
			btnChange() {
				var file = document.getElementById('file')
				file.click()
			},
			//  选中省市县地点
			handleNodeClick(data) {
				console.log(data);
				this.$axios.get("maintainManager/list/city/"+data.id)
				.then(resp=>{
					this.maintainDatas = resp.data.list;
					this.params.total = resp.data.total;
					this.params.pageSize = resp.data.pageSize;
				}).catch(err=>{
					console.log(err);
				})
			},
			selectChange() {
				this.addParams.maintainCity = this.selectedOptions[this.selectedOptions.length - 1];
				console.log(this.selectedOptions);
			},
			queryAllArea() {
				this.$axios.get("crmArea/all")
					.then(resp => {
						console.log(resp);
						this.allAreaDatas = resp.data;
					}).catch(err => {
						console.log(err);
					})
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
				console.log("多选值");
				console.log(val);
			},
			// 选中商品table行
			choiseGood(val) {
				if (val != null) {
					console.log(val);
					this.choiseData = val;
				}
			},
			SizeChange(val) {
				this.params.pagesize = val;
				this.queryParams.pageSize = val;
				this.queryParams.pageNum = 1;
				this.flushPage();
				this.defaultPage = 1;
			},
			PageChange(val) {
				console.log(val);
				this.DefaultPage = val;
				this.queryParams.pageNum = val;
				this.flushPage();
			},
			// 查询
			getMaintainList(query) {
				this.$axios.get("maintainManager/list?" + query)
					.then(resp => {
						console.log("这是获取的list数据：")
						console.log(resp)
						this.maintainDatas = resp.data.list;
						this.params.total = resp.data.total;
						this.params.pageSize = resp.data.pageSize;

					}).catch(err => {
						console.log(err);
					})
			},
			// 当前条件刷新页面
			flushPage() {
				console.log(this.queryParams);
				this.getMaintainList(this.$qs.stringify(this.queryParams));
			},
			handleDelete(index, row) {
				console.log(row.maintainId);
				this.$axios.delete("maintainManager/" + row.maintainId)
					.then(resp => {
						if (resp.code == 20000) {
							this.$message.success("删除成功")
							this.flushPage();
						} else {
							this.$message.error("删除失败")
						}

					}).catch(err => {
						console.log(err);
					})
			},
			handleEdit(index, row) {
				this.addParams = {};
				this.addParams = row;
				this.status = 2;
				console.log(row);
			},
			resetQuery() {
				this.queryParams = {};
				this.flushPage();
			},
			addMainTain() {
				this.status = 1;
				this.selectedOptions = [];
				this.addParams = {};
				this.digName = "新增维修点";
			},
			upDatas() {

			},
			loadDatas() {

			},
			save() {
				console.log(this.addParams);
				if (this.status == 1) {
					this.$axios.post("maintainManager", this.addParams)
						.then(resp => {
							if (resp.code == 20000) {
								this.$message.success("新增维修点成功！")
								this.this.addParams = {};
								this.flushPage();
								this.this.addParams = {};
							} else {
								this.$message.error("新增维修点失败！")
							}

						}).catch(err => {
							console.log(err);
						})
				} else {
					this.$axios.put("maintainManager", this.addParams)
						.then(resp => {
							if (resp.code == 20000) {
								this.$message.success("修改维修点成功！")
								this.this.addParams = {};
								this.flushPage();
								this.this.addParams = {};
							} else {
								this.$message.error("修改维修点失败！")
							}

						}).catch(err => {
							console.log(err);
						})
				}

			},
			/* 导入 */
			myupload(param) {
				let formData = new FormData();
				formData.append("myfile", param.file);
				this.$axios.post("maintainManager/uploadDatas", formData, {
						headers: {
							"Content-Type": "multipart/form-data"
						}
					})
					.then(resp => {
						if (resp.code == 20000) {
							this.$message({
								showClose: true,
								message: '上传成功',
								type: 'success'
							});
						} else {
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
				this.$axios.post("maintainManager/load", this.queryParams)
					.then(returnval => {
						if (returnval.code == 20000) {
							this.$message.success("下载路径：" + returnval.data);
						} else {
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
			queryHaveCity() {
				this.$axios.get("maintainManager/city")
				.then(resp=>{
					this.haveCity=resp.data;
				}).catch(err=>{
					console.log(err);
				})
			}


		},
		mounted() {
			this.queryAllArea();
			this.flushPage();
			this.queryHaveCity();
		}
	};
</script>

<style scoped="scoped">
	
	element.style {
		height: 50px;}
	/* 	.el-cascader-menu {
	  height: 1000px;
	}
	.el-cascader-panel{
		 height: 1000px;
	}
	.el-cascader-menu__wrap {
		height: 1000px;
	} */
</style>
