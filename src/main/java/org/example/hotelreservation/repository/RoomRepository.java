package org.example.hotelreservation.repository;

import org.example.hotelreservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
            "(SELECT res.room.id FROM Reservation res " +
            "WHERE (res.checkInDate <= :checkOutDate AND res.checkOutDate >= :checkInDate))")
    List<Room> findAvailableRooms(@Param("checkInDate") LocalDate checkInDate,
                                  @Param("checkOutDate") LocalDate checkOutDate);
}
