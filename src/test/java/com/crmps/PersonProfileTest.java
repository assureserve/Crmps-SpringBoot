package com.crmps;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.domain.Address;
import com.crmps.domain.Contact;
import com.crmps.domain.Person;
import com.crmps.service.PersonProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonProfileTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private PersonProfileService personProfileService;

	
	
	//@Test
	public void testAddPersonProfile() {
		
		List<Address> addressList = new ArrayList<Address>();
		Address address = new Address();
		address.setStreet1("1110");
		address.setStreet2("Street1");
		address.setCity("Suwanee");
		address.setZip("password");
		address.setState("GA");
		address.setCountry("USA");
		address.setType("Home");
		addressList.add(address);
		
		address = new Address();
		address.setStreet1("1110");
		address.setStreet2("Street1");
		address.setCity("Suwanee");
		address.setZip("password");
		address.setState("GA");
		address.setCountry("USA");
		address.setType("Office");
		addressList.add(address);

		
		
		Person person = new Person();
		person.setFirstName("Prakash");
		person.setLastName("Palled");
		person.setUserId("palledp");
		person.setPassword("password");
		
		List<Contact> contactList = new ArrayList<Contact>();

		Contact contact = new Contact();
		contact.setType("EMAIL");
		contact.setValue("test@test.com");
		
		contactList.add(contact);
		
		contact = new Contact();
		contact.setType("HOMEPHONE");
		contact.setValue("123-123-1234");
		
		contactList.add(contact);
		
		person.setAddressList(addressList);
		person.setContactList(contactList);

		String id = personProfileService.addPersonProfile(person);
		System.out.println("Person Id "+id);
	}
	
	//@Test
	public void testFindPersonProfile(){
		Person person = personProfileService.findPersonProfileForUserId("ppalledp");
		System.out.println("Person Name" + person.getFirstName());
		List<Address> list =person.getAddressList();
		for (Address address : list) {
			System.out.println(address.getCity());
		}
		
		List<Contact> contactList =person.getContactList();
		for (Contact contact : contactList) {
			System.out.println(contact.getValue());
		}
	}
	
}
