package com.clouway.jspservlet.registrationform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ValidatorService {

  private Validator validator = new ValidatorImpl();
  private Resources resources = new Resources();
         

  
  

  public ValidatorService() {
    

    
    // request 
    
    

    
  }
  
  public Map<String, String> checkFieldValues(Map<String, String> fieldToValues) {
    Map<String, String> errorMessages = new HashMap<String, String>();
    Class validatorClass = Validator.class;

    try {

//      for (int i = 0; i < resources.getNumberOfFields() - 1; i++) {
//
//        Method method = validatorClass.getMethod(resources.getFieldName(i), String.class);
//        Object value = method.invoke(validator, fieldToValues.get(resources.getFieldName(i)));
//
//        if (!(Boolean) value) {
//          errorMessages.put(resources.getFieldName(i), resources.getMessage(resources.getFieldName(i)));
//        }
//      }

      Method method = validatorClass.getMethod("confirmPassword", String.class, String.class);
      Boolean value = (Boolean) method.invoke(validator, fieldToValues.get("password"), fieldToValues.get("confirmPassword"));
      
      if (!value) {
//        errorMessages.put("confirmPassword", resources.getMessage("confirmPassword"));
      }
      
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return errorMessages;
  }
}
