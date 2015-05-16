package org.spsystem.action;

import java.util.List;

import org.spsystem.action.base.SkpShopBaseAction;
import org.spsystem.domain.Shop;
import org.spsystem.vo.GoodsInfBean;

import com.opensymphony.xwork2.ActionContext;

public class ViewShopAction extends SkpShopBaseAction{
	private Shop shop;
	private int shopId;
	private double profit;
	private List<GoodsInfBean> ttop;
	private List<GoodsInfBean> hot;
	
	private String res;
	
	ViewShopAction(){
		setShopId();
	}
	
	private void setShop() {
		shop = skp.getShop(shopId);
	}

	public  void setShopId(){
		//shopId = 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (int)ctx.getSession().get("shopId");
	}
	
	public int getShopId(){
		return shopId;
	}
	
	public void setShopId(int shopId){
		this.shopId = shopId;
	}
	
	public void setShop(Shop shop){
		this.shop = shop;
	}
	
	public Shop getShop(){
		return shop;
	}
	
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public List<GoodsInfBean> getHot() {
		return hot;
	}

	public void setHot(List<GoodsInfBean> hot) {
		this.hot = hot;
	}

	public List<GoodsInfBean> getTtop() {
		return ttop;
	}

	public void setTtop(List<GoodsInfBean> top) {
		this.ttop = top;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
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
	
	public String getTypeNum(){
		if(shopId == -1)
			return LOGIN;
		res = skp.getTypeInf(shop);
		return SUCCESS;
	}
}
