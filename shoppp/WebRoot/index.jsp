<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">

	<title></title>
 	<link rel="stylesheet" type="text/css" href="resc-man/style/master.css">
</head>
 
<body class="main_page">
	<%@ include file="WEB-INF/content-man/model.jsp" %>
				<div class="panel first_panel">
    				<h3>你好！管理员</h3>
    			</div>
    			<div class="panel_second">
    			
        		</div>
        		</div>
    	</div>
</body>
</html>