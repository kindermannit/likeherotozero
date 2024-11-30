package de.kindermann.likeherotozero.utils;

/**
 * The EmissionStatus enum represents the different states that an emission
 * record can be in within the system.
 *
 * It has two statuses:
 * - ACTIVE: Representing that the emission is active.
 * - PENDING: Representing that the emission is awaiting approval.
 *
 * Each status is associated with an integer identifier and a descriptive name in German.
 */
public enum EmissionStatus {

    ACTIVE(1, "Aktiv"),
    PENDING(2, "Freigabe ausstehend");

    private final int intStatus;
    private final String status;

    private EmissionStatus(int intStatus, String status) {
        this.intStatus = intStatus;
        this.status = status;
    }

    public int getIntStatus() {
        return intStatus;
    }

    public String getStatus() {
        return status;
    }

}