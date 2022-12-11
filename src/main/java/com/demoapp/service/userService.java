package com.demoapp.service;

import com.demoapp.dao.UserDAO;
import com.demoapp.validation.UserValidation;

public class userService {

	public int registerService(String mailId, String password) throws Exception {
		// TODO Auto-generated method stub
		
		UserValidation validate = new UserValidation();
		
		validate.registerValitation(mailId,password);
		
		int verify = UserDAO.checkValidation(mailId,password);
		return verify;
	}

	public int loginService(String mailId, String password) throws Exception {
		
		UserValidation validate = new UserValidation();
		
		validate.registerValitation(mailId,password);
		
		int verify = UserDAO.checkValidation(mailId,password);
		
		return verify;
	}
	
}
