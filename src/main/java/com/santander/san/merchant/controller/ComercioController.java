package com.santander.san.merchant.controller;

import com.santander.san.merchant.model.ScosRequest;
import com.santander.san.merchant.service.ComercioQueryService;
import com.santander.san.merchant.service.SasAuthService;
import com.santander.san.merchant.service.ScosJweService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/integracion/comercio")
public class ComercioController {

  private final SasAuthService sasAuthService;
  private final ScosJweService scosJweService;
  private final ComercioQueryService comercioQueryService;

  @PostMapping("/datos")
  public String getDatosComercio(@RequestBody Map<String, String> params) {
    // Paso 1: Autenticación contra SAS
    String jwt = sasAuthService.getJwt(
      params.get("uid"),
      params.get("password"),
      params.get("realm"),
      params.get("cookie")
    );

    // Paso 2: Obtener JWE de SCOS
    ScosRequest scosRequest = new ScosRequest();
    scosRequest.setKeyalias(params.get("keyalias"));
    scosRequest.setExpiration(params.get("expiration"));
    scosRequest.setPayload(Map.of(
      "personCode", params.get("personCode"),
      "personType", params.get("personType"),
      "billingDateFrom", params.get("billingDateFrom"),
      "billingDateTo", params.get("billingDateTo"),
      "listDateFrom", params.get("listDateFrom"),
      "listDateTo", params.get("listDateTo"),
      "order", params.get("order")
    ));
    String jwe = scosJweService.getJwe(jwt, params.get("cookie"), scosRequest);

    // Paso 3: Consultar servicio final con el JWE
    return comercioQueryService.getCommercios(
      jwe,
      params.get("personCode"),
      params.get("personType"),
      params.get("billingDateFrom"),
      params.get("billingDateTo"),
      params.get("order"),
      params.get("listDateFrom"),
      params.get("listDateTo")
    );
  }
}