package com.hugo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.ComposeBulkSmsForm;
import com.hugo.pojo.GroupPojo;
import com.hugo.pojo.MmsTemplatePojo;

public class ComposeBulkSmsAction extends DispatchAction{
	List<String> list;
	int loginid;
	Session session;
	ArrayList<String> arraylist;
	String mmstype;
	String message;
	int groupid;
	int templateid;
	 HttpSession httpSession;
	 public ActionForward groupnamesdisplay(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 httpSession = request.getSession();
			String loginId = httpSession.getAttribute("idno").toString();
			loginid = Integer.parseInt(loginId);
			session=HibernateConfiguration.getsession();
			
			//Session session=HibernateConfiguration.getsession();
			String hql = "from GroupPojo group where group.loginid=:loginid";
			//@SuppressWarnings("rawtypes")
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("loginid", loginid);
			//size = query3.list();
			arraylist=new ArrayList<String>();
			List<GroupPojo> list =query.list() ;
			System.out.println(list.size());
			for (GroupPojo grouppojo : list) {
				System.out.println(grouppojo.getGroupname());
				System.out.println(grouppojo.getGroupid());
				 groupid=grouppojo.getGroupid();
				arraylist.add(grouppojo.getGroupname());
				
				
			}
			httpSession.setAttribute("groupID",groupid);
			httpSession.setAttribute("templateid",templateid);
			
		request.setAttribute("groupnames",arraylist);
	       
	        //request.setAttribute("groupnames",list);

	        return mapping.findForward("success");
	    }
	 public ActionForward displaytemplates(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 ComposeBulkSmsForm composebulksms=(ComposeBulkSmsForm)form;
		  mmstype=composebulksms.getMessagetype();
		 httpSession = request.getSession();
		 //String a=httpSession.getAttribute("duptypes").toString();
		 httpSession.setAttribute("Mmstype",mmstype);
			String loginId = httpSession.getAttribute("idno").toString();
			loginid = Integer.parseInt(loginId);
			session=HibernateConfiguration.getsession();
			String asdd=request.getParameter("messagetype");
			System.out.println(asdd);
			
			//Session session=HibernateConfiguration.getsession();
			String hql = "from MmsTemplatePojo as template where template.loginid=:loginid and template.mmstype=:templatename";
			//@SuppressWarnings("rawtypes")
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("loginid", loginid);
			query.setParameter("templatename",mmstype);
			//size = query3.list();
			arraylist=new ArrayList<String>();
			List<MmsTemplatePojo> list =query.list() ;
			System.out.println(list.size());
			for (MmsTemplatePojo mmstemplatepojo : list) {
				System.out.println(mmstemplatepojo.getDescription());
				//System.out.println(mmstemplatepojo.getTemplateid());
				 //templateid= mmstemplatepojo.getTemplateid();
				arraylist.add(mmstemplatepojo.getDescription());
				
				
			}
			if(mmstype!=null)
			{
				
			}
			
			request.setAttribute("messagetype",mmstype);
		request.setAttribute("templatenames",arraylist);
		
	       
		 return mapping.findForward("messagetype");
		 
	 }
	 public ActionForward displaymessage(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		
		 String templatename=request.getParameter("key");
		 
		 
		 request.setAttribute("message",message);
		 return mapping.findForward("previewmessage");
	 }
}
