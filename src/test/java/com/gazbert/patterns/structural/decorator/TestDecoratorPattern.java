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

package com.gazbert.patterns.structural.decorator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Demonstrates use of Decorator pattern.
 *
 * @author gazbert
 */
public class TestDecoratorPattern {

    /**
     * This is how things work before we add/use the decorator.
     */
    @Test
    public void testNonDecoratedAccountBehaviour() {

        final Account stockbrokingAccount = new StockbrokingAccount();
        assertEquals(StockbrokingAccount.class.getSimpleName(), stockbrokingAccount.getType());
        assertEquals(0, stockbrokingAccount.getBalance().intValue());

        // top up the account
        final BigDecimal amountToCredit = new BigDecimal("5000");
        stockbrokingAccount.credit(amountToCredit);
        assertEquals(amountToCredit, stockbrokingAccount.getBalance());
    }

    /**
     * ISA trading accounts are have lowest broker fees.
     */
    @Test
    public void testIsaStockbrokingAccountBehaviour() {

        // Create the Concrete Component as before
        final Account stockbrokingAccount = new StockbrokingAccount();
        assertEquals(StockbrokingAccount.class.getSimpleName(), stockbrokingAccount.getType());
        assertEquals(0, stockbrokingAccount.getBalance().intValue());

        // Now create the Concrete Decorator
        final IsaAccount isaBrokerAccount = new IsaAccount(stockbrokingAccount);
        assertEquals(IsaAccount.class.getSimpleName(), isaBrokerAccount.getType());

        // Credit the account like before
        final BigDecimal amountToCredit = new BigDecimal("5000");
        isaBrokerAccount.credit(amountToCredit);

        // expect low fees
        final BigDecimal brokerFee = amountToCredit.multiply(new BigDecimal("0.1")); // constant in IsaAccount
        final BigDecimal creditAfterFee = amountToCredit.subtract(brokerFee);
        assertEquals(creditAfterFee, isaBrokerAccount.getBalance());
    }

    /**
     * Standard trading accounts are have lowest broker fees.
     */
    @Test
    public void testStandardStockbrokingAccountBehaviour() {

        // Create the Concrete Component as before
        final Account stockbrokingAccount = new StockbrokingAccount();
        assertEquals(StockbrokingAccount.class.getSimpleName(), stockbrokingAccount.getType());
        assertEquals(0, stockbrokingAccount.getBalance().intValue());

        // Now create the Concrete Decorator
        final StandardAccount standardBrokerAccount = new StandardAccount(stockbrokingAccount);
        assertEquals(StandardAccount.class.getSimpleName(), standardBrokerAccount.getType());

        // Credit the account like before
        final BigDecimal amountToCredit = new BigDecimal("5000");
        standardBrokerAccount.credit(amountToCredit);

        // expect low fees
        final BigDecimal brokerFee = amountToCredit.multiply(new BigDecimal("0.3")); // constant in StandardAccount
        final BigDecimal creditAfterFee = amountToCredit.subtract(brokerFee);
        assertEquals(creditAfterFee, standardBrokerAccount.getBalance());
    }

    /**
     * Offshore trading accounts are have lowest broker fees.
     */
    @Test
    public void testOffshoreStockbrokingAccountBehaviour() {

        // Create the Concrete Component as before
        final Account stockbrokingAccount = new StockbrokingAccount();
        assertEquals(StockbrokingAccount.class.getSimpleName(), stockbrokingAccount.getType());
        assertEquals(0, stockbrokingAccount.getBalance().intValue());

        // Now create the Concrete Decorator
        final OffshoreAccount offshoreBrokerAccount = new OffshoreAccount(stockbrokingAccount);
        assertEquals(OffshoreAccount.class.getSimpleName(), offshoreBrokerAccount.getType());

        // Credit the account like before
        final BigDecimal amountToCredit = new BigDecimal("5000");
        offshoreBrokerAccount.credit(amountToCredit);

        // expect low fees
        final BigDecimal brokerFee = amountToCredit.multiply(new BigDecimal("0.5")); // constant in OffshoreAccount
        final BigDecimal creditAfterFee = amountToCredit.subtract(brokerFee);
        assertEquals(creditAfterFee, offshoreBrokerAccount.getBalance());
    }
}
