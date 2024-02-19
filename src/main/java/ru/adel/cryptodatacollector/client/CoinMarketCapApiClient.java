package ru.adel.cryptodatacollector.client;

import io.github.resilience4j.ratelimiter.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.adel.cryptodatacollector.client.util.ApiClientContext;

@Component
@Slf4j
public class CoinMarketCapApiClient {
    private WebClient webClient;
    private RateLimiter rateLimiter;

    public CoinMarketCapApiClient(WebClient webClient, RateLimiter rateLimiter) {
        this.webClient = webClient;
        this.rateLimiter = rateLimiter;

    }

    public void collectData(ApiClientContext apiClientContext) {
        rateLimiter.executeRunnable(() -> {
            webClient.get()
                    .uri(apiClientContext.getUrl())
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe((data -> {
                        apiClientContext.getAction().performAction(data);
                    }));
        });
    }
}
