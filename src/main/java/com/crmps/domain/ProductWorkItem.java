package com.crmps.domain;

public class ProductWorkItem extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String serviceProductUid;
	private String productItemUid;
	private String entityType;
	private String description;
	private String currentOrHistory;

	
	
	public String getCurrentOrHistory() {
		return currentOrHistory;
	}
	public void setCurrentOrHistory(String currentOrHistory) {
		this.currentOrHistory = currentOrHistory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getServiceProductUid() {
		return serviceProductUid;
	}
	public void setServiceProductUid(String serviceProductUid) {
		this.serviceProductUid = serviceProductUid;
	}
	public String getProductItemUid() {
		return productItemUid;
	}
	public void setProductItemUid(String productItemUid) {
		this.productItemUid = productItemUid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
}
