package org.spsystem.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.spsystem.action.base.SkpGoodsBaseAction;

import com.opensymphony.xwork2.ActionContext;

public class ViewGoodsJSON extends SkpGoodsBaseAction{
	private String res;
	private int shopId;
	
	ViewGoodsJSON(){
		setShopId();
	}
	
	public void setShopId(){
		//shopId= 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (Integer)ctx.getSession().get("shopId");
	}
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}
	
	public String findGoodsPurchases(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		res = skp.getGoodsPurchase(shopId, id);
		return SUCCESS;
	}
	
	public String findGoodsSales(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		res = skp.getGoodsSalas(shopId, id);
		return SUCCESS;
	}
	
	public String findGoodsSaleNumScale(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		res = skp.getGoodsSaleScale(shopId, id);
		return SUCCESS;
	}
	
	public String findGoodsProfitScale(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		res = skp.getGoodsProfitScale(shopId, id);
		return SUCCESS;
	}
	
	public String findGoodsSaleInf(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			res = skp.getGoodsSaleInf(shopId, id);
		} catch (Exception e) {
			e.printStackTrace();
			res = e.toString();
		}
		return SUCCESS;
	}
	
	public String findGoodsSalePriceNum(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		res = skp.getGoodsSalePriceNum(shopId, id);
		return SUCCESS;
	}
}
