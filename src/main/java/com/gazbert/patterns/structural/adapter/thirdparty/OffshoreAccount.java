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

package com.gazbert.patterns.structural.adapter.thirdparty;

import java.math.BigDecimal;

/**
 * The 3rd party API class - in real-life, we would not have access to the source, probably just the
 * jar file and the Javadoc/user guides.
 * <p>
 * This is the class we are going to adapt.
 *
 * @author gazbert
 */
public class OffshoreAccount {

    private BigDecimal balance;
    private boolean canHaveNegativeBalance;

    /**
     * The tax for the country where the account is held.
     */
    private static final BigDecimal TAX_RATE = new BigDecimal("0.03");

    public OffshoreAccount(BigDecimal size, boolean canHaveNegativeBalance) {
        this.balance = size;
        this.canHaveNegativeBalance = canHaveNegativeBalance;
    }

    public BigDecimal getGrossBalance() {

        return balance;
    }

    public BigDecimal getOffshoreTaxRate() {

        return TAX_RATE;
    }

    public boolean canHaveNegativeBalance() {

        return canHaveNegativeBalance;
    }

    public void creditTheAccount(BigDecimal credit) {
        balance = balance.add(credit);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Balance=" + getGrossBalance() + " -veBalanceAllowed:"
                + canHaveNegativeBalance();
    }
}
