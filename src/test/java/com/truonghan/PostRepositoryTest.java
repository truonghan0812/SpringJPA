package com.truonghan;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truonghan.entities.Comment;
import com.truonghan.entities.Post;
import com.truonghan.entities.PostPart;
import com.truonghan.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@Transactional
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Test
	public void test() {
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println("Getting name.....");
		System.out.println(dbpost.getTitle());
	}
	
	@Test
	public void InserTest(){
		
		Comment comment = new Comment();
		final String author = " Truong Han";
		final String body1 = "This is body";
		comment.setAuthor(author);
		comment.setBody(body1);
		Comment comment2 = new Comment();
		final String author2 = " Truong Han";
		final String body2 = "This is body";
		comment.setAuthor(author2);
		comment.setBody(body2);
		
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		PostPart postPart = new PostPart();
		String body = "body";
		postPart.setBody(body);
		
		post.setPostPart(postPart);
		post.getComments().add(comment);
		post.getComments().add(comment2);
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		
		assertNotNull(dbpost);
		assertNotNull(dbpost.getPostPart());
		assertNotNull(dbpost.getComments());
		assertEquals(2, dbpost.getComments().size());
		assertTrue(dbpost.getComments().contains(comment));
		assertTrue(dbpost.getComments().contains(comment2));
		
		System.out.println(dbpost.getTitle());
		
	}

}
