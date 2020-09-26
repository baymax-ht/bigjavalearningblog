package org.bigjava.service.biz;

import java.util.List;

import org.bigjava.bean.User;
import org.bigjava.dao.UserDao;
import org.bigjava.dao.UserDaoImpl;
import org.bigjava.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	@Override
	public void register(User user) {
		userdao.saveUser(user);
		
	}
	/**
	 * 用户名或密码错误
	 */
	@Override
	public User login(User user) {
		return userdao.queryUsernameAndPassword(user.getUsername(),user.getPassword());
		
		
	}
	/**
	 * false用户名可用，true用户名已存在
	 */
	@Override
	public boolean existsusername(String username) {
		if(userdao.queryUserName(username)==null) {
			System.out.println("用户名可用");
			return false;
		}
		return true;
	}
	@Override
	public List autoSearch(String keyword) {
		
		return userdao.selectLike(keyword);
	}
}
