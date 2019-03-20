package com.jarek.carrental;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.User;
import com.jarek.carrental.dao.CarRepository;
import com.jarek.carrental.dao.UserRepository;
import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.builders.CarToBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTests {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testCarRepository_findAllCars() {
        // given:
        // when
        List<Car> allCars = carRepository.findAllCars();
        // then:
        Assert.assertTrue(carExists(allCars, "Renault"));
    }

    @Test
    public void testCarRepository_findCarById() {
        // given:
        Long renaultId = 1l;
        //when:
        Car renault = carRepository.findCarById(renaultId);
        // then:
        Assert.assertNotNull(renault);
    }

    @Test
    public void testCarRepository_createACar() {
        // given:
        String carName = "Ferrari";
        List<Car> allCars = carRepository.findAllCars();
        Assert.assertFalse(carExists(allCars, carName));

        Car car = CarToBuilder.aCarTo().withCarName("Ferrari").withCarStatus(CarStatus.OK).withCarMilage(1).build();
        // when
        carRepository.createACar(car);
        // then
        allCars = carRepository.findAllCars();
        Assert.assertTrue(carExists(allCars, carName));
    }

    @Test
    public void testUserRepository_findAllUsers() {
        List<User> users = userRepository.findAllUsers();
        Assert.assertNotNull(users);
    }

    private boolean carExists(List<Car> listOfCars, String carName) {
        Assert.assertFalse(CollectionUtils.isEmpty(listOfCars));
        Optional<Car> car = listOfCars.stream().filter(e -> e.getCarName().equals(carName)).findFirst();
        return car.isPresent();
    }
}
