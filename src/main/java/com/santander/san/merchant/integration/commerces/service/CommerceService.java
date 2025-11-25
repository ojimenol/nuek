package com.santander.san.merchant.integration.commerces.service;

import com.santander.san.merchant.integration.commerces.model.CommerceListResponse;

public interface CommerceService {
  CommerceListResponse getCommerces(String personCode, String personType,
                                    String billingDateFrom, String billingDateTo, String order,
                                    String listDateFrom, String listDateTo);
}