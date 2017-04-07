package com.crmps.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.AddressDao;
import com.crmps.dao.EntityReleationDao;
import com.crmps.domain.Address;
import com.crmps.domain.EntityAddressRelation;

@Component
public class AddressModel  {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private EntityReleationDao entityReleationDao;

	
	public boolean addAddress(String entityUid, String entityType, Address address) {
		boolean retVal = false;
		int value = 0;
		value = addressDao.addAddress(address);
		if (value > 0) {
			EntityAddressRelation entityAddress = new EntityAddressRelation();
			entityAddress.setAddressUid(address.getUid());
			entityAddress.setEntityUid(entityUid);
			entityAddress.setEntityType(entityType);
			entityReleationDao.addEntityAddress(entityAddress);
			retVal = true;
		}
		return retVal;
	}

	
	public boolean addAddresses(String entityUid, String entityType, List<Address> addressList) {
		boolean retVal = false;
		if (addressList != null) {
			int value = 0;
			for (Address address : addressList) {
				value = addressDao.addAddress(address);
				if (value > 0) {
					EntityAddressRelation entityAddress = new EntityAddressRelation();
					entityAddress.setAddressUid(address.getUid());
					entityAddress.setEntityUid(entityUid);
					entityAddress.setEntityType(entityType);
					entityReleationDao.addEntityAddress(entityAddress);
					retVal = true;
				}
			}
		}
		return retVal;
	}
	
	
	public List<Address> findAddressesByEnity(String entityUid) {
		return  addressDao.findByUid(entityUid);
	}


}
