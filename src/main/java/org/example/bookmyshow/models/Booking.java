package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class Booking extends BaseModel {

    @ManyToOne
    //one user can have multiple bookings
    private User user;
    // B:S
    //1:M

    // a booking can have multiple showseat 1:M

    //1 show seat can bea part of many bokking
    // as the booking can be cancelled also so M:1
    //multiple booking which can be cancelled and only one confirmed booking
    //So at the end cadinality will be M:M
    @ManyToMany
    private List<ShowSeat> showSeats;

    // 1 booking multiple paymenta but 1 payment 1 booking so
    @OneToMany
    private List<Payments> payment;
    @Enumerated(EnumType.ORDINAL)
    //for enum mapping we use enumerated ordinal means they will be order according to table
    private BookStatus bookStatus;

    //one show can be preasent in multiple bookings
    @ManyToOne
    private Show show;
    private Date bookedAt;
    private Long amount;
}
