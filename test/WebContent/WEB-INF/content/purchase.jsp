<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase</title>
<%@include file="link.jsp"%>
<script src="resc/purchase.js"></script>
<link rel="stylesheet" type="text/css" href="resc/purchase.css">
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
							<th><b>进货单编号</b></th>
							<th>商品名</th>
							<th>进货时间</th>
							<th>原价</th>
							<th>数量</th>
							<th>负责人</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="purchases" status="index">  
 							<tr> 
 							<td><input class="checkbox" type="checkbox" /></td>
							<td class="td_id"><s:property value="id"/></td>
							<td class="td_name"><s:property value="name"/></td>
							<td><s:property value="date"/></td>
							<td class="td_price"><s:property value="price"/></td>
							<td class="td_num"><s:property value="num"/></td>
							<td><s:property value="staff"/></td>
							<td><a class="changepur">修改</a><br/><a class="deletepur">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				
		</div>
		
	</div>
	<div class="changeForm disappear">
					<s:form>
						<div id="c_tag">
							<ul id="c_nav">
								<li id="c_orgin"  class=" c_active">原有</li>
								<li id="c_new">新品</li>
							</ul>
						</div>
						<div id="c_type" class="type disappear">
							<span id="title">类别：</span>
							<div id="c_choose">
								<span id="c_board" class="board">全部</span>
								<div class="arrow"></div>
							
							<ul id="c_list" class="list disappear">
								<li>全部</li>
								<li>服装</li>
								<li>食品</li>
								<li>家电</li>
								<li>生活用品</li>
							</ul>
							</div>
						</div>
						<s:textfield name="c_goodsName" id="c_goodsName" key="商品名"></s:textfield>
						<s:textfield name="c_typeId" id="c_typeId" class="disappear"></s:textfield>
						<s:textfield name="c_price" id="c_price" key="价格"></s:textfield>
						<s:textfield name="c_purIdx" id="c_purIdx" class="disappear"></s:textfield>
						<s:textfield name="c_num"  id="c_num" key="数量"></s:textfield>
						<s:submit id="c_save" key="保 存"/>
					</s:form>
				</div>
				<div id="checkInf">
					<input id="selectall" type="checkbox" /><span id="ps">全选</span>
					<div id="inf">
						<span>已选中<strong id="purnum">0</strong>个进货单</span>
						<span>进货<strong id="goodsnum">0</strong>件</span>
						<span>成本：￥<strong id="amount">0.00</strong></span>
					</div>
				</div>
</div>
</body>
</html>