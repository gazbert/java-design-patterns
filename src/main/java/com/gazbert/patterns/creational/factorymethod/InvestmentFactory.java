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

import com.gazbert.patterns.creational.factorymethod.products.Product;

/**
 * This is the abstract factory the Client code uses to build different Product types.
 * <p>
 * Concrete factories subclass this to build/instantiate the actual Product objects.
 *
 * @author gazbert
 */
public abstract class InvestmentFactory {

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

    /**
     * This is the business method for the Client code to call to create Products.
     * <p>
     * FYI: An ISA (individual Savings Account) is a tax free investment vehicle used in the UK.
     *
     * @param forUseInAnIsa true is this is used in an ISA, false otherwise.
     * @param productType   the Product type to build.
     * @return the built Product.
     */
    public Product build(boolean forUseInAnIsa, ProductType productType) {
        final Product product = createProduct(productType);
        product.setIsTaxable(!forUseInAnIsa);
        return product;
    }

    /**
     * This is the 'Factory Method' that all concrete factory subclasses must implement to return the Product
     * that they build.
     * <p>
     * Note that the method is protected and only visible to subclass factories.
     *
     * @param productType the type of product to build.
     * @return the built Product.
     */
    protected abstract Product createProduct(ProductType productType);
}
