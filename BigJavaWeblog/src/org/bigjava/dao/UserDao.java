package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.User;

public interface UserDao {
	/**
	 * ��ѯ�û���Ϣ
	 * @param username
	 * @return
	 */
	public User queryUserName(String username);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public int saveUser(User user);
	
	/**
	 * ��¼����
	 */
	public User queryUsernameAndPassword(String username,String password);
	
	public abstract List<String> selectLike(String username);
}
