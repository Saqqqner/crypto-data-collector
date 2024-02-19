package ru.adel.cryptodatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.utility.DockerImageName;

//@TestConfiguration(proxyBeanMethods = false)
//public class TestCryptoDataCollectorApplication {
//
//    @Bean
//    @ServiceConnection
//    ElasticsearchContainer elasticsearchContainer() {
//        return new ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"));
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.from(CryptoDataCollectorApplication::main).with(TestCryptoDataCollectorApplication.class).run(args);
//    }
//
//}
