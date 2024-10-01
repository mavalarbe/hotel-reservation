package org.example.hotelreservation.facade;

import org.example.hotelreservation.model.Reservation;
import org.example.hotelreservation.model.Room;
import org.example.hotelreservation.observer.EmailNotifier;
import org.example.hotelreservation.observer.HotelStaffNotifier;
import org.example.hotelreservation.observer.InventoryManager;
import org.example.hotelreservation.service.GuestManager;
import org.example.hotelreservation.service.HotelManager;
import org.example.hotelreservation.service.PaymentProcessor;
import org.example.hotelreservation.service.ReservationManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelReservationFacade {
    private final HotelManager hotelManager;
    private final ReservationManager reservationManager;
    private final PaymentProcessor paymentProcessor;
    private final GuestManager guestManager;

    public HotelReservationFacade(HotelManager hotelManager, PaymentProcessor paymentProcessor, ReservationManager reservationManager, GuestManager guestManager) {
        this.hotelManager = hotelManager;
        this.paymentProcessor = paymentProcessor;
        this.reservationManager = reservationManager;
        this.guestManager = guestManager;

        // Registrar observadores
        reservationManager.addObserver(new InventoryManager());
        reservationManager.addObserver(new EmailNotifier());
        reservationManager.addObserver(new HotelStaffNotifier());
    }

    public Room addRoom(String type, int number, double price) {
        return hotelManager.addRoom(type, number, price);
    }

    public List<Room> getAllRooms() {
        return hotelManager.getAllRooms();
    }

    public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return hotelManager.findAvailableRooms(checkIn, checkOut);
    }

    public Reservation createReservation(Reservation reservation) throws Exception {
        if (paymentProcessor.processPayment(reservation)) {
            reservation.setRoom(hotelManager.find(reservation.getIdRoom()));
            reservation.setGuest(guestManager.save(reservation.getGuest()));
            return reservationManager.createReservation(reservation);
        } else {
            throw new RuntimeException("Payment processing failed");
        }
    }

    public void cancelReservation(Long reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public List<Reservation> getAllReservations() {
        return reservationManager.getAllReservations();
    }

    public List<Reservation> getReservationsByGuest(Long guestId) {
        return reservationManager.getReservationsByGuest(guestId);
    }

    public List<Reservation> getReservationsByDateRange(LocalDate start, LocalDate end) {
        return reservationManager.getReservationsByDateRange(start, end);
    }
}
