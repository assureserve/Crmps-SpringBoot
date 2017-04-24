package com.crmps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.domain.Address;
import com.crmps.domain.Category;
import com.crmps.domain.Contact;
import com.crmps.domain.Content;
import com.crmps.domain.Credential;
import com.crmps.domain.Person;
import com.crmps.domain.ProductWorkItem;
import com.crmps.domain.ServiceProduct;
import com.crmps.domain.WorkHour;
import com.crmps.service.PersonProfileService;
import com.crmps.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonProfileTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private PersonProfileService personProfileService;

	
	
	@Test
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
		person.setFirstName("Bob");
		person.setLastName("Guru");
		person.setUserId("abcd1");
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
		
		person.setAddresses(addressList);
		person.setContacts(contactList);

		List<String> credentialList  = Constant.getCredentialList();

		Credential c1 = new Credential();
		c1.setType(credentialList.get(1));
		c1.setDescription("xyzProvider");

		Credential c2= new Credential();
		c2.setType(credentialList.get(1));
		c2.setDescription("xyzProvider");
		
		Credential l1 = new Credential();
		l1.setType(credentialList.get(2));
		l1.setDescription("abc business lic");
		l1.setIdNumber("12333");

		Credential l2 = new Credential();
		l2.setType(credentialList.get(2));
		l2.setDescription("abc1 business lic");
		l2.setIdNumber("12334");

		List<Credential> listc1 = new ArrayList<Credential>();
		listc1.add(c1);
		listc1.add(c2);
		
		List<Credential> listl1 = new ArrayList<Credential>();
		listl1.add(l1);
		listl1.add(l2);
		
		Map<String,List<Credential>> credentials = new HashMap<String,List<Credential>>();

		credentials.put(credentialList.get(1), listc1);
		credentials.put(credentialList.get(2), listl1);
		
		person.setCredentials(credentials);

		
		List<String> ctList  = Constant.getContentList();

		Content ct1 = new Content();
	    ct1.setType(ctList.get(0));
	    ct1.setHeader("Main Video");
	    ct1.setUrl("http://youtube.com/test");
	    
		List<Content> ct1List = new ArrayList<Content>();
		ct1List.add(ct1);
		
		
		Content ct2 = new Content();
		ct2.setType(ctList.get(1));
		ct2.setHeader("Main Pic");
		ct2.setUrl("http://pic.com/test");
	    
		List<Content> ct2List = new ArrayList<Content>();
		ct2List.add(ct2);

		Map<String,List<Content>> contents = new HashMap<String,List<Content>>();
		contents.put(ctList.get(0), ct1List);
		contents.put(ctList.get(1), ct2List);

		person.setContents(contents);

		
		
		List<String> catList  = Constant.getCategoryList();
		Category category = new Category();
		category.setDescription("Emergency Service");
		category.setCategoryUid("100");
		category.setType(catList.get(0));

		List<Category> catList1 = new ArrayList<Category>();
		catList1.add(category);
		
		Map<String,List<Category>> categories = new HashMap<String,List<Category>>();
		categories.put(catList.get(0), catList1);

		person.setCategories(categories);

		
		
		ProductWorkItem workItem = new ProductWorkItem();
		workItem.setDescription("");
		workItem.setProductItemUid("100");;
		workItem.setServiceProductUid("100");
		workItem.setCurrentOrHistory("C");
		
		List<ProductWorkItem> productWorkItems = new ArrayList<ProductWorkItem>();
		productWorkItems.add(workItem);
		person.setProductWorkItems(productWorkItems);

		List<WorkHour> workHours = new ArrayList<WorkHour>();

		WorkHour workHour = new WorkHour();
		workHour.setDay("SUNDAY");
		workHour.setFromTime("10:10");
		workHour.setToTime("12:10");;
		workHours.add(workHour);

		 workHour = new WorkHour();
			workHour.setDay("MONDAY");
			workHour.setFromTime("10:10");
			workHour.setToTime("13:10");;

		workHours.add(workHour);
		
		person.setWorkHours(workHours);
		
		ServiceProduct entityServiceRel = new ServiceProduct();
		entityServiceRel.setEntityType("PERSON");
		entityServiceRel.setServiceProductUid("100");
	
		List<ServiceProduct> serviceProducts = new ArrayList<ServiceProduct>();
		serviceProducts.add(entityServiceRel);
		
		person.setServiceProducts(serviceProducts);
		String id = personProfileService.addPersonProfile(person);
		System.out.println("Person Id "+id);
		
		
	}
	
	//@Test
	public void testFindPersonProfile(){
		Person person = personProfileService.findPersonProfileForUserId("palled");
		System.out.println("Person Name" + person.getFirstName());
		List<Address> list =person.getAddresses();
		for (Address address : list) {
			System.out.println(address.getCity());
		}
		
		List<Contact> contactList =person.getContacts();
		for (Contact contact : contactList) {
			System.out.println(contact.getValue());
		}
		
		
	}
	
}
