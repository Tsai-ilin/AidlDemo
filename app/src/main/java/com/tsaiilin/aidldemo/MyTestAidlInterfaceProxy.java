package com.tsaiilin.aidldemo;

import android.os.IBinder;
import android.os.RemoteException;

public class MyTestAidlInterfaceProxy implements IMyTestAidlInterface {

    private static final String DESCRIPTOR = "com.dreamland.server.Test";
    public static IMyTestAidlInterface sDefaultImpl;


    private IBinder mRemote;

    public MyTestAidlInterfaceProxy(IBinder remote)
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

    @Override public String serverHello(String hello) throws RemoteException
    {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        String _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(hello);
            boolean _status = mRemote.transact(IMyTestAidlStub.TRANSACTION_serverHello, _data, _reply, 0);
//            if (!_status ) {
//                return sDefaultImpl.serverHello(hello);
//            }
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
