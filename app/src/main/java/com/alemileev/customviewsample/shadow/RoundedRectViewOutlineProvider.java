package com.alemileev.customviewsample.shadow;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public final class RoundedRectViewOutlineProvider extends ViewOutlineProvider {

    @Override
    public void getOutline(View view, Outline outline) {
        final RoundedRectShadowOwner shadowOwnerView = (RoundedRectShadowOwner) view;
        final Rect rect = shadowOwnerView.cardBackgroundRect();
        outline.setRoundRect(rect, shadowOwnerView.cardCornerRadius());
    }

}