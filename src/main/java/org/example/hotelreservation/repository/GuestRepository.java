package org.example.hotelreservation.repository;

import org.example.hotelreservation.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
