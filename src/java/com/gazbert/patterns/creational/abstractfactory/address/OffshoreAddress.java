package com.gazbert.patterns.creational.abstractfactory.address;

/**
 * 
 * @author gazbert
 *
 */
public class OffshoreAddress implements Address {

    @Override
    public String getAddressDetails() {
	
	return "Offshore Address details with special 'PO Box' info... ;-)";
    }
}
