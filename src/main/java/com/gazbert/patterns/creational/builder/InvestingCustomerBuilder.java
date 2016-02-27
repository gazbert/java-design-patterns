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
import com.gazbert.patterns.creational.builder.customer.InvestingCustomer;

/**
 * Concrete Builder for building an Investing Customer.
 * <p>
 * TODO - The common buildXXX methods could be pushed up into the AbstractCustomerBuilder...
 *
 * @author gazbert
 */
public class InvestingCustomerBuilder extends AbstractCustomerBuilder {

    /**
     * The Product we are going to build
     */
    private InvestingCustomer investingCustomerToBuild;

    public InvestingCustomerBuilder(final InvestingCustomer customer) {
        investingCustomerToBuild = customer;
    }

    @Override
    public Customer getCustomer() {

        return investingCustomerToBuild;
    }

    public void buildContactDetails() {
        System.out.println("Building contact details - performing database lookup...");
        // E.g. database lookup SELECT * FROM Address WHERE CustomerID = 'blabla';
        // Only stubbing the Address, the other buildXXX methods would so something similar...
        investingCustomerToBuild.setAddress(new Address());
    }

    public void buildMarketingPreferences() {
        System.out.println("Building Market preferences...");
    }

    public void buildSalesOpportunities() {
        System.out.println("Building future Sales leads...");
    }

    public void buildRewardsScheme() {
        System.out.println("Building Customer rewards scheme - making REST service call to Loyalty Scheme...");
    }

    public void buildEmployerDetails() {
        System.out.println("Building Employer details...");
    }

    public void buildTaxationDetails() {
        System.out.println("Building Taxation details - making IRS REST service call...");
    }

    /* We don't bother building this - no need for credit report for investors */
    //    public void buildCreditRatingReport()
    //    {
    //	System.out.println("Building Credit rating report");
    //    }

}
