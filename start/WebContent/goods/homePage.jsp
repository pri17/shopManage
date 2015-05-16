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
    	<script type="text/javascript" src="res/jquery.js" charset="GB2312"></script>
    	<script>
		    var errori ='<%=request.getParameter("error")%>';
		      if(errori=='yes'){
		      	alert("商品号不存在！");
		      }
		    	if(errori=='no'){
			      	alert("提交成功！");
			      }
		    	var erroeIO = '<%=request.getParameter("IOerror")%>';
		    	if(erroeIO=='yes'){
			      	alert("数据输入错误！");
			      }
	 	</script>
</head>
  	<body class="theme-cos">
    	<div class="right-all" style="min-width:10px">
        	<div id="add-business-opportunity" style="position:static;" >
            	<div class="hdw" style="border-bottom: 3px solid #40bf02; background: #27fc04">
                	<div class="hd">
                    	<h1><a class="logo" href=""><br><img alt="商品管理信息" src="res/image/logo1.png" style="left:70px;"></a></h1><br>
                	</div>
            	</div>
        	<div class="infos clearfix">
            	<div class="boform-info">
            		<div class="mainbox">
            		<form action="servlet/savePurchase">
            			<div class="content">
            				<div class="title-tip">商品进货信息</div>
            				<div class="navbar-container category clearfix"></div>
							<div style="float:right;position:relative;z-index:9999;cursor:pointer">
								<span id="pur" style="padding: 5px 25px; background-color: #27fc04; border: 1px solid #40bf02;  color: white;  font-weight: bolder;">原有商品</span>
								<span id="goo" style="padding: 5px 25px; background-color: #27fc04; border: 1px solid #40bf02;  color: white;  font-weight: bolder;">新进商品</span>
							</div>
        				<div class="field-group" id="goodsId">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em>
                    			商品编号
                    		</label>    
                    		<input name="id" type="text" id="Text1" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
						<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em>
                   				 商品原价
                    		</label>    
                    		<input name="inprice" type="text" id="Text2" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
          				<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em>
                   				 预定售价
                    		</label>    
                    		<input name="price" type="text" id="Text2" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
          				<div class="field-group">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em> 进货数量
                    		</label>    
                    		<input name="num" type="text" id="Text3" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br><hr>
            			<div class="field-group" id="goodsName" style="display:none;">
            				<label class="field-item" style="width:91px; height:45px" for="fullname">
                    			<em class="required">*</em> 商品名
                    		</label>    
                    		<input name="name" type="text" id="Text3" class="f-text smiddle-text user-name" style="height:40px;width:173px;"><br>
            			</div><br>
         				<div class="field-group" id="selectType" style="display:none;">
            				<label class="field-item" for="fullname">
                    			<em class="required">*</em>
                    			商品类别&nbsp;
                    		</label>    
                    		<select name="type" id="type" style="height:40px;">
								<option value="0">全部</option>
								<option value="1">服装</option>
								<option value="2">食品</option>
								<option value="3">家电</option>
								<option value="4">生活用品</option>
							</select> 
       					</div><br>
      					<input type="submit" value="提 交" style="margin-left: 330px;width: 173px;height: 40px;background-color: #27fc04;border: 1px solid #40bf02;color: white;font-weight: bolder;">
      				</div>
      			</form>
      			</div>
			</div>
		</div>
		</div>
  	</body>
  	<script>
  	$(function(){
  		$('#pur').click(function(){
  			$('form').attr("action", "servlet/savePurchase");
  			$('#selectType').attr("style", "display:none;");
  			$('#goodsName').attr("style", "display:none;");
  		});
  		$('#goo').click(function(){
  			$('#goodsId').attr("style", "display:none");
  			$('form').attr("action", "servlet/saveGoodsPurchase");
  			$('#selectType').attr("style", "display:block;");
  			$('#goodsName').attr("style", "display:block;");
  		})
  	})
  	</script>
</html>
