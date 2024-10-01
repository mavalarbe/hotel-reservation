package org.example.hotelreservation.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservation.facade.HotelReservationFacade;
import org.example.hotelreservation.model.Reservation;
import org.example.hotelreservation.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReservationControllerImpl extends GenericController implements ReservationController {

    private final HotelReservationFacade hotelReservationFacade;

    @Override
    public ResponseEntity<?> addRoom(String type, int number, double price) throws Exception {
        isValid(type);
        isValidNumber(number);
        isValidNumber(price);
        Room roomResponse = hotelReservationFacade.addRoom(type, number, price);
        if (isNull(roomResponse)) {
            return badRequest();
        }
        return ok(roomResponse);
    }

    @Override
    public ResponseEntity<?> getAllRooms() {
        List<Room> roomsResponse = hotelReservationFacade.getAllRooms();
        if (isEmpty(roomsResponse)) {
            return noContent();
        }
        return ok(roomsResponse);
    }

    @Override
    public ResponseEntity<?> getAvailableRooms(LocalDate checkIn,
                                               LocalDate checkOut) throws Exception {
        isValidRangeDate(checkIn, checkOut);
        List<Room> roomsResponse = hotelReservationFacade.findAvailableRooms(checkIn, checkOut);
        if (isEmpty(roomsResponse)) {
            return noContent();
        }
        return ok(roomsResponse);
    }

    @Override
    public ResponseEntity<?> createReservation(Reservation reservation) throws Exception {
        isValid(reservation);
        Reservation reservationResponse = hotelReservationFacade.createReservation(reservation);
        if (isNull(reservationResponse)) {
            return badRequest();
        }
        return ok(reservationResponse);
    }

    @Override
    public void cancelReservation(Long id) throws Exception {
        isValidNumber(id);
        hotelReservationFacade.cancelReservation(id);
    }

    @Override
    public ResponseEntity<?> getAllReservations() {
        List<Reservation> reservations = hotelReservationFacade.getAllReservations();
        if (isEmpty(reservations)) {
            return noContent();
        }
        return ok(reservations);
    }

    @Override
    public ResponseEntity<?> getReservationsByGuest(Long guestId) throws Exception {
        isValidNumber(guestId);
        List<Reservation> reservations = hotelReservationFacade.getReservationsByGuest(guestId);
        if (isEmpty(reservations)) {
            return noContent();
        }
        return ok(reservations);
    }

    @Override
    public ResponseEntity<?> getReservationsByDateRange(LocalDate start,
                                                        LocalDate end) throws Exception {
        isValidRangeDate(start, end);
        List<Reservation> reservations = hotelReservationFacade.getReservationsByDateRange(start, end);
        if (isEmpty(reservations)) {
            return noContent();
        }
        return ok(reservations);
    }
}
