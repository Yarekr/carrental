package com.jarek.carrental;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.ManageCarUc;
import com.jarek.carrental.api.User;
import com.jarek.carrental.dao.CarDatabase;
import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.enums.UserType;
import com.jarek.carrental.impl.ManageCarUcImpl;
import com.jarek.carrental.impl.builders.CarToBuilder;
import com.jarek.carrental.impl.builders.UserToBuilder;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Manage car uc test.
 */
@RunWith(SpringRunner.class)
public class ManageCarUcTest {

    /**
     * The System under test.
     */
    ManageCarUc systemUnderTest = new ManageCarUcImpl();

    /**
     * Test get avarage milage.
     */
    @Test
    public void testGetAvarageMilage() {
        // given
        List<Car> cars = CarDatabase.prepareCars();
        double expectedMilage = 425000.0d;
        // when
        double result = systemUnderTest.getAvarageMilage(cars);
        // then
        Assert.assertEquals(result, expectedMilage,0);
    }


    /**
     * Test user unable to rent anything.
     */
    @Test
    public void testUserUnableToRentAnything() {
        // given:
        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(new ArrayList<>());
        String carName = "Volvo";
        //when
        Pair<User, Car> result = systemUnderTest.rentCarByUser(cars, user, carName);
        //then:
        Assert.assertNotNull(result.getKey());
        Assert.assertNull(result.getValue());

    }

    /**
     * Test is able to rent car but car not exists.
     */
    @Test
    public void testIsAbleToRentCarButCarNotExists() {
        // given:
        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(Arrays.asList(RentalPrivilege.BOOK_CAR));
        String carName = "Astra";
        //when
        Pair<User, Car> result = systemUnderTest.rentCarByUser(cars, user, carName);
        //then:
        Assert.assertNotNull(result.getKey());
        Assert.assertNull(result.getValue());
    }

    /**
     * Test car exists but in wrong condition.
     */
    @Test
    public void testCarExistsButInWrongCondition() {
        // given:
        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(new ArrayList<>());
        String carName = "Lada";
        //when
        Pair<User, Car> result = systemUnderTest.rentCarByUser(cars, user, carName);
        //then:
        Assert.assertNotNull(result.getKey().getPrivileges());
        Assert.assertNull(result.getValue());
    }

    /**
     * Test car exists in good condition but already rented.
     */
    @Test
    public void testCarExistsInGoodConditionButAlreadyRented() {
        // given:
        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(new ArrayList<>());
        String carName = "Renault";
        //when
        Pair<User, Car> result = systemUnderTest.rentCarByUser(cars, user, carName);
        //then:
        Assert.assertNotNull(result.getKey());
        Assert.assertNull(result.getValue());
    }
    @Test
    public void testCarExistInGoodCondition(){

        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(Arrays.asList(RentalPrivilege.BOOK_CAR));
        String carName = "Mazda ";

        Pair<User,Car> result = systemUnderTest.rentCarByUser(cars,user,carName);

        Assert.assertNotNull(result.getKey());
        Assert.assertNull(result.getValue());
    }
    /**
     * Test rent a car happy path.
     */
    @Test
    public void testRentACarHappyPath() {
        // given:
        List<Car> cars = CarDatabase.prepareCars();
        User user = prepareUser(Arrays.asList(RentalPrivilege.BOOK_CAR));
        String carName = "Volvo";
        //when
        Pair<User, Car> result = systemUnderTest.rentCarByUser(cars, user, carName);
        //then:
        User resultUser = result.getKey();
        Car resultCar = result.getValue();

        Assert.assertNotNull(resultUser);
        Assert.assertNotNull(resultCar);

        Assert.assertTrue(resultCar. isCarRented());
        Assert.assertTrue(resultUser.getCars().size() == 1);
    }

    private User prepareUser(List<RentalPrivilege> privileges) {
        return UserToBuilder.anUserTo()
                .withUsername("Jarek")
                .withPrivileges(privileges)
                .build();
    }
}
