<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Shop</title>
<%@include file="link.jsp"%>
<link rel="stylesheet" type="text/css" href="resc/shop.css">
<script src="resc/highcharts.js"></script>
<script src="resc/exporting.js"></script>
<script src="resc/shop.js"></script>
</head>
<body class="main_page">
<%@include file="header.jsp"%>
<div class="container clearfix" id="contain">
	<%@include file="asider.jsp"%>
	
	<div class="main_content">
	<ul id="nav">
		<li id="shop" class="nav_li li_active">店铺信息</li>
		<li id="shopsale" class="nav_li disappear">销售分析</li>
	</ul>
	<div class="content">
		<div id="shopInf">
			<s:iterator value="shop" >
				<span><strong>店名：</strong><s:property value="name"/></span>
				<span><strong>店主：</strong><s:property value="staff.name"/></span>
				<span><strong>地址：</strong><s:property value="district"/></span>
				<span><strong>金额：</strong><s:property value="price"/></span>
			</s:iterator>
				<span><strong>盈利：</strong><s:property value="profit"/></span>
		</div>
		<div id="goods">
			<h2>5佳畅销商品</h2>
			<table>
				<thead>
					<th>商品名</th>
					<th>销量</th>
					<th>盈利</th>
				</thead>
				<tbody>
					<s:iterator value="ttop"> 
 							<tr> 
 							<td><a href="viewGoodsById?id=<s:property value="id"/>"><s:property value="name"/></a></td>
							<td><s:property value="num"/></td>
							<td><s:property value="price"/></td>
							</tr>
						</s:iterator>
				</tbody>
			</table>
			
			<h2>5佳盈利商品</h2>
			<table>
				<thead>
					<th>商品名</th>
					<th>销量</th>
					<th>盈利</th>
				</thead>
				<tbody>
					<s:iterator value="hot">  
 							<tr> 
 							<td><a href="viewGoodsById?id=<s:property value="id"/>"><s:property value="name"/></a></td>
							<td><s:property value="num"/></td>
							<td><s:property value="price"/></td>
							</tr>
						</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<div class="chartcontainer disappear">
	</div>
	</div>
</div>
</body>
</html>