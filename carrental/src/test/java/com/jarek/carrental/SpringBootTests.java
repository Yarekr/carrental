package com.jarek.carrental;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.dao.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTests {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void contextLoads() {
    }


    @Test
    public void  testRepository(){
        // given:
        // when
        List<Car> allCars = carRepository.findAllCars();
        // then:
        Assert.assertFalse(CollectionUtils.isEmpty(allCars));
        Car astra = allCars.stream().filter(e -> e.getCarName().equals("Astra")).findFirst().get();
        Assert.assertNotNull(astra);
    }
}
