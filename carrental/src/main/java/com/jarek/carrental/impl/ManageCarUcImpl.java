package com.jarek.carrental.impl;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.ManageCarUc;
import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.enums.RentalPrivilege;
import javafx.util.Pair;

import java.util.List;

/**
 * The type Manage car uc.
 */
public class ManageCarUcImpl implements ManageCarUc {

    @Override
    public float getAvarageMilage(List<Car> cars) {

        float sumOfMilage = 0;
        for (Car singleCar : cars) {
            sumOfMilage += singleCar.getCarMilage();
        }

        return sumOfMilage / cars.size();
    }

    @Override
    public void printAllCars(List<Car> cars) {
        for (Car singleCar : cars) {
            System.out.println(singleCar);
        }
    }

    @Override
    public Pair<User, Car> rentCarByUser(List<Car> cars, User user, String carName) {

        Car rentedCar = null;
        if (isUserAbleToRentACar(user)) {
            if (isCarPartOfRental(carName, cars)) {
                Car car = getCarByName(cars, carName);
                if (carStatusIsAbleToRent(car)) {
                    rentedCar = rentCar(car, user);
                }
            }
        }
        return new Pair<>(user, rentedCar);
    }

    // private:
    private Car rentCar(Car car, User user) {
        user.addCar(car);
        car.setCarRented(true);
        return car;
    }

    private boolean isUserAbleToRentACar(User user) {
        return user.getPrivileges().contains(RentalPrivilege.BOOK_CAR);
    }

    private boolean isCarPartOfRental(String carName, List<Car> listOfCars) {
        boolean isCarPresent = false;

        for (Car car : listOfCars) {
            if (car.getCarName().equals(carName)) {
                isCarPresent = true;
                break;
            }
        }

        return isCarPresent;
    }

    public boolean carStatusIsAbleToRent(Car car) {
        return car.getCarStatus() == CarStatus.OK && !car.isCarRented();
    }

    public Car getCarByName(List<Car> listOfCars, String carName) {
        for (Car car : listOfCars) {
            if (car.getCarName().equals(carName)) {
                return car;
            }
        }
        return null;
    }


}
