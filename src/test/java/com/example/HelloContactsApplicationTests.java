package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloContactsApplication.class)
@WebAppConfiguration
public class HelloContactsApplicationTests {

	@Autowired
	ContactsRepository repository;

	@Test
	public void contextLoads() {
		List<Contacts> contact = repository.findByNameNotContaining("a");
		assertEquals(4, contact.size());
	}

	@Test
	public void testQueryMethod() {


		List<Contacts> contact = repository.findByNameNotLike("one");
		assertEquals(4, contact.size());
	}

}
