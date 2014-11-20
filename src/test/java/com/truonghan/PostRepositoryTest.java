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
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void orderTest(){
		
		List<Comment> comments = new ArrayList<Comment>();
		Post post = new Post();
		post.setTitle("Title");
		
		for(int i=0; i<30; i++){
			
			Comment comment = new Comment();
			
			Stamp stamp = new Stamp();
			stamp.setAuthor("Truong Han");
			stamp.setCreateDate(new Date(113,01,i));
			
			comment.setBody(i + "Test");
			comment.setStamp(stamp);
			comment.setPost(post);
			comments.add(comment);
		}
		
		post.setComments(comments);
		repository.save(post);
		
		em.refresh(post);// If not it will read from cache
		
		Post dbpost = repository.findOne(post.getPostId());
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		List<Comment> dbcomments = dbpost.getComments();
		
		for(Comment comm: dbcomments){
			System.out.println(comm.getBody());
			System.out.println(format.format(comm.getStamp().getCreateDate()));
		}
	}
	
	
	
	
	/*@Test
	public void test() {
		
		Tag tag = new Tag();
		String tagName = "Tag name";
		tag.setName(tagName);	
		Tag tag1 = new Tag();
		String tagName1 = "Tag name";
		tag.setName(tagName1);
		
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		post.getTags().add(tag);
		post.getTags().add(tag1);
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println("Getting name.....");
		System.out.println(dbpost.getTitle());
		
		List<Tag> tags = dbpost.getTags();
		
		assertTrue(tags.size()>1);
		assertTrue(tags.contains(tag));
		assertTrue(tags.contains(tag1));
	}
	
	@Test
	public void entityCollectionTest(){
		Post post = repository.findOne(24);
		int size = post.getUrls().size();
		
		assertTrue(size>0);
		
		post.getUrls().add("oneway.vn");
		
		repository.save(post);
		
		Post dbpost = repository.findOne(24);
		assertEquals(size + 1, dbpost.getUrls().size());
		
		}
	@Test
	public void InserTest(){
		
		Comment comment = new Comment();
		final String author = " Truong Han";
		final String body1 = "This is body";
		comment.setBody(body1);
		
		Comment comment2 = new Comment();
		final String author2 = " Truong Han";
		final String body2 = "This is body";
		comment2.setBody(body2);
		
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		PostPart postPart = new PostPart();
		String body = "body";
		postPart.setBody(body);
		
		String email="victim77777";
		Date create_date = new Date();
		Stamp stamp = new Stamp();
		stamp.setAuthor(author);
		stamp.setCreateDate(create_date);
		stamp.setEmail(email);
		
		post.setPostPart(postPart);
		post.getComments().add(comment);
		post.getComments().add(comment2);
		post.setStamp(stamp);
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		
		assertNotNull(dbpost);
		assertNotNull(dbpost.getPostPart());
		assertNotNull(dbpost.getComments());
		assertEquals(2, dbpost.getComments().size());
		assertTrue(dbpost.getComments().contains(comment));
		assertTrue(dbpost.getComments().contains(comment2));
		assertEquals(stamp.getAuthor(), dbpost.getStamp().getAuthor());
		
		
		System.out.println(dbpost.getTitle());
		
	}
	*/

}
