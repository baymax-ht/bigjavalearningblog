package org.bigjava.service;

import java.util.List;

import org.bigjava.bean.*;
public interface ManagerService {
public void addManager(Manager manager);
	
	public void deleteManagerById(Integer id);
	
	public void updateManager(Manager manager);
	
	public Manager queryManagerById(Integer id);
	
	public List<Manager> queryManager();

	public Page<Manager> page(int pageNo, int pageSize);

}
