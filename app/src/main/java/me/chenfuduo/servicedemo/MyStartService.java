package me.chenfuduo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartService extends Service {

    public static final String TAG = "MyStartService";

    public MyStartService() {
        Log.e(TAG,"构造器--->" + "MyStartService");
    }



    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
       return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
