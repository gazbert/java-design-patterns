package com.gazbert.patterns.creational.staticfactorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gazbert.patterns.creational.factorymethod.products.Product;
import com.gazbert.patterns.creational.staticfactorymethod.InvestmentFundFactory;


/**
 * Demonstrates use of Static Factory Method / Simple Factory pattern.
 * 
 * @author gazbert
 *
 */
public class TestStaticFactoryMethodPattern 
{
    /**
     * Build some investment fund products.
     * 
     * Note that we do not need to fuss with Concrete Factories anymore; we use the static 
     * factor method directly.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreatingInvestmentFundProducts() throws Exception 
    {
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
   
