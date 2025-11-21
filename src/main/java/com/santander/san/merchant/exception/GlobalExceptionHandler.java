package com.santander.san.merchant.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorModel> handleBadRequestException(BadRequestException ex) {
    ErrorModel.CommerceErrorModelBuilder.Error error = ErrorModel.CommerceErrorModelBuilder.Error.builder()
      .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
      .description(ex.getMessage())
      .level("error")
      .message(ex.getLocalizedMessage())
      .build();

    ErrorModel errorModel = ErrorModel.builder()
      .error(error)
      .build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<ErrorModel> handleInternalServerErrorException(InternalServerErrorException ex) {
    ErrorModel.CommerceErrorModelBuilder.Error error = ErrorModel.CommerceErrorModelBuilder.Error.builder()
      .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
      .description(ex.getMessage())
      .level("error")
      .message(ex.getLocalizedMessage())
      .build();

    ErrorModel errorModel = ErrorModel.builder()
      .error(error)
      .build();

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorModel);
  }
}
