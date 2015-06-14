package com.system.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.actions.basic.shopBaseAction;
import com.system.model.Shop;
import com.system.service.shopManager;
import com.system.service.impl.shopManagerImpl;

public class shopListAction  extends shopBaseAction{
	private List<Shop> shops;
	private Shop shop;
	private int level;//等级
	
	shopListAction(){
		setLevel();
	}
	
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	
	//获取当前等级
	public void setLevel(){
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("level") == null)
			level = -1;
		else
			level = (int)ctx.getSession().get("level");
	}
	public int getLevel(){
		return this.level;
	}
	public String execute() throws Exception{
		if(level != 1)//不是管理员的都要重新登陆
			return LOGIN;
		shops=sm.getAll();
		///ActionContext.getContext().getSession().put("shops", shops);
		return SUCCESS;
	}
	public String getShopById(){
		int id=(int)ActionContext.getContext().getSession().get("shop_id");
		shop=sm.getShop(id);
		return SUCCESS;
	}

}
