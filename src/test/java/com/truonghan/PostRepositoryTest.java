package com.truonghan;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truonghan.entities.Post;
import com.truonghan.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
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

}
