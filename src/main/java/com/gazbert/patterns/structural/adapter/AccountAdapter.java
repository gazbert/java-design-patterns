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

package com.gazbert.patterns.structural.adapter;

import java.math.BigDecimal;
import java.math.MathContext;

import com.gazbert.patterns.structural.adapter.thirdparty.OffshoreAccount;

/**
 * Our adapter class.
 * <p>
 * AbstractAccount is the class we are adapting to - we extend from this class.
 * <p>
 * OffshoreAccount is the class we are adapting from - we wrap this class.
 * <p>
 *
 * @author gazbert
 */
public class AccountAdapter extends AbstractAccount {

    /**
     * The class we are adapting from
     */
    private OffshoreAccount classBeingAdapted;

    /**
     * Constructor takes the class we are going to adapt as an argument.
     *
     * @param offShoreAccount the 3rd party API class we are going to adapt from.
     */
    public AccountAdapter(OffshoreAccount offShoreAccount) {
        // pull the class into out hierarchy by adapting the diff methods names
        super(offShoreAccount.getGrossBalance(), offShoreAccount.canHaveNegativeBalance());

        // keep a reference to it for later
        this.classBeingAdapted = offShoreAccount;
    }

    /**
     * For the offshore account, we have to deduct the tax owed for that country when
     * making the balance calculation.
     */
    @Override
    public BigDecimal getBalance() {

        // get the tax hit from our adapted class
        final BigDecimal taxRate = classBeingAdapted.getOffshoreTaxRate();
        final BigDecimal grossBalance = super.getBalance();

        final BigDecimal taxableBalance = grossBalance.multiply(taxRate);
        final BigDecimal balanceAfterTax = grossBalance.subtract(taxableBalance, MathContext.DECIMAL32);

        return balanceAfterTax;
    }
}
