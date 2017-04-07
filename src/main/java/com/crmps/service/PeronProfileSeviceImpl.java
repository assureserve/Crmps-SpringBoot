package com.crmps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmps.domain.Address;
import com.crmps.domain.Contact;
import com.crmps.domain.Person;
import com.crmps.model.AddressModel;
import com.crmps.model.ContactModel;
import com.crmps.model.PersonModel;

@Service
public class PeronProfileSeviceImpl implements PersonProfileService {

	@Autowired
	private PersonModel personModel;

	@Autowired
	private AddressModel addressModel;
	

	@Autowired
	private ContactModel contactModel;

	@Override
	public String addPersonProfile(Person person) {
		String personUid="";
		boolean value =personModel.addPerson(person);
		if ( value ){
			personUid= person.getUid();
			List<Address> addressList = person.getAddressList();
			addressModel.addAddresses(personUid, "PERSON", addressList);
			List<Contact> contactList = person.getContactList();
			contactModel.addContacts(personUid,  "PERSON", contactList);
		}
		return personUid;
	}
	
	@Override
	public Person findPersonProfileForUid(String uid) {
		Person person =personModel.findPersonByUid(uid);
		if ( person!= null && person.getUid().length()>10){
			List<Address> addressList = addressModel.findAddressesByEnity(person.getUid());
			person.setAddressList(addressList);
			List<Contact> contactList = contactModel.findContactsByEnity(person.getUid());
			person.setContactList(contactList);
		}
		return person;
	}

	@Override
	public Person findPersonProfileForUserId(String userId) {
		
		Person person =personModel.findPersonByUserid(userId);
		if ( person!= null && person.getUid().length()>10){
			List<Address> addressList = addressModel.findAddressesByEnity(person.getUid());
			person.setAddressList(addressList);
			List<Contact> contactList = contactModel.findContactsByEnity(person.getUid());
			person.setContactList(contactList);
		}
		return person;
	}
}

