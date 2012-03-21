package com.clouway.jspservlet.onlinebanking.test;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public final class ContractServiceFactory {

  public static ContractService getContractService() {
    return new ContractServiceImpl();
  }
}
