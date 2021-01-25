package com.dreamland.aidldemo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class IMyTestAidlStub extends Binder implements IMyTestAidlInterface {
    private static final String DESCRIPTOR = "com.dreamland.server.Test";
    static final int TRANSACTION_serverHello = (IBinder.FIRST_CALL_TRANSACTION + 0);


    public IMyTestAidlStub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMyTestAidlInterface asInterface(IBinder obj) {
        if ((obj == null)) {
            return null;
        }
        IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (iin instanceof IMyTestAidlInterface) {
            return (IMyTestAidlInterface) iin;
        }

        // 需要返回代理对象
        return new MyTestAidlInterfaceProxy(obj);
    }

    @Override
    public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
        String descriptor = DESCRIPTOR;
        switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(descriptor);
                return true;
            }
            case TRANSACTION_serverHello: {
                data.enforceInterface(descriptor);
                String _arg0;
                _arg0 = data.readString();
                String _result = this.serverHello(_arg0);
                reply.writeNoException();
                reply.writeString(_result);
                return true;
            }
            default: {
                return super.onTransact(code, data, reply, flags);
            }
        }
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

}
