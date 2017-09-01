package com.thomson.jcip.ch6.execution.travelsite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 旅游门户网站
 *
 * @author Thomson Tang
 * @version Created: 01/09/2017.
 */
public class TravelSite {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public List<TravelQuote> getRankedTravelQuotes(TravelInfo info, Set<TravelCompany> companies,
                                                   Comparator<TravelQuote> ranking, long time, TimeUnit unit) throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companies) {
            tasks.add(new QuoteTask(company, info));
        }

        List<Future<TravelQuote>> futures = executor.invokeAll(tasks, time, unit);

        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> iterator = tasks.iterator();
        for (Future<TravelQuote> quoteFuture : futures) {
            QuoteTask task = iterator.next();
            try {
                quotes.add(quoteFuture.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
                quotes.add(task.getTimeoutQuote(e));
            }
        }
        quotes.sort(ranking);
        return quotes;
    }
}
