<template>
	<div>
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="活动名称">
				<el-input v-model="queryForm.promoteName" placeholder="活动名称"></el-input>
			</el-form-item>
			<el-form-item label="活动类型">
				<el-select v-model="queryForm.promoteType" clearable placeholder="活动类型">
					<!-- <el-option label="全部"></el-option> -->
					<el-option label="每日限量" value="1"></el-option>
					<el-option label="连续促销" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="审核状态">
				<el-select v-model="queryForm.promoteStatus" clearable placeholder="审核状态">
					<!-- <el-option label="全部" value=""></el-option> -->
					<el-option label="未审核" value="1"></el-option>
					<el-option label="已审核" value="3"></el-option>
					<el-option label="审核未通过" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onQuery">查询</el-button>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onAdd">新增</el-button>
			</el-form-item>
		</el-form>
		<!-- 表格数据 -->
		<el-table ref="selectTableDate"  :data="tableData" style="width: 100%" stripe 
		:default-sort="{prop: 'startTime', order: 'descending'}"
			:cell-style="rowStyle" :header-cell-style="headStyle">
			<el-table-column prop="index" label="序号" width="100">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column prop="promoteName" label="活动名称" width="180">
			</el-table-column>
			<el-table-column prop="startTime" label="活动开始时间" sortable width="180">
			</el-table-column>
			<el-table-column prop="priceStartTime" label="价格生效时间" width="180">
			</el-table-column>
			<el-table-column prop="promoteStatus" label="审核状态" width="180" :formatter="promoteStatus">
			</el-table-column>
			<el-table-column prop="operate" label="操作" width="300">
				<template  slot-scope="scope">
					<el-button type="primary" circle @click="onSelect(scope.row)">查看</el-button>
					<!-- :disabled="scope.row.promoteStatus==1||scope.row.promoteStatus==3" -->
					<el-button type="warning" circle @click="onEdit(scope.row)" 
					:disabled="scope.row.operate">编辑</el-button>
					<el-button type="danger" circle @click="onDelete(scope.row)" 
					:disabled="scope.row.operate">删除</el-button>
					<el-button type="success" @click="onTrack(scope.row)" circle>跟踪</el-button>
					<!--  <el-button type="success" icon="el-icon-check" circle></el-button>
				  <el-button type="info" icon="el-icon-message" circle></el-button>
				  <el-button type="warning" icon="el-icon-star-off" circle></el-button> -->
				</template >
			</el-table-column>
			<!-- <el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleAudit(scope.$index, scope.row)">审核</el-button>


					<el-button size="mini" type="success" @click="handleAuditTrack(scope.$index, scope.row)">审核跟踪
					</el-button>
				</template>
			</el-table-column> -->
		</el-table>

		<!-- 分页插件 -->
<!-- 		<div class="block"> -->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="queryForm.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="queryForm.pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="queryForm.total">
			</el-pagination>
		<!-- 模态框 -->
		<el-dialog title="活动详情" :visible.sync="centerDialogVisible" width="55%" center>
			<el-form ref="promoteSaleDate" :model="promoteSaleDate" label-width="120px">
				<el-row>
					<el-col :span="9">
						<el-form-item label="活动名称">
							<el-input v-model="promoteSaleDate.promoteName" :readonly="inputStatus"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				<el-row>
					<el-col :span="9">
						<el-form-item label="活动开始时间">
							<el-date-picker v-model="promoteSaleDate.startTime" :readonly="inputStatus" 
							type="datetime"
								placeholder="开始时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
							</el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>
				
				
				<el-form-item label="活动结束时间">
					<el-date-picker v-model="promoteSaleDate.endTime" :readonly="inputStatus" type="datetime"
						placeholder="结束时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-row>
					<el-col :span="9">
						<el-form-item label="活动类型">
							<el-select v-model="promoteSaleDate.promoteType" clearable :disabled="inputStatus">
								<el-option v-for="item in activeOption" :key="item.value" :value="item.value"
									:label="item.label"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				
				
				<el-form-item label="活动商品">
					<el-table :data="productDate" stripe style="width: 100%" slot-scope="scope">
						<el-table-column prop="productId" label="id" width="50">
						</el-table-column>
						<el-table-column prop="productName" label="商品名字" width="80">
						</el-table-column>
						<el-table-column prop="productStock" label="库存数量" width="100">
						</el-table-column>
						<el-table-column prop="promoteNum" label="促销数量" width="100">
							<!-- 需要对促销数量进行校验 -->
							<template slot-scope="scope">
								<el-input v-model="scope.row.promoteNum" :disabled="inputStatus"
									:change="confirmPromoteNum(scope.row)">
								</el-input>
							</template>
						</el-table-column>

						<el-table-column prop="marketPrice" label="市场价格" width="100">
						</el-table-column>
						<el-table-column prop="shoppingPrice" label="商场价格" width="100">
						</el-table-column>
						<el-table-column prop="promotePrice" label="促销价格" width="100">
							<template slot-scope="scope">
								<el-input v-model="scope.row.promotePrice" :disabled="inputStatus"></el-input>
							</template>
						</el-table-column>
						<el-table-column prop="percent" label="百分比" width="100">
							<template slot-scope="scope">
								<!-- 				<el-input v-model="percentAdjust" :disabled="inputStatus"
									@change="updatePrice(scope.row)"></el-input><span>%</span> -->
								<div class="block">
									<!-- <span class="demonstration">默认</span> -->
									<el-slider v-model="scope.row.percent" @input="updatePrice(scope.row)"
									:min='0'
									:max='120'
									:disabled="inputStatus">
									</el-slider>
								</div>
							</template>
						</el-table-column>
						<el-table-column prop="deleteProduct" label="删除商品" width="100">	  
							<template slot-scope="scope">
								<el-button icon="el-icon-delete" circle :disabled="inputStatus"
								@click.native.prevent="deleteProduct(scope.$index, productDate)"
								type="danger" >移除
								</el-button>
							</template>
						</el-table-column>
					</el-table>
				</el-form-item>
				<el-form-item label="">
					<el-button type="primary" @click="selectProducts" :disabled="inputStatus">选择商品</el-button>
				</el-form-item>
				
				<el-row>
					<el-col :span="12">
						<el-form-item label="活动情况或原因">
							<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" 
							:disabled="inputStatus"
							v-model="promoteSaleDate.promoteDetail">
							</el-input>
						</el-form-item>
					</el-col>
				</el-row>
				
				<el-form-item label="活动策划文件">
					<el-upload ref="upload" class="form-upload" action="http://127.0.0.1:8080/file/upload"
						accept=".doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf,.7z,.rar,.zip" :limit="1"
						:on-success="handleFileSuccess" :on-error="handleFileError" 
						:on-remove="handleFileRemove" :disabled="isProcess" :file-list="fileList">
						<!-- 通过isProcess控制按钮的文字颜色、背景，通过uploadTxt控制按钮文本 -->
						<el-button :class="{'form-upload-process': isProcess}" size="small" type="primary"
							v-text="uploadTxt" :disabled="inputStatus"></el-button>
					</el-upload>
					<!-- :http-request="uploadSelectFile" -->
					<!-- <el-upload ref="uploadForm" :file-list="fileList" :on-remove="removeFile" multiple :limit="1"
						action="http://127.0.0.1:8080/file/upload/" :on-success="handleFileSuccess"
						:on-error="handleFileError" :on-change="onUploadChange"
						accept=".doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf,.txt,.7z,.rar,.zip" :disabled="inputStatus">
						<el-button size="small" type="primary" slot="trigger">选择文件</el-button>
						
						<! <el-button style="margin-left: 10px;" size="small" icon="el-icon-upload2" type="success"
							@click="submitUpload">导入</el-button> -->
					<!-- </el-upload> -->
					// 改为异步上传 
					<a v-bind:href="promoteSaleDate.promoteFile">活动文件下载</a>
				</el-form-item>
				<!-- <el-form-item label="备注">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :disabled="inputStatus"
						v-model="promoteSaleDate.remark">
					</el-input>
				</el-form-item> -->

				<el-form-item prop="operate" label="" width="100">
					<el-button type="warning" @click="reset" v-show="!inputStatus">重置</el-button>
					<el-button type="primary" @click="save" v-show="!inputStatus">保存</el-button>
					<el-button type="primary" @click="updateSubmit" v-show="!inputStatus">提交</el-button>
				</el-form-item>
				<!-- 审核记录 -->
				<el-form-item label="">
					<el-table :data="verifyDate" stripe style="width: 100%" slot-scope="scope" :hiddle="showVerfiy">
						<el-table-column prop="applicant" label="申请人" width="140">
						</el-table-column>
						<el-table-column prop="verifyPerson" label="审批人" width="140">
						</el-table-column>
						<el-table-column prop="verifyTime" label="审批时间" width="150">
						</el-table-column>
						<el-table-column prop="verifyStatus" label="审批状态" width="150" :formatter="verifyStatus">
						</el-table-column>
						<el-table-column prop="verifySuggestion" label="审批意见" width="150">
						</el-table-column>
					</el-table>
				</el-form-item>


			</el-form>
		</el-dialog>
		<!-- 新增的模态框 -->
		<!-- 模态框 -->
		<el-dialog title="新增活动" :visible.sync="addDialogVisible" width="55%" center>
			<!-- 	<el-form :model="form">
			    <el-form-item label="活动名称" :label-width="formLabelWidth">
			      <el-input v-model="form.name" autocomplete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="活动区域" :label-width="formLabelWidth">
			      <el-select v-model="form.region" placeholder="请选择活动区域">
			        <el-option label="区域一" value="shanghai"></el-option>
			        <el-option label="区域二" value="beijing"></el-option>
			      </el-select>
			    </el-form-item>
			  </el-form> -->
			<el-form ref="promoteSaleDate" :model="addFormDate" label-width="120px">
				
				<el-row>
					<el-col :span="12">
						<el-form-item label="活动名称">
							<el-input v-model="addFormDate.promoteName" autocomplete="off"></el-input>
						</el-form-item>
					</el-col>
				</el-row>
				
				<el-form-item label="活动开始时间">
					<el-date-picker v-model="addFormDate.startTime" type="datetime" placeholder="开始时间"
						value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="活动结束时间">
					<el-date-picker v-model="addFormDate.endTime" type="datetime" placeholder="结束时间"
						value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="价格生效时间">
					<el-date-picker v-model="addFormDate.priceStartTime" type="datetime" placeholder="开始时间"
						value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="价格失效时间">
					<el-date-picker v-model="addFormDate.priceEndTime" type="datetime" width="100" placeholder="结束时间"
						value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-row>
					<el-col :span="12">
						<el-form-item label="活动类型">
							<el-select v-model="addFormDate.promoteType">
								<el-option v-for="item in activeOption" :key="item.value" :value="item.value"
									:label="item.label"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>
				
				
				<el-form-item label="">
					<el-table ref="productDateTable" :data="productDate" stripe style="width: 100%" slot-scope="scope">
						<el-table-column prop="productId" label="id" width="50">
						</el-table-column>
						<el-table-column prop="productName" label="商品名字" width="80">
						</el-table-column>
						<el-table-column prop="productStock" label="库存数量" width="100">
						</el-table-column>
						<el-table-column prop="promoteNum" label="促销数量" width="100">
							<template slot-scope="scope">
								<el-input v-model="scope.row.promoteNum" :change="confirmPromoteNum(scope.row)">
								</el-input>
							</template>
						</el-table-column>

						<el-table-column prop="marketPrice" label="市场价格" width="100">
						</el-table-column>
						<el-table-column prop="shoppingPrice" label="商场价格" width="100">
						</el-table-column>
						<el-table-column prop="promotePrice" label="促销价格" width="100">
							<template slot-scope="scope">
								<el-input v-model="scope.row.promotePrice"></el-input>
							</template>
						</el-table-column>
						<el-table-column prop="percent" label="百分比" width="100">
							<template slot-scope="scope">
								<div class="block">
									<el-slider v-model="scope.row.percent" @input="updatePrice(scope.row)">
									</el-slider>
								</div>
							</template>
						</el-table-column>
						<el-table-column prop="delete" label="删除商品" width="100">
							<template slot-scope="scope">
								<el-button icon="el-icon-delete" circle 
								@click.native.prevent="deleteProduct(scope.$index, productDate)"
								type="danger" >移除
								</el-button>
							</template>
						</el-table-column>
					</el-table>
				</el-form-item>
				<el-form-item label="">
					<el-button type="primary" @click="selectProducts">添加活动商品</el-button>
				</el-form-item>
				<el-form-item label="活动情况或原因">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-model="addFormDate.promoteDetail">
					</el-input>
				</el-form-item>
				<el-form-item label="活动策划文件">
					<el-upload ref="upload" class="form-upload" action="http://127.0.0.1:8080/file/upload"
						accept=".doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf,.7z,.rar,.zip" :limit="1"
						:on-success="handleFileSuccess2" :on-error="handleFileError" 
						:on-remove="handleFileRemove" :disabled="isProcess" :file-list="fileList">
						<!-- 通过isProcess控制按钮的文字颜色、背景，通过uploadTxt控制按钮文本 -->
						<el-button :class="{'form-upload-process': isProcess}" size="small" type="primary"
							v-text="uploadTxt"></el-button>
					</el-upload>

					<!-- 当编辑文件并且showFile为true时，显示默认文件文本块 -->
					<p class="form-file" v-if="showFile"><span class="form-file-txt"
							v-text="file" :title="file"></span></p>
				</el-form-item>
				<el-form-item label="备注">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-model="addFormDate.remark">
					</el-input>
				</el-form-item>
				<el-form-item prop="operate" label="" width="100">
					<!-- <el-button type="danger" @click="resetForm">重置</el-button> -->
					<el-button type="primary" @click="addSave">保存</el-button>
					<el-button type="primary" @click="addSubmit">提交</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		<!-- // 添加商品的模态框 -->
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

			<el-table ref="singleTable" :data="productTableData" highlight-current-row 
				style="width: 100%">
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
			<el-pagination @size-change="productHandleSizeChange" @current-change="productHandleCurrentChange"
				:current-page="productPageinfo.page" :page-sizes="[3, 6, 10]" :page-size="productPageinfo.pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="productPageinfo.total">
			</el-pagination>

		</el-dialog>


	</div>


</template>

<script>
	export default {
		data() {
			return {
				form: {
					oldFileName: '' // 绑定表单的选项值，用于做表单校验和动态绑定文件名
				},
				// 是否展示默认文件块
				showFile: false,
				// 绑定upload组件中的文件列表，用于控制一个文件上传
				fileList: [],
				// 上传按钮文本
				uploadTxt: '点击上传',
				// 文件上传状态，false标识未上传，true标识正在上传
				isProcess: false,
				// ------------
				// 添加商品的模态框
				brands: [],//
				colors: [],
				goodsTypes: [],
				productTableData: [],
				addProductsVisible: false,
				productQueryForm: {
					goodsName: '',
					goodsType: '',
					goodsColor: '',
					goodsBrand: '',
					goodsType: ''
				},
				productPageinfo: {
					pageNum: 1,
					pageSize: 3,
					total: 10
				},
				// ----------------
				textarea1: '',
				textarea2: '',
				promoteId: '',
				centerDialogVisible: false,
				addDialogVisible: false,
				currentPage: 1,
				tableData: [],
				activeOption: [{
					value: 1,
					label: '每日限量'
				}, {
					value: 2,
					label: '连续促销'
				}],
				inputStatus: true,
				showVerfiy: true,
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
				addFormDate: {
					createBy: '',
					promoteId: '',
					promoteName: '',
					startTime: null,
					endTime: null,
					promoteType: '',
					priceStartTime: null,
					priceEndTime: null,
					promoteFile: '',
					promoteDetail: '',
					remark: '',
					promoteStatus: ''
				},
				productDate: [],
				verifyDate: [],
				percentAdjust: 100,
				// promoteProductNum:"",
				// promoteProductPrice:"",
				currentRow: null,
				queryForm: {
					promoteName: '',
					// startTime: '',
					promoteType: '',
					promoteStatus: '',
					pageNum: 1,
					pageSize: 5,
					total: undefined
				},
				options: [],
				value: '',
			}
		},
		methods: {
			// 编辑时的文件上传
			handleFileSuccess(res, file) {
				
				// 上传成功之后将上传状态改成未上传中，按钮文本设置成“重新上传”
				this.isProcess = false
				this.uploadTxt = '重新上传'
				// 用form里的oldFileName记录下当前上传成功的文件名
				// debugger;
				this.promoteSaleDate.promoteFile = "http://192.168.20.252:8111/" + res.data.path;
				console.log(this.promoteSaleDate.promoteFile);
				this.form.oldFileName = file.name
				this.$message.success('文件上传成功')
			},
			// add时的文件上传
			handleFileSuccess2(res, file) {
				this.isProcess = false
				this.uploadTxt = '重新上传'
				// 用form里的oldFileName记录下当前上传成功的文件名
				// debugger;
				this.addFormDate.promoteFile = "http://192.168.20.252:8111/" + res.data.path;
				console.log(this.addFormDate.promoteFile);
				this.form.oldFileName = file.name
				this.$message.success('文件上传成功');
			},
			handleFileError(err, file, fileList) { 
				// 上传失败时将上传状态改成未上传中
				this.isProcess = false
				// 文件上传按钮根据oldFileName调整文本
				this.uploadTxt = this.form.oldFileName !== '' ? '重新上传' : '点击上传'
				this.$message.error('文件上传失败!')
			},

			// 文件被移除时
			handleFileRemove(file, fileList) { 
				this.uploadTxt = '点击上传'
				this.form.oldFileName = ''
			},
			//-----------------------------------------------
			// 查询商品时的相关函数 
			// page相关函数，size改变，查询按钮、重置按钮
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
			resetProductMyquery(){
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
			},
			addProduct(row, $index){
				let productNum = this.productDate.length;
				let newProuduct = {};
				var newProudctArray = [];
				if(productNum==0){
					newProuduct.productId = row.goodsId;
					newProuduct.productName = row.goodsName;
					newProuduct.productStock = row.inventoryNumber;
					newProuduct.marketPrice = row.marketRmb;
					newProuduct.shoppingPrice = row.mallRmb;
					newProuduct.promotePrice = row.mallRmb;
					newProuduct.promoteNum = "";
					newProudctArray.push(newProuduct);
					this.productDate = newProudctArray;
				}else{
					// newProudctArray = this.productDate;
					newProuduct.productId = row.goodsId;
					newProuduct.productName = row.goodsName;
					newProuduct.productStock = row.inventoryNumber;
					newProuduct.marketPrice = row.marketRmb;
					newProuduct.shoppingPrice = row.mallRmb;
					newProuduct.promotePrice = row.mallRmb;
					newProuduct.promoteNum = "";
					// 需要刷新添加或者修改的页面
					this.$set(this.productDate,productNum,newProuduct);
					// this.productDate[productNum] = newProuduct;
				}
				console.log(this.productDate);
				// debugger;
				// this.productDate.push(newProuduct;);
				this.$refs['productDateTable'].resetFields();
			},
			lnitializationData(){//初始化页面数据
			   
			},
			// ----------------------------------
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
				this.$refs['selectTableDate'].resetFields();
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
			reset() {
				this.$axios.get("/promoteSale/" + this.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						this.formatTime(this.promoteSaleDate.endTime);
					});
					this.centerDialogVisible = false;
			},
			// 保存草稿
			save() {
				let jsonStr = {
					"PromoteSale": this.promoteSaleDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.put("/promoteSale", jsonStr).then(resp => {
					if (resp.code == 20000) {
					
						this.$message({
							message: resp.msg,
							type: 'success'
						});
					} else if (resp.code == 50000) {
						this.$message.error(resp.msg);
					}
				})
				this.centerDialogVisible = false;
				
			},
			resetForm() {
				this.addFormDate = '';
				this.productDate = [];
			},
			addSave() {
				let jsonStr = {
					"PromoteSale": this.addFormDate,
					"PromoteProduct": this.productDate
				};
				console.log(jsonStr);
				this.$axios.post("/promoteSale", jsonStr).then(resp => {
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
			},
			addSubmit() {
				let jsonStr = {
					"PromoteSale": this.addFormDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.post("/verify/submit", jsonStr).then(resp => {
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
				this.selectPromoteList();
			},
			// 保存并提交
			updateSubmit() {
				let jsonStr = {
					"PromoteSale": this.promoteSaleDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.post("/verify/updatesubmit", jsonStr).then(resp => {
					if (resp.code == 20000) {
					
						this.$message({
							message: resp.msg,
							type: 'success'
						});
					} else if (resp.code == 50000) {
						this.$message.error(resp.msg);
					}
				})
				this.addDialogVisible = false
				// 刷新页面
				this.selectPromoteList();
			},
			confirmPromoteNum(val) {
				if (val.promoteNum == "" || val.promoteNum == null) {
					val.promoteNum = 0;
				};
				// val.promoteNum = this.inputnumZZ(val.promoteNum);
				if (val.promoteNum > val.productStock) {
					val.promoteNum = val.productStock;
				}
			},
			// inputnumZZ(value) {
			// 	value = value.toString()
			// 	let num = value.replace(/[^\d]/g, "")
			// 	if (num.length > 9) {
			// 		num = num.slice(0, 9);
			// 	} //清除"数字"和"."以及"-"以外的字符;
			// 	return num
			// },
			onAdd() {
				this.verifyDate = "";
				this.promoteSaleDate = "";
				this.productDate = "";
				this.addDialogVisible = true;
			},
			onEdit(val) {
				this.verifyDate = "";
				this.showVerfiy = true;
				this.centerDialogVisible = true;
				this.inputStatus = false;
				this.promoteId = val.promoteId;
				this.$axios.get("/promoteSale/" + val.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						this.formatTime(this.promoteSaleDate.endTime);
					});

			},
			updatePrice(val) {
				val.promotePrice = val.shoppingPrice * val.percent / 100;
			},
			rowStyle() {
				return "text-align:center"
			},
			headStyle() {
				return "text-align:center"
			},
			onSelect(val) {
				this.verifyDate = "";
				this.showVerfiy = true;
				this.inputStatus = true;
				this.centerDialogVisible = true;
				console.log(val.promoteId);
				// debugger
				this.$axios.get("/promoteSale/" + val.promoteId)
					.then(resp => {
						this.productDate = resp.data.PromoteProduct;
						this.promoteSaleDate = resp.data.PromoteSale;
						this.formatTime(this.promoteSaleDate.endTime);
					})
			},
			formatTime(oldTimeStr) {
				if (oldTimeStr != null && oldTimeStr != undefined) {
					let length1 = oldTimeStr.length;
					return oldTimeStr.substring(0, length1 - 2);
				};
			},

			onQuery() {
				this.selectPromoteList();
				// debugger;
			},
			promoteStatus(cellValue) {
				if (cellValue.promoteStatus == 0) {
					cellValue.operate = false;
					return "未提交";
				} else if (cellValue.promoteStatus == 1) {
					cellValue.operate = true;
					return "待审核";
				} else if (cellValue.promoteStatus == 2) {
					cellValue.operate = false;
					return "已驳回";
				} else if (cellValue.promoteStatus == 3) {
					cellValue.operate = true;
					return "已审核";
				} else {
					cellValue.operate = false;
					return "其他";
				}
			},
			verifyStatus(cellValue) {
				if (cellValue.verifyStatus == 1) {
					return "通过";
				} else if (cellValue.verifyStatus == 2) {
					return "驳回";
				}
			},
			// startTime(cellValue) {
			// 	return this.timestampToTime(cellValue.startTime);
			// },
			// priceStartTime(cellValue) {
			// 	return this.timestampToTime(cellValue.priceStartTime);
			// },
			// formatTime(timeValue) {
			// 	return this.timestampToTime(timeValue);
			// },
			handleSizeChange(pageSize) {
				this.queryForm.pageSize = pageSize;
				this.selectPromoteList();
				console.log(`每页 ${val} 条`);
			},
			handleCurrentChange(pageNum) {
				this.queryForm.pageNum = pageNum;
				this.selectPromoteList();
				console.log(`当前页: ${val}`);
			},
			// timestampToTime(timestamp) {
			// 	if(timestamp == null||timestamp==undefined){
			// 		return "";
			// 	}
			// 	var date = new Date(timestamp); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
			// 	if(date == null||date==undefined){
			// 		return "";
			// 	}
			// 	var Y = date.getFullYear() + '.';
			// 	var M = ((date.getMonth() + 1) < 10) ? ('0' + (date.getMonth() + 1) + '.') : ((date.getMonth() + 1) + '.');
			// 	var D = (date.getDate() < 10) ? ('0' + date.getDate() + ' ') : (date.getDate() + ' ');
			// 	var h = (date.getHours() < 10) ? ('0' + date.getHours() + ':') : (date.getHours() + ':');
			// 	var m = (date.getMinutes() < 10) ? ('0' + date.getMinutes() + ':') : (date.getMinutes() + ':');
			// 	var s = (date.getSeconds() < 10) ? ('0' + date.getSeconds()) : (date.getSeconds());
			// 	return Y + M + D + h + m + s;
			// },
			selectPromoteList() {
				this.$axios.get("/promoteSale/list", {
					params: this.queryForm
				}).then(resp => {
					// this.tableData = resp.data;
					this.tableData = resp.data.list;
					this.queryForm.pageNum = resp.data.pageNum;
					// debugger;
					this.queryForm.pageSize = resp.data.pageSize;
					this.queryForm.total = resp.data.total;
				})
			}

		},
		mounted() {
			this.selectPromoteList();
		}

	}
</script>

<style>
</style>
