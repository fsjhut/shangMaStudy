<template>
	<div>
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: 'mypage' }">商品与赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item >赠品管理</el-breadcrumb-item>
			<el-breadcrumb-item >赠品管理列表</el-breadcrumb-item>
		</el-breadcrumb>
		<hr />
		<el-form :inline="true" :model="selectform" class="demo-form-inline" ref="selectform">
			<el-form-item prop="giftModel" label="赠品型号:">
				<el-input v-model="selectform.giftModel"  placeholder="赠品型号" style="width: 110px;"></el-input>
			</el-form-item>
			<el-form-item prop="giftBrand" label="赠品品牌:">
				<el-select v-model="selectform.giftBrand"  placeholder="赠品品牌" style="width: 110px;">
					<el-option label="全部" value=""></el-option>
					<el-option
					      v-for="item in brands"
					      :value="item.giftBrand"
					      :label="item.giftBrand">
					    </el-option>
				</el-select>
			</el-form-item>
			<el-form-item prop="giftColor" label="赠品颜色:">
				<el-select v-model="selectform.giftColor"  placeholder="赠品颜色" style="width: 110px;">
					<el-option label="全部" value="" ></el-option>
					<el-option v-for="item in clors" :label="item.giftColor" :value="item.giftColor"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item prop="giftName" label="赠品名称:">
				<el-input v-model="selectform.giftName"  placeholder="赠品名称" style="width: 110px;"></el-input>
			</el-form-item>
			<el-form-item prop="giftType" label="赠品类型:">
				<el-select v-model="selectform.giftType"  placeholder="赠品类型" style="width: 110px;">
					<el-option label="全部" value="" ></el-option>
					<el-option v-for="item in types" :label="item.giftType" :value="item.giftType" ></el-option>
				</el-select>
			</el-form-item>
		    <el-button type="primary" @click="querydata">查询</el-button>
			 <el-button type="success" @click="adddata">新增赠品</el-button>
			<el-button @click="myreset">重置</el-button>
		</el-form>
		</rb>
		<el-table ref="singleTable" :data="tableData" highlight-current-row @current-change="handleCurrentChange" style="width: 65%;height: 20%;" border>
			</el-table-column>
			<el-table-column  label="序号" width="50" type="index">
			</el-table-column>	
			<el-table-column prop="index" label="序号" width="100">
				<template slot-scope="scope">
					{{scope.$index+1}}
				</template>
			</el-table-column>
			<el-table-column prop="giftName" label="赠品名称" width="100">
			</el-table-column>
			<el-table-column prop="giftType" label="赠品类型" width="100">
			</el-table-column>
			<el-table-column prop="giftInventory" label="赠品库存" width="100">
			</el-table-column>
			<el-table-column prop="giftPrice" label="赠品单价" width="100">
			</el-table-column>
			<el-table-column prop="giftCost" label="采购成本" width="100">
			</el-table-column>
			<el-table-column prop="giftReviewstatus"  label="赠品状态"  width="100">
				<template slot-scope="scope">
				      <el-tag :type="scope.row.giftReviewstatus == '0' ? 'primary' : 'danger'" disable-transitions>{{scope.row.giftReviewstatus==0?'有效':'无效'}}</el-tag>
				     </template>
			</el-table-column>
			</el-table-column>
			<el-table-column  label="操作"   width="300">
				<template slot-scope="scope" >
					<el-button size="mini" type="success" @click="handleSelect(scope.$index, scope.row)" 
					>查看</el-button>
					<el-button size="mini" type="warning" @click="handleUpdate(scope.$index, scope.row)"
					 >修改</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)" 
					>删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<el-dialog title="赠品详细信息" :visible.sync="selectFormVisible" >
			<el-form ref="selectForm" :model="selectForm" >
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="selectForm.giftName" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="giftType" >
					<el-input v-model="selectForm.giftType" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="selectForm.giftModel" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="selectForm.giftPrice" value="0" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="selectForm.giftCost" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="selectForm.giftDepartment" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品库存:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="selectForm.giftInventory" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				<el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="selectForm.giftColor" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
				
				<el-form-item label="赠品品牌:" :label-width="formLabelWidth" prop="giftBrand">
					<el-input v-model="selectForm.giftBrand" autocomplete="off" :readonly="true"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="selectFormVisible = false ">取 消</el-button>
				<el-button type="primary" @click="sureSubmit() " >确 定</el-button>
			</div>
		</el-dialog>
		
		<el-dialog title="修改" :visible.sync="updateFormVisible" >
			<el-form ref="updateForm" :model="updateForm" >
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="updateForm.giftName" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item prop="giftType" label="赠品类型:" :label-width="formLabelWidth">
					<el-select v-model="updateForm.giftType"  placeholder="赠品类型" style="width: 110px;">
						<el-option v-for="type in types" :label="type.giftType" :value="type.giftType" ></el-option>
					</el-select>
				</el-form-item>
				
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="updateForm.giftModel" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="updateForm.giftPrice" value="0" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="updateForm.giftCost" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="updateForm.giftDepartment" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="赠品库存:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="updateForm.giftInventory" autocomplete="off" ></el-input>
				</el-form-item>
				<!-- <el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="updateForm.giftColor" autocomplete="off" ></el-input>
				</el-form-item> -->
				<el-form-item prop="giftColor" label="赠品颜色:":label-width="formLabelWidth">
					<el-select v-model="updateForm.giftColor"  placeholder="赠品颜色" style="width: 110px;">
						<el-option v-for="item in clors" :label="item.giftColor" :value="item.giftColor"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item prop="giftBrand" label="赠品品牌:":label-width="formLabelWidth">
					<el-select v-model="updateForm.giftBrand"  placeholder="赠品品牌" style="width: 110px;">
						<el-option v-for="brand in brands" :label="brand.giftBrand" :value="brand.giftBrand" ></el-option>
					</el-select>
				</el-form-item>
			
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="updateFormVisible = false ">取 消</el-button>
				<el-button type="primary" @click="updateSubmit() " >确 定</el-button>
				
			</div>
		</el-dialog>
		
		
		<el-dialog title="新增赠品" :visible.sync="addFormVisible" >
			<el-form ref="addForm" :model="addForm" :rules="rules">
				<el-form-item label="赠品名称:" :label-width="formLabelWidth" prop="giftName" >
					<el-input v-model="addForm.giftName" autocomplete="off" ></el-input>
				</el-form-item>
				<!-- <el-form-item label="赠品类型:" :label-width="formLabelWidth" prop="giftType" >
					<el-input v-model="addForm.giftType" autocomplete="off" ></el-input>
				</el-form-item> -->
				<el-form-item prop="giftType" label="赠品类型:">
					<el-select v-model="addForm.giftType"  placeholder="赠品类型" style="width: 110px;">
					
						<el-option v-for="item in types" :label="item.giftType" :value="item.giftType" ></el-option>
					</el-select>
				</el-form-item>
				
				<el-form-item label="赠品型号:" :label-width="formLabelWidth" prop="giftModel">
					<el-input v-model="addForm.giftModel" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="赠品单价:" :label-width="formLabelWidth" prop="giftPrice">
					<el-input v-model="addForm.giftPrice" value="0" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="采购成本:" :label-width="formLabelWidth" prop="giftCost">
					<el-input v-model="addForm.giftCost" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="采购部门:" :label-width="formLabelWidth" prop="giftDepartment">
					<el-input v-model="addForm.giftDepartment" autocomplete="off" ></el-input>
				</el-form-item>
				<el-form-item label="赠品库存:" :label-width="formLabelWidth" prop="giftInventory">
					<el-input v-model="addForm.giftInventory" autocomplete="off" ></el-input>
				</el-form-item>
				<!-- <el-form-item label="赠品颜色:" :label-width="formLabelWidth" prop="giftColor">
					<el-input v-model="addForm.giftColor" autocomplete="off" ></el-input>
				</el-form-item> -->
				<el-form-item prop="giftColor" label="赠品颜色:">
					<el-select v-model="addForm.giftColor"  placeholder="赠品颜色" style="width: 110px;">
						<el-option v-for="item in clors" :label="item.giftColor" :value="item.giftColor"></el-option>
					</el-select>
				</el-form-item>
				<!-- <el-form-item label="赠品品牌:" :label-width="formLabelWidth" prop="giftBrand" >
					<el-input v-model="addForm.giftBrand" autocomplete="off" ></el-input>
				</el-form-item> -->
				<el-form-item prop="giftBrand" label="赠品品牌:">
					<el-select v-model="addForm.giftBrand"  placeholder="赠品品牌" style="width: 110px;" >
						
						<el-option
						      v-for="item in brands"
						      :value="item.giftBrand"
						      :label="item.giftBrand">
						    </el-option>
					</el-select>
				</el-form-item>
			
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="addFormVisible = false ">取 消</el-button>
				<el-button type="danger" @click="addSubmit() " >确 定</el-button>
				<el-button @click="goodsForm()">选择二类商品</el-button>
			</div>
		</el-dialog>
		
		<el-dialog title="选择二类商品" :visible.sync="TowaddFormVisible" style="width: 100%;">
		<el-table  ref="singleTable" :data="TwotableData" highlight-current-row @current-change="handleCurrentChange" style="width: 100%" borde>
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
			<el-table-column property="giftNumber" label="入库数量" width="78"  >	
				<input v-model="testData" style="width: 30px;" />	
			</el-table-column>
			
	<el-table-column  label="操作"   width="300">
		<template slot-scope="scope" >
			<el-button type="primary" @click="notsureSubmit()" >保存草稿</el-button>
			<el-button type="danger" @click="TwoaddSubmit() "  >确 定</el-button>
		</template>
	</el-table-column>
		</el-table>
		<el-pagination @size-change="handleSizeChange1" @current-change="handlePageChange1" :current-page="pageInfo.pageNum"
		 :page-sizes="[5, 10, 15]" :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total">
		</el-pagination>
		<div slot="footer" class="dialog-footer">
			<el-button @click="TowaddFormVisible = false ">取 消</el-button>
			<el-button type="danger" @click="sureSubmit() "  >确 定</el-button>	
		</div>
		</el-dialog>
		<el-pagination @size-change="handleSizeChange" @current-change="handlePageChange" :current-page="PageInfo.pageNum"
		 :page-sizes="[5, 10, 15 ]" :page-size="PageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="PageInfo.total">
		</el-pagination>
	</div>
</template>

<script>
	export default{
		data() {
			return{
				disabled:false,
				testData:undefined,
				formLabelWidth:"200px",
				selectFormVisible:false,
				updateFormVisible:false,
				addFormVisible :false,
				TowaddFormVisible :false,
				radio: '',
				selectForm:{
					
				},
				updateForm:{},
				
				addForm:{
					giftName:'',
					giftType:'',
					giftModel:'',
					giftPrice:'',
					giftCost:'',
					giftDepartment:'',
					giftInventory:'',
					giftColor:'',
					giftBrand:'',
					giftNumber:''
				},
				TwoaddForm:{},
				rules: {
				  giftType: [
				    { required: true, message: '请输入赠品类型', trigger: 'blur' },
				    
				  ],
				  giftColor:[
					  { required: true, message: '请输入赠品颜色', trigger: 'blur' }
				  ],
				  giftBrand:[
				  	 { required: true, message: '请输入赠品品牌', trigger: 'blur' }
				  ],
				},
				selectform:{
					giftModel:"",
					giftBrand:"",
					giftColor:"",
					giftName:"",
					giftType:""
				},
				brands:[],
				clors:[],
				types:[],
				TwotableData:[],
				tableData:[],
				alldepts: [],
				PageInfo:{
					pageNum:1,
					pageSize:3,
					total:100
					},
				pageInfo:{
					pageNum:1,
					pageSize:3,
					total:100
					},
				auditData:{
						"verifyId": 1000,
						"applicant": "lisi",
						"verifyTable": "",
						"verifyTableId": 1625241212429,
						"verifyPerson": "",
						"verifyStatus": 0,
						"verifySuggestion": "",
						"verifyTime": "2021-07-02 23:53:32.0"}	
			}
		},
		methods:{
			sureSubmit(){
				this.selectFormVisible = false;
				this.updateFormVisible=false;
				this.TowaddFormVisible=false;
			},
			handleCurrentChange(val) {
				this.currentRow = val;
			   
			},
			handleCurrentChange1(val){
				this.currentRow = val;
				this.TwoaddSubmit().disabled=false;
				this.notsureSubmit().disabled=false;
			},
			handleSizeChange(val) { //pageSzie发生变化
				this.PageInfo.pageNum = 1;
				
				this.PageInfo.pageSize = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
			},
			handleSizeChange1(val) { //pageSzie发生变化
				this.pageInfo.pageNum = 1;
				
				this.pageInfo.pageSize = val;
				console.log(this.pageInfo.pageSize);
				console.log(`当前页: ${val}`);
				let myparam = this.$qs.stringify(this.pageInfo) ;
			     this.goodsForm(myparam);
			},
			handlePageChange(val) { //翻页
				
				this.PageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.PageInfo) + "&" + this.$qs.stringify(this.selectform);
				this.myquer(myparam);
				
			
			},
			handlePageChange1(val) { //翻页
				
				this.pageInfo.pageNum = val;
				let myparam = this.$qs.stringify(this.pageInfo) ;
				this.goodsForm(myparam);
				
			
			},
			adddata(param){
			this.addFormVisible = true;
			},
			addSubmit(){
				this.addFormVisible = false;
			
				
				if(this.addForm.giftBrand !='' & this.addForm.giftColor !='' &this.addForm.giftType !=''){
				this.$axios.post("gift/add/addGift",this.addForm)
				.then(resp=>{
					if(resp.code==20000){
									
					let myparam=this.$qs.stringify(this.Pageinfo)+"&"+this.$qs.stringify(this.selectform);
					this.myquer(myparam);
					this.addForm={};
									 // this.btnStatus = true;//将按钮状态改为禁用,没有起作用？
					
					this.$message({
								 showClose: true,
								 message: resp.msg,
								type: 'success'
								 });
										 
					}else if(resp.code==50000){
									 // this.$message.error(returnVal.data.returnMsg)
							 this.$message({
							 showClose: true,
							 message: resp.msg,
							 type: 'warning'
								 });
						 }  
				})
				}else{
					this.$message({
					showClose: true,
					message: "赠品类型，赠品颜色，赠品品牌为必填数据",
					type: 'warning'
													 });
				}
		         },
			notsureSubmit(index,row){
					this.addFormVisible = false;
					console.log("ww"+this.testData);
					// debugger;
					// this.TwotableData.giftNumber = this.testData;
					// console.log("获取到数据："+this.TwotableData.giftNumber);
					this.TowaddFormVisible=false;
					this.currentRow.giftNumber= this.testData;
					
					
					this.$axios.post("goodsGift/giftReviewstatus",this.currentRow)
					.then(resp=>{
						if(resp.code==20000){
							this.$message({
								  message: resp.msg,
								  type: 'success'
							});	
							// //刷新 table数据
							let myparam = {...this.PageInfo,...this.selectform};
							this.myquer(this.$qs.stringify(myparam));
							//刷新下拉列表数据
							this.getbrand("");
							this.getclor("");
							this.gettype("");
									   
						}else if(resp.code==50000){
							this.$message.error(resp.msg);
						}
						this.testData=undefined;
					})
				},
			
			goodsForm(param){
				this. TowaddFormVisible =true;
				this.addFormVisible = false;
				this.$axios.get("goodsManager/list/goodsLevel?"+param)
				.then(resp=>{
					
				console.log("二类商品"+resp);
				this.TwotableData=resp.data.list;
				
				this.pageInfo.pageNum=resp.data.pageNum;
				// debugger;
				this.pageInfo.pageSize=resp.data.pageSize;
				this.pageInfo.total=resp.data.total;
				}).catch(err => {
						console.log(err);
					})
				
			},
			TwoaddSubmit(index,row){
				this.TwotableData.giftNumber = this.testData;
				console.log("获取到数据："+this.TwotableData.giftNumber);
				this.TowaddFormVisible=false;
				this.currentRow.giftNumber= this.testData;
				//  1000 只对申请表做操作，2000 两张表操作
				this.auditData.verifyTable="goods_gift";
				this.auditData.verifyId=1000;
				this.auditData.verifyTableId='';
				console.log(this.currentRow.updateBy);
				debugger;
				this.auditData.applicant=this.currentRow.createBy;
				this.auditData.verifyStatus=0;
				this.currentRow.giftReviewstatus=0;
				
						
				let data = Object.assign(this.auditData,this.currentRow);
				this.$axios.post("ver/adds",data)
				// this.$axios.post("goodsGift",this.currentRow)
				.then(resp=>{
					if(resp.code==20000){
						this.$message({
							  message: resp.msg,
							  type: 'success'
						});	
						// //刷新 table数据
						let myparam = {...this.PageInfo,...this.selectform};
						this.myquer(this.$qs.stringify(myparam));
						//刷新下拉列表数据
						this.getbrand("");
						this.getclor("");
						this.gettype("");
								   
					}else if(resp.code==50000){
						this.$message.error(resp.msg);
					}
				})
			},
			// 全部查询
			querydata(){
				let myparam = {...this.PageInfo,...this.selectform};
				 // let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				 this.myquer(this.$qs.stringify(myparam));
			},
			handleSelect(index,row){
			    this.selectFormVisible=true;
				this.selectForm = row;
				// this.selectForm = JSON.parse(JSON.stringify(this.currentRow));
				
				
			},
		
			handleUpdate(index, row) {
				this.updateFormVisible=true;
				// this.selectForm = JSON.parse(JSON.stringify(this.currentRow));
				this.updateForm = row;
				
			},
			updateSubmit(){
				this.updateFormVisible=false;
				this.$axios.put("gift/update",this.updateForm)
				.then(resp=>{
							if(resp.code==20000){
											
							let myparam=this.$qs.stringify(this.Pageinfo)+"&"+this.$qs.stringify(this.selectform);
							this.myquer(myparam);
							this.updateForm={};
											 // this.btnStatus = true;//将按钮状态改为禁用,没有起作用？
							
							this.$message({
										 showClose: true,
										 message: resp.msg,
										type: 'success'
										 });
												 
							}else if(resp.code==50000){
											 // this.$message.error(returnVal.data.returnMsg)
									 this.$message({
									 showClose: true,
									 message: resp.msg,
									 type: 'warning'
										 });
								 }  
				})
				},
			
			handleDelete(index, row) {
				
				
				this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
								 			            confirmButtonText: '确定',
								 			            cancelButtonText: '取消',
								 			            type: 'warning'
								 			  }).then(() => {
								 				//发请求
								 				this.$axios.put("gift/update1",this.currentRow)
								 				.then(resp=>{
								 					console.log(resp);
								 								//给用户提示
								 								if(resp.code==20000){
																	this.$message({
																		  message: resp.msg,
																		  type: 'success'
																	});	
																	// //刷新 table数据
																	let myparam = this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
																	this.myquer(myparam);
																	//刷新下拉列表数据
																	this.getbrand("");
																	this.getclor("");
																	this.gettype("");		   
								 								}else if(resp.code==50000){
								 									this.$message.error(resp.msg);
								 								}
								 								
								 				})
								 				.catch(err=>{
								 					
								 				})
								 			  }).catch(() => {
								 				this.$message({
								 				  type: 'info',
								 				  message: '已取消删除'
								 				});          
								 			  });
											  
			},
			
			myquer(param) { //初始化页面
				this.$axios.get("gift/list?" + param)
					.then(resp => {
						
						this.tableData = resp.data.list;
						
						this.PageInfo.pageNum=resp.data.pageNum;
						this.PageInfo.pageSize=resp.data.pageSize;
						this.PageInfo.total=resp.data.total;
						
					}).catch(err => {
						console.log(err);
					})
			},
			getbrand(param) { //刷新赠品品牌的下拉框
				this.$axios.get("gift/giftBrand?" + param)
					.then(resp => {
						
						this.brands = resp;
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			getclor(param) { //刷新赠品颜色的下拉框
				this.$axios.get("gift/giftColor?" + param)
					.then(resp => {
						
						this.clors = resp;
						
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			gettype(param){//赠品类型下拉框
				this.$axios.get("gift/giftType?" + param)
					.then(resp => {
						
						
						this.types = resp;
						
					})
					.catch(err => {
						console.log(err);
					})
			},
			myreset(fromname) {//重置按钮
				this.$refs['selectform'].resetFields(); //model需要有ref，和对应的prop属性
				
				let myparam=this.$qs.stringify(this.PageInfo)+"&"+this.$qs.stringify(this.selectform);
				this.myquer(myparam);//重置输入框内容后进行页面刷新
				// this.querydata();
				
				
				
			},
		},
		
		mounted() { //钩子函数，进行页面初始化
			this.myquer();
			this.getbrand("");
			this.getclor("");
			this.gettype("");
		},
		
	}
</script>

<style>
</style>
