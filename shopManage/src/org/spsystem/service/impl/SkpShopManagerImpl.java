package org.spsystem.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.spsystem.dao.GoodsDao;
import org.spsystem.dao.PurchaseDao;
import org.spsystem.dao.SaleDao;
import org.spsystem.dao.ShopDao;
import org.spsystem.dao.StaffDao;
import org.spsystem.dao.TypeDao;
import org.spsystem.domain.Goods;
import org.spsystem.domain.Shop;
import org.spsystem.domain.Type;
import org.spsystem.service.SkpShopManager;
import org.spsystem.vo.GoodsInfBean;
import org.spsystem.vo.JSONBean;
import org.spsystem.vo.PurchaseBean;

public class SkpShopManagerImpl implements SkpShopManager{
	private PurchaseDao purDao;
	private ShopDao shopDao;
	private GoodsDao goodsDao;
	private TypeDao typeDao;
	private StaffDao staffDao;
	private SaleDao saleDao;
		
	public PurchaseDao getPurDao() {
		return purDao;
	}
	public void setPurDao(PurchaseDao purDao) {
		this.purDao = purDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public SaleDao getSaleDao() {
		return saleDao;
	}
	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	@Override
	public Shop getShop(int shopId) {
		Shop shop= shopDao.get(Shop.class, shopId);
		return shop;
	}
	@Override
	public double getProfit(Shop shop) {
		return saleDao.findSalesPrice(shop)-purDao.findPurchasePirce(shop);
	}
	@Override
	public List<GoodsInfBean> getTopGoods(Shop shop) {
		Date now = new Date();
		Date start = new Date();
		start.setTime(now.getTime()-(7*24*3600*1000));
		
		List<Object[]> data = saleDao.findTopGoodsNum(shop, DateFormat.getDateInstance().format(start));
		List<GoodsInfBean> res = new ArrayList<GoodsInfBean>();
		int size = (data.size()>5)?5:data.size();
		for(int i = 0; i < size; i++ ){
			Object[] obj = data.get(i);
			Goods g = (Goods)obj[0];
			GoodsInfBean gib = new GoodsInfBean(g.getId(), g.getName(), (Double)obj[2], (Long)obj[1]);
			res.add(gib);
		}
		return res;
	}
	@Override
	public List<GoodsInfBean> getHotGoods(Shop shop) {
		Date now = new Date();
		Date start = new Date();
		start.setTime(now.getTime()-(7*24*3600*1000));
		
		List<Object[]> data = saleDao.findHotGoodsPrice(shop, DateFormat.getDateInstance().format(start));
		List<GoodsInfBean> res = new ArrayList<GoodsInfBean>();
		int size = (data.size()>5)?5:data.size();
		for(int i = 0; i < size; i++ ){
			Object[] obj = data.get(i);
			Goods g = (Goods)obj[0];
			GoodsInfBean gib = new GoodsInfBean(g.getId(), g.getName(), (Double)obj[2], (Long)obj[1]);
			res.add(gib);
		}
		return res;
	}
	@Override
	public String getGoodsTypeInf(Shop shop) {
		Date now = new Date();
		int year = now.getYear()+1900;
		int month = now.getMonth()+1;
        String ym = String.valueOf(year)+"-"+String.valueOf(month);
		List<Object[]> data = saleDao.findGoodsTypeNum(shop, ym);
		System.out.println("data:"+data.size());
		List<JSONBean> td = new ArrayList<JSONBean>();
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i = 0; i < data.size(); i++ ){
			Object[] obj = data.get(i);
			Type t = (Type) obj[0];
			JSONBean jb = new JSONBean(t.getName(), (Long)obj[1], "t1");
			td.add(jb);
			List<Object[]> temp = saleDao.findGoodsNumType(shop, ym, t);
			List<JSONBean> dd = new ArrayList<JSONBean>();
			for(int j = 0; j <temp.size(); j++){
				Object[] objt = temp.get(i);
				Goods gg = (Goods) objt[0];
				JSONBean jbn = new JSONBean(gg.getName(), (Long)obj[1], "");
				dd.add(jbn);
			}
			map.put("t"+i, dd);
		}
		map.put("main", td);
		JSONObject res = JSONObject.fromObject(map);
	    return res.toString();
	}
	@Override
	public String getTypeInf(Shop shop) {
		Date now = new Date();
		int year = now.getYear()+1900;
		int month = now.getMonth()+1;
        String ym = String.valueOf(year)+"-"+String.valueOf(month);
		List<Object[]> data = saleDao.findGoodsNum(shop, ym);
		List<JSONBean> td = new ArrayList<JSONBean>();
		System.out.println("data:"+data.size());
		
		Comparator<Object[]> comparator = new Comparator<Object[]>(){
			   public int compare(Object[] s1, Object[] s2) {
				   Goods g1 = (Goods)s1[0];
				   Goods g2 = (Goods)s2[0];
			   		if( g1.getType().getId() < g2.getType().getId() )
			   			return 1;
			   		else if(g1.getType().getId() == g2.getType().getId())
			   			return 0;
			   		else return -1;
			   }
		};
		Collections.sort(data,comparator);
		Map<String, Object> map = new HashMap<String, Object>();
		Object[] temp = data.get(0);
		int sign = ((Goods)temp[0]).getType().getId();
		List<JSONBean> dd = new ArrayList<JSONBean>();
		long sum = 0;
		for(int i = 0; i < data.size(); i++ ){
			Object[] obj = data.get(i);
			Goods g = (Goods)obj[0];
			if(g.getType().getId() == sign){
				dd.add(new JSONBean(g.getName(), (Long)obj[1], ""));
				sum += (Long)obj[1];
			}else{
				map.put("t"+sign, dd);
				td.add(new JSONBean(g.getType().getName(), sum, "t"+sign));
				dd.clear();
				sum=0;
				sign = g.getType().getId();
				i--;
			}
		}
		map.put("main", td);
		JSONObject res = JSONObject.fromObject(map);
	    return res.toString();
	}

}
