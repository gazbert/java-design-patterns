package com.gazbert.patterns.creational.singleton;

/**
 * Example of a Singleton using an enum.
 * 
 * @author gazbert
 *
 */
public enum SingletonUsingEnum {
    
    /** Single instance */
    SINGLE_INSTANCE;

    /**
     * The business method - we're a logger for sake of this demo.
     * 
     * @param msg the message to log
     */
    public void log(String msg)
    {
	    System.out.println("LOG: msg");
    }    
}
