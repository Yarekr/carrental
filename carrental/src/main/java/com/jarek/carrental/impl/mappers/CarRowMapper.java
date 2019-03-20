package com.jarek.carrental.impl.mappers;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.enums.CarStatus;
import com.jarek.carrental.impl.CarTo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Car row mapper.
 */
public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new CarTo(rs.getString("carName"));

        String carStatus = rs.getString("carStatus");

        if (!StringUtils.isEmpty(carStatus)) {
            car.setCarStatus(CarStatus.valueOf(carStatus));
        }

        car.setCarRented(rs.getBoolean("isCarRented"));
        car.setCarMilage(rs.getDouble("carMilage"));
        return car;
    }
}
