package com.santander.san.merchant.integration.cos.service;


import com.santander.san.merchant.integration.cos.model.JWEEncryptResponse;

/**
 * The interface Cos service.
 */
public interface CosService {

  /**
   * Generate jwe jwe encrypt response.
   *
   * @param data the data
   * @return the jwe encrypt response
   */
  JWEEncryptResponse generateJwe(Object data);

}
