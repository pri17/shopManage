package com.system.service;

import com.system.model.*;
import java.util.List;

public interface staffManager {
	/**
	 * 获取所有员工信息
	 * return 全部员工信息
	 */
	List<Staff> getAll();
	/**
	 * 通过id获取员工信息
	 * @param staffId 商店号
	 * return 指定的员工信息
	 */
	Staff getStaffById(int StaffId);
	/**
	 * 通过name获取员工信息
	 * @param name  名字
	 * return 指定的员工信息
	 */
	List<Staff> getStaffByName(String name);
	/**
	 * 查找level对应的员工信息
	 * @param level 员工等级
	 * return 指定的员工信息
	 */
	List<Staff> getStaffByLevel(int level);//在jsp页面通过点击 按钮 来实现
	
}
