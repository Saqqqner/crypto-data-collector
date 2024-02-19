package ru.adel.cryptodatacollector.model.crypto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseAPI<T>(
        @JsonProperty("status") ResponseStatus status,

        @JsonProperty("data") T data
) {
}
