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
import java.util.Arrays;
import java.util.List;

/**
 * The UK FTSE All Share Tracker Fund and its implementation of the template method hooks.
 *
 * @author gazbert
 */
public class UkAllShareTrackingFund extends FundInfoCollectionTemplate {

    @Override
    protected String getFundName() {
        return "UK All Share Index Tracker";
    }

    @Override
    protected String getFundType() {
        return "OEIC";
    }

    @Override
    protected String getFundGoal() {
        return "Long term growth from tracking FTSE All Share index";
    }

    @Override
    protected BigDecimal calculateManagementFee() {
        return new BigDecimal(0.01);
    }

    @Override
    protected List<String> getHoldings() {
        final String[] holdings = {"BP", "HSBC", "John Lewis", "Virgin"};
        return Arrays.asList(holdings);
    }
}
