package com.jarek.carrental.api;

/**
 * The interface Sql queries.
 */
public interface SqlQueries {

    String SELECT_ALL_CARS = "SELECT * FROM Car";

    String FIND_CAR_BY_ID = "SELECT * FROM Car WHERE id ='1'";

    String AVG_MILAGE = "SELECT AVG(carMilage) FROM Car";

}
