package com.pandora.car.greendao;


import android.content.Context;

import com.pandora.car.greendao.gen.DaoMaster;
import com.pandora.car.greendao.gen.DaoSession;
import com.pandora.car.greendao.util.MySQLiteOpenHelper;



/**
 * DaoMaster：Dao中的管理者。它保存了sqlitedatebase对象以及操作DAO classes（注意：不是对象）。其提供了一些创建和删除table的静态方法，
 * 其内部类OpenHelper和DevOpenHelper实现了SQLiteOpenHelper，并创建数据库的框架。
 * <p>
 * DaoSession：会话层。操作具体的DAO对象（注意：是对象），比如各种getter方法。
 * <p>
 * Daos：实际生成的某某DAO类，通常对应具体的java类，比如NoteDao等。其有更多的权限和方法来操作数据库元素。
 * <p>
 * Entities：持久的实体对象。通常代表了一个数据库row的标准java properties。
 */
public class GreenDaoManager {

    /**
     * Dao中的管理者
     */
    private static DaoMaster mDaoMaster;

    private static MySQLiteOpenHelper mySQLiteOpenHelper;

    /**
     * 是否初始化
     */
    private boolean initializer;

    public static GreenDaoManager getInstance() {
        return GreenDaoHolder.INSTANCE;
    }

    private static class GreenDaoHolder {
        private static GreenDaoManager INSTANCE = new GreenDaoManager();
    }

    private GreenDaoManager() {

    }

    public void initGreenDao(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (!initializer) {
            mySQLiteOpenHelper = new MySQLiteOpenHelper(context, "my_read.db", null);
            mDaoMaster = new DaoMaster(mySQLiteOpenHelper.getWritableDatabase());
            initializer = true;
        }
    }

    /**
     * 会话层
     *
     * @return
     */
    public DaoSession getSession() {
        return mDaoMaster.newSession();
    }

}
