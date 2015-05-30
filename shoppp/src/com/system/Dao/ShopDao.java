package com.system.Dao;

import java.util.List;

import com.system.model.Shop;

public interface ShopDao {
	//��Shop��������в���
	/**
	* ���̵��������̵꣨ģ����
	* @param name �̵���
	* @return �̵���Ϣ
	*/
	List<Shop> findByShopName(String name);
	/**
	* ���̵�id�����̵�
	* @param id �̵�id
	* @return �̵���Ϣ
	*/
	List<Shop> findByShopId(int id);
	/**
	* �����������̵꣨ģ����
	* @param area ������
	* @return �̵���Ϣ
	*/
	List<Shop> findByArea(String area);
	/**
	* ���̵��ֵ�����̵꣨��Χ��
	* @param p1 ��ͼ�
	* @param p2 ��߼�
	* @return �̵���Ϣ
	*/
	List<Shop> findByPrice(double p1,double p2);
}
