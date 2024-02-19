package ru.adel.cryptodatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoDataCollectorApplication.class, args);
    }

}
