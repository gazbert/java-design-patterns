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

package com.gazbert.patterns.creational.builder;

import com.gazbert.patterns.creational.builder.customer.Customer;

/**
 * The Abstract Builder provides all of the different buildXXX methods the Concrete Builders
 * <em>could</em> choose to build for creating a Customer.
 * <p>
 * Also provides a get Customer operations that Concrete Builders <em>must</em> honour.
 *
 * @author gazbert
 */
public abstract class AbstractCustomerBuilder {

    // all customers are built with these    
    public void buildContactDetails() {
    }

    public void buildMarketingPreferences() {
    }

    public void buildSalesOpportunities() {
    }

    public void buildEmployerDetails() {
    }

    // below are 'optional' and not used to build all customers in this demo    
    public void buildRewardsScheme() {
    } // only investors have this

    public void buildCreditRatingReport() {
    } // only borrowers have this

    public void buildTaxationDetails() {
    } // only investors have this

    /**
     * Tells the Concrete Builder to return the Customer (Product) it has built up until now.
     *
     * @return the Customer that has been built.
     */
    public abstract Customer getCustomer();
}
