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
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.SendEmailForm;
import com.hugo.pojo.MmsTemplatePojo;
import com.hugo.pojo.RegisterPojo;

public class SendEmailAction extends Action {
	Session session;
	int loginid;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession httpSession = request.getSession();
		String loginId = httpSession.getAttribute("idno").toString();
		loginid = Integer.parseInt(loginId);
		String userenterid = request.getSession().getAttribute("emailid")
				.toString();
		SendEmailForm emailform = (SendEmailForm) form;
		String header = emailform.getHeader();
		String description = emailform.getDescription();
		String body = emailform.getBody();
		String footer = emailform.getFooter();
		/*
		 * String query = "FROM RegisterPojo as r where r.emailId=:mailId";
		 * session=HibernateConfiguration.getsession(); List users =
		 * session.createQuery(query).setString("mailId",userenterid) .list();
		 * for (@SuppressWarnings("rawtypes") Iterator iterator2 =
		 * users.iterator(); iterator2.hasNext();) { RegisterPojo regpojo=
		 * (RegisterPojo) iterator2.next(); LoginId=regpojo.getLoginId(); }
		 */
		session = HibernateConfiguration.getsession();
		MmsTemplatePojo mmstemplatepojo = new MmsTemplatePojo();
		Transaction transaction = session.beginTransaction();
		mmstemplatepojo.setLoginid(loginid);
		mmstemplatepojo.setDescription(description);
		mmstemplatepojo.setFooter(footer);
		mmstemplatepojo.setHeader(header);
		mmstemplatepojo.setMmstype("Email");
		mmstemplatepojo.setBodytext(body);
		session.save(mmstemplatepojo);
		transaction.commit();
		session.close();
		return mapping.findForward("success");
	}

}
