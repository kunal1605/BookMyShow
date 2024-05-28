package org.example.bookmyshow.Repositary;

import org.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {

Optional<User> findbyEmail(String email);


}

//JPA is interface
//Hibernet is the implementation of this interface
