package com.system.service;

import java.util.List;

import com.system.model.Shop;


public interface shopManager {
	/**
	 * ��ȡ�̵�ȫ����Ϣ
	 * return �̵�ȫ����Ϣ
	 */
	List<Shop> getAll();
	/**
	 * ͨ��id��ȡ�̵���Ϣ
	 * @param shopId �̵��
	 * return ���̵�ȫ����Ϣ
	 */
	Shop getShop(int shopId);

	
}
