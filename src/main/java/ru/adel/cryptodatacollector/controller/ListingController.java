package ru.adel.cryptodatacollector.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.adel.cryptodatacollector.model.crypto.listing.ListingData;
import ru.adel.cryptodatacollector.service.core.ListingService;

import java.util.List;

@RestController
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("/listing/latest")
    public ResponseEntity<List<ListingData>>getLatestListings(@RequestParam int start, @RequestParam int limit){
        List<ListingData> latestListings =listingService.getLatestListings(start,limit);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(latestListings);

    }
}
