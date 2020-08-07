package com.sample.boot;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

import com.sample.boot.repositories.CostomerRepository;

@Controller
public class SampleController {
	
	@PostConstruct
	public void init() {
		CostomerData cus1 = new CostomerData();
		cus1.setName("山田");
		cus1.setAge(45);
		cus1.setGender("男性");
		repository.saveAndFlush(cus1);
	}
	
	@Autowired
	CostomerRepository repository;
	
	@RequestMapping(value = "/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","SAMPLE SPRING BOOT JPA");
		Iterable<CostomerData> list = repository.findAll();
		mav.addObject("costomer",list);
		return mav;
	}
}
