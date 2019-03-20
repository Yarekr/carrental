package com.jarek.carrental.dao;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.builders.CarToBuilder;
import com.jarek.carrental.impl.builders.TruckToBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Car database.
 */
public class CarDatabase {

    /**
     * Prepare cars list.
     *
     * @return the list
     */
    public static final List<Car> prepareCars() {
        List<Car> carList = new ArrayList<>();

        carList.add(CarToBuilder.aCarTo()
                .withCarMilage(50000)
                .withCarName("Volvo")
                .withCarStatus(CarStatus.OK)
                .build());

        carList.add(CarToBuilder.aCarTo()
                .withCarMilage(500000)
                .withCarName("Lada")
                .withCarStatus(CarStatus.SCRAP)
                .build());

        carList.add(CarToBuilder.aCarTo()
                .withCarMilage(150000)
                .withCarName("Toyota")
                .withCarStatus(CarStatus.CAR_REVIEW)
                .build());

        carList.add(TruckToBuilder.aTruckTo()
                .withCarMilage(1000000)
                .withCarName("Renault")
                .withWeight(16000)
                .withCarStatus(CarStatus.OK)
                .withCarRented(true)
                .build());

        return carList;
    }
}
