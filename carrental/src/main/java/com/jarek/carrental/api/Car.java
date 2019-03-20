package com.jarek.carrental.api;

import com.jarek.carrental.enums.CarStatus;

import java.io.Serializable;

/**
 * Class describing car
 */
public interface Car extends Serializable {

    String getCarName();

    void setCarName(String carName);

    double getCarMilage();

    void setCarMilage(double carMilage);

    CarStatus getCarStatus();

    void setCarStatus(CarStatus carStatus);

    boolean isCarRented();

    void setCarRented(boolean isCarRented);

}




