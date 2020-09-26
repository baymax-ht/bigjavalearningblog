package org.bigjava.test;

import static org.junit.Assert.*;

import org.bigjava.bean.Content;
import org.bigjava.dao.ContentDao;
import org.bigjava.dao.impl.ContentImpl;
import org.junit.Test;

public class ContentDaoTest {
	ContentDao contentdao = new ContentImpl();
	@Test
	public void testAddContent() {
		contentdao.addContent(new Content(null,"ssdffsdf","带你去遥远的地方"));
	}

	@Test
	public void testDeleteContent() {
		contentdao.deleteContent(7);
	}

	@Test
	public void testUpdateContent() {
		contentdao.updateContent(new Content(6,"面朝大海春暖花开","面朝大海春暖花开"));
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
