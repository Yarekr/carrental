package com.jarek.carrental;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.ManageCarUc;
import com.jarek.carrental.dao.CarDatabase;
import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.CarTo;
import com.jarek.carrental.impl.ManageCarUcImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class LoopStreamTests {

    List<Car> cars = CarDatabase.prepareCars();
    ManageCarUc systemUnderTest = new ManageCarUcImpl();

    @Test
    public void testForLoop() {
        for (int i = 0; i < cars.size(); i++) {
            System.err.println(i);
            Car car = cars.get(i);
            System.err.println(car);
            System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
        }
    }

    @Test
    public void testForEachLoop() {
        for (Car car : cars) {
            System.err.println(car);
            System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
        }
    }

    @Test
    public void testWhileLoop() {
        int i = 0;
        while (i < cars.size()) {
            Car car = cars.get(i);
            System.err.println(car);
            System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
            i++;
        }

    }

    @Test
    public void testDoWhileLoop() {
        int i = 0;
        do {
            Car car = cars.get(i);
            System.err.println(car);
            System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
            i++;
        } while (i < cars.size());
    }

    @Test
    public void testIterator() {
        Iterator iter = cars.iterator();
        while (iter.hasNext()) {
            Car car = (Car) iter.next();
            System.err.println(car);
            System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
        }
    }

    @Test
    public void testBasicStreamFunctionality() {
        // forEach
        cars.stream().forEach(car -> printCar(car));
        // filter
        Set<Car> rentedCars = cars.stream()
                .filter(car -> car.isCarRented())
                .collect(Collectors.toSet());
        rentedCars.stream().forEach(car -> printCar(car));
        //
    }

    @Test
    public void testSorCarsByMilage() {
        int size = cars.size();
        Object[] carsToBeSorted = cars.toArray();
        int i, j;
        for (i = 0; i < size - 1; i++) {
            // Last i elements are already in place
            for (j = 0; j < size - i - 1; j++) {
                if (((Car) carsToBeSorted[j]).getCarMilage() > ((Car) carsToBeSorted[j + 1]).getCarMilage()) {
                    Car temp = (Car) carsToBeSorted[j];
                    carsToBeSorted[j] = carsToBeSorted[j + 1];
                    carsToBeSorted[j + 1] = temp;
                }
            }
        }
        cars.stream().forEach(car -> printCar(car));
    }

    @Test
    public void testSortWithStream() {
        cars.stream()
                .sorted((o1, o2) -> Double.compare(o1.getCarMilage(), o2.getCarMilage()))
                .forEach(car -> printCar(car));
    }

    private void printCar(Car car) {
        System.err.println(car);
        System.err.println(systemUnderTest.getAvarageMilage(Arrays.asList(car)));
    }

    @Test
    public void testSortWithSreamByCarMilage() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getCarMilage(), o2.getCarMilage());
            }
        });
        cars.sort((Car o1, Car o2) -> (int) (o1.getCarMilage() - o2.getCarMilage()));
        cars.forEach((car -> printCar(car)));
    }

}