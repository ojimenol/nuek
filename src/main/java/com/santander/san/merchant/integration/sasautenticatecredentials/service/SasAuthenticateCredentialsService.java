package com.santander.san.merchant.integration.sasautenticatecredentials.service;


import com.santander.san.merchant.integration.sasautenticatecredentials.model.SasResponse;

/**
 * The interface Sas authenticate credentials service.
 */
public interface SasAuthenticateCredentialsService {

  /**
   * Gets credentials.
   *
   * @return the credentials
   */
  SasResponse getCredentials();

}
