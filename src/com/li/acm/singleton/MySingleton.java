package com.li.acm.singleton;

public class MySingleton {

    private MySingleton(){}

    private static MySingleton mySingleton = new MySingleton();

    public static MySingleton getMySingleton(){

        return mySingleton;
    }
}


