package com.clouway.jspservlet.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class LoginModule extends AbstractModule {

  protected void configure() {
    bind(LoginService.class).to(LoginServiceImpl.class);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(Login.class), new LoginInterceptor());
  }
}
