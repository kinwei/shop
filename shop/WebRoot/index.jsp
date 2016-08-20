<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<%@ include file="/public/head.jspf"%>
  </head>
  
  <body>
      <a href="send_main_aindex.action">跳转UI界面</a>
      <table width="700" border="1">
<!--大循环开始-->
	<c:forEach items="${applicationScope.bigList}" var="list">
    <tr>
       <td>
       		<table width="100%" border="1">
                <tr>
                <!--小循环开始-->
                <c:forEach items="${list }" var="product">
                  <td>
                  	<!--显示商品信息-->
                    <table width="100%" border="1">
                        <tr>
                          <td>
                          	<!--商品图片-->
                          <img src="${shop}/image/${product.pic}" />
                          </td>
                        </tr>
                        <tr>
                          <td>
                          <!--商品名称-->
                          商品名称：${product.name }
                          </td>
                        </tr>
                        <tr>
                          <td>
                          <!--商品价格-->
                          商品价格：${product.price }
                          </td>
                        </tr>
                  </table>
                  <!-- 商品信息结束 --> 
                  </td>
                 <!--小循环结束-->
                 </c:forEach>
                  </tr>
            </table>
       </td>
    </tr>
    <!--大循环结束-->
    </c:forEach>
   </table>
      
  </body>
</html>
