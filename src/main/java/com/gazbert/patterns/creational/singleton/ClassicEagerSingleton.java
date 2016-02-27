/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
 */
public class ClassicEagerSingleton {

    /**
     * We eagerly create the object at class loading time.
     * Note that the member is static and final. Only 1 copy of this can exist.
     */
    private static final ClassicEagerSingleton SINGLE_INSTANCE = new ClassicEagerSingleton();

    /**
     * Lock down the constructor to prevent Client's from creating instance of this class
     */
    private ClassicEagerSingleton() {
    }

    /**
     * Returns the eagerly created single instance of this class.
     *
     * @return single instance of this class.
     */
    public static ClassicEagerSingleton getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * The business method - we're a logger for sake of this demo.
     *
     * @param msg the message to log
     */
    public void log(String msg) {
        System.out.println("LOG: msg");
    }
}
