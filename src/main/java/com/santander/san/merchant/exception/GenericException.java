package com.santander.san.merchant.exception;

import lombok.Generated;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericException extends RuntimeException {
  private static final String DESCRIPTION = "description";
  private final String errorName;
  private final Integer internalCode;
  private final String shortMessage;
  private final String detailedMessage;
  private final Map<String, ? extends Serializable> mapExtendedMessage;
  private final Map<String, List<String>> errorsMessagePlaceholders;

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage", "mapExtendedMessage", "cause", "errorsMessagePlaceholders"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause, Map<String, List<String>> errorsMessagePlaceholders) {
    super(detailedMessage, cause);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = mapExtendedMessage;
    this.errorsMessagePlaceholders =
      (errorsMessagePlaceholders != null)
        ? new HashMap<String, List<String>>(errorsMessagePlaceholders)
        : Map.of();
  }

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage", "mapExtendedMessage", "cause", "placeHolders"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause, List<String> placeHolders) {
    super(detailedMessage, cause);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = mapExtendedMessage;
    this.errorsMessagePlaceholders = placeHolders != null ? Map.of("description", placeHolders) : Map.of();
  }

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage", "mapExtendedMessage"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage) {
    super(detailedMessage);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = mapExtendedMessage;
    this.errorsMessagePlaceholders = new HashMap();
  }

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage", "mapExtendedMessage", "cause"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage, Map<String, ? extends Serializable> mapExtendedMessage, Throwable cause) {
    super(detailedMessage, cause);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = mapExtendedMessage;
    this.errorsMessagePlaceholders = new HashMap();
  }

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage) {
    super(detailedMessage);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = new HashMap();
    this.errorsMessagePlaceholders = new HashMap();
  }

  @ConstructorProperties({"errorName", "internalCode", "shortMessage", "detailedMessage", "cause"})
  public GenericException(String errorName, Integer internalCode, String shortMessage, String detailedMessage, Throwable cause) {
    super(detailedMessage, cause);
    this.errorName = errorName;
    this.internalCode = internalCode;
    this.shortMessage = shortMessage;
    this.detailedMessage = detailedMessage;
    this.mapExtendedMessage = new HashMap();
    this.errorsMessagePlaceholders = new HashMap();
  }

  @ConstructorProperties({"Exception"})
  public GenericException(Throwable ex) {
    super(ex);
    this.errorName = ex.getClass().getName();
    this.internalCode = -1;
    this.shortMessage = ex.getMessage();
    this.detailedMessage = ex.getLocalizedMessage();
    this.mapExtendedMessage = new HashMap();
    this.errorsMessagePlaceholders = new HashMap();
  }


  @Generated
  public String getErrorName() {
    return this.errorName;
  }

  @Generated
  public Integer getInternalCode() {
    return this.internalCode;
  }

  @Generated
  public String getShortMessage() {
    return this.shortMessage;
  }

  @Generated
  public String getDetailedMessage() {
    return this.detailedMessage;
  }

  @Generated
  public Map<String, ? extends Serializable> getMapExtendedMessage() {
    return this.mapExtendedMessage;
  }

  @Generated
  public Map<String, List<String>> getErrorsMessagePlaceholders() {
    return this.errorsMessagePlaceholders;
  }

  @Generated
  public String toString() {
    String var10000 = this.errorName;
    return "GenericDarwinException(errorName=" + var10000 + ", internalCode=" + this.internalCode + ", shortMessage=" + this.shortMessage + ", detailedMessage=" + this.detailedMessage + ", mapExtendedMessage=" + String.valueOf(this.mapExtendedMessage) + ", errorsMessagePlaceholders=" + String.valueOf(this.errorsMessagePlaceholders) + ")";
  }

  @Generated
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof GenericException)) {
      return false;
    } else {
      GenericException other = (GenericException)o;
      if (!other.canEqual(this)) {
        return false;
      } else {
        Object this$internalCode = this.internalCode;
        Object other$internalCode = other.internalCode;
        if (this$internalCode == null) {
          if (other$internalCode != null) {
            return false;
          }
        } else if (!this$internalCode.equals(other$internalCode)) {
          return false;
        }

        Object this$errorName = this.errorName;
        Object other$errorName = other.errorName;
        if (this$errorName == null) {
          if (other$errorName != null) {
            return false;
          }
        } else if (!this$errorName.equals(other$errorName)) {
          return false;
        }

        Object this$shortMessage = this.shortMessage;
        Object other$shortMessage = other.shortMessage;
        if (this$shortMessage == null) {
          if (other$shortMessage != null) {
            return false;
          }
        } else if (!this$shortMessage.equals(other$shortMessage)) {
          return false;
        }

        Object this$detailedMessage = this.detailedMessage;
        Object other$detailedMessage = other.detailedMessage;
        if (this$detailedMessage == null) {
          if (other$detailedMessage != null) {
            return false;
          }
        } else if (!this$detailedMessage.equals(other$detailedMessage)) {
          return false;
        }

        Object this$mapExtendedMessage = this.mapExtendedMessage;
        Object other$mapExtendedMessage = other.mapExtendedMessage;
        if (this$mapExtendedMessage == null) {
          if (other$mapExtendedMessage != null) {
            return false;
          }
        } else if (!this$mapExtendedMessage.equals(other$mapExtendedMessage)) {
          return false;
        }

        Object this$errorsMessagePlaceholders = this.errorsMessagePlaceholders;
        Object other$errorsMessagePlaceholders = other.errorsMessagePlaceholders;
        if (this$errorsMessagePlaceholders == null) {
          if (other$errorsMessagePlaceholders != null) {
            return false;
          }
        } else if (!this$errorsMessagePlaceholders.equals(other$errorsMessagePlaceholders)) {
          return false;
        }

        return true;
      }
    }
  }

  @Generated
  protected boolean canEqual(final Object other) {
    return other instanceof GenericException;
  }

  @Generated
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $internalCode = this.internalCode;
    result = result * 59 + ($internalCode == null ? 43 : $internalCode.hashCode());
    Object $errorName = this.errorName;
    result = result * 59 + ($errorName == null ? 43 : $errorName.hashCode());
    Object $shortMessage = this.shortMessage;
    result = result * 59 + ($shortMessage == null ? 43 : $shortMessage.hashCode());
    Object $detailedMessage = this.detailedMessage;
    result = result * 59 + ($detailedMessage == null ? 43 : $detailedMessage.hashCode());
    Object $mapExtendedMessage = this.mapExtendedMessage;
    result = result * 59 + ($mapExtendedMessage == null ? 43 : $mapExtendedMessage.hashCode());
    Object $errorsMessagePlaceholders = this.errorsMessagePlaceholders;
    result = result * 59 + ($errorsMessagePlaceholders == null ? 43 : $errorsMessagePlaceholders.hashCode());
    return result;
  }

  public static class GenericDarwinExceptionBuilder {
    @Generated
    private String errorName;
    @Generated
    private Integer internalCode;
    @Generated
    private String shortMessage;
    @Generated
    private String detailedMessage;
    @Generated
    private Map<String, List<String>> errorsMessagePlaceholders;
    Map<String, ? extends Serializable> mapExtendedMessage = new HashMap();
    Map<String, List<String>> descriptionErrorPlaceholders = Map.of();
    Throwable cause = null;

    public GenericDarwinExceptionBuilder cause(Throwable ex) {
      this.cause = ex;
      return this;
    }

    public GenericException build() {
      return new GenericException(this.errorName, this.internalCode, this.shortMessage, this.detailedMessage, this.mapExtendedMessage, this.cause, this.descriptionErrorPlaceholders);
    }

    public GenericDarwinExceptionBuilder throwable(Throwable ex) {
      this.errorName(ex.getClass().getName());
      this.internalCode(-1);
      this.shortMessage(ex.getMessage());
      this.detailedMessage(ex.getLocalizedMessage());
      this.mapExtendedMessage(new HashMap());
      this.errorsMessagePlaceholders(new HashMap());
      return this;
    }

    @Generated
    GenericDarwinExceptionBuilder() {
    }

    @Generated
    public GenericDarwinExceptionBuilder errorName(final String errorName) {
      this.errorName = errorName;
      return this;
    }

    @Generated
    public GenericDarwinExceptionBuilder internalCode(final Integer internalCode) {
      this.internalCode = internalCode;
      return this;
    }

    @Generated
    public GenericDarwinExceptionBuilder shortMessage(final String shortMessage) {
      this.shortMessage = shortMessage;
      return this;
    }

    @Generated
    public GenericDarwinExceptionBuilder detailedMessage(final String detailedMessage) {
      this.detailedMessage = detailedMessage;
      return this;
    }

    @Generated
    public GenericDarwinExceptionBuilder mapExtendedMessage(final Map<String, ? extends Serializable> mapExtendedMessage) {
      this.mapExtendedMessage = mapExtendedMessage;
      return this;
    }

    @Generated
    public GenericDarwinExceptionBuilder errorsMessagePlaceholders(final Map<String, List<String>> errorsMessagePlaceholders) {
      this.errorsMessagePlaceholders = errorsMessagePlaceholders;
      return this;
    }

    @Generated
    public String toString() {
      String var10000 = this.errorName;
      return "GenericDarwinException.GenericDarwinExceptionBuilder(errorName=" + var10000 + ", internalCode=" + this.internalCode + ", shortMessage=" + this.shortMessage + ", detailedMessage=" + this.detailedMessage + ", mapExtendedMessage=" + String.valueOf(this.mapExtendedMessage) + ", errorsMessagePlaceholders=" + String.valueOf(this.errorsMessagePlaceholders) + ")";
    }
  }
}

