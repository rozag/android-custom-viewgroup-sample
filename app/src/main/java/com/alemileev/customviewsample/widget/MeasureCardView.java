package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureCardView extends CardView {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureCardView(Context context) {
        super(context);
    }

    public MeasureCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] CardView onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}