package com.linktic.test.core.settlement.usercase.calculatesettlement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response object for the insured settlement")
public class InsuredResponse {

  @Schema(description = "number of identification the insured user", example = "12345")
  private String numbIdentification;

  @Schema(description = "type of identification the insured user", example = "CC")
  private String typeIdentification;

  @Schema(description = "Amount to be settled", example = "1000")
  private BigDecimal insuredAmount;

  @Schema(description = "Calculated settlement total", example = "1200")
  private BigDecimal total;

  @Schema(description = "List of primas result in settlements", example = "1200")
  private List<SettlementDto> settlements;
}
