package com.santander.san.merchant.web.impl;

import com.santander.san.merchant.integration.commerce.model.CommerceResponse;
import com.santander.san.merchant.integration.commerce.service.CommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/commerce/")
public class CommerceControllerImpl {


  @Autowired
  private CommerceService commerceService;

  @GetMapping
  public ResponseEntity<CommerceResponse> getCommerces(@RequestParam String personCode,
    @RequestParam String personType, @RequestParam String billingDateFrom, @RequestParam String billingDateTo,
    @RequestParam String order, @RequestParam String listDateFrom,  @RequestParam String listDateTo) {
     return new ResponseEntity<>(commerceService.getCommerces(personCode, personType,
      billingDateFrom, billingDateTo, order, listDateFrom, listDateTo), HttpStatus.OK);

  }
}