package com.pakotzy.kurzgesagt.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * Created by P. Kot on 23-Nov-19.
 */

@RestController
@RequestMapping("user")
public class UserController {
  @GetMapping
  public Mono<String> getUser(WebSession session) {
    return Mono.just(session.getAttributes().values().stream().map(Object::toString)
        .collect(Collectors.joining(",")));
  }
}
