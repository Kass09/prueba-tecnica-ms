package com.linktic.test.core.settlement.usercase.calculatesettlement.rest;

import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredRequest;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CalculateSettlementController {

  @Operation(summary = "Calculate the settlement for insureds",
      description = "This endpoint calculates the settlement for a list of insured users.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Settlement calculated successfully",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = InsuredResponse.class))),
      @ApiResponse(responseCode = "400", description = "Invalid request data",
          content = @Content(mediaType = "application/json")),
      @ApiResponse(responseCode = "500", description = "Internal server error",
          content = @Content(mediaType = "application/json"))
  })
  ResponseEntity<List<InsuredResponse>> calculateSettlement(
      @RequestBody List<InsuredRequest> request);
}
