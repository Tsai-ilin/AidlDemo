package com.tsaiilin.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    public MyService() {
    }

    private IMyTestAidlStub stub = new IMyTestAidlStub() {
        @Override
        public String serverHello(String hello) throws RemoteException {
            Log.d(TAG, "serverHello: " + hello);
            return "Hello Client";
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        return stub.asBinder();
    }
}