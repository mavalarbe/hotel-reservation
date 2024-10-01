package org.example.hotelreservation.controller;

import org.example.hotelreservation.util.ObjectValidator;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.example.hotelreservation.controller.APIConstants.*;

public abstract class GenericController {
    protected ResponseEntity<?> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<?> noContent() {
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<?> ok(Object obj) {
        return ResponseEntity.ok(obj);
    }

    protected ResponseEntity<?> internalServerError() {
        return ResponseEntity.internalServerError().body(null);
    }

    protected Boolean isEmpty(List<?> list) {
        return ObjectValidator.isEmpty(list);
    }

    protected Boolean isNull(Object obj) {
        return ObjectValidator.isNull(obj);
    }

    protected void isValid(Object obj) throws Exception {
        if (isNull(obj)) {
            throw new Exception(EXCEPTION_OBJECT);
        }
    }

    protected void isValidNumber(Object num) throws Exception {
        if (isNull(num)) {
            throw new Exception(EXCEPTION_VALID_NUMBER);
        }
        if (num instanceof Long && (Long) num <= 0) {
            throw new Exception(EXCEPTION_VALID_NUMBER);
        }
        if (num instanceof Integer && (Integer) num <= 0) {
            throw new Exception(EXCEPTION_VALID_NUMBER);
        }
        if (num instanceof Double && (Double) num <= 0) {
            throw new Exception(EXCEPTION_VALID_NUMBER);
        }
    }

    protected void isValidRangeDate(LocalDate checkIn, LocalDate checkOut) throws Exception {
        isValid(checkIn);
        isValid(checkOut);
        if (checkIn.isAfter(checkOut)) {
            throw new Exception(EXCEPTION_RANGE_DATE);
        }
    }
}
