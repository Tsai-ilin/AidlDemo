package com.tsaiilin.server;

import android.os.IInterface;
import android.os.RemoteException;

public interface IMyTestAidlInterface extends IInterface {
    String sayHello(String hello) throws RemoteException;
}
