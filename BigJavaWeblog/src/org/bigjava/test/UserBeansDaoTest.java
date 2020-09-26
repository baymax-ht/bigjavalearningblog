package org.bigjava.test;

import java.util.Iterator;
import java.util.List;

import org.bigjava.bean.User;
import org.bigjava.dao.*;

public class UserBeansDaoTest {
	UserDao userdao = new UserDaoImpl();

	public void queryUsername() {
		if (userdao.queryUserName("admin123") == null) {
			System.out.println("用户名可用！");
		} else {
			;
			System.out.println("用户名已存在不可用！");
		}
	}

	public void saveUser() {
		userdao.saveUser(new User(3,"admin123","1234","admin@qq.123com"));
	}

	public void queryUsernameAndPassword() {
		if (userdao.queryUsernameAndPassword("a", "666") == null) {
			System.out.println("用户名或密码错误!");
		} else {
			System.out.println("登录成功！");

		};
	}
	public void selectLike() {
////		List<User> list = userdao.selectLike("admin");
//		Iterator itor = list.iterator();
//		while (itor.hasNext()) {
//			System.out.println(itor.next());
//		}
	}
	public static void main(String[] args) {
		UserBeansDaoTest ubt = new UserBeansDaoTest();
//		ubt.queryUsername();
//		ubt.saveUser();
//		ubt.queryUsernameAndPassword();
		ubt.selectLike();
	}
}
