package com.jarek.carrental.impl;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.enums.CarStatus;

/**
 * Class describing car
 */
public class CarTo implements Car {

    private static final long serialVersionId = 1;

    private String carName;
    private double carMilage;
    private CarStatus carStatus;
    private boolean isCarRented = false;

    @Override
    public String getCarName() {
        return carName;
    }

    @Override
    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public double getCarMilage() {
        return carMilage;
    }

    @Override
    public void setCarMilage(double carMilage) {
        this.carMilage = carMilage;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    @Override
    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public CarTo(String carName) {
        this.carName = carName;
    }

    public CarTo(String carName, double carMilage) {
        this.carName = carName;
        this.carMilage = carMilage;
    }


    @Override
    public String toString() {
        return getClass().getName()
                + " | " + "name: "
                + getCarName() + " | milage: "
                + getCarMilage() + "| Status : "
                + getCarStatus();
    }

    @Override
    public boolean isCarRented() {
        return this.isCarRented;
    }

    @Override
    public void setCarRented(boolean carRented) {
        this.isCarRented = carRented;
    }
}




