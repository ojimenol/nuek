package com.santander.san.merchant.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PayloadCommerceRequest {

  private String personCode;
  private String personType;
  private String billingDateFrom;
  private String billingDateTo;
  private String listDateFrom;
  private String listDateTo;
  private String order;
}
