package com.alemileev.customviewsample.shadow;

import android.graphics.Rect;
import android.support.annotation.NonNull;

public interface RoundedRectShadowOwner {
    @NonNull
    Rect cardBackgroundRect();

    float cardCornerRadius();
}