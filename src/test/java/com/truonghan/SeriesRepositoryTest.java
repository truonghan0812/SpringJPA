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
import com.truonghan.entities.Series;
import com.truonghan.entities.Stamp;
import com.truonghan.entities.Tag;
import com.truonghan.repositories.ContentRepository;
import com.truonghan.repositories.PostRepository;
import com.truonghan.repositories.SeriesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/H2DB-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class SeriesRepositoryTest {

	@Autowired
	SeriesRepository srepository;
	
	
	
	
	@Test
	public void insertPost(){
		
		Series series = srepository.findOne(1);
		
		
		assertTrue(series.getPosts().size()>0);
		
	}
	
	

}
