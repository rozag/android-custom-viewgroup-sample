package com.alemileev.customviewsample;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public final class MeasureCounter {

    public static final String TAG = "MeasureCounter";
    private static final MeasureCounter ourInstance = new MeasureCounter();

    public static MeasureCounter getInstance() {
        return ourInstance;
    }

    private MeasureCounter() {}

    private Map<String, Integer> counts = new HashMap<>(2);

    public void countOnMeasure(String tag) {
        if (counts.containsKey(tag)) {
            counts.put(tag, counts.get(tag) + 1);
        } else {
            counts.put(tag, 1);
        }
    }

    public void printStats() {
        Log.d(TAG, "MeasureCounter results:");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            Log.d(TAG, "\t" + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void reset() {
        counts.clear();
    }

}