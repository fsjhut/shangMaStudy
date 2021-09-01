<template>
	<div>
		<el-table
		    ref="singleTable"
		    :data="tableData"
		    highlight-current-row
		    @current-change="handleCurrentChange"
		    style="width: 100%">
		    <el-table-column
		      property="menuid"
		      label="菜单编号"
		      width="120">
		    </el-table-column>
		    <el-table-column
		      property="menuname"
		      label="菜单名称"
		      width="120">
		    </el-table-column>
			<el-table-column
			  property="pid"
			  label="上级地址">
			</el-table-column>
			<el-table-column
			  property="pname"
			  label="上级名称">
			</el-table-column>
		    <el-table-column
		      property="menuurl"
		      label="访问地址">
		    </el-table-column>
			<el-table-column
			  property="glyphicon"
			  label="图标">
			  <template slot-scope="abc">
				  <i :class="abc.row.glyphicon"></i> {{abc.row.glyphicon}}
			  </template>
			</el-table-column>
		</el-table>
		<el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :current-page="pageinfo.page"
		      :page-sizes="[10, 20, 30]"
		      :page-size="pageinfo.pagesize"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="pageinfo.total">
		</el-pagination>
	</div>
	
</template>

<script>
	 export default {
	    data() {
	      return {
	        tableData: [],
	        currentRow: null,
			currentPage4:2,
			pageinfo:{
				page:1,
				pagesize:10,
				total:99
			},
	      }
	    },
	
	    methods: {
	      setCurrent(row) {
	        this.$refs.singleTable.setCurrentRow(row);
	      },
	      handleCurrentChange(val) {
	        this.currentRow = val;
	      },
			handleSizeChange(val) {
			  console.log(`每页 ${val} 条`);
			  this.pageinfo.page = 1;
			  this.pageinfo.pagesize = val;
			  
			  this.myquery(this.$qs.stringify(this.pageinfo));
			},
			handleCurrentChange(val) {
			  console.log(`当前页: ${val}`);
			  this.pageinfo.page = val;
			  this.myquery(this.$qs.stringify(this.pageinfo));
			},
			myquery(param){
				//在vue中，不要通过function自己指定函数 直接在methods中定义
				// 通过vue对象，调用函数 this.函数
				this.$axios.get("menu/query?"+param)
				.then(returnval=>{
					console.log(returnval.data);
					this.tableData = returnval.data.returnData;
					this.pageinfo = returnval.data.pageinfo;
				})
				.catch(err=>{
					
				})
			}
		},
		mounted(){
			this.myquery("");
		}
	  }
</script>

<style>
	.el-main{
		line-height: 30px;
	}
</style>
