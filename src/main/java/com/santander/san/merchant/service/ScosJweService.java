package com.santander.san.merchant.service;


import com.santander.san.merchant.config.AppCosProperties;
import com.santander.san.merchant.model.ScosRequest;
import com.santander.san.merchant.model.ScosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ScosJweService {
  private final AppCosProperties appCosProperties;
  private final RestTemplate restTemplate;

  public String getJwe(String jwt, String cookie, ScosRequest scosRequest) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(MediaType.parseMediaTypes("application/json"));
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("X-Clientid", "darwin");
    headers.set("Authentication", "Bearer " + jwt);
    headers.set("Cookie", cookie);

    ResponseEntity<ScosResponse> response = restTemplate.exchange(
      appCosProperties.getScosJweUrl(),
      HttpMethod.POST,
      new HttpEntity<>(scosRequest, headers),
      ScosResponse.class
    );

    return response.getBody().getJwe();
  }
}
