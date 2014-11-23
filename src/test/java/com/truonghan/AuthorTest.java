package com.truonghan;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.truonghan.entities.Author;
import com.truonghan.repositories.AuthorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional
public class AuthorTest {

	@Autowired
	AuthorRepository repository;
	@Test
	public void insertTest() {
		Author author = new Author();
		author.setFirstName("Han");
		author.setLasName("Huynh");
		
		Author author1 = new Author();
		author1.setFirstName("Obama1");
		author1.setLasName("Barrack1");
		
		Author sponsor = new Author();
		sponsor.setFirstName("Obama");
		sponsor.setLasName("Barrack");
		
		author.setSponsor(sponsor);
		author1.setSponsor(sponsor);
		sponsor.getSponsoredAuthors().add(author);
		sponsor.getSponsoredAuthors().add(author1);
		
		repository.save(author);
		repository.save(author1);
		
		Author dbauthor = repository.findOne(author.getAuthorId());
		
		assertNotNull(dbauthor);
		assertNotNull(dbauthor.getSponsor());
		
		Author dbSponsor = repository.findOne(sponsor.getAuthorId());
		assertTrue(dbSponsor.getSponsoredAuthors().size()>1);
		
		
	}

}
