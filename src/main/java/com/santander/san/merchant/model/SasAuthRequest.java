package com.santander.san.merchant.model;

import lombok.Data;
import java.util.Map;

@Data
public class SasAuthRequest {
  private Map<String, String> idAttributes;
  private String password;
  private String realm;
}