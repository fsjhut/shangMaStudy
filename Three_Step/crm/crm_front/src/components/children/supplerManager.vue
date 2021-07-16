<template>
	<div>
		<el-row :gutter="20">
			<el-form :inline="true" ref="queryForm" :model="queryForm" class="demo-form-inline">
				<el-form-item label="供应商名称" prop="supplierName">
					<el-input v-model="queryForm.supplierName" placeholder="供应商名称"></el-input>
				</el-form-item>
				<el-form-item label="联系人" prop="supplierRealname">
					<el-input v-model="queryForm.supplierRealname" placeholder="供应商名称"></el-input>
				</el-form-item>
				<!-- <el-form-item label="选择推荐">
					<el-select :v-model="form">
						<el-option v-for="item in allForm" :value="item" :label="item">
						</el-option>
					</el-select>
				</el-form-item> -->
				<el-form-item>
					<el-button type="primary" @click="queryList">查询</el-button>

					<el-button type="success" @click="addFormOpen()">新增供应商</el-button>
				</el-form-item>
			</el-form>
		</el-row>
		<el-table style="width:100%;border: 3px solid black; text-align: left;" :data="tableData" row-key="sid"
		 @current-change="handleRowchange" border>
			<el-table-column prop="supplierName" label="供应商名称" width="120">
			</el-table-column>
			<el-table-column prop="supplierRealname" label="联系人" width="100">
			</el-table-column>
			<el-table-column prop="supplierPhone" label="联系电话" width="140">
			</el-table-column>
			<el-table-column prop="supplierEmail" label="供应商邮箱" width="160">
			</el-table-column>
			<el-table-column prop="supplierAddress" label="供应商地址" width="140">
			</el-table-column>
			<el-table-column prop="depositBank" label="开户银行" width="200">
			</el-table-column>
			<el-table-column prop="accountNumber" label="开户账号" width="200">
			</el-table-column>
			<el-table-column label="操作" width="380">
				<template slot-scope="scope">

					<el-button type="primary" plain :disabled="btnstatus" @click="choseGood"> 选择供应商品</el-button>
					<el-button type="warning" :disabled="btnstatus" @click="editFormOpen">修改</el-button>
					<el-button type="danger" :disabled="btnstatus" @click="delFormOpen">删除</el-button>
				</template>
			</el-table-column>


		</el-table>

		<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
		 :page-sizes="[5, 10, 20]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
		</el-pagination>

		<el-dialog title="新增供应商" :visible.sync="dialogForm">
			<el-form :model="typeform">
				<el-form-item label="供应商名称" :label-width="formLabelWidth">
					<el-input v-model="typeform.supplierName" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="联系人" :label-width="formLabelWidth">
					<el-input v-model="typeform.supplierRealname" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="联系电话" :label-width="formLabelWidth">
					<el-input v-model="typeform.supplierPhone" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="供应商邮箱" :label-width="formLabelWidth">
					<el-input v-model="typeform.supplierEmail" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="供应商地址" :label-width="formLabelWidth">
					<el-input v-model="typeform.supplierAddress" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="开户银行" :label-width="formLabelWidth">
					<el-input v-model="typeform.depositBank" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="开户账号" :label-width="formLabelWidth">
					<el-input v-model="typeform.accountNumber" autocomplete="off">
					</el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">

				<el-button type="primary" @click="addSubmit()">保存</el-button>
				<el-button @click="dialogForm = false">返回</el-button>
			</div>
		</el-dialog>

		<el-dialog title="修改" :visible.sync="editFormVisible">
			<el-form ref="editFrom" :model="editFrom">

				<el-form-item label="供应商名称" :label-width="formLabelWidth">
					<el-input v-model="editFrom.supplierName" :disabled="true" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="联系人" :label-width="formLabelWidth">
					<el-input v-model="editFrom.supplierRealname" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="联系电话" :label-width="formLabelWidth">
					<el-input v-model="editFrom.supplierPhone" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="供应商邮箱" :label-width="formLabelWidth">
					<el-input v-model="editFrom.supplierEmail" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="供应商地址" :label-width="formLabelWidth">
					<el-input v-model="editFrom.supplierAddress" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="开户银行" :label-width="formLabelWidth">
					<el-input v-model="editFrom.depositBank" :disabled="true" autocomplete="off">
					</el-input>
				</el-form-item>
				<el-form-item label="开户账号" :label-width="formLabelWidth">
					<el-input v-model="editFrom.accountNumber" :disabled="true" autocomplete="off">
					</el-input>
				</el-form-item>

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="editFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="editSubmit()">确 定</el-button>
			</div>
		</el-dialog>

		<!-- ******************************** -->
		<el-dialog title="选择供应商品" :visible.sync="dialogGoodVisible">

			<el-button icon="el-icon-search"  @click="selectProducts" circle>添加商品</el-button>
			<el-form ref="promoteSaleDate" :model="promoteSaleDate" label-width="120px">
				<el-form-item label="">
					<el-table ref="productDateTable" :data="productDate" stripe style="width: 100%" slot-scope="scope">
						<el-table-column prop="productId" label="id" width="50">
						</el-table-column>
						<el-table-column prop="productName" label="商品名字" width="80">
						</el-table-column>

						<el-table-column prop="marketPrice" label="市场价格" width="100">
						</el-table-column>
						<el-table-column prop="shoppingPrice" label="商场价格" width="100">
						</el-table-column>


						<el-table-column prop="delete" label="删除商品" width="100">
							<template slot-scope="scope">
								<el-button icon="el-icon-delete" circle @click.native.prevent="deleteProduct(scope.$index, productDate)" type="danger">移除
								</el-button>
							</template>
						</el-table-column>
					</el-table>
				</el-form-item>
				<el-form-item prop="operate" label="" width="100">
					<!-- <el-button type="danger" @click="resetForm">重置</el-button> -->
					<el-button type="primary" @click="addSave">保存</el-button>
					<el-button type="primary" @click="dialogGoodVisible=false">取消</el-button>
				</el-form-item>
			</el-form>

		</el-dialog>

		<!-- **************************************************************************** -->

		<el-dialog :visible.sync="addProductsVisible" width="65%" center>
			<el-form ref="productQueryForm" :inline="true" :model="productQueryForm" class="demo-form-inline">
				<el-form-item label="商品名字：" prop="goodsName">
					<el-input v-model="productQueryForm.goodsName" placeholder="商品名字"></el-input>
				</el-form-item>
				<el-form-item label="商品型号：" prop="goodsModel">
					<el-input v-model="productQueryForm.goodsModel" placeholder="商品型号"></el-input>
				</el-form-item>
				<br />
				<el-form-item label="商品颜色" prop="goodsColor">
					<el-select v-model="productQueryForm.goodsColor" placeholder="商品颜色">
						<el-option v-for="item in colors" :value="item.goodsColor" :label="item.goodsColor">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="商品品牌" prop="goodsBrand">
					<el-select v-model="productQueryForm.goodsBrand" placeholder="商品品牌">
						<!-- <el-option label="商品品牌" :value="0"></el-option> -->
						<el-option v-for="item in brands" :value="item.goodsBrand" :label="item.goodsBrand">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="商品分类：" prop="goodsType">
					<el-select v-model="productQueryForm.goodsType" placeholder="商品分类">
						<!-- <el-option label="商品分类" :value="0"></el-option> -->
						<el-option v-for="item in goodsTypes" :value="item.goodsType" :label="item.goodsType">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button type="warning" @click="productMyquery()">查询</el-button>
					<el-button type="primary" @click="resetProductMyquery()">重置</el-button>
				</el-form-item>
			</el-form>

			<el-table ref="singleTable" :data="productTableData" highlight-current-row style="width: 100%">
				<el-table-column property="" label="序号" width="60px " type="index">
				</el-table-column>
				<el-table-column property="goodsName" label="商品名称" width="160">
				</el-table-column>
				<el-table-column property="goodsType" label="商品分类" width="160">
				</el-table-column>
				<el-table-column property="goodsBrand" label="商品品牌" width="160">
				</el-table-column>
				<el-table-column property="goodsModel" label="商品型号" width="160">
				</el-table-column>
				<el-table-column property="goodsColor" label="商品颜色" width="160">
				</el-table-column>
				<el-table-column label="操作" width="300">
					<template slot-scope="{row, $index}">
						<el-button type="primary" circle @click="addProduct(row, $index)">添加</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!--  要接受从后台返回的数据 页数 current-page="currentPage4" -->
			<el-pagination @size-change="productHandleSizeChange" @current-change="productHandleCurrentChange" :current-page="productPageinfo.page"
			 :page-sizes="[3, 6, 10]" :page-size="productPageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper"
			 :total="productPageinfo.total">
			</el-pagination>

		</el-dialog>
		<!-- ******************************************************************************************* -->

	</div>

</template>

<script>
	export default {
		data() {
			return {
				queryForm: {
					supplierName: '',
					supplierRealname: ''
				},
				typeform: {
					supplierName: '',
					supplierRealname: '',
					supplierPhone: '',
					supplierEmail: '',
					supplierAddress: '',
					depositBank: '',
					accountNumber: ''
				},
				editFrom: {
					sid: '',
					supplierName: '',
					supplierRealname: '',
					supplierPhone: '',
					supplierEmail: '',
					supplierAddress: '',
					depositBank: '',
					accountNumber: ''
				},
				pageinfo: {
					pageNum: 1,
					pageSize: 5,
					total: 10
				},

				formLabelWidth: '120px',
				tableData: [],
				allForm: [],
				productTableData: [],
				btnstatus: true,
				dialogForm: false,
				editFormVisible: false,
				dialogGoodVisible: false,
				// 添加商品-----------------------------------------------------
				addProductsVisible: false,
				productQueryForm: {
					goodsName: '',
					goodsType: '',
					goodsColor: '',
					goodsBrand: '',
					goodsType: ''
				},
				brands: [],
				colors: [],
				goodsTypes: [],
				productDate: [],
				productTableData: [],
				addProductsVisible: false,
				productQueryForm: {
					goodsName: '',
					goodsType: '',
					goodsColor: '',
					goodsBrand: '',
					goodsType: ''
				},
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
				testDate:{
					productId:''
				},
				productPageinfo: {
					pageNum: 1,
					pageSize: 3,
					total: 10
				}

			}
		},
		methods: {
			handleRowchange(val) {
				this.btnstatus = false;
				console.log("rowchange 触发了");
				this.currentRow = val

				console.log(JSON.parse(JSON.stringify(this.currentRow)));
				if (this.currentRow != null) {
					this.editFrom = JSON.parse(JSON.stringify(this.currentRow));
				}

			},
			// page相关函数，size改变，查询按钮、重置按钮
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				// this.pageinfo.page = 1;
				this.pageinfo.pageSize = val;
				let param = this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo);
				this.queryList(param); //刷新页数

			},
			//page改变
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageinfo.pageNum = val;
				let param = this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo);
				console.log("111" + param)
				this.queryList(param); //刷新页数
			},
			addFormOpen() {
				console.log(1)
				this.dialogForm = true;
			},
			addSubmit() {
				this.dialogForm = false;
				this.mybtnstatus = true;
				this.$axios.post("crmSupplier", this.typeform)
					.then(returnval => {

						//给用户提示
						if (returnval.code == 20000) {
							this.$message({
								message: returnval.msg,
								type: 'success'
							});
						} else if (returnval.code == 50000) {
							this.$message.error(returnval.msg);
						}
						//刷新 table数据
						let myparam = this.$qs.stringify(this.pageinfo);
						this.queryList(myparam);
						this.typeform=[];
						//刷新数数据
						this.gettree();
					})
					.catch(err => {

					})

			},
			editFormOpen() {
				this.editFormVisible = true;

			},
			editSubmit() {
				this.editFormVisible = false;

				this.$axios.put("crmSupplier", this.editFrom)
					.then(returnval => {

						//给用户提示
						if (returnval.code == 20000) {
							this.$message({
								message: returnval.msg,
								type: 'success'
							});
						} else if (returnval.code == 50000) {
							this.$message.error(returnval.msg);
						}
						//刷新 table数据
						let myparam = this.$qs.stringify(this.pageinfo);
						this.queryList(myparam);
					})
					.catch(err => {

					})
			},
			delFormOpen() {
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					//发请求
					this.$axios.delete("crmSupplier/" + this.currentRow.sid)
						.then(returnval => {
							console.log(returnval.data);
							//给用户提示
							if (returnval.code == 20000) {
								this.$message({
									message: returnval.msg,
									type: 'success'
								});
							} else if (returnval.code == 50000) {
								this.$message.error(returnval.msg);
							}
							//刷新 table数据
							let myparam = this.$qs.stringify(this.pageinfo);
							this.queryList(myparam);
						})
						.catch(err => {

						})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			},
			choseGood() {
				
				this.dialogGoodVisible = true;
				this.$axios.get("crmSupplyGoods/" + this.currentRow.sid)
					.then(resp => {
						console.log(resp.data)

					}).catch(function(err) {
						console.log(err)
					})
			},
			handleClick(row) {
				console.log(row);
			},
			queryList() {
				this.$axios.get("crmSupplier/list?" + this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo))
					.then(returnval => {

						if (returnval.code == 20000) {
							this.$message.success(returnval.msg);
							this.tableData = returnval.data.list;
							this.pageinfo.pageNum = returnval.data.pageNum;
							this.pageinfo.pageSize = returnval.data.pageSize;
							this.pageinfo.total = returnval.data.total;
						} else if (returnval.code == 50000) {
							this.$message.error(returnval.msg);
						}

					})
					.catch(err => {

					})
			},
			//----------------------------------------------------------------------
			selectProducts() {
				//打开第二个模态框，将查询到的数据传递进去
				this.addProductsVisible = true;
				this.getbrand();
				this.getcolor();
				this.getGoodsType();
				this.productMyquery();
			},

			deleteProduct(index, rows) {
				rows.splice(index, 1);
			},
			onDelete(val) {
				this.promoteId = val.promoteId;
				this.$axios.delete("/promoteSale/" + this.promoteId)
					.then(resp => {
						if (resp.code == 20000) {
							this.$message({
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg);
						}
					});
			},
			productsMyquery() {
				this.$axios.get("goodsManager/list?" +
						this.$qs.stringify(this.queryForm) + "&" + this.$qs.stringify(this.pageinfo))
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
			resetProductsMyquery() {
				// this.$refs['selectTableDate'].resetFields();
			},
			addProduct(row, $index) {
				
				this.testDate.productId=row.goodsId
			
				console.log("这里")
				let productNum = this.productDate.length;
				let newProuduct = {};
				var newProudctArray = [];
				if (productNum == 0) {
					newProuduct.productId = row.goodsId;
					newProuduct.productName = row.goodsName;
					newProuduct.productStock = row.inventoryNumber;
					newProuduct.marketPrice = row.marketRmb;
					newProuduct.shoppingPrice = row.mallRmb;
					newProuduct.promotePrice = row.mallRmb;
					newProuduct.promoteNum = "";
					newProudctArray.push(newProuduct);
					this.productDate = newProudctArray;
				} else {
					// newProudctArray = this.productDate;
					newProuduct.productId = row.goodsId;
					newProuduct.productName = row.goodsName;
					newProuduct.productStock = row.inventoryNumber;
					newProuduct.marketPrice = row.marketRmb;
					newProuduct.shoppingPrice = row.mallRmb;
					newProuduct.promotePrice = row.mallRmb;
					newProuduct.promoteNum = "";
					// 需要刷新添加或者修改的页面
					this.$set(this.productDate, productNum, newProuduct);
					// this.productDate[productNum] = newProuduct;
				}
				console.log(this.productDate);
				// debugger;
				// this.productDate.push(newProuduct;);
				// this.$refs['productDateTable'].resetFields();
			},
			onTrack(val) {
				this.promoteId = val.promoteId;
				this.inputStatus = true;
				this.centerDialogVisible = true;
				this.showVerfiy = false;
				this.$axios.get("/verify/" + this.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						this.verifyDate = resp.data.Verify;
						console.log(this.verifyDate);
						// debugger;
						this.formatTime(this.promoteSaleDate.endTime);
					});
			},
			
			addSave() {
				console.log(this.productDate)
				
				console.log("上下")
				console.log(this.testDate)
				let jsonStr = {
					"sid": this.currentRow.sid,
					"goodsId": this.testDate.productId
				};
				console.log(jsonStr);
				this.$axios.post("/goodsSupplier", jsonStr).then(resp => {
					if (resp.code == 20000) {

						this.$message({
							message: resp.msg,
							type: 'success'
						});
					} else if (resp.code == 50000) {
						this.$message.error(resp.msg);
					}
				});
				this.addDialogVisible = false;
				this.addFormDate = '';
				this.productDate = [];
this.testDate.productId='';
			},
			
			//商品页面改变时-------------------------------------------- 
			productHandleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				// this.pageinfo.page = 1;
				this.productPageinfo.pageSize = val;
				let param = this.$qs.stringify(this.productQueryForm) + "&" + this.$qs.stringify(this.productPageinfo);
				this.productMyquery(param); //刷新页数
			},
			//page改变
			productHandleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.productPageinfo.pageNum = val;
				let param = this.$qs.stringify(this.productQueryForm) + "&" + this.$qs.stringify(this.productPageinfo);
				console.log("111" + param)
				this.productMyquery(param); //刷新页数
			},
			productMyquery() {
				this.$axios.get("goodsManager/list?" + this.$qs.stringify(this.productQueryForm) +
						"&" + this.$qs.stringify(this.productPageinfo))
					.then(resp => {

						console.log("2222" + this.productPageinfo)
						console.log(resp.data.list);
						this.productTableData = resp.data.list;
						console.log("当前" + resp.data.pageNum)
						this.productPageinfo.pageNum = resp.data.pageNum;
						this.productPageinfo.pageSize = resp.data.pageSize;
						this.productPageinfo.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			},
			resetProductMyquery() {
				this.$refs['productQueryForm'].resetFields();
				this.productMyquery();
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
		mounted() {
			this.queryList();
		}
	}
</script>

<style>


</style>
