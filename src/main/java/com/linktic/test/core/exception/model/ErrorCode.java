package com.linktic.test.core.exception.model;

public interface ErrorCode {

  String EXCEPTION = "Exception";

  String name();

  default String message() {
    return String.format("%s.%s", EXCEPTION, this.name());
  }
}
