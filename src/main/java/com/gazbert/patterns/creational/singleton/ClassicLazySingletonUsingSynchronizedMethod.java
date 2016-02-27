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
 * The pre Java 5 way of creating <em>lazy</em> singletons.
 * <p>
 * Use this approach if the Singleton has to perform resource/time expensive stuff on instantiation during startup of
 * an application, e.g. booting of app server.
 * <p>
 * NOTE: This technique works on all versions of Java. But, it is less perfomant than the Double Checked Locking
 * approach.
 *
 * @author gazbert
 */
public class ClassicLazySingletonUsingSynchronizedMethod {

    /**
     * We lazily create the object when any Client tries to access it for the first time.
     * Note that the member is static and final. Only 1 copy of this can exist.
     */
    private static ClassicLazySingletonUsingSynchronizedMethod SINGLE_INSTANCE;

    /**
     * Lock down the constructor to prevent Client's from creating instance of this class
     */
    private ClassicLazySingletonUsingSynchronizedMethod() {
    }

    /**
     * Returns the lazily created single instance of this class.
     * <p>
     * NOTE: the entire method is synchronized. More expensive getting the mutex
     * <em>everytime</em> a Client calls this method compared to the Double Check Locking approach.
     *
     * @return single instance of this class.
     */
    public synchronized static ClassicLazySingletonUsingSynchronizedMethod getInstance() {
        if (SINGLE_INSTANCE == null) {
            SINGLE_INSTANCE = new ClassicLazySingletonUsingSynchronizedMethod();
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