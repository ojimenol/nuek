package com.santander.san.merchant.integration.cos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santander.san.merchant.model.Payload;
import lombok.Builder;
import lombok.Data;

/**
 * The type Jwe encrypt request.
 */
@Data
@Builder
public class JWEEncryptRequest {

  /**
   * The Keyalias.
   */
  @JsonProperty("keyalias")
  private String keyalias;

  /**
   * The Payload.
   */
  @JsonProperty("payload")
  private Payload payload;

}
