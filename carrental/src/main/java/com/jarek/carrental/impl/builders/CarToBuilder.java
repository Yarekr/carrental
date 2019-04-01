package com.jarek.carrental.impl.builders;

import com.jarek.carrental.impl.CarTo;
import com.jarek.carrental.enums.CarStatus;

/**
 * The type Car to builder.
 */
public final class CarToBuilder {
    private CarStatus carStatus;
    private String carName;
    private double carMilage;

    private CarToBuilder() {
    }

    /**
     * A car to car to builder.
     *
     * @return the car to builder
     */
    public static CarToBuilder aCarTo() {
        return new CarToBuilder();
    }

    /**
     * With car status car to builder.
     *
     * @param carStatus the car status
     * @return the car to builder
     */
    public CarToBuilder withCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    /**
     * With car name car to builder.
     *
     * @param carName the car name
     * @return the car to builder
     */
    public CarToBuilder withCarName(String carName) {
        this.carName = carName;
        return this;
    }

    /**
     * With car milage car to builder.
     *
     * @param carMilage the car milage
     * @return the car to builder
     */
    public CarToBuilder withCarMilage(double carMilage) {
        this.carMilage = carMilage;
        return this;
    }

    /**
     * Build car to.
     *
     * @return the car to
     */
    public CarTo build() {
        CarTo carTo = new CarTo(carName, carMilage);
        carTo.setCarStatus(carStatus);
        return carTo;
    }
}
