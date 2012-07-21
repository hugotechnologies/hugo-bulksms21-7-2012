package com.hugo.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.ManageForm;
import com.hugo.pojo.GroupContactsPojo;

public class ManageAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception
			{
		String userid = request.getSession().getAttribute("id").toString();

		// System.out.println("id is.."+id);
		ManageForm manageForm=(ManageForm)form;
		ArrayList<ManageData> al = loadData1(userid);
	                  manageForm.setList(al);
		request.getSession().setAttribute("ManageForm",manageForm);
		return mapping.findForward("manageview");
	}

	public ArrayList<ManageData> loadData1(String id) 
	{
		ArrayList<ManageData> userList = new ArrayList<ManageData>();
		
	Session	session3 = HibernateConfiguration.getsession();
		Transaction transaction = session3.beginTransaction();
		String query = "FROM GroupContactsPojo as u where u.mloginid=:myId";
		@SuppressWarnings("rawtypes")
		List users = session3.createQuery(query).setString("myId", id).list();
		
		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				GroupContactsPojo grouppojo = (GroupContactsPojo) iterator.next();
				int groupcontactid = grouppojo.getGroupcontactid();
				//int loginId = grouppojo.getLoginId();
				String recipientname = grouppojo.getRname();
				String recipientemail = grouppojo.getRemail();
				String recipientphone = grouppojo.getRphone();
				//String notes = uploadPojo.getNotes();
				System.out.println("Data is.." +groupcontactid + " " + 
						 " " + recipientname + " " + recipientemail + " "
						+ recipientphone );
				userList.add(new ManageData(groupcontactid, recipientname,recipientemail, recipientphone) {
						});

			}

		}
		transaction.commit();
		return userList;

	}
}
