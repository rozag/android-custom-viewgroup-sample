package com.alemileev.customviewsample.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.alemileev.customviewsample.MeasureCounter;

public final class MeasureImageView extends AppCompatImageView {

    private final MeasureCounter counter = MeasureCounter.getInstance();

    public MeasureImageView(Context context) {
        super(context);
    }

    public MeasureImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(MeasureCounter.TAG, "[" + getTag() + "] ImageView onMeasure()");
        counter.countOnMeasure((String) getTag());
    }

}