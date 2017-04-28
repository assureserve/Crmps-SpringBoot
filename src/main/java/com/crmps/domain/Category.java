package com.crmps.domain;

public class Category extends AbstractBaseEntity{
	

	private static final long serialVersionUID = 1L;
	
	private String description;
	private String type;
	private String entityUid;
	private String categoryUid;
	
	public String getCategoryUid() {
		return categoryUid;
	}
	public void setCategoryUid(String categoryUid) {
		this.categoryUid = categoryUid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEntityUid() {
		return entityUid;
	}
	public void setEntityUid(String entityUid) {
		this.entityUid = entityUid;
	}


}
