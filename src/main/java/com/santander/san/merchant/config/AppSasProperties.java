package com.santander.san.merchant.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.sas")
public class AppSasProperties {
  private String sasAuthUrl;
}
