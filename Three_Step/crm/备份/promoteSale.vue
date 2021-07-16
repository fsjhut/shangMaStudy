<template>
	<div>
		<el-form :inline="true" :model="queryForm" class="demo-form-inline">
			<el-form-item label="活动名称">
				<el-input v-model="queryForm.promoteName" placeholder="活动名称"></el-input>
			</el-form-item>
			<el-form-item label="活动类型">
				<el-select v-model="queryForm.promoteType" placeholder="活动类型">
					<el-option label="全部" value=""></el-option>
					<el-option label="每日限量" value="1"></el-option>
					<el-option label="连续促销" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="审核状态">
				<el-select v-model="queryForm.promoteStatus" placeholder="审核状态">
					<el-option label="全部" value=""></el-option>
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
		<el-table :data="tableData" style="width: 100%" stripe :default-sort="{prop: 'startTime', order: 'descending'}"
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
				<el-row slot-scope="scope">
					<el-button type="primary" circle @click="onSelect(scope.row)">查看</el-button>
					<!-- :disabled="scope.row.promoteStatus==1||scope.row.promoteStatus==3" -->
					<el-button type="warning" circle @click="onEdit(scope.row)" :disabled="buttonStatus">编辑</el-button>
					<el-button type="danger" circle @click="onDelete(scope.row)" :disabled="buttonStatus">删除</el-button>
					<el-button type="success" @click="onTrack(scope.row)" circle>跟踪</el-button>
					<!--  <el-button type="success" icon="el-icon-check" circle></el-button>
				  <el-button type="info" icon="el-icon-message" circle></el-button>
				  <el-button type="warning" icon="el-icon-star-off" circle></el-button> -->
				</el-row>
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
		<div class="block">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="queryForm.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="queryForm.pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="queryForm.total">
			</el-pagination>
		</div>
		<!-- 模态框 -->
		<el-dialog title="提示" :visible.sync="centerDialogVisible" width="68%" center>
			<el-form ref="promoteSaleDate" :model="promoteSaleDate" label-width="120px">
				<el-form-item label="活动名称">
					<el-input v-model="promoteSaleDate.promoteName" :disabled="inputStatus"></el-input>
				</el-form-item>
				<el-form-item label="活动开始时间">
					<el-date-picker v-model="promoteSaleDate.startTime" :readonly="inputStatus" type="datetime"
						placeholder="开始时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="活动结束时间">
					<el-date-picker v-model="promoteSaleDate.endTime" :readonly="inputStatus" type="datetime"
						placeholder="结束时间" value-format="yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="活动类型">
					<el-select v-model="promoteSaleDate.promoteType" :disabled="inputStatus">
						<el-option v-for="item in activeOption" :key="item.value" :value="item.value"
							:label="item.label"></el-option>
					</el-select>
				</el-form-item>
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
									<el-slider v-model="percentAdjust" @input="updatePrice(scope.row)"
										:disabled="inputStatus">
									</el-slider>
								</div>
							</template>
						</el-table-column>
					</el-table>
				</el-form-item>

				<el-form-item label="活动情况或原因">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :disabled="inputStatus"
						v-model="promoteSaleDate.promoteDetail">
					</el-input>
				</el-form-item>
				<el-form-item label="活动策划文件">
					<el-upload ref="upload" class="form-upload" action="http://127.0.0.1:8080/file/upload"
						accept=".doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf,.txt,.7z,.rar,.zip"
					    :limit="1"
						:on-success="handleFileSuccess" :on-error="handleFileError"
						:on-change="handleChange" :on-remove="handleFileRemove" 
						:disabled="isProcess" :file-list="fileList"> 
						<!-- 通过isProcess控制按钮的文字颜色、背景，通过uploadTxt控制按钮文本 -->
						<el-button :class="{'form-upload-process': isProcess}" size="small" type="primary"
							v-text="uploadTxt"></el-button>
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
					<a v-bind:href="promoteSaleDate.promoteFile">活动文件下载</a>
				</el-form-item>
				<el-form-item label="备注">
					<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :disabled="inputStatus"
						v-model="promoteSaleDate.remark">
					</el-input>
				</el-form-item>

				<el-form-item prop="operate" label="" width="100">
						<el-button type="primary" @click="reset" v-show="!inputStatus">重置</el-button>
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
		<el-dialog title="提示" :visible.sync="addDialogVisible" width="68%" center>
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

				<el-form-item label="活动名称">
					<el-input v-model="addFormDate.promoteName" autocomplete="off"></el-input>
				</el-form-item>
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
				<el-form-item label="活动类型">
					<el-select v-model="addFormDate.promoteType">
						<el-option v-for="item in activeOption" :key="item.value" :value="item.value"
							:label="item.label"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="">
					<el-table :data="productDate" stripe style="width: 100%" slot-scope="scope">
						<el-table-column prop="<productI></productI>d" label="id" width="50">
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
									<el-slider v-model="percentAdjust" @input="updatePrice(scope.row)">
									</el-slider>
								</div>
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
						accept=".doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf,.txt,.7z,.rar,.zip"
					    :limit="1"
						:on-success="handleFileSuccess2" :on-error="handleFileError"
						:on-change="handleChange" :on-remove="handleFileRemove" 
						:disabled="isProcess" :file-list="fileList"> 
						<!-- 通过isProcess控制按钮的文字颜色、背景，通过uploadTxt控制按钮文本 -->
						<el-button :class="{'form-upload-process': isProcess}" size="small" type="primary"
							v-text="uploadTxt"></el-button>
					</el-upload>
					
					<!-- 当编辑文件并且showFile为true时，显示默认文件文本块 -->
					<p class="form-file" v-if="dialogTit === '编辑文件' && showFile"><span class="form-file-txt"
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
				// 文件tempId
				tempId: '',
				// 正式文件id
				activeId: '',
				// ------------
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
				buttonStatus: '',
			}
		},
		methods: {
			handleFileSuccess(res, file) {
				this.uploadCount++
				// 上传成功之后将上传状态改成未上传中，按钮文本设置成“重新上传”
				this.isProcess = false
				this.uploadTxt = '重新上传'
				// 用form里的oldFileName记录下当前上传成功的文件名
				debugger;
				this.promoteSaleDate.promoteFile = "http://192.168.20.252:8111/" + res.data.path;
				console.log(this.promoteSaleDate.promoteFile);
				this.form.oldFileName = file.name
				this.$message.success('文件上传成功')
			},
			handleFileSuccess2(res, file){
				this.isProcess = false
				this.uploadTxt = '重新上传'
				// 用form里的oldFileName记录下当前上传成功的文件名
				debugger;
				this.addFormDate.promoteFile = "http://192.168.20.252:8111/" + res.data.path;
				console.log(this.addFormDate.promoteFile);
				this.form.oldFileName = file.name
				this.$message.success('文件上传成功');
			},
			handleFileError(err, file, fileList) { // eslint-disable-line
				// 上传失败时将上传状态改成未上传中
				this.isProcess = false
				// 文件上传按钮根据oldFileName调整文本
				this.uploadTxt = this.form.oldFileName !== '' ? '重新上传' : '点击上传'
				this.$message.error('文件上传失败!')
			},
			// 文件被移除时
			handleFileRemove(file, fileList) { // eslint-disable-line
				if (this.uploadCount === 0) {
					return
				}
				this.uploadTxt = '点击上传'
				this.form.oldFileName = ''
			},
			removeFile() {

			},
			onUploadChange(file) {

			},
			selectProducts() {
				//打开第二个模态框，将查询到的数据传递进去

			},
			onDelete(val) {
				this.promoteId = val.promoteId;
				this.$axios.delete("/promoteSale/" + this.promoteId)
					.then(resp => {
						console.log(resp)
					});
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
			},
			// 保存草稿
			save() {
				let jsonStr = {
					"PromoteSale": this.promoteSaleDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.put("/promoteSale", jsonStr).then(resp => {
					console.log(resp)
				})
			},
			resetForm(){
				this.addFormDate='';
				this.productDate=[];
			},
			addSave() {
				let jsonStr = {
					"PromoteSale": this.addFormDate,
					"PromoteProduct": this.productDate
				};
				console.log(jsonStr);
				this.$axios.post("/promoteSale", jsonStr).then(resp => {
					console.log(resp)
				});
				this.addDialogVisible = false;
				this.addFormDate='';
				this.productDate=[];
				
			},
			addSubmit() {
				let jsonStr = {
					"PromoteSale": this.addFormDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.post("/verify/submit", jsonStr).then(resp => {
					console.log(resp)
				});
				this.addDialogVisible = false;
				this.addFormDate='';
				this.productDate=[];
			},
			// 保存并提交
			updateSubmit() {
				let jsonStr = {
					"PromoteSale": this.promoteSaleDate,
					"PromoteProduct": this.productDate
				};
				this.$axios.post("/verify/updatesubmit", jsonStr).then(resp => {
					console.log(resp)
				})
			},
			confirmPromoteNum(val) {
				if (val.promoteNum == "" || val.promoteNum == null) {
					val.promoteNum = 0;
				};
				val.promoteNum = this.inputnumZZ(val.promoteNum);
				if (val.promoteNum > val.productStock) {
					val.promoteNum = val.productStock;
				}
			},
			inputnumZZ(value) {
				value = value.toString()
				let num = value.replace(/[^\d]/g, "")
				if (num.length > 9) {
					num = num.slice(0, 9);
				} //清除"数字"和"."以及"-"以外的字符;
				return num
			},
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
				val.promotePrice = val.shoppingPrice * this.percentAdjust / 100;
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
				this.$axios.get("/promoteSale/list", {
					params: this.queryForm
				}).then(resp => {
					this.tableData = resp.data.list;
					this.pageForm.pageNum = resp.data.pageNum;
					this.pageForm.pageSize = resp.data.pageSize;
					this.pageForm.total = resp.data.total;
					// console.log(this.queryForm);
				})
			},
			promoteStatus(cellValue) {
				if (cellValue.promoteStatus == 0) {
					this.buttonStatus = false;
					return "未提交";
				} else if (cellValue.promoteStatus == 1) {
					this.buttonStatus = true;
					return "待审核";
				} else if (cellValue.promoteStatus == 2) {
					this.buttonStatus = false;
					return "已驳回";
				} else if (cellValue.promoteStatus == 3) {
					this.buttonStatus = true;
					return "已审核";
				} else {
					this.buttonStatus = false;
					return "未提交";
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
					this.tableData = resp.data.list;
					// this.tableData.startTime = this.timestampToTime(resp.data.list.startTime);
					this.queryForm.pageNum = resp.data.pageNum;
					this.queryForm.pageSize = resp.data.pageSize;
					this.queryForm.total = resp.data.total;
					// console.log(this.queryForm);
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
