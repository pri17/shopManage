package org.spsystem.service;

import java.util.List;

import org.spsystem.domain.Shop;
import org.spsystem.vo.GoodsInfBean;

public interface SkpShopManager {
	/*
	 * ��ȡ�̵�ȫ����Ϣ
	 * @param shopId �̵��
	 * return ���̵�ȫ����Ϣ
	 */
	Shop getShop(int shopId);
	
	/*
	 * ��ȡ�̵��ۻ�����ֵ
	 * @param shop �̵�
	 * return ���̵�����ֵ
	 */
	double getProfit(Shop shop);
	
	/*
	 * ��ȡ�̵�������ߵ�5����Ʒ
	 * @param shop �̵�
	 * return ���̵��������5����Ʒ����Ϣ
	 */
	List<GoodsInfBean> getTopGoods(Shop shop);
	
	/*
	 * ��ȡ�̵�ӯ����ߵ�5����Ʒ
	 * @param shop �̵�
	 * return ���̵�ӯ����ߵ�5����Ʒ����Ϣ
	 */
	List<GoodsInfBean> getHotGoods(Shop shop);
	
	/**
	 * �����鿴���걾�²�ͬ��������
	 * @param shop �̵�
	 * @return ����ĵ�json����
	 */
	String getGoodsTypeInf(Shop shop);
	
	/**
	 * �����鿴���걾�²�ͬ��������
	 * @param shop �̵�
	 * @return ����ĵ�json����
	 */
	String getTypeInf(Shop shop);
}
