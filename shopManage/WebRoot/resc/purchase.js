$(function(){
		$('.purchase').addClass("active");

	$('#complexorder').attr("href", "viewPurchase");
	$('#timeorder').attr("href", "viewPurchaseOrderbyTime");
	$('#numorder').text("进货量排序");
	$('#numorder').attr("href", "viewPurchaseOrderbyNum");
	$('h3').text("进货管理");
	$('em').text($('#counter').val());
	
	var path = window.location.pathname;
	var action = path.substring(6) ;
	if(path.substring(6, 8) == "p_"){
		$('form').attr("action", action);
		var tag = "#"+action.substring(2);
		$(tag).toggleClass("selected");
	}
	else{
		$('form').attr("action", "p_findByGoodsName");
		$('#findByGoodsName').toggleClass("selected");
	}
	
	var nav = $('#search_nav').children('li');
	nav.click(function(){
		$('.selected').toggleClass("selected");
		$(this).toggleClass("selected");
		var action = $(this).attr("id");
		$('form').attr("action", "p_"+action);
	})
	
	var type = $('#list').children('li');
	type.click(function(){
		var id = type.index($(this));
		var url = "/test/viewPurchaseChosenbyType?type="+id;
		location.href=decodeURIComponent(url);
	})
	
	var purId = $('.deletepur');
	function addhref(){
	    $(this).attr("href", "deletePurchase?id="+purId.index($(this)));
	}
	purId.each(addhref);
	
	$('#c_choose').hover(function(){
		$('#c_list').toggleClass("disappear");
	},function(){
		$('#c_list').toggleClass("disappear");
	})
	var c_list_select=$('#c_list').children('li');
	c_list_select.click(function(){
		$('#c_typeId').val(c_list_select.index($(this)));
		$('#c_board').text($(this).text());
	})
	
	var c_tag = $('#c_nav').children('li');
	c_tag.click(function(){
		$('.c_active').toggleClass("c_active");
		$(this).toggleClass("c_active");
		$('#c_type').toggleClass("disappear");
	})
	
	var change = $('.changepur');
	change.click(function(){
		var target = $(this).parent().parent();
		var idx = change.index($(this));
		var res = idx * 53 + 475;
		if($(this).text() == "修改"){
			$(this).text("取消");
		}
		else
			$(this).text("修改");
		target.toggleClass("tr_active");
		$('.changeForm').attr("style", "top:"+res+"px;");
		$('#c_goodsName').val(target.children('.td_name').text());
		$('#c_price').val(target.children('.td_price').text());
		$('#c_num').val(target.children('.td_num').text());
		$('form').attr("action", "changePurchase");
		$('#c_purIdx').val(idx);
		$('.changeForm').toggleClass("disappear");
	})
	
	$('.checkbox').change(function(){
		var purnum = 0, goodsnum=0, amount=0;
		$( ".checkbox:checked" ).each(function() {
			var target = $(this).parent();
			var num = parseInt(target.siblings('.td_num').text());
			var price = parseFloat(target.siblings('.td_price').text());
			purnum = purnum+1;
			goodsnum = goodsnum+num;
			amount = num*price +amount;
		  })
		$('#purnum').text(purnum);
		$('#goodsnum').text(goodsnum);
		$('#amount').text(amount);
	})
	
	$('#selectall').change(function(){
		if(document.getElementById("selectall").checked){
			for(var i = 0; i < $('.checkbox').length; i++)
				document.getElementsByClassName("checkbox")[i].checked = true;
				$('#ps').text("取消");
		}else{
			for(var i = 0; i < $('.checkbox').length; i++)
				document.getElementsByClassName("checkbox")[i].checked = false;
			$('#ps').text("全选");
		}
		$('.checkbox').change();
	})
})