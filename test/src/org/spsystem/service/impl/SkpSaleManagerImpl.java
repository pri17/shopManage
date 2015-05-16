package org.spsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.spsystem.dao.*;
import org.spsystem.domain.*;
import org.spsystem.service.SkpSaleManager;
import org.spsystem.vo.PurchaseBean;
import org.spsystem.vo.SaleBean;


public class SkpSaleManagerImpl implements SkpSaleManager {
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
	public List<SaleBean> getAllSale(int shopId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		
		List<Sale> sale = saleDao.findByShop(shop);
		List<SaleBean> res = new ArrayList<SaleBean>();
		
		for(Sale s:sale){
			res.add(new SaleBean(s.getId(), s.getGoods().getName(), s.getWorkDay(), s.getSaleTime(), s.getPrice(), s.getNum(), s.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<SaleBean> getSaleByGoods(int shopId, String goodsName) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.findByGoodsName(goodsName).get(0);
		
		List<Sale> sale = saleDao.findByGoods(shop, goods);
		List<SaleBean> res = new ArrayList<SaleBean>();
		
		for(Sale s:sale){
			res.add(new SaleBean(s.getId(), s.getGoods().getName(), s.getWorkDay(), s.getSaleTime(), s.getPrice(), s.getNum(), s.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<SaleBean> getSaleByGoods(int shopId, int goodsId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Goods goods = goodsDao.get(Goods.class, goodsId);
		
		List<Sale> sale = saleDao.findByGoods(shop, goods);
		List<SaleBean> res = new ArrayList<SaleBean>();
		
		for(Sale s:sale){
			res.add(new SaleBean(s.getId(), s.getGoods().getName(), s.getWorkDay(), s.getSaleTime(), s.getPrice(), s.getNum(), s.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<SaleBean> getSaleByStaff(int shopId, int staffId) {
		Shop shop = shopDao.get(Shop.class, shopId);
		Staff staff = staffDao.get(Staff.class, staffId);
		
		List<Sale> sale = saleDao.findByStaff(shop, staff);
		List<SaleBean> res = new ArrayList<SaleBean>();
		
		for(Sale s:sale){
			res.add(new SaleBean(s.getId(), s.getGoods().getName(), s.getWorkDay(), s.getSaleTime(), s.getPrice(), s.getNum(), s.getStaff().getName()));
		}
		return res;
	}

	@Override
	public List<SaleBean> getSaleByType(List<SaleBean> data, int typeId) {
		Type t = typeDao.get(Type.class, typeId);
		List<SaleBean> res = new ArrayList<SaleBean>();
		for(SaleBean p:data){
			Goods g = goodsDao.findByGoodsName(p.getName()).get(0);			
			if((g.getType()).equals(t))
				res.add(p);
		}
		return res;
	}

	@Override
	public void deleteSale(int id) {
		saleDao.delete(Sale.class, id);
	}

	@Override
	public void changeSale(SaleBean s) {
		Sale obj = saleDao.get(Sale.class, s.getId());
		if(!(s.getName().replace(" ", "")).equals(obj.getGoods().getName())){
			Goods g = goodsDao.findByGoodsName(s.getName()).get(0);
			obj.setGoods(g);
		}
		obj.setPrice(s.getPrice());
		obj.setNum(s.getNum());
		saleDao.update(obj);
	}
}
