package com.jarek.carrental.impl.builders;

import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.TruckTo;

/**
 * The type Truck to builder.
 */
public final class TruckToBuilder {
    private String carName;
    private double carMilage;
    private double weight;
    private CarStatus carStatus;
    private boolean carRented;

    private TruckToBuilder() {
    }

    /**
     * With car rented truck to builder.
     *
     * @param carRented the car rented
     * @return the truck to builder
     */
    public TruckToBuilder withCarRented(boolean carRented){
        this.carRented = carRented;
        return this;
    }

    /**
     * A truck to truck to builder.
     *
     * @return the truck to builder
     */
    public static TruckToBuilder aTruckTo() {
        return new TruckToBuilder();
    }

    /**
     * With car name truck to builder.
     *
     * @param carName the car name
     * @return the truck to builder
     */
    public TruckToBuilder withCarName(String carName) {
        this.carName = carName;
        return this;
    }

    /**
     * With car milage truck to builder.
     *
     * @param carMilage the car milage
     * @return the truck to builder
     */
    public TruckToBuilder withCarMilage(double carMilage) {
        this.carMilage = carMilage;
        return this;
    }

    /**
     * With weight truck to builder.
     *
     * @param weight the weight
     * @return the truck to builder
     */
    public TruckToBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * With car status truck to builder.
     *
     * @param carStatus the car status
     * @return the truck to builder
     */
    public TruckToBuilder withCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    /**
     * Build truck to.
     *
     * @return the truck to
     */
    public TruckTo build() {
        TruckTo truckTo = new TruckTo(carStatus);
        truckTo.setCarName(carName);
        truckTo.setCarMilage(carMilage);
        truckTo.setWeight(weight);
        truckTo.setCarRented(carRented);
        return truckTo;
    }
}
