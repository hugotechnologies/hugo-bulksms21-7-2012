package com.hugo.action;

public class GetData {
	int contactId;
	int loginId;
	String recipientname;
	String recipientemail;
	String recipientphone;
	String notes;

	public int getContactId() {
		return contactId;
	}

	public int getLoginId() {
		return loginId;
	}

	public String getRecipientname() {
		return recipientname;
	}

	public String getRecipientemail() {
		return recipientemail;
	}

	public String getRecipientphone() {
		return recipientphone;
	}

	public String getNotes() {
		return notes;
	}

	public GetData() {

	}
	
	
	public GetData(int contactId, int loginId, String recipientname,
			String recipientemail, String recipientphone, String notes) {

		this.contactId = contactId;
		this.loginId = loginId;
		this.recipientname = recipientname;
		this.recipientemail = recipientemail;
		this.recipientphone = recipientphone;
		this.notes = notes;
		
	}
}