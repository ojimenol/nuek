package com.santander.san.merchant.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.santander.san.merchant.annotation.CustomErrorModel;
import lombok.Generated;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
  builder = ErrorModel.class
)
@CustomErrorModel
public class ErrorModel implements GraphQLErrorModel {
  private List<CommerceErrorModelBuilder.Error> errors;

  @NonNull
  public String getGraphQlMessage() {
    return ((CommerceErrorModelBuilder.Error) this.errors.get(this.errors.size() - 1)).getDescription();
  }

  public Map<String, Object> getExtensions() {
    CommerceErrorModelBuilder.Error error = (CommerceErrorModelBuilder.Error) this.errors.get(this.errors.size() - 1);
    Map<String, Object> extensions = new HashMap();
    extensions.put("httpCode", error.getCode());
    extensions.put("httpMessage", error.getDescription());
    extensions.put("moreInformation", error.getDescription());
    return extensions;
  }

  @Generated
  ErrorModel(final List<CommerceErrorModelBuilder.Error> errors) {
    this.errors = errors;
  }

  @Generated
  public static CommerceErrorModelBuilder builder() {
    return new CommerceErrorModelBuilder();
  }

  @Generated
  public List<CommerceErrorModelBuilder.Error> getErrors() {
    return this.errors;
  }

  @JsonPOJOBuilder(
    withPrefix = ""
  )
  public static class CommerceErrorModelBuilder implements ErrorModelBuilder<ErrorModel> {
    @Generated
    private ArrayList<Error> errors;

    public ErrorModel buildErrorModel(Map<String, Object> errorModelAttributes) {
      Error.GluonErrorBuilder var10000 = Error.builder().description((String) errorModelAttributes.get("shortMessage"));
      long var10001 = System.currentTimeMillis();
      Error.GluonErrorBuilder errorBuilder = var10000.message(var10001 + "-" + String.valueOf(errorModelAttributes.get("appName")) + "-" + String.valueOf(errorModelAttributes.get("errorName")) + "-" + String.valueOf(errorModelAttributes.get("detailedMessage"))).code(String.valueOf(errorModelAttributes.get("status")));
      return ErrorModel.builder().error(errorBuilder.build()).build();
    }

    @Generated
    CommerceErrorModelBuilder() {
    }

    @Generated
    public CommerceErrorModelBuilder error(final Error error) {
      if (this.errors == null) {
        this.errors = new ArrayList();
      }

      this.errors.add(error);
      return this;
    }

    @Generated
    public CommerceErrorModelBuilder errors(final Collection<? extends Error> errors) {
      if (errors == null) {
        throw new NullPointerException("errors cannot be null");
      } else {
        if (this.errors == null) {
          this.errors = new ArrayList();
        }

        this.errors.addAll(errors);
        return this;
      }
    }

    @Generated
    public CommerceErrorModelBuilder clearErrors() {
      if (this.errors != null) {
        this.errors.clear();
      }

      return this;
    }

    @Generated
    public ErrorModel build() {
      List<Error> errors;
      switch (this.errors == null ? 0 : this.errors.size()) {
        case 0 -> errors = Collections.emptyList();
        case 1 -> errors = Collections.singletonList((Error) this.errors.get(0));
        default -> errors = Collections.unmodifiableList(new ArrayList(this.errors));
      }

      return new ErrorModel(errors);
    }

    @Generated
    public String toString() {
      return "GluonErrorModel.CommerceErrorModelBuilder(errors=" + String.valueOf(this.errors) + ")";
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonDeserialize(
      builder = CommerceErrorModelBuilder.class
    )
    public static class Error {
      private String code;
      private String description;
      private static String ERROR_LEVEL = "error";
      private String level;
      private String message;

      @Generated
      private static String $default$level() {
        return ERROR_LEVEL;
      }

      @Generated
      Error(final String code, final String description, final String level, final String message) {
        this.code = code;
        this.description = description;
        this.level = level;
        this.message = message;
      }

      @Generated
      public static GluonErrorBuilder builder() {
        return new GluonErrorBuilder();
      }

      @Generated
      public String getCode() {
        return this.code;
      }

      @Generated
      public String getDescription() {
        return this.description;
      }

      @Generated
      public String getLevel() {
        return this.level;
      }

      @Generated
      public String getMessage() {
        return this.message;
      }

      @Generated
      public void setCode(final String code) {
        this.code = code;
      }

      @Generated
      public void setDescription(final String description) {
        this.description = description;
      }

      @Generated
      public void setLevel(final String level) {
        this.level = level;
      }

      @Generated
      public void setMessage(final String message) {
        this.message = message;
      }

      @JsonPOJOBuilder(
        withPrefix = ""
      )
      public static class GluonErrorBuilder {
        @Generated
        private String code;
        @Generated
        private String description;
        @Generated
        private boolean level$set;
        @Generated
        private String level$value;
        @Generated
        private String message;

        @Generated
        GluonErrorBuilder() {
        }

        @Generated
        public GluonErrorBuilder code(final String code) {
          this.code = code;
          return this;
        }

        @Generated
        public GluonErrorBuilder description(final String description) {
          this.description = description;
          return this;
        }

        @Generated
        public GluonErrorBuilder level(final String level) {
          this.level$value = level;
          this.level$set = true;
          return this;
        }

        @Generated
        public GluonErrorBuilder message(final String message) {
          this.message = message;
          return this;
        }

        @Generated
        public Error build() {
          String level$value = this.level$value;
          if (!this.level$set) {
            level$value = Error.$default$level();
          }

          return new Error(this.code, this.description, level$value, this.message);
        }

        @Generated
        public String toString() {
          return "GluonErrorModel.GluonErrorModelBuilder.GluonError.GluonErrorBuilder(code=" + this.code + ", description=" + this.description + ", level$value=" + this.level$value + ", message=" + this.message + ")";
        }
      }
    }
  }
}
