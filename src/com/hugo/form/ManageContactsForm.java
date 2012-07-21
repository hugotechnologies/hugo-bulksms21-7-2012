package com.hugo.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class ManageContactsForm extends ValidatorForm{
	                         
	private String creategroup;
	private FormFile filelocation;
	public String getCreategroup() {
		return creategroup;
	}
	public void setCreategroup(String creategroup) {
		this.creategroup = creategroup;
	}
	public FormFile getFilelocation() {
		return filelocation;
	}
	public void setFilelocation(FormFile filelocation) {
		this.filelocation = filelocation;
	}
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		creategroup = "";
		filelocation= null;
	}

}
