package org.bigjava.service.biz;

import java.util.List;

import org.bigjava.bean.Content;
import org.bigjava.dao.ContentDao;
import org.bigjava.dao.impl.ContentImpl;
import org.bigjava.service.ContentService;

public class ContentServiceImpl implements ContentService{
	private ContentDao contentdao = new ContentImpl();
	@Override
	public void addContent(Content content) {
		
		 contentdao.addContent(content);
	}

	@Override
	public void deleteContent(Integer id) {
		contentdao.deleteContent(id);
	}

	@Override
	public void updateContent(Content content) {
		contentdao.updateContent(content);
	}

	@Override
	public Content queryContentById(Integer id) {
		return contentdao.queryContentById(id);
	}

	@Override
	public List<Content> queryContentList() {
		return contentdao.queryContentList();
	}
	
}
