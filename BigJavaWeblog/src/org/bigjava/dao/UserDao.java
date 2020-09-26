package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.User;

public interface UserDao {
	/**
	 * 查询用户信息
	 * @param username
	 * @return
	 */
	public User queryUserName(String username);
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	public int saveUser(User user);
	
	/**
	 * 登录操作
	 */
	public User queryUsernameAndPassword(String username,String password);
	
	public abstract List<String> selectLike(String username);
}
