package com.hugo.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.ComposeBulkSmsForm;
import com.hugo.pojo.GroupPojo;
import com.hugo.pojo.MappingDto;
import com.hugo.pojo.MmsDataPojo;
import com.hugo.pojo.MmsTemplatePojo;
import com.hugo.pojo.UploadPojo;
public class JspAction extends DispatchAction{
	private int loginid;
	private Session session;
	private ArrayList<String> arraylist;
	private String templatename;
	private String message;
	private String s;
	private String grouptypes;
	private int tempid;
	private String mmstype;
	HttpSession httpSession;
	private int groupId ;
	Session  session1;
	private String date1;
	private String header;
	private String footer;
	private String totalbody;
	//MappingDto mappingdto;
	 public ActionForward changepassword(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("changepassword");
	    }
	 public ActionForward groupcontacts(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("empty");
	    }
	 public ActionForward groupcontactsupload(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("groupupload");
	    }
	 public ActionForward groupcontactsview(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("groupupload");
	    }
	 public ActionForward managecontacts(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("empty1");
	    }
	 public ActionForward managecontactsupload(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("managecontacts");
	    }
	 public ActionForward sendsmsview(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("sendsmsview");
	    }
	 public ActionForward sendemail(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("sendemailview");
	    }
	 public ActionForward voiceupload(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
	        return mapping.findForward("voiceupload");
	    }
	 public ActionForward composebulksms(ActionMapping mapping, ActionForm  form,HttpServletRequest request, HttpServletResponse response)
     throws Exception {
		/* HttpSession httpSession = request.getSession();
			String loginId = httpSession.getAttribute("idno").toString();
			loginid = Integer.parseInt(loginId);
			session=HibernateConfiguration.getsession();
			
			Session session=HibernateConfiguration.getsession();
			String hql = "from MmsTemplatePojo as template where template.loginid=:loginid";
			//@SuppressWarnings("rawtypes")
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("loginid", loginid);
			//size = query3.list();
			arraylist=new ArrayList<String>();
			List<MmsTemplatePojo> list =query.list() ;
			System.out.println(list.size());
			for (MmsTemplatePojo mmstemplatepojo : list) {
				System.out.println(mmstemplatepojo.getMmstype());
				
				arraylist.add(mmstemplatepojo.getMmstype());
				
				
		}*/
			
			
		//request.setAttribute("types",arraylist);
		 
 return mapping.findForward("composebulksms");
}
	 public ActionForward composemessagetype(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		  HttpSession httpSession = request.getSession();
			String loginId = httpSession.getAttribute("idno").toString();
			loginid = Integer.parseInt(loginId);
			session=HibernateConfiguration.getsession();
			String grouptype=request.getParameter("key");
			  grouptypes= grouptype.replace("\'", "");
			System.out.println(grouptype);
			
			Session session=HibernateConfiguration.getsession();
			//String hql1 = " from MmsTemplatePojo as template where template.loginid=:loginid";
			String hql="Select distinct mmstype from MmsTemplatePojo  where loginid=:loginid";
			//@SuppressWarnings("rawtypes")
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			Query query1 = session.createQuery(hql);
			query1.setParameter("loginid", loginid);
			//size = query3.list();
			arraylist=new ArrayList<String>();
			List<String> list = query1.list();
			
			System.out.println(list.size());
			
			for (String mmstemplate :list) 
			{
				
				System.out.println(mmstemplate);
				arraylist.add(mmstemplate);
				
		}
			/*Query query1 = session.createQuery(hql);
			query.setParameter("loginid", loginid);
			List<MmsTemplatePojo> list1 =query1.list() ;
			System.out.println(list1.size());
			for (MmsTemplatePojo mmstemplatepojo : list1) 
			{
				tempid=mmstemplatepojo.getTemplateid();
				
			}*/
			request.setAttribute("types",arraylist);
			Iterator itr = arraylist.iterator();
	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
			
			//request.setAttribute("duptypes",arraylist);
			
	        return mapping.findForward("messagetype");
	    }
	 public ActionForward preview(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 HttpSession httpSession = request.getSession();
			String loginId = httpSession.getAttribute("idno").toString();
			loginid = Integer.parseInt(loginId);
	        String templatename=request.getParameter("key");
	        String s= templatename.replace("\'", "");
	       System.out.println("s="+s);
              session=HibernateConfiguration.getsession();
			
			//Session session=HibernateConfiguration.getsession();
			String hql = "from MmsTemplatePojo as template where template.loginid=:loginid and template.description=:templatename";
			//@SuppressWarnings("rawtypes")
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("loginid", loginid);
			query.setParameter("templatename",s);
			//size = query3.list();
			List<MmsTemplatePojo> list =query.list() ;
			System.out.println(list.size());
			for (MmsTemplatePojo mmstemplatepojo1 : list) {
				System.out.println(mmstemplatepojo1.getTemplateid()+"templateidddddddddddddddd");
				tempid=mmstemplatepojo1.getTemplateid();
				System.out.println(mmstemplatepojo1.getDescription());
			 message=mmstemplatepojo1.getBodytext();
			 header=mmstemplatepojo1.getHeader();
			 footer= mmstemplatepojo1.getFooter();
			 String message="this is successfull page";
			}
			totalbody=message+footer;
		request.setAttribute("message",message);
		request.setAttribute("header",header);
		request.setAttribute("footer",footer);
	        return mapping.findForward("preview");
	    }
	/* public ActionForward displaytemplates(ActionMapping mapping, ActionForm  form,
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
		 
	 }*/
	 public ActionForward proceed(ActionMapping mapping, ActionForm  form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception 
	            {
		 
			 session = HibernateConfiguration.getsession();
			 Transaction transaction=session.beginTransaction();
			 HttpSession httpSession = request.getSession();
				//String groupId = httpSession.getAttribute("groupID").toString();
				String hql = "FROM GroupPojo as get WHERE get.groupname=:gname ";
				@SuppressWarnings("rawtypes")
				 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            	  Date date = new Date();
		            	  System.out.println(dateFormat.format(date));
		             date1=dateFormat.format(date);
		            	  System.out.println(date1+"todaydate");
				Query query3 = session.createQuery(hql);
				query3.setParameter("gname", grouptypes);
				List<GroupPojo> list = query3.list();
				for(GroupPojo grouppojo:list)
				{
					System.out.println(grouppojo.getGroupid()+"groupid value");
					groupId=grouppojo.getGroupid();
				}
				
				 mmstype = httpSession.getAttribute("Mmstype").toString();
				
				 if(groupId>0)
				 {
				Map<String, Object> map =new HashMap();
		            map.put("aloginid", loginid);
		            
		            map.put("agroupid",groupId);
		            map.put("atemplateid",tempid);
		            map.put("mmstype",mmstype);
		          
		          
		            final List<MappingDto> loanRepayments = executeNamedQueryWithResultTransformer("getthevalues",map,MappingDto.class);  
		            for (MappingDto mappingdto : loanRepayments) 
		            {
		            	  //session1=HibernateConfiguration.getsession();
		            	  Transaction transaction1=session.beginTransaction(); 
		            	MmsDataPojo mmsdatapojo=new MmsDataPojo();
		            	        mmsdatapojo.setMmsloginid(mappingdto.getMms_loginid());
		            	        mmsdatapojo.setMmsmessage(mappingdto.getMms_body());
		            	        System.out.println(mappingdto.getMms_body()+"body");
		            	        mmsdatapojo.setMmssender("avinashcheboina517@gmail.com");
		            	        mmsdatapojo.setMmssendresponse(null);
		            	        mmsdatapojo.setMmsstatus(1);
		            	        mmsdatapojo.setMmsattachment(mappingdto.getMms_file());
		            	        mmsdatapojo.setMmssubject(null);
		            	        mmsdatapojo.setMmstemplateid(tempid);
		            	        mmsdatapojo.setMmstype(mmstype);
		            	        mmsdatapojo.setMms_recipient(mappingdto.getMms_recipientname());
		            	        mmsdatapojo.setSenddate(date1);
		            	        mmsdatapojo.setMmssendresponse("success");
		            	      System.out.println( session.save(mmsdatapojo));
		            	      transaction1.commit();
		            }
				 }
		            else
		            {
		            	String hql3 = "FROM UploadPojo as get WHERE get.loginId=:loginid ";
						@SuppressWarnings("rawtypes")
						Query query4 = session.createQuery(hql3);
						query4.setParameter("loginid", loginid);
						List<UploadPojo> list2 = query4.list();
						Map<String, Object> map1 =new HashMap();
			            map1.put("cloginid", loginid);
			            map1.put("ctemplateid",tempid);
			            map1.put("cmmstype",mmstype);
						/*for(UploadPojo uploadpojo:list2)
						{*/
							
				          
				            
				            final List<MappingDto> loanRepayments1 = executeNamedQueryWithResult("getthecontacts",map1,MappingDto.class);  
				            for (MappingDto mappingdto1 : loanRepayments1)
				            {
				            	//session1=HibernateConfiguration.getsession();
				            	  Transaction transaction2=session.beginTransaction(); 
				            	 /* DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				            	  Date date = new Date();
				            	  System.out.println(dateFormat.format(date));
				             date1=dateFormat.format(date);
				            	  System.out.println(date1+"todaydate");*/
				            	  
				            	MmsDataPojo mmsdatapojo=new MmsDataPojo();
				            	        mmsdatapojo.setMmsloginid(mappingdto1.getMms_loginid());
				            	        mmsdatapojo.setMmsmessage(mappingdto1.getMms_body());
				            	        System.out.println(mappingdto1.getMms_body()+"body");
				            	        mmsdatapojo.setMmssender("avinashcheboina517@gmail.com");
				            	        mmsdatapojo.setMmssendresponse(null);
				            	        mmsdatapojo.setMmsstatus(1);
				            	        mmsdatapojo.setMmsattachment(mappingdto1.getMms_file());
				            	        mmsdatapojo.setMmssubject(null);
				            	        mmsdatapojo.setMmstemplateid(tempid);
				            	        mmsdatapojo.setMmstype(mmstype);
				            	        mmsdatapojo.setMms_recipient(mappingdto1.getMms_recipientname());
				            	        mmsdatapojo.setSenddate(date1);
				            	        mmsdatapojo.setMmssendresponse("success");
				            	      System.out.println( session.save(mmsdatapojo));
				            	      transaction2.commit();
							
				            }
					
				            session.close();
                               
		            }
		            
		 return mapping.findForward("lastsuccess");
		 
	 }
	 
	 private List<MappingDto> executeNamedQueryWithResultTransformer(
				String string, Map<String, Object> map, Class<MappingDto> clazz) 
				{
			        Query query = session.getNamedQuery("getthevalues");
			        query.setResultTransformer(Transformers.aliasToBean(clazz));
			        query.setProperties(map);
			        return query.list();
		}
	 private List<MappingDto> executeNamedQueryWithResult(String string, Map<String, Object> map, Class<MappingDto> clazz) 
				{
			        Query query = session.getNamedQuery("getthecontacts");
			        query.setResultTransformer(Transformers.aliasToBean(clazz));
			        query.setProperties(map);
			        return query.list();
		}
	
	 }
