package com.hugo.operations;

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

import com.hugo.pojo.UploadPojo;

public class DeleteContacts extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		
		String status="failure";
		Session session = null;
		String userid = request.getSession().getAttribute("id").toString();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = null;

		transaction = session.beginTransaction();

		String query = "FROM UploadPojo as u where u.loginId=:myId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("myId", userid)
				.list();

		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				UploadPojo uploadPojo = (UploadPojo) iterator.next();
				session.delete(uploadPojo);
			}
			status="success";
			
		}
		
		transaction.commit();
		return mapping.findForward(status);

	}

}
