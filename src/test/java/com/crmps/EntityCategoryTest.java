package com.crmps;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.EntityCategoryDao;
import com.crmps.dao.EntityCredentialDao;
import com.crmps.domain.Category;
import com.crmps.domain.Credential;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityCategoryTest {

	@Test
	public void contextLoads() {
	}
	

	@Autowired
	private EntityCategoryDao entityCategoryDao;

	
	
	@Test
	public void testAddCategory() {
		String entityUid = "1231231231231231";

		Category category = new Category();
		category.setDescription("Emergency Service");
		category.setCategoryUid("100");
		category.setType("RESPONSE");
		int number = entityCategoryDao.addCategory(entityUid,category);
		System.out.println("Credential "+number);
	}
	
	
	@Test
	public void testGetCredential() {
	
		List<Category> credentialList= entityCategoryDao.findCategroyByEntityAndType("1231231231231231","RESPONSE");
		
		for (Category credential : credentialList) {
			System.out.println("credential id "+ credential.getDescription());
			System.out.println("credential type "+ credential.getType());

		}
	}
}
