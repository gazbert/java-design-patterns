package com.gazbert.patterns.creationalstaticfactorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gazbert.patterns.creational.factorymethod.products.Product;
import com.gazbert.patterns.creational.staticfactorymethod.InvestmentFundFactory;


/**
 * Demonstrates use of Static Factory Method pattern.
 * 
 * @author gazbert
 *
 */
public class TestStaticFactoryMethodPattern 
{
    /**
     * Build some investment fund products.
     */
    @Test
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
    }
}
   
