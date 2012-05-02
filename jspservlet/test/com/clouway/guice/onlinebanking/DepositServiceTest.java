package com.clouway.guice.onlinebanking;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
@RunWith(JMock.class)
public class DepositServiceTest {

  private DepositService depositService;
  private Mockery context = new JUnit4Mockery();
  private final BalanceService balanceService = context.mock(BalanceService.class);

  @Before
  public void setUp() {
    depositService = new DepositServiceImpl(balanceService);
  }

  @Test
  public void depositPositiveAmountInAccount() {
    
    context.checking(new Expectations(){{
      oneOf(balanceService).getBalance();
      will(returnValue(200.00));
      oneOf(balanceService).updateBalance(300);
    }});

    depositService.deposit(100);
  }

  @Test(expected = InvalidDepositAmountException.class)
  public void cannotDepositZeroAmountInAccount() {
    depositService.deposit(0);
  }

  @Test(expected = InvalidDepositAmountException.class)
  public void cannotDepositNegativeAmountInAccount() {
    depositService.deposit(-10);
  }

  @Test(expected = InvalidDepositAmountException.class)
  public void cannotDepositAmountBiggerThanTenThousandInAccount() {
    depositService.deposit(11000);
  }
}
