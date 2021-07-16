<template>
	<div>
		<template>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{}">商品与赠品管理管理</el-breadcrumb-item>
				<el-breadcrumb-item>商品管理</el-breadcrumb-item>
				<el-breadcrumb-item>商品品牌管理</el-breadcrumb-item>
			</el-breadcrumb>
		</template>
		<br />
		<el-form ref="queryForm" :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="品牌名称：" prop="brandName">
				<el-input v-model="queryForm.brandName" placeholder="品牌名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="myquery()">查询</el-button>
				<el-button type="danger" @click="myreset()">重置</el-button>
				<el-button type="sucess" @click="myadd()">添加</el-button>
			</el-form-item>
			<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
				<el-table-column property="" label="序号" width="60px " type="index">
				</el-table-column>
				<el-table-column type="selection" width="55"> </el-table-column>
				<el-table-column property="brandName" label="品牌名称" width="260">
				</el-table-column>
				<el-table-column property="brandUrl" label="品牌网址" width="260">
				</el-table-column>
				<el-table-column property="brandDesc" label="品牌描述" width="260">
				</el-table-column>
				<el-table-column label="操作" width="300">
					<template slot-scope="scope">
						<!-- <el-button @click="openQueryForm" type="warning">查看</el-button> -->
						<!-- <el-button type="primary" :disabled="disBtn" @click="openEditForm">编辑</el-button> -->
						<el-button type="warning" :disabled="disBtn" @click="myedit()">修改</el-button>
						<el-button type="danger" :disabled="disBtn" @click="mydelete()">删除</el-button>
					</template>
				</el-table-column>
			</el-table>

			<!--  要接受从后台返回的数据 页数 current-page="currentPage4" -->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[5, 10, 15]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>
			<el-dialog title="新增品牌" :visible.sync="addFormVisable" width="60%">
				<el-form ref="addform" :model="addform" label-width="123px">
					<el-form-item label="品牌名称" prop="brandName">
						<el-input v-model="addform.brandName"></el-input>
					</el-form-item>
					<el-form-item label="品牌网址" prop="brandUrl">
						<el-input v-model="addform.brandUrl"></el-input>
					</el-form-item>
					<el-form-item label="品牌描述" prop="brandDesc">
						<el-input v-model="addform.brandDesc"></el-input>
					</el-form-item>

					<!-- <el-form-item label="级别" prop="goodsLevel">
						<el-input v-model="addform.goodsLevel"></el-input>
					</el-form-item> -->

					<el-button type="primary" @click="addFromSubmit">保存</el-button>
					<el-button @click="addFormVisable = false">取 消</el-button>
					</el-form-item>
					</el-form-item>
				</el-form>
			</el-dialog>


			<el-dialog title="修改品牌" :visible.sync="editFormVisable" width="60%">
				<el-form ref="editform" :model="editform" label-width="123px">
					<el-form-item label="品牌名称" prop="brandName">
						<el-input v-model="editform.brandName"></el-input>
					</el-form-item>
					<el-form-item label="品牌网址" prop="brandUrl">
						<el-input v-model="editform.brandUrl"></el-input>
					</el-form-item>
					<el-form-item label="品牌描述" prop="brandDesc">
						<el-input v-model="editform.brandDesc"></el-input>
					</el-form-item>

					<!-- <el-form-item label="级别" prop="goodsLevel">
						<el-input v-model="addform.goodsLevel"></el-input>
					</el-form-item> -->

					<el-button type="primary" @click="editFromSubmit">保存</el-button>
					<el-button @click="editFormVisable = false">取 消</el-button>
					</el-form-item>
					</el-form-item>
				</el-form>
			</el-dialog>


		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				currentRow: null,
				pageinfo: {
					pageNum: 1,
					pageSize: 5,
					total: 10
				},
				addform: {
					brandName: '',
					brandUrl: '',
					brandDesc: ''
				},
				editform: {
					brandName: '',
					brandUrl: '',
					brandDesc: '',

				},

				addFormVisable: false,
				editFormVisable: false,
				queryFormVisable: false,
				disBtn: true,
				queryForm: {
					brandName: ''
				}



			}
		},
		methods: {
			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				this.disBtn = false; //点击该行数据时 按钮禁用模式 取消
				console.log("当前对象" + this.currentRow);
			},
			// page相关函数，size改变，查询按钮、重置按钮
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				// this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				let param = this.$qs.stringify(this.pageinfo);
				this.myquery(param); //刷新页数
			},
			//page改变
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageinfo.pageNum = val;
				let param = this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo);
				console.log("111" + param)
				this.myquery(); //刷新页数
			},
			// 查询重置
			myreset() {
				this.$refs['queryForm'].resetFields();
			},

			resetForm(formName) {
				this.$refs[formName].resetFields();
			},

			myadd() {
				this.addFormVisable = true;
				this.$nextTick(function() {
					this.resetForm('addform');
				})
			},
			//添加是提交保存按钮 
			addFromSubmit() {
				// this.addform=1;
				this.addFormVisable = false;
				this.$axios.post("brandManager/add", this.addform)
					.then(resp => {
						console.log(resp.code);
						if (resp.code == 20000) {

							this.$message({
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg);
						}
						this.editFormVisable = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
					})
			},
			myedit() {
				this.editFormVisable = true;
				if (this.currentRow) {
					this.editform = JSON.parse(JSON.stringify(this.currentRow));
					console.log("修改的" + this.editform)
				}
			},
			editFromSubmit() {
				// this.addform=1;
				this.editFormVisable = false;
				this.$axios.put("brandManager", this.editform)
					.then(resp => {
						console.log(resp.code);
						if (resp.code == 20000) {

							this.$message({
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg);
						}
						this.editFormVisable = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
					})
			},
			mydelete() {
				console.log(this.currentRow.brandId)
				this.$axios.put("brandManager/update1",this.currentRow)
					.then(resp => {
						console.log(resp.code);
						if (resp.code == 20000) {

							this.$message({
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg);
						}
						this.editFormVisable = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
					})
			},




			myquery() {
				let a = { ...this.pageinfo,
					...this.queryform
				}
				this.$axios.get("brandManager/list?" + this.$qs.stringify(a))
					.then(resp => {
						console.log(resp.data.list);
						this.tableData = resp.data.list;
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			}
		},
		mounted() {
			this.myquery();
			// this.getbrand();
			// this.getcolor();
			// this.getGoodsType();
		},

	}
</script>

<style>
</style>
