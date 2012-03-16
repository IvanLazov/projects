package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidatePasswordTest {
  
  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }

  @Test
  public void passwordIsValid() {

    assertTrue(validator.password("ivan123456"));
  }

  @Test
  public void passwordIsValidIfContainsCapitalLetters() {

    assertTrue(validator.password("IvaN123"));
  }
  
  @Test
  public void passwordIsNotValidIfContainsSymbols() {
    
    assertFalse(validator.password("ivan!@#$"));
  }

  @Test
  public void passwordIsNotValidIfItsLessThanSixCharacters() {
    
    assertFalse(validator.password("i123"));
  }
  
  @Test
  public void passwordIsNotValidIfItsMoreThanEighteenCharacters() {
    
    assertFalse(validator.password("ivan1234ivan1234ivan1234"));
  }
  
  @Test
  public void passwordIsNotValidIfContainsEmptySpaces() {
    
    assertFalse(validator.password("ivan  9876"));
  }

  @Test
  public void passwordIsNotValidIfItsEmpty() {

    assertFalse(validator.password(""));
  }
}
