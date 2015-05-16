$(function(){
		$('.homepage').addClass("active");
		
		$('#shop').click(function(){
			$('.li_active').removeClass('li_active');
			$(this).addClass('li_active');
			$('.chartcontainer').attr("style", "display:none;");
			$('.content').attr("style", "");
		})
		$('#shopsale').click(function(){
			$('.li_active').removeClass('li_active');
			$(this).addClass('li_active');
			$('.content').attr("style", "display:none;");
			$('.chartcontainer').attr("style", "");
			typenum();
		})
		
	function typenum(){
		var urlAPI="typeNum";
		var RequestTimeout = setTimeout(function(){
			content.append("<p>数据获取失败！</p>");
		}, 8000);
		$.ajax({
			url:urlAPI,
			type:"post",
			data:{//设置数据源
                main:$("input[name=main]").val(),
                type0:$("input[name=t0]").val(),
                type1:$("input[name=t1]").val(),
                type2:$("input[name=t2]").val(),
                type3:$("input[name=t3]").val()
            },
			dataType:"json",
			success:function(response){
					var res = eval ("(" + response.res + ")");
					var chartdata=res.main;
					var data=new Array()
					data[0] = res.type0;
					data[1] = res.type1;
					data[2] = res.type2;
					data[3] = res.type3;
				//pie_chart设置
				piechart( chartdata, data);
				clearTimeout(RequestTimeout);
		}})
	}
	//pie-chart设置
	function piechart(chartdata, data){
		 $('.chartcontainer').highcharts({
             chart: {
                 type: 'pie'
             },
             title: {
                 text: '商品类型与销量'
             },
             plotOptions: {
                 series: {
                     dataLabels: {
                         enabled: true,
                         format: '{point.name}: {point.y:.1f}%'
                     }
                 }
             },

             tooltip: {
                 headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                 pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b><br/>'
             },

             series: [{
		         name: '类型',
		         colorByPoint: true,
		         data: chartdata
		     }],
		     drilldown: {
		         series: [{
		             id: 't0',
		             data: data[0]
			         }, {
			             id: 't1',
			             data:data[1]
			         }, {
			             id: 't2',
			             data: data[2]
			         },{
			        	 id:'t3',
			        	 data:data[3]
			         }]
		     	}
		 });
	}
})