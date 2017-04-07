package com.crmps.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


public abstract class AbstractBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String uid;
	
	private String createdBy;
	private String updatedBy;
	private Timestamp createdTimestamp;
	private Timestamp updatedTimestamp;

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public AbstractBaseEntity() {
		this.uid = UUID.randomUUID().toString();
		createdTimestamp = new Timestamp(System.currentTimeMillis());
		updatedTimestamp= createdTimestamp;
		createdBy ="System";
		updatedBy =createdBy;
	}

	@Override
	public int hashCode() {
		return uid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractBaseEntity)) {
			return false;
		}
		AbstractBaseEntity other = (AbstractBaseEntity) obj;
		return getUid().equals(other.getUid());
	}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}