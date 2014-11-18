package com.truonghan;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truonghan.entities.Comment;
import com.truonghan.entities.Post;
import com.truonghan.repositories.CommentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
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
		comment.setAuthor(author);
		comment.setBody(body);
		comment.setPost(post);
		repository.save(comment);
	
		Comment dbcomment = repository.findOne(comment.getCommendId());
		
		assertNotNull(dbcomment);
		assertNotNull(dbcomment.getPost());
		assertNotEquals(body, dbcomment.getBody());
		assertNotEquals(author, dbcomment.getAuthor());
	}

}
