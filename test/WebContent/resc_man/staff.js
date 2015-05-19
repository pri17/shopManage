 function search1(){
            $("#serTable").html("");
            $("#serTable").append("<tr id='tableTr' ><td>管理者姓名</td><td>ID</td><td>权限等级</td></tr>")
            var name=$("#s1").val();
            $.getJSON("staffByName",{name:name},function(json){
                $.each(json,function(i,data){
                    $("#tableTr").after("<tr id='aaa'><td>"+data.name+"</td><td>"+data.id+"</td><td>"+data.level+"</td></tr>");
                })
            })
}
 
 function search2(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><td>ID</td><td>管理者姓名</td><td>权限等级</td></tr>")
      
     var id=$("#s2").val();
     $.getJSON("staffByID",{id:id},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.id+"</td><td>"+data.name+"</td><td>"+data.level+"</td></tr>");
         })
     })
}
 
 function search3(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><td>权限等级</td><td>ID</td><td>管理者姓名</td></tr>")
      
     var id=$("#s3").val();
     $.getJSON("staffByLevel",{level:id},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.level+"</td><td>"+data.id+"</td><td>"+data.name+"</td></tr>");
         })
     })
}
 /////////////////
 /////////////////////
 ///////////////
 $(function(){
		$('.goods').addClass("active");

	$('#findByStaff').toggleClass("disappear");
	$('#complexorder').attr("href", "viewGoods");
	$('#order').append('<a id="leftorder"></a>');
	$('h3').text("商品管理");
	$('em').text($('#counter').val());
	
	var path = window.location.pathname;
	var action = path.substring(6) ;
	if(action === "viewGoodsOrderbyNumH"){
		$('#numorder').text("销量低");
		$('#numorder').attr("href", "viewGoodsOrderbyNumL");
	}else{
		$('#numorder').attr("href", "viewGoodsOrderbyNumH");
		$('#numorder').text("销量高");
	}
	if(action === "viewGoodsOrderbyLeftH"){
		$('#leftorder').text("余货少");
		$('#leftorder').attr("href", "viewGoodsOrderbyLeftL");
	}else{
		$('#leftorder').attr("href", "viewGoodsOrderbyLeftH");
		$('#leftorder').text("余货多");
	}
	if(action === "viewGoodsOrderbyProfitH"){
		$('#timeorder').text("获利少");
		$('#timeorder').attr("href", "viewGoodsOrderbyProfitL");
	}else{
		$('#timeorder').attr("href", "viewGoodsOrderbyProfitH");
		$('#timeorder').text("获利多");
	}
	
	if(path.substring(6, 8) == "g_"){
		$('form').attr("action", action);
		var tag = "#"+action.substring(2);
		$(tag).toggleClass("selected");
	}
	else{
		$('form').attr("action", "g_findByGoodsName");
		$('#findByGoodsName').toggleClass("selected");
	}
	
	var nav = $('#search_nav').children('li');
	nav.click(function(){
		$('.selected').toggleClass("selected");
		$(this).toggleClass("selected");
		var action = $(this).attr("id");
		$('form').attr("action", "g_"+action);
	})
	
	var type = $('#list').children('li');
	type.click(function(){
		var id = type.index($(this));
		var url = "/test/viewGoodsChosenbyType?type="+id;
		location.href=decodeURIComponent(url);
	})
	
	$('.checkbox').change(function(){
		var checknum = 0, goodsnum=0, amount=0;
		$( ".checkbox:checked" ).each(function() {
			var target = $(this).parent();
			var num = parseInt(target.siblings('.td_num').text());
			var ivy = parseInt(target.siblings('.td_ivy').text());
			var price = parseFloat(target.siblings('.td_profit').text());
			checknum = checknum+1;
			goodsnum = goodsnum+ivy - num;
			amount = price +amount;
		  })
		$('#checknum').text(checknum);
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
	
	
	//进货历史数据加载
	var content = $('.changeForm');
	var purchase = $('.purchase');
	purchase.click(function(){
		content.append("<h2>进货历史</h2>");
		var target = $(this).parent().parent();
		var idx = purchase.index($(this));
		var res = idx *71 + 475;
		if($(this).text() == "进货历史"){
			$(this).text("收起");
			var purchaseAPI="viewGoodsPurchase?id="+target.children('.td_id').text();
			var RequestTimeout = setTimeout(function(){
				content.text("进货历史获取失败！ ");
			}, 8000);
			$.ajax({
				url:purchaseAPI,
				type:"post",
				data:{//设置数据源
	                name:$("input[name=name]").val(),
	                id:$("input[name=id]").val(),
	                date:$("input[name=date]").val(),
	                num:$("input[name=num]").val(),
	                staff:$("input[name=staff]").val(),
	                price:$("input[name=price]").val()
	            },
				dataType:"json",
				success:function(response){
					content.append("<table><thead><tr>"+
								"<th><b>进货单编号</b></th>"+
								"<th>商品名</th>"+
								"<th>进货时间</th>"+
								"<th>原价</th>"+
								"<th>数量</th>"+
								"<th>负责人</th>"+
							"</tr></thead><tbody></tbody></table>");
					var inf = content.find('tbody');
					var res = eval ("(" + response.res + ")");
					//var res = obj.res;
					for( var i = 0; i < res.length; i++ ){
						inf.append("<tr><td>"+res[i].id+
								"</td><td>"+res[i].name+
								"</td><td>"+res[i].date+
								"</td><td>"+res[i].price+
								"</td><td>"+res[i].num+
								"</td><td>"+res[i].staff+"</tr>");
					}
					content.append('<a href="viewGoodsPurchases?id='+target.children('.td_id').text()+'">>>更多</a>');
					clearTimeout(RequestTimeout);
			}});
		}
		else{
			$(this).text("进货历史");
			content.children().remove();
		}
		target.toggleClass("tr_active");
		content.attr("style", "top:"+res+"px;");
		content.toggleClass("disappear");
	})
	
	//售货历史数据加载
	var sale = $('.sale');
	sale.click(function(){
		content.append("<h2>销售历史</h2>");
		var target = $(this).parent().parent();
		var idx = sale.index($(this));
		var res = idx *71 + 475;
		if($(this).text() == "销售历史"){
			$(this).text("收起");
			var saleAPI="viewGoodsSale?id="+target.children('.td_id').text();
			var RequestTimeout = setTimeout(function(){
				content.text("<p>销售历史获取失败！</p>");
			}, 8000);
			$.ajax({
				url:saleAPI,
				type:"post",
				data:{//设置数据源
	                name:$("input[name=name]").val(),
	                id:$("input[name=id]").val(),
	                date:$("input[name=date]").val(),
	                num:$("input[name=num]").val(),
	                staff:$("input[name=staff]").val(),
	                price:$("input[name=price]").val()
	            },
				dataType:"json",
				success:function(response){
					content.append("<table><thead><tr>"+
								"<th><b>售货单编号</b></th>"+
								"<th>商品名</th>"+
								"<th>售货时间</th>"+
								"<th>售价</th>"+
								"<th>数量</th>"+
								"<th>负责人</th>"+
							"</tr></thead><tbody></tbody></table>");
					var inf = content.find('tbody');
					var res = eval ("(" + response.res + ")");
					//var res = obj.res;
					for( var i = 0; i < res.length; i++ ){
						inf.append("<tr><td>"+res[i].id+
								"</td><td>"+res[i].name+
								"</td><td>"+res[i].date+
								"</td><td>"+res[i].price+
								"</td><td>"+res[i].num+
								"</td><td>"+res[i].staff+"</tr>");
					}
					content.append('<a href="viewGoodsSales?id='+target.children('.td_id').text()+'">>>更多</a>');
					clearTimeout(RequestTimeout);
			}});
		}
		else{
			$(this).text("售货历史");
			content.children().remove();
		}
		target.toggleClass("tr_active");
		content.attr("style", "top:"+res+"px;");
		content.toggleClass("disappear");
	})
	
	//pie-chart设置
	function piechart(title, chartdata, namey){
		$('#highcharts').highcharts({
	        title: {
	            text: title
	        },
	        tooltip: {
	            pointFormat: '比例: <b>{point.percentage:.1f}%<br/>'+namey+':<b>{point.y}</b> '
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            data:chartdata
	        }]
	    });
	}
	
	//销售分析
	//销量比例
	function salenum(target){
		var urlAPI="pieSaleNumScale?id="+target.children('.td_id').text();
		var chartdata;
		var RequestTimeout = setTimeout(function(){
			content.append("<p>数据获取失败！</p>");
		}, 8000);
		var resname=target.children('.td_name').text();
		$.ajax({
			url:urlAPI,
			type:"post",
			data:{//设置数据源
             name:$("input[name=name]").val(),
             num:$("input[name=num]").val(),
             amount:$("input[name=amount]").val()
         },
			dataType:"json",
			success:function(response){
					var res = eval ("(" + response.res + ")");
					chartdata=[
				                {
				                    name: res.name,
				                    y: res.num,
				                    sliced: true,
				                    selected: true
				                },
				                ['其他',  res.amount]
				            ];
				//pie_chart设置
				piechart('销售比例', chartdata, '销量');
				clearTimeout(RequestTimeout);
		}})
	}
	
	//销售分析详情
	//销售分析click
	var charts = $('.charts');
	$('.charts').click(function(){
		content.toggleClass("disappear");
		var target = $(this).parent().parent();
		target.toggleClass("tr_active");
		if($(this).text() == "销售分析"){
			$(this).text("收起");
			content.append('<span class="prev" id="none"><span class="prev-btn"></span></span>');
			content.append('<div id="highcharts"></div>');
			content.append('<span class="next" id="saletrends"><span class="next-btn"></span></span>');
			var idx = charts.index($(this));
			var res = idx *71 + 540;
			content.attr("style", "top:"+res+"px;");
			salenum(target);
		}else{
			$(this).text("销售分析");
			content.children().remove();
		}
	})
	
	function clearhover(){
		$('.prev-btn').removeClass("prev-btn-hover");
		$('.prev').removeClass("btn-hover");
		$('.next-btn').removeClass("next-btn-hover");
		$('.next').removeClass("btn-hover");
		$('.changeForm').find('p').remove();
		content.children('#highcharts').children().remove();
	}
	
	$(document).on('click','#salecolumn',function(){
		clearhover();
		$('.next').attr("id", "none");
		$('.prev').attr("id", "saletrends");
		var target = $('.tr_active');
		var urlAPI="columnSale?id="+target.children('.td_id').text();
		var RequestTimeout = setTimeout(function(){
			content.append("<p>数据获取失败！</p>");
		}, 8000);
		$.ajax({
			url:urlAPI,
			type:"post",
			dataType:"json",
			success:function(response){
					var res = eval ("(" + response.res + ")");
					var chartdata=res;
				//timeline_chart设置
					salecol(chartdata);
				clearTimeout(RequestTimeout);
		}})
	})
	
	function salecol(data){
		$('#highcharts').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '销量售价关系'
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '销量'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '销量：<b>{point.y}</b>'
	        },
	        series: [{
	            name: 'Population',
	            data: data,
	            dataLabels: {
	                enabled: true,
	                rotation: -90,
	                color: '#FFFFFF',
	                align: 'right',
	                format: '{point.y}', // one decimal
	                y: 10, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
	    });
	}
	
	$(document).on('click','#saletrends',function(){
		clearhover();
		$('.next').attr("id", "salecolumn");
		$('.prev').attr("id", "salepie");
		var target = $('.tr_active');
		var urlAPI="lineSaleInf?id="+target.children('.td_id').text();
		var chartdata;
		var RequestTimeout = setTimeout(function(){
			content.append("<p>数据获取失败！</p>");
		}, 8000);
		var resname=target.children('.td_name').text();
		$.ajax({
			url:urlAPI,
			type:"post",
			dataType:"json",
			success:function(response){
					var res = eval ("(" + response.res + ")");
					chartdata=res;
				//timeline_chart设置
					timeLine(chartdata);
				clearTimeout(RequestTimeout);
		}})
	})
	
	function timeLine(data){
		    $('#highcharts').highcharts({
		        chart: {
		            zoomType: 'x'
		        },
		        title: {
		            text: '销售趋势分析'
		        },
		        xAxis: {
		            type: 'datetime',
		            minRange: 14 * 24 * 3600000 // fourteen days
		        },
		         yAxis: [{ // Primary yAxis
		            labels: {
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            title: {
		                text: '销量',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            opposite: true
		        }, { // Secondary yAxis
		            title: {
		                text: '盈利',
		                style: {
		                    color: Highcharts.getOptions().colors[5]
		                }
		            },
		            labels: {
		                style: {
		                    color: Highcharts.getOptions().colors[5]
		                }
		            }

		        }],
		        legend: {
		            enabled: false
		        },
		        plotOptions: {
		            area: {
		                
		                marker: {
		                    radius: 2
		                },
		                lineWidth: 1,
		                states: {
		                    hover: {
		                        lineWidth: 1
		                    }
		                },
		                threshold: null
		            }
		        },

		        series: [{
		            type: 'area',
		            name: '盈利',
		            yAxis: 1,
		            pointInterval: 24 * 3600 * 1000,
		            pointStart: Date.UTC(2015, 2, 1),
		            color: Highcharts.getOptions().colors[5],
		            fillColor: {
		                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
		                    stops: [
		                        [0, Highcharts.getOptions().colors[5]],
		                        [1, Highcharts.Color(Highcharts.getOptions().colors[5]).setOpacity(0).get('rgba')]
		                    ]
		                },
		            data: data[0]
		        },{
		        type: 'area',
		            name: '销量',
		            yAxis: 0,
		            pointInterval: 24 * 3600 * 1000,
		            pointStart: Date.UTC(2015, 2, 1),
		            color: Highcharts.getOptions().colors[0],
		            fillColor: {
		                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
		                    stops: [
		                        [0, Highcharts.getOptions().colors[0]],
		                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
		                    ]
		                },
		            data: data[1]
		        }]
		    });
	}
	
	$(document).on('click','#salepie',function(){
		clearhover();
		$('.next').attr("id", "saletrends");
		$('.prev').attr("id", "none");
		salenum($('.tr_active'));
	})
		
	$(document).on('mouseover','.prev',function(){
		if($(this).attr('id') != 'none'){
			$('.prev-btn').addClass("prev-btn-hover");
			$('.prev').addClass("btn-hover");
		}
	});
	$(document).on('mouseout','.prev',function(){
		if($(this).attr('id') != 'none'){
			$('.prev-btn').removeClass("prev-btn-hover");
			$('.prev').removeClass("btn-hover");
		}
	});
	$(document).on('mouseover','.next',function(){
		if($(this).attr('id') != 'none'){
			$('.next-btn').addClass("next-btn-hover");
			$('.next').addClass("btn-hover");
		}
	});
	$(document).on('mouseout','.next',function(){
		if($(this).attr('id') != 'none') {
			$('.next-btn').removeClass("next-btn-hover");
			$('.next').removeClass("btn-hover");
		}
	});
	
})