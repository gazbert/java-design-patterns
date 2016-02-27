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

package com.gazbert.patterns.behavioural.template;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * This is the main abstract template class.
 * <p>
 * It uses a template to collect fund information from different ISA providers in order to display
 * them on a 'fund supermarket' website.
 * <p>
 *
 * @author gazbert
 */
public abstract class FundInfoCollectionTemplate {

    // Here we have hooks that subclasses must provide impl for    
    protected abstract String getFundName();

    protected abstract String getFundType();

    protected abstract String getFundGoal();

    protected abstract BigDecimal calculateManagementFee();

    protected abstract List<String> getHoldings();

    // Here we have a hook with a default impl.
    protected String getFundCurrency() {
        // default to stirling
        return "GBP";
    }

    /**
     * This is the main template method that Clients will call.
     * Notice it is final and cannot be overridden.
     */
    public final void collectFundInformationForCatalogue() {
        System.out.println("START of main template method.");

        System.out.println("Fund Name: " + getFundName());
        System.out.println("Fund Type: " + getFundType());
        System.out.println("Fund Goal: " + getFundGoal());
        System.out.println("Fund Currency: " + getFundCurrency());
        System.out.println("Fund Management Fee: " + new DecimalFormat("#.###").format(calculateManagementFee()) + "%");

        System.out.print("Fund Holdings: ");
        final List<String> fundHoldings = getHoldings();
        for (final String stock : fundHoldings) {
            System.out.print(stock + ", ");
        }

        System.out.println("\nEND of main template method.\n");
    }
}
