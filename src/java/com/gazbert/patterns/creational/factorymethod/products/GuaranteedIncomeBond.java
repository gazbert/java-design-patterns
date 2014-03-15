package com.gazbert.patterns.creational.factorymethod.products;

/**
 * A guaranteed income bond (UK).
 * 
 * @author gazbert
 *
 */
public class GuaranteedIncomeBond extends BaseProduct {

    @Override
    public String getProductDetails() {
	
	return "Guaranteed Income Bond";
    }
}
