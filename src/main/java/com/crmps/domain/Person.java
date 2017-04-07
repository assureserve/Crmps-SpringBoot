package com.crmps.domain;

import java.util.List;


public class Person extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;

	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	private String govermentId;

	private String pictureURL;

	
	
	private List<Address> addressList ;

	private List<Contact> contactList ;
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
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
