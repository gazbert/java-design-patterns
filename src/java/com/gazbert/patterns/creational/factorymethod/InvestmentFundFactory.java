package com.gazbert.patterns.creational.factorymethod;

import com.gazbert.patterns.creational.factorymethod.products.Gilt;
import com.gazbert.patterns.creational.factorymethod.products.InvestmentTrust;
import com.gazbert.patterns.creational.factorymethod.products.Oeic;
import com.gazbert.patterns.creational.factorymethod.products.Product;

/**
 * Concrete factory implementation for building investment fund Products, e.g.
 * OEICs, Gilts, Investment Trusts
 * 
 * @author gazbert
 *
 */
public class InvestmentFundFactory extends InvestmentFactory {

    @Override
    protected Product createProduct(final ProductType productType) {
	
	if (productType == ProductType.GILT)
	{
	    return new Gilt();
	}
	else if (productType == ProductType.OEIC)
	{
	    return new Oeic();
	}
	else if (productType == ProductType.INVESTMENT_TRUST)
	{
	    return new InvestmentTrust();
	}
	else
	{
	    throw new IllegalArgumentException("Can't build unknown productType: " + productType);
	}	
    }
}
