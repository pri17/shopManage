package com.system.actions;

import java.util.List;

import com.system.model.Shop;

public class shopList {
	private List<Shop> shop;

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
	public String execute() throws Exception{
		if(shopId == -1)
			return LOGIN;
		shop = skp.getShop(shopId);
		profit = skp.getProfit(shop);
		setTtop(skp.getTopGoods(shop));
		System.out.println(ttop.size());
		setHot(skp.getHotGoods(shop));
		System.out.println(hot.size());
		System.out.println(ttop.size());
		return SUCCESS;
	}
}
