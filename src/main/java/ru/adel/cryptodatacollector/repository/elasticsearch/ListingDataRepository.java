package ru.adel.cryptodatacollector.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;

public interface ListingDataRepository extends ElasticsearchRepository<ListingData,String> {

}
