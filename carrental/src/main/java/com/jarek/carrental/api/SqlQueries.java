package com.jarek.carrental.api;

/**
 * The interface Sql queries.
 */
public interface SqlQueries {

    /**
     * The constant QUOTATION.
     */
    String QUOTATION = "'";

    /**
     * The constant SELECT_ALL_CARS.
     */
    String SELECT_ALL_CARS = "SELECT * FROM Car";

    /**
     * The constant SELECT_ALL_USERS.
     */
    String SELECT_ALL_USERS = "SELECT * FROM Users";

    /**
     * The constant FIND_CAR_BY_ID.
     */
    String FIND_CAR_BY_ID = "Select * from Car Where id = ";

    /**
     * The constant CREATE_A_CAR.
     */
    String CREATE_A_CAR = "insert into car values({0},{1}, {2}, {3}, {4})";

}
