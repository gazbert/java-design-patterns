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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Demonstrates use of Singleton pattern.
 *
 * @author gazbert
 */
public class TestSingletonPattern {
    /**
     * Shows using an enum as a Singleton.
     */
    @Test
    public void testUsingEnumSingleton() throws Exception {

        final SingletonUsingEnum firstAccessAttempt = SingletonUsingEnum.SINGLE_INSTANCE;
        final SingletonUsingEnum secondAccessAttempt = SingletonUsingEnum.SINGLE_INSTANCE;

        // Same object? Hope so!
        assertTrue(firstAccessAttempt == secondAccessAttempt); // reference same object
        assertTrue(firstAccessAttempt.equals(secondAccessAttempt)); // and equality the same in this case

        // Use the Singleton to so something that mandates only 1 instance of the class e.g
        // for controlling sequential access to writing a log file
        firstAccessAttempt.log("Logging some data...");
    }

    /**
     * Shows the 'classic' way of using an <em>eager</em> Singleton.
     */
    @Test
    public void testUsingClassicEagerSingleton() throws Exception {
        final ClassicEagerSingleton firstAccessAttempt = ClassicEagerSingleton.getInstance();
        final ClassicEagerSingleton secondAccessAttempt = ClassicEagerSingleton.getInstance();

        // Same object? Hope so!
        assertTrue(firstAccessAttempt == secondAccessAttempt); // reference same object
        assertTrue(firstAccessAttempt.equals(secondAccessAttempt)); // and equality the same in this case

        // Use the Singleton to so something that mandates only 1 instance of the class e.g
        // for controlling sequential access to writing a log file
        firstAccessAttempt.log("Logging some data...");
    }

    /**
     * Shows the 'classic' way of using an <em>lazy</em> Singleton using Double Checked Locking.
     * <p>
     * NOTE: This technique only works for Java 5 and above.
     */
    @Test
    public void testUsingClassicLazySingletonUsingDoubleCheckedLocking() throws Exception {
        final ClassicLazySingletonUsingDoubleCheckedLocking firstAccessAttempt =
                ClassicLazySingletonUsingDoubleCheckedLocking.getInstance();
        final ClassicLazySingletonUsingDoubleCheckedLocking secondAccessAttempt =
                ClassicLazySingletonUsingDoubleCheckedLocking.getInstance();

        // Same object? Hope so!
        assertTrue(firstAccessAttempt == secondAccessAttempt); // reference same object
        assertTrue(firstAccessAttempt.equals(secondAccessAttempt)); // and equality the same in this case

        // Use the Singleton to so something that mandates only 1 instance of the class e.g
        // for controlling sequential access to writing a log file
        firstAccessAttempt.log("Logging some data...");
    }

    /**
     * Shows the 'classic' way of using an <em>lazy</em> Singleton using synchronized method.
     * <p>
     * NOTE: This technique works on all versions of Java. But, it is less perfomant than the
     * Double Checked Locking approach.
     */
    @Test
    public void testUsingClassicLazySingletonUsingSynchronizedMethod() throws Exception {
        final ClassicLazySingletonUsingSynchronizedMethod firstAccessAttempt =
                ClassicLazySingletonUsingSynchronizedMethod.getInstance();
        final ClassicLazySingletonUsingSynchronizedMethod secondAccessAttempt =
                ClassicLazySingletonUsingSynchronizedMethod.getInstance();

        // Same object? Hope so!
        assertTrue(firstAccessAttempt == secondAccessAttempt); // reference same object
        assertTrue(firstAccessAttempt.equals(secondAccessAttempt)); // and equality the same in this case

        // Use the Singleton to so something that mandates only 1 instance of the class e.g
        // for controlling sequential access to writing a log file
        firstAccessAttempt.log("Logging some data...");
    }
}

