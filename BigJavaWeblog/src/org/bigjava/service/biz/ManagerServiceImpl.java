package org.bigjava.service.biz;

import java.util.List;

import org.bigjava.bean.Manager;
import org.bigjava.bean.Page;
import org.bigjava.dao.ManagerDao;
import org.bigjava.dao.ManagerImpl;
import org.bigjava.service.ManagerService;
import org.bigjava.service.biz.ManagerServiceImpl;
public class ManagerServiceImpl implements ManagerService{
	private ManagerDao managerdao = new ManagerImpl();
	
	public void addManager(Manager manager) {
		managerdao.addManager(manager);
	}

	@Override
	public void deleteManagerById(Integer id) {
		managerdao.deleteManager(id);
	}

	@Override
	public void updateManager(Manager manager) {
		managerdao.updateManager(manager);
	}

	@Override
	public Manager queryManagerById(Integer id) {
		return managerdao.queryManager(id);
	}

	@Override
	public List<Manager> queryManager() {
		return managerdao.queryMangerList();
	}

	@Override
	public Page<Manager> page(int pageNo, int pageSize) {
		Page<Manager> page = new Page<>();
		page.setPageSize(pageSize);
		//设置总记录数
		Integer pageTotalCount = managerdao.queryForPageTotalCount();
		page.setPageTotalCount(pageTotalCount);
		//求总页码
		Integer pageTotal = pageTotalCount / pageSize;
		if(pageTotalCount % pageSize >0) {
			pageTotal++;
		}
		
		//设置总页码
		page.setPageTotal(pageTotal);
		//设置当前页码
		page.setPageNo(pageNo);
		//求当前页数据
		int begin = (page.getPageNo()-1)*pageSize;
		List<Manager> items= managerdao.queryForPageItems(begin,pageSize);
		page.setItems(items);
		return page;
	}

}
