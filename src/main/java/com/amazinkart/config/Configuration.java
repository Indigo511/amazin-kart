package com.amazinkart.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Configuration extends io.dropwizard.Configuration {

  @JsonProperty("externalServices")
  private ExternalServicesConfig externalServicesConfig;
  @JsonProperty
  private String targetFolderPath;

}
