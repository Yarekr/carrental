package com.jarek.carrental.impl;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.RentalPrivilege;
import org.testng.collections.Lists;

import java.util.List;

/**
 * The type User to.
 */
public class UserTo implements User {

    /**
     * The Username.
     */
    String username;
    /**
     * The Privileges.
     */
    List<RentalPrivilege> privileges;
    /**
     * The Cars.
     */
    List<Car> cars = Lists.newArrayList();

    public UserTo(String username) {
       this.username = username;

    }



    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public List<RentalPrivilege> getPrivileges() {
        return privileges;
    }

    @Override
    public void setPrivileges(List<RentalPrivilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}

