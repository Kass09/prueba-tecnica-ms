package com.linktic.test.core.settlement.usercase.calculatesettlement.builder;

import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredResponse;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.SettlementDto;
import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.InsuredEntity;
import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.PrimaEntity;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CalculateSettlementBuilder {

  public InsuredResponse buildInsuredResponse(InsuredEntity insuredEntity,
      BigDecimal insuredAmount, List<SettlementDto> primaEntities) {
    return InsuredResponse.builder()
        .insuredAmount(insuredAmount)
        .numbIdentification(insuredEntity.getNumbIdentification())
        .typeIdentification(insuredEntity.getTypeIdentification().getCode())
        .total(totalSettlement(primaEntities))
        .settlements(primaEntities)
        .build();
  }

  public List<SettlementDto> buildSettlement(List<PrimaEntity> primaEntities,
      BigDecimal insuredAmount) {
    return primaEntities.stream().map(prima -> SettlementDto.builder()
        .amparoName(prima.getAmparo().getName())
        .amparoCode(prima.getAmparo().getId())
        .primaAmount(prima.getPrimaPercent().multiply(insuredAmount))
        .build()).toList();
  }

  public BigDecimal totalSettlement(List<SettlementDto> settlements) {
    return settlements.isEmpty() ? BigDecimal.ZERO
        : settlements.stream().map(SettlementDto::getPrimaAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
