package com.crmps.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.PersonDao;
import com.crmps.domain.Person;

@Component

public class PersonModel  {

	@Autowired
	private PersonDao personDao;

	public boolean addPerson(Person person) {
		boolean retVal=false;
		int value =personDao.addPerson(person);
		if ( value > 0){
			retVal = true;
		}
		return retVal;
	}
	
	public Person findPersonByUserid(String userId) {
		
		return personDao.findByUserId(userId);
	}
	
	public Person findPersonByUid(String uid) {
		
		return personDao.findByUid(uid);
	}
	
	public List<Person> findPersonByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

}
