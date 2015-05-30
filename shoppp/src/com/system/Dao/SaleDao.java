package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.*;

public interface SaleDao extends BasicDao<Sale>{
	/**
	 * ����ָ���̵���������
	 * @param shop �̵�
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findByShop(Shop shop);
	
	/**
	 * ����ָ���̵�ָ����Ʒ���������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findByGoods(Shop shop, Goods goods);
	
	/**
	 * ����ָ���ۻ�Ա���������
	 * @param shop �̵�
	 * @param staff �ۻ�Ա
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findByStaff(Shop shop, Staff staff);
	
	
	
	/**
	 * ����ָ���̵�ָ����Ʒĳ����������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @param date ����
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findGoodsNumByDate(Shop shop, Goods goods, String Date);
	
	/**
	 * ����ָ���̵�ָ����Ʒĳ�µ��������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @param month �·�
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findGoodsNumByMonth(Shop shop, Goods goods, String month);
	
	/**
	 * ����ָ���̵�ָ����Ʒĳ����������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @param year ��
	 * @return ���̵��������Ϣ�� 
	 */
	List<Sale> findGoodsNumByYear(Shop shop, Goods goods, String year);
	
	/**
	 * ��Date����ĳ��Ʒ���������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return ���̵��������Ϣ��Date, SUM(num), SUM(price)��
	 */
	List findGoodsByDate(Shop shop, Goods goods);
	
	/**
	 * ���Ҹ��̵�ĳλԱ��������ۻ���
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @param num �ۻ�����Ŀ
	 * @return ���̵����Ʒ���ۻ���Ϣ�� 
	 */
	List<Sale> findGoodsSales(Shop shop, Goods goods, int num);
	
	/**
	 * �����̵�ĳ��Ʒ��ĳ��������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return �̵����Ʒ������ 
	 */
	long findGoodsSalesNumByYear(Shop shop, Goods goods, String year);
	
	/**
	 * �����̵��ĳ��������
	 * @param shop �̵�
	 * @return �̵������ 
	 */
	long findSalesNumByYear(Shop shop, String year);
	
	/**
	 * �����̵�ĳ��Ʒ��ĳ��������
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return �̵����Ʒ������ 
	 */
	double findGoodsSalesPriceByYear(Shop shop, Goods goods, String year);
	
	/**
	 * �����̵��ĳ��������
	 * @param shop �̵�
	 * @return �̵������ 
	 */
	double findSalesPriceByYear(Shop shop, String year);
	
	/**
	 * �����̵��������
	 * @param shop �̵�
	 * @return �̵������ 
	 */
	double findSalesPrice(Shop shop);
	
	/**
	 * �����̵��ĳ��ĳ��Ʒ���ۼ���������ϵ
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return �̵���Ʒ���������ۼ۹�ϵ 
	 */
	List<Object[]> findGoodsSalesPriceNum(Shop shop, Goods goods);
	
	/**
	 * �����̵�����һ�ܵ�������ߵ�5����Ʒ
	 * @param shop �̵�
	 * @param start ������һ
	 * @return �̵��������5����Ʒ�����۵� 
	 */
	List<Object[]> findTopGoodsNum(Shop shop, String start);
	
	/**
	 * �����̵��ĳ��ĳ����Ʒ��������	 
	 * @param shop �̵�
	 * @param ym ����
	 * @return �̵��������5����Ʒ�����۵� 
	 */
	List<Object[]> findGoodsTypeNum(Shop shop, String ym);
	
	/**
	 * �����̵�����һ�ܵ�ӯ����ߵ�5����Ʒ
	 * @param shop �̵�
	 * @param start ������һ
	 * @return �̵��������5����Ʒ�����۵� 
	 */
	List<Object[]> findHotGoodsPrice(Shop shop, String start);
	
	/**
	 * �����̵��ĳ��ĳ��ĳ����Ʒ������	 
	 * @param shop �̵�
	 * @param ym ����
	 * @param type���
	 * @return �̵��������5����Ʒ�����۵� 
	 */
	List<Object[]> findGoodsNumType(Shop shop, String ym, Type type);
	
	/**
	 * �����̵��ĳ��ĳ����Ʒ������	 
	 * @param shop �̵�
	 * @param ym ����
	 * @param type���
	 * @return �̵��������5����Ʒ�����۵� 
	 */
	List<Object[]> findGoodsNum(Shop shop, String ym);
}
