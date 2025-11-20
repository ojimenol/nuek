package com.santander.san.merchant.integration.commerce.service.impl;

import com.santander.san.merchant.config.CommerceProperties;
import com.santander.san.merchant.integration.commerce.model.CommerceResponse;
import com.santander.san.merchant.integration.commerce.service.CommerceService;
import com.santander.san.merchant.integration.cos.model.JWEEncryptResponse;
import com.santander.san.merchant.integration.cos.service.CosService;
import com.santander.san.merchant.model.PayloadCommerceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CommerceServiceImpl implements CommerceService {

  private final WebClient webClient;

  private final CommerceProperties properties;

  @Autowired
  private CosService cosService;

  public CommerceServiceImpl(WebClient.Builder webClientBuilder, CommerceProperties commerceProperties) {
    this.properties = commerceProperties;
    this.webClient = webClientBuilder
      .baseUrl(this.properties.getCommerceUrl())
      .build();
  }


  @Override
  public CommerceResponse getCommerces(String personCode, String personType,
                                       String billingDateFrom, String billingDateTo, String order,
                                       String listDateFrom, String listDateTo) {

    JWEEncryptResponse encryptResponse = cosService.generateJwe(buildCommerceRequest(personCode, personType,
      billingDateFrom, billingDateTo, order, listDateFrom, listDateTo));


    return webClient.get()
      .uri(uriBuilder -> uriBuilder
        .queryParam("personCode", personCode)
        .queryParam("personType", personType)
        .queryParam("billingDateFrom", billingDateFrom)
        .queryParam("billingDateTo", billingDateTo)
        .queryParam("order", order)
        .queryParam("listDateFrom", listDateFrom)
        .queryParam("listDateTo", listDateTo)
        .build())
      .header(HttpHeaders.AUTHORIZATION, encryptResponse.getJwe())
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .onStatus(HttpStatusCode::is4xxClientError, resp -> Mono.error(new HttpClientErrorException(resp.statusCode())))
      .onStatus(HttpStatusCode::is5xxServerError, resp -> Mono.error(new HttpServerErrorException(resp.statusCode())))
      .bodyToMono(CommerceResponse.class)
      .block();
  }

  private PayloadCommerceRequest buildCommerceRequest(String personCode, String personType, String billingDateFrom,
                                                      String billingDateTo, String order, String listDateFrom, String listDateTo) {
    return PayloadCommerceRequest.builder()
      .personCode(personCode)
      .personType(personType)
      .billingDateFrom(billingDateFrom)
      .billingDateTo(billingDateTo)
      .order(order)
      .listDateFrom(listDateFrom)
      .listDateTo(listDateTo)
      .build();
  }
}
