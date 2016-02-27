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
import com.gazbert.patterns.creational.abstractfactory.account.StandardAccount;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.address.DomicileAddress;
import com.gazbert.patterns.creational.abstractfactory.product.Product;
import com.gazbert.patterns.creational.abstractfactory.product.TaxableInvestmentFund;

/**
 * Concrete factory for creating our objects for the Onshore Investment Customer 'family'.
 *
 * @author gazbert
 */
public class OnshoreInvestmentCustomerFactory extends AbstractCustomerFactory {

    @Override
    public Address createAddress() {

        // UK address
        return new DomicileAddress();
    }

    @Override
    public Account createAccount() {

        // onshore customers have standard accounts
        return new StandardAccount();
    }

    @Override
    public Product createProduct() {

        // and they're taxed
        return new TaxableInvestmentFund();
    }
}
