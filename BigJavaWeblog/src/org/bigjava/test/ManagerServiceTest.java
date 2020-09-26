package org.bigjava.test;

import static org.junit.Assert.*;

import org.bigjava.bean.Manager;
import org.bigjava.bean.Page;
import org.bigjava.dao.ManagerDao;
import org.bigjava.dao.ManagerImpl;
import org.bigjava.service.ManagerService;
import org.bigjava.service.biz.ManagerServiceImpl;
import org.junit.Test;

public class ManagerServiceTest {
	private ManagerService managerService = new ManagerServiceImpl();
	@Test
	public void testAddManager() {
		managerService.addManager(new Manager(null,"°²ÄÝ±¦±´",10,10));
	}

	@Test
	public void testDeleteManagerById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateManager() {
		managerService.updateManager(new Manager(11,"ÇìÉ½",10,10));
	}

	@Test
	public void testQueryManagerById() {
		System.out.println(managerService.queryManagerById(11));
	}

	@Test
	public void testQueryManager() {
		for(Manager manager :managerService.queryManager()) {
			System.out.println(manager);
		}
	}
	@Test
	public void page() {
		System.out.println(managerService.page(1, Page.PAGE_SIZE));
	}
	public static void main(String []args) {
		ManagerServiceTest managerServiceTest = new ManagerServiceTest();
		managerServiceTest.page();
				
	}

}
