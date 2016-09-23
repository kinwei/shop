<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><!doctype html><html><head><meta charset="UTF-8"><title>详情页</title><link type="text/css" rel="stylesheet" href="style/reset.css"><link type="text/css" rel="stylesheet" href="style/main.css"><link type="text/css" rel="stylesheet" href="style/detail.css"><%@include file="/public/head.jspf"%></head>	<body class="grey">	<div class="headerBat">    	<div class="topBar">        	<div class="comWidth">            	<div class="leftArea">            		<a href="#" class="collection">收藏商城</a>                </div>                <div class="rightArea">                <c:choose>                <c:when test="${sessionScope.user == null}">                	欢迎来到慕课网 <a href="login.jsp">[登录]</a>                    <a href="register.jsp">[注册]</a>                 </c:when>                 <c:otherwise>                 	欢迎${sessionScope.user.name}来到慕课网                 	<a href="UserAction_logout.action">安全退出</a>                 </c:otherwise>                 </c:choose>                </div>            </div>        </div>                <div class="logoBar">        	<div class="comWidth">            	<div class="logo fl">                	<a href="./index3.jsp"><img src="./images/logo.jpg" alt="shop"></a>                </div>                <div class="search_box fl">                	<input type="text" class="search_text fl" >                    <input type="button" value="搜 索" class="search_btn fr">                </div>                <div class="shopCar fr">                	<span class="shopText fl">购物车</span>                    <span class="shopNum fl">0</span>                </div>            </div>        </div>        <div class="navBox">        	<div class="comWidth">            	<div class="shopClass fl">                	<h3>全部商品分类<i></i></h3>                    <!--暂缺列表-->                    <div class="showClass_show hide" >                    	<dl class="shopClass_item">                        	<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>                            <dd><a href="#">荣耀3X</a><a href="#">单反</a><a href="#">智能设备</a></dd>                        </dl>                           					<dl class="shopClass_item" >                        	<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>                            <dd><a href="#">荣耀3X</a><a href="#">单反</a><a href="#">智能设备</a></dd>                        </dl>                                                <dl class="shopClass_item">                        	<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>                            <dd><a href="#">荣耀3X</a><a href="#">单反</a><a href="#">智能设备</a></dd>                        </dl>                                                <dl class="shopClass_item">                        	<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>                            <dd><a href="#">荣耀3X</a><a href="#">单反</a><a href="#">智能设备</a></dd>                        </dl>                                            	<dl class="shopClass_item">                        	<dt><a href="#" class="b">手机</a> <a href="#" class="b">数码</a> <a href="#" class="aLink">合约机</a></dt>                            <dd><a href="#">荣耀3X</a><a href="#">单反</a><a href="#">智能设备</a></dd>                        </dl>                    </div>                                      	<div class="shopClass_list hide" >                       <div class="shopClass_cont">                    	 <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a>                            </dd>                         </div>                                                   <div class="shopList_item ">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a>                            </dd>                         </div>                                                   <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a><a href="#">平板电脑</a>                            </dd>                         </div>                                                  <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a><a href="#">平板电脑</a>                            </dd>                         </div>                                                  <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a>                            </dd>                         </div>                                                  <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a>                            </dd>                         </div>                                                  <div class="shopList_item">                        	<dt>电脑装机</dt>                            <dd>                                <a href="#">笔记本</a><a href="#">上网本</a> <a href="#">超级本</a> <a href="#">台式电脑</a> <a href="#">平板电脑</a>                            </dd>                         </div>                                                  <div class="shopList_links">                         	<a href="#">测试内容啊啊<span></span></a>                            <a href="#">测试内容啊啊<span></span></a>                         </div>                                             	</div>                    </div>                                   </div>                            <ul class="nav fl">                      <li><a href="#" class="active">数码城</a></li>                      <li><a href="#">天黑黑</a></li>                      <li><a href="#">团购</a></li>                      <li><a href="#">发现</a></li>                      <li><a href="#">二手特卖</a></li>                      <li><a href="#">名品会</a></li>                 </ul>            </div>        </div>            </div>    <div class="userPosition comWidth">    	<strong><a href="#">首页</a></strong>    	<span>&nbsp;&gt;&nbsp;</span>        <a href="#">平板电脑</a>        <span>&nbsp;&gt;&nbsp;</span>        <em>电脑</em>    </div>    <div class="description comWidth">    	<div class="description_child clearfix">            <div class="leftArea">                <div class="description_imgs">                	<div class="des_big_img">                    	<img  src="${shop}/image/${product.pic}" alt="">                    </div>                    <ul class="des_sm_img clearfix">                    	<li><a href="#"><img src="images/shopImg/iPad_sm01.jpg"  class="active" alt="" /></a></li>                        <li><a href="#"><img src="images/shopImg/iPad_sm01.jpg" alt="" /></a></li>                        <li><a href="#"><img src="images/shopImg/iPad_sm02.jpg" alt="" /></a></li>                        <li><a href="#"><img src="images/shopImg/iPad_sm03.jpg" alt="" /></a></li>                        <li><a href="#"><img src="images/shopImg/iPad_sm04.jpg" alt="" /></a></li>                    </ul>                </div>            </div>            <div class="rightArea">                <div class="des_content">                	<h3 class="des_content_title">${product.name}</h3>                    <div class="dl clearfix">                    	<div class="dt">价格</div>                        <div class="dd"><span class="des_money"><em>￥</em>${product.price}</span></div>                    </div>                     <div class="dl clearfix">                    	<div class="dt">优惠</div>                        <div class="dd"><i class="hg_icon"></i><span class="hg">够iPad送对象咯</span></div>                    </div>                    <div class="des_position clearfix">                    	 <div class="dl clearfix">                    	<div class="dt">送到</div>                        <div class="dd">                        	<div  class="select">                            	<h3>山东省</h3><span></span>                                <ul class="show_select">                                	<li>济南市</li>                                    <li>青岛市</li>                                    <li>聊城市</li>                                </ul>                            </div>                            <span class="theGoods">有货，可当日出货</span>                        </div>                        </div>                                                <div class="dl clearfix">                        	<div class="dt colorSelect">选择颜色</div>                            <div class="dd clearfix">                            	<div class="des_item des_item_active">                                	WIFI 16GB                                </div>                                <div class="des_item">                                	WIFI 16GB                                </div>                                <div class="des_item">                                	WIFI 16GB                                </div>                            </div>                        </div>                         <div class="dl clearfix">                        	<div class="dt des_more">版本</div>                            <div class="dd clearfix">                            	<div class="des_item des_item_sm des_item_active">                                	WIFI 16GB                                </div>                                <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                 <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                 <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                 <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                                <div class="des_item des_item_sm">                                	WIFI 16GB                                </div>                            </div>                        </div>                    	<div class="dl">                        	<div class="dt">数量</div>                            <div class="dd clearfix">                                <div class="des_num">                                    <div class="reduction"></div>                                    <div class="des_input">                                        <input type="text" />                                    </div>                                    <div class="plus"></div>                                </div>                                <span class="xg">限购<em>10</em>件</span>                            </div>                        </div>                    </div>                    <div class="des_select">                    	已选择<span>“白色|WIFI”</span>                    </div>                    <div class="shop_buy">                    	<a href="${shop}/sorder_addSorder.action?product.id=${product.id}" class="shopping_btn"></a>                        <span class="line"></span>                        <a href="" class="buy_btn"></a>                    </div>                </div>            </div>        </div>    </div>        <div class="footer">    	<p></p>        <p></p>        <p><a href="#">慕课简介</a> <i>|</i> <a href="#">慕课公告</a><i>|</i><a href="#">招纳贤士</a><i>|</i> <a href="#">联系我们</a><i>|</i> <a href="#">tel：13203168780</a> </p>        <p>blablablablablablablablablablablablablablablablablablablabla</p>            </div></body></html>