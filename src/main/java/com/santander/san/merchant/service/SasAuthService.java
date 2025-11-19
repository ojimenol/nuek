package com.santander.san.merchant.service;


import com.santander.san.merchant.config.AppSasProperties;
import com.santander.san.merchant.model.SasAuthRequest;
import com.santander.san.merchant.model.SasAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class SasAuthService {
  private final AppSasProperties appSasProperties;
  private final RestTemplate restTemplate;

  public String getJwt(String uid, String password, String realm, String cookie) {
    SasAuthRequest req = new SasAuthRequest();
    req.setIdAttributes(new HashMap<>() {{ put("uid", uid); }});
    req.setPassword(password);
    req.setRealm(realm);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Cookie", cookie);

    ResponseEntity<SasAuthResponse> response = restTemplate.exchange(
      appSasProperties.getSasAuthUrl(),
      HttpMethod.POST,
      new HttpEntity<>(req, headers),
      SasAuthResponse.class
    );

    return response.getBody().getJwt();
  }
}
