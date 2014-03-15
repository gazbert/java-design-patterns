package com.gazbert.patterns.creational.factorymethod;

import com.gazbert.patterns.creational.factorymethod.products.GuaranteedIncomeBond;
import com.gazbert.patterns.creational.factorymethod.products.Product;
import com.gazbert.patterns.creational.factorymethod.products.SavingsDepositAccount;

/**
 * Concrete factory implementation for building investment savings Products, e.g.
 * Building Society accounts, Guaranteed Income Bonds, Premium Bonds
 * 
 * @author gazbert
 *
 */
public class InvestmentSavingsFactory extends InvestmentFactory {

    @Override
    protected Product createProduct(final ProductType productType) {
	
	if (productType == ProductType.GUARANTEED_INCOME_BOND)
	{
	    return new GuaranteedIncomeBond();
	}
	else if (productType == ProductType.CASH_SAVINGS_ACCOUNT)
	{
	    return new SavingsDepositAccount();
	}
	else
	{
	    throw new IllegalArgumentException("Can't build unknown productType: " + productType);
	}	
    }
}
