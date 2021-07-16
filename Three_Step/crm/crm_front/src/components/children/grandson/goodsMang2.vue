<template>
	<div>
		<template>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{}">商品与赠品管理管理</el-breadcrumb-item>
				<el-breadcrumb-item>商品管理</el-breadcrumb-item>
				<el-breadcrumb-item>商品信息列表</el-breadcrumb-item>
			</el-breadcrumb>
			<br />
			<el-form ref="queryForm" :inline="true" :model="queryForm" class="demo-form-inline">
				<el-form-item label="商品名字：" prop="goodsName">
					<el-input v-model="queryForm.goodsName" placeholder="商品名字"></el-input>
				</el-form-item>
				<el-form-item label="商品型号：" prop="goodsModel">
					<el-input v-model="queryForm.goodsModel" placeholder="商品型号"></el-input>
				</el-form-item>
				<br />
				<el-form-item label="商品颜色" prop="goodsColor">
					<el-select v-model="queryForm.goodsColor" placeholder="">

						<!-- <el-option label="商品颜色" :value="0"></el-option> -->
						<el-option v-for="item in colors" :value="item.goodsColor" :label="item.goodsColor">
						</el-option>

					</el-select>
				</el-form-item>

				<el-form-item label="商品品牌" prop="goodsBrand">
					<el-select v-model="queryForm.goodsBrand" placeholder="商品品牌">
						<!-- <el-option label="商品品牌" :value="0"></el-option> -->
						<el-option v-for="item in brands" :value="item.goodsBrand" :label="item.goodsBrand">
						</el-option>

					</el-select>
				</el-form-item>

				<!-- <el-cascader :change-on-select="true" :props="defaultParams"  :options="goodsTypes" 
				 :clearable="true"></el-cascader> -->
				
				
				<el-form-item label="商品分类" prop="goodsType">
					<el-select v-model="queryForm.goodsType" placeholder="商品品牌">
						<!-- <el-option label="商品品牌" :value="0"></el-option> -->
						<el-option v-for="item in goodsTypes" :value="item.goodsType" :label="item.goodsType">
						</el-option>
				
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button type="warning" @click="myquery()">查询</el-button>
					<el-button type="primary" @click="myreset()">重置</el-button>
					<el-button type="success" @click="addFir()">添加一类商品</el-button>
					<el-button type="success" @click="addSec()">添加二类商品</el-button>
				</el-form-item>
			</el-form>

			<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleRowchange" style="width: 100%">
				<el-table-column property="" label="序号" width="60px " type="index">
				</el-table-column>
				<el-table-column type="selection" width="55"> </el-table-column>
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
					<template slot-scope="scope">
						<el-button @click="openQueryForm" type="warning">查看</el-button>
						<el-button type="primary" :disabled="disBtn" @click="openEditForm">编辑</el-button>
						<el-button type="danger">删除</el-button>
					</template>
				</el-table-column>
			</el-table>


			<!--  要接受从后台返回的数据 页数 current-page="currentPage4" -->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[5, 10, 20]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>


			<el-dialog title="查看" :visible.sync="queryFormVisable" width="40%">
				<el-form ref="queryform" :model="queryform" label-width="200px" hide-required-asterisk>

					<el-form-item label="存货档案编码" prop="goodsCode">
						<el-input v-model="queryform.goodsCode" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-分类" prop="goodsType">
						<el-input v-model="queryform.goodsType" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-品牌" prop="goodsBrand">
						<el-input v-model="queryform.goodsBrand" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-型号" prop="goodsModel">
						<el-input v-model="queryform.goodsModel" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-业务模式" prop="basePurchasingMode">
						<el-input v-model="queryform.basePurchasingMode" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-颜色" prop="goodsColor">
						<el-input v-model="queryform.goodsColor" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-采购模式" prop="businessModel ">
						<el-input v-model="queryform.businessModel" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-铺货" prop="baseComplementaryGoods">
						<el-input v-model="queryform.baseComplementaryGoods" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-备机" prop="baseStandby">
						<el-input v-model="queryform.baseStandby" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="商品名称" prop="goodsName">
						<el-input v-model="queryform.goodsName" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="商品类别" prop="goodsType">
						<el-input v-model="queryform.goodsType" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="市场价" prop="marketRmb">
						<el-input v-model="queryform.marketRmb" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="商城价" prop="mallRmb">
						<el-input v-model="queryform.mallRmb" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="库存" prop="inventoryNumber">
						<el-input v-model="queryform.inventoryNumber" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="是否可采购" prop="booleanBuy">
						<el-input v-model="queryform.booleanBuy"></el-input>
					</el-form-item>
					<el-form-item>
						<el-button type="primary" @click="queryFromSubmit">返回</el-button>
					</el-form-item>

				</el-form>
			</el-dialog>


			<el-dialog title="修改" :visible.sync="editFormVisable" width="50%">
				<el-form ref="editform" :model="editform" label-width="200px" hide-required-asterisk>
					<el-form-item label="存货档案编码" prop="goodsCode">
						<el-input v-model="editform.goodsCode" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-分类" prop="goodsType">
						<el-input v-model="editform.goodsType" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-品牌" prop="goodsBrand">
						<el-input v-model="editform.goodsBrand" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-型号" prop="goodsModel">
						<el-input v-model="editform.goodsModel" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-业务模式" prop="basePurchasingMode">
						<el-input v-model="editform.basePurchasingMode" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-颜色" prop="goodsColor">
						<el-input v-model="editform.goodsColor" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-采购模式" prop="businessModel">
						<el-input v-model="editform.businessModel" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-铺货" prop="baseComplementaryGoods">
						<el-input v-model="editform.baseComplementaryGoods" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="基础库-备机" prop="baseStandby">
						<el-input v-model="editform.baseStandby" :readonly="true"></el-input>
					</el-form-item>
					<el-form-item label="商品名称" prop="goodsName">
						<el-input v-model="editform.goodsName"></el-input>
					</el-form-item>
					<el-form-item label="商品类别" prop="goodsType">
						<el-select v-model="editform.goodsType" placeholder="请选择">
							<el-option label="全部" :value="0"></el-option>
							<el-option v-for="item in goodsTypes" :value="item.goodsType" :label="item.goodsType"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="市场价" prop="marketRmb">
						<el-input v-model="editform.marketRmb"></el-input>
					</el-form-item>

					<el-form-item label="商城价" prop="mallRmb">
						<el-input v-model="editform.mallRmb"></el-input>
					</el-form-item>
					<el-form-item label="库存" prop="inventoryNumber">
						<el-input v-model="editform.inventoryNumber"></el-input>
					</el-form-item>
					<el-form-item label="是否可采购" prop="booleanBuy">
						<el-select v-model="editform.booleanBuy" placeholder="请选择">
							<el-option label="可以购买" :value="1">
							</el-option>
							<el-option label="不可购买" :value="0">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item>
						<el-button type="prmyreset2imary" @click="editFromSubmit">提交</el-button>
						<el-button @click="myreset2">重置</el-button>

					</el-form-item>
				</el-form>
			</el-dialog>


			<el-dialog title="添加一级商品" :visible.sync="addFormVisable" width="40%">
				<el-form ref="addform" :model="addform" label-width="150px">
					<el-form-item label="存货档案编码" prop="goodsCode">
						<el-input v-model="addform.goodsCode"></el-input>
					</el-form-item>
					<el-form-item label="基础库-分类" prop="goodsType">
						<el-input v-model="addform.goodsType"></el-input>
					</el-form-item>
					<el-form-item label="基础库-品牌" prop="goodsBrand">
						<el-input v-model="addform.goodsBrand"></el-input>
					</el-form-item>
					<el-form-item label="基础库-型号" prop="goodsModel">
						<el-input v-model="addform.goodsModel"></el-input>
					</el-form-item>
					<el-form-item label="基础库-业务模式" prop="basePurchasingMode">
						<el-input v-model="addform.basePurchasingMode"></el-input>
					</el-form-item>
					<el-form-item label="基础库-颜色" prop="goodsColor">
						<el-input v-model="addform.goodsColor"></el-input>
					</el-form-item>
					<el-form-item label="基础库-采购模式" prop="businessModel">
						<el-input v-model="addform.businessModel"></el-input>
					</el-form-item>
					<el-form-item label="基础库-铺货" prop="baseComplementaryGoods">
						<el-input v-model="addform.baseComplementaryGoods"></el-input>
					</el-form-item>
					<el-form-item label="基础库-备机" prop="baseStandby">
						<el-input v-model="addform.baseStandby"></el-input>
					</el-form-item>
					<el-form-item label="商品名称" prop="goodsName">
						<el-input v-model="addform.goodsName"></el-input>
					</el-form-item>
					<el-form-item label="商品类别" prop="goodsType">
						<el-cascader :change-on-select="true" :props="defaultParams" 
						       :options="allAreaDatas"  :clearable="true"></el-cascader>
					</el-form-item>
					<el-form-item label="市场价" prop="marketRmb">
						<el-input v-model="addform.marketRmb"></el-input>
					</el-form-item>

					<el-form-item label="商城价" prop="mallRmb">
						<el-input v-model="addform.mallRmb"></el-input>
					</el-form-item>
					<el-form-item label="库存" prop="inventoryNumber">
						<el-input v-model="addform.inventoryNumber"></el-input>
					</el-form-item>
					<el-form-item label="是否可采购" prop="booleanBuy">
						<el-select v-model="addform.booleanBuy" placeholder="请选择">
							<el-option label="可以购买" :value="1">
							</el-option>
							<el-option label="不可购买" :value="0">
							</el-option>
						</el-select>
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

			<el-dialog title="添加二级商品" :visible.sync="addFormVisable1" width="40%">
				<el-form ref="addform1" :model="addform1" label-width="100px">

					<el-form-item label="基础库-品牌" prop="goodsBrand">
						<el-input v-model="addform1.goodsBrand"></el-input>
					</el-form-item>
					<el-form-item label="基础库-型号" prop="goodsModel">
						<el-input v-model="addform1.goodsModel"></el-input>
					</el-form-item>
					<el-form-item label="基础库-颜色" prop="goodsColor">
						<el-select v-model="addform1.goodsColor" placeholder="请选择">
							<el-option label="全部" :value="0"></el-option>
							<el-option v-for="item in colors" :value="item.goodsColor" :label="item.goodsColor"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="商品名称" prop="goodsName">
						<el-input v-model="addform1.goodsName"></el-input>
					</el-form-item>
					<el-form-item label="商品类别" prop="goodsType">
						<el-select v-model="addform1.goodsType" placeholder="请选择">
							<el-option label="全部" :value="0"></el-option>
							<el-option v-for="item in goodsTypes" :value="item.goodsType" :label="item.goodsType"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="市场价" prop="marketRmb">
						<el-input v-model="addform1.marketRmb"></el-input>
					</el-form-item>

					<el-form-item label="商城价" prop="mallRmb">
						<el-input v-model="addform1.mallRmb"></el-input>
					</el-form-item>
					<el-form-item label="库存" prop="inventoryNumber">
						<el-input v-model="addform1.inventoryNumber"></el-input>
					</el-form-item>
					<el-form-item label="是否可采购" prop="booleanBuy">
						<el-select v-model="addform1.booleanBuy" placeholder="请选择">
							<el-option label="可以购买" :value="1">
							</el-option>
							<el-option label="不可购买" :value="0">
							</el-option>
						</el-select>
					</el-form-item>
					<el-button type="primary" @click="addFromSubmit1">保存</el-button>
					<el-button @click="addFormVisable = false">取 消</el-button>
					</el-form-item>
					</el-form-item>
				</el-form>
			</el-dialog>
		</template>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				allAreaDatas:[],
				defaultParams: {
					label: 'typeName',
					value: 'tid',
					children: 'children'
				},
				tableData: [],
				currentRow: null,
				pageinfo: {
					pageNum: 1,
					pageSize: 5,
					total: 10
				},
				queryForm: {
					goodsName: '',
					goodsType: '',
					goodsColor: '',
					goodsBrand: '',
					goodsType: ''
				},
				addFormVisable: false,
				addFormVisable1: false,
				queryFormVisable: false,
				editFormVisable: false,
				disBtn: true,
				editform: {},
				queryform: {},
				addform: {
					goodsCode: '',
					goodsType: '',
					goodsName: '',
					goodsBrand: '',
					goodsModel: '',
					goodsColor: '',
					procurementRmb: '',
					marketRmb: '',
					mallRmb: '',
					booleanBuy: '',
					goodsCode: '',
					inventoryNumber: '',
					businessModel: '',
					basePurchasingMode: '',
					baseComplementaryGoods: '',
					baseStandby: '',
				},
				addform1: {
					goodsCode: '',
					goodsType: '',
					goodsName: '',
					goodsBrand: '',
					goodsModel: '',
					goodsColor: '',
					procurementRmb: '',
					marketRmb: '',
					mallRmb: '',
					booleanBuy: '',
					goodsCode: '',
					inventoryNumber: '',
					businessModel: '',
					basePurchasingMode: '',
					baseComplementaryGoods: '',
					baseStandby: '',
				},

				brands: [], //
				
				colors: [],
				goodsTypes: [],
				goodsTypes1: [],
				// defaultProps: {
				// 	children: 'children',
				// 	typeName: 'label'
				// }



			}
		},
		methods: {
			// 变更当前行
			handleRowchange(val) {
				this.currentRow = val;
				this.disBtn = false;
				console.log("当前对象" + this.currentRow);
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
			// 查询重置
			myreset() {
				this.$refs['queryForm'].resetFields();
			},

			// 修改框重置
			myreset2() {
				this.$refs['editform'].resetFields();
			},

			resetForm(formName) {
				this.$refs[formName].resetFields();
			},


			//点击新增二级商品按钮
			addSec() {
				this.addFormVisable1 = true;
				this.$nextTick(function() {
					this.resetForm('addform1');
				})
			},
			//添加是提交保存按钮
			addFromSubmit1() {
				// this.addform=1;
				this.addFormVisable1 = false;
				this.$axios.post("goodsManager/add/2", this.addform1)
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
						this.addFormVisable1 = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
					})
			},
			//点击新增一级商品按钮
			addFir() {
				this.addFormVisable = true;
				this.$nextTick(function() {
					this.resetForm('addform');
				})
				this.$axios.get("goodType/tree")
				.then(resp=>{
					console.log("商品类型数据")
					this.allAreaDatas=resp.data;
					console.log(resp.data)
				}).catch(err=>{
					console.log(err);
				})
			},
			//添加是提交保存按钮 
			addFromSubmit() {
				// this.addform=1;
				this.addFormVisable = false;
				this.$axios.post("goodsManager/add/1", this.addform)
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
						this.addFormVisable = false;
						this.myquery();
					}).catch(err => {
						console.log(err);
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

			//点击打开查看框
			openQueryForm() {
				this.queryFormVisable = true;
				this.queryform = JSON.parse(JSON.stringify(this.currentRow));
			},
			//提交修改保存
			queryFromSubmit() {
				this.queryFormVisable = false;

			},

			//修改
			//点击提交修改
			openEditForm() {
				this.editFormVisable = true;
				if (this.currentRow) {
					this.editform = JSON.parse(JSON.stringify(this.currentRow));
					console.log("修改的" + this.editform)
				}

			},
			//提交修改保存  提交修改框
			editFromSubmit() {
				this.editFormVisable = false;
				console.log(this.editform)
				this.$axios.put("goodsManager", this.editform)
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
						console.log("数据：-------------")
						console.log(this.goodsTypes);
					})
					.catch(err => {
						console.log(err);
					})
			}

		},
		
		getType() { ////刷新商品分类的下拉框
				this.$axios.get("goodType/tree")
					.then(resp => {
		
						console.log(resp);
						this.goodsTypes1 = resp;
						console.log("数据：-------------")
						console.log(this.goodsTypes1);
					})
					.catch(err => {
						console.log(err);
					})
		
		
		},

		//监听  操作完成  进行页面渲染
		mounted() {
			this.myquery();
			this.getbrand();
			this.getcolor();
			this.getGoodsType();
		},

	}
</script>

<style>
</style>
