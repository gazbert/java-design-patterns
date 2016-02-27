/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.patterns.structural.adapter;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gazbert.patterns.structural.adapter.thirdparty.OffshoreAccount;

/**
 * Demonstrates use of Adapter pattern.
 * <p>
 * We create a couple of accounts using our own organisation's code, then we create an OffshoreAccount using
 * 3rd party API class. We adapt this in order to get the balance required for Clients to use in our
 * organisation's system.
 * <p>
 * The OffshoreAccount is the 3rd party API - assume we only have the jar file and Javadoc.
 *
 * @author gazbert
 */
public class TestAdapterPattern {

    /**
     *
     */
    @Test
    public void testAdapterPattern() {

        // Create our internal accounts
        final StandardAccount standardAccount = new StandardAccount(new BigDecimal("7000"));
        final BigDecimal initialStandardAccountBalance = standardAccount.getBalance();
        final PlatinumAccount platinumAccount = new PlatinumAccount(new BigDecimal("1000000"));
        final BigDecimal initialPlatinumAccountBalance = platinumAccount.getBalance();

        // add them into our reconciliation 'system'
        final List<Account> accounts = new ArrayList<>();
        accounts.add(standardAccount);
        accounts.add(platinumAccount);

        // Create our 3rd party API class to be adapted
        final OffshoreAccount offsoreAccount = new OffshoreAccount(new BigDecimal("10000000"), false);

        // Adapt the class using our adapter and add it to the reco system
        final AccountAdapter adaptedOffshoreAccount = new AccountAdapter(offsoreAccount);
        final BigDecimal initialOffshoreAccountBalance = adaptedOffshoreAccount.getBalance();
        accounts.add(adaptedOffshoreAccount);

        // assert the initial balances are as expected
        assertEquals(new BigDecimal("7000"), initialStandardAccountBalance);
        assertEquals(new BigDecimal("1000000"), initialPlatinumAccountBalance);
        assertEquals(new BigDecimal("9700000"), initialOffshoreAccountBalance);    // 0.03% tax deduction

        // Credit all the accounts
        final BigDecimal amountToCredit = new BigDecimal(500);
        for (final Account account : accounts) {
            System.out.println(account);
            account.creditAccount(amountToCredit);
        }

        // expected credited balances
        final BigDecimal expectedCreditedStandardAccountBalance = initialStandardAccountBalance.add(amountToCredit);
        final BigDecimal expectedCreditedPlatinumAccountBalance = initialPlatinumAccountBalance.add(amountToCredit);

        // assert the credited balances are as expected
        assertEquals(expectedCreditedStandardAccountBalance, standardAccount.getBalance());
        assertEquals(expectedCreditedPlatinumAccountBalance, platinumAccount.getBalance());
        assertEquals(new BigDecimal("9700485"), adaptedOffshoreAccount.getBalance()); // 0.03% tax on $500 credit :-(

        System.out.println();
        System.out.println("*** Credited accounts ***");
        System.out.println();

        // Check the new balances - note the OffshoreAccount (AccountAdapter) has a funky balance value thanks to the
        // adaptation code tweaking it for the tax hit...
        accounts.forEach(System.out::println);
    }
}
