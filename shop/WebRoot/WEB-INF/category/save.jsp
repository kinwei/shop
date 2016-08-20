<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
	$(function(){
		$("input[name=type]").validatebox({
			required:true,
			missingMessage:'请输入类别名称'
		});
		
		$("#ff").form("disableValidation");
		
		$("#btn").click(function(){
			$("#ff").form("enableValidation");
			//如果验证成功 则提交数据
			if($("#ff").form("validate")){
				$('#ff').form('submit', {
					url:'category_save.action',
					success: function(){
					//如果成功 关闭当前页面 并刷新
					parent.$("#win").window("close");
					var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					}
});
				
			}
		});
		
	});
</script>
  <body>
 <form id="ff" method="post">   
    <div>   
        <label for="type">商品类别</label>   
        <input class="easyui-validatebox" type="text" name="type" />   
    </div>   
    <div>   
        <label for="hot">热点</label>   
       	 热点<input  type="checkbox" name="hot" value="true" />   
                         非热点<input type="checkbox" name="hot" value="false" />
    </div>   
    
    <div>
    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>  
    </div>
     
</form>  
    
  </body>
</html>
