package com.hugo.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.form.ChangepwdForm;
import com.hugo.pojo.RegisterPojo;

public class ChangePassword extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession httpSession = request.getSession();
		String STATUS = "failure";
		String password = "";
		Session session = null;
		ChangepwdForm changepwdForm = (ChangepwdForm) form;

		String loginId = httpSession.getAttribute("loginId").toString();
		System.out.println("In session::: " + loginId);
		String oldpwd = changepwdForm.getOldpwd();
		String retype = changepwdForm.getRetype();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String cquery = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List getpassword = session.createQuery(cquery)
				.setString("mailId", loginId).list();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = getpassword.iterator(); iterator.hasNext();) {
			RegisterPojo registerPojo = (RegisterPojo) iterator.next();
			password = registerPojo.getPassword();
		}
		if (oldpwd.equals(password)) {
			String query = "update RegisterPojo as r set r.password =:newpwd where r.emailId = :mailId";

			int x = session.createQuery(query).setString("newpwd", retype)
					.setString("mailId", loginId).executeUpdate();

			transaction.commit();
			System.out.println("x is " + x);

			if (x == 1)
				STATUS = "success";
		} else {
			System.out.println("Old password is incorrect");
		}
		System.out.println(STATUS);
		return mapping.findForward(STATUS);
	}
}
