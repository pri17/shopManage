package com.system.service;

import com.system.model.*;

import java.util.List;

public interface goodsManager {
	/**
	 * ��ȡ������Ʒ��Ϣ
	 * return ȫ����Ʒ��Ϣ
	 */
	List<Goods> getAll();
	/**
	 * ͨ��id��ȡ��Ʒ��Ϣ
	 * @param  goodsId ��Ʒid
	 * return ָ������Ʒ��Ϣ
	*/
	Goods getGoodsById(int goodsId);
	/**
	 * ͨ��name��ȡ��Ʒ��Ϣ
	 * @param name ��Ʒ����
	 * return ָ������Ʒ��Ϣ
	*/
	List<Goods> getGoodsByname(String name);
	/**
	 * ͨ���������ֻ�ȡ��Ʒ��Ϣ
	 * @param typeName ��������
	 * return ָ������Ʒ��Ϣ
	*/
	List<Goods> getGoodsByType(String typeName);
	
}
