package org.example.hotelreservation.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservation.factory.RoomFactory;
import org.example.hotelreservation.model.Room;
import org.example.hotelreservation.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelManager {

    private final RoomRepository roomRepository;

    public Room addRoom(String type, int number, double price) {
        Room room = RoomFactory.createRoom(type, number, price);
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findAvailableRooms(checkIn, checkOut);
    }
    public Room find(Long id) throws Exception {
        return roomRepository.findById(id).orElseThrow(Exception::new);
    }
}
