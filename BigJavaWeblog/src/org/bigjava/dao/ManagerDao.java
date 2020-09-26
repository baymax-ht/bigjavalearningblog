package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.Manager;

public interface ManagerDao {
	
	public int addManager(Manager manager);
	
	public int deleteManager(Integer id);
	
	public int updateManager(Manager manager);
	
	public Manager queryManager(Integer id);
	
	public List<Manager> queryMangerList();

	public Integer queryForPageTotalCount();

	public List<Manager> queryForPageItems(int begin, int pageSize);

}
