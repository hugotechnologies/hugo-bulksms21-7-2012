package com.hugo.action;

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

import com.hugo.form.ForgotForm;
import com.hugo.pojo.RegisterPojo;

public class Forget extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Session session = null;
		String password = "";
ForgotForm forgotform=(ForgotForm)form;
		//String myemail = request.getParameter("email");
		String myemail = forgotform.getEmail();
		System.out.println(myemail);
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("mailId", myemail)
				.list();
		// System.out.println("List contains.."+users);
		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				RegisterPojo registerPojo = (RegisterPojo) iterator.next();
				password = registerPojo.getPassword();
			}
			NewUserAction userAction = new NewUserAction();
			userAction.sendMail(myemail, password);
		}
		System.out.println("password is.." + password);
		transaction.commit();
		
		return mapping.findForward("success");
	}
}
