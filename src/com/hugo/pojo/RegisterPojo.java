package com.hugo.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class RegisterPojo implements Serializable{
	private int loginId;
	private String name;
	private String address;
	private String phone;
	private String user;
	private String password;
	private String emailId;
	private String cdate;
	private String status;
	private List<UploadPojo> uploadpojos;
	      
	public List<UploadPojo> getUploadpojos() {
		return uploadpojos;
	}
	public void setUploadpojos(List<UploadPojo> uploadpojos) {
		this.uploadpojos = uploadpojos;
	}
private List<MmsTemplatePojo> mmstemplatepojos;
	
	public List<MmsTemplatePojo> getMmstemplatepojos() {
		return mmstemplatepojos;
	}
	public void setMmstemplatepojos(List<MmsTemplatePojo> mmstemplatepojos) {
		this.mmstemplatepojos = mmstemplatepojos;
	}

	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/*public RegisterPojo(int loginId,String name,String address, String phone,String user,String password,String emailId,String cdate,String status)
	{
		this.loginId=loginId;
		this.address=address;
		this.cdate=cdate;
		this.name=name;
		this.password=password;
		this.phone=phone;
		this.status=status;
		this.user=user;
		this.emailId=emailId;
	}*/
}
