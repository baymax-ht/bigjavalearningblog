package org.bigjava.dao.impl;

import java.util.List;

import org.bigjava.bean.Content;
import org.bigjava.dao.BaseDao;
import org.bigjava.dao.ContentDao;

public class ContentImpl extends BaseDao implements ContentDao{

	@Override
	public int addContent(Content content) {
		String sql = "insert into t_look(`username`,`reading`)values(?,?)";
		return update(sql,content.getUsername(),content.getReading());
	}

	@Override
	public int deleteContent(Integer id) {
		String sql = "delete from t_look where id=?";
		return update(sql,id);
	}

	@Override
	public int updateContent(Content content) {
		String sql = "update t_look set `username`=?,`reading`=? where id=?";
		return update(sql,content.getUsername(),content.getReading(),content.getId());
	}

	@Override
	public Content queryContentById(Integer id) {
		String sql = "select `id`,`username`,`reading` from t_look where id=?";
		return queryForOne(Content.class,sql,id);
	}

	@Override
	public List<Content> queryContentList() {
		String sql = "select `id`,`username`,`reading` from t_look";
		return queryForList(Content.class,sql);
	}

	
}