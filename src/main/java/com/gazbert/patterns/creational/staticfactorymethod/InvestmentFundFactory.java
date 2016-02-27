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

import com.gazbert.patterns.creational.factorymethod.products.Gilt;
import com.gazbert.patterns.creational.factorymethod.products.InvestmentTrust;
import com.gazbert.patterns.creational.factorymethod.products.Oeic;
import com.gazbert.patterns.creational.factorymethod.products.Product;

/**
 * This is the abstract factory the Client code uses to build different Product types.
 * <p>
 * It is a <em>simple</em> factory that contains a <em>static</em> factory method.
 * <p>
 * The 'factory method' is not abstract like in the traditional Factory Method pattern; it builds/instantiates
 * the actual Product objects. It eliminates the need for creating separate Concrete Factory subclass impls.
 * <p>
 * Clients use this static factory method directly.
 *
 * @author gazbert
 */
public abstract class InvestmentFundFactory {

    /**
     * Some sample financial investment products for purposes of the demo
     */
    public enum ProductType {
        OEIC,
        GILT,
        INVESTMENT_TRUST,
        CASH_SAVINGS_ACCOUNT,
        GUARANTEED_INCOME_BOND
    }

    ;

    // lockdown
    private InvestmentFundFactory() {
    }

    /**
     * This is the business method for the Client code to call to create Products.
     * <p>
     * This is also the static 'Factory Method' that builds the Products. Clients call this directly.
     * <p>
     * FYI: An ISA (individual Savings Account) is a tax free investment vehicle used in the UK.
     *
     * @param forUseInAnIsa true is this is used in an ISA, false otherwise.
     * @param productType   the Product type to build.
     * @return the built Product.
     */
    public static Product build(boolean forUseInAnIsa, ProductType productType) {
        final Product product;

        if (productType == ProductType.GILT) {
            product = new Gilt();
        } else if (productType == ProductType.OEIC) {
            product = new Oeic();
        } else if (productType == ProductType.INVESTMENT_TRUST) {
            product = new InvestmentTrust();
        } else {
            throw new IllegalArgumentException("Can't build unknown productType: " + productType);
        }

        product.setIsTaxable(!forUseInAnIsa);
        return product;
    }
}
