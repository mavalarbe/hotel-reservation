package org.example.hotelreservation.observer;

import org.example.hotelreservation.model.Reservation;

public interface ReservationSubject {
    void addObserver(ReservationObserver observer);
    void removeObserver(ReservationObserver observer);
    void notifyObservers(Reservation reservation);
}