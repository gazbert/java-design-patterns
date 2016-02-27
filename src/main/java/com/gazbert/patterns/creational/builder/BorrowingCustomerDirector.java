
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
 * Concrete Director impl for assembling a Borrowing Customer.
 * <p>
 * The Director decides what builder methods to call and in what order.
 * <p>
 * Tells the Builder what to build and at what point to return what it has built to date.
 *
 * @author gazbert
 */
public class BorrowingCustomerDirector extends AbstractCustomerDirector {

    @Override
    public Customer build(AbstractCustomerBuilder builder) {

        builder.buildContactDetails();
        builder.buildEmployerDetails();

        // for borrowers only
        builder.buildCreditRatingReport();

        builder.buildSalesOpportunities();
        builder.buildMarketingPreferences();

        return builder.getCustomer();
    }
}
