package com.santander.san.merchant.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Standard error response format")
public class ErrorResponse {

  @Schema(description = "Error code or type", example = "UNAUTHORIZED")
  private String error;

  @Schema(description = "Detailed error message", example = "Access is denied")
  private String message;

  @Schema(description = "API endpoint where the error occurred", example = "/api/user/2")
  private String path;

  @Schema(description = "Timestamp of the error (ISO 8601)", example = "2025-11-20T13:15:30.123Z")
  private String timestamp;

  public ErrorResponse() {
  }

  public ErrorResponse(String error, String message, String path, String timestamp) {
    this.error = error;
    this.message = message;
    this.path = path;
    this.timestamp = timestamp;
  }

  // Getters and Setters
  public String getError() { return error; }
  public void setError(String error) { this.error = error; }

  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }

  public String getPath() { return path; }
  public void setPath(String path) { this.path = path; }

  public String getTimestamp() { return timestamp; }
  public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}