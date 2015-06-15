package me.chenfuduo.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    MyBindService mService;

     boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStartServcice = (Button) findViewById(R.id.startService);
        btnStartServcice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MyStartService.class);
                startService(intent);
            }
        });

        Button btnStopService = (Button) findViewById(R.id.stopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        Button btnIntentService = (Button) findViewById(R.id.intentServcice);
        btnIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent);
            }
        });

        Button btnBindService = (Button) findViewById(R.id.bindService);
        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, MyBindService.class);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        Button btnCommunicate = (Button) findViewById(R.id.communicate);

        btnCommunicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    int randomNumber = mService.getRandomNumber();
                    Toast.makeText(MainActivity.this, "通讯:" + randomNumber, Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btnUnBindService = (Button) findViewById(R.id.unBindService);
        btnUnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    unbindService(mServiceConnection);
                    mBound = false;
                }
            }
        });

    }

    /**
     * Defines callbacks for service binding, passed to bindService()
     */
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindService.LocalBinder binder = (MyBindService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

}
