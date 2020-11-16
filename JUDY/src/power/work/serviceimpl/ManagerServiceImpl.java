package power.work.serviceimpl;

import power.work.bean.Manager;
import power.work.dao.ManagerDao;
import power.work.daoimpl.ManagerDaoImpl;
import power.work.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public List<Manager> queryListForManager() {
        return managerDao.queryListManager();
    }
}
