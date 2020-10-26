package com.mrep.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mrep.BuildConfig;


public class Debugger {
    final private static boolean isDebuggable = BuildConfig.DEBUG;
    private final String TAG;
    private static boolean isUnitTest = false;

    public static void setIsUnitTest(boolean isUnitTest) {
        Debugger.isUnitTest = isUnitTest;
    }

    public Debugger(String TAG) {
        this.TAG = TAG;
    }

    public Debugger(Object o) {
        this.TAG = o.getClass().getSimpleName();
    }

    public static void logD(String TAG, String msg) {
        if (isDebuggable) {
            Log.d(TAG, msg);
        }
        unitTestMsg("d", TAG, msg);
    }

    public static void logE(String TAG, String msg) {
        if (isDebuggable) {
            Log.e(TAG, msg);
        }
        unitTestMsg("e", TAG, msg);
    }

    public static void logI(String TAG, String msg) {
        if (isDebuggable) {
            Log.i(TAG, msg);
        }
        unitTestMsg("i", TAG, msg);
    }

    public static void logV(String TAG, String msg) {
        if (isDebuggable) {
            Log.v(TAG, msg);
        }
        unitTestMsg("v", TAG, msg);
    }

    public static void logW(String TAG, String msg) {
        if (isDebuggable) {
            Log.w(TAG, msg);
        }
        unitTestMsg("w", TAG, msg);
    }

    public void logD(String msg) {
        if (isDebuggable) {
            Log.d(TAG, msg);
        }
        unitTestMsg("d", msg);
    }

    public void logE(String msg) {
        if (isDebuggable) {
            Log.e(TAG, msg);
        }
        unitTestMsg("e", msg);
    }

    public void logI(String msg) {
        if (isDebuggable) {
            Log.i(TAG, msg);
        }
        unitTestMsg("i", msg);
    }

    public void logV(String msg) {
        if (isDebuggable) {
            Log.v(TAG, msg);
        }
        unitTestMsg("v", msg);
    }

    public void logW(String msg) {
        if (isDebuggable) {
            Log.w(TAG, msg);
        }
        unitTestMsg("w", msg);
    }


    public static void toast(Context context, String msg, int length) {
        if (isDebuggable) {
            Toast.makeText(context, "Debugger: " + msg, length).show();
        }
    }


    private static void unitTestMsg(String logTag, String tag, String msg) {
        if (isUnitTest) {
            System.out.println("logTag/" + tag + " : " + msg);
        }
    }

    private void unitTestMsg(String logTag, String msg) {
        if (isUnitTest) {
            System.out.println(logTag + "/" + TAG + " : " + msg);
        } else {
            //   System.out.println("bug"+"/"+"is unit testmode"+" : "+isUnitTest);
        }
    }
}
