package org.example.bookmyshow.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Screen extends BaseModel {
@ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection //wec cannot store enum lsit in a row so we need a mapping tbale with screen
    //create a new mapping table like screen features
    private List<Feature> features;

    @OneToMany
    private  List<Seat> seats;
}
