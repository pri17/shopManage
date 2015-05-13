package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.SaleBean;

public interface SkpSaleManager {
	/**
	 * �����鿴�������е��ۻ���
	 * @param shopId �̵�ID
	 * @return ���̵����е��ۻ���
	 */
	List<SaleBean> getAllSale(int shopId);
	
	/**
	 * ��������Ʒ�������ۻ���
	 * @param shopId �̵�ID
	 * @param goodsName ��Ʒ��
	 * @return ���̵����е��ۻ���
	 */
	List<SaleBean> getSaleByGoods(int shopId, String goodsName);
	
	/**
	 * ��������Ʒ��Ų����ۻ���
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ���̵����е��ۻ���
	 */
	List<SaleBean> getSaleByGoods(int shopId, int goodsId);
	
	/**
	 * ������Ա���������ۻ���
	 * @param shopId �̵�ID
	 * @param staffId Ա����
	 * @return ���̵����е��ۻ���
	 */
	List<SaleBean> getSaleByStaff(int shopId, int staffId);
	
	/**
	 * ������ԭ�е����ݰ��������ͷ���
	 * @param data Ҫ��ѡ��ԭ�е���������
	 * @param typeId ���ͺ�
	 * @return ���̵����Ҫ����ۻ���
	 */
	List<SaleBean> getSaleByType(List<SaleBean> data, int typeId);
	
	/**
	 * ������ɾ��ָ�������ŵ��ۻ���
	 * @param id Ҫɾ�����ۻ���ID
	 * @return null
	 */
	void deleteSale(int id);
	
	/**
	 * ����������º���ۻ���
	 * @param p ���ĺ���ۻ���
	 * @return null
	 */
	void changeSale(SaleBean p);
}
