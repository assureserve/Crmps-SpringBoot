package com.crmps;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.PersonDao;
import com.crmps.domain.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private PersonDao personDao;

	//@Test
	public void testPersonLastName() {
		List<Person> list = personDao.findByLastName("Test");
		for (Person person : list) {
			System.out.println("First Person "+person.getFirstName());
		}
		
	}
	
	//@Test
	public void testPersonUserId() {
		Person person = personDao.findByUserId("palledp");
		System.out.println("First Person "+person.getFirstName());
		
	}
	
	//@Test
	public void testAddPerson() {
		Person person = new Person();
		person.setFirstName("Prakash");
		person.setLastName("Palled");
		person.setUserId("prakashp");
		person.setPassword("password");
		int number = personDao.addPerson(person);
		System.out.println("First Person "+number);
	}
	
}
