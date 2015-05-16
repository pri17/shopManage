package org.spsystem.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.spsystem.action.base.SkpGoodsBaseAction;
import org.spsystem.vo.*;

import com.opensymphony.xwork2.ActionContext;

public class ViewGoodsAction extends SkpGoodsBaseAction{
	private List<GoodsBean> goods;
	private int shopId;
	private String search_cnt;
	private int counter;
	
	ViewGoodsAction(){
		setShopId();
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public List<GoodsBean> getGoods() {
		return goods;
	}
	public void setGoods(List<GoodsBean> goods) {
		this.goods = goods;
		setCounter(goods.size());
		ActionContext.getContext().getSession().put("goods", goods);
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(){
		//shopId= 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (int)ctx.getSession().get("shopId");
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getSearch_cnt() {
		return search_cnt;
	}
	public void setSearch_cnt(String search_cnt) {
		this.search_cnt = search_cnt;
	}
	public String execute() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = skp.getAllGoods(shopId);
		setGoods(res);
		return SUCCESS;
	}
	
	public String findByGoodsId() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = skp.getGoodsById(shopId, Integer.valueOf(getSearch_cnt()));
		setGoods(res);
		return SUCCESS;
	}
	
	public String findByGoodsName() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res =skp.getGoodsByName(shopId, search_cnt);
		setGoods(res);
		return SUCCESS;
	}
	
	public String chooseType() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> orgin = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		HttpServletRequest request=ServletActionContext.getRequest();
		int type = Integer.valueOf(request.getParameter("type"));
		if( type == 0 )
			setGoods(orgin);
		else{
			List<GoodsBean> res = skp.getGoodsByType(orgin, type);
			setGoods(res);
		}
		return SUCCESS;
	}
	
	public String numOrderHigh() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
			   		if(s1.getSalenum() < s2.getSalenum()) return 1;
			   		else if(s1.getSalenum() == s2.getSalenum()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String numOrderLow() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
			   		if(s1.getSalenum() > s2.getSalenum()) return 1;
			   		else if(s1.getSalenum() == s2.getSalenum()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String leftOrderHigh() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
				   long a = s1.getInventory()-s1.getSalenum();
				   long b = s2.getInventory()-s2.getSalenum();
			   		if(a< b) return 1;
			   		else if(a == b) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String leftOrderLow() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
				   long a = s1.getInventory()-s1.getSalenum();
				   long b = s2.getInventory()-s2.getSalenum();
			   		if(a> b) return 1;
			   		else if(a == b) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String profitOrderHigh() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
			   		if(s1.getProfit() < s2.getProfit()) return 1;
			   		else if(s1.getProfit() == s2.getProfit()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String profitOrderLow() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<GoodsBean> res = (List<GoodsBean>) ActionContext.getContext().getSession().get("goods");
		Comparator<GoodsBean> comparator = new Comparator<GoodsBean>(){
			   public int compare(GoodsBean s1, GoodsBean s2) {
			   		if(s1.getProfit() > s2.getProfit()) return 1;
			   		else if(s1.getProfit() == s2.getProfit()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setGoods(res);
		return SUCCESS;
	}
	
	public String viewGoodsById(){
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		List<GoodsBean> res = skp.getGoodsById(shopId, id);
		setGoods(res);
		return SUCCESS;
	}
}
