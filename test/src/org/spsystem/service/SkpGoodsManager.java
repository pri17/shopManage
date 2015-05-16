package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.GoodsBean;

public interface SkpGoodsManager {
	/**
	 * �����鿴�������е���Ʒ
	 * @param shopId �̵�ID
	 * @return ���̵����е���Ʒ����Ʒ��Ϣ
	 */
	List<GoodsBean> getAllGoods( int shopId );
	
	/**
	 * ��������Ʒ�����ұ�����Ʒ
	 * @param shopId �̵�ID
	 * @param goodsName ��Ʒ��
	 * @return ���̵꺬�и���Ʒ����������Ʒ��Ϣ
	 */
	List<GoodsBean> getGoodsByName( int shopId, String goodsName );
	
	/**
	 * ��������Ʒ�Ų��ұ�����Ʒ
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ���̵����Ʒ������Ʒ��Ϣ
	 */
	List<GoodsBean> getGoodsById( int shopId, int goodsId );
	
	/**
	 * ���������Ͳ��ұ�����Ʒ
	 * @param data ԭ������
	 * @param typeId ����ID
	 * @return ���̵������������Ʒ��Ϣ
	 */
	List<GoodsBean> getGoodsByType( List<GoodsBean> data, int typeId );
	
	/**
	 * �����鿴����ĳ��Ʒ��10�����ڵĽ�����¼
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return �ý�����¼��json����
	 */
	String getGoodsPurchase(  int shopId, int goodsId );
	
	/**
	 * �����鿴����ĳ��Ʒ��10�����ڵ��ۻ���¼
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ���ۻ���¼��json����
	 */
	String getGoodsSalas(  int shopId, int goodsId );
	
	/**
	 * �����鿴����ĳ��Ʒ���۱���
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ���۱�����json����
	 */
	String getGoodsSaleScale( int shopId, int goodsId );
	
	/**
	 * �����鿴����ĳ��Ʒӯ������
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ӯ��������json����
	 */
	String getGoodsProfitScale( int shopId, int goodsId );
	
	/**
	 * �����鿴����ĳ��Ʒ�������
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ���������json����
	 * @throws Exception 
	 */
	String getGoodsSaleInf( int shopId, int goodsId ) throws Exception;
	
	/**
	 * �����鿴����ĳ��Ʒ�������ۼ�
	 * @param shopId �̵�ID
	 * @param goodsId ��Ʒ��
	 * @return ����ĵ�json����
	 */
	String getGoodsSalePriceNum( int shopId, int goodsId );
}
