package com.sample.boot.controller;

import com.sample.boot.CustomerData;
import com.sample.boot.dao.CustomerDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import com.sample.boot.repositories.CustomerRepository;

import java.util.List;

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
		// 追加
		CustomerData cus2 = new CustomerData();
		cus2.setName("高橋");
		cus2.setAge(27);
		cus2.setGender("男性");
		cus2.setMail("takahashi@sample.com");
		cus2.setMemo("takahashi memo");
		repository.saveAndFlush(cus2);
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

	@GetMapping("/find")
	public ModelAndView find(ModelAndView mav){
		mav.setViewName("find");
		mav.addObject("title","Find Sample Page");
		mav.addObject("msg", "Findのサンプルです");
		mav.addObject("value","");
		Iterable<CustomerData> list = dao.getAll();
		mav.addObject("datalist",list);
		return mav;
	}

	@PostMapping("/find")
	public ModelAndView findResult(HttpServletRequest request, ModelAndView mav){
		mav.setViewName("find");
		String param = request.getParameter("findstr");
		if(param == ""){
			mav = new ModelAndView("redirect:/find");
		}else{
			mav.addObject("title","Find Result");
			mav.addObject("msg",param + " の検索結果");
			mav.addObject("value",param);
			List<CustomerData> list = dao.find(param);
			mav.addObject("datalist",list);
		}
		return mav;
	}
}
