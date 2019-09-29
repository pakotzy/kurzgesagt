package com.pakotzy.kurzgesagt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class KurzgesagtApplication {
  public static void main(String[] args) {
    SpringApplication.run(KurzgesagtApplication.class, args);
  }
}
