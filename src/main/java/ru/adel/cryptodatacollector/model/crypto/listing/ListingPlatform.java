package ru.adel.cryptodatacollector.model.crypto.listing;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ListingPlatform(
        Integer id,
        String name,
        String symbol,
        String slug,
        @JsonProperty("token_address")
        String tokenAddress) {

}
