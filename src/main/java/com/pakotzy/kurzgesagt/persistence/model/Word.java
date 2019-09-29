package com.pakotzy.kurzgesagt.persistence.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by P. Kot on 29-Sep-19.
 */

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Word {
  @Id
  private long id;

  private String word;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  @Override
  public String toString() {
    return "Word{" +
        "id=" + id +
        ", word='" + word + '\'' +
        '}';
  }
}
