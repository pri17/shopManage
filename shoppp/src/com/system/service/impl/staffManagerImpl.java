package com.system.service.impl;

import java.util.List;

import com.system.Dao.GoodsDao;
import com.system.Dao.PurchaseDao;
import com.system.Dao.SaleDao;
import com.system.Dao.ShopDao;
import com.system.Dao.StaffDao;
import com.system.Dao.TypeDao;
import com.system.model.Staff;
import com.system.service.*;

public class staffManagerImpl implements staffManager{
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
	public List<Staff> getAll(){;
		return staffDao.findAll(Staff.class);
	}
	@Override
	public Staff getStaffById(int StaffId){
		Staff staff=(Staff) staffDao.findSatffById(StaffId);
		return staff;
	}
	@Override
	public List<Staff> getStaffByName(String name){
		List<Staff> staff=staffDao.findStaffByName(name);
		return staff;
	}
	@Override 
	public List<Staff> getStaffByLevel(int level){
		List<Staff> staff=staffDao.findStaffByLevel(level);
		return staff;
	}
}
