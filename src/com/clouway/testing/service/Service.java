package com.clouway.testing.service;

public class Service {

    private Validator validator;
    private Database database;

    public void setValidator(Validator validator) {

        this.validator = validator;
    }

    public void setDatabase(Database database) {

        this.database = database;
    }

    /**
     * Validate the age of the user, then saves it in the database
     *
     * @param userName   the name of the user
     * @param age   the age of the user
     */
    public void processData(String userName, String age) {
        validator.validateAge(age);
        database.saveData(userName, age);
    }

    /**
     * Determines whether the user is adult
     *
     * @param userName   the name of the user
     * @return true if the user age is bigger than 18
     */
    public boolean isUserAdult(String userName) {

        if (Integer.parseInt(database.getData(userName)) >= 18) {
            return true;
        }

        return false;
    }
}
