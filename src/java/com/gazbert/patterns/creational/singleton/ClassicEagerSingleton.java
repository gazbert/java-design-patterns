package com.gazbert.patterns.creational.singleton;

/**
 * The old skool way of creating <em>eager</em> singletons.
 * <p>
 * Most of the time, this is the preferred approach if you are not using an enum. If you know
 * that you will always need an instance of this Singleton, the eager approach is fine.
 * <p>
 * If the Singleton has to perform resource/time expensive stuff on instantiation during startup of
 * an application (e.g. booting of app server),  consider using a lazy Singleton instead.
 * <p>
 * This technique will work with any version of Java.
 * 
 * @author gazbert
 *
 */
public class ClassicEagerSingleton {
    
    /**
     * We eagerly create the object at class loading time.
     * Note that the member is static and final. Only 1 copy of this can exist.
     */
    private static final ClassicEagerSingleton SINGLE_INSTANCE = new ClassicEagerSingleton();
    
    /** Lock down the constructor to prevent Client's from creating instance of this class */
    private ClassicEagerSingleton() {}
    
    /**
     * Returns the eagerly created single instance of this class.
     * @return single instance of this class.
     */
    public static ClassicEagerSingleton getInstance()
    {
	return SINGLE_INSTANCE;
    }
    
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
