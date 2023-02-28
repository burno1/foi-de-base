package com.fernandes.bruno.foidebase.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: Bruno Fernandes
 * Created at : 27/02/2023
 */
@Service
public class JsonService {

  private final ObjectMapper objectMapper;
  private String[] phrases;

  public JsonService(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    loadPhrases();
  }

  public String[] getPhrases() {
    return phrases;
  }

  private void loadPhrases() {
    try {
      ClassPathResource resource = new ClassPathResource("data.json");
      InputStream inputStream = resource.getInputStream();
      DataModel data = objectMapper.readValue(inputStream, DataModel.class);
      phrases = data.getPhrases();
    } catch (IOException e) {
      e.printStackTrace();
      phrases = new String[0];
    }
  }

  private static class DataModel {
    private String[] phrases;

    public String[] getPhrases() {
      return phrases;
    }

    public void setPhrases(String[] phrases) {
      this.phrases = phrases;
    }
  }
}
