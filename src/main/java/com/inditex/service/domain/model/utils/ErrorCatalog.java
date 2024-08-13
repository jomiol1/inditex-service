package com.inditex.service.domain.model.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

	GENERIC_ERROR("00", "An unexpected error occurred."),
	PRICE_NOT_FOUND("01", "Price not found.");

  private final String code;
  private final String message;

  ErrorCatalog(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
