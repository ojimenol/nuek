package com.santander.san.merchant.model;

import lombok.Data;
import java.util.Map;

@Data
public class ScosRequest {
  private String keyalias;
  private String expiration;
  private Map<String, Object> payload;
}
