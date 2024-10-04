package com.linktic.test.core.exception.impl;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.linktic.test.core.exception.base.BaseException;
import com.linktic.test.core.exception.model.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class GenericNotFoundException extends BaseException {

  public GenericNotFoundException(ErrorCode errorCode) {
    super(NOT_FOUND, errorCode);
  }
}
