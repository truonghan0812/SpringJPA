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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
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
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class CriteriaApiTest {

	@Autowired
	PostRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	/*@Test
	public void selectPostTest(){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Post> query = cb.createQuery(Post.class);
		Root<Post> postRoot = query.from(Post.class);
		
		query.select(postRoot).where(cb.equal(postRoot.get("stamp").get("author"),"Kevin"));
		
		TypedQuery<Post> q = em.createQuery(query);
		
		List<Post> posts = q.getResultList();
		
		for(Post p:posts){
			System.out.println(p.getTitle());
			System.out.println(p.getStamp().getAuthor());
		}
	}*/
	/*@Test
	public void joinTest(){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Post> post = query.from(Post.class);
		Join<Post, PostPart> postPart =  post.join("postPart");
		
		
		//query.select(postRoot).where(cb.equal(postRoot.get("stamp").get("author"),"Kevin"));
		query.multiselect(post.get("stamp").get("author"),postPart.get("body"));
		
		TypedQuery<Object[]> q = em.createQuery(query);
		
		List<Object[]> results = q.getResultList();
		
		for(Object[] p:results){
			System.out.println(p[0]);
			System.out.println(p[1]);
		}
	}
	*/
	@Test
	public void aggregrateTest(){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Post> post = query.from(Post.class);
		
		query.multiselect(post.get("stamp").get("author"),cb.count(post)).groupBy(post.get("stamp").get("author"));
		
		TypedQuery<Object[]> q = em.createQuery(query);
		
		List<Object[]> results = q.getResultList();
		
		for(Object[] p:results){
			System.out.println(p[0]);
			System.out.println(p[1]);
		}
	}
}
