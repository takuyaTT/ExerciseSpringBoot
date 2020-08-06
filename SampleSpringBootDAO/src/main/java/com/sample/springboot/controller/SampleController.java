package com.sample.springboot.controller;

import com.sample.springboot.CustomerData;
import com.sample.springboot.dao.CustomerDaoImpl;
import com.sample.springboot.reposiotories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class SampleController {

    @Autowired
    CustomerRepository repository;

    //自動的に作成されたEntityManagerのBeanを取得しこのフィールドへ設定
    @PersistenceContext
    EntityManager entityManager;

    CustomerDaoImpl dao;

    //サンプルデータを初起動時に用意
    @PostConstruct
    public void init(){
        //DAO生成
        dao = new CustomerDaoImpl(entityManager);
        //顧客NO1を生成
        CustomerData cus1 = new CustomerData();
        cus1.setName("Yamada");
        cus1.setAge(45);
        cus1.setGender("Men");
        cus1.setEmail("yamada@sample.com");
        cus1.setComment("Sample comment");
        repository.saveAndFlush(cus1);
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("msg", "Sample Message");
        //CustomerDaoImplのgetAllCustomer()で全件取得
        Iterable<CustomerData> customerLists = dao.getAllCustomer();
        mav.addObject("customers", customerLists);
        return mav;
    }
}