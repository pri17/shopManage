package com.system.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.system.model.Shop;
import com.system.service.shopManager;
import com.system.service.impl.shopManagerImpl;

public class shopListAction extends ActionSupport implements RequestAware{
	private List<Shop> shop;
	private shopManagerImpl sm;
	private Map<String ,Object> request;
	public Map<String, Object> getRequest() {
		return request;
	}

	public shopManager getSm() {
		return sm;
	}

	public void setSm(shopManagerImpl sm) {
		this.sm = sm;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
	public String execute() throws Exception{
		request.put("shops", sm.getAll());
		return SUCCESS;
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
}
