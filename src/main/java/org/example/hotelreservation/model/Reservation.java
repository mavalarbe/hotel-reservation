package org.example.hotelreservation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Room room;
    private Long idRoom;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
