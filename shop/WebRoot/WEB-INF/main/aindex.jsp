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
	<script type="text/javascript">
		$(function(){
			$("a[title]").click(function(){
				var text=$(this).text();
				var href=$(this).attr("title");
				
				if($("#tt").tabs("exists",text)){
					$("#tt").tabs("select",text);
				}else{
					$("#tt").tabs("add",{
						title:text,
						closable:true,
						content:'<iframe title=' + text + ' src='+ href +' frameborder="0" width="100%" height="100%" />'
						//href:'send_category_query.action'
					});
				}
				
			});
		});
	</script>
  </head>

<body class="easyui-layout">   
    <div data-options="region:'north',title:'欢迎欢迎！',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'west',title:'系統操作',split:true" style="width:200px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">   
   			 <div title="基本操作">      
  				<ul>
  					<li><a href="#" title="send_category_query.action">类别管理</a></li>
  					<li><a href="#" title="send_product_query.action">商品管理</a></li>
  		
 				</ul>
  			</div>       
    		
    		<div title="其他操作">   
       			<ul>
  					<li><a href="#">类别管理</a></li>
  					<li><a href="#">商品管理</a></li>
  		
 				</ul>   
   			 </div>   
    		<div title="Title3">   
        content3    
   		 	</div>   
		</div>   	
    </div>   
    <div data-options="region:'center',title:'后台操作'" style="padding:1px;background:#fff;">
    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
    <div title="系统缺省页面" style="padding:10px;">   
       显示系统相应信息   
    </div>   
    
</div>  
    	
    </div>
     <div id="win" style="width:400px;height:300px"   
        data-options="collapsible:true,closable:true,maximizable:true,modal:true"> </div>   
</body>

</html>
