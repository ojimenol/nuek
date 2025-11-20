package com.santander.san.merchant.integration.commerces.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommerceResponse {

  private String personType;
  private String personCode;
  private String commerceCode;
  private String commerceContract;
  private String iban;
  private String commerceName;
  private String postalAddress;
  private BigDecimal groupedBilling;
  private String groupedBillingDate;
  private String currency;
  private String dateFrom;
  private BigDecimal totalGroupedBilling;
  private String flagTpv;


}
