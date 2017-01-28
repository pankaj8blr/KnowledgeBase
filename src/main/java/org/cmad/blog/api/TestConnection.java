package org.cmad.blog.api;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.biz.UserService;

public class TestConnection {

	public TestConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
//		PersonalInfo info = new PersonalInfo("Pankaj", "9886427658", new Date());
		Topic topic = new Topic("Technology");
		
		
//		BlogUser user = new BlogUser("pkablr2020@gmail.com","123456",new PersonalInfo(),topic);
//		AppUser appUser = new AppUser("pkablr2020@gmail.com","123456",info,topic);
		
//		Comment comment = new Comment("Nice", new Date(), appUser);
//		Post post = new Post("JPA", "Technology", new Date(), topic, comment);
		
		
		
		

	/*	UserBlog blog = new UserBlog();
		try {
			blog.addAppUser(appUser);
		} catch (BlogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		/*em.persist(topic);
//		em.persist(comment);
//		em.persist(post);
		em.persist(appUser);
//		em.persist(blog);
		em.persist(user);
		em.persist(post);
		em.persist(topic);
		em.persist(comment);
		em.getTransaction().commit();
		em.close();*/
	}

}
