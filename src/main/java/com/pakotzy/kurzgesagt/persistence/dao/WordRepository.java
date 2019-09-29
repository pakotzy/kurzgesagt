package com.pakotzy.kurzgesagt.persistence.dao;

import com.pakotzy.kurzgesagt.persistence.model.Word;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Created by P. Kot on 29-Sep-19.
 */

public interface WordRepository extends ReactiveMongoRepository<Word, Long> {
  @Query("{ 'name': ?0 }")
  Flux<Word> findByName(final String name);
}
