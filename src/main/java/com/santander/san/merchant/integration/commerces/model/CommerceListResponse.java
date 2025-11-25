package com.santander.san.merchant.integration.commerces.model;

import java.util.List;

public class CommerceListResponse {
  private List<Commerce> commerceList;

  public List<Commerce> getCommerceList() {
    return commerceList;
  }

  public void setCommerceList(List<Commerce> commerceList) {
    this.commerceList = commerceList;
  }
}
