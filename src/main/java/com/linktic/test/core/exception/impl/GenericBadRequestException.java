package com.linktic.test.core.exception.impl;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.linktic.test.core.exception.base.BaseException;
import com.linktic.test.core.exception.model.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class GenericBadRequestException extends BaseException {

  public GenericBadRequestException(ErrorCode errorCode) {
    super(BAD_REQUEST, errorCode);
  }
}
