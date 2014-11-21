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
import com.truonghan.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class JPQLTest {

	@Autowired
	PostRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void orderTest(){
		
		TypedQuery<Post> query = em.createQuery("select p from Post p",Post.class);
		List<Post> posts = query.getResultList();
		
		for(Post post:posts){
			System.out.println(post.getTitle());
		}
		
	}
	@Test
	public void compositeTest(){
		
		TypedQuery<PostPart> query = em.createQuery("select p.postPart from Post p",PostPart.class);
		List<PostPart> posts = query.getResultList();
		
		for(PostPart post:posts){
			System.out.println(post.getBody());
		}
		
	}
	@Test
	public void filterTest(){
		System.out.println("Enter a name:");
		Scanner scaner = new Scanner(System.in);
		String name = scaner.nextLine();
		TypedQuery<Post> query = 
				em.createQuery("select p from Post p where p.stamp.author like '%"+name+"%'"
				
								,Post.class);
		List<Post> posts = query.getResultList();
		
		for(Post post:posts){
			System.out.println(post.getTitle());
		}
		
	}
	
	
	
	

}
