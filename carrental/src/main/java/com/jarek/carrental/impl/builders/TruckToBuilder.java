package com.jarek.carrental.impl.builders;

import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.TruckTo;

public final class TruckToBuilder {
    private String carName;
    private double carMilage;
    private double weight;
    private CarStatus carStatus;
    private boolean carRented;

    private TruckToBuilder() {
    }

    public TruckToBuilder withCarRented(boolean carRented){
        this.carRented = carRented;
        return this;
    }

    public static TruckToBuilder aTruckTo() {
        return new TruckToBuilder();
    }

    public TruckToBuilder withCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public TruckToBuilder withCarMilage(double carMilage) {
        this.carMilage = carMilage;
        return this;
    }

    public TruckToBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public TruckToBuilder withCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    public TruckTo build() {
        TruckTo truckTo = new TruckTo(carStatus);
        truckTo.setCarName(carName);
        truckTo.setCarMilage(carMilage);
        truckTo.setWeight(weight);
        truckTo.setCarRented(carRented);
        return truckTo;
    }
}
