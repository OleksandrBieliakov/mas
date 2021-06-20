package com.obieliakov.clinic.model.enums;

public enum AppointmentStatus {

    AVAILABLE,
    BOOKED,
    ATTENDED,
    UNATTENDED,
    CANCELED,
    ARCHIVED;

    public static final int MAX_LENGTH = 10;
}
