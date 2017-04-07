package com.crmps.domain;

public class EntityContactRelation extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String entityUid;
	private String contactUid;
	private String entityType;

	
	public String getContactUid() {
		return contactUid;
	}
	public void setContactUid(String contactUid) {
		this.contactUid = contactUid;
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
