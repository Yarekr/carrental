package com.jarek.carrental.dao;

import com.jarek.carrental.api.User;
import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.enums.UserType;
import com.jarek.carrental.impl.builders.UserToBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type User factory.
 */
public class UserFactory implements Serializable {

    private static Map<UserType, User> sUserMap = new HashMap<>();

    static {
        User adminUser = UserToBuilder.anUserTo()
                .withUsername("admin")
                .withPrivileges(Arrays.asList(RentalPrivilege.DIAGNOSE))
                .build();

        User customerUser = UserToBuilder.anUserTo()
                .withUsername("Tomasz")
                .withPrivileges(Arrays.asList(RentalPrivilege.BOOK_CAR))
                .build();

        sUserMap.put(UserType.ADMIN, adminUser);
        sUserMap.put(UserType.CUSTOMER, customerUser);

    }


    /**
     * Gets user by type.
     *
     * @param userType the user type
     * @return the user by type
     */
    public static User getUserByType(UserType userType) {
        return sUserMap.get(userType);
    }


}
