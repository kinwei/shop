<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>

<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({    
    	url:'category_queryJoinAccount.action',
    	striped:true,
    	queryParams:{type:''},
    	loadMsg:'请等待。。。',
    	fitColumns:true,
    	pagination:true,
    	
    	toolbar: [{
		iconCls: 'icon-add',
		text:"添加类别",
		handler: function(){
			parent.$("#win").window({
				title:'添加类别',
				content:'<iframe src="send_category_save.action" frameborder="0" width="100%" height="100%" />'
			});
		}
	},'-',{
		iconCls: 'icon-edit',
		text:"更新类别",
		handler: function(){
			var rows=$("#dg").datagrid("getSelections");
			if(rows.length != 1){
				$.messager.show({
					title:'错误信息',
					msg:'一次只能更新一条记录',
					timeout:5000,
					showType:'slide'
					});
			}else{
				//1.弹出更新页面
			parent.$("#win").window({
				title:'更新类别',
				content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%" />'
			});
			}
		}
	},'-',{
		iconCls: 'icon-remove',
		text:"删除类别",
		handler: function(){
			var rows=$("#dg").datagrid("getSelections");
			if(rows.length == 0){
				$.messager.show({
					title:'错误信息',
					msg:'至少选中一行',
					timeout:5000,
					showType:'slide'
					});
					}else{
				$.messager.confirm('删除确认对话框', '确认删除', function(r){
				if (r){
	   					var ids="";
	   					for(i=0;i<rows.length;i++){
	   						ids += rows[i].id + ",";
	   					}
	   					ids = ids.substring(0,ids.lastIndexOf(","));
	   					//发送ajax请求
	   					$.post("category_deleteByIds.action",{ids:ids},function(result){
	   						if(result == "true"){
	   							
	   							$("#dg").datagrid("reload");
	   							$("#dg").dategrid("uncheckAll");
	   						}else{
	   							$.messager.show({
									title:'删除异常',
									msg:'删除失败',
									timeout:5000,
									showType:'slide'
									});
	   						}
	   					},"text");
					}
});}
		}
	},'-',{
		
		text:"<input id='ss' />",
		
	}],
    	
    	
    	frozenColumns:[[
    	{field:'xxx',checkbox:true},
    	{field:'id',title:'商品编号',width:100}
    	]],    
   	 columns:[[      
        {field:'type',title:'商品类别',width:100},    
        {field:'hot',title:'商品热点',width:100,align:'right',
        formatter:function(value,row,index){
        	if(value==true){
        		return "<input type='checkbox' checked='true' disabled='disabled'/>";
        	}else{
        		return "<input type='checkbox' disabled='disabled'/>";
        		}
        }
        },    
        {field:'aid',title:'商品管理员',width:100,align:'right',
        formatter:function(value,row,index){
        	if(row.account!=null && row.account.login!=null){
        		return row.account.login;
        	}else{
        	return "x";
        	}
        }
        }    
    ]]    
});  
		$('#ss').searchbox({ 
			searcher:function(value,name){ 
				$('#dg').datagrid('load',{type:value});
					},
					prompt:'请输入值' 
			});
	});
</script>

  </head>
  
  <body>
     <table id="dg"> </table>       
  </body>
</html>
