package com.hugo.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.SendSmsForm;
import com.hugo.pojo.MmsTemplatePojo;
import com.hugo.pojo.RegisterPojo;
import com.hugo.action.NewUserAction;

public class SendSmsAction extends DispatchAction {
	int LoginId;
	Session session;
	int loginid;

	public ActionForward sendsms(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession httpSession = request.getSession();
		String loginId = httpSession.getAttribute("idno").toString();
		loginid = Integer.parseInt(loginId);
		String userenterid = request.getSession().getAttribute("emailid")
				.toString();
		/*
		 * String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		 * session=HibernateConfiguration.getsession(); List users =
		 * session.createQuery(query).setString("mailId",userenterid) .list();
		 * for (@SuppressWarnings("rawtypes") Iterator iterator2 =
		 * users.iterator(); iterator2.hasNext();) { RegisterPojo regpojo=
		 * (RegisterPojo) iterator2.next(); LoginId=regpojo.getLoginId(); }
		 */
		// String userlid =
		// request.getSession().getAttribute("LoginID").toString();
		// userloginid=Integer.parseInt(userlid);
		SendSmsForm sendsmsform = (SendSmsForm) form;
		String message = sendsmsform.getBody();
		String template = sendsmsform.getTemplatename();
		NewUserAction userAction = new NewUserAction();
		// userAction.sendMail(userenterid,message);
		MmsTemplatePojo mmstemplate = new MmsTemplatePojo();
		Session session = HibernateConfiguration.getsession();
		Transaction transaction = session.beginTransaction();
		mmstemplate.setBodytext(message);
		mmstemplate.setMmstype("SMS");
		mmstemplate.setLoginid(loginid);
		mmstemplate.setDescription(template);
		session.save(mmstemplate);
		transaction.commit();
		session.close();

		System.out.println("hello");
		return mapping.findForward("success");
	}

}
