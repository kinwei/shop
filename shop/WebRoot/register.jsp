<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%><!doctype html><html><head><meta charset="utf-8"><title>注册</title><link type="text/css" rel="stylesheet" href="style/reset.css"><link type="text/css" rel="stylesheet" href="style/main2.css"><link type="text/css" rel="stylesheet" href="style/main.css"><link type="text/css" rel="stylesheet" href="style/register.css"><%@include file="/public/head.jspf"%><script type="text/javascript">		$(function(){			$("#login").focusout(function(){				var login = $(this).val();				$.post('user_queryByLoginName.action',{login:login},function(bol){						if(bol == "true"){							$(".hinder").html("已被占用");						}else{							$(".hinder").html("");						}					},"text");			});			});	</script><!--[if IE 6]><script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script><script type="text/javascript" src="js/ie6Fixpng.js"></script><![endif]--></head><body><div class="headerBar">	<div class="logoBar reg_logo">		<div class="comWidth">			<div class="logo fl">				<a href="#"><img src="images/logo.jpg" alt="慕课网"></a>			</div>			<h3 class="welcome_title">欢迎注册</h3>		</div>	</div></div><form action="user_add.action" method="post"><div class="regBox">	<div class="login_cont">		<ul class="login">						<li><span class="reg_item"><i>*</i>用户名</span><div class="input_item"><input name="login" type="text" class="login_input" id="login"></div><span class="hinder"></span></li>            <li><span class="reg_item"><i>*</i>密码</span><div class="input_item"><input name="pass" type="password" class="login_input"></div></li>            <li><span class="reg_item"><i>*</i>确认密码</span><div class="input_item"><input type="password" class="login_input"></div></li>            <li><span class="reg_item"><i>*</i>姓名</span><div class="input_item"><input name="name" type="text" class="login_input "></div></li>            <li><span class="reg_item"><i>*</i>电话</span><div class="input_item"><input name="phone" type="text" class="login_input "></div></li>            <li><span class="reg_item"><i>*</i>邮箱</span><div class="input_item"><input name="email" type="text" class="login_input "></div></li>            <li><span class="reg_item"><i>*</i>性别</span><div class="input_item"><label><input name="sex" type="radio" value="男" />男</label> 																				<label><input name="sex" type="radio" value="女" />女 </label> </div></li>						<li><input type="submit" value="" class="login_btn"></li>		</ul>	</div>	</div></form><div class="hr_25"></div><div class="footer">    	<p></p>        <p></p>        <p><a href="#">地摊简介</a> <i>|</i> <a href="#">地摊公告</a><i>|</i> <a href="#">联系我</a><i>|</i> <a href="#">tel：17308416757</a> </p>        <p>blablablablablablablablablablablablablablablablablablablabla</p>            </div></body></html>