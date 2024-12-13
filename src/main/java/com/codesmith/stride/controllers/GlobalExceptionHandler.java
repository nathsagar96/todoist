package com.codesmith.stride.controllers;

import com.codesmith.stride.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(exception = IllegalArgumentException.class)
  public ErrorResponse handleException(IllegalArgumentException exception, WebRequest request) {
    return new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getDescription(false));
  }
}
