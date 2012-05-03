package com.clouway.guice.onlinebanking;

import com.google.inject.*;
import com.google.inject.Provider;
import com.google.inject.util.Providers;
import org.junit.Test;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class MyTest {

  interface Something {

    void doSomething();
  }


  static class MyClass implements Something {


    private final Provider<String> nameProvider;

    @Inject
    MyClass(Provider<String> nameProvider) {


      this.nameProvider = nameProvider;
    }


    public void doSomething() {
      System.out.println(nameProvider.get());
    }
  }


  static class MyModule extends AbstractModule {

    @Override
    protected void configure() {
      bind(Something.class).to(MyClass.class).in(Singleton.class);
    }

    @Provides
    public String getName() {
      System.out.println("Get Name was invoked");
      return "test";
    }
  }

  @Test
  public void testtest() throws Exception {
    MyClass myClass = new MyClass(Providers.of("test"));
    myClass.doSomething();
  }
}
