package com.linktic.test.core.settlement.usercase.calculatesettlement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Schema(description = "Request object for insured settlement calculation")
public class InsuredRequest implements Serializable {

  @NotNull
  @NotEmpty
  @Schema(description = "number of identification the insured user", example = "12345")
  private String numbIdentification;

  @NotNull
  @NotEmpty
  @Schema(description = "type of identification the insured user", example = "CC")
  private String typeIdentification;

  @NotNull
  @Schema(description = "Amount to be settled", example = "1000")
  private BigDecimal insuredAmount;
}
