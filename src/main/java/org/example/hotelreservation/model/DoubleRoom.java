package org.example.hotelreservation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleRoom extends Room {
    @Override
    public String getRoomType() {
        return "DOUBLE";
    }
}
