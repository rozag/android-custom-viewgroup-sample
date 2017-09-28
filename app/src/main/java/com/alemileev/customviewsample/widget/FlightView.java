package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alemileev.customviewsample.R;
import com.alemileev.customviewsample.model.Flight;

@SuppressWarnings("FieldCanBeLocal")
public final class FlightView extends ViewGroup {

    @ColorInt private int headerColor;
    @ColorInt private int headerTextColor;
    @ColorInt private int cardBackgroundColor;
    @ColorInt private int primaryTextColor;
    @ColorInt private int secondaryTextColor;
    @ColorInt private int dividerColor;

    @Px private int paddingLeft;
    @Px private int paddingTop;
    @Px private int paddingRight;
    @Px private int paddingBottom;
    @Px private int paddingInner;
    @Px private int dividerHeight;

    @Dimension(unit = Dimension.SP) private float primaryTextSize;
    @Dimension(unit = Dimension.SP) private float secondaryTextSize;

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
    private ImageView planeImageView;

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
        setClipToPadding(false);

        // Prepare colors
        headerColor = ContextCompat.getColor(context, R.color.primary);
        headerTextColor = ContextCompat.getColor(context, R.color.white_text);
        cardBackgroundColor = ContextCompat.getColor(context, R.color.white);
        primaryTextColor = ContextCompat.getColor(context, R.color.primary_text);
        secondaryTextColor = ContextCompat.getColor(context, R.color.secondary_text);
        dividerColor = ContextCompat.getColor(context, R.color.divider);

        // Prepare paddings
        paddingLeft = dpToPx(8);
        paddingTop = dpToPx(8);
        paddingRight = dpToPx(8);
        paddingBottom = dpToPx(8);
        paddingInner = dpToPx(8);
        dividerHeight = dpToPx(1);

        // Prepare text sizes
        primaryTextSize = 24;
        secondaryTextSize = 14;

        // Instantiate, setup and attach child views
        numberTextView = new TextView(context);
        numberTextView.setTextSize(primaryTextSize);
        numberTextView.setTextColor(headerTextColor);
        addView(numberTextView);

        departureDateTextView = new TextView(context);
        departureDateTextView.setTextSize(primaryTextSize);
        departureDateTextView.setTextColor(headerTextColor);
        addView(departureDateTextView);

        takeOffTimeTextView = new TextView(context);
        takeOffTimeTextView.setTextSize(primaryTextSize);
        takeOffTimeTextView.setTextColor(primaryTextColor);
        addView(takeOffTimeTextView);

        departureCodeTextView = new TextView(context);
        departureCodeTextView.setTextSize(primaryTextSize);
        departureCodeTextView.setTextColor(primaryTextColor);
        addView(departureCodeTextView);

        departureCityTextView = new TextView(context);
        departureCityTextView.setTextSize(secondaryTextSize);
        departureCityTextView.setTextColor(secondaryTextColor);
        addView(departureCityTextView);

        departureAirportNameTextView = new TextView(context);
        departureAirportNameTextView.setTextSize(secondaryTextSize);
        departureAirportNameTextView.setTextColor(secondaryTextColor);
        addView(departureAirportNameTextView);

        landingTimeTextView = new TextView(context);
        landingTimeTextView.setTextSize(primaryTextSize);
        landingTimeTextView.setTextColor(primaryTextColor);
        addView(landingTimeTextView);

        arrivalCodeTextView = new TextView(context);
        arrivalCodeTextView.setTextSize(primaryTextSize);
        arrivalCodeTextView.setTextColor(primaryTextColor);
        addView(arrivalCodeTextView);

        arrivalCityTextView = new TextView(context);
        arrivalCityTextView.setTextSize(secondaryTextSize);
        arrivalCityTextView.setTextColor(secondaryTextColor);
        addView(arrivalCityTextView);

        arrivalAirportNameTextView = new TextView(context);
        arrivalAirportNameTextView.setTextSize(secondaryTextSize);
        arrivalAirportNameTextView.setTextColor(secondaryTextColor);
        addView(arrivalAirportNameTextView);

        durationTextView = new TextView(context);
        durationTextView.setTextSize(secondaryTextSize);
        durationTextView.setTextColor(secondaryTextColor);
        addView(durationTextView);

        planeImageView = new ImageView(context);
        planeImageView.setImageResource(R.drawable.plane);
        addView(planeImageView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO:
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO:
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

    @Px
    private int dpToPx(@Dimension(unit = Dimension.DP) int dp) {
        final Resources resources = getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

}