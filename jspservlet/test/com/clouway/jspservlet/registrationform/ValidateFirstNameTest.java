package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateFirstNameTest {
  
  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }
  
  @Test
  public void firstNameIsValidIfContainsLetters() {

    assertTrue(validator.firstName("Ivan"));
  }

  @Test
  public void firstNameIsValidIfContainsCapitalLetters() {

    assertTrue(validator.firstName("IVAN"));
  }
  
  @Test
  public void firstNameIsValidIfContainsLowercaseLetters() {
    
    assertTrue(validator.firstName("ivan"));
  }

  @Test
  public void firstNameIsNotValidIfContainsSymbols() {
    
    assertFalse(validator.firstName("!@#$%"));
  }

  @Test
  public void firstNameIsNotValidIfItsEmpty() {

    assertFalse(validator.firstName(""));
  }
  
  @Test
  public void firstNameIsNotValidIfLengthIsLessThanThreeCharacters() {
    
    assertFalse(validator.firstName("Iv"));
  }
  
  @Test
  public void firstNameIsNotValidIfLengthIsMoreThanFifteenCharacters() {
    
    assertFalse(validator.firstName("IvanIvanIvanIvanIvanIvan"));
  }

  @Test
  public void firstNameIsNotValidIfContainsBlankSpaces() {
    
    assertFalse(validator.firstName("Ivan Lazov"));
  }
  
}
