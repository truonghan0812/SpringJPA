package com.truonghan;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.entities.Comment;
import com.truonghan.entities.ContentPost;
import com.truonghan.entities.Post;
import com.truonghan.entities.PostPart;
import com.truonghan.entities.Stamp;
import com.truonghan.entities.Tag;
import com.truonghan.repositories.ContentRepository;
import com.truonghan.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class AbstractPostRepositoryTest {

	@Autowired
	PostRepository prepository;
	
	@Autowired
	ContentRepository cRepository;
	
	@PersistenceContext
	EntityManager em;
	
	
	@Test
	public void insertPost(){
		
		Post post = new Post();
		String title = "title";
		post.setTitle(title);
		
		PostPart postPart = new PostPart();
		postPart.setBody("body");
		
		post.setPostPart(postPart);
		postPart.setPost(post);
		
		prepository.save(post);
		
		Post dbpost = prepository.findOne(post.getPostId());
		assertNotNull(dbpost);
		assertEquals(title, dbpost.getTitle());
		
	}
	@Test
	public void insertContentPost(){
		ContentPost post = new ContentPost();
		String contentUrl = "url";
		post.setContentUrl(contentUrl);
		
		cRepository.save(post);
		
		ContentPost dbpost = cRepository.findOne(post.getPostId());
		
		assertNotNull(dbpost);
		assertEquals(contentUrl, dbpost.getContentUrl());
	}
	
	

}
