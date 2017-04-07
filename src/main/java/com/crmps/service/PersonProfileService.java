package com.crmps.service;


import com.crmps.domain.Person;
public interface PersonProfileService {
	
	String addPersonProfile(Person person);
	Person findPersonProfileForUserId(String userId);
	Person findPersonProfileForUid(String uid);
}
