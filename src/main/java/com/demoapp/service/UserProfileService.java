package com.demoapp.service;

import java.util.List;

import com.demoapp.dao.UserDAO;
import com.demoapp.model.UserDetails;
import com.demoapp.validation.UserValidation;

public class UserProfileService {
	
public static List<UserDetails> viewUserProfile(String mailId, String password) throws Exception {
		
		UserValidation validate = new UserValidation();
		
		validate.registerValitation(mailId,password);
		
		List<UserDetails> list= UserDAO.getUserDetails(mailId,password);
		
		return list;
	}
}
