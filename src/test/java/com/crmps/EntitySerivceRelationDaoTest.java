package com.crmps;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crmps.dao.EntityServiceReleationDao;
import com.crmps.domain.ProductWorkItem;
import com.crmps.domain.ServiceProduct;
import com.crmps.domain.WorkHour;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntitySerivceRelationDaoTest {

	private String entityUid = "1231231231231231";

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private EntityServiceReleationDao entityServiceReleationDao;

	
	
	//@Test
	public void testProductRelation() {
		
		ServiceProduct entityServiceRel = new ServiceProduct();
		entityServiceRel.setEntityType("PERSON");
		entityServiceRel.setServiceProductUid("100");
	
		int number = entityServiceReleationDao.addSerivceProduct(entityUid,entityServiceRel);
		System.out.println("ProductRelation "+number);
	}
	
	//@Test
	public void testProductWorkHour(){
		WorkHour workHour = new WorkHour();
		workHour.setDay("SUNDAY");
		workHour.setFromTime("10:10");
		workHour.setToTime("12:10");;

		int number = entityServiceReleationDao.addWorkHours(entityUid,workHour);
		System.out.println("workHour "+number);
	}
	
	
	//@Test
	public void testProductWorkHistory(){
		ProductWorkItem workItem = new ProductWorkItem();
		workItem.setDescription("");
		workItem.setProductItemUid("100");;
		workItem.setServiceProductUid("100");
		workItem.setCurrentOrHistory("C");
		int number = entityServiceReleationDao.addEnityProductWorkItem(entityUid,workItem);
		System.out.println("workHistory "+number);
	}
	
	@Test
	public void testGetServiceProductRelation() {
	
		List<ServiceProduct> credentialList= entityServiceReleationDao.findServiceProductRel("1231231231231231");
		
		for (ServiceProduct credential : credentialList) {
			System.out.println("credential id "+ credential.getDescription());
			System.out.println("credential type "+ credential.getEntityType());

		}
	}
	
	@Test
	public void testGetProductWorkHistory() {
	
		List<ProductWorkItem> credentialList= entityServiceReleationDao.findWorkProductItemsByUid("1231231231231231");
		
		for (ProductWorkItem credential : credentialList) {
			System.out.println("credential id "+ credential.getDescription());
			System.out.println("credential current or history "+ credential.getCurrentOrHistory());


		}
	}
	
	

	@Test
	public void testGetWorkingHours() {
	
		List<WorkHour> credentialList= entityServiceReleationDao.findWorkingHours("1231231231231231");
		
		for (WorkHour credential : credentialList) {
			System.out.println("Day"+ credential.getDay());
			System.out.println("From Time"+ credential.getFromTime());
			System.out.println("To Time"+ credential.getToTime());

		}
	}
	
}
