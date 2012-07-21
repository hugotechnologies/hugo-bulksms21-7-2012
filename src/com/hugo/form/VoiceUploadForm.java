package com.hugo.form;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class VoiceUploadForm extends ValidatorForm{
private FormFile filelocation;
private String description;

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public FormFile getFilelocation() {
	return filelocation;
}

public void setFilelocation(FormFile filelocation) {
	this.filelocation = filelocation;
}

}
