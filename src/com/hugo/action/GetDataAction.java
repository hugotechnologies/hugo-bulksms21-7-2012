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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.form.GetDataForm;
import com.hugo.pojo.UploadPojo;

public class GetDataAction extends Action {
	private final static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userid = request.getSession().getAttribute("id").toString();

		// System.out.println("id is.."+id);
		GetDataForm dataForm = (GetDataForm) form;
		ArrayList<GetData> al = loadData(userid);
		dataForm.setList(al);
		request.getSession().setAttribute("GetDataForm", dataForm);
		return mapping.findForward(SUCCESS);
	}

	Session session = null;

	public ArrayList<GetData> loadData(String id) {
		ArrayList<GetData> userList = new ArrayList<GetData>();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM UploadPojo as u where u.loginId=:myId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("myId", id).list();
		
		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				UploadPojo uploadPojo = (UploadPojo) iterator.next();
				int contactId = uploadPojo.getContactId();
				int loginId = uploadPojo.getLoginId();
				String recipientname = uploadPojo.getRecipientname();
				String recipientemail = uploadPojo.getRecipientemail();
				String recipientphone = uploadPojo.getRecipientphone();
				String notes = uploadPojo.getNotes();
				System.out.println("Data is.." + contactId + " " + loginId
						+ " " + recipientname + " " + recipientemail + " "
						+ recipientphone + " " + notes);
				userList.add(new GetData(contactId, loginId, recipientname,
						recipientemail, recipientphone, notes) {
						});

			}

		}
		transaction.commit();
		return userList;

	}

}
