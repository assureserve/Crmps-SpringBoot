package com.crmps;


import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.EntityCategoryDao;
import com.crmps.dao.EntityCredentialDao;
import com.crmps.domain.Category;
import com.crmps.domain.Credential;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityCredentialTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private EntityCredentialDao entityCredentialDao;

	
	
	//@Test
	public void testAddLicCredential() {
		String entityUid = "1231231231231231";

		Credential credential = new Credential();
		credential.setDescription("Business Lic");
		credential.setExpireDate( new Date(System.currentTimeMillis()));
		credential.setIssueDate( new Date(System.currentTimeMillis()));
		credential.setIdNumber("1232312abcdee");
		credential.setType("LIC");
		int number = entityCredentialDao.addCredential(entityUid,credential);
		System.out.println("Credential "+number);
	}
	
	
	//@Test
	public void testAddCertifcateCredential() {
		Credential credential = new Credential();
		credential.setDescription("Business Lic");
		String entityUid = "1231231231231231";
		credential.setExpireDate( new Date(System.currentTimeMillis()));
		credential.setIssueDate( new Date(System.currentTimeMillis()));
		credential.setIdNumber("1232312abcdee");
		credential.setType("CERTIFICATE");
		int number = entityCredentialDao.addCredential(entityUid,credential);
		System.out.println("Credential "+number);
	}
	
	@Test
	public void testGetCredential() {
	
		List<Credential> credentialList= entityCredentialDao.findByEnitityUid("1231231231231231");
		
		for (Credential credential : credentialList) {
			System.out.println("credential id "+ credential.getIdNumber());
			System.out.println("credential type "+ credential.getType());

		}
	}
	
	
}
