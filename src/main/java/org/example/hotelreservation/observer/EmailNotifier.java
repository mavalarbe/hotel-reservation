package org.example.hotelreservation.observer;

import org.example.hotelreservation.model.Reservation;

public class EmailNotifier implements ReservationObserver {
    @Override
    public void update(Reservation reservation) {
        System.out.println("Sending confirmation email for reservation: " + reservation.getId());
        // Lógica para enviar correo electrónico
    }
}
