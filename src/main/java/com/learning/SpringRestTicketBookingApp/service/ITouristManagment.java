package com.learning.SpringRestTicketBookingApp.service;

import com.learning.SpringRestTicketBookingApp.model.Tourist;

import java.util.List;

public interface ITouristManagment {

    public String registerTourist(Tourist tourist);
    public List<Tourist> getAllTourists();
    public Tourist fetchTouristById(Integer id);
    public String updateTheTouristAllDetails(Tourist tourist);
    public String updateTouristById(Integer id,Double budgetHike);
    public String deleteTouristById(Integer id);
}

