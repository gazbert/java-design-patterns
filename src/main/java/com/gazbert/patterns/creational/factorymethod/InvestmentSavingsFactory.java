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

import com.gazbert.patterns.creational.factorymethod.products.GuaranteedIncomeBond;
import com.gazbert.patterns.creational.factorymethod.products.Product;
import com.gazbert.patterns.creational.factorymethod.products.SavingsDepositAccount;

/**
 * Concrete factory implementation for building investment savings Products, e.g.
 * Building Society accounts, Guaranteed Income Bonds, Premium Bonds
 *
 * @author gazbert
 */
public class InvestmentSavingsFactory extends InvestmentFactory {

    @Override
    protected Product createProduct(ProductType productType) {

        if (productType == ProductType.GUARANTEED_INCOME_BOND) {
            return new GuaranteedIncomeBond();
        } else if (productType == ProductType.CASH_SAVINGS_ACCOUNT) {
            return new SavingsDepositAccount();
        } else {
            throw new IllegalArgumentException("Can't build unknown productType: " + productType);
        }
    }
}
