package com.clouway.jspservlet.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class CalculatorTest {

  private Calculator calculator;
  
  @Before
  public void setUp() {
    calculator = new Calculator();
  }
  
  @Test
  public void sumTwoPositiveNumbers() {    
    assertThat(8, is(equalTo(calculator.calculate("3+5"))));
  }

  @Test
  public void negativeNumberPlusPositiveNumber() {    
    assertThat(2, is(equalTo(calculator.calculate("-3+5"))));
  }
  
  @Test
  public void subtractTwoNumbers() {
    assertThat(7, is(equalTo(calculator.calculate("10-3"))));
  }
  
  @Test
  public void subtractTwoNegativeNumbers() {
    assertThat(-8, is(equalTo(calculator.calculate("-3-5"))));
  }
  
  @Test
  public void multiplyTwoPositiveNumbers() {
    assertThat(10, is(equalTo(calculator.calculate("2*5"))));
  }
  
  @Test
  public void multiplyOneNegativeNumberAndOnePositiveNumber() {
    assertThat(-6, is(equalTo(calculator.calculate("-3*2"))));
  }
  
  @Test
  public void divideTwoPositiveNumbers() {
    assertThat(3, is(equalTo(calculator.calculate("9/3"))));
  }
  
  @Test
  public void divideOneNegativeNumberByPositiveNumber() {
    assertThat(-3, is(equalTo(calculator.calculate("-6/2"))));
  }
  
  @Test
  public void shouldNotCalculateIfExpressionIsEmpty() {
    assertThat(0, is(equalTo(calculator.calculate(""))));
  }
  
  @Test
  public void shouldReturnZeroIfItsEnteredOnlyOneNumber() {
    assertThat(0, is(equalTo(calculator.calculate("12"))));
  }
  
  @Test(expected = InvalidExpressionException.class)
  public void shouldThrowExceptionIfEnteredExpressionIsNotValid() {
    calculator.calculate("12+");
  }
  
  @Test
  public void shouldReturnZeroIfItsEnteredOnlyASign() {
    assertThat(0, is(equalTo(calculator.calculate("+"))));
  }
}
