package com.gazbert.patterns.structural.proxy;

/**
 * Authorization handling via user proxy
 *
 * @author ramazansakin
 */
public class UserProxyHandler implements UserProxy{

	private boolean isLoggedIn;

	public UserProxyHandler(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public User getUser() {
		User user;
		if (isLoggedIn) {
			user = new AuthorizedUser();
		} else {
			user = new GuestUser();
		}
		return user;
	}
}