package com.pakotzy.kurzgesagt.service;

import com.pakotzy.kurzgesagt.persistence.dao.WordRepository;
import com.pakotzy.kurzgesagt.persistence.model.Word;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by P. Kot on 29-Sep-19.
 */

@Service
public class WordService implements IWordService {
  final private WordRepository wordRepository;

  public WordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  @Override
  public void create(Word word) {
    wordRepository.save(word).subscribe();
  }

  @Override
  public Mono<Word> findById(long id) {
    return wordRepository.findById(id);
  }

  @Override
  public Flux<Word> findByName(String name) {
    return wordRepository.findByName(name);
  }

  @Override
  public Flux<Word> findAll() {
    return wordRepository.findAll();
  }

  @Override
  public Mono<Word> update(Word word) {
    return wordRepository.save(word);
  }

  @Override
  public Mono<Void> delete(long id) {
    return wordRepository.deleteById(id);
  }
}
