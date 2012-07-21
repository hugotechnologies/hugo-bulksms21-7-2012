package com.hugo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.form.NewUserForm;
import com.hugo.pojo.RegisterPojo;
import com.hugo.pojo.UploadPojo;

public class NewUserAction extends Action {
	private static String STATUS = "failure";
	HttpServletRequest request;
	HttpServletResponse response;

	// private final static String FAILURE = "failure";
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Session session = null;
		NewUserForm newUserForm = (NewUserForm) form;
		String user = newUserForm.getUname();
		String address = newUserForm.getAddress();
		String phone = newUserForm.getPhone();
		String myemail = newUserForm.getEmail();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List users = session.createQuery(query).setString("mailId", myemail)
				.list();
		// System.out.println("List contains.."+users);
		if (users.isEmpty()) {

			String password = RandomStringUtils.randomAlphanumeric(6);

			try {
				// SessionFactory sessionFactory = new
				// Configuration().configure()
				// .buildSessionFactory();
				// session = sessionFactory.openSession();
				// Transaction transaction = session.beginTransaction();
				RegisterPojo rp = new RegisterPojo();

				rp.setLoginId(1);
				rp.setName(user);
				rp.setPassword(password);
				rp.setAddress(address);
				rp.setPhone(phone);
				rp.setUser(myemail);
				rp.setEmailId(myemail);
				rp.setCdate("2012-12-12");
				rp.setStatus("A");
				session.save(rp);
				System.out.println("Done");
				transaction.commit();
				STATUS = "success";
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println(e.getMessage());
			} finally {
				// Actual contact insertion will happen at this step
				session.flush();
				session.close();
			}

			System.out.println(password);
			sendMail(myemail, password);

		} else {
			System.out.println("E-Mail already Existed");
		}
		System.out.println("status is:" + STATUS);

		if (STATUS.equals("failure")) {
			request.setAttribute("message", "YOUR ALREADY REGISTERED USER");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		}

		return mapping.findForward(STATUS);

	}

	public void sendMail(String myemail, String password) {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("avinashcheboina517",
				"9908819374"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		try {
			email.setFrom("avinashcheboina517@gmail.com");
			email.setSubject("Hi");
			email.setMsg("This is a test mail ... :-)" + "\n");
			email.setMsg("Your user name:" + myemail + "\n" + "Password:"
					+ password);
			email.addTo(myemail);
			email.setTLS(true);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Mail sent!");

	}
}
