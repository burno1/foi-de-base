package com.fernandes.bruno.foidebase.controllers;

import com.fernandes.bruno.foidebase.services.JsonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruno Fernandes
 * Created at : 27/02/2023
 */

@RestController
@AllArgsConstructor
public class PhraseController {

  private final JsonService jsonService;

  @GetMapping("/phrases")
  public ResponseEntity<String[]> getPhrases() {
    String[] phrases = jsonService.getPhrases();
    return new ResponseEntity<>(phrases, HttpStatus.OK);
  }
}
