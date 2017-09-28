package com.alemileev.customviewsample.model;

import android.support.annotation.NonNull;

@SuppressWarnings("WeakerAccess")
public final class Airport {

    @NonNull public final String code;
    @NonNull public final String city;
    @NonNull public final String name;

    public Airport(@NonNull String code, @NonNull String city, @NonNull String name) {
        this.code = code;
        this.city = city;
        this.name = name;
    }

}