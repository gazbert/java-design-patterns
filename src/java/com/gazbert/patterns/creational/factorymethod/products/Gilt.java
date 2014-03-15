package com.gazbert.patterns.creational.factorymethod.products;

/**
 * A gilt (UK government bonds)
 * 
 * @author gazbert
 *
 */
public class Gilt extends BaseProduct {

    @Override
    public String getProductDetails() {
	
	return "Gilt";
    }
}
