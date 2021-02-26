package com.companyname.springapp.web.controllers;

import java.lang.ModuleLayer.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.companyname.springapp.business.SpringappBusinessConfig;
import com.companyname.springapp.web.SpringappWebConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class, SpringappWebConfig.class})
@WebAppConfiguration
public class HelloControllerTests {

    @Autowired
    private Controller controller;

    @Test
    public void testHandleRequestView() {	
     //   ModelAndView modelAndView = controller.handleRequest();
     //   assertEquals("hello.jsp", modelAndView.getViewName());
    }
}