package com.linktic.test.core.exception.base;

import com.linktic.test.core.exception.model.ErrorCode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {

  private final HttpStatus status;
  private final String outputParam;
  private final LocalDateTime date;
  private final ErrorCode exceptionCode;

  protected BaseException(HttpStatus status, String outputParam, ErrorCode errorCode) {
    this.outputParam = outputParam;
    this.status = status;
    this.exceptionCode = errorCode;
    this.date = LocalDateTime.now(ZoneId.systemDefault());

  }

  protected BaseException(HttpStatus status, ErrorCode errorCode) {
    this.outputParam = null;
    this.status = status;
    this.exceptionCode = errorCode;
    this.date = LocalDateTime.now(ZoneId.systemDefault());

  }
}
