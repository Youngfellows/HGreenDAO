package com.pandora.car;

import android.app.Application;
import android.content.Context;

import com.pandora.car.greendao.GreenDaoManager;


public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        GreenDaoManager.getInstance().initGreenDao(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
