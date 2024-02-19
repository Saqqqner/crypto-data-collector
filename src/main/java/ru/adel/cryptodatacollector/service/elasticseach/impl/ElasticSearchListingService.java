package ru.adel.cryptodatacollector.service.elasticseach.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;
import ru.adel.cryptodatacollector.repository.elasticsearch.ListingDataRepository;
import ru.adel.cryptodatacollector.service.elasticseach.ElasticSearchService;

import java.util.List;

@Service
public class ElasticSearchListingService implements ElasticSearchService<ListingData> {
    private ListingDataRepository listingDataRepository;

    public ElasticSearchListingService(ListingDataRepository listingDataRepository) {
        this.listingDataRepository = listingDataRepository;
    }


    @Override
    public List<ListingData> getData(int start, int limit) {
        Pageable pageable = PageRequest.of(start, limit);
        Page<ListingData> listingDataPage = listingDataRepository.findAll(pageable);
        return listingDataPage.getContent();
    }
    @Override
    public void saveData(ListingData data) {
        listingDataRepository.save(data);
    }
    @Override
    public void saveAllData(List<ListingData> listingData){
        listingDataRepository.saveAll(listingData);
    }
}
