<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head id="Head1">
    	<base href="<%=basePath%>">
    	<title>商品信息管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="res/css/login.css"></head>
  	</head>
  	<body id="login" style="position: static;">
    	<div class="new-index-triffle-w" style="bottom : 408px; right : 10px;"></div>
  		<header id="site-mast" class="site-mast site-mast--mini">
    		<div class="site-mast__branding cf">
        		<a class="site-logo sp-header-new-hd" href=""></a>
   			</div>
    	</header>
  		<div class="site-body pg-login cf">
      		<div class="promotion-banner">
            	<img alt="" src="res/image/merchant.jpg" width="480" height="500">
       		</div>
        	<div class="login-section">
        		<div class="validate-info" style="display:none"></div><br><br><br>
        		<h2 align="left" style="font-size: large">
            		<a href="/manager/login.aspx" class="login-type login-type--normal" id="J-login-link" style="display:none">用户登录<i></i></a>
           			 用户名
        		</h2>
    			<form method="get" action="servlet/loginServlet" id="form2" class="form form--stack">
					<div class="aspNetHidden">
						<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUJNTkxODUyOTc0ZGRvTK7TZd9HpBd3/S+VWz+JfBw30fB8W1GxVWLTeHRrKA==">
					</div>
					<div class="aspNetHidden">
						<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEdAAV09u6NxQZgfmaZeriaLPkRESCFkFW/RuhzY1oLb/NUVB2nXP6dhZn6mKtmTGNHd3PuG/voEfy+7uIzi2Rvx6fVzfg78Z8BXhXifTCAVkevd9jZoicwyP96+lM+anKNFKWTpvNSIcNjd7tcQsyYId7z">
					</div>
        			<div class="form-field form-field--icon">
        				<i class="icon icon-user"></i>
        				<input name="username" type="text" id="TextBox1" class="f-text" placeholder="账户名">
        			</div>
     				<div class="form-field form-field--icon">
           				<i class="icon icon-password"></i>
            			<input name="password" type="password" id="TextBox2" class="f-text" placeholder="密码">
       				</div>
        			<div class="form-field form-field--ops">
            			<input type="submit" name="Button1" value="登陆" id="Button1" class="btn">
        			</div>    
    			</form>
			</div>
		</div>
    	<footer class="site-info-w site-info-w--mini">
    		<div class="site-info">
        		<div class="site-info-nav cf">
  					<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    					东华大学科学与技术学院<br /><br>
    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    					版权所有 卓越软件12级 朱博宇 周敏 周佳雯 2014年4月1日
  					</font>
        		</div>
        		<div class="copyright">
            		<p></p>
        		</div>
    		</div>
		</footer>
  	</body>
</html>
