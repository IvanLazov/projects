package com.clouway.jspservlet.onlinebanking;

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
public class WithdrawServiceTest {

  private Mockery context = new JUnit4Mockery();
  private WithdrawService withdrawService;
  private final BalanceService balanceService = context.mock(BalanceService.class);

  @Before
  public void setUp() {
    withdrawService = new WithdrawServiceImp(balanceService);
  }

  @Test
  public void withdrawAmountFromAccount() {
    
    context.checking(new Expectations(){{
      oneOf(balanceService).getBalance();
      will(returnValue(200.0));
      oneOf(balanceService).updateBalance(100);
    }});

    withdrawService.withdraw(100);
  }

  @Test(expected = InsufficientFundsException.class)
  public void cannotWithdrawIfCurrentBalanceNotEnough() {

    context.checking(new Expectations(){{
      oneOf(balanceService).getBalance();
      will(returnValue(200.0));
    }});

    withdrawService.withdraw(300);
  }

  @Test(expected = InvalidWithdrawAmountException.class)
  public void cannotWithdrawAmountBiggerThanTenThousandFromAccount() {

    withdrawService.withdraw(11000);
  }

  @Test(expected = InvalidWithdrawAmountException.class)
  public void cannotWithdrawZeroAmountFromAccount() {

    withdrawService.withdraw(0);
  }

  @Test(expected = InvalidWithdrawAmountException.class)
  public void cannotWithdrawNegativeAmountFromAccount() {

    withdrawService.withdraw(-10);
  }
}
