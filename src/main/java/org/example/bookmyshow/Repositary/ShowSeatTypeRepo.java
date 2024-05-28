package org.example.bookmyshow.Repositary;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeatStatus;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType,Long> {
List<ShowSeatType> findAllByShow(Show show);
}
