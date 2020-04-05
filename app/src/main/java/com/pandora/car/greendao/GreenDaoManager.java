package com.pandora.car.greendao;


import com.pandora.car.MyApplication;
import com.pandora.car.greendao.gen.DaoMaster;
import com.pandora.car.greendao.gen.DaoSession;
import com.pandora.car.greendao.util.MySQLiteOpenHelper;


public class GreenDaoManager {
    private static GreenDaoManager instance;
    private static DaoMaster daoMaster;
    private static MySQLiteOpenHelper mySQLiteOpenHelper;

    public static GreenDaoManager getInstance() {
        if (instance == null) {
            instance = new GreenDaoManager();
        }
        return instance;
    }

    public GreenDaoManager() {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(MyApplication.getContext(), "my_read", null);
        daoMaster = new DaoMaster(mySQLiteOpenHelper.getWritableDatabase());
    }


    public DaoSession getSession() {
        return daoMaster.newSession();
    }

}
