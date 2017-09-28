package com.alemileev.customviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alemileev.customviewsample.model.Airport;
import com.alemileev.customviewsample.model.Flight;
import com.alemileev.customviewsample.widget.FlightView;

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

        // Bind flight to the simple XML implementation
        final View xmlFlightView = findViewById(R.id.xml_flight_view);
        xmlFlightView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Nothing to do here
            }
        });
        final TextView numberTextView = xmlFlightView.findViewById(R.id.number_tv);
        final TextView departureDateTextView = xmlFlightView.findViewById(R.id.departure_date_tv);
        final TextView takeOffTimeTextView = xmlFlightView.findViewById(R.id.take_off_time_tv);
        final TextView departureCodeTextView = xmlFlightView.findViewById(R.id.departure_code_tv);
        final TextView departureCityTextView = xmlFlightView.findViewById(R.id.departure_city_tv);
        final TextView departureAirportNameTextView = xmlFlightView.findViewById(R.id.departure_airport_name_tv);
        final TextView landingTimeTextView = xmlFlightView.findViewById(R.id.landing_time_tv);
        final TextView arrivalCodeTextView = xmlFlightView.findViewById(R.id.arrival_code_tv);
        final TextView arrivalCityTextView = xmlFlightView.findViewById(R.id.arrival_city_tv);
        final TextView arrivalAirportNameTextView = xmlFlightView.findViewById(R.id.arrival_airport_name_tv);
        final TextView durationTextView = xmlFlightView.findViewById(R.id.duration_tv);
        numberTextView.setText(FLIGHT.number);
        departureDateTextView.setText(FLIGHT.departureDate);
        takeOffTimeTextView.setText(FLIGHT.takeOffTime);
        departureCodeTextView.setText(FLIGHT.departureAirport.code);
        departureCityTextView.setText(FLIGHT.departureAirport.city);
        departureAirportNameTextView.setText(FLIGHT.departureAirport.name);
        landingTimeTextView.setText(FLIGHT.landingTime);
        arrivalCodeTextView.setText(FLIGHT.arrivalAirport.code);
        arrivalCityTextView.setText(FLIGHT.arrivalAirport.city);
        arrivalAirportNameTextView.setText(FLIGHT.arrivalAirport.name);
        durationTextView.setText(FLIGHT.duration);

        // Bind flight to the custom ViewGroup
        final FlightView customFlightView = findViewById(R.id.custom_flight_view);
        customFlightView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Nothing to do here
            }
        });
        customFlightView.bindFlight(FLIGHT);
    }

}