package com.test.goldenTrio;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

public class PasswordValidatorTest {
	PasswordValidator passwordValidator;
	
	@BeforeEach
	public void init() {
		passwordValidator = new PasswordValidator();
	}
	
	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		assertFalse(passwordValidator.validatePassword("Asdf123"));
	}

	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		assertFalse(passwordValidator.validatePassword("Asdf"));
	}
	
	@Test
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		Exception exception = assertThrows(InfyAcademyException.class, () -> {
			passwordValidator.validatePassword("");
		});
		
		String expectedMessage = "Invalid Password.";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Qwerty", "Qwerty1234", "QwerAsdfZxcvVcxzFdsaRewq", "Zxcvb54321"})
	public void validatePasswordParameterizedPassword(String password) throws InfyAcademyException {
		assertTrue(passwordValidator.validatePassword(password));
	}
}
