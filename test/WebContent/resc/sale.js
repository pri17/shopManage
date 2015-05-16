$(function(){
		$('.sale').addClass("active");

	$('#complexorder').attr("href", "viewSale");
	$('#timeorder').attr("href", "viewSaleOrderbyTime");
	$('#numorder').text("销量排序");
	$('#numorder').attr("href", "viewSaleOrderbyNum");
	$('h3').text("售货管理");
	$('em').text($('#counter').val());
	
	var path = window.location.pathname;
	var action = path.substring(6) ;
	if(path.substring(6, 8) == "s_"){
		$('form').attr("action", action);
		var tag = "#"+action.substring(2);
		$(tag).toggleClass("selected");
	}
	else{
		$('form').attr("action", "s_findByGoodsName");
		$('#findByGoodsName').toggleClass("selected");
	}
	
	var nav = $('#search_nav').children('li');
	nav.click(function(){
		$('.selected').toggleClass("selected");
		$(this).toggleClass("selected");
		var action = $(this).attr("id");
		$('form').attr("action", "s_"+action);
	})
	
	var type = $('#list').children('li');
	type.click(function(){
		var id = type.index($(this));
		var url = "/test/viewSaleChosenbyType?type="+id;
		location.href=decodeURIComponent(url);
	})
	
	var saleId = $('.deletesale');
	function addhref(){
	    $(this).attr("href", "deleteSale?id="+saleId.index($(this)));
	}
	saleId.each(addhref);
	
	var change = $('.changesale');
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
		$('form').attr("action", "changeSale");
		$('#c_salerIdx').val(idx);
		$('.changeForm').toggleClass("disappear");
	})
	
	$('.checkbox').change(function(){
		var salenum = 0, goodsnum=0, amount=0;
		$( ".checkbox:checked" ).each(function() {
			var target = $(this).parent();
			var num = parseInt(target.siblings('.td_num').text());
			var price = parseFloat(target.siblings('.td_price').text());
			salenum = salenum+1;
			goodsnum = goodsnum+num;
			amount = price +amount;
		  })
		$('#salenum').text(salenum);
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