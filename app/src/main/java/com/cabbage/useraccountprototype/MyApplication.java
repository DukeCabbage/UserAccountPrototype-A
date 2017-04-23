package com.cabbage.useraccountprototype;

import android.app.Application;
import android.content.Context;
import timber.log.Timber;

// TODO: Have different build variants, and extend from a base class
public class MyApplication extends Application {

    public static synchronized MyApplication getInstance(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUpLogging();
    }

    protected void setUpLogging() {
        Timber.plant(new Timber.DebugTree() {
            //add line number to the tag
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ':' + element.getLineNumber();
            }
        });
    }
}
