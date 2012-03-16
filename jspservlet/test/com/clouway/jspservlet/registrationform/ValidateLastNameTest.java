package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateLastNameTest {

  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }

  @Test
  public void lastNameIsValidIfContainsLetters() {

    assertTrue(validator.lastName("Lazov"));
  }
  
  @Test
  public void lastNameIsValidIfContainsCapitalLetters() {
    
    assertTrue(validator.lastName("LAZOV"));
  }
  
  @Test
  public void lastNameIsValidIfContainsLowercaseLetters() {
    
    assertTrue(validator.lastName("lazov"));
  }

  @Test
  public void lastNameIsNotValidIfContainsSymbols() {

    assertFalse(validator.lastName("!@#$%^&*"));
  }
  
  @Test
  public void lastNameIsNotValidIfItsEmpty() {
    
    assertFalse(validator.lastName(""));
  }
  
  @Test
  public void lastNameIsNotValidIfLengthIsLessThanThreeCharacters() {
    
    assertFalse(validator.lastName("La"));
  }
  
  @Test
  public void lastNameIsNotValidIfLengthIsMoreThanTwentyCharacters() {
    
    assertFalse(validator.lastName("LazovLazovLazovLazovLazov"));
  }
  
  @Test
  public void lastNameIsNotValidIfContainsBlankSpaces() {
    
    assertFalse(validator.lastName("Lazov Lazov"));
  }
}
