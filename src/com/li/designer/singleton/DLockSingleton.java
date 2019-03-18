package com.li.designer.singleton;

public class DLockSingleton {

    private static DLockSingleton dLockSingleton = null;

    private DLockSingleton() {

    }

    public static DLockSingleton getInstance() {

        if (dLockSingleton == null) {

            synchronized (dLockSingleton) {
                if (dLockSingleton == null) {
                    dLockSingleton = new DLockSingleton();
                }
            }
        }
        return dLockSingleton;
    }
}
