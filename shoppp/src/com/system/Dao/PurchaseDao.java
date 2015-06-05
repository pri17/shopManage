package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.*;




public interface PurchaseDao extends BasicDao<Purchase>{
	//��Purchase��������в���
	/**
	 * ����ָ���̵�Ľ������
	 * @param shop �̵�
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findByShop(Shop shop);
	
	
	
	/**
	 * ���Ҹ��̵갴��Ʒ�����ҵ���Ʒ
	 * @param shop �̵�
	 * @return ���̵�����е���Ʒ
	 */
	List<Purchase> findGoodsByShop(Shop shop, String name);
	
	/**
	 * ����ָ���̵ꡢָ����Ʒ�Ľ������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findByGoods(Shop shop, Goods goods);
	
	/**
	 * ����ָ���̵�İ�ʱ������Ľ������
	 * @param shop �̵�
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findOrderbyTime(Shop shop);
	
	/**
	 * ����ָ���̵갴ÿ�ν�����������Ľ������
	 * @param shop �̵�
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findOrderbyNum(Shop shop);
	
	/**
	 * ����ָ���̵갴��ͬ��Ʒ���Ľ������
	 * @param shop �̵�
	 * @param type ��Ʒ����
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findByType(Shop shop, Type type);
	
	/**
	 * ����ָ���̵겻ͬ��Ʒ������Ʒ������
	 * @param shop �̵�
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findGoodsByType(Shop shop, Type type);
	
	/**
	 * ���Ҹ��̵�ĳλԱ������Ľ�����
	 * @param shop �̵�
	 * @param staff Ա��
	 * @return ���̵�Ľ�����Ϣ�� 
	 */
	List<Purchase> findGoodsByStaff(Shop shop, Staff staff);
	
	/**
	 * ���Ҹ��̵�ĳλԱ������Ľ�����
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @param num ��������Ŀ
	 * @return ���̵����Ʒ�Ľ�����Ϣ�� 
	 */
	List<Purchase> findGoodsPurchases(Shop shop, Goods goods, int num);

	/**
	 * �����̵�ĳ��Ʒ��ĳ���ܳɱ�
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return �̵����Ʒ������ 
	 */
	double findGoodsPurchasesPriceByYear(Shop shop, Goods goods, String year);
	
	/**
	 * �����̵��ĳ���ܳɱ�
	 * @param shop �̵�
	 * @return �̵������ 
	 */
	double findPurchasesPriceByYear(Shop shop, String year);
	
	/**
	 * �����̵���ܳɱ�
	 * @param shop �̵�
	 * @return �̵������ 
	 */
	double findPurchasePirce(Shop shop);
}
