package com.crmps.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.crmps.dao.EntityCredentialDao;
import com.crmps.domain.Credential;
import com.crmps.utils.Constant;

@Component
public class CredentialModel  {

	@Autowired
	private EntityCredentialDao entityCredentialDao;

	
	public boolean addCredential(String entityUid, Credential credential) {
		boolean retVal = false;
		int value = 0;
		value = entityCredentialDao.addCredential(entityUid,credential);
		if (value > 0) {
			retVal = true;
		}
		return retVal;
	}

	public boolean addCredentials( String entityUid, List<Credential> credentials) {
		boolean retVal = false;
		if (credentials != null) {
			int value = 0;
			for (Credential credential : credentials) {
				value = entityCredentialDao.addCredential(entityUid,credential);
				if (value > 0) {
					retVal = true;
				}
			}
		}
		return retVal;
	}

	
	public boolean addCredentials(String entityUid ,  Map<String,List<Credential> > credentialMap) {
		boolean retVal = false;
		if (credentialMap != null) {
			for (Map.Entry<String, List<Credential>> entry : credentialMap.entrySet()) {
				retVal = addCredentials( entityUid, entry.getValue());
			}
		}
		return retVal;
	}

	
	public List<Credential> findCredentialByEntity(String entityUid) {
		return  entityCredentialDao.findByEnitityUid(entityUid);
	}
	
	
	public Map<String,List<Credential> > findCredentialsByEntity(String entityUid) {
		Map<String,List<Credential>> map = new HashMap<String,List<Credential>>();
		List<String> credentialKeys =Constant.getCredentialList();
		for(String key: credentialKeys){
			List<Credential> credential =entityCredentialDao.findByEnitityUidAndType(entityUid, key);
			map.put(key, credential);
		}
		return  map;
	}


	
	public List<Credential> findCredentialByEntityAndType(String entityUid, String type) {
		return  entityCredentialDao.findByEnitityUidAndType(entityUid, type);
	}

}
