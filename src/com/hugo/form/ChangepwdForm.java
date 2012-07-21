package com.hugo.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

@SuppressWarnings("serial")
public class ChangepwdForm extends ValidatorForm {
	
	private String oldpwd;
	private String newpwd;
	private String retype;
	
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		oldpwd= "";
		newpwd= "";
		retype= "";
	}

}
