package com.pakotzy.kurzgesagt.persistence.dao;

import com.pakotzy.kurzgesagt.persistence.model.Word;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * Created by P. Kot on 29-Sep-19.
 */

public interface WordRepository extends ReactiveCrudRepository<Word, UUID> {
  @Query("{ 'name': ?0 }")
  Flux<Word> findByName(final String name);
}
