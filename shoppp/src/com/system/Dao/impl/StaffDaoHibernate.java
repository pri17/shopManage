package com.system.Dao.impl;

import java.util.List;

import com.basic.Dao.impl.BasicDaoHibernate;
import com.system.Dao.StaffDao;
import com.system.model.Goods;
import com.system.model.Shop;
import com.system.model.Staff;

public class StaffDaoHibernate extends BasicDaoHibernate<Staff> implements StaffDao{

	@Override
	public List<Staff> findBySatffById(int id) {
		return (find("from Staff where id="+id));
	}

	@Override
	public List<Staff> findByStaffByName(String name) {
		return (find("from Staff where name like %"+name+"%"));
	}

	@Override
	public List<Staff> findStaffByLevel(int level) {
		return (find("from Staff where level="+level));
	}

	@Override//Î´Íê³É
	public List<Staff> findShopKeeper(Shop shop) {
		return find("from Staff where level=2 and shop_id="+shop.getShopId());
	}

	@Override
	public List<Staff> findShopImporter(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> findShopExporter(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

}
