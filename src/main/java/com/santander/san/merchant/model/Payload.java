package com.santander.san.merchant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * The type Payload.
 */
@Builder
@Data
public class Payload {

  /**
   * The Data.
   */
  @JsonProperty("data")
  private Object data;

}
