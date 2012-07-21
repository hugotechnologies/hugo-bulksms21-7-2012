package com.hugo.form;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class UploadForm extends ValidatorForm {
	private FormFile filelocation;

	public FormFile getFilelocation() {
		return filelocation;
	}

	public void setFilelocation(FormFile filelocation) {
		this.filelocation = filelocation;
	}
	
}
