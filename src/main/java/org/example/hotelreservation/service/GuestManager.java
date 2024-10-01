package org.example.hotelreservation.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelreservation.model.Guest;
import org.example.hotelreservation.repository.GuestRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuestManager {
    private final GuestRepository guestRepository;
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }
}
