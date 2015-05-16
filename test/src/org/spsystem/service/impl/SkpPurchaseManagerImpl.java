package org.spsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.spsystem.dao.*;
import org.spsystem.domain.*;
import org.spsystem.service.SkpPurchaseManager;
import org.spsystem.vo.PurchaseBean;

public class SkpPurchaseManagerImpl implements SkpPurchaseManager{
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
	public List<PurchaseBean> getAllPurchase(int shopId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		
		List<Purchase> pur = purDao.findByShop(shop);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getAllPurchaseOrderbyTime(int shopId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		
		List<Purchase> pur = purDao.findOrderbyTime(shop);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getAllPurchaseOrderbyNum(int shopId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		
		List<Purchase> pur = purDao.findOrderbyNum(shop);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getPurchaseByType(int shopId, int typeId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Type type = typeDao.get(Type.class, typeId);
		
		List<Purchase> pur = purDao.findByType(shop, type);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getPurchaseByGoods(int shopId, String goodsName) {
		Shop shop = shopDao.get(Shop.class, shopId);
		
		List<Purchase> pur = purDao.findGoodsByShop(shop, goodsName);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getPurchaseByStaff(int shopId, int staffId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Staff staff = staffDao.get(Staff.class, staffId);
		
		List<Purchase> pur = purDao.findGoodsByStaff(shop, staff);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getPurchaseByGoods(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		
		List<Purchase> pur = purDao.findByGoods(shop, goods);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		
		for(Purchase p:pur){
			res.add(new PurchaseBean(p.getId(), p.getGoods().getName(), p.getWorkDay(), p.getPurchaseTime(), p.getInprice(), p.getNum(), p.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<PurchaseBean> getPurchaseByType(List<PurchaseBean> data,
			int typeId) {
		Type t = typeDao.get(Type.class, typeId);
		List<PurchaseBean> res = new ArrayList<PurchaseBean>();
		for(PurchaseBean p:data){
			Goods g = goodsDao.findByGoodsName(p.getName()).get(0);			
			if((g.getType()).equals(t))
				res.add(p);
		}
		return res;
	}
	public void deletePurchase(){
		
	}

	@Override
	public void deletePurchase(int id) {
		purDao.delete(Purchase.class, id);
	}

	@Override
	public void changePurchase(PurchaseBean p, String goodsName, int type) {
		Purchase obj = purDao.get(Purchase.class, p.getId());
		if(!(goodsName.replace(" ", "")).equals(obj.getGoods().getName())){
			Goods g = new Goods();
			if(type != -1){
				Type t = typeDao.get(Type.class, type);
				g.setName(goodsName);
				g.setType(t);
				goodsDao.save(g);
			}else{
				g = goodsDao.findByGoodsName(goodsName).get(0);
			}
			obj.setGoods(g);
		}
		obj.setInprice(p.getPrice());
		obj.setNum(p.getNum());
		purDao.update(obj);
	}
}
