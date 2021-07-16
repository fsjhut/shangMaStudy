<template>
	<div>
		<el-dialog width="70%" title="选择商品" :visible.sync="innerVisible" append-to-body>
			
			<!-- 搜索块 -->
			<el-form :inline="true" :model="goodQueryParams" class="demo-form-inline">
				
				<el-form-item label="颜色" :inline="true" >
				  <el-select v-model="goodQueryParams.goodsColor" placeholder="颜色">
				    <el-option
				      v-for="item in goodDatas.goodsColor"
				      :key="item.value"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				  </el-select>
				</el-form-item>
				<el-form-item label="品牌" :inline="true">
				  <el-select v-model="goodQueryParams.goodsBrand" placeholder="品牌">
				    <el-option
				      v-for="item in goodDatas.goodsBrand"
				      :key="item.value"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				  </el-select>
				</el-form-item>
				<el-form-item label="分类">
				  <el-select v-model="goodQueryParams.goodsType" placeholder="商品分类">
				    <el-option
				      v-for="item in goodDatas.goodsType"
				      :key="item.value"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				  </el-select>
				</el-form-item>
				
								<br />
				<el-form-item label="名称" :inline="true">
					<el-input v-model="goodQueryParams.goodsName" placeholder="名称"></el-input>
				</el-form-item>
				<el-form-item label="型号">
					<el-input v-model="goodQueryParams.goodsModel" placeholder="型号"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="goodQueryBut">查询</el-button>
					<el-button @click="restGoodQueryBut">重置</el-button>
				</el-form-item>
			</el-form>
			
			<el-table :data="goodsDatas" height="500" border style="width: 100%" @current-change="choiseGood">
				<el-table-column label="序号" type="index" align="center" show-overflow-tooltip width="50px">
				</el-table-column>
				<el-table-column prop="goodsName" width="150px" label="名称">
				</el-table-column>
				<el-table-column prop="goodsType" label="类型">
				</el-table-column>
				<el-table-column prop="marketRmb" label="单价">
				</el-table-column>
				<el-table-column prop="goodsBrand" label="品牌">
				</el-table-column>
				<el-table-column prop="goodsModel" label="型号">
				</el-table-column>
				<el-table-column prop="inventoryNumber" label="库存">
				</el-table-column>
				<el-table-column prop="goodsColor" label="颜色">
				</el-table-column>

				<el-table-column v-if="false" prop="goodsId" label="ID">
				</el-table-column>

			</el-table>
			<!-- 页码块 -->
			<el-pagination @size-change="goodSizeChange" @current-change="goodPageChange"
				:current-page="goodDefaultPage" :page-sizes="[5, 10, 20]" :page-size="5"
				layout="total, sizes, prev, pager, next, jumper" :total="goodParams.total">
			</el-pagination>
			<span slot="footer" class="dialog-footer">
				<el-button @click="innerVisible = false">取 消</el-button>
				<el-button type="primary" @click="innerVisible = false,goodEnsure()">选 择</el-button>
			</span>
		</el-dialog>


		<!-- 价格修改页面+审核页面+修改页面+审核跟踪 -->
		<el-dialog title="商品调价申请添加" :visible.sync="openAdd" center>
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">商品ID</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="商品ID" v-model="priceAdjustData.goodId" :readonly="true"></el-input>
					</div>
				</el-col>
				<el-col :span="9">
					<div class="grid-content bg-purple">
						<el-button type="primary" v-show="digChoiseGood" @click="innerVisible = true,choiseGoods()">
							选择商品</el-button>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">商品名称</div>
				</el-col>
				<el-col :span="12">
					<div class="grid-content bg-purple">
						<el-input placeholder="商品名称" :readonly="true" v-model="priceAdjustData.goodsName"></el-input>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">商品库存</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="商品库存" :readonly="true" v-model="priceAdjustData.inventoryNumber">
						</el-input>
					</div>
				</el-col>

			</el-row>

			<br />


			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">商品价格</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="原始价格" :readonly="true" v-model="priceAdjustData.originalPrice">
						</el-input>
					</div>
				</el-col>

				<el-col :span="6">
					<!--  style="width: 200px;"-->

					<el-select v-model="what" :inline="true" v-show="ban2" placeholder="计算方式" @change="CalculationType">
						<el-option label="" style="display: none;" value=""></el-option>
						<el-option label="绝对值" value="2"></el-option>
						<el-option label="百分比" value="1"></el-option>
						<el-option label="" value="" hidden="false"></el-option>
					</el-select>
				</el-col>

				<el-col :span="8" :hidden="percent">
					<div class="grid-content bg-purple">
						<el-slider v-model="value2" @change="percentChange"></el-slider>
					</div>
				</el-col>

			</el-row>




			<!-- 			<el-row :gutter="20" :hidden="percent">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">折扣幅度</div>
				</el-col>
				<el-col :span="8">
					<div class="grid-content bg-purple">
						<el-slider v-model="value2"></el-slider>
					</div>
				</el-col>
				
			</el-row> -->




			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">调整价格</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-input placeholder="调整价格" :readonly="disAdjust" v-model="priceAdjustData.currentPrice">
						</el-input>
					</div>
				</el-col>
			</el-row>



			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">生效时间</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-date-picker v-model="priceAdjustData.startTime" :readonly="ban1" type="datetime"
							placeholder="生效时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
						</el-date-picker>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">失效时间</div>
				</el-col>
				<el-col :span="6">
					<div class="grid-content bg-purple">
						<el-date-picker v-model="priceAdjustData.endTime" :readonly="ban1" type="datetime"
							placeholder="失效时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
						</el-date-picker>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">调价原因</div>
				</el-col>
				<el-col :span="15">
					<div class="grid-content bg-purple">
						<el-input type="textarea" placeholder="调价原因" :readonly="ban1"
							v-model="priceAdjustData.adjustAccount" maxlength="200" show-word-limit>
						</el-input>
					</div>
				</el-col>

			</el-row>
			<br />
			<el-row :gutter="20">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">备注</div>
				</el-col>
				<el-col :span="15">
					<div class="grid-content bg-purple">
						<el-input type="textarea" placeholder="备注" :readonly="ban1" v-model="priceAdjustData.remark"
							maxlength="200" show-word-limit>
						</el-input>
					</div>
				</el-col>

			</el-row>
			<br />
			<!-- 审核意见： -->
			<el-row :gutter="20" v-show="auditHidden">
				<el-col :span="3">
					<div class="grid-content bg-purple" style="float: right;">审核意见</div>
				</el-col>
				<el-col :span="15">
					<div class="grid-content bg-purple">
						<el-input type="textarea" placeholder="审核意见" maxlength="200" show-word-limit
							v-model="auditIdeas">
						</el-input>
					</div>
				</el-col>

			</el-row>
			<br />

			<!-- 审核记录 -->
			<el-table ref="singleTable" :hidden="auditRecord" :data="auditDatas" border highlight-current-row
				@current-change="choiseTable" style="width: 100%">

				<el-table-column label="序号" type="index" align="center" show-overflow-tooltip width="50px">
				</el-table-column>

				<el-table-column prop="verifyPerson" label="审批人" align="center">
				</el-table-column>
				<el-table-column prop="verifyTime" label="审批时间" align="center">
				</el-table-column>

				<el-table-column prop="verifySuggestion" label="审批意见" align="center">
				</el-table-column>
				<el-table-column prop="checkStatus" label="审批状态" align="center">

					<template v-slot="scope">
						<span v-if="scope.row.verifyStatus==0">待审核</span>
						<span v-if="scope.row.verifyStatus==1">审核通过</span>
						<span v-if="scope.row.verifyStatus==2">已驳回</span>
					</template>

				</el-table-column>
			</el-table>



			<span slot="footer" class="dialog-footer">
				<el-button v-show="auditHidden" @click="openAdd = false,pass()">通 过</el-button>
				<el-button v-show="auditHidden" @click="openAdd = false,rebut()">驳 回</el-button>
				<el-button @click="openAdd = false">取 消</el-button>
				<el-button v-show="digEnsure" type="primary" @click="openAdd = false,addGoodPriceAdjust()">确 定
				</el-button>
				<el-button v-show="updateSubmit" type="primary" @click="openAdd = false,updateSubmitBut()">修改提交
				</el-button>
				<el-button v-show="draftshow" type="primary" @click="openAdd = false,draft()">保存草稿</el-button>
			</span>
		</el-dialog>



		<!-- 搜索块 -->
		<el-form :inline="true" :model="queryParams" class="demo-form-inline">

			<el-form-item>
				<el-button type="primary" @click="qyeryData">查询</el-button>
				<el-button @click="resetQuery">重置</el-button>
				<el-button type="button" @click="openAdd = true,addApply()">新增价格申请</el-button>
				<el-button type="button" :disabled="updateButton2" @click="openAdd = true,updateApply()">修改申请
				</el-button>
				<el-button type="button" :disabled="updateButton" @click="openAdd = true,viewDetails()">查看详情</el-button>
				<!-- <el-button type="button" @click="history= true">历史记录</el-button> -->
				<el-button type="button" :disabled="updateButton" v-show="deDraft" @click="removeData">删除</el-button>
				<!-- <el-button type="button" @click="setRole = true , getRole()" :readonly="update">授权</el-button> -->
			</el-form-item>
			<br />

			<el-form-item label="商品名称">
				<el-input v-model="queryParams.goodsName" placeholder="商品名称"></el-input>
			</el-form-item>

			<el-form-item label="审核状态">
				<el-select v-model="queryParams.checkStatus" :inline="true" style="width: 200px;" placeholder="审核状态">
					<el-option label="" style="display: none;" value=""></el-option>
					<el-option label="待审核" value="0"></el-option>
					<el-option label="审核通过" value="1"></el-option>
					<el-option label="已驳回" value="2"></el-option>
					<el-option label="草稿" value="3"></el-option>
					<el-option label="已过期" value="4"></el-option>
				</el-select>
			</el-form-item>

			<el-form-item label="起始时间">
				<el-date-picker v-model="queryParams.startTime" type="datetime" placeholder="请选择起始时间"
					value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm"></el-date-picker>
			</el-form-item>

			<el-form-item label="截止时间">
				<el-date-picker v-model="queryParams.endTime" type="datetime" placeholder="请选择截止时间"
					value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm"></el-date-picker>
			</el-form-item>


		</el-form>


		<el-table @current-change="choiseTable" :data="priceAdjustDatas" style="width: 100%">
			<el-table-column type="expand">
				<template slot-scope="props">
					<el-form label-position="left" inline class="demo-table-expand">

						<el-form-item label="商品 ID">
							<span>{{ props.row.goodId }}</span>
						</el-form-item>

						<el-form-item label="商品名称">
							<span>{{ props.row.goodsName }}</span>
						</el-form-item>

						<el-form-item label="商品库存">
							<span>{{ props.row.inventoryNumber }}</span>
						</el-form-item>

						<el-form-item label="原价格">
							<span>{{ props.row.originalPrice }}</span>
						</el-form-item>

						<el-form-item label="调整后价格">
							<span>{{ props.row.currentPrice }}</span>
						</el-form-item>

						<el-form-item label="生效时间">
							<span>{{ props.row.startTime }}</span>
						</el-form-item>

						<el-form-item label="失效时间">
							<span>{{ props.row.endTime }}</span>
						</el-form-item>
						<el-form-item label="调整原因">
							<span>{{ props.row.adjustAccount }}</span>
						</el-form-item>
						<el-form-item label="备注">
							<span>{{ props.row.remark }}</span>
						</el-form-item>
					</el-form>
				</template>
			</el-table-column>

			<el-table-column label="序号" type="index" align="center" show-overflow-tooltip width="50px">
			</el-table-column>

			<el-table-column label="商品名称" prop="goodsName">
			</el-table-column>
			<el-table-column label="原价" prop="originalPrice">
			</el-table-column>
			<el-table-column label="调整价" prop="currentPrice">
			</el-table-column>
			<el-table-column label="生效时间" prop="startTime">
			</el-table-column>
			<el-table-column prop="checkStatus" label="审批状态" align="center">
				<template v-slot="scope">
					<span v-if="scope.row.checkStatus==0">待审核</span>
					<span v-if="scope.row.checkStatus==1">通过</span>
					<span v-if="scope.row.checkStatus==2">已驳回</span>
					<span v-if="scope.row.checkStatus==3">草稿</span>
					<span v-if="scope.row.checkStatus==4">已过期</span>
					<span v-if="scope.row.checkStatus==5">待高级审核</span>
				</template>
			</el-table-column>

			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button :disabled="scope.row.checkStatus==3 
					  || scope.row.checkStatus==4 
					  || rank==0 
					  || scope.row.checkStatus==1 
					  || scope.row.checkStatus==2
					  || (scope.row.checkStatus==5 && rank==1)
					  " size="mini" @click="handleAudit(scope.$index, scope.row)">审核
					</el-button>
<!-- || (scope.row.checkStatus==0 && rank==2) -->

					<el-button :disabled="scope.row.checkStatus==3" size="mini" type="success"
						@click="handleAuditTrack(scope.$index, scope.row)">审核跟踪</el-button>
				</template>
			</el-table-column>

		</el-table>

		<!-- 页码块 -->
		<el-pagination @size-change="sizeChange" @current-change="pageChange" :current-page="defaultPage"
			:page-sizes="[5, 10, 20]" :page-size="5" layout="total, sizes, prev, pager, next, jumper"
			:total="params.total">
		</el-pagination>

	</div>



</template>

<script>
	export default {

		data() {
			return {
				// 商品选择模块相关参数
				goodDatas:[],
				goodQueryParams: {
					pageSize: 5,
					pageNum: 1,
					goodsName: undefined,
					goodsModel: undefined,
					goodsColor: undefined,
					goodsBrand: undefined
				},
				goodsDatas: [],
				choiseGoodData: {},
				goodDefaultPage: 1,
				goodParams: {
					total: 0,
					pageSize: 5,
				},
				value2: 100,
				updateButton2: true,
				AuditLogging: {},
				// 临时数据
				temp: {},


				// 公用调价数据
				priceAdjustData: {},
				percent: true,
				disAdjust: false,
				priceAdjustDataUpdate: {},
				digChoiseGood: false,
				updateButton: true,
				digStatus: undefined,
				ban1: false,
				ban2: false,
				what: '',
				auditDatas: [],
				dishandleAudit: false,
				rank: 1,
				auditIdea: true,
				digEnsure: true,
				draftshow: false,
				// true时展示审核相关标签
				auditHidden: false,
				// 主模块相关参数
				priceAdjustDatas: [],
				queryParams: {
					pageSize: 5,
					pageNum: 1,
					goodsName: undefined,
					startTime: undefined,
					endTime: undefined,
					checkStatus: undefined
				},
				defaultPage: 1,
				params: {
					total: 0,
					pageSize: 5,
				},
				openAdd: false,
				history: false,
				outerVisible: false,
				innerVisible: false,
				textarea: "",
				auditRecord: true,
				// 审核参数
				auditQueryData: {
					verifyTable: "",
					verifyTableId: 0
				},
				auditIdeas: "",
				update: {},
				deDraft: false,
				updateSubmit: false,




			}
		},
		methods: {
			// 查询
			getAdjustList(query) {
				this.$axios.get("goodsPriceAdjustment/list?" + query)
					.then(resp => {
						console.log("这是获取的list数据：")
						console.log(resp)
						this.priceAdjustDatas = resp.data.list;
						this.params.total = resp.data.total;
						this.params.pageSize = resp.data.pageSize;

					}).catch(err => {
						console.log(err);
					})
			},
			// 当前条件刷新页面
			flushPage() {
				console.log(this.queryParams);
				this.getAdjustList(this.$qs.stringify(this.queryParams));
				if (this.queryParams.checkStatus == 3) {
					this.deDraft = true;
				} else {
					this.deDraft = false;
				}
			},
			// 本页面选中当前行
			choiseTable(val) {

				if (val != null) {
					console.log("选中行数据：");
					console.log(val);
					this.priceAdjustDataUpdate = val;
					this.updateButton = false;

					if (val.checkStatus == 2 || val.checkStatus == 3) {
						this.updateButton2 = false;
					}
					if (val.checkStatus != 2 && val.checkStatus != 3) {
						this.updateButton2 = true;
					}
				} else {
					this.updateButton = true;
					this.updateButton2 = true;
				}
			},
			sizeChange(val) {
				this.params.pagesize = val;
				this.queryParams.pageSize = val;
				this.queryParams.pageNum = 1;
				this.flushPage();
				this.defaultPage = 1;
			},
			pageChange(val) {
				this.updateButton = true;
				this.defaultPage = val;
				this.queryParams.pageNum = val;
				this.flushPage();
			},
			// 查询按钮
			qyeryData() {
				this.flushPage();
			},
			// 删除按钮
			removeData() {
				let id = this.priceAdjustDataUpdate.priceAdjustmentId;
				console.log(id);
				this.$axios.delete("goodsPriceAdjustment/" + id)
					.then(resp => {
						console.log(resp);
						if (resp.code == 20000) {
							this.$message.success("删除成功！")
							this.flushPage();
						} else {
							this.$message.error("删除失败！")
						}
					}).catch(err => {
						this.$message.error("删除失败！")
						console.log(err)
					})
			},
			// 初始化参数，初始化查询
			resetQuery() {
				this.queryParams = {};
				this.flushPage();
			},
			// 二级模态框商品相关函数
			// 点击选择商品按钮打开二级模态框
			choiseGoods() {
				this.queryGoods(this.$qs.stringify(this.goodQueryParams));
				// goodsColor: undefined,
				// goodsBrand: undefined
				// goodDatas.goodsType"
				this.$axios.get("goodsPriceAdjustment/type")
				.then(resp=>{
					let test = resp.data;
					this.goodDatas.goodsType=test[0];
					this.goodDatas.goodsColor=test[1];
					this.goodDatas.goodsBrand=test[2];
					console.log(test);
				}).catch(err=>{
					console.log(err);
				})
			},
			// 二级模态框查询商品函数
			queryGoods(query) {
				this.$axios.get("goodsManager/list?" + query)
					.then(resp => {
						console.log(resp);
						this.goodsDatas = resp.data.list;
						this.goodParams.total = resp.data.total;
						console.log(this.goodsDatas);
					}).catch(err => {
						console.log(err);
					})
			},
			goodQueryBut(){
				this.queryGoods(this.$qs.stringify(this.goodQueryParams));
			},
			restGoodQueryBut(){
				this.goodQueryParams={};
				this.queryGoods(this.$qs.stringify(this.goodQueryParams));
			},
			// 选中商品table行
			choiseGood(val) {
				if (val != null) {
					console.log(val);
					this.choiseGoodData = val;
				}
			},
			goodSizeChange() {
				this.goodParams.pagesize = val;
				this.goodQueryParams.pageSize = val;
				this.goodQueryParams.pageNum = 1;
				this.choiseGoods();
				this.goodDefaultPage = 1;
			},
			goodPageChange(val) {
				this.goodDefaultPage = val;
				this.goodQueryParams.pageNum = val;
				this.choiseGoods();
			},
			// 选中商品，返回一级模态框，一级模态框表单赋值
			goodEnsure() {
				console.log(this.choiseGoodData);
				this.priceAdjustData.goodId = this.choiseGoodData.goodsId;
				this.priceAdjustData.goodsName = this.choiseGoodData.goodsName;
				this.priceAdjustData.inventoryNumber = this.choiseGoodData.inventoryNumber;
				this.priceAdjustData.originalPrice = this.choiseGoodData.marketRmb;
				this.priceAdjustData.currentPrice = this.priceAdjustData.originalPrice;
			},
			// 根据计算方式，是都隐藏托拉条
			CalculationType(val) {
				console.log("计算方式：" + val);
				if (val == 1) {
					this.percent = false;
					this.disAdjust = true;
					// percent:true,
					// disAdjust:false,

				} else {
					this.percent = true;
					this.disAdjust = false;
				}
			},
			// 百分比计算价格函数
			percentChange(val) {
				console.log(val);
				this.priceAdjustData.currentPrice = this.priceAdjustData.originalPrice * (val / 100);
				//  强制刷新
				this.$forceUpdate();
			},
			//  草稿：修改并提交
			updateSubmitBut() {
				//  修改
				this.priceAdjustDataUpdate.checkStatus = 0;

				this.AuditLogging.verifyTime = "";
				this.AuditLogging.verifyId = 2000;
				this.AuditLogging.applicant = this.priceAdjustDataUpdate.createBy;
				this.AuditLogging.verifyTableId = this.priceAdjustDataUpdate.priceAdjustmentId+'';
				this.AuditLogging.verifyPerson = "";
				this.AuditLogging.verifyStatus = this.priceAdjustDataUpdate.checkStatus;
				this.AuditLogging.verifySuggestion = "修改提交";
				this.AuditLogging.verifyTable = "goods_price_adjustment";
				let data = Object.assign(this.AuditLogging, this.priceAdjustData);
				this.saveAuditLoggin(data);

			},
			//  添加审核记录：保存、通过、驳回的函数this.AuditLogging
			saveAuditLoggin(data) {
				console.log("进入审核记录的添加函数！")
				this.$axios.post("ver/adds", data)
					.then(resp => {
						if (resp.code == 20000) {
							this.$message.success("添加审核记录成功！")
							this.flushPage();
						} else {
							this.$message.error("添加审核记录失败！")
						}
					}).catch(err => {
						console.log("这是失败新增审核记录：");
						console.log(err);
					})
			},
			// 		this.temp=resp.data;
			// 		this.AuditLogging.verifyTime=this.temp.createTime;
			// 		this.AuditLogging.verifyId=1000;
			// 		this.AuditLogging.applicant="";
			// 		this.AuditLogging.verifyTableId=this.temp.priceAdjustmentId;
			// 		this.AuditLogging.verifyPerson="";
			// 		this.AuditLogging.verifyStatus=this.temp.checkStatus;
			// 		this.AuditLogging.verifySuggestion="";
			// 		this.AuditLogging.verifyTable="goods_price_adjustment";
			// 		this.saveAuditLoggin();
			//  复用确定按钮：价格申请新增、修改确定
			addGoodPriceAdjust() {
				// 新增价格申请确定
				if (this.digStatus == 1 && this.priceAdjustData.checkStatus != 3) {
					this.priceAdjustData.checkStatus = 0;
					if (this.rank == 2) {
						this.priceAdjustData.checkStatus = 1;
					}else if (this.rank == 1){
						this.priceAdjustData.checkStatus = 5;
					}
					console.log(this.priceAdjustData);
					this.AuditLogging.verifyTime = "";
					this.AuditLogging.verifyId = 1000;
					this.AuditLogging.applicant = "";
					this.AuditLogging.verifyTableId = "";
					this.AuditLogging.verifyPerson = "";
					this.AuditLogging.verifyStatus = this.priceAdjustData.checkStatus;
					this.AuditLogging.verifySuggestion = "新增";
					this.AuditLogging.verifyTable = "goods_price_adjustment";

					let data = Object.assign(this.AuditLogging, this.priceAdjustData);
					this.saveAuditLoggin(data);

				} //  修改价格申请内容
				else if (this.digStatus == 2 && this.priceAdjustData.checkStatus != 3) {
					this.updateButton = true;
					this.$axios.put("goodsPriceAdjustment", this.update)
						.then(resp => {
							if (resp.code == 20000) {
								this.$message.success("修改成功");
								this.flushPage();
							} else {
								this.$message.error("修改失败");
							}
							console.log(resp);
						}).catch(err => {
							console.log(err);
						})
				} else if (this.priceAdjustData.checkStatus == 3) {

					this.update = JSON.parse(JSON.stringify(this.priceAdjustDataUpdate));
					this.update.checkStatus = 3;
					this.$axios.put("goodsPriceAdjustment", this.update)
						.then(resp => {
							if (resp.code == 20000) {
								this.$message.success("修改草稿成功");
								this.flushPage();
							} else {
								this.$message.error("修改草稿失败");
							}
							console.log(resp);
						}).catch(err => {
							console.log(err);
						})

				}

			},
			// 模态框数据清理函数
			dataClean() {
				this.priceAdjustData = {};
				this.what = '';
				this.percent = true;
			},
			// 打开修改模态框
			updateApply() {
				this.updateSubmit = true;
				this.draftshow = false;
				this.dataClean();
				this.priceAdjustData = this.priceAdjustDataUpdate;
				this.ban2 = true;
				this.digEnsure = true;
				this.auditRecord = true;
				this.auditHidden = false;
				this.ban1 = false;
				this.digStatus = 2;
				this.digChoiseGood = false;
				this.update = JSON.parse(JSON.stringify(this.priceAdjustDataUpdate));

				if (this.update.checkStatus = 2) {
					this.update.checkStatus = 0;
				} else {
					this.update.checkStatus = 3;
				}
				console.log("这是修改的数据：");
				console.log(this.update);
			},
			//  打开新增价格申请
			addApply() {
				this.updateSubmit = false;
				this.draftshow = true;
				this.ban2 = true;
				this.digEnsure = true;
				this.auditRecord = true;
				this.auditHidden = false;

				this.ban1 = false;
				this.digStatus = 1;
				this.digChoiseGood = true;
				this.dataClean();
			},
			//  打开查看详情
			viewDetails() {
				this.updateSubmit = false;
				this.digChoiseGood = false;
				this.dataClean();
				this.draftshow = false;
				this.ban2 = false;
				this.digEnsure = false;
				this.auditRecord = true;
				this.auditHidden = false;

				this.percent = true;
				this.priceAdjustData = this.priceAdjustDataUpdate;
				this.ban1 = true;
				this.disAdjust = true;
			},
			//  table内审核按钮
			handleAudit(index, row) {
				this.dataClean();
				this.priceAdjustData = row;
				this.ban2 = false;
				this.digEnsure = false;
				this.ban1 = true;
				this.percent = true;
				this.openAdd = true;
				this.disAdjust = true;
				this.auditIdea = false;
				this.auditHidden = true;
				this.auditRecord = true;
				this.digChoiseGood = false;


				// this.digStatus=3;
			},
			//  table内审核记录跟踪按钮
			handleAuditTrack(index, row) {
				this.dataClean();
				this.draftshow = false;
				this.priceAdjustData = row;
				this.ban2 = false;
				this.digEnsure = false;
				this.auditRecord = false;
				this.openAdd = true;
				this.auditHidden = false;
				this.digChoiseGood = false;
				this.disAdjust = true;
				this.ban1 = true;
				this.auditQueryData.verifyTable = "goods_price_adjustment";
				this.auditQueryData.verifyTableId = row.priceAdjustmentId;

				this.$axios.get("ver/list?" + this.$qs.stringify(this.auditQueryData))
					.then(resp => {
						console.log(resp);
						console.log(11111);
						console.log(resp.data);
						this.auditDatas = resp.data;
					}).catch(err => {
						console.log(err);
					})


			},
			//  保存草稿按钮
			draft() {
				console.log("保存草稿操作！")
				this.priceAdjustData.checkStatus = 3;
				this.$axios.post("goodsPriceAdjustment", this.priceAdjustData)
					.then((resp) => {
						console.log("保存数据：")
						if (resp.code == 20000) {
							this.flushPage();
							this.$message.success("保存草稿成功！")
						} else {
							this.$message.error("保存草稿失败！")
						}
					}).catch(err => {
						this.$message.error("保存草稿失败！")
					})

			},
			// 审核通过
			pass() {
				//  修改本表
				// let data={};
				// data.priceAdjustmentId=this.priceAdjustDataUpdate.priceAdjustmentId;
				if (this.rank == 1) {
					this.priceAdjustDataUpdate.checkStatus = 5;
				} else if(this.rank == 2) {
					this.priceAdjustDataUpdate.checkStatus = 1;
				}
				this.priceAdjustDataUpdate.auditIdeas = this.auditIdeas;

				this.AuditLogging.verifyId = 2000;
				this.AuditLogging.applicant = this.priceAdjustDataUpdate.createBy;
				this.AuditLogging.verifyTableId = this.priceAdjustDataUpdate.priceAdjustmentId+"";
				this.AuditLogging.verifyPerson = "待审核";
				this.AuditLogging.verifyStatus = this.priceAdjustDataUpdate.checkStatus;
				this.AuditLogging.verifySuggestion = this.auditIdeas;
				this.AuditLogging.verifyTable = "goods_price_adjustment";

				let data = Object.assign(this.AuditLogging, this.priceAdjustDataUpdate);
				this.saveAuditLoggin(data);
			},
			// 驳回
			rebut() {
				//  修改本表
				let data = {};
				data.priceAdjustmentId = this.priceAdjustDataUpdate.priceAdjustmentId;
				data.checkStatus = 2;
				this.priceAdjustDataUpdate.checkStatus=2;
				data.auditIdeas = this.auditIdeas;
				this.AuditLogging.verifyId = 2000;
				this.AuditLogging.applicant = this.priceAdjustDataUpdate.createBy;
				this.AuditLogging.verifyTableId = data.priceAdjustmentId+'';
				// this.AuditLogging.verifyPerson = "待审核";
				this.AuditLogging.verifyStatus = data.checkStatus;
				this.AuditLogging.verifySuggestion = this.auditIdeas;
				this.AuditLogging.verifyTable = "goods_price_adjustment";
				let dataa = Object.assign(this.AuditLogging, this.priceAdjustDataUpdate);
				this.saveAuditLoggin(dataa);
			},
			// 获取当前登录用户
			getLoginUser() {
				this.$axios.get("sysuser/loginUser")
					.then(resp => {
						if (resp.code == 20000) {
							this.$message.success("获取当前登录用户成功！")
							console.log(resp);
							this.rank=resp.data;
							// this.rank=0;
							console.log(this.rank);
						} else {
							console.log("登录标记：")
							this.$message.success("获取当前登录用户失败！");
							// this.rank=resp.data;
							// this.rank=2;
						}
					}).catch(err => {

					})
			},
		},
		mounted() {
			this.getAdjustList(this.$qs.stringify(this.queryParams));
			this.getLoginUser();
			this.choiseGoods();
		}
	}
</script>

<style>


	.demo-table-expand {
		font-size: 0;
	}

	.demo-table-expand label {
		width: 90px;
		color: #99a9bf;
	}

	.demo-table-expand .el-form-item {
		margin-right: 0;
		margin-bottom: 0;
		width: 50%;
	}
</style>
