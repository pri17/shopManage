package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.Shop;
import com.system.model.Staff;

public interface StaffDao extends BasicDao<Staff>{
	//对Staff对象的所有操作
	/**
	* 按id查找staff
	* @param int id staff的id
	* @return 员工信息
	*/
	List<Staff> findSatffById(int id);
	/**
	* 按staff名字查找staff（模糊）
	* @param String name satff名字
	* @return 员工信息
	*/
	List<Staff> findStaffByName(String name);
	/**
	* 按权限等级查找staff（模糊）
	* @param int level staff的level
	* @return 员工信息
	*/
	List<Staff> findStaffByLevel(int level);
	/**
	* 查找特定商店的店主
	* @param shop 商店
	* @return 员工信息
	*/
	List<Staff> findShopKeeper(Shop shop);
	/**
	* 查找特定商店的进货员
	* @param shop 商店
	* @return 员工信息
	*/
	List<Staff> findShopImporter(Shop shop);
	/**
	* 查找特定商店的售货员
	* @param shop 商店
	* @return 员工信息
	*/
	List<Staff> findShopExporter(Shop shop);
}
