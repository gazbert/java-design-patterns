package com.gazbert.patterns.structural.proxy;

import org.junit.Test;

/**
 * Demonstrates use of Proxy pattern.
 *
 * @author ramazansakin
 */
public class TestProxyPattern {

	/**
	 * Detecting authorized user via proxy sample test
	 *
	 * @author ramazansakin
	 */
	@Test
	public void testUserProxy() {

		User authUser = new AuthorizedUser();
		authUser.checkOut();

		User guest = new GuestUser();
		guest.checkOut();
	}

}
