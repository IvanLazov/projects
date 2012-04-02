package com.clouway.jspservlet.onlinebanking;

/**
 * InsufficientFundsException is thrown when а user tries to withdraw
 * an amount greater than its current account balance
 *
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class InsufficientFundsException extends RuntimeException {
}
