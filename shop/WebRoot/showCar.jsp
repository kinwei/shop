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
		
  </head>
  
  <body>
  	购物车显示页面
  	  
  	
  	<table>
  		<tr>
  			<td>编号</td>
  			<td>商品名称</td>
  			<td>商品单价</td>
  			<td>数量</td>
  			<td>小计</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach items="${sessionScope.forder.sorderSet}" var="sorder" varStatus="num">
  		<tr>
  			<td>${num.count }</td>
  			<td>${sorder.name}</td>
  			<td>${sorder.price }</td>
  			<td><input type="text" value="${sorder.number }" /></td>
  			<td>${sorder.price * sorder.number }</td>
  			<td>操作</td>
  		</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="6">总价格：${sessionScope.forder.total }</td>
  		</tr>
  	</table> 
  </body>
</html>
