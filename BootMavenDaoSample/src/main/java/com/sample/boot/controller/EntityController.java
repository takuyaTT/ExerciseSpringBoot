package com.sample.boot.controller;

import com.sample.boot.CustomerData;
import com.sample.boot.MsgData;
import com.sample.boot.dao.MsgDataDaoImpl;
import com.sample.boot.repositories.MsgDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EntityController {
    @Autowired
    MsgDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    MsgDataDaoImpl dao;

    @GetMapping("/msg")
    public ModelAndView msg(ModelAndView mav){
        mav.setViewName("showMsgData");
        mav.addObject("title","Sample");
        mav.addObject("msg","MsgDataのサンプルです");
        MsgData msgdata = new MsgData();
        mav.addObject("formModel",msgdata);
        List<MsgData> list = (List<MsgData>)dao.getAll();
        mav.addObject("datalist",list);
        return mav;
    }

    @PostMapping("/msg")
    public ModelAndView msgform(
            @Valid @ModelAttribute MsgData msgdata,
            Errors result,
            ModelAndView mav
    ){
        if(result.hasErrors()) {
            mav.setViewName("showMsgData");
            mav.addObject("title", "Sample [ERROR}");
            mav.addObject("msg", "値を確認して下さい");
            return mav;
        }else{
            repository.saveAndFlush(msgdata);
            return new ModelAndView("redirect:/msg");
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("OK");
        dao = new MsgDataDaoImpl(entityManager);

    }
}
