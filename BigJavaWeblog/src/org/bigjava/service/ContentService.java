package org.bigjava.service;

import java.util.List;

import org.bigjava.bean.Content;

public interface ContentService {
	public void addContent(Content content);
	
	public void deleteContent(Integer id);
	
	public void updateContent(Content content);
	
	public Content queryContentById(Integer id);
	
	public List<Content> queryContentList();

}
