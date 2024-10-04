package com.linktic.test.core.settlement.usercase.calculatesettlement.rest;

import com.linktic.test.core.settlement.usercase.calculatesettlement.CalculateSettlementUserCase;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredRequest;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insured")
@RequiredArgsConstructor
public class CalculateSettlementControllerImpl implements CalculateSettlementController {

  private final CalculateSettlementUserCase calculateSettlementUserCase;

  @Override
  @PostMapping("/calculate-settlement")
  public ResponseEntity<List<InsuredResponse>> calculateSettlement(List<InsuredRequest> request) {
    return ResponseEntity.ok(calculateSettlementUserCase.calculate(request));
  }
}
