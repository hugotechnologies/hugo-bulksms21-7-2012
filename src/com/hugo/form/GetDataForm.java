package com.hugo.form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class GetDataForm extends ActionForm {
	@SuppressWarnings("rawtypes")
	private ArrayList list;
	public GetDataForm(){
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
