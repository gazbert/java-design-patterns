package com.gazbert.patterns.creational.abstractfactory.address;

/**
 * 
 * @author gazbert
 *
 */
public class DomicileAddress implements Address {

    @Override
    public String getAddressDetails() {
	
	return "Domicile Address details with UK specific bit n pieces";
    }
}
