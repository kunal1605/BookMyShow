package org.example.bookmyshow.Service;

import org.example.bookmyshow.Repositary.ShowSeatTypeRepo;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
@Autowired
private ShowSeatTypeRepo showSeatTypeRepo;
    public Long calculatePrice(List<ShowSeat> showSeatList, Show show){
        //1.Find out the types of seat in the given show
       //2. type of seats in the given show
       //3.  calculate the amount

        List<ShowSeatType> showSeatTypes =  showSeatTypeRepo.findAllByShow(show);//Taking out all the types of showseat type of the particuler show
        int amount = 0;
        for(ShowSeat showSeat : showSeatList){
            for(ShowSeatType showSeatType : showSeatTypes){ //Matching showtypwe with selected show
                if(showSeat.getSeat().getSeatTypes().equals(showSeatType.getSeatType())){
                    amount+=showSeatType.getPrice();
                }
            }
        }
       return  Long.valueOf(amount);
    }
}
