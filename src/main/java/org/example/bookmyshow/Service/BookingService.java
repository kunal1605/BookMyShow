package org.example.bookmyshow.Service;



import org.example.bookmyshow.Repositary.BookingRepo;
import org.example.bookmyshow.Repositary.ShowRepo;
import org.example.bookmyshow.Repositary.ShowSeatRepo;
import org.example.bookmyshow.Repositary.UserRepo;
import org.example.bookmyshow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class BookingService {

//For now we are keeping a transcation on the whole func
//This will start when we call our func
//This is on DB level not code
//@Autowired
private UserRepo userRepo;
//@Autowired
private ShowRepo showRepo;
////@Autowired
        private ShowSeatRepo showSeatRepo;
//@Autowired
        private BookingRepo bookingRepo;
//@Autowired
private PriceCalculator priceCalculator;
@Autowired
    public BookingService(UserRepo userRepo, ShowRepo showRepo, ShowSeatRepo showSeatRepo, BookingRepo bookingRepo, PriceCalculator priceCalculator) {
        this.userRepo = userRepo;
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
        this.bookingRepo = bookingRepo;
        this.priceCalculator = priceCalculator;
    }

    Long userId;
    List<Long> showSeatIds;
    Long showID;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, List<Long> showSeatIds, Long showID) {


        // Get User by userID     getUserByID(Long userID)
        User existingUser =getUserByID(userId);
        // Get the show with showID
        Show bookedShow = getShowByID(showID);

        // ----Take lock----------Start Transcation here
        //Get the showseat using showSeatid
        //check if all seats are available
        // if no, throw error
        //if yes, mark akk the seats as blocked
        //save it in database
       checkAllSeatsAvailable();

        //-----------release the lock : end the trensaction
        // Create the corresponding booking obj
        // save the booking details in database
        // retun the booking obj

        Booking booking =  new Booking();
        booking.setBookStatus(BookStatus.PENDING);
        booking.setShowSeats(savedShowSheats);
        booking.setUser(existingUser);
        booking.setBookedAt(new Date());
        booking.setAmount(priceCalculator.calculatePrice(savedShowSheats,bookedShow));
        booking.setPayment(new ArrayList<>());

        booking =bookingRepo.save(booking);

        return booking;
    }

    private User getUserByID(Long userID){
//
//        Optional<User> user=  userRepo.findById(userID);
//
//        if(user.isEmpty()){
//            throw  new RuntimeException("No Such user exits");
//        }
//        return user.get();
        return  null;

    }
    private Show getShowByID(Long showId){

        Optional<Show> show=  showRepo.findById(showId);

        if(show.isEmpty()){
            throw  new RuntimeException("No Show user exits");
        }
        return show.get();

    }
    private List<ShowSeat> getShowSeatByID(){

        List<ShowSeat> showSeat=  showSeatRepo.findAllById(showSeatIds);


//        if(showSeat.isEmpty()){
//            throw  new RuntimeException("No Such user exits");
        //}
       return showSeat;

    }
List<ShowSeat > savedShowSheats =  new ArrayList<>();
    private void checkAllSeatsAvailable(){
        List<ShowSeat> showSeats = getShowSeatByID();
        for(ShowSeat showSeat : showSeats){
            if(!(showSeat.getShowSeatStatus() == ShowSeatStatus.AVAILABLE) || (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) && Duration.between(showSeat.getBlockedAt().toInstant(),new Date().toInstant()).toMinutes()<15)){
                throw new RuntimeException("Selected seats are not available");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeat.setBlockedAt(new Date());

        savedShowSheats.add(showSeatRepo.save(showSeat));
        }

    }
}
