package com.hugo.form;

import org.apache.struts.validator.ValidatorForm;

public class SendEmailForm extends ValidatorForm{
	private String body;
	private String header;
	private String footer;
	private String description;
	 public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
