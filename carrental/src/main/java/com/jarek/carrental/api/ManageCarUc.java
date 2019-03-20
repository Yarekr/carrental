package com.jarek.carrental.api;

import com.sun.istack.internal.NotNull;
import javafx.util.Pair;

import java.util.List;


/**
 * The interface Manage car.
 */
public interface ManageCarUc {

    /**
     * Gets avarage milage.
     *
     * @param cars the cars
     * @return the avarage milage
     */
    float getAvarageMilage(List<Car> cars);

    /**
     * Print all cars.
     *
     * @param cars the cars
     */
    void printAllCars(List<Car> cars);

    Pair<User, Car> rentCarByUser(@NotNull List<Car> cars, @NotNull User user, @NotNull String carName);
}
