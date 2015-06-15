package me.chenfuduo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyBindService extends Service {
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
