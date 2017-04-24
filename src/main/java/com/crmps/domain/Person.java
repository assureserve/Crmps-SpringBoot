package com.crmps.domain;

import java.util.List;
import java.util.Map;



public class Person extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;

	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	private String govermentId;

	private String pictureURL;
	
	private List<Address> addresses ;

	private List<Contact> contacts ;
	
	private List<ProductWorkItem> productWorkItems ;
	
	private List<WorkHour> workHours ;
	
	private List<ServiceProduct> serviceProducts ;
	
	private Map<String,List<Credential>> credentials ;
	
	private Map<String,List<Category>> categories ;

	
	public Map<String, List<Category>> getCategories() {
		return categories;
	}



	public void setCategories(Map<String, List<Category>> categories) {
		this.categories = categories;
	}



	public Map<String, List<Credential>> getCredentials() {
		return credentials;
	}
	
	private Map<String,List<Content>> contents ;
	
	


	public Map<String, List<Content>> getContents() {
		return contents;
	}



	public void setContents(Map<String, List<Content>> contents) {
		this.contents = contents;
	}



	public void setCredentials(Map<String, List<Credential>> credentials) {
		this.credentials = credentials;
	}


	
	public List<ProductWorkItem> getProductWorkItems() {
		return productWorkItems;
	}

	public void setProductWorkItems(List<ProductWorkItem> productWorkItems) {
		this.productWorkItems = productWorkItems;
	}

	public List<WorkHour> getWorkHours() {
		return workHours;
	}

	public void setWorkHours(List<WorkHour> workHours) {
		this.workHours = workHours;
	}

	public List<ServiceProduct> getServiceProducts() {
		return serviceProducts;
	}

	public void setServiceProducts(List<ServiceProduct> serviceProducts) {
		this.serviceProducts = serviceProducts;
	}

	


	
	


	public List<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}



	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	public String getGovermentId() {
		return govermentId;
	}

	public void setGovermentId(String govermentId) {
		this.govermentId = govermentId;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
