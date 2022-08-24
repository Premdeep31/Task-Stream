package com.test.goldenTrio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

public class EmailValidatorTest {
	EmailValidator emailValidator;

	@BeforeEach
	void initializeMock() {
		emailValidator = new EmailValidator();
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId("James_Potter@infy.com"));
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		assertFalse(emailValidator.validateEmailId("James_Potter@infy.org"));
	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		
		Exception exception = assertThrows(InfyAcademyException.class, () -> {
			emailValidator.validateEmailId("");
		});
		
		String expectedMessage = "Invalid Email ID";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));

	}

	@ParameterizedTest
	@ValueSource(strings = {"Sirius_Black", "Lily_Evans@Hoggy.in", "Remus_Lups", "NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(String emailId) throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId(emailId));
	}
}
