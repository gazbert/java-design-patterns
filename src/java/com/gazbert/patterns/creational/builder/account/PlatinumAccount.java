package com.gazbert.patterns.creational.builder.account;

import java.math.BigDecimal;

/**
 * Platinum Account holder.
 * 
 * @author gazbert
 *
 */
public class PlatinumAccount extends AbstractAccount {

    public PlatinumAccount(final BigDecimal balance)
    {
        super(balance, true);
    }
}
