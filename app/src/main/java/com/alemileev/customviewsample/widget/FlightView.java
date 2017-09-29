package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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
import com.alemileev.customviewsample.shadow.RoundedRectShadowOwner;

@SuppressWarnings("FieldCanBeLocal")
public final class FlightView extends ViewGroup implements RoundedRectShadowOwner {

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

    private Paint paint;
    private RectF rect;

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

        // Prepare drawing objects
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rect = new RectF();

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
        widthMeasureSpec = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

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
        // Prepare some dimens
        final int width = right - left;
        final int leftBorder = paddingHorizontal;
        final int rightBorder = width - paddingHorizontal;
        final int centerHorizontal = width / 2;
        final int centerVertical = (bottom - top) / 2;

        // Counter for the spent height
        int heightUsed = paddingVertical;

        // Layout rows one-by-one
        // 1. Header
        numberTextView.layout(
                leftBorder,
                heightUsed,
                leftBorder + numberTextView.getMeasuredWidth(),
                heightUsed + numberTextView.getMeasuredHeight()
        );
        departureDateTextView.layout(
                rightBorder - departureDateTextView.getMeasuredWidth(),
                heightUsed,
                right,
                heightUsed + departureDateTextView.getMeasuredHeight()
        );
        heightUsed += numberTextView.getMeasuredHeight() + paddingInner + paddingInner;

        // 2. Take off and landing times
        takeOffTimeTextView.layout(
                leftBorder,
                heightUsed,
                leftBorder + takeOffTimeTextView.getMeasuredWidth(),
                heightUsed + takeOffTimeTextView.getMeasuredHeight()
        );
        landingTimeTextView.layout(
                rightBorder - landingTimeTextView.getMeasuredWidth(),
                heightUsed,
                rightBorder,
                heightUsed + landingTimeTextView.getMeasuredHeight()
        );
        heightUsed += takeOffTimeTextView.getMeasuredHeight();

        // 3. Airports' codes row
        departureCodeTextView.layout(
                leftBorder,
                heightUsed,
                leftBorder + departureCodeTextView.getMeasuredWidth(),
                heightUsed + departureCodeTextView.getMeasuredHeight()
        );
        arrivalCodeTextView.layout(
                rightBorder - arrivalCodeTextView.getMeasuredWidth(),
                heightUsed,
                rightBorder,
                heightUsed + arrivalCodeTextView.getMeasuredHeight()
        );
        heightUsed += departureCodeTextView.getMeasuredHeight();

        // 4. Cities row
        departureCityTextView.layout(
                leftBorder,
                heightUsed,
                leftBorder + departureCityTextView.getMeasuredWidth(),
                heightUsed + departureCityTextView.getMeasuredHeight()
        );
        arrivalCityTextView.layout(
                rightBorder - arrivalCityTextView.getMeasuredWidth(),
                heightUsed,
                rightBorder,
                heightUsed + arrivalCityTextView.getMeasuredHeight()
        );
        heightUsed += departureCityTextView.getMeasuredHeight() + dividerHeight;

        // 5. Airports' names row
        departureAirportNameTextView.layout(
                leftBorder,
                heightUsed,
                leftBorder + departureAirportNameTextView.getMeasuredWidth(),
                heightUsed + departureAirportNameTextView.getMeasuredHeight()
        );
        arrivalAirportNameTextView.layout(
                rightBorder - arrivalAirportNameTextView.getMeasuredWidth(),
                heightUsed,
                rightBorder,
                heightUsed + arrivalAirportNameTextView.getMeasuredHeight()
        );
        heightUsed += departureAirportNameTextView.getMeasuredHeight() + paddingInner + dividerHeight + paddingInner;

        // 6. Flight duration row
        durationTextView.layout(
                centerHorizontal - durationTextView.getMeasuredWidth() / 2,
                heightUsed,
                centerHorizontal + durationTextView.getMeasuredWidth() - durationTextView.getMeasuredWidth() / 2,
                heightUsed + durationTextView.getMeasuredHeight()
        );

        // 7. Plane image view
        planeImageView.layout(
                centerHorizontal - planeImageView.getMeasuredWidth() / 2,
                centerVertical - planeImageView.getMeasuredHeight() / 2,
                centerHorizontal + planeImageView.getMeasuredWidth() - planeImageView.getMeasuredWidth() / 2,
                centerVertical + planeImageView.getMeasuredHeight() - planeImageView.getMeasuredHeight() / 2
        );
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        final int width = canvas.getWidth();
        final int height = canvas.getHeight();

        // Draw card header background
        paint.setColor(headerColor);
        final int headerHeight = paddingVertical + numberTextView.getMeasuredHeight() + paddingInner;
        rect.set(0, 0, width, headerHeight + cornerRadius);
        canvas.save();
        canvas.clipRect(0, 0, width, headerHeight);
        canvas.drawRoundRect(
                rect,
                cornerRadius,
                cornerRadius,
                paint
        );
        canvas.restore();

        // Draw card background
        paint.setColor(cardBackgroundColor);
        rect.set(0, headerHeight - cornerRadius, width, height);
        canvas.save();
        canvas.clipRect(0, headerHeight, width, height);
        canvas.drawRoundRect(
                rect,
                cornerRadius,
                cornerRadius,
                paint
        );
        canvas.restore();

        // Draw dividers
        //noinspection SuspiciousNameCombination
        paint.setStrokeWidth(dividerHeight);
        paint.setColor(dividerColor);
        final float smallDividerY = departureCityTextView.getBottom() + dividerHeight / 2f + 1;
        canvas.drawLine(
                paddingHorizontal,
                smallDividerY,
                planeImageView.getLeft() - paddingInner,
                smallDividerY,
                paint
        );
        canvas.drawLine(
                planeImageView.getRight() + paddingInner,
                smallDividerY,
                width - paddingHorizontal,
                smallDividerY,
                paint
        );
        final float largeDividerY = departureAirportNameTextView.getBottom() + paddingInner + dividerHeight / 2f + 1;
        canvas.drawLine(
                0,
                largeDividerY,
                width,
                largeDividerY,
                paint
        );

        // Draw children
        super.dispatchDraw(canvas);
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

    @NonNull
    @Override
    public Rect cardBackgroundRect() {
        return new Rect(0, 0, getWidth(), getHeight());
    }

    @Override
    public float cardCornerRadius() {
        return cornerRadius;
    }

}