package com.crmps.domain;

public class ServiceProduct extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String serviceProductUid;
	private String serviceProductSubUid;
	private String entityType;
	private String description;

	
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
	public String getServiceProductSubUid() {
		return serviceProductSubUid;
	}
	public void setServiceProductSubUid(String serviceProductSubUid) {
		this.serviceProductSubUid = serviceProductSubUid;
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
