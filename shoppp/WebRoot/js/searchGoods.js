 function search1(){
            $("#serTable").html("");
            $("#serTable").append("<tr id='tableTr' ><td>��Ʒ��</td><td>��ƷID</td><td>��Ʒ����</td><th><font color='orange'>����</font></th></tr>")
            var name=$("#s1").val();
            $.getJSON("goodsByName",{name:name},function(json){
                $.each(json,function(i,data){
                    $("#tableTr").after("<tr id='aaa'><td>"+data.name+"</td><td>"+data.id+"</td><td>"+data.type+"</td><td><a href='delGoods?id="+data.id+"'>ɾ��</a></td></tr>");
                })
            })
}
 
 function search2(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><td>��ƷID</td><td>��Ʒ��</td><td>��Ʒ����</td><th><font color='orange'>����</font></th></tr>")
      
     var id=$("#s2").val();
     $.getJSON("goodsByID",{id:id},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.id+"</td><td>"+data.name+"</td><td>"+data.type+"</td><td><a href='delGoods?id="+data.id+"'>ɾ��</a></td></tr>");
         })
     })
}
 
 function search3(){
     $("#serTable").html("");
     $("#serTable").append("<tr id='tableTr' ><td>����</td><td>��ƷID</td><td>��Ʒ��</td><th><font color='orange'>����</font></th></tr>")
      
     var type=$("#s3").val();
     $.getJSON("goodsByType",{type:type},function(json){
         $.each(json,function(i,data){
             $("#tableTr").after("<tr id='aaa'><td>"+data.type+"</td><td>"+data.id+"</td><td>"+data.name+"</td><td><a href='delGoods?id="+data.id+"'>ɾ��</a></td></tr>");
         })
     })
}