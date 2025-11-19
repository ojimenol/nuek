package com.santander.san.merchant.service;

import com.santander.san.merchant.config.AppCommerceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ComercioQueryService {
  private final AppCommerceProperties appCommerceProperties;
  private final RestTemplate restTemplate;

  public String getCommercios(
    String jwe,
    String personCode,
    String personType,
    String billingDateFrom,
    String billingDateTo,
    String order,
    String listDateFrom,
    String listDateTo
  ) {
    String url = appCommerceProperties.getCommerceUrl()
      + "?personCode=" + personCode
      + "&personType=" + personType
      + "&billingDateFrom=" + billingDateFrom
      + "&billingDateTo=" + billingDateTo
      + "&order=" + order
      + "&listDateFrom=" + listDateFrom
      + "&listDateTo=" + listDateTo;

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + jwe);

    ResponseEntity<String> response = restTemplate.exchange(
      url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

    return response.getBody();
  }
}
