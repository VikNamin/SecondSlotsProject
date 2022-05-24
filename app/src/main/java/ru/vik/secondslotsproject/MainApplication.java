package ru.vik.secondslotsproject;

import android.app.Application;

import com.onesignal.OneSignal;

public class MainApplication extends Application {
    private static final String ONESIGNAL_APP_ID = "c4147517-1adb-4ddf-b8f3-abc85f4825b6";

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
