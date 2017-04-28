package com.crmps.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.EntityContentDao;
import com.crmps.dao.EntityServiceReleationDao;
import com.crmps.domain.Content;
import com.crmps.domain.Credential;
import com.crmps.domain.ProductWorkItem;
import com.crmps.domain.ServiceProduct;
import com.crmps.domain.WorkHour;

@Component
public class ProductRelationModel  {

	@Autowired
	private EntityServiceReleationDao entityServiceReleationDao;

	
	public boolean addProductWorkItem( String entityUid, ProductWorkItem workItem) {
		boolean retVal = false;
		int value = 0;
		value = entityServiceReleationDao.addEnityProductWorkItem(entityUid,workItem);
		if (value > 0) {
			retVal = true;
		}
		return retVal;
	}
	

	public boolean addProductWorkItems( String entityUid, List<ProductWorkItem> workitems) {
		boolean retVal = false;
		if (workitems != null) {
			for (ProductWorkItem workItem : workitems) {
				retVal = addProductWorkItem(entityUid,workItem);
			}
		}
		return retVal;
	}

	public boolean addServiceProduct( String entityUid, ServiceProduct serviceProd) {
		boolean retVal = false;
		int value = 0;
		value = entityServiceReleationDao.addSerivceProduct(entityUid,serviceProd);
		if (value > 0) {
			retVal = true;
		}
		return retVal;
	}
	
	public boolean addServiceProducts( String entityUid, List<ServiceProduct> serviceProds) {
		boolean retVal = false;
		if (serviceProds != null) {
			for (ServiceProduct serviceProd : serviceProds) {
				retVal = addServiceProduct(entityUid,serviceProd);
			}
		}
		return retVal;
	}
	
	public boolean addWorkHour( String entityUid, WorkHour workHour) {
		boolean retVal = false;
		int value = 0;
		value = entityServiceReleationDao.addWorkHours(entityUid,workHour);
		if (value > 0) {
			retVal = true;
		}
		return retVal;
	}
	
	public boolean addWorkHours( String entityUid, List<WorkHour> workHours) {
		boolean retVal = false;
		if (workHours != null) {
			for (WorkHour workHour : workHours) {
				retVal = addWorkHour(entityUid,workHour);
			}
		}
		return retVal;
	}

	
	public List<ServiceProduct> findServiceProducts(String entityUid) {
		return  entityServiceReleationDao.findServiceProductRel(entityUid);
	}

	public List<ProductWorkItem> findProductWorkItems(String entityUid) {
		return  entityServiceReleationDao.findWorkProductItemsByUid(entityUid);
	}
	
	public List<WorkHour> findWokingHours(String entityUid) {
		return  entityServiceReleationDao.findWorkingHours(entityUid);
	}

}
