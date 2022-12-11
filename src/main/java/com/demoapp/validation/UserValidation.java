package com.demoapp.validation;

public class UserValidation {

	public void registerValitation(String userMailId, String userPass) throws Exception {

//			if (!userMailId.isBlank() && !userMailId.isEmpty() && !userPass.isBlank() && !userPass.isEmpty()) {
//				if (userMailId.contains("@gmail.com") && userPass.length() >= 8 && userPass.length() <= 16) {
//					verify = UserDAO.checkValidation(userMailId, userPass);
//				} 
//			} 
		if (userMailId == null || userMailId.trim() == "") {
			throw new Exception("Please enter valid email");
		}
		if (userPass == null || userPass.trim() == "") {
			throw new Exception("Please enter valid password");
		}
	}
}