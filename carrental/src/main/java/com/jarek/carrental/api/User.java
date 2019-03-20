package com.jarek.carrental.api;

import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;

import java.io.Serializable;
import java.util.List;

public interface User extends Serializable {

    String getUsername();

    void setUsername(String username);

    List<RentalPrivilege> getPrivileges();

    void setPrivileges(List<RentalPrivilege> privileges);

    void addCar(Car car);

    List<Car> getCars();


}
