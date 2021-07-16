<template>
	<div>
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/mypage' }">商品与赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item>赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item>商品转赠品管理</el-breadcrumb-item>

		</el-breadcrumb>
		<hr />
		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-form-item prop="goodsName" label="商品名称:">
				<el-input v-model="selectform.goodsName" placeholder="商品名称" style="width: 150px;"></el-input>
			</el-form-item>


			<el-form-item prop="goodsType" label="商品类型:">
				<el-select v-model="selectform.goodsType" placeholder="商品类型" style="width: 150px;">
					<el-option label="全部" value=""></el-option>
					<el-option v-for="item in types" :label="item.goodsType" :value="item.goodsType"></el-option>
					<!-- <template slot-scope="scope">
					      <el-tag :type="scope.row.goodsReviewstatus == '0' ? 'primary' : 'danger'" disable-transitions>{{scope.row.goodsReviewstatus==0?'有效':'草稿'}}</el-tag>
					     </template> -->
				</el-select>
			</el-form-item>
			<el-form-item prop="giftReviewstatus" label="审核状态:">
				<el-select v-model="selectform.giftReviewstatus" placeholder="审核状态" style="width: 150px;">

					<el-option label="全部" value=""></el-option>
					<el-option v-for="item in reviewstatus" :label="item.descInfo" :value="item.giftReviewstatus"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item prop="goodsReviewstatus" label="赠品状态:">
				<el-select v-model="selectform.goodsReviewstatus" placeholder="赠品状态" style="width: 150px;">

					<el-option label="全部" value=""></el-option>
					<el-option v-for="item in reviewstatus" :label="item.descInfo" :value="item.giftReviewstatus"></el-option>
				</el-select>
			</el-form-item>


		</el-form>
		<div>
			<el-button type="primary" @click="querydata()">查询</el-button>

			<el-button type="success" @click="goodsForm()">新增赠品转商品</el-button>
			<el-button @click="myreset()">重置</el-button>
			<hr />
		</div>
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleCurrentChange" style="width: 78.5%;height: 20%;"
		 border>
			</el-table-column>
			<el-table-column label="序号" width="50" type="index">
			</el-table-column>
			<el-table-column type="selection" width="55">
			</el-table-column>
			<el-table-column prop="goodsName" label="赠品名称" width="100">
			</el-table-column>
			<el-table-column prop="goodsType" label="赠品类型" width="100">
			</el-table-column>
			<el-table-column prop="goodsBrand" label="赠品品牌" width="100">
			</el-table-column>
			<!-- <el-table-column prop="procurementRmb" label="赠品成本" width="100">
			</el-table-column> -->
			<el-table-column prop="marketRmb" label="赠品单价" width="100">
			</el-table-column>
			<el-table-column prop="giftNumber" label="赠品数量" width="100">
			</el-table-column>
			<!-- <el-table-column prop="giftReviewstatus" label="审核状态" width="100">
				<template slot-scope="scope">
					
					<el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'"
					 disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?'已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'无效'}}</el-tag>
				</template>
			</el-table-column>
			</el-table-column>
			<el-table-column label="操作" width="300">
				<template slot-scope="scope">
					<el-button size="mini" type="success" @click="handleSelect(scope.$index, scope.row)">查看</el-button>
					<el-button size="mini" type="warning" @click="handleUpdate(scope.$index, scope.row)">修改</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
					<el-button size="mini" type="danger" @click="audit(scope.$index, scope.row)">审核跟踪</el-button>
				</template>
			</el-table-column> -->
			<el-table-column prop="giftReviewstatus"  label="审核状态"  width="100" :formatter="giftReviews">
			  <!--   <template slot-scope="scope">
			          <el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'" disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?' 已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'草稿'}}</el-tag>
			         </template> -->
			   </el-table-column>
			   </el-table-column>
			   <el-table-column prop="operate" label="操作"   width="300">
			    <template slot-scope="scope" >
			     <el-button size="mini" type="success" @click="handleSelect(scope.$index, scope.row)"
			     >查看</el-button>
			     <el-button size="mini" type="warning" @click="handleUpdate(scope.$index, scope.row)"
			     :disabled="scope.row.operate">修改</el-button>
			     <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)"
			     :disabled="scope.row.operate">删除</el-button>
			     <el-button size="mini" type="danger" @click="audit(scope.$index, scope.row)">审核跟踪</el-button>
			    </template>
			   </el-table-column>
		</el-table>
		<el-dialog title="赠品详细信息" :visible.sync="selectFormVisible">
			<el-form ref="selectForm" :model="selectForm">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="goodsName">
					<el-input v-model="selectForm.goodsName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="goodsType">
					<el-input v-model="selectForm.goodsType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="goodsModel">
					<el-input v-model="selectForm.goodsModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="goodsPrice">
					<el-input v-model="selectForm.marketRmb" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品成本" :label-width="formLabelWidth" prop="procurementRmb">
					<el-input v-model="selectForm.procurementRmb" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="purchasingDepartment">
					<el-input v-model="selectForm.purchasingDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="goodsInventory">
					<el-input v-model="selectForm.giftNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="goodsColor">
					<el-input v-model="selectForm.goodsColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button type="primary" @click="sureSubmit() ">确 定</el-button>
			</div>

		</el-dialog>
		<el-dialog title="修改" :visible.sync="updateFormVisible">
			<el-form ref="updateForm" :model="updateForm">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="goodsName">
					<el-input v-model="updateForm.goodsName" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="goodsType">
					<el-input v-model="updateForm.goodsType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="goodsModel">
					<el-input v-model="updateForm.goodsModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="updateForm.marketRmb" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="updateForm.marketRmb" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="purchasingDepartment">
					<el-input v-model="updateForm.purchasingDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<!-- purchasingDepartment -->
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="inventoryNumber">
					<el-input v-model="updateForm.inventoryNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="goodsColor">
					<el-input v-model="updateForm.goodsColor" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item prop="giftNumber" label="入库数量" :label-width="formLabelWidth">
					<el-input v-model="updateForm.giftNumber" autocomplete="off" />
				</el-form-item>
				<el-form-item prop="tianyiPrice" label="天翼价" :label-width="formLabelWidth">
					<el-input v-model="updateForm.tianyiPrice" autocomplete="off" />
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="updateFormVisible = false ">取 消</el-button>

				<el-button type="primary" @click="updateSubmit() ">提交审核</el-button>
			</div>

		</el-dialog>


		<el-dialog title="审核跟踪详情" :visible.sync="trackingFormVisible">
			<el-form ref="trackingForm" :model="trackingForm">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="goodsName">
					<el-input v-model="trackingForm.goodsName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="goodsType">
					<el-input v-model="trackingForm.goodsType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="goodsModel">
					<el-input v-model="trackingForm.goodsModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="trackingForm.marketRmb" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="marketRmb">
					<el-input v-model="trackingForm.marketRmb" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="purchasingDepartment">
					<el-input v-model="trackingForm.purchasingDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品数量:" :label-width="formLabelWidth" prop="giftNumber">
					<el-input v-model="trackingForm.giftNumber" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="goodsColor">
					<el-input v-model="trackingForm.goodsColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<span>
					<h3>审核记录</h3>
				</span>
				<el-table ref="singleTable" :data="trackingForeData" highlight-current-row style="width: 100% " border>
					<el-table-column property="updateBy" label="审核人" width="100px">
					</el-table-column>
					<el-table-column property="updateTime" label="审核时间" width="150px">
					</el-table-column>
					<el-table-column property="giftReviewstatus" label="审核状态" width="100px">
						<template slot-scope="scope">
							<!-- 0：未审核，1：已审核，2：审核未通过 -->
							<el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' :scope.row.giftReviewstatus == '1'?'danger': scope.row.giftReviewstatus == '2'?'warning':'info'"
							 disable-transitions>{{scope.row.giftReviewstatus==0?'未审核': scope.row.giftReviewstatus==1?'已审核' :scope.row.giftReviewstatus==2?'审核未通过' :'无效'}}
							</el-tag>
						</template>
					</el-table-column>
					<el-table-column property="auditOpinion" label="审核意见">
					</el-table-column>
				</el-table>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="trackingFormVisible = false ">返回</el-button>
			</div>
		</el-dialog>


		<el-dialog title="新增赠品转商品" :visible.sync="TowaddFormVisible" style="width: 100%;">
			<el-table ref="singleTable" :data="TwotableData" highlight-current-row @current-change="handleCurrentChange" style="width: 116%"
			 borde>
				<el-table-column property="" label="序号" width="45px " type="index">
				</el-table-column>
				<el-table-column type="selection" width="45"> </el-table-column>

				<el-table-column property="goodsName" label="商品名称" width="78">
				</el-table-column>
				<el-table-column property="goodsType" label="商品类型" width="78">
				</el-table-column>
				<el-table-column property="goodsModel" label="商品型号" width="78">
				</el-table-column>
				<el-table-column property="marketRmb" label="商品单价" width="78">
				</el-table-column>
				<el-table-column property="procurementRmb" label="成本价格" width="78">
				</el-table-column>
				<el-table-column property="inventoryNumber" label="商品库存" width="78">
				</el-table-column>
				<el-table-column property="goodsColor" label="商品颜色" width="78">
				</el-table-column>
				<el-table-column property="goodsBrand" label="商品品牌" width="78">
				</el-table-column>
				<el-table-column property="basePurchasingMode" label="采购部门" width="78">
				</el-table-column>
				<el-table-column property="giftNumber" label="入库数量" width="78">
					<input v-model="testData" style="width: 60px;" placeholder="入库数量" />
				</el-table-column>
				<el-table-column property="tianyiPrice" label="天翼价" width="78">
					<input v-model="testData1" style="width: 60px;" placeholder="天翼价" />
				</el-table-column>

				<el-table-column label="操作" width="300">
					<template slot-scope="scope">
						<el-button type="danger" @click="addGoodsSubmit(scope.$index, scope.row) ">提交</el-button>
					</template>
				</el-table-column>
			</el-table>


			<el-pagination @size-change="handleSizeChange2" @current-change="handlePageChange2" :current-page="PageInfo.pageNum"
			 :page-sizes="[3, 6, 9, 12]" :page-size="PageInfo2.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="PageInfo2.total">
			</el-pagination>
			<div slot="footer" class="dialog-footer">
				<el-button @click="TowaddFormVisible = false ">取 消</el-button>
				<el-button type="danger" @click="sureSubmit()">确 定</el-button>

			</div>
		</el-dialog>

		<el-pagination @size-change="handleSizeChange" @current-change="handlePageChange" :current-page="PageInfo.pageNum"
		 :page-sizes="[3, 6, 9, 12]" :page-size="PageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="PageInfo.total">
		</el-pagination>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				testData: undefined,
				testData1: undefined,
				formLabelWidth: "180px",
				selectFormVisible: false,
				updateFormVisible: false,
				trackingFormVisible: false,
				giftFormVisible: false,
				TowaddFormVisible: false,
				giftForm: [],
				TwotableData: [],
				trackingForm: [],
				trackingForeData: [],
				selectform: {},
				selectForm: {},
				updateForm: {},
				brands: [],
				clors: [],
				types: [],
				tableData: [],
				auditData: {},
				reviewstatus: [],
				PageInfo: {
					pageNum: 1,
					pageSize: 3,
					total: 100
				},
				PageInfo2: {
					pageNum: 1,
					pageSize: 6,
					total: 10
				},
			}
		},
		methods: {
			giftReviews(cellValue) {
			    console.log(11111111111111);
			    //debugger
			    if (cellValue.giftReviewstatus == 1) {
			     cellValue.operate = true;
			     return "已审核";
			    } else if (cellValue.giftReviewstatus == 0) {
			     cellValue.operate=false;
			     return "未审核";
			    } else if (cellValue.giftReviewstatus == 2) {
			     cellValue.operate=false;
			     return "审核未通过";
			    } else if (cellValue.giftReviewstatus == 3) {
			     cellValue.operate=false;
			     return "无效";
			    }
			   },
			handleCurrentChange(val) {
				this.currentRow = val;
				//this.TwotableData = val;
				//console.log("basePurchasingMode===>"+val.basePurchasingMode);
			},


			handleSizeChange(val) { //pageSzie发生变化
				this.PageInfo.pageNum = 1;
				this.PageInfo.pageSize = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},


			//模态框分页
			handleSizeChange2(val) { //pageSzie发生变化

				this.PageInfo2.pageNum = 1;
				this.PageInfo2.pageSize = val;
				let myparam = this.$qs.stringify(this.PageInfo2);
				this.goodsForm(myparam);
				this.adddata();
			},

			handlePageChange(val) { //翻页

				this.PageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},

			//模态框分页
			handlePageChange2(val) { //翻页

				this.PageInfo2.pageNum = val;
				let myparam = this.$qs.stringify(this.PageInfo2);
				this.goodsForm(myparam);
				this.adddata();
			},

			//查询方法
			querydata() {
				let a = { ...this.PageInfo,
					...this.selectform
				};
				//let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				this.myquer(this.$qs.stringify(a));
			},

			//查看审核详情的按钮
			sureSubmit() {
				this.selectFormVisible = false;
				this.TowaddFormVisible = false;

			},

			//获取商品数据
			goodsForm(param) {
				this.TowaddFormVisible = true;
				this.addFormVisible = false;
				this.$axios.get("goodsManager/list/goodsLevel?" + param)
					.then(resp => {
						this.TwotableData = resp.data.list;
						console.log(resp.data.list.basePurchasingMode);

						this.PageInfo2.pageNum = resp.data.pageNum;
						this.PageInfo2.pageSize = resp.data.pageSize;
						this.PageInfo2.total = resp.data.total;
					}).catch(err => {
						console.log(err);
					})

			},

			adddata() {
				this.giftFormVisible = true;
				this.$axios.get("gift/list?giftReviewstatus=0")
					.then(resp => {
						console.log(resp);
						this.giftForm = resp.data.list;

					})
					.catch(err => {
						console.log(err);
					})
			},

			//添加商品转赠品
			addGoodsSubmit(index, row) {
				// String verifyTableId = (String) map.get("verifyTableId");
				//Integer verifyId = (Integer) map.get("verifyId");
				//Integer verifyStatus = (Integer) map.get("verifyStatus");
				this.giftFormVisible = false;

				this.currentRow.giftNumber = this.testData;
				this.currentRow.tianyiPrice = this.testData1;
				this.currentRow.purchasingDepartment = this.currentRow.basePurchasingMode;
				this.currentRow.purchasingPrice = this.currentRow.procurementRmb;
				this.currentRow.giftReviewstatus = 0;

				this.auditData.verifyTable = "goods_gift";
				this.auditData.verifyTableId = "";
				this.auditData.verifyId = 1000;
				this.auditData.verifyStatus = 0;
				
				let data = Object.assign(this.auditData, this.currentRow);
					
				this.$axios.post("ver/adds", data)
					.then(resp => {
						console.log(this.giftForm.id);
						if (resp.code == 20000) {
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error("库存不足，提交失败!")
						}
						//刷新列表
						let a = { ...this.PageInfo,
							...this.selectform
						};
						this.testData = "";
						this.testData1 = "";
						//let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
						this.myquer(this.$qs.stringify(a));
					})

			},
		

			//查看按钮
			handleSelect(index, row) {
				this.selectFormVisible = true;
				this.selectForm = row;

			},


			//获取修改表单数据
			handleUpdate(index, row) {
				this.updateFormVisible = true;
				this.updateForm = row;

			},
			//修改数据
			updateSubmit(index,row) {
				this.updateFormVisible = false;

				this.auditData.verifyTable = "goods_gift";
				this.auditData.verifyTableId = this.currentRow.goodsId+"";
				this.auditData.verifyId = 2000;
				this.auditData.verifyStatus = 0;
				
				this.currentRow.giftReviewstatus = 0;
				// debugger
				let data = Object.assign(this.auditData, this.currentRow);
				this.$axios.post("ver/adds", data)
					.then(resp => {
						if (resp.code == 20000) {
							this.$message({
								showClose: true,
								message: resp.msg,
								type: 'success'
							});
						} else if (resp.code == 50000) {
							this.$message.error(resp.msg)
						}
						//删除之后再查询
						let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
						this.myquer(myparam);
					})
			},
			//修改数据
			// updateSubmit() {
			// 	this.updateFormVisible = false;

			// 	this.$axios.put("goodsGift/updates/goods", this.currentRow)
			// 		.then(resp => {
			// 			if (resp.code == 20000) {
			// 				this.$message({
			// 					showClose: true,
			// 					message: resp.msg,
			// 					type: 'success'
			// 				});
			// 			} else if (resp.code == 50000) {
			// 				this.$message.error(resp.msg)
			// 			}
			// 			//删除之后再查询
			// 			let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
			// 			this.myquer(myparam);
			// 		})
			// },



			//删除数据，属于假删除
			handleDelete(index, row) {
				//跳出删除框
				this.$confirm('此操作将永久删除该数据，请问是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					//发删除请求
					this.$axios.put("goodsGift", this.currentRow)
						.then(resp => {
							console.log("id===>" + this.currentRow.id);
							//给用户提示
							//给用户提示
							if (resp.code == 20000) {
								this.$message({
									showClose: true,
									message: resp.msg,
									type: 'success'
								});
							} else if (resp.code == 50000) {
								this.$message.error(resp.msg)
							}

							//删除之后再查询
							let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
							this.myquer(myparam);



						}).catch(err => {})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});

			},

			//审核跟踪
			audit(index, row) {
				this.trackingFormVisible = true;
				this.trackingForm = row;
				//this.trackingForeData = row;
				this.$axios.get("goodsGift/list?goodsId=" + row.goodsId)
					.then(resp => {
						console.log(resp);
						this.trackingForeData = resp.data.list;

						// debugger;
					})
					.catch(err => {
						console.log(err);
					})


			},



			//查询所有或条件查询
			myquer(param) { //初始化页面
				this.$axios.get("goodsGift/list?" + param)
					.then(resp => {

						this.tableData = resp.data.list;
						//this.trackingForeData = resp.data.list;
						this.PageInfo.pageNum = resp.data.pageNum;
						this.PageInfo.pageSize = resp.data.pageSize;
						this.PageInfo.total = resp.data.total;
					}).catch(err => {
						console.log(err);
					})
			},


			//重置按钮
			myreset(fromname) {
				this.$refs['selectform'].resetFields(); //model需要有ref，和对应的prop属性
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam); //重置输入框内容后进行页面刷新
			},






			//赠品类型下拉框
			gettype() {
				this.$axios.get("goodsGift/selectType/goods_type")
					.then(resp => {
						this.types = resp.data;
					})
					.catch(err => {
						console.log(err);
					})
			},

			//审核状态
			getreviewstatus(param) {
				this.$axios.get("goodsGift/reviewstatus?" + param)
					.then(resp => {
						console.log("reviewstatus" + resp);
						this.reviewstatus = resp.data.list;
						console.log("this.reviewstatus----" + this.reviewstatus)
					})
					.catch(err => {
						console.log(err);
					})
			},


		},

		mounted() { //钩子函数，进行页面初始化
			this.myquer();
			//this.goodsForm("");
			// this.getclor("");
			this.gettype();
			this.getreviewstatus("");
		},

	}
</script>

<style>
</style>
