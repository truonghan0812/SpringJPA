package com.truonghan;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.entities.Comment;
import com.truonghan.entities.Post;
import com.truonghan.entities.PostPart;
import com.truonghan.entities.Stamp;
import com.truonghan.entities.Tag;
import com.truonghan.entities.Teaser;
import com.truonghan.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class JPQLTest1 {

	@Autowired
	PostRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	/*@Test
	public void basicTest(){
		
		List<Post> posts = em.createNamedQuery("Post.findPosts",Post.class).getResultList();
		
		for(Post post:posts){
			System.out.println(post.getTitle());
		}
		
	}*/
/*	@Test
	public void joinTest(){
		
		List<Object[]> tearsers = em.createNamedQuery("Post.teaser").getResultList();
		
		for(Object[] teaser:tearsers){
			System.out.println("Title: "+ teaser[0]);
			System.out.println("Author: "+ teaser[1]);
			System.out.println("Body: "+ teaser[2]);
		}*/
		@Test
		public void joinClassTest(){
			System.out.println("Enter author name: ");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			
			List<Teaser> tearsers = em.createNamedQuery("Post.teaser",Teaser.class)
											.setParameter("name","%" + name + "%").getResultList();
			
			for(Teaser teaser:tearsers){
				System.out.println("Title: "+ teaser.getTitle());
				System.out.println("Author: "+ teaser.getAthor());
				System.out.println("Body: "+ teaser.getTeaserText());
			}
		
	}
	
	
	
	
	

}
