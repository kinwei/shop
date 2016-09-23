// JavaScript Document
$(document).ready(function() {
	/*图片轮播*/
	var ul = $(".imgBox"),
	nav = $(".imgNum a"),
	oneWidth = ul.find("li").eq(0).width(),
	timer = null,
	iNow = 0;
	ul.hover(function(){
		clearInterval(timer);	
	},autoPlay);
	
	nav.on("click", function(){
		var me = $(this);
			index = me.index();
			iNow = index;
			ul.animate({
				"left": -oneWidth * iNow
			});
		nav.removeClass("active");
		me.addClass("active");	
	});
	
	autoPlay();
	
	function autoPlay(){
	
	timer = setInterval(function(){
		
		iNow++;
		
		if(iNow > nav.length - 1){
			iNow = 0;	
		}
		
		nav.eq(iNow).trigger("click");
		
	},3000);
	}	
	
	/*二级菜单*/
	
	var shopClass_item = $(".shopClass_item");
	shopClass_item.hover(function(){
			$(this).addClass("shopClass_active").find(".shopClass_list").removeClass("hide");
			$(this).find(".shopClass_list").removeClass("hide");
		},function(){
			$(this).removeClass("shopClass_active");	
		});
	
	/*导航菜单*/
	
	
});