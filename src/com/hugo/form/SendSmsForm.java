package com.hugo.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class SendSmsForm extends ValidatorForm 
{

private String body;
private String templatename;

public String getTemplatename() {
	return templatename;
}
public void setTemplatename(String templatename) {
	this.templatename = templatename;
}

public String getBody()
{
	return body;
}
public void setBody(String body) 
{
	this.body = body;
}







}
