package com.system.Dao;

import java.util.List;

import com.system.model.Goods;


public interface TypeDao {
	//��Type��������в���
	/**
	 * ��������������Ʒ��ģ����
	 * @param name ������
	 * @return ��Ʒ��Ϣ
	 */
	List<Goods> findByTypeName(String goodsName);
}