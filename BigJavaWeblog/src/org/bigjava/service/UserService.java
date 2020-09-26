package org.bigjava.service;

import java.util.List;

import org.bigjava.bean.User;

public interface UserService {
	/**
	 * 注册
	 * @param user
	 */
	public void register(User user);
	/**
	 * 登录
	 * @param user
	 */
	public User login(User user);
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean existsusername(String username);
	
	public List autoSearch(String keyword);
}
