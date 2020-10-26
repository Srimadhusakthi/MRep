package com.mrep.utils;

import android.util.Log;

public class TraceUtils {

    public TraceUtils() {
        throw new IllegalStateException("TraceUtils");
    }


    public static void log(String key, String value) {
        Log.e(key, value);
    }
}
