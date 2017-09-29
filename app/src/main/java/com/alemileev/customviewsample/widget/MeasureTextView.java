package com.alemileev.customviewsample.widget;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureTextView extends AppCompatTextView {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureTextView(Context context) {
        super(context);
    }

    public MeasureTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] TextView onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}