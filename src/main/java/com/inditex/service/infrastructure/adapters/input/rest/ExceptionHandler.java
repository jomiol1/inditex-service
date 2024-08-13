package com.inditex.service.infrastructure.adapters.input.rest;


import static com.inditex.service.domain.model.utils.ErrorCatalog.GENERIC_ERROR;
import static com.inditex.service.domain.model.utils.ErrorCatalog.PRICE_NOT_FOUND;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inditex.service.domain.model.ErrorResponse;
import com.inditex.service.domain.model.exception.PriceNotFound;

@RestControllerAdvice
public class ExceptionHandler {
	
	  @ResponseStatus(
	           value = HttpStatus.NOT_FOUND)
	  @org.springframework.web.bind.annotation.ExceptionHandler(value = {PriceNotFound.class })
	  public ErrorResponse handleStudentNotFoundException() {
	    return ErrorResponse.builder()
	        .code(PRICE_NOT_FOUND.getCode())
	        .message(PRICE_NOT_FOUND.getMessage())
	        .timestamp(LocalDateTime.now())
	        .build();
	  }
	  
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	  public ErrorResponse handleGenericError(Exception exception) {
	    return ErrorResponse.builder()
	        .code(GENERIC_ERROR.getCode())
	        .message(GENERIC_ERROR.getMessage())
	        .details(Collections.singletonList(exception.getMessage()))
	        .timestamp(LocalDateTime.now())
	        .build();
	  }

}
