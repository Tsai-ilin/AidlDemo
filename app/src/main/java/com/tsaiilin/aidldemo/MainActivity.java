package com.tsaiilin.aidldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.dreamland.aidldemo.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    IMyTestAidlInterface iMyTestAidlInterface;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyTestAidlInterface = IMyTestAidlStub.asInterface(service);
            try {
                String hhhhhhhhh = iMyTestAidlInterface.serverHello("hhhhhhhhh");
                Log.d(TAG, "onServiceConnected: " + hhhhhhhhh);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setAction("com.tsaiilin.service.MyService");
        intent.setPackage("com.tsaiilin.server");
        this.bindService(intent, connection, BIND_AUTO_CREATE);

    }
}