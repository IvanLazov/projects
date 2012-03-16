package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateEgnTest {

  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }

  @Test
  public void egnIsValid() {

    assertTrue(validator.egn("8912271449"));
  }
  
  @Test
  public void egnIsNotValidIfContainsLetters() {
    
    assertFalse(validator.egn("qwerty"));
  }
  
  @Test
  public void engIsNotValidIfItsLessThanTenDigits() {
    
    assertFalse(validator.egn("12345"));
  }
  
  @Test
  public void egnIsNotValidIfItsMoreThanTenDigits() {
    
    assertFalse(validator.egn("123456789055555"));
  }
  
  @Test
  public void engIsNotValidIfItsEmpty() {
    
    assertFalse(validator.egn(""));
  }
}
