package com.hugo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("serial")
public class CheckUser extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session session = null;

		PrintWriter out = response.getWriter();

		String myemail = request.getParameter("email");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM RegisterPojo as r where r.emailId=:mailId";

		@SuppressWarnings("rawtypes")
		List res = session.createQuery(query).setString("mailId", myemail)
				.list();

		System.out.println("Res contains.." + res);
		transaction.commit();
		if (res.isEmpty()) {
			out.println("<font color=green>");
			out.println("<center>Available</center>");
			out.println("</font>");
		} else {
			out.println("<font color=red>");
			out.println("<center>Not Available</center>");
			out.println("</font>");
		}
	}

}
