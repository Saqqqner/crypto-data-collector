package ru.adel.cryptodatacollector.client.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.adel.cryptodatacollector.model.crypto.ResponseAPI;
import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;
import ru.adel.cryptodatacollector.service.elasticseach.ElasticSearchService;

import java.util.List;

@Component
public class ListingDataToElasticAction implements ApiClientAction {
    private ElasticSearchService elasticSearchListingService;
    private ObjectMapper objectMapper;


    public ListingDataToElasticAction(ElasticSearchService elasticSearchListingService) {
        this.elasticSearchListingService = elasticSearchListingService;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void performAction(String data) {
        try {
            ResponseAPI<List<ListingData>> response = objectMapper.readValue(data, new TypeReference<ResponseAPI<List<ListingData>>>() {});
            List<ListingData> listingDataList = response.data();
            elasticSearchListingService.saveAllData(listingDataList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
