package com.truonghan;

import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.entities.Comment;
import com.truonghan.entities.Post;
import com.truonghan.entities.Stamp;
import com.truonghan.repositories.CommentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class CommentRepositoryTest {

	@Autowired
	CommentRepository repository;

	@Test
	public void test() {
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		Comment comment = new Comment();
		final String author = " Truong Han";
		final String body = "This is body";
		//comment.setAuthor(author);
		
		String email="victim77777";
		Date create_date = new Date();
		Stamp stamp = new Stamp();
		stamp.setAuthor(author);
		stamp.setCreateDate(create_date);
		stamp.setEmail(email);
		
		comment.setBody(body);
		comment.setPost(post);
		comment.setStamp(stamp);
		
		repository.save(comment);
	
		Comment dbcomment = repository.findOne(comment.getCommendId());
		
		assertNotNull(dbcomment);
		assertNotNull(dbcomment.getPost());
		assertEquals(body, dbcomment.getBody());
		assertEquals(author, dbcomment.getStamp().getAuthor());
	}

}
