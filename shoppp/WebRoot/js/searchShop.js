function search1(){
            $("#serTable").html("");
            $("#serTable").append("<tr id='tableTr' ><th>�̵���</th>" +
            		"<th>�̵�ID</th><th>�̵����ڵ�</th><th>�̵������ID</th><th>�̵������</th><th>�����ߵȼ�</th><th>�̵��ܽ��</th><th><font color='orange'>����</font></th></tr>")
            var name=$("#s1").val();
            $.getJSON("shopByName",{name:name},function(json){
                $.each(json,function(i,data){
                    $("#tableTr").after("<tr id='aaa'><td>"+data.shop_name+"</td><td>"
                    		+data.shop_id+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
                })
            })
}
 function search2(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>�̵�ID</th>" +
            		"<th>�̵���</th><th>�̵����ڵ�</th><th>�̵������ID</th><th>�̵������</th><th>�����ߵȼ�</th><th>�̵��ܽ��</th><th><font color='orange'>����</font></th></tr>")
      
     var id=$("#s2").val();
     $.getJSON("shopByID",{id:id},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.shop_id+"</td><td>"
             		+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
         })
     })
}
 
 function search3(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>����Ա����</th>"+ 
            		"<th>�̵����ԱID</th><th>�����ߵȼ�</th><th>�̵�ID</th><th>�̵���</th><th>�̵����ڵ�</th><th>�̵��ܽ��</th><th><font color='orange'>����</font></th></tr>")
      
     var name=$("#s3").val();
     $.getJSON("shopByStaffName",{name:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.staff_name+"</td><td>"
             		+data.staff_id+"</td><td>"+data.level+"</td><td>"+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
         })
     })
}
 
 
 function search4(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>����ԱID</th>"+ 
            		"<th>�̵����Ա����</th><th>�����ߵȼ�</th><th>�̵�ID</th><th>�̵���</th><th>�̵����ڵ�</th><th>�̵��ܽ��</th><th><font color='orange'>����</font></th></tr>")
      
     var name=$("#s4").val();
     $.getJSON("shopByStaffID",{id:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.staff_id+"</td><td>"
             		+data.staff_name+"</td><td>"+data.level+"</td><td>"+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.area+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
         })
     })
}
 
 function search5(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>�̵����ڵ�</th>"+ 
            		"<th>�̵�ID</th><th>�̵���</th><th>������ID</th><th>����������</th><th>�����ߵȼ�</th><th>�̵��ܽ��</th><th><font color='orange'>����</font></th></tr>")
      
     var name=$("#s5").val();
     $.getJSON("shopByArea",{area:name},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.area+"</td><td>"
             		+data.shop_id+"</td><td>"+data.shop_name+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.staff_level+"</td><td>"+data.price+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
         })
     })
}
 
 function search6(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><th>�̵��ܽ��</th><th>�̵���</th>" +
		"<th>�̵�ID</th><th>�̵����ڵ�</th><th>�̵������ID</th><th>�̵������</th><th>�����ߵȼ�</th><th><font color='orange'>����</font></th></tr>")
		
     var p1=$("#s6").val();
     var p2=$("#s7").val();
     //�ж�p1 p2��С
     if(parseFloat(p1)>parseFloat(p2))
    	 $("#tableTr").after("����������󣬺�һ������С��ǰһ�������������룡");
     else{
     $.getJSON("shopByPrice",{p1:p1,p2:p2},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.price+"</td><td>"+data.shop_name+"</td><td>"
             		+data.shop_id+"</td><td>"+data.area+"</td><td>"+data.staff_id+"</td><td>"+data.staff_name+"</td><td>"+data.level+"</td>"+"</td><td><a href='delShop?id="+data.shop_id+"'>ɾ��</a></td></tr>");
              })
     })}
}
 
 