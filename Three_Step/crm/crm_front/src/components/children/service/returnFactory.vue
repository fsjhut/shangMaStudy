<template>
	<div>
		<el-form :inline="true" :model="returnform" class="demo-form-inline">
		  <el-form-item label="返厂入库单号">
		    <el-input v-model="returnform.refactoryCode" placeholder="请输入返厂入库单号"></el-input>
		  </el-form-item>
		  <el-form-item label="返厂入库标志">
		    <el-select v-model="returnform.refactoryFlag" placeholder="返厂入库标志">
		      <el-option
				v-for="item in flags"
				:key="item.value"
				:label="item.label"
				:value="item.value">
		      </el-option>
		    </el-select>
		  </el-form-item>
		  <el-form-item label="审核状态">
		    <el-select v-model="returnform.refactoryState" placeholder="审核状态">
		      <el-option
				v-for="item in states"
				:key="item.value"
				:label="item.label"
				:value="item.value">
		      </el-option>
		    </el-select>
		  </el-form-item>
		  <el-form-item label="制单人">
		    <el-input v-model="returnform.createBy" placeholder="制单人"></el-input>
		  </el-form-item>
		  <el-form-item label="制单时间">
			  <el-date-picker
			        v-model="returnform.createTime"
			        type="datetimerange"
					format="yyyy-MM-dd hh:mm:ss"
					value-format="yyyy-MM-dd hh:mm:ss"
			        range-separator="至"
			        start-placeholder="开始日期"
			        end-placeholder="结束日期">
			      </el-date-picker>
		  </el-form-item>
		  <el-form-item label="审批时间">
			  <el-date-picker
					v-model="returnform.updateTime"
					type="datetimerange"
					format="yyyy-MM-dd hh:mm:ss"
					value-format="yyyy-MM-dd hh:mm:ss"
					range-separator="至"
					start-placeholder="开始日期"
					end-placeholder="结束日期">
				  </el-date-picker>
		  </el-form-item>
		  <el-form-item>
		    <el-button type="primary" @click="onSubmit">查询</el-button>
		    <el-button type="success" @click="addorder">选择商品</el-button>
			<!-- <a class='download' :href="'/crmReturnfactory/down?path=download/mobanf4w5a4f5.xlsx'" download=""  title="下载">下载</a> -->
			<!-- <a href="crmReturnfactory/down?path=download/mobanf4w5a4f5.xlsx">下载模板</a> -->
		    <el-button type="info" @click="downloadmodel">下载模板</el-button>
		    <!-- <el-button type="warning" @click="infactory">入库单导入</el-button> -->
		    <el-button type="success" @click="outfactory">入库单导出</el-button>
		  </el-form-item>
		  <el-form-item>
			  <el-upload
			    class="upload-demo"
			    ref="upload"
			    action="https://jsonplaceholder.typicode.com/posts/"
			    :on-preview="handlePreview"
			    :on-remove="handleRemove"
			    :file-list="fileList"
			    :auto-upload="false">
			    <el-button slot="trigger" type="primary" @click="infactory">入库单导入</el-button>
			  </el-upload>
		  </el-form-item>
		</el-form>
		
		<el-table :data="tableData" border style="width: 100%">
			<el-table-column fixed type="index" label="序号" width="150" >
			</el-table-column>
			<el-table-column prop="refactoryCode" label="返厂入库单号" width="150">
			</el-table-column>
			<el-table-column prop="refactoryFlag" label="返厂入库标志" width="150">
				<template slot-scope="scope">
				   <el-tag type="warning" effect="dark" v-if="scope.row.refactoryFlag==0">已出库</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.refactoryFlag==1">已入库</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="createBy" label="制单人" width="150">
			</el-table-column>
			<el-table-column prop="createTime" label="制单时间" width="300">
			</el-table-column>
			<el-table-column prop="updateBy" label="审批人" width="120">
			</el-table-column>
			<el-table-column prop="refactoryState" label="审批状态" width="120">
				<template slot-scope="scope">
				   <el-tag type="warning" effect="dark" v-if="scope.row.refactoryState==0">未审核</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.refactoryState==1">审核通过</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.refactoryState==2">未通过</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.refactoryState==3">草稿</el-tag>
				   <el-tag type="success" effect="dark" v-if="scope.row.refactoryState==5">待高级审核</el-tag>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="300">
				<template slot-scope="scope">
					<el-button @click="handleClick(scope.row)" type="success" size="small">编辑</el-button>
					<el-button @click="handlecheck(scope.row)" type="success" size="small" 
					:disabled="ischeck || scope.row.refactoryState==1
					|| scope.row.refactoryState==2
					">审核</el-button>
					<el-button @click="checkFlowing(scope.row)" type="success" size="small">审核跟踪</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :current-page="pageinfo.pageNum"
		      :page-sizes="[10, 20, 30, 100]"
		      :page-size="pageinfo.pageSize"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="pageinfo.total">
		</el-pagination>
		<!-- 选择商品 -->
		<el-dialog title="添加商品" :visible.sync="addiolog">
			<el-button type="success" size="small" :disabled="isdisabled" @click="addfactory">添加入库</el-button>
			<el-button type="warning" size="small" :disabled="isdisabled" @click="addtext">保存草稿</el-button>
		  <el-table :data="goodsData">
			<el-table-column label="选择" width="65">
			     <template scope="scope">
			      <el-radio :label="scope.$index" v-model="radio" @change.native="getCurrentRow(scope.row)"></el-radio>
			    </template>
			</el-table-column>	
		    <el-table-column property="goodsCode" label="商品串码" width="100"></el-table-column>
		    <el-table-column property="goodsBrand" label="商品品牌" width="100"></el-table-column>
		    <el-table-column property="goodsName" label="商品名称" width="100"></el-table-column>
		    <el-table-column property="goodsModel" label="商品型号"></el-table-column>
		    <el-table-column property="goodsColor" label="商品颜色"></el-table-column>
		    <el-table-column property="goodsFrom" label="商品供应商"></el-table-column>
		    <el-table-column property="goodsFlowing" label="商品跟踪信息"></el-table-column>
		    <el-table-column property="outMark" label="返厂类型">
				<template slot-scope="scope">
				   <el-tag type="success" effect="dark" v-if="scope.row.outMark==0">维修</el-tag>
				   <el-tag type="primary" effect="dark" v-if="scope.row.outMark==1">更换</el-tag>
				</template>
			</el-table-column>
		    <el-table-column property="editCode" label="更换后商品串码"></el-table-column>
			<el-table-column fixed="right" label="操作" width="100">
				<template slot-scope="scope">
					<el-button @click="editgoods(scope.row)" type="text" size="small">编辑</el-button>
				</template>
			</el-table-column>
		  </el-table>
		</el-dialog>
		
		<!-- 添加备注信息 -->
		<el-dialog title="问题商品入库备注信息" :visible.sync="descdialog">
		  <el-form :model="descform">
		    <el-form-item >
		      <el-input type="textarea" v-model="descform.fdesc" autocomplete="off"></el-input>
		    </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
			  	<el-button @click="desccancle" type="button" size="small">取消</el-button>
			  	<el-button @click="desconfirm" type="button" size="small">确定</el-button>
		  </div>
		</el-dialog>
		
		<!-- 编辑商品信息 -->
		<el-dialog title="商品详细信息" :visible.sync="goodsdiolog">
		  <el-form :model="goodsform">
		    <el-form-item label="商品串码" :label-width="formLabelWidth">
		      <el-input v-model="goodsform.goodsCode" autocomplete="off" :disabled="true"></el-input>
		    </el-form-item>
			<el-form-item label="商品品牌" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsBrand" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品名称" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsName" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品型号" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsModel" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品颜色" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsColor" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品供应商" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsFrom" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品跟踪信息" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsFlowing" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="返厂类型" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.outMark" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="更换后商品串码" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.editCode" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="入库备注" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.fdesc" autocomplete="off" :disabled="isshow"></el-input>
			</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="goodscancle">取 消</el-button>
		    <el-button type="primary" @click="goodsconfirm" :disabled="isshow">修改</el-button>
		    <el-button type="primary" @click="goodsubmit" :disabled="isshow">提交</el-button>
		  </div>
		</el-dialog>
		
		<!-- 审核信息 -->
		<el-dialog title="商品详细信息" :visible.sync="checkdiolog">
		  <el-form :model="goodsform">
		    <el-form-item label="商品串码" :label-width="formLabelWidth">
		      <el-input v-model="goodsform.goodsCode" autocomplete="off" :disabled="true"></el-input>
		    </el-form-item>
			<el-form-item label="商品品牌" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsBrand" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品名称" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsName" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品型号" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsModel" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品颜色" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsColor" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品供应商" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsFrom" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="商品跟踪信息" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.goodsFlowing" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="返厂类型" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.outMark" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="更换后商品串码" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.editCode" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
			<el-form-item label="入库备注" :label-width="formLabelWidth">
			  <el-input v-model="goodsform.fdesc" autocomplete="off" :disabled="true"></el-input>
			</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="checkcancle">取 消</el-button>
		    <el-button type="primary" @click="checkback">驳回</el-button>
		    <el-button type="primary" @click="checksubmit">通过</el-button>
		  </div>
		</el-dialog>
		
		<!-- 商品跟踪信息 -->
		<el-dialog title="商品详细信息" :visible.sync="flowdiolog">
		  <el-form :model="goodsform">
			  <el-row>
			    <el-col :span="12">
					<el-form-item label="商品串码" :label-width="formLabelWidth">
					  <el-input v-model="goodsform.goodsCode" autocomplete="off" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			    <el-col :span="12">
					<el-form-item label="商品品牌" :label-width="formLabelWidth">
					  <el-input v-model="goodsform.goodsBrand" autocomplete="off" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			  </el-row>
		    <el-row>
		      <el-col :span="12">
				  <el-form-item label="商品名称" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.goodsName" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
		      <el-col :span="12">
				  <el-form-item label="商品型号" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.goodsModel" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
		    </el-row>
			<el-row>
			  <el-col :span="12">
				  <el-form-item label="商品颜色" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.goodsColor" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			  <el-col :span="12">
				  <el-form-item label="商品供应商" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.goodsFrom" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			</el-row>
			<el-row>
			  <el-col :span="12">
				  <el-form-item label="商品跟踪信息" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.goodsFlowing" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			  <el-col :span="12">
				  <el-form-item label="返厂类型" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.outMark" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			</el-row>
			<el-row>
			  <el-col :span="12">
				  <el-form-item label="更换后商品串码" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.editCode" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			  <el-col :span="12">
				  <el-form-item label="入库备注" :label-width="formLabelWidth">
				    <el-input v-model="goodsform.fdesc" autocomplete="off" :disabled="true"></el-input>
				  </el-form-item>
			  </el-col>
			</el-row>
		  </el-form>
		  <el-table
		        :data="logData"
		        style="width: 100%">
		        <el-table-column
		          prop="applicant"
		          label="申请人"
		          width="180">
		        </el-table-column>
		        <el-table-column
		          prop="verifyPerson"
		          label="审批人"
		          width="180">
		        </el-table-column>
		        <el-table-column
		          prop="verifySuggestion"
		          label="审批记录">
		        </el-table-column>
				<el-table-column
				  prop="verifyTime"
				  label="审批时间">
				</el-table-column>
				
		      </el-table>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="flowdiolog = false">返回</el-button>
		  </div>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
		  return {
			ujob:'',
			isdisabled:true,
			checkdiolog:false,
			flowdiolog:false,
			isshow:true,
			ischeck:true,
			descform:{
				goodsCode:'',
				fdesc:'',
			},
			goodsform:{
				goodsCode:'',
				goodsBrand:'',
				goodsModel:'',
				goodsName:'',
				goodsColor:'',
				goodsFrom:'',
				goodsFlowing:'',
				outMark:'',
				editCode:'',
				fdesc:''
			},
			formLabelWidth: '120px',
			goodsdiolog:false,
			descdialog:false,
			radio:"",
			value1:'',
			value2:'',
			addiolog:false,
		    tableData: [],
			logData:[],
			goodsData:[],
			returnform: {
			  refactoryCode:'',
			  refactoryFlag:'',
			  refactoryState:'',
			  createBy:'',
			  createTime:'',
			  crendTime:'',
			  updateTime:'',
			  upendTime:''
			},
			templateSelection:[],
			pageinfo:{
				pageNum:1,
				pageSize:5,
				total:0
			},
			editstate:{
				fid:'',
				refactoryState:''
			},
			states:[
				{value:0,label:'未审核'},
				{value:1,label:'审核通过'},
				{value:2,label:'未通过'}
			],
			flags:[
				{value:0,label:'已出库'},
				{value:1,label:'已入库'},
			],
			descedit:{
				goodsCode:'',
				fdesc:'',
			},
			AuditLogging:{
				verifyTime:'',
				verifyId:'',
				applicant:'',
				verifyTableId:'',
				verifyPerson:'',
				verifyStatus:'',
				verifySuggestion:'',
				verifyTable:''
			},
			checklogging:{},
			getlog:{
				verifyTable:'crm_returnfactory',
				verifyTableId:''
			}
		  }
		},
	    methods: {
		download (data,titName) {
			if(!data){
			  return
			}
			const content = data
			const blob = new Blob([content],{type: "application/vnd.ms-excel"})
			const fileName = titName?titName: '报废卡号.xlsx'
			if ('download' in document.createElement('a')) { // 非IE下载
			  const elink = document.createElement('a')
			  elink.download = fileName
			  elink.style.display = 'none'
			  elink.href = URL.createObjectURL(blob)
			  document.body.appendChild(elink)
			  elink.click()
			  URL.revokeObjectURL(elink.href) // 释放URL 对象
			  document.body.removeChild(elink)
			} else { // IE10+下载
			  navigator.msSaveBlob(blob, fileName)
			}
		  },
		downloadmodel() {
		    console.log("下载excel模板");
		    var url = ""; //接口地址
		    var fileName = "download/mobanf4w5a4f5.xlsx";
		    this.$axios({
		     url: "crmReturnfactory/down?path="+fileName,
		     method: 'get',
		     responseType: 'blob',
		    }).then(res => {
		     console.log(res)
		     const blob = new Blob([res]);
		     const downloadElement = document.createElement("a");
		     const href = window.URL.createObjectURL(blob);
		     // 后台再header中传文件名
		     const name = fileName;
		     downloadElement.href = href;
		     downloadElement.download = name;
		     document.body.appendChild(downloadElement);
		     downloadElement.click();
		     document.body.removeChild(downloadElement); // 下载完成移除元素
		     window.URL.revokeObjectURL(href); // 释放掉blob对象
		    });
		   },
		infactory(){
			
		},
		outfactory(){
			this.$axios.post("crmReturnfactory/out")
			.then(resp=>{
				if(resp.code==20000){
					this.$message.success("返厂入库信息单保存至:"+resp.data);
				}else{
					this.$message.error('操作失败');
				}
			}).catch(error=>{console.log(error)})
		},
		checkFlowing(row){
			this.getlog.verifyTableId = row.fid+'';
			this.$axios.get("crmFactoryGoods/"+row.returnsId)
			.then(resp=>{
				this.goodsform = resp.data;
				this.flowdiolog=true;
			}).catch(error=>{console.log(error)})
			this.getchecklog();
		},
		checksubmit(){
			if(this.ujob==1){
				this.AuditLogging.verifyTime = "";
				this.AuditLogging.verifyId = 2000;//1000新增2000修改
				this.AuditLogging.applicant = this.checklogging.createBy;
				this.AuditLogging.verifyTableId = this.checklogging.fid+'';
				this.AuditLogging.verifyPerson = "";
				this.AuditLogging.verifyStatus = 5;
				this.AuditLogging.verifySuggestion = "带高级审核";
				this.AuditLogging.verifyTable = "crm_returnfactory";
				this.checklogging.refactoryState = 5;
			}
			if(this.ujob==2){
				this.AuditLogging.verifyTime = "";
				this.AuditLogging.verifyId = 2000;//1000新增2000修改
				this.AuditLogging.applicant = this.checklogging.createBy;
				this.AuditLogging.verifyTableId = this.checklogging.fid+'';
				this.AuditLogging.verifyPerson = "";
				this.AuditLogging.verifyStatus = 1;
				this.AuditLogging.verifySuggestion = "审核通过";
				this.AuditLogging.verifyTable = "crm_returnfactory";
				this.checklogging.refactoryState = 1;
				this.checklogging.refactoryFlag=1;
			}
			this.checkparamsubmit();
		},
		handlecheck(row){
			this.checklogging = row;
			this.$axios.get("crmFactoryGoods/"+row.returnsId)
			.then(resp=>{
				this.goodsform = resp.data;
				this.checkdiolog=true;
			}).catch(error=>{console.log(error)})
		},
		checkback(){
				this.AuditLogging.verifyTime = "";
			    this.AuditLogging.verifyId = 2000;//1000新增2000修改
			    this.AuditLogging.applicant = this.checklogging.createBy;
			    this.AuditLogging.verifyTableId = this.checklogging.fid+'';
			    this.AuditLogging.verifyPerson = "";
			    this.AuditLogging.verifyStatus = 2;
			    this.AuditLogging.verifySuggestion = "驳回提交";
			    this.AuditLogging.verifyTable = "crm_returnfactory";
				this.checklogging.refactoryState = 2;
				this.checkparamsubmit();
		},
		checkparamsubmit(){
			let param = Object.assign(this.AuditLogging,this.checklogging);
			this.$axios.post("ver/adds",param)
			.then(resp=>{
				this.editparam();
				this.checkdiolog=false;
			}).catch(error=>{console.log(error)})
		},
		getchecklog(){
			let param = this.$qs.stringify(this.getlog);
			this.$axios.get("ver/list?"+param)
			.then(resp=>{
				this.logData = resp.data;
			}).catch(error=>{console.log(error)})
		},
		goodsubmit(){
			this.$axios.put("crmReturnfactory",this.editstate)
			.then(resp=>{
				if(resp.code==20000){
					this.$message.success('提交成功');
				}
				this.editparam();
				this.goodsdiolog=false;
			}).catch(error=>{console.log(error)})
		},
		goodsconfirm(){
			this.descedit.goodsCode = this.goodsform.goodsCode;
			this.descedit.fdesc = this.goodsform.fdesc;
			this.updatedesc(this.descedit);
		},
		addtext(){
			this.$axios.post("crmReturnfactory?goodsCode="+this.templateSelection.goodsCode+"&refactoryState=3")
			.then(resp=>{
				this.addiolog=false;
				this.editparam();
			}).catch(error=>{console.log(error)})
		},
		checkcancle(){
			this.checkdiolog=false;
		},
		goodscancle(){
			this.goodsdiolog=false;
			this.isshow=true;
		},
		handleSizeChange(val) {
			this.pageinfo.pageSize = val;
			this.editparam();
		},
		handleCurrentChange(val) {
			this.pageinfo.pageNum = val;
			this.editparam();
		},
		addfactory(){
			console.log(this.templateSelection);
			this.$axios.post("crmReturnfactory?goodsCode="+this.templateSelection.goodsCode+"&refactoryState=0")
			.then(resp=>{
				this.addiolog=false;
				this.editparam();
			}).catch(error=>{console.log(error)})
		},
		desccancle(){
			this.descdialog=false;
		},
		desconfirm(){
			this.updatedesc(this.descform);
			this.descdialog=false;
		},
		updatedesc(param){
			this.$axios.put("crmFactoryGoods",param)
			.then(resp=>{
				if(resp.code==20000){
					this.$message.success('备注修改成功');
				}
			}).catch(error=>{console.log(error)})
		},
		getCurrentRow(row){ //获取选中数据
		this.$axios.get("crmFactoryGoods/list?goodsCode="+row.goodsCode)
		.then(resp=>{
			if(resp.code==20000){
				for(var i=0;i<resp.data.length;i++){
					let json = resp.data[i];
					if(!json.hasOwnProperty("fid")){
						this.isdisabled=false;
					}else{
						this.isdisabled=true;
					}
				}
			}
		}).catch(error=>{console.log(error)})
		this.templateSelection = row;
		},
		addorder(){
			this.addiolog=true;
			this.$axios.get("crmReturnfactory/all")
			.then(resp=>{
				this.goodsData = resp.data;
			}).catch(error=>{console.log(error)})
		},
		editgoods(row){
			this.descdialog=true;
			this.descform.goodsCode = row.goodsCode;
			this.$axios.get("crmReturnfactory/all")
			.then(resp=>{
				
			}).catch(error=>{console.log(error)})
		},
	    handleClick(row) {
			this.editstate.fid = row.fid;
			this.editstate.refactoryState = 0;
			if(row.refactoryState==3 || row.refactoryState==2){
				this.isshow=false;
			}
			this.$axios.get("crmFactoryGoods/"+row.returnsId)
			.then(resp=>{
				this.goodsform = resp.data;
				this.goodsdiolog=true;
			}).catch(error=>{console.log(error)})
	      },
		onSubmit() {
			if(this.returnform.createTime instanceof Array){
				this.returnform.crendTime = this.returnform.createTime[1];
				this.returnform.createTime = this.returnform.createTime[0];
			}
			if(this.returnform.updateTime instanceof Array){
				this.returnform.upendTime = this.returnform.updateTime[1];
				this.returnform.updateTime = this.returnform.createTime[0];
			}
			this.editparam();
		},
		getdata(param){
			this.$axios.get("crmReturnfactory/list?"+param)
			.then(resp=>{
				this.tableData = resp.data.list;
				this.pageinfo.pageNum = resp.data.pageNum;
				this.pageinfo.pageSize = resp.data.pageSize;
				this.pageinfo.total = resp.data.total;
				if(this.ujob!=0){
				this.ischeck=false;
				}
			}).catch(error=>{console.log(error)})
		},
		editparam(){
			let param = this.$qs.stringify(this.returnform)+"&"+this.$qs.stringify(this.pageinfo);
			this.getdata(param);
		},
		getujob(){
			this.$axios.get("sysuser/loginUser")
			.then(resp=>{
				this.ujob = resp.data;
			}).catch(error=>{console.log(error)})
		}
	    },
		mounted() {
			this.getdata("");
			this.getujob();
		}
	  }
</script>

<style>
</style>
