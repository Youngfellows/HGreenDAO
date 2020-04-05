package com.pandora.car;

import android.app.Application;
import android.content.Context;

/**
 * Created by AIJACK on 2020/4/5.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
