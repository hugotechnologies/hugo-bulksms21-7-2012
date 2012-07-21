package com.hugo.operations;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.pojo.GroupContactsPojo;
import com.hugo.pojo.GroupPojo;

public class ManageDelete extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userid = request.getSession().getAttribute("id").toString();
		Session session3 = HibernateConfiguration.getsession();
		Transaction transaction = session3.beginTransaction();
		Query query = session3.createQuery("FROM  GroupContactsPojo");
		List<GroupContactsPojo> groupContactsPojos=query.list();
		Iterator<GroupContactsPojo> iterator=groupContactsPojos.iterator();
		while (iterator.hasNext()) {
			GroupContactsPojo groupContactsPojo = (GroupContactsPojo) iterator
					.next();
			System.out.println(groupContactsPojo.getMloginid());
			session3.delete(groupContactsPojo);	
		}
		transaction.commit();
		Transaction tran = session3.beginTransaction();
		Query q = session3.createQuery("FROM  GroupPojo");
		List<GroupPojo> groupPojos=q.list();
		Iterator<GroupPojo> iterator1=groupPojos.iterator();
		while (iterator1.hasNext()) {
			GroupPojo group = (GroupPojo) iterator1
					.next();
			System.out.println(group.getLoginid());
			session3.delete(group);	
		}
		
		//System.out.println(que.);
		tran.commit();
		session3.close();
		return mapping.findForward("delete");

	}

}
