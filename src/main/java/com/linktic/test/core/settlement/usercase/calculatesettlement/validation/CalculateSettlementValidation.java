package com.linktic.test.core.settlement.usercase.calculatesettlement.validation;

import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.VALIDATE_INSURED_AMOUNT_IS_NULL;
import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.VALIDATE_INSURED_AMOUNT_LESS_OR_EQUAL_THAN_ZERO;
import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.VALIDATE_INSURED_NUMB_IDENTIFICATION_INVALID;
import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.VALIDATE_INSURED_REQUEST_IS_NULL;
import static com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error.InsuredExceptionCode.VALIDATE_INSURED_TYPE_IDENTIFICATION_INVALID;
import static java.util.Objects.isNull;

import com.linktic.test.core.exception.impl.GenericInternaleErrorServerException;
import com.linktic.test.core.settlement.usercase.calculatesettlement.dto.InsuredRequest;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class CalculateSettlementValidation {

  private static final int NUMB_ZERO = 0;

  public void validate(InsuredRequest request) {
    validaInsureRequest(request);
    validateInsuredData(request);
    validateInsuredAmount(request);
  }

  private void validaInsureRequest(InsuredRequest insuredRequest) {
    if (isNull(insuredRequest)) {
      throw new GenericInternaleErrorServerException(VALIDATE_INSURED_REQUEST_IS_NULL);
    }
  }

  private void validateInsuredData(InsuredRequest insuredRequest) {
    if (isNull(insuredRequest.getNumbIdentification()) || insuredRequest.getNumbIdentification()
        .isEmpty()) {
      throw new GenericInternaleErrorServerException(VALIDATE_INSURED_NUMB_IDENTIFICATION_INVALID);
    }

    if (isNull(insuredRequest.getTypeIdentification()) || insuredRequest.getTypeIdentification()
        .isEmpty()) {
      throw new GenericInternaleErrorServerException(VALIDATE_INSURED_TYPE_IDENTIFICATION_INVALID);
    }
  }

  private void validateInsuredAmount(InsuredRequest insuredRequest) {
    if (isNull(insuredRequest.getInsuredAmount())) {
      throw new GenericInternaleErrorServerException(
          VALIDATE_INSURED_AMOUNT_IS_NULL);
    }

    if (BigDecimal.ZERO.compareTo(insuredRequest.getInsuredAmount()) >= NUMB_ZERO) {
      throw new GenericInternaleErrorServerException(
          VALIDATE_INSURED_AMOUNT_LESS_OR_EQUAL_THAN_ZERO);
    }
  }
}
