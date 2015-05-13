<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale</title>
<%@include file="link.jsp"%>
<script src="resc/sale.js"></script>
<link rel="stylesheet" type="text/css" href="resc/sale.css">
<link rel="stylesheet" type="text/css" href="resc/c_form.css">
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
							<th><b>售货单编号</b></th>
							<th>商品名</th>
							<th>售货时间</th>
							<th>售价</th>
							<th>数量</th>
							<th>负责人</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="sales" status="index">  
 							<tr> 
 							<td><input class="checkbox" type="checkbox" /></td>
							<td class="td_id"><s:property value="id"/></td>
							<td class="td_name"><s:property value="name"/></td>
							<td><s:property value="date"/></td>
							<td class="td_price"><s:property value="price"/></td>
							<td class="td_num"><s:property value="num"/></td>
							<td><s:property value="staff"/></td>
							<td><a class="changesale">修改</a><br/><a class="deletesale">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				
		</div>
	</div>
	<div class="changeForm disappear">
					<s:form>
						<s:textfield name="c_goodsName" id="c_goodsName" key="商品名"></s:textfield>
						<s:textfield name="c_saleIdx" id="c_saleIdx" class="disappear"></s:textfield>
						<s:textfield name="c_price" id="c_price" key="价格"></s:textfield>
						<s:textfield name="c_num"  id="c_num" key="数量"></s:textfield>
						<s:submit id="c_save" key="保 存"/>
					</s:form>
		</div>
		<div id="checkInf">
					<input id="selectall" type="checkbox" /><span id="ps">全选</span>
					<div id="inf">
						<span>已选中<strong id="salenum">0</strong>个售货单</span>
						<span>售货<strong id="goodsnum">0</strong>件</span>
						<span>收入：￥<strong id="amount">0.00</strong></span>
					</div>
				</div>
</div>
</body>
</html>