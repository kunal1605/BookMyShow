package org.example.bookmyshow.Controllers;

import org.example.bookmyshow.Service.BookingService;
import org.example.bookmyshow.dto.BookingRequestDTO;
import org.example.bookmyshow.dto.BookingResponseDTO;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.models.ResposeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired //find the object and
    // create if not already created and pass it over
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;

    }

    public BookingResponseDTO bookTickets(BookingRequestDTO bookingRequestDTO){
        BookingResponseDTO response = new BookingResponseDTO();

        try{

            Booking booking =bookingService.bookTicket(bookingRequestDTO.getUserID(),bookingRequestDTO.getShowSeatID(),bookingRequestDTO.getShowId());
            response.setResposeStatus(ResposeStatus.SUCCESS);
            response.setBookingID(booking.getId());
            response.setAmount(booking.getAmount());
        }
        catch(Exception ex){
            response.setResposeStatus(ResposeStatus.FAILURE);
        }

return  response;


    }
}
