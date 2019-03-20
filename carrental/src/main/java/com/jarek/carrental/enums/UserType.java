package com.jarek.carrental.enums;

/**
 * The enum User type.
 */
public enum UserType {
    /**
     * Customer user type.
     */
    CUSTOMER("Customer"),
    /**
     * Admin user type.
     */
    ADMIN("Admin"),
    /**
     * The Secret customer.
     */
    SECRET_CUSTOMER("Secret Customer");

    /**
     * The User type.
     */
    public String UserType;

    /**
     * Gets user type.
     *
     * @return the user type
     */
    public String getUserType() {
        return UserType;
    }

    /**
     * Sets user type.
     *
     * @param userType the user type
     * @return the user type
     */
    public UserType setUserType(String userType) {
        UserType = userType;
        return this;
    }

    UserType(String userType) {
        UserType = userType;
    }
}
