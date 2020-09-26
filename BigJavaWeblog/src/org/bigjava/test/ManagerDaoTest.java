package org.bigjava.test;

import static org.junit.Assert.*;

import org.bigjava.bean.Manager;
import org.bigjava.bean.Page;
import org.bigjava.dao.ManagerDao;
import org.bigjava.dao.ManagerImpl;
import org.junit.Test;

public class ManagerDaoTest {
	ManagerDao managerdao = new ManagerImpl();
	@Test
	public void testAddManager() {
		managerdao.addManager(new Manager(null,"«Â≥ÿ",100,200));
	}

	@Test
	public void testDeleteManager() {
		managerdao.deleteManager(10);
	}

	@Test
	public void testUpdateManager() {
		managerdao.updateManager(new Manager(2,"«Ï…Ω",100,200));
	}

	@Test
	public void testQueryManager() {
		System.out.println(managerdao.queryManager(2));
	}

	@Test
	public void testQueryMangerList() {
		for(Manager manager : managerdao.queryMangerList()) {
			System.out.println(manager);
		}
	}
	@Test
	public void testQueryForPageTotalCount() {
		System.out.println(managerdao.queryForPageTotalCount());
	}
	@Test
	public void testQueryForPageItems() {
		for(Manager manager :managerdao.queryForPageItems(0, Page.PAGE_SIZE)) {
			System.out.println(manager);
		};
	}
	
	public static void main(String[]args) {
		ManagerDaoTest daoTest = new ManagerDaoTest();
		daoTest.testQueryForPageTotalCount();
		daoTest.testQueryForPageItems();
	}

}
