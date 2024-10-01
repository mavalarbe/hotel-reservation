package org.example.hotelreservation.observer;

import org.example.hotelreservation.model.Reservation;

public class InventoryManager implements ReservationObserver {
    @Override
    public void update(Reservation reservation) {
        System.out.println("Updating room inventory for reservation: " + reservation.getId());
        // Lógica para actualizar el inventario
    }
}