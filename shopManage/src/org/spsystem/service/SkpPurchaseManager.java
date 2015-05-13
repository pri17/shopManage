package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.PurchaseBean;

public interface SkpPurchaseManager {
	/**
	 * �����鿴�������еĽ�����
	 * @param shopId �̵�ID
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getAllPurchase(int shopId);
	
	/**
	 * �����鿴�������еĽ�������ʱ������
	 * @param shopId �̵�ID
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getAllPurchaseOrderbyTime(int shopId);
	
	/**
	 * �����鿴�������еĽ���������Ʒ�Ľ���������
	 * @param shopId �̵�ID
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getAllPurchaseOrderbyNum(int shopId);
	
	/**
	 * �����鿴����ָ�����͵Ľ�����
	 * @param shopId �̵�ID
	 * @param typeId ��Ʒ����ID
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getPurchaseByType(int shopId, int typeId);
	
	/**
	 * ��������Ʒ�����ҽ�����
	 * @param shopId �̵�ID
	 * @param goodsName ��Ʒ��
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getPurchaseByGoods(int shopId, String goodsName);
	
	/**
	 * ��������Ʒ��Ų��ҽ�����
	 * @param shopId �̵�ID
	 * @param goodsName ��Ʒ��
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getPurchaseByGoods(int shopId, int goodsId);
	
	/**
	 * ������Ա�������ҽ�����
	 * @param shopId �̵�ID
	 * @param staffId Ա����
	 * @return ���̵����еĽ�����
	 */
	List<PurchaseBean> getPurchaseByStaff(int shopId, int staffId);
	
	/**
	 * ������ԭ�е����ݰ��������ͷ���
	 * @param data Ҫ��ѡ��ԭ�е���������
	 * @param typeId ���ͺ�
	 * @return ���̵����Ҫ��Ľ�����
	 */
	List<PurchaseBean> getPurchaseByType(List<PurchaseBean> data, int typeId);
	
	/**
	 * ������ɾ��ָ�������ŵĽ�����
	 * @param id Ҫɾ���Ľ�����ID
	 * @return null
	 */
	void deletePurchase(int id);
	
	/**
	 * ����������º�Ľ�����
	 * @param p ���ĺ�Ľ�����
	 * @param goodsName ���ĺ����Ʒ��
	 * @param type ���ĺ����Ʒ����
	 * @return null
	 */
	void changePurchase(PurchaseBean p, String goodsName, int type);
}
