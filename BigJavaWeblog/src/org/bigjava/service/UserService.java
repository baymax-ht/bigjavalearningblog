package org.bigjava.service;

import java.util.List;

import org.bigjava.bean.User;

public interface UserService {
	/**
	 * ע��
	 * @param user
	 */
	public void register(User user);
	/**
	 * ��¼
	 * @param user
	 */
	public User login(User user);
	/**
	 * �ж��û����Ƿ����
	 * @param username
	 * @return
	 */
	public boolean existsusername(String username);
	
	public List autoSearch(String keyword);
}
