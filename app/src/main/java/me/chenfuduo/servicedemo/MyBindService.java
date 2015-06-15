package me.chenfuduo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyBindService extends Service {

    //定义mBinder
    private final IBinder mBinder = new LocalBinder();

    private final Random mGenerator = new Random();

    public MyBindService() {
    }

    /**
     * method for clients
     *
     * 提供了公有的方法
     */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

    /**
     * 返回mBinder对象
     * @param intent intent
     * @return 返回mBinder对象
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * 返回了当前Service的实例
     */
    public class LocalBinder extends Binder{
        MyBindService getService(){
            return MyBindService.this;
        }
    }

}
