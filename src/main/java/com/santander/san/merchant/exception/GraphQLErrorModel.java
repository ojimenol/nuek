package com.santander.san.merchant.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import java.util.Map;

public interface GraphQLErrorModel {
  @NonNull
  @JsonIgnore
  String getGraphQlMessage();

  @JsonIgnore
  default Map<String, Object> getExtensions() {
    return Map.of();
  }
}
