package com.clouway.testing.service;

/**
 * PersonDataService class uses Validator class to validate user age.
 * If the user age is valid (between 10 and 100) saves the user name and age
 * in a database using Database class.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonDataService {

    private Validator validator;
    private Database database;
    private final static int MINIMAL_AGE = 18;

    public PersonDataService(Database database, Validator validator) {
        this.database = database;
        this.validator = validator;
    }

    /**
     * If user age is valid, save the user name and age in database
     *
     * @param userName   Name of user
     * @param age   Age of user
     */
    public void savePersonData(String userName, String age) {
        validator.validateAge(age);
        database.saveData(userName, age);
    }

    /**
     * Determines whether the user is adult
     *
     * @param userName   Name of user
     * @return true   If user age is bigger than 18
     */
    public boolean isUserAdult(String userName) {

        if (Integer.parseInt(database.getData(userName)) >= MINIMAL_AGE) {
            return true;
        }

        return false;
    }
}
