package com.jarek.carrental.dao;

import com.jarek.carrental.api.Car;
import com.jarek.carrental.api.SqlQueries;
import com.jarek.carrental.api.User;
import com.jarek.carrental.impl.mappers.CarRowMapper;
import com.jarek.carrental.impl.mappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

/**
 * The type User repository.
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Find all users list.
     *
     * @return the list
     */
    public List<User> findAllUsers() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_USERS, new UserRowMapper());
    }

}