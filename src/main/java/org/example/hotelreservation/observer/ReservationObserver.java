package org.example.hotelreservation.observer;

import org.example.hotelreservation.model.Reservation;

public interface ReservationObserver {
    void update(Reservation reservation);
}
