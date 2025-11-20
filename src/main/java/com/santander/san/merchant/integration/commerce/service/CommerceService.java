package com.santander.san.merchant.integration.commerce.service;

import com.santander.san.merchant.integration.commerce.model.CommerceResponse;

public interface CommerceService {
  CommerceResponse getCommerces(String personCode, String personType,
                                String billingDateFrom, String billingDateTo, String order,
                                String listDateFrom, String listDateTo);
}