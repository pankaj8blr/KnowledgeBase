package org.cmad.blog.data;

import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static SessionFactory sesFac = null;
	private static ThreadLocal<Session> tlSessions = new ThreadLocal<Session>();
	static{
 		sesFac = (SessionFactory) Persistence.createEntityManagerFactory("blog");
	}
	
	

	public static Session currentSession() {
		Session ses = tlSessions.get();
		if(ses == null){
			ses = sesFac.openSession();
			tlSessions.set(ses);
		}
		return ses;
	}

	public static void closeSession() {
		Session ses = tlSessions.get();
		if(ses!=null){
			ses.close();
			tlSessions.set(null);
		}
		
	}
}
