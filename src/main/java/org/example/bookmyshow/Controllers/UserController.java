package org.example.bookmyshow.Controllers;

import org.example.bookmyshow.Service.UserService;
import org.example.bookmyshow.dto.UserRequestDTO;
import org.example.bookmyshow.dto.UserResponseDTO;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.models.UserResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public UserResponseDTO login(UserRequestDTO userRequestDTO){
        User user =userService.login(userRequestDTO);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setUserID(user.getId());
        return  userResponseDTO;

    }

    public UserResponseDTO signUp(UserRequestDTO userRequestDTO){
        User user = new User();
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try {
            user = userService.signUp(userRequestDTO);

            userResponseDTO.setPassword(user.getPassword());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setUserID(user.getId());
            userResponseDTO.setUserResponseStatus(UserResponseStatus.COMPLETED);
        }
        catch(Exception ex){
            userResponseDTO.setUserResponseStatus(UserResponseStatus.FAILED);
        }

        return  userResponseDTO;

    }
}
