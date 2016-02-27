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
 * The old skool way of creating <em>lazy</em> singletons.
 * <p>
 * Use this approach if the Singleton has to perform resource/time expensive stuff on instantiation during startup of
 * an application, e.g. booting of app server.
 * <p>
 * NOTE: This technique only works for Java 5 and above.
 *
 * @author gazbert
 */
public class ClassicLazySingletonUsingDoubleCheckedLocking {

    /**
     * We lazily create the object when any Client tries to access it for the first time.
     * Note that the member is static and final. Only 1 copy of this can exist.
     * <p>
     * The <code>volatile</code> forces threads to ALWAYS get the latest version of the variable.
     */
    private volatile static ClassicLazySingletonUsingDoubleCheckedLocking SINGLE_INSTANCE;

    /**
     * Lock down the constructor to prevent Client's from creating instance of this class
     */
    private ClassicLazySingletonUsingDoubleCheckedLocking() {
    }

    /**
     * Returns the lazily created single instance of this class.
     *
     * @return single instance of this class.
     */
    public static ClassicLazySingletonUsingDoubleCheckedLocking getInstance() {
        // 1st check is not synchronized, so we don't get performance hit of going for the mutex;
        // 99.9999999999% of time the object will be created
        if (SINGLE_INSTANCE == null) {
            // Not created the object yet, so go for class level mutex to block other Clients...
            synchronized (ClassicLazySingletonUsingDoubleCheckedLocking.class) {
                // double check - some other thread might sneaked in and created the instance in the meantime
                if (SINGLE_INSTANCE == null) {
                    SINGLE_INSTANCE = new ClassicLazySingletonUsingDoubleCheckedLocking();
                }
            }
        }

        // most of the time we just drop straight down to here and return the single instance
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
