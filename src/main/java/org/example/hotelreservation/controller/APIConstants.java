package org.example.hotelreservation.controller;

public interface APIConstants {
    String API_RESERVATION = "/api/v1/reservation";
    String METHOD_ROOM = "/v1/rooms";
    String METHOD_ROOM_AVAILABLE = "/v1/rooms/available";
    String METHOD_RESERVATION = "/v1/reservations";
    String METHOD_RESERVATION_CANCEL = "/v1/reservations/{id}/cancel";
    String METHOD_RESERVATION_GUEST = "/v1/reservations/guest/{guestId}";
    String METHOD_RESERVATION_DATE = "/v1/reservations/date-range";
    String EXCEPTION_OBJECT = "El objeto enviado no debe estar vacio";
    String EXCEPTION_RANGE_DATE = "La fecha inicial debe ser menor a la fecha final";
    String EXCEPTION_VALID_NUMBER = "El valor enviado debe ser mayor a 0";
    String EXCEPTION_RESERVATION_NOT_FOUND = "La reservación no ha sido encontrada";
}
