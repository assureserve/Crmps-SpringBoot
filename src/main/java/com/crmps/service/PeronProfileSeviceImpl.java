package com.crmps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmps.domain.Address;
import com.crmps.domain.Category;
import com.crmps.domain.Contact;
import com.crmps.domain.Content;
import com.crmps.domain.Credential;
import com.crmps.domain.Person;
import com.crmps.domain.ProductWorkItem;
import com.crmps.domain.ServiceProduct;
import com.crmps.domain.WorkHour;
import com.crmps.model.AddressModel;
import com.crmps.model.CategoryModel;
import com.crmps.model.ContactModel;
import com.crmps.model.ContentModel;
import com.crmps.model.CredentialModel;
import com.crmps.model.PersonModel;
import com.crmps.model.ProductRelationModel;

@Service
public class PeronProfileSeviceImpl implements PersonProfileService {

	@Autowired
	private PersonModel personModel;

	@Autowired
	private AddressModel addressModel;

	@Autowired
	private ContactModel contactModel;

	@Autowired
	private ContentModel contentModel;

	@Autowired
	private CredentialModel credentialModel;

	@Autowired
	private ProductRelationModel productRelationModel;

	@Autowired
	private CategoryModel categoryModel;

	@Override
	public String addPersonProfile(Person person) {
		String personUid = "";
		boolean value = personModel.addPerson(person);
		if (value) {
			personUid = person.getUid();
			List<Address> addressList = person.getAddresses();
			addressModel.addAddresses(personUid, "PERSON", addressList);
			List<Contact> contactList = person.getContacts();
			contactModel.addContacts(personUid, "PERSON", contactList);
			List<ProductWorkItem> workItems = person.getProductWorkItems();
			productRelationModel.addProductWorkItems(personUid, workItems);

			List<ServiceProduct> serviceProds = person.getServiceProducts();
			productRelationModel.addServiceProducts(personUid, serviceProds);

			List<WorkHour> workHours = person.getWorkHours();
			productRelationModel.addWorkHours(personUid, workHours);

			Map<String, List<Content>> contentList = person.getContents();
			contentModel.addContents(personUid, contentList);

			Map<String, List<Credential>> credentials = person.getCredentials();
			credentialModel.addCredentials(personUid, credentials);

			Map<String, List<Category>> categories = person.getCategories();
			categoryModel.addCategories(personUid, categories);

		}
		return personUid;
	}

	@Override
	public Person findPersonProfileForUid(String uid) {
		Person person = personModel.findPersonByUid(uid);
		person = populatePerson(person);
		return person;
	}

	@Override
	public Person findPersonProfileForUserId(String userId) {

		Person person = personModel.findPersonByUserid(userId);
		person = populatePerson(person);
		return person;
	}

	private Person populatePerson(Person person) {

		if (person != null && person.getUid().length() > 10) {
			List<Address> addressList = addressModel.findAddressesByEnity(person.getUid());
			person.setAddresses(addressList);
			List<Contact> contactList = contactModel.findContactsByEnity(person.getUid());
			person.setContacts(contactList);

			List<ServiceProduct> serviceProducts = productRelationModel.findServiceProducts(person.getUid());
			person.setServiceProducts(serviceProducts);
			List<WorkHour> workHours = productRelationModel.findWokingHours(person.getUid());
			person.setWorkHours(workHours);
			List<ProductWorkItem> productWorkItems = productRelationModel.findProductWorkItems(person.getUid());
			person.setProductWorkItems(productWorkItems);

			Map<String, List<Content>> contents = contentModel.findContentsByEntity(person.getUid());
			person.setContents(contents);

			Map<String, List<Credential>> credentials = credentialModel.findCredentialsByEntity(person.getUid());
			person.setCredentials(credentials);

			Map<String, List<Category>> categories = categoryModel.findCredentialsByEntity(person.getUid());
			person.setCategories(categories);

		}
		return person;
	}
}
