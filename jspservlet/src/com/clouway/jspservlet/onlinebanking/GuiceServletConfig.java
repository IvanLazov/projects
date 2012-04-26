package com.clouway.jspservlet.onlinebanking;

import com.google.inject.*;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.servlet.SessionScoped;

import javax.servlet.http.HttpSession;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class GuiceServletConfig extends GuiceServletContextListener {

  protected Injector getInjector() {

    return Guice.createInjector(new ServletModule() {

      protected void configureServlets() {

        serve("/register").with(RegisterServlet.class);
        serve("/login").with(LoginServlet.class);
        serve("/userBalance").with(UserBalanceServlet.class);
        serve("/withdraw").with(WithdrawServlet.class);
        serve("/deposit").with(DepositServlet.class);
        serve("/logout").with(LogoutServlet.class);
        serve("/onlineUsers").with(OnlineUsersServlet.class);

        filter("/onlinebanking/userPage.jsp").through(LoginSecurityFilter.class);
        filter("onlinebanking/").through(LoginSecurityFilter.class);
        filter("/onlinebanking/register.jsp").through(RegisterSecurityFilter.class);
        filter("/onlinebanking/login.jsp").through(OnlineUsersFilter.class);

        bind(DatabaseHelper.class).asEagerSingleton();
        bind(RegisterService.class).to(RegisterServiceImpl.class);
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(OnlineUserManager.class).to(OnlineUserManagerImpl.class);
        bind(WithdrawService.class).to(WithdrawServiceImp.class);
        bind(DepositService.class).to(DepositServiceImpl.class);
        bind(BalanceService.class).to(BalanceServiceImpl.class);
      }

      @Provides @SessionScoped User provideUser(Provider<HttpSession> sessionProvider) {
        return (User) sessionProvider.get().getAttribute("user");
      }
    });
  }
}
