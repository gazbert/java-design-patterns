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

package com.gazbert.patterns.creational.abstractfactory;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.product.Product;

/**
 * This is the Abstract Factory class providing operations that all concrete factory classes must
 * override and implement to build stuff.
 * <p>
 * Yes, this could have been an interface, but the 'abstract class' bit clearly shows we're using
 * the Abstract Factory pattern for the demo here.
 * <p>
 * The Abstract Factory provides the operations for building the family of parts that make up a
 * Customer.
 * <p>
 * One thing to note, the Abstract Factory pattern does <em>not</em> create an actual Customer
 * object; it only creates the (family of) parts that make it up.
 *
 * @author gazbert
 */
public abstract class AbstractCustomerFactory {

  /**
   * Creates an Address object.
   *
   * @return the address.
   */
  public abstract Address createAddress();

  /**
   * Creates an Account object.
   *
   * @return the account.
   */
  public abstract Account createAccount();

  /**
   * Creates a Product object.
   *
   * @return the product.
   */
  public abstract Product createProduct();

  // etc etc etc.... more ops defined....
}
