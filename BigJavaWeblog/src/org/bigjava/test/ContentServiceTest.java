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
		contentdao.addContent(new Content(null,"过狗","哈哈哈"));
	}

	@Test
	public void testDeleteContent() {
		contentdao.deleteContent(8);
	}

	@Test
	public void testUpdateContent() {
		contentdao.updateContent(new Content(6,"无所无谓","我想要去遥远的地方"));
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
