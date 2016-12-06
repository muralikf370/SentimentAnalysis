package com.bcbs.sentimentanalysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bcbs.sentimentanalysis.model.Login;
import com.bcbs.sentimentanalysis.model.User;
import com.bcbs.sentimentanalysis.service.LoginService;
import com.bcbs.sentimentanalysis.utility.SentimentAnalysisUtilty;



@RestController
public class LoginController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired LoginService loginService;
	@RequestMapping(value = "/loginservice", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> loginvalidation(@RequestBody  User userDetails,    UriComponentsBuilder ucBuilder) {
	User userdetailsResponce ;
	
		logger.info("User Email ::"+userDetails.getEmail());
	
		userdetailsResponce = loginService.findByEmail(userDetails.getEmail());
		if(!SentimentAnalysisUtilty.isEmpty(userdetailsResponce)){
			if(userdetailsResponce.getEmail().equalsIgnoreCase(userDetails.getEmail()) && (userdetailsResponce.getPassword().equalsIgnoreCase(userDetails.getPassword()))){
				userdetailsResponce.setErrorcode(01);
				userdetailsResponce.setErrorMessage("Login validation Success");
			}else{
				userdetailsResponce.setErrorcode(02);
				userdetailsResponce.setErrorMessage("Invalid Password");
			}
				
		}else{
			userdetailsResponce = new User();
			userdetailsResponce.setErrorcode(02);
			userdetailsResponce.setErrorMessage("Invalid User Name");
		}
		return new ResponseEntity<User>(userdetailsResponce,HttpStatus.OK);

	}
	
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveRegisteredUser(@RequestBody  User userDetails,    UriComponentsBuilder ucBuilder) {
	User userdetailsResponce = new User();
	
		logger.info("User Email ::"+userDetails.getEmail());
	
	loginService.saveRegisteredUser(userDetails);
	/*	if(!SentimentAnalysisUtilty.isEmpty(userdetailsResponce)){
			if(userdetailsResponce.getEmail().equalsIgnoreCase(userDetails.getEmail()) && (userdetailsResponce.getPassword().equalsIgnoreCase(userDetails.getPassword()))){
				userdetailsResponce.setErrorcode(01);
				userdetailsResponce.setErrorMessage("Login validation Success");
			}else{
				userdetailsResponce.setErrorcode(02);
				userdetailsResponce.setErrorMessage("Invalid Password");
			}
				
		}else{
			userdetailsResponce = new User();
			userdetailsResponce.setErrorcode(02);
			userdetailsResponce.setErrorMessage("Invalid User Name");
		}*/
		return new ResponseEntity<User>(userdetailsResponce,HttpStatus.OK);

	}
}
