package com.crmps.domain;

public class EntityAddressRelation extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String entityUid;
	private String addressUid;
	private String entityType;

	public String getEntityUid() {
		return entityUid;
	}
	public void setEntityUid(String entityUid) {
		this.entityUid = entityUid;
	}
	public String getAddressUid() {
		return addressUid;
	}
	public void setAddressUid(String addressUid) {
		this.addressUid = addressUid;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
}
