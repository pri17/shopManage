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