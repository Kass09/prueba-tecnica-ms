package com.linktic.test.core.exception.impl;

import com.linktic.test.core.exception.base.BaseException;
import com.linktic.test.core.exception.model.ErrorCode;
import org.springframework.http.HttpStatus;

public class GenericException extends BaseException {

  public GenericException(ErrorCode errorCode, HttpStatus status) {
    super(status, errorCode);
  }
}
