package ru.adel.cryptodatacollector.model.crypto.listing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(indexName = "listingdata")
@JsonIgnoreProperties(ignoreUnknown = true)
public record ListingData(
        Integer id,
        String name,
        String symbol,
        String slug,
        @JsonProperty("num_market_pairs") Integer numMarketPairs,
        @JsonProperty("date_added") Date dateAdded,
        List<String> tags,
        @JsonProperty("max_supply") Long maxSupply,
        @JsonProperty("circulating_supply") Double circulatingSupply,
        @JsonProperty("total_supply") Double totalSupply,
        @JsonProperty("infinite_supply") boolean infiniteSupply,
        ListingPlatform platform,
        @JsonProperty("cmc_rank") Integer cmcRank,
        @JsonProperty("self_reported_circulating_supply") Double selfReportedCirculatingSupply,
        @JsonProperty("self_reported_market_supply") Double selfReportedMarketSupply,
        @JsonProperty("tvl_ratio") Double tvlRatio,
        @JsonProperty("last_update") Date lastUpdate,
        Map<String, ListingQuote> quote
) {
}
