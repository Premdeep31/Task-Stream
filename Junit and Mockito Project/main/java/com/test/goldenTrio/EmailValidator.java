package com.test.goldenTrio;

import com.infy.exception.InfyAcademyException;

public class EmailValidator {
	public boolean validateEmailId(String emailId) throws InfyAcademyException {
			
			if(emailId == null || emailId.isBlank())
				throw new InfyAcademyException("Invalid Email ID");
		
			//   "\\w+@\\w\\.(com|in)"
			return emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+(com|in)$");
		}
}
