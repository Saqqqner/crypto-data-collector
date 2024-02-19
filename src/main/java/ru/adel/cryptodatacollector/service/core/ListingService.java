package ru.adel.cryptodatacollector.service.core;

import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;

import java.util.List;

public interface ListingService {
    List<ListingData> getLatestListings(int start, int limit);
}
