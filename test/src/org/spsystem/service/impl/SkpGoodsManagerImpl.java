package org.spsystem.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.spsystem.dao.*;
import org.spsystem.domain.*;
import org.spsystem.service.SkpGoodsManager;
import org.spsystem.vo.*;

public class SkpGoodsManagerImpl implements SkpGoodsManager{
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
	public List<GoodsBean> getAllGoods(int shopId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		List<Goods> orgin = goodsDao.findGoodsByShop(shop);
		List<Object[]> pur = (goodsDao.findPurchaseInfByGoods(shop));
		List<Object[]> sale = goodsDao.findSaleInfByGoods(shop);
		List<GoodsBean> res = new ArrayList<GoodsBean>();
		
		int purIdx = 0, saleIdx = 0;
		for(Goods g:orgin){
			GoodsBean gb = new GoodsBean(g.getName(), g.getId(), 0, 0, 0, g.getType().getName());
			if(purIdx<pur.size()){
				Object[] purGib = pur.get(purIdx);
				if(g.getId() == purGib[0]){
					gb.setInventory((long) purGib[1]);
					gb.setProfit(-(double)purGib[2]);
					purIdx++;
				}
			}
			if(saleIdx<sale.size()){
				Object[] saleGib = sale.get(saleIdx);
				if(g.getId() == saleGib[0]){
					gb.setSalenum((long)saleGib[1]);
					gb.setProfit(gb.getProfit()+(double)saleGib[2]);
					saleIdx++;
				}
			}
			res.add(gb);
		}
		return res;
	}

	@Override
	public List<GoodsBean> getGoodsByName(int shopId, String goodsName) {
		Shop shop = shopDao.get(Shop.class, shopId);
		List<Goods> orgin = goodsDao.findGoodsByName(shop, goodsName);
		List<Object[]> pur = goodsDao.findPurchaseInfByName(shop, goodsName);
		List<Object[]> sale = goodsDao.findSaleInfByName(shop, goodsName);
		List<GoodsBean> res = new ArrayList<GoodsBean>();
		
		int purIdx = 0, saleIdx = 0;
		for(Goods g:orgin){
			GoodsBean gb = new GoodsBean(g.getName(), g.getId(), 0, 0, 0, g.getType().getName());
			if(purIdx<pur.size()){
				Object[] purGib = pur.get(purIdx);
				if(g.getId() == purGib[0]){
					gb.setInventory((long) purGib[1]);
					gb.setProfit(-(double)purGib[2]);
					purIdx++;
				}
			}
			if(saleIdx<sale.size()){
				Object[] saleGib = sale.get(saleIdx);
				if(g.getId() == saleGib[0]){
					gb.setSalenum((long)saleGib[1]);
					gb.setProfit(gb.getProfit()+(double)saleGib[2]);
					saleIdx++;
				}
			}
			res.add(gb);
		}
		return res;
	}

	@Override
	public List<GoodsBean> getGoodsById(int shopId, int goodsId) {
		List<GoodsBean> res = new ArrayList<GoodsBean>();
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		if(goods==null)
			return res;
		List<Object[]> pur = goodsDao.findPurchaseInfByGoods(shop, goods);
		List<Object[]> sale = goodsDao.findSaleInfByGoods(shop, goods);
		
		
		GoodsBean gb = new GoodsBean(goods.getName(), goods.getId(), 0, 0, 0, goods.getType().getName());
		if(pur.size() > 0){
			gb.setInventory((long)pur.get(0)[1]);
			gb.setProfit(-(double)pur.get(0)[2]);
		}
			if(sale.size() > 0){
				gb.setSalenum((long)sale.get(0)[1]);
				gb.setProfit(gb.getProfit()+(double)sale.get(0)[2]);
			}
			res.add(gb);
		return res;
	}

	@Override
	public List<GoodsBean> getGoodsByType(List<GoodsBean> data, int typeId) {
		Type type = typeDao.get(Type.class, typeId);
		List<GoodsBean> res = new ArrayList<GoodsBean>();
		for(GoodsBean g:data){
			if(g.getType().equals(type.getName()))
				res.add(g);
		}
		return res;
	}

	@Override
	public String getGoodsPurchase(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		List<Purchase> pur = purDao.findGoodsPurchases(shop, goods, 10);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		JSONArray json = JSONArray.fromObject(res);
		return json.toString();
	}

	@Override
	public String getGoodsSalas(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		List<Sale> sale = saleDao.findGoodsSales(shop, goods, 10);
		List<SaleBean> res = new ArrayList<SaleBean>();
		
		for(Sale s:sale){
			res.add(new SaleBean(s.getId(), s.getGoods().getName(), s.getWorkDay(), s.getSaleTime(), s.getPrice(), s.getNum(), s.getStaff().getName()));
		}
		JSONArray json = JSONArray.fromObject(res);
		return json.toString();
	}

	@Override
	public String getGoodsSaleScale(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		Map<String, Object> map = new HashMap<String, Object>();
		Date now = new Date();
		String year = String.valueOf(now.getYear()+1900);
		long num = saleDao.findGoodsSalesNumByYear(shop, goods, year);
		long amount = saleDao.findSalesNumByYear(shop, year);
		//double scale = (amount == 0)?0:(num*100.0/amount);
		//System.out.println(num);
		//System.out.println(amount);
		map.put("name", goods.getName());
		map.put("num", num);
		map.put("amount", amount-num);
		//map.put("scale", scale);
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
		return json.toString();
	}

	@Override
	public String getGoodsProfitScale(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		Map<String, Object> map = new HashMap<String, Object>();
		Date now = new Date();
		String year = String.valueOf(now.getYear()+1900);
		double num = saleDao.findGoodsSalesPriceByYear(shop, goods, year) - purDao.findGoodsPurchasesPriceByYear(shop, goods, year);
		double amount = saleDao.findSalesPriceByYear(shop, year) - purDao.findPurchasesPriceByYear(shop, year);
		//double scale = (amount == 0)?0:(num*100.0/amount);
		map.put("name", goods.getName());
		map.put("num", num);
		map.put("amount", amount-num);
		//map.put("scale", scale);
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}

	public int DateDuring(Date d1, Date d2){
		long t1 = d1.getTime();
		long t2 = d2.getTime();
		long res = (t2-t1)/(3600*24*1000);
		return (int)res;
	}
	
	@Override
	public String getGoodsSaleInf(int shopId, int goodsId) throws Exception {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		List<Object[]> res = saleDao.findGoodsByDate(shop, goods);
		Date start = new Date(115, 2, 1);
		Date now = new Date();
		int size = DateDuring(start, now);
		DateFormat ymd = new SimpleDateFormat("yyyy-MM-dd"); 
		long a[] = new long[size+1];
		double b[] = new double[size+1];
		for(int i = 0; i < size; i++){
			a[i] = 0;b[i] = 0;
		}
		for(Object[] n:res){
			String date = (String) n[0];
			Date d = ymd.parse(date);
			int dis = DateDuring(start, d);
			a[dis] = (long)n[1];
			b[dis] =(double)n[2];
		}
		JSONArray json = JSONArray.fromObject(a);
		JSONArray json1 = JSONArray.fromObject(b);
		return "["+json.toString()+", "+json1.toString()+"]";
	}

	@Override
	public String getGoodsSalePriceNum(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		List<Object[]> res = saleDao.findGoodsSalesPriceNum(shop, goods);
		JSONArray json = JSONArray.fromObject(res);
		return json.toString();
	}
}
