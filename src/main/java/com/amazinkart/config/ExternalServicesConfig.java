package com.amazinkart.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalServicesConfig {

  @JsonProperty
  private String productDetailsRetrievalAPI;

  @JsonIgnoreProperties
  private String convertRatesAPI;

  public String getProductDetailsRetrievalAPI() {
    return productDetailsRetrievalAPI;
  }

  public String getConvertRatesAPI() {
    return convertRatesAPI;
  }

}
