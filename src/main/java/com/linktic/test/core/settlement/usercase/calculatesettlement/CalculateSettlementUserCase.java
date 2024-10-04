package com.linktic.test.core.settlement.usercase.calculatesettlement;

import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.INSURED_NOT_FOUND;
import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.REQUESTS_IS_EMPTY;

import com.linktic.test.core.exception.impl.GenericInternaleErrorServerException;
import com.linktic.test.core.exception.impl.GenericNotFoundException;
import com.linktic.test.core.settlement.usercase.calculatesettlement.builder.CalculateSettlementBuilder;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredRequest;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredResponse;
import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.InsuredEntity;
import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.PrimaEntity;
import com.linktic.test.core.settlement.usercase.calculatesettlement.repository.InsuredRepository;
import com.linktic.test.core.settlement.usercase.calculatesettlement.repository.PrimaRepository;
import com.linktic.test.core.settlement.usercase.calculatesettlement.validation.CalculateSettlementValidation;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalculateSettlementUserCase {

  private final CalculateSettlementValidation calculateSettlementValidation;
  private final PrimaRepository primaRepository;
  private final InsuredRepository insuredRepository;
  private final CalculateSettlementBuilder calculateSettlementBuilder;

  public List<InsuredResponse> calculate(List<InsuredRequest> insuredRequests) {
    if (insuredRequests.isEmpty()) {
      throw new GenericInternaleErrorServerException(REQUESTS_IS_EMPTY);
    }
    return insuredRequests.stream().map(request -> {
      calculateSettlementValidation.validate(request);
      InsuredEntity insuredEntity = findByTypeIdentificationAndNumbIdentification(request);
      return processSettlement(insuredEntity, request);
    }).toList();

  }

  private InsuredEntity findByTypeIdentificationAndNumbIdentification(
      InsuredRequest request) {
    return insuredRepository.findByTypeIdentificationAndNumbIdentification(
            request.getTypeIdentification(), request.getNumbIdentification())
        .orElseThrow(() -> new GenericNotFoundException(INSURED_NOT_FOUND));
  }

  private InsuredResponse processSettlement(InsuredEntity insuredEntity,
      InsuredRequest insuredRequest) {
    final int age = Period.between(insuredEntity.getBirthdate().toLocalDate(), LocalDate.now())
        .getYears();
    List<PrimaEntity> primaEntities = primaRepository.findByAgeRange(age);
    return primaEntities.isEmpty() ? calculateSettlementBuilder.buildInsuredResponse(insuredEntity,
        insuredRequest.getInsuredAmount(), new ArrayList<>()) :
        calculateSettlementBuilder.buildInsuredResponse(insuredEntity,
            insuredRequest.getInsuredAmount(),
            calculateSettlementBuilder.buildSettlement(primaEntities,
                insuredRequest.getInsuredAmount()));
  }
}

