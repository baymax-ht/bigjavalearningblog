package org.bigjava.test;

import static org.junit.Assert.*;

import org.bigjava.bean.Content;
import org.bigjava.dao.ContentDao;
import org.bigjava.dao.impl.ContentImpl;
import org.junit.Test;

public class ContentServiceTest {
	private ContentDao contentdao = new ContentImpl();
	@Test
	public void testAddContent() {
		contentdao.addContent(new Content(null,"����","������"));
	}

	@Test
	public void testDeleteContent() {
		contentdao.deleteContent(8);
	}

	@Test
	public void testUpdateContent() {
		contentdao.updateContent(new Content(6,"������ν","����ҪȥңԶ�ĵط�"));
	}

	@Test
	public void testQueryContentById() {
		System.out.println(contentdao.queryContentById(6));
	}

	@Test
	public void testQueryContentList() {
		for(Content content : contentdao.queryContentList()) {
			System.out.println(content);
		}
	}

}
