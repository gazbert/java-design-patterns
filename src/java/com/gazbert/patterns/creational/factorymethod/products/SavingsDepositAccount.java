package com.gazbert.patterns.creational.factorymethod.products;

/**
 * A deposit account for savings e.g. a UK Building Society account
 * 
 * @author gazbert
 *
 */
public class SavingsDepositAccount extends BaseProduct {

    @Override
    public String getProductDetails() {
	
	return "Savings Deposit Account";
    }
}
