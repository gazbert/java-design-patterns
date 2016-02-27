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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.product.Product;

/**
 * Demonstrates use of Abstract Factory pattern.
 *
 * @author gazbert
 */
public class TestAbstractFactoryPattern {
    /**
     * For sake of demo and id'ing what customer to create - the App business logic would decide this
     */
    private static enum CustomerType {
        OFFSHORE_INVESTOR,

        ONSHORE_INVESTOR;
    }

    /**
     * Some previous bit of code logic in the App decides we want to create an Offshore investment customer.
     */
    @Test
    public void testCreatingOffshoreInvestmentCustomer() throws Exception {

        // App logic decides this in real life...
        final CustomerType customerType = CustomerType.OFFSHORE_INVESTOR;

        final AbstractCustomerFactory abstractCustomeFactory;

        if (customerType == CustomerType.ONSHORE_INVESTOR) {
            abstractCustomeFactory = new OnshoreInvestmentCustomerFactory();
        } else if (customerType == CustomerType.OFFSHORE_INVESTOR) {
            abstractCustomeFactory = new OffshoreInvestmentCustomerFactory();
        } else {
            throw new IllegalArgumentException("Unknown customer type: " + customerType);
        }

        // Create the Customer's parts - either and offshore investor or an onshore investor
        final Account account = abstractCustomeFactory.createAccount();
        final Address address = abstractCustomeFactory.createAddress();
        final Product product = abstractCustomeFactory.createProduct();

        // What we got?
        assertTrue(account.getAccountDetails().startsWith("Platinum"));
        assertTrue(address.getAddressDetails().startsWith("Offshore"));
        assertTrue(product.getProductDetails().startsWith("Investment Trust"));
    }

    /**
     * Some previous bit of code logic in the App decides we want to create an Onshore investment customer.
     */
    @Test
    public void testCreatingOnshoreInvestmentCustomer() throws Exception {

        // App logic decides this in real life...
        final CustomerType customerType = CustomerType.ONSHORE_INVESTOR;

        final AbstractCustomerFactory abstractCustomeFactory;

        if (customerType == CustomerType.ONSHORE_INVESTOR) {
            abstractCustomeFactory = new OnshoreInvestmentCustomerFactory();
        } else if (customerType == CustomerType.OFFSHORE_INVESTOR) {
            abstractCustomeFactory = new OffshoreInvestmentCustomerFactory();
        } else {
            throw new IllegalArgumentException("Unknown customer type: " + customerType);
        }

        // Create the Customer's parts - either and offshore investor or an onshore investor
        final Account account = abstractCustomeFactory.createAccount();
        final Address address = abstractCustomeFactory.createAddress();
        final Product product = abstractCustomeFactory.createProduct();

        // What we got?
        assertTrue(account.getAccountDetails().startsWith("Standard"));
        assertTrue(address.getAddressDetails().startsWith("Domicile"));
        assertTrue(product.getProductDetails().startsWith("Taxable OEIC"));
    }
}
