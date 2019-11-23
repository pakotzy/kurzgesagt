package com.pakotzy.kurzgesagt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories("com.pakotzy.kurzgesagt.persistence")
public class KurzgesagtApplication {
  public static void main(String[] args) {
    SpringApplication.run(KurzgesagtApplication.class, args);
  }
}
