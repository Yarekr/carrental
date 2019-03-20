package com.jarek.carrental.impl.mappers;

import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new UserTo(rs.getString("username"));
        String rentalPrivileges = rs.getString("privileges");

        if(!StringUtils.isEmpty(rentalPrivileges)){
            user.setPrivileges(List<RentalPrivilege>rentalPrivileges.valueOf(rentalPrivileges));
        }
    /// help !
    }
}
