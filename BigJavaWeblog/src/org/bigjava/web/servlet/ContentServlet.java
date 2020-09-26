package org.bigjava.web.servlet;

import org.bigjava.service.ContentService;
import org.bigjava.service.biz.ContentServiceImpl;

public class ContentServlet extends BaseServlet {
	private ContentService contentservice = new ContentServiceImpl();
} 
