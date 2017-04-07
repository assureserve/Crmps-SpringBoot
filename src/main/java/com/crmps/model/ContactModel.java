package com.crmps.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.AddressDao;
import com.crmps.dao.ContactDao;
import com.crmps.dao.EntityReleationDao;
import com.crmps.domain.Address;
import com.crmps.domain.Contact;
import com.crmps.domain.EntityContactRelation;

@Component
public class ContactModel  {

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private EntityReleationDao entityReleationDao;

	
	public boolean addContact(String entityUid, String entityType, Contact contact) {
		boolean retVal = false;
		int value = 0;
		value = contactDao.addContact(contact);
		if (value > 0) {
			EntityContactRelation entityContact = new EntityContactRelation();
			entityContact.setContactUid(contact.getUid());
			entityContact.setEntityUid(entityUid);
			entityContact.setEntityType(entityType);
			entityReleationDao.addEntityContact(entityContact);
			retVal = true;
		}
		return retVal;
	}

	
	public boolean addContacts(String entityUid, String entityType, List<Contact> contactList) {
		boolean retVal = false;
		if (contactList != null) {
			int value = 0;
			for (Contact contact : contactList) {
				value = contactDao.addContact(contact);
				if (value > 0) {
					EntityContactRelation entityContact = new EntityContactRelation();
					entityContact.setContactUid(contact.getUid());
					entityContact.setEntityUid(entityUid);
					entityContact.setEntityType(entityType);
					entityReleationDao.addEntityContact(entityContact);
					retVal = true;
				}
			}
		}
		return retVal;
	}
	
	public List<Contact> findContactsByEnity(String entityUid) {
		return  contactDao.findByUid(entityUid);
	}

}
