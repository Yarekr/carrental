package com.jarek.carrental.dao;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.SqlQueries;
import com.jarek.carrental.impl.mappers.CarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

/**
 * The type Car repository.
 */
@Repository
public class CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Find all cars list.
     *
     * @return the list
     */
    public List<Car> findAllCars() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_CARS, new CarRowMapper());
    }

    /**
     * Find car by id car.
     *
     * @param id the id
     * @return the car
     */
    public Car findCarById(Long id) {
        String query = SqlQueries.FIND_CAR_BY_ID + wrapInQuotations(id.toString());
        List<Car> result = jdbcTemplate.query(query, new CarRowMapper());
        // find by id always return list of 1 element
        return result.iterator().next();
    }

    /**
     * Create a car.
     *
     * @param car the car
     */
    public void createACar(Car car) {
        MessageFormat queryFormat = new MessageFormat(SqlQueries.CREATE_A_CAR);
        String query = queryFormat.format(new Object[]{
                // 0 - id:
                new Random().nextInt(10) + 10,
                // 1 - name
                wrapInQuotations(car.getCarName()),
                // 2 - status
                wrapInQuotations(car.getCarStatus().toString()),
                // 3 - rented
                car.isCarRented() ? 1 : 0,
                // 4 - milage
                car.getCarMilage()
        });

        jdbcTemplate.update(query);
    }

    private String wrapInQuotations(String source) {
        return SqlQueries.QUOTATION + source + SqlQueries.QUOTATION;
    }
}