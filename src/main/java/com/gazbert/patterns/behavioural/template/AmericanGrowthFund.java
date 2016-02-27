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
 * The American Fund and its implementation of the template method hooks.
 *
 * @author gazbert
 */
public class AmericanGrowthFund extends FundInfoCollectionTemplate {

    @Override
    protected String getFundName() {
        return "American Growth";
    }

    @Override
    protected String getFundType() {
        return "Investment Trust";
    }

    @Override
    protected String getFundGoal() {
        return "Long term growth investing in large US companies listed on Dow Jones";
    }

    @Override
    protected BigDecimal calculateManagementFee() {
        return new BigDecimal("0.019");
    }

    protected String getFundCurrency() {
        return "USD";
    }

    @Override
    protected List<String> getHoldings() {
        final String[] holdings = {"IBM", "Bank Of America", "Oracle", "Chevron"};
        return Arrays.asList(holdings);
    }
}
