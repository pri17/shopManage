<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">

	<title>商品列表</title>
 	<link rel="stylesheet" type="text/css" href="resc-man/style/3.css">
 	<script type="text/javascript" src="resc-man/js/searchGoods.js" charset="GB2312"></script>
 	<script type="text/javascript" src="resc-man/js/jquery-1.3.2.min.js"></script>
</head>
 
<body class="main_page">
	<%@ include file="model.jsp" %>
	<div class="panel first_panel">
    				<h3>你好！管理员</h3>
    				<div class="search_box">
						 <input type="text" name="search1" id="s1">
						 <button onclick="search1()">查询商品名</button>
						 <input type="text" name="search2" id="s2">
						 <button onclick="search2()">查询商品ID</button>
						 <input type="text" name="search3" id="s3">
						 <button onclick="search3()">查询种类</button>
					 </div>
    			</div>
    			<div class="panel_second">
    			<!--<jsp:include page="/goods" flush="true" /></br>-->
        		</div>
        		</div>
    	</div>
</body>
</html>
    				
  
