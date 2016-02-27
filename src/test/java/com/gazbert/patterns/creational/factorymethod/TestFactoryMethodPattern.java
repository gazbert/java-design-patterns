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

package com.gazbert.patterns.creational.factorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gazbert.patterns.creational.factorymethod.products.Product;


/**
 * Demonstrates use of Factory Method pattern.
 *
 * @author gazbert
 */
public class TestFactoryMethodPattern {

    /**
     * Build some investment fund products.
     */
    @Test
    public void testCreatingInvestmentFundProducts() throws Exception {

        final InvestmentFactory investmentFactory = new InvestmentFundFactory();

        final Product oeic = investmentFactory.build(true, InvestmentFactory.ProductType.OEIC);
        assertFalse(oeic.isTaxable());
        assertTrue(oeic.getProductDetails().equals("OEIC"));

        final Product gilt = investmentFactory.build(true, InvestmentFactory.ProductType.GILT);
        assertFalse(gilt.isTaxable());
        assertTrue(gilt.getProductDetails().equals("Gilt"));

        final Product trust = investmentFactory.build(false, InvestmentFactory.ProductType.INVESTMENT_TRUST);
        assertTrue(trust.isTaxable()); // trusts cannot be in ISA
        assertTrue(trust.getProductDetails().equals("Investment Trust"));
    }

    /**
     * Build some cash savings products.
     */
    @Test
    public void testCreatingSavingsInvestmentProducts() throws Exception {

        final InvestmentFactory investmentFactory = new InvestmentSavingsFactory();

        final Product cash = investmentFactory.build(true, InvestmentFactory.ProductType.CASH_SAVINGS_ACCOUNT);
        assertFalse(cash.isTaxable());
        assertTrue(cash.getProductDetails().equals("Savings Deposit Account"));

        final Product bond = investmentFactory.build(true, InvestmentFactory.ProductType.GUARANTEED_INCOME_BOND);
        assertFalse(bond.isTaxable());
        assertTrue(bond.getProductDetails().equals("Guaranteed Income Bond"));
    }
}
