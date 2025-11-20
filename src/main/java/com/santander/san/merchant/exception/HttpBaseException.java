package com.santander.san.merchant.exception;

import lombok.Generated;
import org.springframework.http.HttpStatus;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class HttpBaseException extends GenericException {
private static final long serialVersionUID = -8135368130095363613L;
private final HttpStatus status;

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause, Map<String, List<String>> errorsMessagePlaceholders) {
  super(errorName, status.value(), shortMessage, detailedMessage, mapExtendedMessage, cause, errorsMessagePlaceholders);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause, List<String> placeHolders) {
  super(errorName, status.value(), shortMessage, detailedMessage, mapExtendedMessage, cause, placeHolders);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage) {
  super(errorName, status.value(), shortMessage, detailedMessage);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage, Throwable cause) {
  super(errorName, status.value(), shortMessage, detailedMessage, cause);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, Integer internalCode, String shortMessage, String detailedMessage) {
  super(errorName, internalCode, shortMessage, detailedMessage);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, Integer internalCode, String shortMessage, String detailedMessage, Throwable cause) {
  super(errorName, internalCode, shortMessage, detailedMessage, cause);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage) {
  super(errorName, status.value(), shortMessage, detailedMessage, mapExtendedMessage);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause) {
  super(errorName, status.value(), shortMessage, detailedMessage, mapExtendedMessage, cause);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage) {
  super(errorName, internalCode, shortMessage, detailedMessage, mapExtendedMessage);
  this.status = status;
}

public HttpBaseException(String errorName, HttpStatus status, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause) {
  super(errorName, internalCode, shortMessage, detailedMessage, mapExtendedMessage, cause);
  this.status = status;
}

@ConstructorProperties({"Exception"})
public HttpBaseException(Exception ex) {
  super(ex);
  this.status = HttpStatus.INTERNAL_SERVER_ERROR;
}

@Generated
public boolean equals(final Object o) {
  if (o == this) {
    return true;
  } else if (!(o instanceof HttpBaseException)) {
    return false;
  } else {
    HttpBaseException other = (HttpBaseException)o;
    if (!other.canEqual(this)) {
      return false;
    } else if (!super.equals(o)) {
      return false;
    } else {
      Object this$status = this.status;
      Object other$status = other.status;
      if (this$status == null) {
        if (other$status != null) {
          return false;
        }
      } else if (!this$status.equals(other$status)) {
        return false;
      }

      return true;
    }
  }
}

@Generated
protected boolean canEqual(final Object other) {
  return other instanceof HttpBaseException;
}

@Generated
public int hashCode() {
  int PRIME = 59;
  int result = super.hashCode();
  Object $status = this.status;
  result = result * 59 + ($status == null ? 43 : $status.hashCode());
  return result;
}

@Generated
public HttpStatus getStatus() {
  return this.status;
}
}
