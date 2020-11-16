package power.work.dao;

import power.work.bean.Manager;

import java.util.List;

public interface ManagerDao{
    public List<Manager> queryListManager();

    Manager existManagerName(String username);
}
