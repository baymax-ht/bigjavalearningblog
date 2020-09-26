package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.Content;

public interface ContentDao {
	public int addContent(Content content);
	
	public int deleteContent(Integer id);
	
	public int updateContent(Content content);
	
	public Content queryContentById(Integer id);
	
	public List<Content> queryContentList();

}
