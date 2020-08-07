package com.sample.boot.controller;

import com.sample.boot.CustomerData;
import com.sample.boot.dao.CustomerDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sample.boot.repositories.CustomerRepository;

@Controller
public class SampleController {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	CustomerRepository repository;

	CustomerDaoImpl dao;

	@PostConstruct
	public void init() {
		dao = new CustomerDaoImpl(entityManager);
		CustomerData cus1 = new CustomerData();
		cus1.setName("山田");
		cus1.setAge(45);
		cus1.setGender("男性");
		cus1.setMail("Yamada@sample.com");
		cus1.setMemo("sample memo");
		repository.saveAndFlush(cus1);
	}
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","SAMPLE SPRING BOOT JPA");
		//Iterable<CustomerData> list = repository.findAll();
		Iterable<CustomerData> list = dao.getAll();
		mav.addObject("costomer",list);
		return mav;
	}
}
