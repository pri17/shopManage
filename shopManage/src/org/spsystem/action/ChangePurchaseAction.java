package org.spsystem.action;

import java.util.List;

import org.spsystem.action.base.SkpPurchaseBaseAction;
import org.spsystem.vo.PurchaseBean;

import com.opensymphony.xwork2.ActionContext;

public class ChangePurchaseAction extends SkpPurchaseBaseAction{
	private String c_goodsName;
	private int c_typeId;
	private double c_price;
	private int c_num;
	private List purchases;
	private int shopId;
	private int c_purIdx;
	
	public String getC_goodsName() {
		return c_goodsName;
	}
	public void setC_goodsName(String c_goodsName) {
		this.c_goodsName = c_goodsName;
	}
	public int getC_typeId() {
		return c_typeId;
	}
	public void setC_typeId(int c_typeId) {
		this.c_typeId = c_typeId;
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
	public int getC_purIdx() {
		return c_purIdx;
	}
	public void setC_purIdx(int c_purIdx) {
		this.c_purIdx = c_purIdx;
	}
	
	ChangePurchaseAction(){
		getshopId();
		c_typeId = -1;
	}
	
	private void getshopId(){
		//shopId= 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (Integer)ctx.getSession().get("shopId");
	}
	
	public void setPurchases(List purchases) {
		this.purchases = purchases;
	}
	
	public List getPurchases() {
		return purchases;
	}
	
	public String execute() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> res = (List) ActionContext.getContext().getSession().get("purchase");
		PurchaseBean p = res.get(c_purIdx);
		p.setName(c_goodsName);
		p.setNum(c_num);
		p.setPrice(c_price);
		skp.changePurchase(p, c_goodsName, c_typeId);
		res.set(c_purIdx, p);
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
}
