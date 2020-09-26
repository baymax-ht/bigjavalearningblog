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
	 * �û������������
	 */
	@Override
	public User login(User user) {
		return userdao.queryUsernameAndPassword(user.getUsername(),user.getPassword());
		
		
	}
	/**
	 * false�û������ã�true�û����Ѵ���
	 */
	@Override
	public boolean existsusername(String username) {
		if(userdao.queryUserName(username)==null) {
			System.out.println("�û�������");
			return false;
		}
		return true;
	}
	@Override
	public List autoSearch(String keyword) {
		
		return userdao.selectLike(keyword);
	}
}
