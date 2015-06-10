function search1(){
            $("#serTable").html("");
            $("#serTable").append("<tr id='tableTr' ><th>商店名</th>" +
            		"<th>商店ID</th><th>商店所在地</th><th>商店管理者ID</th><th>商店管理者</th><th>管理者等级</th><th>商店总金额</th><th><font color='orange'>操作</font></th></tr>")
            var name=$("#s1").val();
            $.getJSON("shopByName",{name:name},function(json){
                $.each(json,function(i,data){
                    $("#tableTr").after("<tr id='aaa'><td>"+data.shop_name+"</td><td>"
                    		+data.shop_id+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
                })
            })
}
 function search2(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>商店ID</th>" +
            		"<th>商店名</th><th>商店所在地</th><th>商店管理者ID</th><th>商店管理者</th><th>管理者等级</th><th>商店总金额</th><th><font color='orange'>操作</font></th></tr>")
      
     var id=$("#s2").val();
     $.getJSON("shopByID",{id:id},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.shop_id+"</td><td>"
             		+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
         })
     })
}
 
 function search3(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>管理员名字</th>"+ 
            		"<th>商店管理员ID</th><th>管理者等级</th><th>商店ID</th><th>商店名</th><th>商店所在地</th><th>商店总金额</th><th><font color='orange'>操作</font></th></tr>")
      
     var name=$("#s3").val();
     $.getJSON("shopByStaffName",{name:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.staff_name+"</td><td>"
             		+data.staff_id+"</td><td>"+data.level+"</td><td>"+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
         })
     })
}
 
 
 function search4(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>管理员ID</th>"+ 
            		"<th>商店管理员名字</th><th>管理者等级</th><th>商店ID</th><th>商店名</th><th>商店所在地</th><th>商店总金额</th><th><font color='orange'>操作</font></th></tr>")
      
     var name=$("#s4").val();
     $.getJSON("shopByStaffID",{id:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.staff_id+"</td><td>"
             		+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
         })
     })
}
 
 function search5(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>商店所在地</th>"+ 
            		"<th>商店ID</th><th>商店名</th><th>管理者ID</th><th>管理者名字</th><th>管理者等级</th><th>商店总金额</th><th><font color='orange'>操作</font></th></tr>")
      
     var name=$("#s5").val();
     $.getJSON("shopByArea",{area:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.area+"</td><td>"
             		+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.staff_level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
         })
     })
}
 
 function search6(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>商店总金额</th><th>商店名</th>" +
		"<th>商店ID</th><th>商店所在地</th><th>商店管理者ID</th><th>商店管理者</th><th>管理者等级</th><th><font color='orange'>操作</font></th></tr>")
		
     var p1=$("#s6").val();
     var p2=$("#s7").val();
     //判断p1 p2大小
     if(parseFloat(p1)>parseFloat(p2))
    	 $("#tableTr").after("金额输入有误，后一个金额不能小于前一个金额，请重新输入！");
     else{
     $.getJSON("shopByPrice",{p1:p1,p2:p2},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.price+"</td><td>"+data.shop_name+"</td><td>"
             		+data.shop_id+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td>"+"</td><td><a href='delShop?id="+data.shop_id+"'>删除</a></td></tr>");
              })
     })}
}
 
 