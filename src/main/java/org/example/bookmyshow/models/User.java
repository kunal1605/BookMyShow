package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

//Entity is from JPA
@Entity(name = "users")
public class User extends BaseModel {
private String name;
    private  String password;
    private   String email;
    @OneToMany
    private List<Booking> bookingList;
}
