package com.jarek.carrental.enums;


/**
 * The enum Status to.
 */
public enum CarStatus {
    /**
     * Ok status to.
     */
    OK("1", "ok!"),
    /**
     * The Car review.
     */
    CAR_REVIEW("2", "Car review"),
    /**
     * Scrap status to.
     */
    SCRAP("3", "Scrap");

    /**
     * The Nr status.
     */
    public String nrStatus;
    /**
     * The Car status.
     */
    public String carStatus;

    /**
     * Gets car status.
     *
     * @return the car status
     */
    public String getCarStatus() {
        return carStatus;
    }

    /**
     * Sets car status.
     *
     * @param carStatus the car status
     * @return the car status
     */
    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    /**
     * Gets nr status.
     *
     * @return the nr status
     */
    public String getNrStatus() {
        return nrStatus;
    }

    /**
     * Sets nr status.
     *
     * @param nrStatus the nr status
     * @return the nr status
     */
    public void setNrStatus(String nrStatus) {
        this.nrStatus = nrStatus;
    }

    CarStatus(String nrStatus, String carStatus) {
        this.carStatus = carStatus;
        this.nrStatus = nrStatus;
    }

    /**
     * Gets car status.
     *
     * @param carStatus the car status
     * @return the car status
     */
    public static String getCarStatus(String carStatus) {
        return carStatus;

    }
}




