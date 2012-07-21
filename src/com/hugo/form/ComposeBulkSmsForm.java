package com.hugo.form;

import org.apache.struts.action.ActionForm;

public class ComposeBulkSmsForm extends ActionForm
{
	String messagetype;
	String templatename;

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

}
