package com.gazbert.patterns.structural.proxy;

/**
 * Proxy for guest user
 *
 * @author ramazansakin
 */
public class GuestUser implements User {

	@Override
	public void checkOut() {
		System.out.println("User unauthorized. Delegeting to Registration Page...");
	}

}