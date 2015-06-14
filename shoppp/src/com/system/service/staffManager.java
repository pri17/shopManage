package com.system.service;

import com.system.model.*;
import java.util.List;

public interface staffManager {
	/**
	 * ��ȡ����Ա����Ϣ
	 * return ȫ��Ա����Ϣ
	 */
	List<Staff> getAll();
	/**
	 * ͨ��id��ȡԱ����Ϣ
	 * @param staffId �̵��
	 * return ָ����Ա����Ϣ
	 */
	Staff getStaffById(int StaffId);
	/**
	 * ͨ��name��ȡԱ����Ϣ
	 * @param name  ����
	 * return ָ����Ա����Ϣ
	 */
	List<Staff> getStaffByName(String name);
	/**
	 * ����level��Ӧ��Ա����Ϣ
	 * @param level Ա���ȼ�
	 * return ָ����Ա����Ϣ
	 */
	List<Staff> getStaffByLevel(int level);//��jspҳ��ͨ����� ��ť ��ʵ��
	
}
