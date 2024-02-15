package com.learning.SpringRestTicketBookingApp.dao;

import com.learning.SpringRestTicketBookingApp.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}
