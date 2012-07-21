package com.hugo.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class UploadPojo implements Serializable {
	private int contactId;
	private int loginId;
	private String recipientname;
	private String recipientemail;
	private String recipientphone;
	private String notes;
	RegisterPojo registerpojo;
	
	public RegisterPojo getRegisterpojo() {
		return registerpojo;
	}
	public void setRegisterpojo(RegisterPojo registerpojo) {
		this.registerpojo = registerpojo;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getRecipientname() {
		return recipientname;
	}
	public void setRecipientname(String recipientname) {
		this.recipientname = recipientname;
	}
	public String getRecipientemail() {
		return recipientemail;
	}
	public void setRecipientemail(String recipientemail) {
		this.recipientemail = recipientemail;
	}
	public String getRecipientphone() {
		return recipientphone;
	}
	public void setRecipientphone(String recipientphone) {
		this.recipientphone = recipientphone;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
