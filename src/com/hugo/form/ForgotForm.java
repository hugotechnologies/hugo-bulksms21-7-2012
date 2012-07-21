package com.hugo.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ForgotForm extends ValidatorForm
{
String email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public void reset(ActionMapping mapping, ValidatorForm form,HttpServletRequest request,HttpServletResponse response) {
	// reset properties
	super.reset(mapping,request);
	this.email = "";
	
	//form.reset(mapping=null,request=null);
	//form.reset();
}
}
