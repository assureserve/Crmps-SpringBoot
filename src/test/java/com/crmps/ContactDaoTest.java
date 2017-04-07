package com.crmps;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.ContactDao;
import com.crmps.domain.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactDaoTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private ContactDao contactDao;

	//@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setType("EMAIL");
		contact.setValue("test@test.com");
		int number = contactDao.addContact(contact);
		System.out.println("Address "+number);
	}
	
	@Test
	public void testFindByUid() {
	
		List<Contact>  list = contactDao.findByUid("73d785a4-94ed-493c-aa72-8504fdf9a1ec");
		for (Contact contact : list) {
			System.out.println("Contact "+contact.getValue());

		}
	}
}
