package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.Manager;

public class ManagerImpl extends BaseDao implements ManagerDao {

	@Override
	public int addManager(Manager manager) {
		String sql = "insert into t_manager(`username`,`likes`,`reading`)values(?,?,?)";
		return update(sql,manager.getUsername(),manager.getLikes(),manager.getReading());
	}

	@Override
	public int deleteManager(Integer id) {
		String sql = "delete from t_manager where id=?";
		return update(sql,id);
	}

	@Override
	public int updateManager(Manager manager) {
		String sql = "update t_manager set `username`=?,`likes`=?,`reading`=? where id=?";
		return update(sql,manager.getUsername(),manager.getLikes(),manager.getReading(),manager.getId());
	}

	@Override
	public Manager queryManager(Integer id) {
		String sql = "select `id`,`username`,`likes`,`reading` reading from t_manager where id=?";
		return queryForOne(Manager.class,sql,id);
	}

	@Override
	public List<Manager> queryMangerList() {
		String sql = "select `id`,`username`,`likes`,`reading` reading from t_manager";
		return queryForList(Manager.class,sql);
	}

	@Override
	public Integer queryForPageTotalCount() {
		String sql = "select count(*) from t_manager";
		Number count =(Number) querySingleValues(sql);
		return count.intValue();
	}

	@Override
	public List<Manager> queryForPageItems(int begin, int pageSize) {
		String sql = "select `id`,`username`,`likes`,`reading` reading from t_manager limit ?,?";
		return queryForList(Manager.class,sql,begin,pageSize);
	}

}
