package com.gazbert.patterns.creational.factorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gazbert.patterns.creational.factorymethod.products.Product;


/**
 * Demonstrates use of Factory Method pattern.
 * 
 * @author gazbert
 *
 */
public class TestFactoryMethodPattern 
{
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
