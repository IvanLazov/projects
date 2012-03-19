package com.clouway.jspservlet.registrationform;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidatorImpl implements Validator {

  public boolean firstName(String firstName) {

    return firstName.matches("[a-zA-Z]{3,15}");
  }

  public boolean lastName(String lastName) {

    return lastName.matches("[a-zA-Z]{3,15}");
  }

  public boolean egn(String egn) {

    return egn.matches("[0-9]{10}");
  }

  public boolean age(String age) {

    boolean result = false;

    try {
      int userAge = Integer.parseInt(age);

      if ((userAge >= 18) && (userAge <= 118)) {
        result = true;
      }

    } catch (NumberFormatException exception) {

    }

    return result;
  }

  public boolean address(String address) {

    return address.matches("[a-zA-Z0-9 ]{1,100}");
  }

  public boolean password(String password) {

    return password.matches("[a-zA-Z0-9]{6,18}");
  }

  public boolean confirmPassword(String password, String confirmPassword) {

    return !password.equals("") && confirmPassword.equals(password);
  }
}
