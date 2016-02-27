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

package com.gazbert.patterns.creational.staticfactorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gazbert.patterns.creational.factorymethod.products.Product;
import com.gazbert.patterns.creational.staticfactorymethod.InvestmentFundFactory;

/**
 * Demonstrates use of Static Factory Method / Simple Factory pattern.
 *
 * @author gazbert
 */
public class TestStaticFactoryMethodPattern {

    /**
     * Build some investment fund products.
     * <p>
     * Note that we do not need to fuss with Concrete Factories anymore; we use the static
     * factor method directly.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreatingInvestmentFundProducts() throws Exception {
        final Product oeic = InvestmentFundFactory.build(true, InvestmentFundFactory.ProductType.OEIC);
        assertFalse(oeic.isTaxable());
        assertTrue(oeic.getProductDetails().equals("OEIC"));

        final Product gilt = InvestmentFundFactory.build(true, InvestmentFundFactory.ProductType.GILT);
        assertFalse(gilt.isTaxable());
        assertTrue(gilt.getProductDetails().equals("Gilt"));

        final Product trust = InvestmentFundFactory.build(false, InvestmentFundFactory.ProductType.INVESTMENT_TRUST);
        assertTrue(trust.isTaxable()); // trusts cannot be in ISA
        assertTrue(trust.getProductDetails().equals("Investment Trust"));

        // Now try building something illegal
        InvestmentFundFactory.build(false, InvestmentFundFactory.ProductType.CASH_SAVINGS_ACCOUNT);
    }
}
   
