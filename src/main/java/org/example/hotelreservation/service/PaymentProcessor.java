package org.example.hotelreservation.service;

import org.example.hotelreservation.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor {
    public boolean processPayment(Reservation reservation) {
        // Simular procesamiento de pago
        return Math.random() < 0.9; // 90% de éxito
    }
}
