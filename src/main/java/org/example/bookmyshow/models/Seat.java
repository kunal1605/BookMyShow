package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Seat extends BaseModel {

    @ManyToOne
    private SeatTypes seatTypes;
    private String seatNumber;

    //These row and col value store thre coordinated of the seats,
    // as we see in BMS wevery theatore has diff seart arrangment so for each seat we store coordinate X,Y  topleft and bottom right

    //we will not put status here as status is not an attrribute of seat it is an attribute of show and seat, as one seat may belong to multiple show
    private int rowVal;
    private int colValue;
}
