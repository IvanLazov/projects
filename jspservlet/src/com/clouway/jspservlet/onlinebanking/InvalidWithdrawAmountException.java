package com.clouway.jspservlet.onlinebanking;

/**
 * InvalidWithdrawAmountException is thrown when the user tries
 * to withdraw amount less than $1 and greater than $10,000
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class InvalidWithdrawAmountException extends RuntimeException {
}
