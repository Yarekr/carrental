package com.jarek.carrental.api;

import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;

import java.io.Serializable;
import java.util.List;

/**
 * The interface User.
 */
public interface User extends Serializable {

    /**
     * Gets username.
     *
     * @return the username
     */
    String getUsername();

    /**
     * Sets username.
     *
     * @param username the username
     */
    void setUsername(String username);

    /**
     * Gets privileges.
     *
     * @return the privileges
     */
    List<RentalPrivilege> getPrivileges();

    /**
     * Sets privileges.
     *
     * @param privileges the privileges
     */
    void setPrivileges(List<RentalPrivilege> privileges);

    /**
     * Add car.
     *
     * @param car the car
     */
    void addCar(Car car);

    /**
     * Gets cars.
     *
     * @return the cars
     */
    List<Car> getCars();


}
