package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateAgeTest {

  private Validator validator;

  @Before
  public void setUp() {

    validator = new ValidatorImpl();
  }

  @Test
  public void userAgeIsValid() {
    
    assertTrue("Age is valid between 18 - 118", validator.age("22"));
  }

  @Test
  public void userAgeIsValid2() {

    assertTrue("Age is valid between 18 - 118", validator.age("18"));
  }

  @Test
  public void userAgeIsValid3() {
    
    assertTrue("Age is valid between 18 - 118", validator.age("118"));
  }
  
  @Test
  public void userAgeLessThanEighteenIsNotValid() {
    
    assertFalse(validator.age("15"));
  }

  @Test
  public void userAgeBiggerThanOneHundredAndEighteenIsNotValid() {
    
    assertFalse(validator.age("130"));
  }
  
  @Test
  public void userAgeIsNotValidIfContainsLetters() {
    
    assertFalse(validator.age("asd"));
  }
  
  @Test
  public void userAgeIsNotValidIfItsEmpty() {
    
    assertFalse(validator.age(""));
  }
  
  @Test
  public void userAgeIsNotValidIfContainsSymbols() {
    
    assertFalse(validator.age("!@#$%^"));
  }
}
