package com.hugo.action;

public class ManageData {
	int groupcontactid;
	String recipientname;
	String recipientemail;
	String recipientphone;
	
	public int getGroupcontactid() {
		return groupcontactid;
	}


	public void setGroupcontactid(int groupcontactid) {
		this.groupcontactid = groupcontactid;
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


	

	
	

ManageData()
{
	
}
	

	public  ManageData(int groupcontactid, String recipientname,String recipientemail, String recipientphone) 
	{
		this.groupcontactid=groupcontactid;
		this.recipientname = recipientname;
		this.recipientemail = recipientemail;
		this.recipientphone = recipientphone;
		
		
	}
}
