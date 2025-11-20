package com.santander.san.merchant.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * The type Sas properties config.
 */
@Configuration
@Getter
@Setter
public class SasPropertiesConfig {

  /**
   * The Sas authenticate url.
   */
  @Value("${app.sas.auth-url}")
  private String sasAuthenticateUrl;

  /**
   * The Credential type jwt.
   */
  @Value("${app.sas.credential-type-jwt}")
  private String credentialTypeJWT;

  /**
   * The Credential type token corp.
   */
  @Value("${app.sas.credential-type-token-corp}")
  private String credentialTypeTokenCorp;

  /**
   * The Uid.
   */
  @Value("${app.sas.uid}")
  private String uid;

  /**
   * The Password.
   */
  @Value("${app.sas.password}")
  private String password;

  /**
   * The Realm.
   */
  @Value("${app.sas.realm}")
  private String realm;
}
