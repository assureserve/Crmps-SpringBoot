package com.crmps;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.AddressDao;
import com.crmps.domain.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private AddressDao addressDao;

	
	
	//@Test
	public void testAddAddress() {
		Address address = new Address();
		address.setStreet1("1110");
		address.setStreet2("Street1");
		address.setCity("Suwanee");
		address.setZip("password");
		address.setState("GA");
		address.setCountry("USA");
		address.setType("Home");
		int number = addressDao.addAddress(address);
		System.out.println("Address "+number);
	}
	

	@Test
	public void testFindByUid() {
	
		List<Address>  list = addressDao.findByUid("73d785a4-94ed-493c-aa72-8504fdf9a1ec");
		for (Address address : list) {
			System.out.println("Address "+ address.getCity());
		}
		
	}
	
}
