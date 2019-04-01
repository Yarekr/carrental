package com.jarek.carrental;

import com.jarek.carrental.dao.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Carrental application.
 */
@SpringBootApplication
public class CarrentalApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarRepository repository;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CarrentalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.error("All cars -> {}", repository.findAllCars());
    }
}

