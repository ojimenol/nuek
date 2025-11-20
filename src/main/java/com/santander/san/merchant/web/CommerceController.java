package com.santander.san.merchant.web;

import com.santander.san.merchant.exception.InternalServerErrorException;
import com.santander.san.merchant.integration.commerce.model.CommerceResponse;
import com.santander.san.merchant.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Commerce", description = "ComercioController")
public interface CommerceController {


  @Operation(
    summary = "Retrieves a list of accounts.",
    description = "The accounts included in the response can be filtered by operation participant and status."
  )
  @ApiResponses(value = {
    //Successful response
    @ApiResponse(
      responseCode = "200",
      description = "successful operation",
      content = @Content(
        schema = @Schema(implementation = CommerceResponse.class))),
    //Bad request response
    @ApiResponse(
      responseCode = "400",
      description = "Bad Request",
      content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //Unauthorized response
    @ApiResponse(
      responseCode = "401",
      description = "Unauthorized",
      content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //Forbidden response
    @ApiResponse(
      responseCode = "403",
      description = "Forbidden",
      content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //Not Found response
    @ApiResponse(
      responseCode = "404",
      description = "Not Found",
      content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //Internal server response
    @ApiResponse(
      responseCode = "500",
      description = "Internal server error",
      content = @Content(schema = @Schema(implementation = InternalServerErrorException.class))),
    //Service unavailable response
    @ApiResponse(
      responseCode = "503",
      description = "Service unavailable",
      content = @Content(schema = @Schema(implementation = InternalServerErrorException.class))),
    //Gateway timeout response
    @ApiResponse(
      responseCode = "504",
      description = "Gateway timeout",
      content = @Content(schema = @Schema(implementation = InternalServerErrorException.class)))
  })
  public ResponseEntity<CommerceResponse> getCommerces(
    @RequestHeader("Authorization") String authorization, @RequestParam String personCode,
    @RequestParam String personType, @RequestParam String billingDateFrom, @RequestParam String billingDateTo,
    @RequestParam String order, @RequestParam String listDateFrom,  @RequestParam String listDateTo) ;
}