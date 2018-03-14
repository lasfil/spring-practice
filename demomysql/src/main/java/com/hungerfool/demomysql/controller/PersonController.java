package com.hungerfool.demomysql.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungerfool.demomysql.Person;
import com.hungerfool.demomysql.PersonDao;
@RestController    // This means that this class is a Controller
@RequestMapping("/person") // This means URL's start with /demo (after Application path)
public class PersonController {
	@Autowired
	PersonDao personDao;
	
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/get")
	public Person getP(String name) {
		Person person = personDao.findByName(name).get(0);
		return person;
	}
	
	@RequestMapping("/save")
	public Person createPerson(String name) {
		Person person = new Person();
		person.setName("HungerFool" + counter.incrementAndGet());
		personDao.save(person);
		System.out.println(personDao.getClass());
		return person;
	}

	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot";
	}
}
