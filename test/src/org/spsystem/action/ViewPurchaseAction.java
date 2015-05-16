package org.spsystem.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.spsystem.action.base.SkpPurchaseBaseAction;
import org.spsystem.vo.PurchaseBean;

import com.opensymphony.xwork2.ActionContext;

public class ViewPurchaseAction extends SkpPurchaseBaseAction{
	private List purchases;
	private int shopId;
	private String search_cnt;
	private String goodsType;
	private int counter;
	

	ViewPurchaseAction(){
		getshopId();
	}
	
	public void setGoodsType( String goodsType ){
		this.goodsType = goodsType;
	}
	public String getGoodsType(){
		return goodsType;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	private void getshopId(){
		//shopId= 1;
		ActionContext ctx = ActionContext.getContext();
		if(ctx.getSession().get("shopId") == null)
			shopId = -1;
		else
			shopId = (int)ctx.getSession().get("shopId");
	}
	
	public void setSearch_cnt(String search_cnt){
		this.search_cnt = search_cnt;
	}
	public String getSearch_cnt(){
		return search_cnt;
	}
	
	public List getPurchases() {
		return purchases;
	}

	public void setPurchases(List purchases) {
		this.purchases = purchases;
		setCounter(purchases.size());
	}
	
	public String execute() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> res = skp.getAllPurchase(shopId);
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String timeOrder() throws Exception{
		if(shopId == -1)
			return LOGIN;
		setPurchases((List) ActionContext.getContext().getSession().get("purchase"));
		Comparator<PurchaseBean> comparator = new Comparator<PurchaseBean>(){
			   public int compare(PurchaseBean s1, PurchaseBean s2) {
			   		return s2.getDate() .compareTo(s1.getDate());
			   }
		};
		Collections.sort(purchases,comparator);
		//List<PurchaseBean> res = skp.getAllPurchaseOrderbyTime(shopId);
		//setPurchases(res);
		return SUCCESS;
	}
	
	public String numOrder() throws Exception{
		if(shopId == -1)
			return LOGIN;
		setPurchases((List) ActionContext.getContext().getSession().get("purchase"));
		Comparator<PurchaseBean> comparator = new Comparator<PurchaseBean>(){
			   public int compare(PurchaseBean s1, PurchaseBean s2) {
			   		if(s1.getNum() < s2.getNum()) return 1;
			   		else if(s1.getNum() == s2.getNum()) return 0;
			   		else return -1;
			   }
		};
		Collections.sort(purchases,comparator);
		//List<PurchaseBean> res = skp.getAllPurchaseOrderbyNum(shopId);
		//setPurchases(res);
		return SUCCESS;
	}
	
	public String findByGoodsId() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> res = skp.getPurchaseByGoods(shopId, Integer.valueOf(getSearch_cnt()));
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
	
	public String findByGoodsName() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> res = skp.getPurchaseByGoods(shopId, getSearch_cnt());
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
	
	public String findByStaff() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> res = skp.getPurchaseByStaff(shopId, Integer.valueOf(search_cnt.replace(" ", "")));
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
	
	public String chooseType() throws Exception{
		if(shopId == -1)
			return LOGIN;
		List<PurchaseBean> orgin = (List) ActionContext.getContext().getSession().get("purchase");
		HttpServletRequest request=ServletActionContext.getRequest();
		int type = Integer.valueOf(request.getParameter("type"));
		if( type == 0 )
			setPurchases(orgin);
		else{
			List<PurchaseBean> res = skp.getPurchaseByType(orgin, type);
			setPurchases(res);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		if(shopId == -1)
			return LOGIN;
		setPurchases((List) ActionContext.getContext().getSession().get("purchase"));
		HttpServletRequest request=ServletActionContext.getRequest();
		int index = Integer.valueOf(request.getParameter("id"));
		int id = ((PurchaseBean)purchases.get(index)).getId();
		skp.deletePurchase(id);
		purchases.remove(index);
		return SUCCESS;
	}
	
	public String viewGoodsPurchases() throws Exception{
		if(shopId == -1)
			return LOGIN;
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		List<PurchaseBean> res = skp.getPurchaseByGoods(shopId, id);
		setPurchases(res);
		ActionContext.getContext().getSession().put("purchase", purchases);
		return SUCCESS;
	}
	
}
