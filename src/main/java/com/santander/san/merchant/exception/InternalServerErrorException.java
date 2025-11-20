package com.santander.san.merchant.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class InternalServerErrorException extends HttpBaseException {
  private static final long serialVersionUID = 1985008623690043274L;
  private static final HttpStatus HTTP_STATUS;
  private static final String DEFAULT_SHORT_MESSAGE = "Internal Server Error";
  private static final String DEFAULT_DETAILED_MESSAGE = "Something is horribly wrong.";

  public InternalServerErrorException(String errorName, List<String> placeHolders) {
    super(errorName, HTTP_STATUS, "Internal Server Error", "Something is horribly wrong.", (Map)null, (Throwable)null, placeHolders);
  }

  public InternalServerErrorException(String errorName, Map<String, List<String>> errorsMessagePlaceholders) {
    super(errorName, HTTP_STATUS, "Internal Server Error", "Something is horribly wrong.", (Map)null, (Throwable)null, errorsMessagePlaceholders);
  }

  public InternalServerErrorException(String errorName, String message) {
    super(errorName, HTTP_STATUS, "Internal Server Error", message == null ? "Something is horribly wrong." : message);
  }

  public InternalServerErrorException(String errorName) {
    this(errorName, (String)null);
  }

  public InternalServerErrorException(String errorName, String message, Throwable throwable) {
    this(errorName, message);
  }

  public InternalServerErrorException(String errorName, String message, Map<String, ? extends Serializable> map) {
    super(errorName, HTTP_STATUS, "Internal Server Error", message == null ? "Something is horribly wrong." : message, map);
  }

  static {
    HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
