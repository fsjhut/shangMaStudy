<template>
	<el-container>
	  <el-header>公司logo   xxx系统     </el-header>
	  <el-container>
	    <el-aside width="200px">
			<!-- 
			 不同用户 展示不同的菜单
			 动态菜单   用户权限
			 
			 -->
			<el-row class="tac">
			  <el-col :span="24">
			    <el-menu
			      default-active="2"
			      class="el-menu-vertical-demo"
				  :router="true"
			      @open="handleOpen"
			      @close="handleClose"
			      background-color="#545c64"
			      text-color="#fff"
			      active-text-color="#ffd04b">
				  
				  
				  
			      <el-submenu v-for="menu in mymenu" :index="menu.menuid.toString()" :keys="menu.menuid">
			        <template slot="title">
			          <i :class="menu.glyphicon"></i>
			          <span>{{menu.menuname}}</span>
			        </template>
					
			        <el-menu-item v-for=" submenus in menu.submenu" :index="submenus.menuurl">{{submenus.menuname}}</el-menu-item>
					
			      </el-submenu>
				  
				  
				  
			    </el-menu>
			  </el-col>
			</el-row>
			
		</el-aside>
	    <el-main>
			<router-view></router-view>
		</el-main>
	  </el-container>
	</el-container>
</template>

<script>
	export default{
		data(){
			return{
				mymenu:[]
			}
		},
		methods:{
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			  },
			  handleClose(key, keyPath) {
				console.log(key, keyPath);
			  }
		},
		mounted() {
			this.$axios.get("getmenu")
			.then(returnval=>{
				if(returnval.data.returnCode=10000){
					this.mymenu = returnval.data.returnData;
				}
			})
			.catch(err=>{
				
			})
			console.log("vue加载完成了")
		}
	}
</script>

<style>
	html,body,#app{
				  height: 100%;
				  margin: 0px;
				  padding: 0px;
	}
				
	.el-header, .el-footer {
	  background-color: #B3C0D1;
	  color: #333;
	  text-align: center;
	  line-height: 60px;
	}
	
	.el-aside {
	  background-color: #D3DCE6;
	  color: #333;
	  text-align: center;
	  line-height: 200px;
	}
	
	.el-main {
	  background-color: #E9EEF3;
	  color: #333;
	  text-align: center;
	  line-height: 160px;
	}
	
	body > .el-container {
	  margin-bottom: 40px;
	}
	
	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
	  line-height: 260px;
	}
	
	.el-container:nth-child(7) .el-aside {
	  line-height: 320px;
	}
	/* 选择器越复杂优先级越高 */
	body>.el-container{
				  height: 100%;
	}
</style>
