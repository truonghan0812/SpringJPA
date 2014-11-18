package com.truonghan;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truonghan.entities.Post;
import com.truonghan.entities.PostPart;
import com.truonghan.repositories.PostPartRepository;
import com.truonghan.repositories.PostRepository;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
	//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
	@Transactional
public class PostPartRepositoryTest {

	@Autowired
	PostPartRepository repository;
	
	@Test
	public void test() {
		PostPart postpart = new PostPart();
		String body = "body";
		postpart.setBody(body);
		
		repository.save(postpart);
		
		PostPart dbpostpart = repository.findOne(postpart.getPostPartId());
		assertNotNull(dbpostpart);
		assertNotEquals(body, dbpostpart.getBody());
	}
	
	@Test
	public void InserTest(){
		
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		PostPart postPart = new PostPart();
		String body = "body";
		postPart.setBody(body);
		
		postPart.setPost(post);
		
		repository.save(postPart);
		
		PostPart dbpostppart = repository.findOne(postPart.getPostPartId());
		
		assertNotNull(dbpostppart);
		assertNotNull(dbpostppart.getPost());
		assertNotEquals(body, dbpostppart.getBody());
		

}
	}
