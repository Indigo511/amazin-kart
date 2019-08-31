package com.amazinkart.bean;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateDetails {
  private String base;
  private String date;
  private Map<String, Double> rates;
}
