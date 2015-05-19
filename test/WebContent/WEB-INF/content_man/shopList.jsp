<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">

	<title>商店列表</title>
 	<link rel="stylesheet" type="text/css" href="style/2.css">
 	<script type="text/javascript" src="js/searchShop.js" charset="GB2312"></script>
 	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
</head>
 
<body class="main_page">
	<%@ include file="model.jsp" %>
				<div class="panel first_panel">
    				<h3>你好！管理员</h3>
    				 <div class="search_box">
						 <input type="text" name="search1" id="s1">
						 <button onclick="search1()">查询商店名字</button>
						 <input type="text" name="search2" id="s2">
						 <button onclick="search2()">查询商店ID</button>
						 <input type="text" name="search3" id="s3">
						 <button onclick="search3()">查询管理者名字</button>
						 <input type="text" name="search4" id="s4">
						 <button onclick="search4()">查询管理者ID</button>
						 <input type="text" name="search5" id="s5">
						 <button onclick="search5()">查询地区</button><br>
						 <input type="text" name="search6" id="s6" value="0" 
						 onfocus="javascript:if(this.value=='0')this.value='';">--
						 <input type="text" name="search7" id="s7">
						 <button onclick="search6()">查询总金额</button>
					 </div>
    			</div>
    			<div class="panel panel_second">
    			<!--<jsp:include page="/shops" flush="true" /></br>-->
        		</div>
        		</div>
    	</div>
</body>

</html>
    	