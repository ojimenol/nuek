package com.santander.san.merchant.integration.sasautenticatecredentials.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * The type Sas request.
 */
@Data
@Builder
public class SasRequest {

  /**
   * The Credential type.
   */
  private List<String> credentialType;

  /**
   * The Id attributes.
   */
  private IdAttributes idAttributes;

  /**
   * The Password.
   */
  private String password;

  /**
   * The Realm.
   */
  private String realm;
}
