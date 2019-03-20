package com.jarek.carrental.impl.builders;

import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;

import java.util.List;

public final class UserToBuilder {
    String username;
    List<RentalPrivilege> privileges;

    private UserToBuilder() {
    }

    public static UserToBuilder anUserTo() {
        return new UserToBuilder();
    }

    public UserToBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserToBuilder withPrivileges(List<RentalPrivilege> privileges) {
        this.privileges = privileges;
        return this;
    }

    public UserTo build() {
        UserTo userTo = new UserTo();
        userTo.setUsername(username);
        userTo.setPrivileges(privileges);
        return userTo;
    }
}
