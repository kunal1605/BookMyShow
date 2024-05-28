package org.example.bookmyshow.Service;

import org.example.bookmyshow.Repositary.UserRepo;
import org.example.bookmyshow.dto.UserRequestDTO;
import org.example.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User login(UserRequestDTO userRequestDTO){

        Optional<User> user = userRepo.findById(userRequestDTO.getId());
        if (user.isEmpty()){
            throw  new RuntimeException("user does not exists");
        }
        else{
            //Validate password
            return  new User();
        }




    }
    public User signUp(UserRequestDTO userRequestDTO){

        Optional<User> user = userRepo.findbyEmail(userRequestDTO.Email);
        if (user.isEmpty()){
            User user1 =  new User();
            user1.setPassword("123456");
            user1.setName("Kunal");
            user1.setEmail("kunal@gmail.com");
            user1.setBookingList(new ArrayList<>());
             return userRepo.save(user1);
        }
        else {
            throw  new RuntimeException("User already exits");

        }
    }


}
