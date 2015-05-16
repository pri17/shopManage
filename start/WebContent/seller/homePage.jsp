<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    	<title>My JSP 'homePage.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    	<link rel="stylesheet" type="text/css" href="res/css/merchantRegister.css">
    	<style type="text/css">
         .field-group
         {
             width: 1088px;
         }
         #s_lg_img
         {
             height: 77px;
             width: 279px;
         }
         #lg
         {}
    	</style>
    	<script>
	    	var errori ='<%=request.getParameter("error")%>'
	      if(errori=='yes'){
	      	alert("商品号不存在！");
	      }
	    	if(errori=='no'){
		      	alert("提交成功！");
		      }
	    	var errorIO ='<%=request.getParameter("IOerror")%>'
	  	      if(errorIO=='yes'){
	  	      	alert("数据输入错误！");
	  	      }
 	</script>
  	</head>
  	<body class="theme-cos">
    	<div class="right-all" style="min-width:10px">
        	<div id="add-business-opportunity" style="position:static;" >
            	<div class="hdw" style="border-bottom: 3px solid #fce804; background: #f3fc04">
                	<div class="hd">
                    	<h1><a class="logo" href=""><br><img alt="商品管理信息" src="res/image/logo1.png" style="left:70px;"></a></h1><br>
                	</div>
            	</div>
        	<div class="infos clearfix">
            	<div class="boform-info">
            		<div class="mainbox">
            		<form action="servlet/saveSale">
            			<div class="content">
            				<div class="title-tip">商品销售信息</div>
            				<div class="navbar-container category clearfix"></div>
								
        				<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em>
                    			商品编号
                    		</label>    
                    		<input name="id" type="text" id="Text1" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>

          				<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em>
                   				 商品售价
                    		</label>    
                    		<input name="price" type="text" id="Text2" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
          				<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em> 销售数量
                    		</label>    
                    		<input name="num" type="text" id="Text3" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
      					<input type="submit" value="提 交" style="margin-left: 330px;width: 173px;height: 40px;background-color: #f3fc04;border: 1px solid #fce804;color: white;font-weight: bolder;">
      				</div>
      			</form>
      			</div>
			</div>
		</div>
		</div>
  	</body>
</html>
