package com.tsaiilin.server;

import android.os.IBinder;
import android.os.RemoteException;

public class MyTestAidlInterfaceProxy implements IMyTestAidlInterface {

    private static final java.lang.String DESCRIPTOR = "com.dreamland.server.Test";
    public static IMyTestAidlInterface sDefaultImpl;


    private IBinder mRemote;

    public MyTestAidlInterfaceProxy(android.os.IBinder remote)
    {
        mRemote = remote;
    }

    public String getInterfaceDescriptor()
    {
        return DESCRIPTOR;
    }


    @Override
    public IBinder asBinder() {
        return mRemote;
    }

    @Override public String sayHello(String hello) throws RemoteException
    {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(hello);
            boolean _status = mRemote.transact(IMyTestAidlStub.TRANSACTION_sayHello, _data, _reply, 0);
            if (!_status ) {
                return sDefaultImpl.sayHello(hello);
            }
            _reply.readException();
            _result = _reply.readString();
        }
        finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }
}
