package com.linktic.test.core.settlement.usercase.calculatesettlement.validation.error;

import com.linktic.test.core.exception.model.ErrorCode;
import lombok.Getter;

@Getter
public enum InsuredExceptionCode implements ErrorCode {
  REQUEST_FIELDS_ERROR,
  VALIDATE_INSURED_AMOUNT_LESS_OR_EQUAL_THAN_ZERO,
  VALIDATE_INSURED_AMOUNT_IS_NULL,
  VALIDATE_INSURED_REQUEST_IS_NULL,
  VALIDATE_INSURED_NUMB_IDENTIFICATION_INVALID,
  VALIDATE_INSURED_TYPE_IDENTIFICATION_INVALID,
  INSURED_NOT_FOUND,
  REQUESTS_IS_EMPTY

}
