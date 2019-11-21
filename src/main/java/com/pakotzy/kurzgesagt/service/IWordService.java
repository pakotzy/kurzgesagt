package com.pakotzy.kurzgesagt.service;

import com.pakotzy.kurzgesagt.persistence.model.Word;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by P. Kot on 29-Sep-19.
 */

public interface IWordService {
  Mono<Word> create(Word word);

  Mono<Word> findById(UUID id);

  Flux<Word> findByName(String name);

  Flux<Word> findAll();

  Mono<Word> update(Word word);

  Mono<Void> delete(UUID id);
}
