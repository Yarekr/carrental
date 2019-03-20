package com.jarek.carrental.enums;

/**
 * The enum Rental privilege.
 */
public enum RentalPrivilege {
    /**
     * The Book car.
     */
    BOOK_CAR("Book car"),
    /**
     * Diagnose rental privilege.
     */
    DIAGNOSE("Diagnose");

    private String rentalPrivilege;

    /**
     * Gets rental privilege.
     *
     * @return the rental privilege
     */
    public String getRentalPrivilege() {
        return rentalPrivilege;
    }

    /**
     * Sets rental privilege.
     *
     * @param rentalPrivilege the rental privilege
     * @return the rental privilege
     */
    public void setRentalPrivilege(String rentalPrivilege) {
        this.rentalPrivilege = rentalPrivilege;
    }

    RentalPrivilege(String rentalPrivilege) {
        setRentalPrivilege(rentalPrivilege);
    }
}
