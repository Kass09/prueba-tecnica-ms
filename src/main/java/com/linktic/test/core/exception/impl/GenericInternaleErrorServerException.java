package com.linktic.test.core.exception.impl;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.linktic.test.core.exception.base.BaseException;
import com.linktic.test.core.exception.model.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(INTERNAL_SERVER_ERROR)
public class GenericInternaleErrorServerException extends BaseException {

  public GenericInternaleErrorServerException(ErrorCode errorCode) {
    super(INTERNAL_SERVER_ERROR, errorCode);
  }
}
