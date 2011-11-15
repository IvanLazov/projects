package com.clouway.testing.service;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonDataService {

    private Validator validator;
    private Database database;

    public PersonDataService(Database database, Validator validator) {
        this.database = database;
        this.validator = validator;
    }

    public void setValidator(Validator validator) {

        this.validator = validator;
    }

    public void setDatabase(Database database) {

        this.database = database;
    }

    /**
     * Validate the age of the user, and if its valid saves it in the database
     *
     * @param userName   Name of user
     * @param age   Age of user
     */
    public void personData(String userName, String age) {
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

        if (Integer.parseInt(database.getData(userName)) >= 18) {
            return true;
        }

        return false;
    }
}
