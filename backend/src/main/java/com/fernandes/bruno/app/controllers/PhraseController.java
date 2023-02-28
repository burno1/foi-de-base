package com.fernandes.bruno.app.controllers;

import com.fernandes.bruno.app.services.JsonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruno Fernandes
 * Created at : 27/02/2023
 */

@RestController
@RequiredArgsConstructor
public class PhraseController {

  private final JsonService jsonService;

  @GetMapping("/phrases")
  public ResponseEntity<String> getPhrases() {
    String[] phrases = jsonService.getPhrases();
    int randomIndex = (int) (Math.random() * phrases.length);
    return new ResponseEntity<>(phrases[randomIndex], HttpStatus.OK);
  }
}
