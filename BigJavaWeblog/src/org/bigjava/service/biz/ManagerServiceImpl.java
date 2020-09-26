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
		//�����ܼ�¼��
		Integer pageTotalCount = managerdao.queryForPageTotalCount();
		page.setPageTotalCount(pageTotalCount);
		//����ҳ��
		Integer pageTotal = pageTotalCount / pageSize;
		if(pageTotalCount % pageSize >0) {
			pageTotal++;
		}
		
		//������ҳ��
		page.setPageTotal(pageTotal);
		//���õ�ǰҳ��
		page.setPageNo(pageNo);
		//��ǰҳ����
		int begin = (page.getPageNo()-1)*pageSize;
		List<Manager> items= managerdao.queryForPageItems(begin,pageSize);
		page.setItems(items);
		return page;
	}

}
