package com.alemileev.customviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alemileev.customviewsample.model.Airport;
import com.alemileev.customviewsample.model.Flight;

public class MainActivity extends AppCompatActivity {

    private static final Flight FLIGHT = new Flight(
            "AA 1",
            "Sep 18, 2017",
            "07:57",
            "11:19",
            "Duration: 6h 22m",
            new Airport("JFK", "New York, US", "John F. Kennedy International Airport"),
            new Airport("LAX", "Los Angeles, US", "Los Angeles International Airport")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}