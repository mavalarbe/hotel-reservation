package org.example.hotelreservation.observer;

import org.example.hotelreservation.model.Reservation;

public class HotelStaffNotifier implements ReservationObserver {
    @Override
    public void update(Reservation reservation) {
        System.out.println("Notifying hotel staff about new reservation: " + reservation.getId());
        // Lógica para notificar al personal
    }
}