package org.example.bookmyshow.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.models.UserResponseStatus;

@Getter
@Setter
public class UserResponseDTO {
    public Long userID;
    public String password;
    public  String email;
    public UserResponseStatus userResponseStatus;
}
