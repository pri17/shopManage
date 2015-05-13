<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goods</title>
<%@include file="link.jsp"%>
<script src="resc/goods.js"></script>
<script src="resc/highcharts.js"></script>
<script src="resc/exporting.js"></script>
<link rel="stylesheet" type="text/css" href="resc/goods.css">
<link rel="stylesheet" type="text/css" href="resc/g_form.css">
<link rel="stylesheet" type="text/css" href="resc/checkinf.css">
</head>
<body class="main_page">
<%@include file="header.jsp"%>
<div class="container clearfix" id="contain">
	<%@include file="asider.jsp"%>
	<div class="main_content">
	<%@include file="firster.jsp"%>
		<div class="panel_table">
				<table>
					<thead>
						<tr>
							<th></th>
							<th><b>商品编号</b></th>
							<th>商品名</th>
							<th>类别</th>
							<th>库存</th>
							<th>销量</th>
							<th>利润</th>
							<th>详情</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="goods" status="index">  
 							<tr> 
 							<td><input class="checkbox" type="checkbox" /></td>
							<td class="td_id"><s:property value="id"/></td>
							<td class="td_name"><s:property value="name"/></td>
							<td><s:property value="type"/></td>
							<td class="td_ivy"><s:property value="inventory"/></td>
							<td class="td_num"><s:property value="salenum"/></td>
							<s:if test="profit>0">
								<td class="td_profit" style="color:red">
							</s:if>
							<s:else>
								<td class="td_profit" style="color:green">
							</s:else>
								<s:property value="profit"/></td>
							<td><a class="charts">销售分析</a><br/><a class="purchase">进货历史</a><br/><a class="sale">销售历史</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				
		</div>
	</div>
	<div class="changeForm disappear">
					
		</div>
		<div id="checkInf">
					<input id="selectall" type="checkbox" /><span id="ps">全选</span>
					<div id="inf">
						<span>已选中<strong id="checknum">0</strong>个商品</span>
						<span>余货<strong id="goodsnum">0</strong>件</span>
						<span>利润：￥<strong id="amount">0.00</strong></span>
					</div>
				</div>
</div>
</body>
</html>