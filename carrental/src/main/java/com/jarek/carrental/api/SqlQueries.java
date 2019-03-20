package com.jarek.carrental.api;

/**
 * The interface Sql queries.
 */
public interface SqlQueries {

    String QUOTATION = "'";

    String SELECT_ALL_CARS = "SELECT * FROM Car";

    String SELECT_ALL_USERS = "SELECT * FROM Users";

    String FIND_CAR_BY_ID = "Select * from Car Where id = ";

    String CREATE_A_CAR = "insert into car values({0},{1}, {2}, {3}, {4})";

}
