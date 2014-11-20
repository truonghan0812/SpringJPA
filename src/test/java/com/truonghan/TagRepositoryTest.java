package com.truonghan;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truonghan.entities.Post;
import com.truonghan.entities.Tag;
import com.truonghan.repositories.TagRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
@Transactional
public class TagRepositoryTest {

	@Autowired
	TagRepository repository;
	
	@Test
	public void test() {
		
		Post post =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		Post post1 =new Post();
		post.setTitle("Title");
		post.setPostDate(new java.util.Date());
		
		Tag tag = new Tag();
		
		String tagName = "Tag name";
		tag.setName(tagName);
		tag.getPosts().add(post);
		tag.getPosts().add(post1);
		
		repository.save(tag);
		
		Tag dbtag = repository.findOne(tag.getTagId());
		
		assertNotNull(dbtag);
		assertEquals(tagName, dbtag.getName());
		
		List<Post> posts = dbtag.getPosts();
		assertTrue(posts.size()>1);
		assertTrue(posts.contains(post));
		assertTrue(posts.contains(post1));
		
	}

}
