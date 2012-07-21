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

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.LoginForm;
import com.hugo.pojo.GroupContactsPojo;
import com.hugo.pojo.RegisterPojo;

public class LoginAction extends Action {

	private String STATUS = "";
	Session session = null;
	String uname;
	int LoginId;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession httpSession = request.getSession(true);
		// HttpSession httpSession=request.getSession();

		// request.setAttribute("titleAttribute","Avinash");
		LoginForm lf = (LoginForm) form;
		String loginId = lf.getUsername();
		httpSession.setAttribute("emailid", loginId);
		String pwd = lf.getPassword();
		// System.out.println(loginId+"\t"+pwd);
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		// session=HibernateConfiguration.getsession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("mailId", loginId)
				.list();
		// System.out.println("List contains.."+users);
		for (@SuppressWarnings("rawtypes")
		Iterator iterator2 = users.iterator(); iterator2.hasNext();) {
			RegisterPojo regpojo = (RegisterPojo) iterator2.next();
			uname = regpojo.getName();
			LoginId = regpojo.getLoginId();
			httpSession.setAttribute("idno", LoginId);
		}
		request.setAttribute("titleAttribute", uname);
		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				RegisterPojo registerPojo = (RegisterPojo) iterator.next();
				String password = registerPojo.getPassword();
				// System.out.println("Password is.."+password);
				if (pwd.equals(password)) {
					STATUS = "success";
					httpSession.setAttribute("loginId", loginId);
					httpSession.setAttribute("id", registerPojo.getLoginId());
				} else {
					STATUS = "failure";
				}
			}
		} else {

			STATUS = "failure";
		}
		transaction.commit();
		System.out.println(STATUS);
		return mapping.findForward(STATUS);
	}
}
