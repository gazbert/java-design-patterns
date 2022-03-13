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

package com.gazbert.patterns.structural.facade;

/**
 * The trading facade.
 * <p>
 * Use Case: Imagine a trader has clicked on the Buy button and the Exchange UI component is about
 * to trigger the trade...
 *
 * @author gazbert
 */
public class TradingFacade {

    /**
     * Without this facade, the Exchange UI component would have to know about and call all the different
     * subsystems to execute the trade.... zzzz.... ;-)
     * <p>
     * This example is <em>massively</em> simplified, but you get the idea!
     *
     * @param trade the trade details.
     */
    public void executeBuyOrder(TradeDetails trade) {
        final TradingEngine tradingEngine = new TradingEngine();
        tradingEngine.fillBuyOrder(trade);
        tradingEngine.fillSellOrder(trade);

        final MarketMaker marketMaker = new MarketMaker();
        marketMaker.updateMarketMakingStrategy(trade);

        final ReconciliationSystem recoSystem = new ReconciliationSystem();
        recoSystem.balanceTheExchangeBooks(trade);

        final RiskAndControlSystem riskAndControl = new RiskAndControlSystem();
        riskAndControl.updateClientCreditScore(trade);

        final SettlementSystem settlements = new SettlementSystem();
        settlements.settle(trade);

        final RegulatorySystem regs = new RegulatorySystem();
        regs.auditTrade(trade);

        final SalesAndMarketingSystem sales = new SalesAndMarketingSystem();
        sales.updateCampaignBooks(trade);
    }
}
