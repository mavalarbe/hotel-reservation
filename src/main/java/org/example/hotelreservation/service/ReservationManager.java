package org.example.hotelreservation.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservation.model.Reservation;
import org.example.hotelreservation.model.ReservationStatus;
import org.example.hotelreservation.observer.ReservationObserver;
import org.example.hotelreservation.observer.ReservationSubject;
import org.example.hotelreservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.hotelreservation.controller.APIConstants.EXCEPTION_RESERVATION_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ReservationManager implements ReservationSubject {

    private final ReservationRepository reservationRepository;
    private final List<ReservationObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(ReservationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ReservationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Reservation reservation) {
        for (ReservationObserver observer : observers) {
            observer.update(reservation);
        }
    }

    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus(ReservationStatus.CONFIRMED);
        Reservation createdReservation = reservationRepository.save(reservation);
        notifyObservers(createdReservation);
        return createdReservation;
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_RESERVATION_NOT_FOUND));
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByGuest(Long guestId) {
        return reservationRepository.findByGuestId(guestId);
    }

    public List<Reservation> getReservationsByDateRange(LocalDate start, LocalDate end) {
        return reservationRepository.findByCheckInDateBetween(start, end);
    }
}
