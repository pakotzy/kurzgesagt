package com.pakotzy.kurzgesagt.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by P. Kot on 29-Sep-19.
 */

@Table
public class Word {
  @Id
  private UUID id;

  @NotNull
  private String word;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
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
