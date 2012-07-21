package com.hugo.form;


import org.apache.struts.action.ActionForm;

public class GroupingForm extends ActionForm{
private String groups;
private String emailid;
public String getGroups() {
	return groups;
}
public void setGroups(String groups) {
	this.groups = groups;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
	
}
}
