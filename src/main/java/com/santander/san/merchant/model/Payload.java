package com.santander.san.merchant.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * The type Payload.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {

  /**
   * The Fields.
   */
  private Map<String, Object> fields;

  @JsonAnyGetter
  public Map<String, Object> fields() {
    return fields;
  }

}
