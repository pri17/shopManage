function search1(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>商店名字</th><th>商店ID</th><th>销售列表ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店管理员</th><th>商店管理者ID</th><th>销售日期</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var name=$("#s1").val();
    $.getJSON("salesByShopName",{name:name},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.shop_name+"</td><td>"+data.shop_id+"</td><td>"+data.sales_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
}

function search2(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>商店ID</th><th>商店名</th><th>销售列表ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店管理员</th><th>商店管理者ID</th><th>销售日期</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var id=$("#s2").val();
    $.getJSON("salesByShopID",{id:id},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.sales_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
}

function search3(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>商店管理员</th><th>商店管理者ID</th><th>销售列表ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店ID</th><th>商店名</th><th>销售日期</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var name=$("#s3").val();
    $.getJSON("salesByStaffName",{name:name},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"+data.sales_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
}

function search4(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>商店管理员ID</th><th>商店管理者</th><th>销售列表ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店ID</th><th>商店名</th><th>销售日期</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var name=$("#s4").val();
    $.getJSON("salesByStaffID",{id:name},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.sales_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
}

function search5(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>销售ID</th><th>商店名</th><th>商店ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店管理员</th><th>商店管理者ID</th><th>销售日期</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var name=$("#s5").val();
    $.getJSON("salesByID",{id:name},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.sales_id+"</td><td>"+data.shop_name+"</td><td>"+data.shop_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
}

function search7(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>销售数目</th><th>销售ID</th><th>商店名</th><th>商店ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店管理员</th><th>商店管理者ID</th><th>销售日期</th>"
			+ "<th>售价</th></B><th><font color='orange'>操作</font></th></tr>");
	
    
    var n1=$("#s7").val();
    var n2=$("#s8").val();
    if(parseInt(n1)>parseInt(n2))
   	 $("#tableTr").after("数目输入有误，后一个数目不能小于前一个数目大小，请重新输入！");
    else if(parseInt(n1)<0||parseInt(n2)<0){
    	$("#tableTr").after("数目输入有误，不能输入负数，请重新输入！");
    }else{
    $.getJSON("salesByNum",{n1:n1,n2:n2},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.num+"</td><td>"+data.sales_id+"</td><td>"+data.shop_name+"</td><td>"+data.shop_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"+data.date+"</td><td>"
					+data.price+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })
    }
}
 

function search6(){
    $("#serTable").html("");
    $("#serTable").append("<tr id='tableTr'><B><th>销售日期</th><th>销售ID</th><th>商店名</th><th>商店ID</th><th>商品名</th><th>商品ID</th>"
			+ "<th>商店管理员</th><th>商店管理者ID</th>"
			+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
	var d1=$("#s6").val();
	var d2=$("#s9").val();
	////alert(d1);
	//alert(d2);
	//alert(d1);
	if(d1>d2){
		 $("#tableTr").after("日期输入有误，前一个日期不能大于后一个日期！");
	}else{
    $.getJSON("salesByDate",{d1:d1,d2:d2},function(json){
        $.each(json,function(i,data){
            $("#tableTr").after("<tr><td>"+data.date+"</td><td>"+data.sales_id+"</td><td>"+data.shop_name+"</td><td>"+data.shop_id+"</td><td>"+data.goods_name+"</td><td>"+data.goods_id+"</td><td>"
            		+data.staff_name+"</td><td>"+data.staff_id+"</td><td>"
					+data.price+"</td><td>"+data.num+"</td><td><a href='delSales?id="+data.sales_id+"'>删除</a></td></tr>");
		})
    })}
}

