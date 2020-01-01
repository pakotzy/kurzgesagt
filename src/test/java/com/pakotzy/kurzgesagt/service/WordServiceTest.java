package com.pakotzy.kurzgesagt.service;

import com.pakotzy.kurzgesagt.persistence.dao.WordRepository;
import com.pakotzy.kurzgesagt.persistence.model.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

/**
 * Created by P. Kot on 1/1/2020.
 */

@ExtendWith(MockitoExtension.class)
@DisplayName("The ClientServiceImpl")
class WordServiceTest {
  @InjectMocks
  WordService wordService;

  @Mock
  WordRepository wordRepository;

  @Nested
  @DisplayName("Get")
  class Get {
    @Test
    @DisplayName("return unchanged Word by id when present")
    void GetWord_ValidId_Word() {
//      given
      Word mockWord = new Word();
      mockWord.setId(UUID.randomUUID());
      mockWord.setWord("TEST");

      given(wordRepository.findById(mockWord.getId())).willReturn(Mono.just(mockWord));

//      when
      Mono<Word> resultMono = wordService.get(mockWord.getId());

//      then
      then(wordRepository).should(times(1)).findById(mockWord.getId());

      Word resultObject = resultMono.block();
      assertNotNull(resultObject);

      assertAll(
          () -> assertEquals(mockWord, resultObject),
          () -> assertEquals(mockWord.getId(), resultObject.getId()),
          () -> assertEquals(mockWord.getWord(), resultObject.getWord())
      );
    }
  }
}