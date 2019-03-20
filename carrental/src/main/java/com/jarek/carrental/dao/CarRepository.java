package com.jarek.carrental.dao;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.SqlQueries;
import com.jarek.carrental.impl.mappers.CarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Car> findAllCars() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_CARS, new CarRowMapper());
    }

    public Car findCarById(long id) {

        return (Car) jdbcTemplate.query("Select * from Car Where id ='?'", new CarRowMapper());
    }

    public void createACar(Car car) {
        jdbcTemplate.update(
                "INSERT INTO car (carName, carMilage) VALUES (?, ?)",
                car.getCarName(), car.getCarMilage()
        );
    }

    public List<Car> getAvarageMilage(){
        return jdbcTemplate.query(SqlQueries.AVG_MILAGE, new CarRowMapper());
    }
}