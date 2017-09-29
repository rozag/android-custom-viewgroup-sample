package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureLinearLayout extends LinearLayout {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureLinearLayout(Context context) {
        super(context);
    }

    public MeasureLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] LinearLayout onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}