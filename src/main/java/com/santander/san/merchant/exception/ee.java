package com.santander.san.merchant.exception;

import java.util.Map;

interface ErrorModelBuilder<T> {
  default T buildErrorModel(Map<String, Object> errorModelAttributes) {
    return null;
  }
}
