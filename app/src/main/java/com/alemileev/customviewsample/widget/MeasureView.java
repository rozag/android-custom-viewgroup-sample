package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureView extends View {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureView(Context context) {
        super(context);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] View onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}