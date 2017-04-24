package com.crmps.domain;

public class BusinessTypeRelation extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String entityUid;
	private String businessTypeUid;
	private String entityType;

	public String getBusinessTypeUid() {
		return businessTypeUid;
	}
	public void setBusinessTypeUid(String businessTypeUid) {
		this.businessTypeUid = businessTypeUid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEntityUid() {
		return entityUid;
	}
	public void setEntityUid(String entityUid) {
		this.entityUid = entityUid;
	}

	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
}
