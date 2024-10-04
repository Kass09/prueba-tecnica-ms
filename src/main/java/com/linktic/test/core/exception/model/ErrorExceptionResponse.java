package com.linktic.test.core.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorExceptionResponse implements Serializable {

  private Integer status;
  private String message;
  private LocalDateTime date;
  private Map<String, List<String>> fieldsWithErrors;
}
