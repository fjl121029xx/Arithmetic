package com.li.thead;

import java.util.ArrayList;
import java.util.List;

public class FairLock {


    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueusObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueusObject queusObject = new QueusObject();
        boolean isLockedForThisThread = true;
        synchronized (this) {
            waitingThreads.add(queusObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queusObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queusObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }

            try {
                queusObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queusObject);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;

        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }

}


class QueusObject {
    public boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;

    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
