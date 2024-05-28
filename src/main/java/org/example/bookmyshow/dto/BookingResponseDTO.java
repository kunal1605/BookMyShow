package org.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.bookmyshow.models.ResposeStatus;

@Getter
@Setter
public class BookingResponseDTO {

    private ResposeStatus resposeStatus;
    private Long BookingID;
    private Long amount;
}
