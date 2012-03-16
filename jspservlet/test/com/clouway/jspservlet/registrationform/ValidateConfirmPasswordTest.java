package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateConfirmPasswordTest {
  
  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }

  @Test
  public void confirmPasswordIsValid() {

    assertTrue(validator.confirmPassword("ivan123456", "ivan123456"));
  }
  
  @Test
  public void confirmPasswordIsNotValid() {
    
    assertFalse(validator.confirmPassword("ivan123456", "qwerty"));
  }
  
  @Test
  public void confirmPasswordIsNotValidIfItsEmpty() {
    
    assertFalse(validator.confirmPassword("ivan123456", ""));
  }
  
  @Test
  public void passwordsAreNotValidIfAreEmpty() {
    
    assertFalse(validator.confirmPassword("", ""));
  }
}
