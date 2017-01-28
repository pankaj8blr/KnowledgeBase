package org.cmad.blog.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.cmad.blog.api.AppUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class AppUserDAO implements UserDAO {

//	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog");
	static SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("blog");
	/*@Override
	public int addAppUser(AppUser appUser) {
		System.out.println("UserBlogDAO.addAppUser()appUser: "+appUser);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(appUser);
		em.getTransaction().commit();
		em.close();
		return appUser.getAppUserId();
		
	}
	
	
	@Override
	public int authenticateAppUser(AppUser appUser) {
		int appUserId = -1;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		String userName = appUser.getEmail();
		String password = appUser.getPassword();
		System.out.println("UserBlogDAO.authenticateAppUser() userName: "+userName+",password: "+password);
		
		
		AppUser u=null;
		List<AppUser> list = em.createQuery("SELECT u FROM AppUser u").getResultList();
		if(list!=null){
			for(int index=0;index<list.size();index++){
				u = (AppUser)list.get(index);
				if(u!=null){

					if (u!=null && userName.equalsIgnoreCase(u.getEmail())&&password.equals(u.getPassword())) {
						appUserId=u.getAppUserId();
						break;
					}
					System.out.println("UserBlogDAO.authenticateAppUser()user["+index+"]:"+u);
					System.out.println("UserBlogDAO.authenticateAppUser()["+index+"]:"+",user.getEmail(): "+u.getEmail()+",user.getPassword(): "+u.getPassword());
					System.out.println("UserBlogDAO.authenticateAppUser()getAppUserId["+index+"]:"+ u.getAppUserId());
					System.out.println("UserBlogDAO.authenticateAppUser()+++++++++++++++++++++++++++++++++++++++++++++++++++++==");
				}
			}
		}
		
		
	  
		em.getTransaction().commit();
	    em.close();
	    
	    System.out.println("UserBlogDAO.authenticateAppUser()appUserId: "+appUserId);
		return appUserId;
	}
	
	
	*/
	
	@Override
	public int addAppUser(AppUser appUser) {
		System.out.println("UserBlogDAO.addAppUser()appUser: "+appUser);
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(appUser);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
		System.out.println("AppUserDAO.addAppUser() appUser.getAppUserId(): "+appUser.getAppUserId());
		return appUser.getAppUserId();
	}

	@Override
	public AppUser updateAppUser(AppUser appUser) {
		System.out.println("AppUserDAO.updateAppUser()appUser: "+appUser);
		AppUser newappUser = null;
		if(appUser!=null){
			System.out.println("AppUserDAO.updateAppUser()getAppUserId: "+appUser.getAppUserId());
			try {
				Session ses = HibernateUtil.currentSession();
				if(isUserExist(appUser,ses)){

					Transaction tx = ses.beginTransaction();
//					ses.update(appUser);
					ses.merge(appUser);
					tx.commit();

					if(appUser!=null){
						System.out.println("AppUserDAO.updateAppUser() UserId: "+appUser.getAppUserId());

						newappUser = getAppUser(appUser.getAppUserId());
						System.out.println("AppUserDAO.updateAppUser()newappUser: "+newappUser);

						if(newappUser!=null){
							System.out.println("AppUserDAO.updateAppUser() UserId: "+appUser.getAppUserId());
						}
					}
				}
			}finally{
				HibernateUtil.closeSession();
			}
		}
		System.out.println("AppUserDAO.updateAppUser()appUser: "+appUser);
		return appUser;

	}
	
	private boolean isUserExist(AppUser appUser,Session ses) {
		String emailId = appUser.getEmail();
//		String pwd = appUser.getPassword();
		System.out.println("UserBlogDAO.isUserExist() email: "+emailId);

		AppUser user = (AppUser) ses
				.createQuery("SELECT u from AppUser u where u.email = :emailId")
				.setParameter("emailId", emailId).getSingleResult();
		System.out.println("AppUserDAO.isUserExist() user: "+user);
		if(user!=null){
			return true;
		}
		return false;
	}

	@Override
	public int authenticateAppUser(AppUser appUser) {
		int appUserId = -1;
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			String emailId = appUser.getEmail();
			String pwd = appUser.getPassword();
			System.out.println("UserBlogDAO.authenticateAppUser() email: "+emailId+",pwd: "+pwd);

			AppUser user = (AppUser) ses
					.createQuery("SELECT u from AppUser u where u.email = :emailId and u.password = :pwd")
					.setParameter("emailId", emailId).setParameter("pwd", pwd).getSingleResult();

			if(user!=null){
				appUserId = user.getAppUserId();
			}

			
		}catch(NoResultException e){
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		System.out.println("AppUserDAO.authenticateAppUser()appUserId: "+appUserId);
		return appUserId;
	}

	
	@Override
	public AppUser getAppUser(String userName, String pwd) {
		EntityManager em = factory.createEntityManager();
		try {
			AppUser appUser = (AppUser) em
					.createQuery("SELECT u from User u where u.nameUser = :name and u.password = :password")
					.setParameter("name", userName).setParameter("password", pwd).getSingleResult();
			return appUser;
		} catch (NoResultException e) {
			return null;
		}
	}

	public AppUser getAppUser(Integer id) {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(AppUser.class);
			System.out.println("AppUserDAO.getAppUser()id: "+id);
			crit.add(Restrictions.idEq(id));
			AppUser u = (AppUser)crit.uniqueResult();
			return u;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<AppUser> getAppUsers() {
		Session ses = HibernateUtil.currentSession();
		try {
			List<AppUser> list = ses.createCriteria(AppUser.class).list();
			return list;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean insertAppUser(AppUser appUser) {
		EntityManager em = factory.createEntityManager();
		try {
			em.persist(appUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAppUser(AppUser appUser) {
		EntityManager em = factory.createEntityManager();
		try {
			em.remove(appUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
