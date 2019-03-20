package com.jarek.carrental.impl;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.enums.CarStatus;

/**
 * Class describing car
 */
public class TruckTo implements Car {

    private static final long serialVersionId = 1;

    private String carName;
    private double carMilage;
    private double weight;
    private CarStatus carStatus;
    private boolean isCarRented = false;

    public double getWeight() {
        return weight;
    }

    public TruckTo setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    @Override
    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public boolean isCarRented() {
        return isCarRented;
    }

    @Override
    public void setCarRented(boolean isCarRented) {
        this.isCarRented = isCarRented;
    }

    public TruckTo(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

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

    public TruckTo(String carName, double carMilage) {
        this.carName = carName + "Truck";
        this.carMilage = carMilage;
    }

    @Override
    public String toString() {
        return getClass()
                .getName() + " | " + "name: "
                + getCarName() + " | milage: "
                + getCarMilage() + " | weight: "
                + getWeight() + "| Status: "
                + getCarStatus();

    }
}




