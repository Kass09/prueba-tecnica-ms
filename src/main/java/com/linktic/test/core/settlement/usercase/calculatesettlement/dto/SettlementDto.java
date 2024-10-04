package com.linktic.test.core.settlement.usercase.calculatesettlement.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SettlementDto implements Serializable {

  private long amparoCode;
  private String amparoName;
  private BigDecimal primaAmount;
}
