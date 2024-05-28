package org.example.bookmyshow.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDTO {
    private Long userID;
    private List<Long> showSeatID;
    private Long showId;
}
