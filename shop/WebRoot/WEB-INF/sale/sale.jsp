<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
	
	<style type="text/css">
		#menu{
			width:200px;
			
		}
		
		#menu ul{
			list-style: none;
			padding:0px;
			margin: 0px;
		}
		
		#menu ul li{
		 border-bottom: 1px solid #fff;
		}
		#menu ul li a{
			display:block;
			background-color: #008792;
			color: #fff;
			padding:5px;
			text-decoration: none;
		}
		#menu ul li a:hover{
			background-color: #00a6ac;
		}
	</style>
		
  <script type="text/javascript" src="${shop}/jquery-easyui-1.3.5/jquery-1.3.js"></script>
  <script type="text/javascript" src="${shop}/jquery-easyui-1.3.5/jscharts.js"></script>
  <script type="text/javascript">
 $(function(){
			var color=['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531','#CAD857'];
			$("#search").click(function(){
				$.post($("#sale").val(),{number:$("#number").val()},function(data){
					var myChart = new JSChart('chart_container', $("#type").val(),'');
					myChart.setDataArray(data);
					// 设置树状结构颜色值, 通过slice来获取数组部分数据
					myChart.colorize(color.slice(0,data.length));
					// 设置报表尺寸
					myChart.setSize(100*$("#number").val(),200);
					// 是否在柱形上面显示值
					myChart.setBarValues(true);
					// 设置支持3D显示
					myChart.set3D(true);
					// 柱形之间的具体. 1~100之间
					myChart.setBarSpacingRatio(30);
					// 柱形透明度
					myChart.setBarOpacity(1);
					// 柱形边框值
					myChart.setBarBorderWidth(1);
					// 设置报表的标题
					myChart.setTitle('订单销售Top ' + $("#number").val());
					// 设置标题字体大小
					myChart.setTitleFontSize(10);
					// 设置标题字体颜色
					myChart.setTitleColor('#607985');
					// 设置轴的颜色值
					myChart.setAxisValuesColor('#607985');
					// 设置网格的透明度
					myChart.setGridOpacity(0.8);
					// 设置坐标的值
					myChart.setAxisNameX('商品名称',true);
					myChart.setAxisNameY('销量',true);
					// 设置轴的内间距, 可以调整轴与文字的距离
					myChart.setAxisPaddingBottom(50);
					myChart.setAxisPaddingLeft(50);
					myChart.draw();	
				},"json");
			});
		});
	</script>
</head>
<body>
请选择报表的类型：
<select id="sale">
	<option value="sorder_querySale.action">年度销售报表</option>
</select>

查询的数量：
<select id="number">
	<option value="5">5</option>
	<option value="7">7</option>
	<option value="10">10</option>
</select>

类型：
<select id="type">
	<option value="bar">柱状图</option>
	<option value="line">线形图</option>
	<option value="pie">饼图</option>
</select>

<input type="button" id="search" value="查询" />
<div id="chart_container">Loading chart...</div>

</body>
</html>
  