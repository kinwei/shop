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
  lalala
  <div style="width: 750px;">
  	<c:forEach items="${applicationScope.bankList}" var="bankImage">
  		<input type="radio" value="" name="${fn:substring(bankImage,0,fn:indexOf(bankImage,'.')) }">
  		<img src="${shop}/images/bank/${bankImage}" />
  	</c:forEach>  
  </div>
  </body>
</html>
