package ru.adel.cryptodatacollector.client.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.adel.cryptodatacollector.client.CoinMarketCapApiClient;
import ru.adel.cryptodatacollector.client.action.ApiClientAction;
import ru.adel.cryptodatacollector.client.util.ApiClientContext;

@Component
public class ListingDataScheduler implements DataScheduler {
    private static String LISTINGS_URL = "/v1/cryptocurrency/listings/latest?start=1&limit=20";
    private CoinMarketCapApiClient coinMarketCapApiClient;
    private ApiClientContext clientContext;
    private ApiClientAction listingDataToElasticAction;


    public ListingDataScheduler(CoinMarketCapApiClient coinMarketCapApiClient,
                                ApiClientContext clientContext,
                                ApiClientAction listingDataToElasticAction) {
        this.coinMarketCapApiClient = coinMarketCapApiClient;
        this.clientContext = clientContext;
        this.listingDataToElasticAction = listingDataToElasticAction;

        clientContext.setAction(listingDataToElasticAction);
        clientContext.setUrl(LISTINGS_URL);
    }

    @Override
    @Scheduled(fixedDelayString = "${coinmarketcap.api.scheduler.pollingIntervalMillis}")
    public void collectDataPeriodically() {
        coinMarketCapApiClient.collectData(clientContext);
    }

}
