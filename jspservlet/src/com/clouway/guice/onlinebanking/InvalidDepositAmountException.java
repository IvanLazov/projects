package com.clouway.guice.onlinebanking;

/**
 * InvalidDepositAmountException is thrown when a user tries
 * to deposit an amount less than $1 or greater than $10.000
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class InvalidDepositAmountException extends RuntimeException {
}
