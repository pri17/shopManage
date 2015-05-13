package org.spsystem.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.spsystem.action.base.SkpSaleBaseAction;
import org.spsystem.vo.PurchaseBean;
import org.spsystem.vo.SaleBean;

import com.opensymphony.xwork2.ActionContext;

public class ViewSaleAction  extends SkpSaleBaseAction{
	private List<SaleBean> sales;
	private int shopId;
	private int counter;
	private String search_cnt;
	
	ViewSaleAction(){
		setShopId();
	}
	
	public List<SaleBean> getSales() {
		return sales;
	}
	public void setSales(List<SaleBean> sales) {
		this.sales = sales;
		setCounter(sales.size());
		ActionContext.getContext().getSession().put("sale", sales);
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId() {
		//shopId= 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (Integer)ctx.getSession().get("shopId");
	}
	
	public void setShopId(int shopId) {
		this.shopId= shopId;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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
		List<SaleBean> res = skp.getAllSale(shopId);
		setSales(res);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String timeOrder() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = (List<SaleBean>) ActionContext.getContext().getSession().get("sale");
		Comparator<SaleBean> comparator = new Comparator<SaleBean>(){
			   public int compare(SaleBean s1, SaleBean s2) {
			   		return s2.getDate() .compareTo(s1.getDate());
			   }
		};
		Collections.sort(res,comparator);
		setSales(res);
		return SUCCESS;
	}
	
	public String numOrder() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = (List<SaleBean>) ActionContext.getContext().getSession().get("sale");
		Comparator<SaleBean> comparator = new Comparator<SaleBean>(){
			   public int compare(SaleBean s1, SaleBean s2) {
			   		if(s1.getNum() < s2.getNum()) return 1;
			   		else if(s1.getNum() == s2.getNum()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(res,comparator);
		setSales(res);
		return SUCCESS;
	}
	
	public String findByGoodsId() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = skp.getSaleByGoods(shopId, Integer.valueOf(getSearch_cnt()));
		setSales(res);
		return SUCCESS;
	}
	
	public String findByGoodsName() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = skp.getSaleByGoods(shopId, getSearch_cnt());
		setSales(res);
		return SUCCESS;
	}
	
	public String findByStaff() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = skp.getSaleByStaff(shopId, Integer.valueOf(search_cnt.replace(" ", "")));
		setSales(res);
		return SUCCESS;
	}
	
	public String chooseType() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> orgin = (List<SaleBean>) ActionContext.getContext().getSession().get("sale");
		HttpServletRequest request=ServletActionContext.getRequest();
		int type = Integer.valueOf(request.getParameter("type"));
		if( type == 0 )
			setSales(orgin);
		else{
			List<SaleBean> res = skp.getSaleByType(orgin, type);
			setSales(res);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = (List<SaleBean>) ActionContext.getContext().getSession().get("sale");
		HttpServletRequest request=ServletActionContext.getRequest();
		int index = Integer.valueOf(request.getParameter("id"));
		int id = ((SaleBean)res.get(index)).getId();
		skp.deleteSale(id);
		res.remove(index);
		setSales(res);
		return SUCCESS;
	}
	public String findGoodsSales() throws Exception{
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		List<SaleBean> res = skp.getSaleByGoods(shopId, id);
		setSales(res);
		return SUCCESS;
	}
	
}
