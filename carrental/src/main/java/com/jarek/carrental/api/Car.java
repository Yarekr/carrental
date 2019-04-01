package com.jarek.carrental.api;

import com.jarek.carrental.enums.CarStatus;

import java.io.Serializable;

/**
 * Class describing car
 */
public interface Car extends Serializable {

    /**
     * Gets car name.
     *
     * @return the car name
     */
    String getCarName();

    /**
     * Sets car name.
     *
     * @param carName the car name
     */
    void setCarName(String carName);

    /**
     * Gets car milage.
     *
     * @return the car milage
     */
    double getCarMilage();

    /**
     * Sets car milage.
     *
     * @param carMilage the car milage
     */
    void setCarMilage(double carMilage);

    /**
     * Gets car status.
     *
     * @return the car status
     */
    CarStatus getCarStatus();

    /**
     * Sets car status.
     *
     * @param carStatus the car status
     */
    void setCarStatus(CarStatus carStatus);

    /**
     * Is car rented boolean.
     *
     * @return the boolean
     */
    boolean isCarRented();

    /**
     * Sets car rented.
     *
     * @param isCarRented the is car rented
     */
    void setCarRented(boolean isCarRented);

}




