(function($){
	$.fn.rePriceShow = function(){
		return this.each(function() {
			$(this).change(function(){
				// 1: 验证数据的有效性
				var number=$(this).val();  // $(this).val();
				if(!isNaN(number) && parseInt(number)==number && number>0){
					// 获取当前商品的id编号
					var id=$(this).parent().parent().parent().parent().attr("lang");
					// 发送ajax请求,如果get请求会先到浏览器缓存, 返回新的总价格
					$.post('sorder_updateSorder.action',{'product.id':id,number:number},function(total){
						$("#total").html('￥' + total);
					},"text");
					var price=$(this).parent().parent().parent().parent().find(".help_price").html().substring(1);
					//alert(2.456.toFixed(2));
					$(this).parent().parent().next().html('￥' + (price*number).toFixed(2));
				}else{
					// 重置原来的数据
					this.value=$(this).attr("lang");
				}
			});
		});
	};
})(jQuery);