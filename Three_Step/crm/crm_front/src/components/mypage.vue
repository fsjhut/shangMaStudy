<template>
	<el-container>
		<el-header> <strong>后台管理系统</strong></el-header>
		<el-container>
			<el-aside width="200px">

				<el-menu class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" background-color="#545c64"
				 text-color="#fff" active-text-color="#ffd04b" unique-opened :router="true">
						<template v-for="(menu,indexo) in menus">
							<el-submenu :index="menu.menuId.toString()" :key="menu.menuId" v-if="menu.submenu!=0">
								<template slot="title">
									<i :class="menu.glyphicon"></i>
									<span>{{menu.menuName}}</span>
								</template>
								
								<el-submenu v-for="(sub,index) in menu.submenu" :key="sub.menuId" :index="sub.menuId.toString()" v-if="sub.submenu!=0">
									<template slot="title">
										<i :class="sub.glyphicon"></i>
										<span>{{sub.menuName}}</span>
									</template>
									<!-- <el-menu-item :index="sub.menuUrl">{{sub.menuName}}</el-menu-item> -->
									<el-menu-item-group v-for="(item,index) in sub.submenu" :key="item.menuId">
										<el-menu-item :index="item.menuUrl">{{item.menuName}}</el-menu-item>
									</el-menu-item-group>
								</el-submenu>
								<el-menu-item v-else :index="sub.menuUrl" :key="sub.menuId"><span slot="title">{{sub.menuName}}</span></el-menu-item>
									<!-- <el-menu-item v-for="itemChild_Child in sub.submenu" :index="itemChild_Child .menuUrl" :key="itemChild_Child.menuId">
									<i :class="itemChild_Child.icon"></i><span slot="title">{{itemChild_Child.menuName}}</span></el-menu-item>-->
							</el-submenu>
							 <el-menu-item v-else :index="menu.menuUrl" :key="menu.menuId"><span slot="title">{{menu.menuName}}</span></el-menu-item>
						</template>
						
				</el-menu>

			</el-aside>
			<el-container>
				<el-main>
					<router-view></router-view>
				</el-main>
			</el-container>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
				isCollapse: true,
				tableData: "",
				search: '',
				
				menus: [{
						menuName: "系统管理",
						menuId: "11",
						submenu: [{
							menuName: "用户管理",
							menuId: "11001"
						}, {
							menuName: "部门管理",
							menuId: "11002",
							menuUrl: "/dept"
						},{
							menuName: "角色管理",
							menuId: "11003"
						},{
							menuName: "权限管理",
							menuId: "11004"
						}]
					}]
			}
		},
		methods: {
			handleOpen(key, keyPath) {
			},
			handleClose(key, keyPath) {
			},
			getmenu(){
				this.$axios.get("menu/tree")
				.then(resp=>{
					console.log(resp);
					if(resp.code==20000){
						this.menus=resp.data.list;
					}
				})
			}
		},
		mounted() {
			this.getmenu();
		}
	}
</script>

<style>
	element.style {
	    padding-left: 0px;
	    
	}
	.el-menu {
		
		height: 100%;
	}

	.el-menu-vertical-demo:not(.el-menu--collapse) {
		width: 200px;
		
		min-height: 400px;
	}

	html,
	body {
		
		height: 100%;
		margin: 0px;
	}

	

	.el-aside {
		/* background-color: #D3DCE6; */
		/* color: #333; */
		text-align: center;
		
		line-height: 200px;
	}


	body>.el-container {
		margin-bottom: 40px;
	}

	.el-container {
		height: 100%;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
	
		line-height: 320px;
	}
</style>
