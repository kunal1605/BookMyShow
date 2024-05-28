package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//This class is used to give price om the basis of shoe and seatype
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatTypes seatType;
    private  int price;
}
