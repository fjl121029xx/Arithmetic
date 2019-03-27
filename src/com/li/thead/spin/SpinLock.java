package com.li.thead.spin;

import com.sun.corba.se.spi.monitoring.MonitoredObject;

/**
 * 自旋锁
 */
public class SpinLock {

    int[] arr = new int[12];
    boolean wasSignalled = false;

    public void doWait() {

        synchronized (arr) {

            while (!wasSignalled) {
                try {
                    arr.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (arr) {
            wasSignalled = true;
            arr.notify();
        }
    }
}
