package com.gazbert.patterns.creational.abstractfactory.product;

/**
 * 
 * @author gazbert
 *
 */
public class TaxExemptInvestmentFund implements Product {

    @Override
    public String getProductDetails() {
	
	return "Investment Trust details... ";
    }
}
