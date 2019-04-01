package com.jarek.carrental.impl.builders;

import com.jarek.carrental.enums.RentalPrivilege;
import com.jarek.carrental.impl.UserTo;

import java.util.List;

/**
 * The type User to builder.
 */
public final class UserToBuilder {
    /**
     * The Username.
     */
    String username;
    /**
     * The Privileges.
     */
    List<RentalPrivilege> privileges;

    private UserToBuilder() {
    }

    /**
     * An user to user to builder.
     *
     * @return the user to builder
     */
    public static UserToBuilder anUserTo() {
        return new UserToBuilder();
    }

    /**
     * With username user to builder.
     *
     * @param username the username
     * @return the user to builder
     */
    public UserToBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * With privileges user to builder.
     *
     * @param privileges the privileges
     * @return the user to builder
     */
    public UserToBuilder withPrivileges(List<RentalPrivilege> privileges) {
        this.privileges = privileges;
        return this;
    }

    /**
     * Build user to.
     *
     * @return the user to
     */
    public UserTo build() {
        UserTo userTo = new UserTo();
        userTo.setUsername(username);
        userTo.setPrivileges(privileges);
        return userTo;
    }
}
