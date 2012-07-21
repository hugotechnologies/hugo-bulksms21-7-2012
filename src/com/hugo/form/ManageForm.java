package com.hugo.form;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;
public class ManageForm extends ActionForm
{
	private ArrayList list; 
	public ManageForm(){
		super();
	}
	@SuppressWarnings("rawtypes")
	public ArrayList getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(ArrayList list) {
		this.list = list;
	}
	
}
