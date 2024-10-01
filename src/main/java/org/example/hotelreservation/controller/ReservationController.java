package org.example.hotelreservation.controller;

import org.example.hotelreservation.model.Reservation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.example.hotelreservation.controller.APIConstants.*;

@RequestMapping(API_RESERVATION)
public interface ReservationController {
    @PostMapping(METHOD_ROOM)
    ResponseEntity<?> addRoom(@RequestParam String type, @RequestParam int number, @RequestParam double price) throws Exception;

    @GetMapping(METHOD_ROOM)
    ResponseEntity<?> getAllRooms();

    @GetMapping(METHOD_ROOM_AVAILABLE)
    ResponseEntity<?> getAvailableRooms(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) throws Exception;

    @PostMapping(METHOD_RESERVATION)
    ResponseEntity<?> createReservation(@RequestBody Reservation reservation) throws Exception;

    @PostMapping(METHOD_RESERVATION_CANCEL)
    void cancelReservation(@PathVariable Long id) throws Exception;

    @GetMapping(METHOD_RESERVATION)
    ResponseEntity<?> getAllReservations();

    @GetMapping(METHOD_RESERVATION_GUEST)
    ResponseEntity<?> getReservationsByGuest(@PathVariable Long guestId) throws Exception;

    @GetMapping(METHOD_RESERVATION_DATE)
    ResponseEntity<?> getReservationsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) throws Exception;
}
