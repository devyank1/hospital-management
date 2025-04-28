package com.hospital.api_medical.exception;

public class MedicNotFoundException extends RuntimeException {
  public MedicNotFoundException(String message) {
    super(message);
  }
}
