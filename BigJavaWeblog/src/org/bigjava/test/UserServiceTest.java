package org.bigjava.test;

import org.bigjava.bean.User;
import org.bigjava.service.UserService;
import org.bigjava.service.biz.UserServiceImpl;
import org.junit.Test;
public class UserServiceTest {
	UserService userService = new UserServiceImpl();
	@Test
	public void register() {
//		userService.register(new User(null,"hongting","123456","hongting@qq.com"));
	}
	@Test
	public void login() {
		System.out.println(new User(null,"hongting","123456",null));
	}
	@Test
	public void existsusername() {
		if(userService.existsusername("hong")) {
			System.out.println("用户名已存在");
		}else {
			System.out.println("用户名可用");
		}
	}
	
}
