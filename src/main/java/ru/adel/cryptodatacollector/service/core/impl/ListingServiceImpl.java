package ru.adel.cryptodatacollector.service.core.impl;

import org.springframework.stereotype.Service;
import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;
import ru.adel.cryptodatacollector.service.elasticseach.ElasticSearchService;
import ru.adel.cryptodatacollector.service.core.ListingService;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {
    private ElasticSearchService elasticSearchListingService;

    public ListingServiceImpl(ElasticSearchService elasticSearchListingService) {
        this.elasticSearchListingService = elasticSearchListingService;
    }

    @Override
    public List<ListingData> getLatestListings(int start, int limit) {
        List<ListingData> listingData = elasticSearchListingService.getData(start, limit);
        return listingData;
    }
}
