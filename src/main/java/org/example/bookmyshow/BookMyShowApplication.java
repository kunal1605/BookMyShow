package org.example.bookmyshow;

import org.example.bookmyshow.Controllers.UserController;
import org.example.bookmyshow.dto.UserRequestDTO;
import org.example.bookmyshow.models.BaseModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
    UserController userController ;
    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setEmail("kunal@gmail.com");
        userRequestDTO.setPassword("123456");
        userController.signUp(userRequestDTO);
    }
}
