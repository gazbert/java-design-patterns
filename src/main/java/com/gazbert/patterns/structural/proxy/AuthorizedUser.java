package com.gazbert.patterns.structural.proxy;

/**
 * Proxy for authorized user
 *
 * @author ramazansakin
 */
public class AuthorizedUser implements User {

	@Override
	public void checkOut() {
		System.out.println("User authorized. Logging in...");
	}

}