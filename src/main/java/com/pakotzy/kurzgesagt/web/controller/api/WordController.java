package com.pakotzy.kurzgesagt.web.controller.api;

import com.pakotzy.kurzgesagt.persistence.model.Word;
import com.pakotzy.kurzgesagt.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by P. Kot on 29-Sep-19.
 */

@RestController
@RequestMapping("words")
public class WordController {
  private final WordService wordService;

  public WordController(WordService wordService) {this.wordService = wordService;}

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Word> create(@RequestBody Word word) {
    return wordService.create(word);
  }

  @GetMapping("{id}")
  public Mono<Word> findById(@PathVariable String id) {
    return wordService.get(UUID.fromString(id));
  }

  @GetMapping
  public Flux<ServerSentEvent<Word>> findAll() {
    return wordService.get().map(word -> ServerSentEvent.<Word>builder()
        .id(String.valueOf(word.getId()))
        .event("periodic-event")
        .data(word)
        .build());
  }
}
