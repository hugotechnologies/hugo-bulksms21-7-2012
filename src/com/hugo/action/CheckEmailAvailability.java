package com.hugo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.pojo.RegisterPojo;

@SuppressWarnings("serial")
public class CheckEmailAvailability extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session session = null;
		String password = "";
		PrintWriter out = response.getWriter();

		String myemail = request.getParameter("email");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("mailId", myemail)
				.list();
		if (users.isEmpty() == false) {
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = users.iterator(); iterator.hasNext();) {
				RegisterPojo registerPojo = (RegisterPojo) iterator.next();
				password = registerPojo.getPassword();
			}
			NewUserAction userAction = new NewUserAction();
			userAction.sendMail(myemail, password);
			transaction.commit();
			out.println("<font color=green>");
			out.println("Successfully sent the mail");
			out.println("</font>");
		} else {
			out.println("<font color=red>");
			out.println("You have entered an invalid mail!");
			out.println("</font>");
		}

	}
}
