package org.example.hotelreservation.factory;

import org.example.hotelreservation.model.DoubleRoom;
import org.example.hotelreservation.model.Room;
import org.example.hotelreservation.model.SingleRoom;
import org.example.hotelreservation.model.SuiteRoom;

public class RoomFactory {
    public static Room createRoom(String type, int number, double price) {
        Room room = switch (type.toUpperCase()) {
            case "SINGLE" -> new SingleRoom();
            case "DOUBLE" -> new DoubleRoom();
            case "SUITE" -> new SuiteRoom();
            default -> throw new IllegalArgumentException("Invalid room type: " + type);
        };
        room.setNumber(number);
        room.setPrice(price);
        return room;
    }
}
