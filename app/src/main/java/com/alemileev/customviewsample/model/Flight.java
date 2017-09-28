package com.alemileev.customviewsample.model;

import android.support.annotation.NonNull;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Flight {

    @NonNull public final String number;
    @NonNull public final String departureDate;
    @NonNull public final String duration;

    @NonNull public final String takeOffTime;
    @NonNull public final String landingTime;

    @NonNull public final Airport departureAirport;
    @NonNull public final Airport arrivalAirport;

    public Flight(@NonNull String number,
                  @NonNull String departureDate,
                  @NonNull String takeOffTime,
                  @NonNull String landingTime,
                  @NonNull String duration,
                  @NonNull Airport departureAirport,
                  @NonNull Airport arrivalAirport) {
        this.number = number;
        this.departureDate = departureDate;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.duration = duration;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

}