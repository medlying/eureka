package com.simao.application.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    private static volatile Singleton singleton;

    private static final Lock lock = new ReentrantLock();

    public static Singleton init() {
        if (singleton == null) {
            try {
                lock.lock();
                if (singleton == null) {
                    singleton = new Singleton();
                }
            } finally {
                lock.unlock();
            }
            return singleton;
        } else
            return singleton;
    }

    private Singleton() {
        throw new UnsupportedOperationException();
    }

    private static class SingletonInstance {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.singleton;
    }
}
