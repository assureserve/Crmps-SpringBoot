package com.crmps.utils;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	public static List<String> credentialList = new ArrayList<String>();

	public static List<String> contentList = new ArrayList<String>();

	public static List<String> categoryList = new ArrayList<String>();

	
	public static List<String> getContentList() {
		contentList.add("viedos");
		contentList.add("pictures");
		return contentList;
	}


	public static List<String> getCategoryList() {
		categoryList.add("responseTime");
		categoryList.add("paymentType");
		return categoryList;
	}



	public static void setCategoryList(List<String> categoryList) {
		Constant.categoryList = categoryList;
	}



	public static void setContentList(List<String> contentList) {
		Constant.contentList = contentList;
	}

	public static List<String> getCredentialList() {
		credentialList.add("authorizedProviders");
		credentialList.add("businessLicenses");
		credentialList.add("certifications");
		credentialList.add("industyAffliations");
		return credentialList;
	}

	public static void setCredentialList(List<String> credentialList) {
		Constant.credentialList = credentialList;
	}
	

}
