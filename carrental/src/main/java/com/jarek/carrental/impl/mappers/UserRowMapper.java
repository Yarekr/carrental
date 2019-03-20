package com.jarek.carrental.impl.mappers;

import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new UserTo(rs.getString("username"));
        String rentalPrivileges = rs.getString("rentalPrivilege");

        user.setPrivileges(getListOfPrivileges(rentalPrivileges));
        return user;
    }

    private List<RentalPrivilege> getListOfPrivileges(String source) {
        List<RentalPrivilege> rentalPrivilegeList = new ArrayList<>();
        Set<String> setOfEnums = StringUtils.commaDelimitedListToSet(source);

        for (String singleEnum : setOfEnums) {
            RentalPrivilege rentalPriviligeEnum = RentalPrivilege.valueOf(singleEnum);
            rentalPrivilegeList.add(rentalPriviligeEnum);
        }

        return rentalPrivilegeList;

    }

}
