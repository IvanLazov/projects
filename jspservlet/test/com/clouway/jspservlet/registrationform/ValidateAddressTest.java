package com.clouway.jspservlet.registrationform;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidateAddressTest {
  
  private Validator validator;
  
  @Before
  public void setUp() {
    
    validator = new ValidatorImpl();
  }

  @Test
  public void addressIsValid() {

    assertTrue(validator.address("Veliko Turnovo Dimitur Blagoev 19"));
  }

  @Test
  public void addressIsNotValidIfContainsSymbols() {
    
    assertFalse(validator.address("!@#$%^&*("));
  }
  
  @Test
  public void addressIsNotValidIfItsEmpty() {
    
    assertFalse(validator.address(""));
  }
  
  @Test
  public void addressIsNotValidIfItsMoreThanOneHundredCharacters() {
    
    assertFalse(validator.address("Veliko Turnovo Veliko Turnovo Veliko Turnovo Veliko Turnovo Veliko Turnovo Veliko Turnovo Veliko Turnovo Veliko Turnovo"));
  }
}
