package com.thomson.jcip.ch6.execution.travelsite;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/**
 * 报价任务
 *
 * @author Thomson Tang
 * @version Created: 01/09/2017.
 */
public class QuoteTask implements Callable<TravelQuote> {
    private final TravelCompany company;
    private final TravelInfo travelInfo;

    public QuoteTask(TravelCompany company, TravelInfo travelInfo) {
        this.company = company;
        this.travelInfo = travelInfo;
    }

    @Override
    public TravelQuote call() throws Exception {
        return company.solicitQuote(travelInfo);
    }

    public TravelQuote getFailureQuote(Throwable cause) {
        return null;
    }

    public TravelQuote getTimeoutQuote(CancellationException e) {
        return null;
    }
}
