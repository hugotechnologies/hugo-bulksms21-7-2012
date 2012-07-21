package com.hugo.pojo;

import java.util.List;

public class MmsTemplatePojo {
private int	templateid;
private int loginid;
private String description;
private String bodytext;
private String mmstype;
private String footer;
private String header;
private byte[] file;
public MmsTemplatePojo()
{
	
}
public byte[] getFile() {
	return file;
}
public void setFile(byte[] file) {
	this.file = file;
}
public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}
public int getTemplateid() {
	return templateid;
}
public void setTemplateid(int templateid) {
	this.templateid = templateid;
}
public int getLoginid() {
	return loginid;
}
public void setLoginid(int loginid) {
	this.loginid = loginid;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getBodytext() {
	return bodytext;
}
public void setBodytext(String bodytext) {
	this.bodytext = bodytext;
}
public String getMmstype() {
	return mmstype;
}
public void setMmstype(String mmstype) {
	this.mmstype = mmstype;
}
public String getFooter() {
	return footer;
}
public void setFooter(String footer) {
	this.footer = footer;
}
}
