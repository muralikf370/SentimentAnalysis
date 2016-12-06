package com.bcbs.sentimentanalysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 @RequestMapping(method = RequestMethod.GET)
	    public String index(){
	      logger.info("HomeController :: Index method");
	        return "static/index.html";
	        
	    }

}
