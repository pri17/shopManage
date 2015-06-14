package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.Shop;
import com.system.model.Staff;

public interface StaffDao extends BasicDao<Staff>{
	//��Staff��������в���
	/**
	* ��id����staff
	* @param int id staff��id
	* @return Ա����Ϣ
	*/
	List<Staff> findSatffById(int id);
	/**
	* ��staff���ֲ���staff��ģ����
	* @param String name satff����
	* @return Ա����Ϣ
	*/
	List<Staff> findStaffByName(String name);
	/**
	* ��Ȩ�޵ȼ�����staff��ģ����
	* @param int level staff��level
	* @return Ա����Ϣ
	*/
	List<Staff> findStaffByLevel(int level);
	/**
	* �����ض��̵�ĵ���
	* @param shop �̵�
	* @return Ա����Ϣ
	*/
	List<Staff> findShopKeeper(Shop shop);
	/**
	* �����ض��̵�Ľ���Ա
	* @param shop �̵�
	* @return Ա����Ϣ
	*/
	List<Staff> findShopImporter(Shop shop);
	/**
	* �����ض��̵���ۻ�Ա
	* @param shop �̵�
	* @return Ա����Ϣ
	*/
	List<Staff> findShopExporter(Shop shop);
}
