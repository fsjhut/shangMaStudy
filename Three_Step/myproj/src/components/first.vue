<template>
	<div>
		<div class="mydiv" >
			活动总参与人数&ensp;<el-tag type="success">本月</el-tag>
			<br>
			500
			</div>
		<div class="mydiv1">今日活动报名数&ensp;<el-tag type="success">本月</el-tag>
		<br>50</div><br />
		<div id="main" style="width: 600px;height:400px; display: inline-block"></div>
		<div id="main1" style="width: 600px;height:400px;  display: inline-block"></div>
	</div>
</template>

<script>
	export default {
		name: 'Echarts',
		data() {
			return {

			};
		},
		mounted() {
			this.myEcharts();
			this.myEcharts1();
		},

		methods: {

			myEcharts() {

				// 基于准备好的dom，初始化echarts实例
				var myChart = this.$echarts.init(document.getElementById('main'));

				// 指定图表的配置项和数据
				var option = {
					title: {
						text: '活动报名人数总量'
					},



					series: [{
						name: '访问来源',
						type: 'pie',
						radius: '45%',
						data: [{
								value: 50,
								name: '活动1'
							},
							{
								value: 60,
								name: '活动2'
							},
							{
								value: 100,
								name: '活动3'
							},
							{
								value: 140,
								name: '活动4'
							},
							{
								value: 150,
								name: '活动5'
							}
						]
					}]
				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);

			},

			myEcharts1() {
				var myChart1 = this.$echarts.init(document.getElementById('main1'));
				var option1 = {
					title: {
						text: '最近30天活动报名人数'
					},
					xAxis: {
						type: 'category',
						data: ['活动1', '活动2', '活动3', '活动4', '活动5']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						data: [50,60,100, 140, 150],
						type: 'bar'
					}]
				};
				myChart1.setOption(option1);


			}

		},
	};
</script>

<style>
	.mydiv{
		border: 1px solid black;
		width: 300px;
		height: 100px;
		margin-top: 50px;
		margin-left: 50px;
		margin-bottom: 100px;
		border-radius: 4px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
		display: inline-block;
		text-align: center;
	}
	.mydiv1{
		border: 1px solid black;
		width: 300px;
		height: 100px;
		margin-top: 50px;
		margin-left: 100px;
		margin-bottom: 100px;
		border-radius: 4px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
		display: inline-block;
		text-align: center;
	}
</style>
