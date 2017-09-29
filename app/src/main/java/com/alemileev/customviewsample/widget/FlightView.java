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
import android.view.Gravity;
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

    @Px private int paddingHorizontal;
    @Px private int paddingVertical;
    @Px private int paddingInner;
    @Px private int dividerHeight;
    @Px private int cornerRadius;

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
        paddingHorizontal = dpToPx(8);
        paddingVertical = dpToPx(8);
        paddingInner = dpToPx(8);
        dividerHeight = dpToPx(1);
        cornerRadius = dpToPx(16);

        // Prepare text sizes
        primaryTextSize = 24;
        secondaryTextSize = 14;

        // Instantiate, setup and attach child views
        numberTextView = new TextView(context);
        numberTextView.setTextSize(primaryTextSize);
        numberTextView.setTextColor(headerTextColor);
        numberTextView.setGravity(Gravity.START);
        addView(numberTextView);

        departureDateTextView = new TextView(context);
        departureDateTextView.setTextSize(primaryTextSize);
        departureDateTextView.setTextColor(headerTextColor);
        departureDateTextView.setGravity(Gravity.END);
        addView(departureDateTextView);

        takeOffTimeTextView = new TextView(context);
        takeOffTimeTextView.setTextSize(primaryTextSize);
        takeOffTimeTextView.setTextColor(primaryTextColor);
        takeOffTimeTextView.setGravity(Gravity.START);
        addView(takeOffTimeTextView);

        departureCodeTextView = new TextView(context);
        departureCodeTextView.setTextSize(primaryTextSize);
        departureCodeTextView.setTextColor(primaryTextColor);
        departureCodeTextView.setGravity(Gravity.START);
        addView(departureCodeTextView);

        departureCityTextView = new TextView(context);
        departureCityTextView.setTextSize(secondaryTextSize);
        departureCityTextView.setTextColor(secondaryTextColor);
        departureCityTextView.setGravity(Gravity.START);
        addView(departureCityTextView);

        departureAirportNameTextView = new TextView(context);
        departureAirportNameTextView.setTextSize(secondaryTextSize);
        departureAirportNameTextView.setTextColor(secondaryTextColor);
        departureAirportNameTextView.setGravity(Gravity.START);
        addView(departureAirportNameTextView);

        landingTimeTextView = new TextView(context);
        landingTimeTextView.setTextSize(primaryTextSize);
        landingTimeTextView.setTextColor(primaryTextColor);
        landingTimeTextView.setGravity(Gravity.END);
        addView(landingTimeTextView);

        arrivalCodeTextView = new TextView(context);
        arrivalCodeTextView.setTextSize(primaryTextSize);
        arrivalCodeTextView.setTextColor(primaryTextColor);
        arrivalCodeTextView.setGravity(Gravity.END);
        addView(arrivalCodeTextView);

        arrivalCityTextView = new TextView(context);
        arrivalCityTextView.setTextSize(secondaryTextSize);
        arrivalCityTextView.setTextColor(secondaryTextColor);
        arrivalCityTextView.setGravity(Gravity.END);
        addView(arrivalCityTextView);

        arrivalAirportNameTextView = new TextView(context);
        arrivalAirportNameTextView.setTextSize(secondaryTextSize);
        arrivalAirportNameTextView.setTextColor(secondaryTextColor);
        arrivalAirportNameTextView.setGravity(Gravity.END);
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
        // Measure the plane image first, it's kind of anchor for other children
        measureChild(planeImageView, widthMeasureSpec, heightMeasureSpec);

        // Determine text width for the header views and the body views
        final int bodyTextWidth = (widthMeasureSpec - planeImageView.getMeasuredWidth()) / 2 - paddingHorizontal;
        final int headerTextWidth = widthMeasureSpec / 2 - paddingHorizontal;

        // Specify max width for the TextViews
        numberTextView.setMaxWidth(headerTextWidth);
        departureDateTextView.setMaxWidth(headerTextWidth);
        takeOffTimeTextView.setMaxWidth(headerTextWidth);
        departureCodeTextView.setMaxWidth(bodyTextWidth);
        departureCityTextView.setMaxWidth(bodyTextWidth);
        departureAirportNameTextView.setMaxWidth(bodyTextWidth);
        landingTimeTextView.setMaxWidth(bodyTextWidth);
        arrivalCodeTextView.setMaxWidth(bodyTextWidth);
        arrivalCityTextView.setMaxWidth(bodyTextWidth);
        arrivalAirportNameTextView.setMaxWidth(bodyTextWidth);

        // Measure children
        measureChild(numberTextView, headerTextWidth, heightMeasureSpec);
        measureChild(departureDateTextView, headerTextWidth, heightMeasureSpec);
        measureChild(takeOffTimeTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(departureCodeTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(departureCityTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(departureAirportNameTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(landingTimeTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(arrivalCodeTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(arrivalCityTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(arrivalAirportNameTextView, bodyTextWidth, heightMeasureSpec);
        measureChild(durationTextView, widthMeasureSpec, heightMeasureSpec);

        // Calculate the height of the whole view
        final int heightUsed = paddingVertical +
                numberTextView.getMeasuredHeight() +
                paddingInner +
                paddingInner +
                takeOffTimeTextView.getMeasuredHeight() +
                departureCodeTextView.getMeasuredHeight() +
                departureCityTextView.getMeasuredHeight() +
                dividerHeight +
                departureAirportNameTextView.getMeasuredHeight() +
                paddingInner +
                dividerHeight +
                paddingInner +
                durationTextView.getMeasuredHeight() +
                paddingVertical;

        // Finally, set the measured dimensions to the FlightView
        setMeasuredDimension(widthMeasureSpec, heightUsed);
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