<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="panel first_panel">
    			<h3></h3>
				<div id="search">
					<div id="search_tab">
						<ul id="search_nav">
							<li id="findByGoodsName">商品名</li>
							<li id="findByGoodsID">商品号</li>
							<li id="findByStaff">员工号</li>
						</ul>
					</div>
					<div id="search_panel">
						<s:form>
							<s:textfield  id="search_content" name ="search_cnt" />
							<s:submit id="search_btn" />
							<s:textfield id="counter" name="counter" class="disappear" />
						</s:form>
					</div>
				</div>
    			</div>
    			<div class="panel panel_second">
				<div id="require">
					<div id="order">
						<a id="complexorder">综合排序</a>
						<a id="timeorder">时间排序</a>
						<a id="numorder"></a>
					</div>
					<div id="type" class="type">
						<span id="title">类别：</span>
						<div id="choose">
							<span id="board" class="board">全部</span>
							<div class="arrow"></div>
						
						<ul id="list" class="list disappear">
							<li>全部</li>
							<li>服装</li>
							<li>食品</li>
							<li>家电</li>
							<li>生活用品</li>
						</ul>
						</div>
					</div>
				</div>
				<p>共有<em></em>条记录</p>
</div>