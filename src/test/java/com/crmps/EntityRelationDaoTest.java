package com.crmps;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.EntityReleationDao;
import com.crmps.domain.EntityAddressRelation;
import com.crmps.domain.EntityContactRelation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityRelationDaoTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private EntityReleationDao entityReleationDao;

	
	
	//@Test
	public void testEnityAddress() {
		EntityAddressRelation entityAddress = new EntityAddressRelation();
		entityAddress.setEntityType("PERSON");
		entityAddress.setEntityUid("1231231231231231");
		entityAddress.setAddressUid("2321321312312313");
	
		int number = entityReleationDao.addEntityAddress(entityAddress);
		System.out.println("Address "+number);
	}
	
	@Test
	public void testEnityContact() {
		EntityContactRelation entityContact = new EntityContactRelation();
		entityContact.setEntityType("PERSON");
		entityContact.setEntityUid("1231231231231231");
		entityContact.setContactUid("2321321312312313");
	
		int number = entityReleationDao.addEntityContact(entityContact);
		System.out.println("Address "+number);
	}
	
	
}
