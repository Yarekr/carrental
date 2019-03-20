package com.jarek.carrental.impl.builders;

import com.jarek.carrental.impl.CarTo;
import com.jarek.carrental.enums.CarStatus;

public final class CarToBuilder {
    private CarStatus carStatus;
    private String carName;
    private double carMilage;

    private CarToBuilder() {
    }

    public static CarToBuilder aCarTo() {
        return new CarToBuilder();
    }

    public CarToBuilder withCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    public CarToBuilder withCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public CarToBuilder withCarMilage(double carMilage) {
        this.carMilage = carMilage;
        return this;
    }

    public CarTo build() {
        CarTo carTo = new CarTo(carName, carMilage);
        carTo.setCarStatus(carStatus);
        return carTo;
    }
}
