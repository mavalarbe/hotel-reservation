package org.example.hotelreservation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SINGLE")
public class SingleRoom extends Room {
    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}
