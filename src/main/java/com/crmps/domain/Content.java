package com.crmps.domain;

public class Content extends AbstractBaseEntity {
	

	private static final long serialVersionUID = 1L;
	
	private String url;
	private String type;
	private String header;
	


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
