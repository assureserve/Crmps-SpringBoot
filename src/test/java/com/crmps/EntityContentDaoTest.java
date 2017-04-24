package com.crmps;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.EntityContentDao;
import com.crmps.domain.Content;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityContentDaoTest {

	@Test
	public void contextLoads() {
	}
	

	@Autowired
	private EntityContentDao entityContentDao;

	
	
	@Test
	public void testAddContent() {
		String entityUid = "1231231231231231";

		Content content = new Content();
		content.setUrl("http://test.com/test.jpg");
		content.setHeader("test url for testing");
		content.setType("VIDEO");
		int number = entityContentDao.addContent(entityUid,content);
		System.out.println("Credential "+number);
	}
	
	
	@Test
	public void testGetContent() {
	
		List<Content> contentList= entityContentDao.findContentByType("1231231231231231","VIDEO");
		
		for (Content content : contentList) {
			System.out.println("Content id "+ content.getUrl());
			System.out.println("Content type "+ content.getType());
			System.out.println("Content header "+ content.getHeader());


		}
	}
}
