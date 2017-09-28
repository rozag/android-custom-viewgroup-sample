package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alemileev.customviewsample.R;
import com.alemileev.customviewsample.model.Flight;

public final class FlightView extends FrameLayout {

    private TextView numberTextView;
    private TextView departureDateTextView;
    private TextView takeOffTimeTextView;
    private TextView departureCodeTextView;
    private TextView departureCityTextView;
    private TextView departureAirportNameTextView;
    private TextView landingTimeTextView;
    private TextView arrivalCodeTextView;
    private TextView arrivalCityTextView;
    private TextView arrivalAirportNameTextView;
    private TextView durationTextView;

    public FlightView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public FlightView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FlightView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(@NonNull Context context) {
        setClipChildren(false);
        setClipToPadding(false);

        // Inflate xml to this ViewGroup
        inflate(context, R.layout.view_flight, this);

        // Find child views
        numberTextView = findViewById(R.id.number_tv);
        departureDateTextView = findViewById(R.id.departure_date_tv);
        takeOffTimeTextView = findViewById(R.id.take_off_time_tv);
        departureCodeTextView = findViewById(R.id.departure_code_tv);
        departureCityTextView = findViewById(R.id.departure_city_tv);
        departureAirportNameTextView = findViewById(R.id.departure_airport_name_tv);
        landingTimeTextView = findViewById(R.id.landing_time_tv);
        arrivalCodeTextView = findViewById(R.id.arrival_code_tv);
        arrivalCityTextView = findViewById(R.id.arrival_city_tv);
        arrivalAirportNameTextView = findViewById(R.id.arrival_airport_name_tv);
        durationTextView = findViewById(R.id.duration_tv);
    }

    public void bindFlight(@NonNull Flight flight) {
        numberTextView.setText(flight.number);
        departureDateTextView.setText(flight.departureDate);
        takeOffTimeTextView.setText(flight.takeOffTime);
        departureCodeTextView.setText(flight.departureAirport.code);
        departureCityTextView.setText(flight.departureAirport.city);
        departureAirportNameTextView.setText(flight.departureAirport.name);
        landingTimeTextView.setText(flight.landingTime);
        arrivalCodeTextView.setText(flight.arrivalAirport.code);
        arrivalCityTextView.setText(flight.arrivalAirport.city);
        arrivalAirportNameTextView.setText(flight.arrivalAirport.name);
        durationTextView.setText(flight.duration);
    }

}