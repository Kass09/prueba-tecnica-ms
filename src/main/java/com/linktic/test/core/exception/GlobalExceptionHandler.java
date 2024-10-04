package com.linktic.test.core.exception;


import com.linktic.test.core.exception.base.BaseException;
import com.linktic.test.core.exception.model.ErrorExceptionResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  private final MessageSource messageSource;

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorExceptionResponse> errorHandler(BaseException ex) {
    return new ResponseEntity<>(buildExceptionResponse(ex),
        HttpStatus.valueOf(ex.getStatus().value()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorExceptionResponse> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    Map<String, List<String>> errorsFields = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(error -> {
          String field = ((FieldError) error).getField();
          String message = Objects.requireNonNull(error.getDefaultMessage());
          errorsFields.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
        });

    final String requestFieldsErrorMessage = "Exception.REQUEST_FIELDS_ERROR";
    return ResponseEntity.badRequest().body(ErrorExceptionResponse.builder()
        .fieldsWithErrors(errorsFields)
        .message(messageSource.getMessage(requestFieldsErrorMessage, null,
            LocaleContextHolder.getLocale()))
        .date(LocalDateTime.now())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build());
  }

  private ErrorExceptionResponse buildExceptionResponse(BaseException baseException) {
    return ErrorExceptionResponse.builder()
        .status(baseException.getStatus().value())
        .message(
            messageSource.getMessage(
                baseException.getExceptionCode().message(),
                new Object[]{baseException.getOutputParam()},
                LocaleContextHolder.getLocale()))
        .date(baseException.getDate())
        .build();
  }
}
