<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
	$(function(){
		var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
		
		
		//对管理员的下拉列表进行回显
		$('#cc').combobox({    
		    url:'account_query.action',    
		    valueField:'id',    
		    textField:'login',
		    panelHeight:'auto',
		    editable:false
		});  
		
		var rows=dg.datagrid("getSelections");
		$('#ff').form('load',{
			id:rows[0].id,
			type:rows[0].type,
			hot:rows[0].hot,
			'account.id':rows[0].account.id
		});

		
	
	
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
					url:'category_update.action',
					success: function(){
					//如果成功 关闭当前页面 并刷新
					parent.$("#win").window("close");
					dg.datagrid("reload");
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
    
    所属管理员 <input id="cc" name="account.id" value=" " />  
  <!--   <label for="type">商品类别管理员</label>   
        <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
		    <option value="aa">aitem1</option>   
		    <option>bitem2</option>   
		    <option>bitem3</option>   
		    <option>ditem4</option>   
		    <option>eitem5</option>   
		</select>   -->
 
    <div>
    <input type="hidden" name="id" />
    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新类别</a>  
    </div>
     
</form>  
    
  </body>
</html>
