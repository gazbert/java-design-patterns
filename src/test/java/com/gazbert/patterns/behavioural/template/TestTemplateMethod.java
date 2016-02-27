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

import org.junit.Test;

/**
 * Demonstrates use of Template Method.
 * <p>
 *
 * @author gazbert
 */
public class TestTemplateMethod {

    /**
     * Collects fund information for an online fund supermarket catalogue.
     * TODO - assert something ;-)
     */
    @Test
    public void collectFundDetails() {

        final FundInfoCollectionTemplate americanGrowth = new AmericanGrowthFund();
        americanGrowth.collectFundInformationForCatalogue();

        final FundInfoCollectionTemplate ukAllShareTracker = new UkAllShareTrackingFund();
        ukAllShareTracker.collectFundInformationForCatalogue();

        final FundInfoCollectionTemplate japaneseSpecialSits = new JapanSpecialSituationsFund();
        japaneseSpecialSits.collectFundInformationForCatalogue();

        final FundInfoCollectionTemplate ukMidCaps = new UkMidCapEquityFund();
        ukMidCaps.collectFundInformationForCatalogue();
    }
}
