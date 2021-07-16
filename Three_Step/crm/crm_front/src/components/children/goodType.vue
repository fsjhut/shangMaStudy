<template>
	<div class="mydiv">
		<template>
			
			<el-row>

				<el-form :inline="true" :model="formInline" class="demo-form-inline">
					<el-col :span="12">
						<el-form-item label="商品类型">
							<el-input v-model="formInline.typeDesc" placeholder="商品类型"></el-input>

						</el-form-item>
					</el-col>
					<!-- <el-col :span="6"> -->
					<el-form-item>
						<template slot-scope="scopetype">
							<el-button type="primary" @click="myquery">查询</el-button>
						</template>
					</el-form-item>
					<!-- </el-row> -->
					<el-col :span="3">
						<el-button type="primary2" plain :disabled="mybtnstatus" @click="addFormOpen()"> 新增类型</el-button>
					</el-col>
				</el-form>
			</el-row>

			<el-row>
				<el-tree style="width: 30%;float: left;" @current-change="handleTreechange" default-expand-all class="filter-tree" :data="treeData" :props="defaultProps"
				 :tree-props="{children: 'children'}" ref="tree">
				</el-tree>

				<el-table :data="tableData" :row-class-name="tableRowClassName" @current-change="handleRowchange" style="float: right;width: 70%;border:3px solid black;margin-bottom: 20px;"
				 row-key="tid" border :tree-props="{children: 'children'}">
					<el-table-column prop="typeName" label="商品类型" style="border: 5px solid black; width: 30%;">
					</el-table-column>
					<el-table-column prop="typeDesc" label="类型介绍" style="border: 5px solid black; width: 30%;">
					</el-table-column>
					<el-table-column label="操作">
						<template slot-scope="scope">

							<el-button type="primary" plain :disabled="btnstatus" @click="buyFormOpen"> 选择商品品牌</el-button>
							<el-button type="warning" :disabled="btnstatus" @click="editFormOpen">修改</el-button>
							<el-button type="danger" :disabled="btnstatus" @click="delFormOpen">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
			</el-row>


			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageinfo.page"
			 :page-sizes="[5, 10, 20]" :page-size="pageinfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageinfo.total">
			</el-pagination>







			<!-- <el-dialog title="添加品牌" :visible.sync="dialogBrandVisible">
				<el-row :gutter="20">
				  <el-col :span="9">
						<el-select :v-model="form" class="mysel" >
							<el-option v-for="item in brandNames" :value="item.brandName" :label="item.brandName">
							</el-option>
						</el-select>
					</el-col>
				  <el-col :span="4">
					  <div class="btns">
									<input id="addone" type="button" value=">" /><br />
									<input id="addall" type="button" value=">>>" /><br />
									<input id="removeone" type="button" value="<" /><br />
									<input id="removeall" type="button" value="<<<" /><br />
						</div>
					</el-col> 
					   <el-col :span="6">
					  <el-form-item label="已选择商品品牌：" >
						<el-select v-model="choseForm" class="mysel" >
							<el-option v-for="item in brandNames" :value="item.brandName" :label="item.brandName">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col> 
				</el-row>
				<div slot="footer" class="dialog-footer">
					<el-button @click="dialogBrandVisible = false">取 消</el-button>
					<el-button type="primary" @click="dialogBrandVisible = false">确 定</el-button>
				</div>
			</el-dialog> -->

			<el-dialog title="选用品牌" :visible.sync="buyFormVisible">
			<el-form ref="buyform" :model="editform">
				<el-transfer v-model="relationBuy" :data="data" :button-texts="['可选', '已选']">
				</el-transfer>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="buyFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="buySubmit()">确 定</el-button>
			</div>
		</el-dialog>


			<el-dialog title="新增类型"  :visible.sync="dialogForm">
				<el-form :model="typeform" >
					<el-form-item label="新增商品类型名称" :label-width="formLabelWidth">
						<el-input v-model="typeform.typeName" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="新增商品类型描述" :label-width="formLabelWidth">
						<el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="typeform.typeDesc" autocomplete="off">
						</el-input>
					</el-form-item>
					<el-form-item label="商品类型" :label-width="formLabelWidth">
						<el-input type="textarea" :rows="4" :disabled="true" v-model="typeform.parentName" autocomplete="off">
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
					<el-form-item label="商品类型名称" :label-width="formLabelWidth" prop="menuid">
						<el-input v-model="editFrom.typeName" :disabled="false" autocomplete="off"></el-input>
					</el-form-item>
					<el-form-item label="商品类型描述" :label-width="formLabelWidth" prop="menuid">
						<el-input type="textarea" v-model="editFrom.typeDesc" :disabled="false" autocomplete="off"></el-input>
					</el-form-item>
				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button @click="editFormVisible = false">取 消</el-button>
					<el-button type="primary" @click="editSubmit()">确 定</el-button>
				</div>
			</el-dialog>


		</template>
	</div>


</template>

<script>
	export default {
		data() {
			const generateData = _ => {
				const data = [];
				const recomends = ['华为', '解放', '小米', 'iphone'];
				recomends.forEach((recomend, index) => {
					data.push({
						label: recomend,
						key: index,
					});
				});
				return data;
			};
			return {
				
				buyFormVisible: false,
				data: generateData(),
				relationBuy: [],
				editBrand: {
					typeId:'',
					typeBrand:'',
				},
				
				
				treeData: [],
				tableData: [],
				pageinfo: {
					pageNum: 1,
					pageSize: 5,
					total: 10
				},
				formInline: {
					typeDesc: ''
				},
				defaultProps: {
					children: 'children',
					label: 'typeDesc',
					label: 'typeName'
				
				},
				dialogFormVisible: false,
				dialogBrandVisible:false,
				dialogForm: false,
				rowindex: '',
				
				form: {
					brandId:'',
					brandName:'',
					brandUrl:'',
					brandDesc:''
				},
				choseForm: {
					brandId:'',
					brandName:'',
					brandUrl:'',
					brandDesc:''
				},
				typeform: {
					
					typeName: '',
					typeDesc: '',
					parentName:'',
					pid:''
				},
				formLabelWidth: '120px',
				editFrom: {
					tid:'',
					typeName: '',
					typeDesc: ''
				},
				editform: {
					tid:'',
					typeName: '',
					typeDesc: ''
				},
				editFormVisible: false,
				btnstatus: true,
				mybtnstatus:true,
				brandNames:[]
			}
		},
		methods: {
			buyFormOpen() {
				this.buyFormVisible = true;
				this.$nextTick(function() {
					this.$refs['buyform'].resetFields();
				});
				// this.$axios.get("typeManage/" + this.editform.tid)
				// 	.then(returnval => {
				// 		this.relationBuy = returnval.data.data;
				// 	})
				// 	.catch(err => {
				// 		console.log(err)
				// 	})
			},
			// 关联申购
			buySubmit() {
				this.buyFormVisible = false;
				this.editBrand.typeBrand=this.relationBuy.toString();
				this.editBrand.typeId=this.editform.tid;
				console.log(this.editBrand)
				this.$message({
					message: returnval.data.returnMsg,
					type: 'success'
				});
				// this.$axios.put("typeManage",this.editBrand)
				// 	.then(returnval => {
						
				// 		// 提示
				// 		if (returnval.data.code == 200) {
				// 				this.$message({
				// 					message: returnval.data.returnMsg,
				// 					type: 'success'
				// 				});
				// 		} else if (returnval.data.code == 201) {
				// 			// 失败提示信息
				// 			this.$message.error(returnval.data.returnMsg);
				// 		}
				// 	})
				// 	.catch(err => {
				// 		console.log(err)
				// 	})
			},
			handleTreechange(val) {
				this.mybtnstatus = false;
				console.log("tree 触发了");
				
				
				this.typeform.parentName=val.typeName;
				this.typeform.pid=val.tid;
				
				this.$axios.get("goodType/selectList/" +val.tid+this.$qs.stringify(this.pageinfo))
					.then(resp => {
						console.log(resp.data)
						
						this.tableData = resp.data.list;
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			},
			handleRowchange(val) {
				this.btnstatus = false;
				console.log("rowchange 触发了");
				this.currentRow=val
				
				// this.editFrom.typeName=val.typeName
				// this.editFrom.typeDesc=val.typeDesc
				/* 
				 js中 深克隆json对象
				 JSON.parse(JSON.stringify(this.currentRow)) 
				 */
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
				let param = this.$qs.stringify(this.formInline) + "&" + this.$qs.stringify(this.pageinfo);
				this.queryList(param); //刷新页数
				
			},
			//page改变
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.pageinfo.pageNum = val;
				let param = this.$qs.stringify(this.formInline) + "&" + this.$qs.stringify(this.pageinfo);
				console.log("111" + param)
				this.queryList(param); //刷新页数
			},
			//染色
			tableRowClassName({
				row,
				rowIndex
			}) {
				if (rowIndex % 2 === 0) {
					return 'warning-row';
				} else if (rowIndex % 2 !== 3) {
					return 'success-row';
				}
				return '';
			},
			handleNodeClick(data) {},
			
			//查询表格内容
			queryList() {
				this.$axios.get("goodType/list?" + this.$qs.stringify(this.formInline) + "&" + this.$qs.stringify(this.pageinfo))
					.then(resp => {
						this.tableData = resp.data.list;
						this.pageinfo.pageNum = resp.data.pageNum;
						this.pageinfo.pageSize = resp.data.pageSize;
						this.pageinfo.total = resp.data.total;
					}).catch(function(err) {
						console.log(err)
					})
			},
			//商品品牌
			choseBrand(){
				this.dialogBrandVisible=true;
				this.$axios.get("brandManager/list")
					.then(resp => {
						this.brandNames=resp.data.list;
						this.form = resp.data.list;
						console.log('看我下面')
						console.log(this.form)
					}).catch(function(err) {
						console.log(err)
					})
			},
			addFormOpen() {
				this.dialogForm = true;
			},
			addSubmit() {
				this.dialogForm = false;
				this.mybtnstatus = true;
				this.$axios.post("goodType", this.typeform)
					.then(returnval => {
						this.typeform.typeName='';
						this.typeform.typeDesc='';
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
			
						//刷新数数据
						this.gettree();
					})
					.catch(err => {
			
					})
					
			},
			//修改
			editFormOpen() {
				this.editFormVisible = true;
				
			},
			editSubmit() {
				this.editFormVisible = false;
				
				this.$axios.put("goodType", this.editFrom)
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

						//刷新数数据
						this.gettree();
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
					console.log(1)
					this.$axios.delete("goodType/id/" + this.currentRow.tid)
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
							//刷新下拉列表数据
							this.gettree();
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
			myquery() {
				var param = this.formInline.typeDesc
				if (param == undefined) {
					param = "";
				}

				this.getlist(param);
			},
			gettree() {

				this.$axios.get("goodType/tree")
					.then(resp => {
						if (resp.code == 20000) {
							this.treeData = resp.data;
						}
					})
			},
			getlist(param) {
				this.$axios.get("goodType/selectByType/" + param)
					.then(resp => {
				
						if (resp.code == 20000) {
							this.tableData = resp.data.list;
							this.pageinfo.pageNum = resp.data.pageNum;
							this.pageinfo.pageSize = resp.data.pageSize;
							this.pageinfo.total = resp.data.total;
						}
					})
			}

		},
		mounted() {
			this.gettree();
			this.queryList();
		}
	}
</script>

<style>
	.el-table .warning-row {
		background: oldlace;
	}

	.el-table .success-row {
		background: #aaffff;
	}

	.mydiv {
		margin: 0px;
		padding: 0px;
		height: 100%;
	}
	.mysel{
					width: 150px;
					height: 300px;
				}
</style>
