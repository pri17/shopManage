package org.spsystem.action;

import java.util.List;

import org.spsystem.action.base.SkpSaleBaseAction;
import org.spsystem.vo.SaleBean;

import com.opensymphony.xwork2.ActionContext;

public class ChangeSaleAction extends SkpSaleBaseAction{
	private String c_goodsName;
	private double c_price;
	private int c_num;
	private List sales;
	private int shopId;
	private int c_saleIdx;
	private int counter;
	
	ChangeSaleAction(){
		setShopId();
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getC_goodsName() {
		return c_goodsName;
	}
	public void setC_goodsName(String c_goodsName) {
		this.c_goodsName = c_goodsName;
	}

	public double getC_price() {
		return c_price;
	}
	public void setC_price(double c_price) {
		this.c_price = c_price;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getC_saleIdx() {
		return c_saleIdx;
	}
	public void setC_saleIdx(int c_saleIdx) {
		this.c_saleIdx = c_saleIdx;
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
			shopId = (int)ctx.getSession().get("shopId");
	}
	
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	public List getSales() {
		return sales;
	}
	public void setSales(List sales) {
		this.sales = sales;
		setCounter(sales.size());
		ActionContext.getContext().getSession().put("sale", sales);
	}
	public String execute() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<SaleBean> res = (List) ActionContext.getContext().getSession().get("sale");
		SaleBean p = res.get(c_saleIdx);
		p.setName(c_goodsName);
		p.setNum(c_num);
		p.setPrice(c_price);
		skp.changeSale(p);
		res.set(c_saleIdx, p);
		setSales(res);
		return SUCCESS;
	}
}
