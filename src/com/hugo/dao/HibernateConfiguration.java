package com.hugo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	static Configuration configuration;
	static SessionFactory sessionFactory;
	
	static{
		configuration = new Configuration();
		 configuration.configure();
	}
public static Session getsession()
{
	Session session=null;
	if(sessionFactory==null)
	 sessionFactory = configuration.buildSessionFactory();
	if (session==null) {
		session=sessionFactory.openSession();	
	}
    return session;
}
public  List getEmailId(String loginId)
{
Session	session1=HibernateConfiguration.getsession();
Transaction transaction=session1.beginTransaction();
String cquery = "FROM RegisterPojo as r where r.emailId=:mailId";
@SuppressWarnings("rawtypes")
List getId = session1.createQuery(cquery)
		.setString("mailId", loginId).list();
  transaction.commit();
return getId;
} 
public List insertvalues(String groupname)
{
Session	session2=HibernateConfiguration.getsession();
Transaction transaction=session2.beginTransaction();
Query query = session2
.createQuery("FROM GroupPojo get WHERE get.groupname=:gname");
query.setParameter("gname", groupname);
  List list = query.list();
  transaction.commit();
return list;
}
}
