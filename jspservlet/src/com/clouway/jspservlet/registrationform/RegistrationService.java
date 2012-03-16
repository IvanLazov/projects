package com.clouway.jspservlet.registrationform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegistrationService {

  private String[] parameters = new String[]{"firstName", "lastName", "egn", "age", "address", "password", "confirmPassword"};
  private Map<String, String> parametersToValues;
  private Map<String, String> errors;
  private Validator validator;

  public RegistrationService(Map<String, String> parametersToValues) {

    this.parametersToValues = parametersToValues;
    errors = new HashMap<String, String>();
    validator = new ValidatorImpl();
  }
  
  public void checkFormData() {
    
    Class validatorClass = Validator.class;
    
    for (int i = 0; i < parameters.length - 1; i++) {

      try {
        Method method = validatorClass.getMethod(parameters[i], String.class);
        Boolean returnValue = (Boolean) method.invoke(validator, parametersToValues.get(parameters[i]));
        
        if (!returnValue) {
          errors.put(parameters[i], "Error");
        }
        
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

  public Map<String, String> getErrors() {
    return errors;
  }
}
