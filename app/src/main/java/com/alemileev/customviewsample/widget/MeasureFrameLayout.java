package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureFrameLayout extends FrameLayout {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MeasureFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] FrameLayout onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}