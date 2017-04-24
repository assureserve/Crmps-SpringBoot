package com.crmps.domain;

public class WorkHour extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String day;
	private String fromTime;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	private String toTime;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
