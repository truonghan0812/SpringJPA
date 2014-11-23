package com.truonghan;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.entities.Post;
import com.truonghan.repositories.PostRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class SpringDataTest {

	@Autowired
	PostRepository repository;
	
	
	@Test
	public void findByTitleContaining(){
		
		//List<Post> posts = repository.findByTitleContaining("Java");
		
		//for(Post p:posts){
		//	System.out.println(p.getTitle());
	//	}
		
	
	
	}
	
	
	
	

}
