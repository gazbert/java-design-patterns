package com.gazbert.patterns.creational.abstractfactory.product;

/**
 * 
 * @author gazbert
 *
 */
public class TaxableInvestmentFund implements Product {

    @Override
    public String getProductDetails() {
	
	return "Taxable OEIC details...";
    }
}
