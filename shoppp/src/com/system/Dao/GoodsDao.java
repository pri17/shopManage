package com.system.Dao;

import java.util.List;
import com.system.model.Goods;
import com.system.model.Shop;

public interface GoodsDao {
	//��Goods��������в���
	/**
	 * ����Ʒ��������Ʒ��ģ����
	 * @param goodsName ��Ʒ��
	 * @return ��Ʒ��Ϣ
	 */
	List<Goods> findByGoodsName(String goodsName);
	/**
	 * ͨ����Ʒid��������
	 * @param int id
	 * @return ���̵������Ϣ
	 */
	List<Goods> findGoodsById(int id);
	/**
	 * ͨ������������ģ������
	 * @param string type_name
	 * @return ���̵������Ϣ
	 */
	List<Goods>findGoodsByType(String type_name);
	/**
	 * ���� 'ָ���̵� '��ӵ�е�������Ʒ
	 * @param shop �̵�
	 * @return ���̵�����е���Ʒ
	 */
	List<Goods> findGoodsByShop(Shop shop);
	
	/**
	 * ����  'ָ���̵� '��ӵ�е�ĳ����Ʒ���ۻ���Ϣ
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return ���̵����Ʒ���ۻ���Ϣ�����������롢�ۻ�����Ŀ��
	 */
	List<Object[]> findSaleInfByGoods(Shop shop, Goods goods);
	
	/**
	 * ���� 'ָ���̵� '��ӵ�е�ĳ����Ʒ�Ľ�����Ϣ
	 * @param shop �̵�
	 * @param goods ��Ʒ
	 * @return ���̵����Ʒ�Ľ�����Ϣ����桢�ɱ�����������Ŀ��
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop, Goods goods);
	
	/**
	 * ���� 'ָ���̵� '��ӵ�е���Ʒ���ۻ���Ϣ
	 * @param shop �̵�
	 * @return ���̵�������Ʒ���ۻ���Ϣ�����������롢�ۻ�����Ŀ��
	 */
	List<Object[]> findSaleInfByGoods(Shop shop);
	
	/**
	 * ���� 'ָ���̵� '��ӵ�е���Ʒ�Ľ�����Ϣ
	 * @param shop �̵�
	 * @return ���̵�������Ʒ�Ľ�����Ϣ����桢�ɱ�����������Ŀ��
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop);
	
	/**
	 * ���� 'ָ���̵� '������Ʒ���йص���Ʒ��Ϣ
	 * @param shop �̵�
	 * @param goodsName ��Ʒ��
	 * @return ���̵�ģ�����ҵ�������Ʒ
	 */
	List<Goods> findGoodsByName(Shop shop, String goodsName);

	/**
	 * ���� 'ָ���̵� '������Ʒ���йصĽ�����Ϣ
	 * @param shop �̵�
	 * @param goodsName ��Ʒ��
	 * @return ���̵�������Ʒ�Ľ�����Ϣ����桢�ɱ�����������Ŀ��
	 */
	List<Object[]> findPurchaseInfByName(Shop shop, String goodsName);

	/**
	 * ���� 'ָ���̵� '������Ʒ���йص�������Ϣ
	 * @param shop �̵�
	 * @param goodsName ��Ʒ��
	 * @return ���̵�������Ʒ���ۻ���Ϣ�����������롢�ۻ�����Ŀ��
	 */
	List<Object[]> findSaleInfByName(Shop shop, String goodsName);

}