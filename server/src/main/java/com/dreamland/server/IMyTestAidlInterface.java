package com.dreamland.server;

import android.os.IInterface;
import android.os.RemoteException;

public interface IMyTestAidlInterface extends IInterface {
    String serverHello(String hello) throws RemoteException;
}