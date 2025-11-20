package com.santander.san.merchant.integration.cos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Jwe encrypt response.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWEEncryptResponse {

  /**
   * The Jwe.
   */
  private String jwe;
}
